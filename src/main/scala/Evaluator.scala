package coop.rchain.rhocomb.repl

import org.bitbucket.inkytonik.kiama.attribution.Attribution

/**
 * Use attribution to evaluate an expression.
 */
object Evaluator extends Attribution {

  val value : RCRhoCombExp => Int =
    attr {
      case Num (i)    => i
      case Add (l, r) => value (l) + value (r)
      case Mul (l, r) => value (l) * value (r)
      case _          => -1
    }

  val txPiToRho : RCPProcExp => RCRhoCombExp = {
    ( rcpproc : RCPProcExp ) => {
      txPiToY( rcpproc ) match {
        case rcyproc : RCYProcExp =>
          txYToRho( rcyproc )
        case unknown => throw new Exception( s"unexpected translation: ${unknown}" )
      }
    }
  }

  val txYToRho : RCYProcExp => RCRhoCombExp = {
    ( rcpproc : RCYProcExp ) => {
      RCRZeroExp
    }
  }

  def subst( trgt : RCUNameExp, src : RCUNameExp, p : RCYProcExp ) : RCYProcExp = {
    p match {
      case RCYZeroExp             => RCYZeroExp
      case m@RCYMsgExp( a, b )    => {
        ( a == src, b == src ) match {
          case ( false, false ) => m
          case ( true, false )  => RCYMsgExp( trgt, b )
          case ( false, true )  => RCYMsgExp( a, trgt )
          case ( true, true )   => RCYMsgExp( trgt, trgt )
        }
      }
      case d@RCYDupExp( a, b, c ) => {
        ( a == src, b == src, c == src ) match {
          case ( false, false, false ) => d
          case ( true,  false, false ) => RCYDupExp( trgt, b, c )
          case ( true,  false, true )  => RCYDupExp( trgt, b, trgt )
          case ( true,  true,  false ) => RCYDupExp( trgt, trgt, c )
          case ( false, false, true )  => RCYDupExp( a, b, trgt )
          case ( false, true,  false ) => RCYDupExp( a, trgt, c )
          case ( false, true,  true )  => RCYDupExp( a, trgt, trgt )
          case ( true,  true,  true )  => RCYDupExp( trgt, trgt, trgt )
        }
      }
      case k@RCYKillExp( a )      => {
        if ( a == src ) {
          RCYKillExp( trgt )
        }
        else { k }
      }
      case fw@RCYFwdExp( a, b )   => {
        ( a == src, b == src ) match {
          case ( false, false ) => fw
          case ( true, false )  => RCYFwdExp( trgt, b )
          case ( false, true )  => RCYFwdExp( a, trgt )
          case ( true, true )   => RCYFwdExp( trgt, trgt )
        }
      }
      case bl@RCYBrlExp( a, b )   => {
        ( a == src, b == src ) match {
          case ( false, false ) => bl
          case ( true, false )  => RCYBrlExp( trgt, b )
          case ( false, true )  => RCYBrlExp( a, trgt )
          case ( true, true )   => RCYBrlExp( trgt, trgt )
        }
      }
      case br@RCYBrrExp( a, b )   => {
        ( a == src, b == src ) match {
          case ( false, false ) => br
          case ( true, false )  => RCYBrrExp( trgt, b )
          case ( false, true )  => RCYBrrExp( a, trgt )
          case ( true, true )   => RCYBrrExp( trgt, trgt )
        }
      }
      case s@RCYSeqExp( a, b, c ) => {
        ( a == src, b == src, c == src ) match {
          case ( false, false, false ) => s
          case ( true,  false, false ) => RCYSeqExp( trgt, b, c )
          case ( true,  false, true )  => RCYSeqExp( trgt, b, trgt )
          case ( true,  true,  false ) => RCYSeqExp( trgt, trgt, c )
          case ( false, false, true )  => RCYSeqExp( a, b, trgt )
          case ( false, true,  false ) => RCYSeqExp( a, trgt, c )
          case ( false, true,  true )  => RCYSeqExp( a, trgt, trgt )
          case ( true,  true,  true )  => RCYSeqExp( trgt, trgt, trgt )
        }
      }
      case RCYStrExp( p )         => {
        RCYStrExp( subst( src, trgt, p ) )
      }
      case n@RCYNewExp( ns, p )   => {
        if ( !ns.contains( src ) ) {
          RCYNewExp( ns, subst( src, trgt, p ) )
        }
        else { n }
      }
      case RCYParExp( l, r )      => {
        RCYParExp( subst( src, trgt, l ), subst( src, trgt, r ) )
      }
    }
  }

  def txPiForToY( s : RCUNameExp, o : RCUNameExp, p : RCYProcExp ) : RCRhoCombExp = {
    p match {
      case RCYParExp( l, r )    => {
        val ( c1, c2 ) = ( RCUNameUtil.fresh(), RCUNameUtil.fresh() )
          ( txPiForToY( c1, o, l ), txPiForToY( c2, o, r ) ) match {
          case ( fl : RCYProcExp, fr : RCYProcExp ) =>
            RCYNewExp(
              List[RCUNameExp]( c1, c2 ),
              RCYParExp( RCYDupExp( s, c1, c2 ), RCYParExp( fl, fr ) )
            )
          case unknown => throw new Exception( s"unexpected translations ${unknown}" )
        }
      }
      case RCYNewExp( ns, q )   => {
        ns match {
          case Nil      => throw new Exception( "empty binder list" )
          case n :: rns => {
            val c    = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYNewExp( rns, q ) ) match {
              case fq : RCYProcExp => 
                RCYNewExp( List[RCUNameExp]( c ), subst( c, n, fq ) )
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case RCYZeroExp           => {
        RCYKillExp( s )
      }
      case RCYStrExp( p )       => {
        val c = RCUNameUtil.fresh()
        txPiForToY( c, o, RCYParExp( p, RCYMsgExp( c, o ) ) ) match {
          case fq : RCYProcExp =>
            RCYNewExp( List[RCUNameExp]( c ), RCYParExp( RCYFwdExp( s, c ), fq ) )
          case unknown => throw new Exception( s"unexpected translations ${unknown}" )
        }
      }
      case RCYMsgExp( a, b )    => {
        ( o == a, o == b ) match {
          case ( false, false ) => {
            val c = RCUNameUtil.fresh()
            RCYNewExp( 
              List[RCUNameExp]( c ), 
              RCYParExp( RCYSeqExp( s, c, a ), RCYMsgExp( c, b ) ) 
            )
          }
          case ( false, true )  => {
            RCYFwdExp( s, a )
          }
          case ( true, _ )  => {
            val c = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( c, o ), RCYMsgExp( c, b ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case RCYFwdExp( a, b )    => {
        ( o == a, o == b ) match {
          case ( false, false ) => {
            val c = RCUNameUtil.fresh()
            RCYNewExp( 
              List[RCUNameExp]( c ), 
              RCYParExp( RCYSeqExp( s, a, c ), RCYFwdExp( c, b ) ) 
            )
          }
          case ( true, false )  => {
            RCYBrlExp( s, b )
          }
          case ( false, true )  => {
            RCYBrrExp( s, b )
          }        
          case ( true, true )   => {
            val c = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( o, c ), RCYFwdExp( c, b ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case RCYBrlExp( a, b )    => {
        ( o == a, o == b ) match {
          case ( false, false ) => {
            val c = RCUNameUtil.fresh()
            RCYNewExp( 
              List[RCUNameExp]( c ), 
              RCYParExp( RCYSeqExp( s, a, c ), RCYBrlExp( c, b ) ) 
            )
          }
          case ( false, true )  => {
            val c = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( c, o ), RCYBrlExp( a, c ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( true, _ )  => {
            val c = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( o, c ), RCYBrlExp( c, b ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case RCYBrrExp( a, b )    => {
        ( o == a, o == b ) match {
          case ( false, false ) => {
            val c = RCUNameUtil.fresh()
            RCYNewExp( 
              List[RCUNameExp]( c ), 
              RCYParExp( RCYSeqExp( s, a, c ), RCYBrrExp( c, b ) ) 
            )
          }
          case ( true, _ )  => {
            val c = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( o, c ), RCYFwdExp( c, b ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( false, true )  => {
            val ( c1, c2, c3 ) = ( RCUNameUtil.fresh(), RCUNameUtil.fresh(), RCUNameUtil.fresh() )
            val q = RCYParExp( RCYSeqExp( c1, o, c3 ), RCYBrrExp( c2, c3 ) )
            txPiForToY( s, o, RCYParExp( RCYDupExp( a, c1, c2 ), q ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c1, c2, c3 ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }          
        }
      }
      case RCYDupExp( a, b, c ) => {
        RCYZeroExp
      }
      case RCYSeqExp( a, b, c ) => {
        RCYZeroExp
      }
    }
  }

  val txPiToY : RCPProcExp => RCRhoCombExp = {
    ( rcpproc : RCPProcExp ) => {
      rcpproc match {
        case RCPZeroExp => RCYZeroExp
        case RCPInpExp  ( s, o, p ) => {
          txPiToY( p ) match {
            case fp : RCYProcExp => txPiForToY( s, o, fp )
            case unknown => throw new Exception( s"unexpected translations ${unknown}" )
          }
        }
        case RCPOutpExp ( s, o )    => RCYMsgExp( s, o )
        case RCPRepExp  ( p )       => {
          txPiToY( p ) match {
            case fp : RCYProcExp => RCYStrExp( fp )
            case unknown => throw new Exception( s"unexpected translations ${unknown}" )
          }
        }
        case RCPNewExp  ( ns, p )   => {
          txPiToY( p ) match {
            case fp : RCYProcExp => RCYNewExp( ns, fp )
            case unknown => throw new Exception( s"unexpected translations ${unknown}" )
          }
        }
        case RCPParExp  ( l, r )    => {
          ( txPiToY( l ), txPiToY( r ) ) match {
            case ( fl : RCYProcExp, fr: RCYProcExp ) =>
              RCYParExp( fl, fr )
            case unknown => throw new Exception( s"unexpected translations ${unknown}" )
          }
        }
      }
    }
  }

  val reduce : RCRhoCombExp => RCRhoCombExp =
    attr {
      case RCRZeroExp => RCRZeroExp
      case m@RCRMsgExp( _, _ )    => m
      case d@RCRDupExp( _, _, _ ) => d
      case k@RCRKillExp( _ )      => k
      case fw@RCRFwdExp( _, _ )   => fw
      case bl@RCRBrlExp( _, _ )   => bl
      case br@RCRBrrExp( _, _ )   => br
      case s@RCRSeqExp( _, _, _ ) => s
      case u@RCRStrExp( _ )       => u
      case dppar@RCRParExp( RCRDupExp( a, b, c ), RCRMsgExp( ma, mp ) ) => {
        if ( a == ma ) {
          RCRParExp( RCRMsgExp( b, mp ), RCRMsgExp( c, mp ) )
        }
        else dppar
      }
      case dppar@RCRParExp( RCRMsgExp( ma, mp ), RCRDupExp( a, b, c ) ) => {
        if ( a == ma ) {
          RCRParExp( RCRMsgExp( b, mp ), RCRMsgExp( c, mp ) )
        }
        else dppar
      }
      case kppar@RCRParExp( RCRKillExp( a ), RCRMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RCRZeroExp } else kppar
      }
      case kppar@RCRParExp( RCRMsgExp( ma, mp ), RCRKillExp( a ) ) => {
        if ( a == ma ) { RCRZeroExp } else kppar
      }
      case fwppar@RCRParExp( RCRFwdExp( a, b ), RCRMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RCRMsgExp( b, mp ) } else fwppar
      }
      case fwppar@RCRParExp( RCRMsgExp( ma, mp ), RCRFwdExp( a, b ) ) => {
        if ( a == ma ) { RCRMsgExp( b, mp ) } else fwppar
      }
      case blppar@RCRParExp( RCRBrlExp( a, b ), RCRMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RCRFwdExp( mp, b ) } else blppar
      }
      case blppar@RCRParExp( RCRMsgExp( ma, mp ), RCRBrlExp( a, b ) ) => {
        if ( a == ma ) { RCRFwdExp( mp, b ) } else blppar
      }
      case brppar@RCRParExp( RCRBrrExp( a, b ), RCRMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RCRFwdExp( b, mp ) } else brppar
      }
      case brppar@RCRParExp( RCRMsgExp( ma, mp ), RCRBrrExp( a, b ) ) => {
        if ( a == ma ) { RCRFwdExp( b, mp ) } else brppar
      }
      case sppar@RCRParExp( RCRSeqExp( a, b, c ), RCRMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RCRFwdExp( b, c ) } else sppar
      }
      case sppar@RCRParExp( RCRMsgExp( ma, mp ), RCRSeqExp( a, b, c ) ) => {
        if ( a == ma ) { RCRFwdExp( b, c ) } else sppar
      }
      case strppar@RCRParExp( RCRStrExp( a ), RCRMsgExp( ma, mp ) ) => {
        if ( a == ma ) { 
          mp match { 
            case RCRQuotExp( p ) => p
            case _ => throw new Exception( s"unexpected nominal: ${mp}" )
          } 
        } else strppar
      }
      case strppar@RCRParExp( RCRMsgExp( ma, mp ), RCRStrExp( a ) ) => {
        if ( a == ma ) { 
          mp match { 
            case RCRQuotExp( p ) => p
            case _ => throw new Exception( s"unexpected nominal: ${mp}" )
          } 
        } else strppar
      }
      case ppar@RCRParExp( l@RCRParExp( _, _ ), e ) => {
        reduce( RCRParExp( reduce( l ), e ) )
      }      
    }

}
