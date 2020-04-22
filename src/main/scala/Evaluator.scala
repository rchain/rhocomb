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

  def txPiForToRho( s : RCUNameExp, o : RCUNameExp, p : RCYProcExp ) : RCRhoCombExp = {
    RCRZeroExp
  }  

  def txYToRhoDirect( p : RCYProcExp )( m : RCUNameExp, n : RCUNameExp ) : RCRhoCombExp = {
    RCRZeroExp
  }

  def txPiForToRhoDirect( s : RCUNameExp, o : RCUNameExp, p : RCYProcExp )( m : RCUNameExp, n : RCUNameExp ) : RCRhoCombExp = {
    txYToRhoDirect( p )( m, n ) match {
      case fp : RCRProcExp => {
        txPiForToRhoDirect( s, o, fp )( m, n )
      }
      case unknown => throw new Exception( s"unexpected translation: ${unknown}" )
    }
  }
  def txPiForToRhoDirect( s : RCUNameExp, o : RCUNameExp, p : RCRProcExp )( m : RCUNameExp, n : RCUNameExp ) : RCRhoCombExp = {
    p match {
      case rcrPar@RCRParExp( l, r )    => {
        val ( ml, nl, mr, nr ) = ( RCRNameUtil.inL( m ), RCRNameUtil.inL( n ), RCRNameUtil.inR( m ), RCRNameUtil.inR( n ) )
        //( txPiToRhoDirect( l )( ml, nl ), txPiToRhoDirect( r )( mr, nr ) ) match {
        ( l, r ) match {
          case ( fp : RCRProcExp, fq : RCRProcExp ) => {
            val ( v, w ) = (
              RCRQuotExp( RCRParExp( RCRMsgExp( n, RCRQuotExp( RCRParExp( RCRBrlExp( m, n ), RCRParExp( fp, fq ) ) ) ), rcrPar ) ), 
              RCRQuotExp( RCRParExp( RCRMsgExp( n, RCRQuotExp( RCRParExp( RCRBrrExp( m, n ), RCRParExp( fp, fq ) ) ) ), rcrPar ) )
            )
            val (n1, n2, q1, q2 ) = ( 
              RCRQuotExp( RCRParExp( RCRBrlExp( v, w ), RCRMsgExp( m, RCRQuotExp( RCRMsgExp( v, w ) ) ) ) ),
              RCRQuotExp( RCRParExp( RCRBrrExp( v, w ), RCRMsgExp( m, RCRQuotExp( RCRMsgExp( v, w ) ) ) ) ),
              RCRQuotExp( RCRParExp( RCRBrlExp( v, w ), RCRMsgExp( n, RCRQuotExp( RCRMsgExp( v, w ) ) ) ) ),
              RCRQuotExp( RCRParExp( RCRBrrExp( v, w ), RCRMsgExp( n, RCRQuotExp( RCRMsgExp( v, w ) ) ) ) )
            )

            ( txPiForToRhoDirect( v, o, fp )( ml, nl ), txPiForToRhoDirect( w, o, fq )( mr, nr ) ) match {
              case ( fl : RCRProcExp, fr : RCRProcExp ) =>
                RCRParExp( RCRDupExp( s, v, w ), RCRParExp( fl, fr ) )
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case unknown => throw new Exception( s"unexpected translations ${unknown}" )
        }        
      }      
      case RCRZeroExp           => {
        RCRKillExp( s )
      }
      case RCRStrExp( RCRQuotExp( p ) )       => {
        //txPiToRhoDirect( p )( m, n ) match {
        p match {
          case fp : RCRProcExp => {
            val nfp = RCRQuotExp( fp )
            val ( x, v, w, c, mR, nR ) = (
              RCRNameUtil.inL( RCRNameUtil.inL( nfp ) ),
              RCRNameUtil.inL( RCRNameUtil.inR( nfp ) ),
              RCRNameUtil.inR( RCRNameUtil.inL( nfp ) ),
              RCRNameUtil.inR( RCRNameUtil.inR( nfp ) ),
              RCRNameUtil.inR( m ), RCRNameUtil.inR( n )
            )
            txPiForToRhoDirect( c, o, RCRParExp( p, RCRMsgExp( c, o ) ) )( mR, nR ) match {
              case fq : RCRProcExp => {
                txPiForToRhoDirect( n, nR, fq )( mR, nR ) match {
                  case frRInner : RCRProcExp => {
                    txPiForToRhoDirect( m, mR, frRInner )( mR, nR ) match {
                      case frROuter : RCRProcExp => {
                        val rMsgs = RCRParExp( RCRMsgExp( m, mR ), RCRMsgExp( n, nR ) )
                        val rPayload = RCRParExp( frROuter, RCRParExp( txRhoD( x, v, w ), rMsgs ) )
                        val r = RCRMsgExp( o, RCRQuotExp( rPayload ) )
                        val fstr = txPiForToRhoDirect( c, m, RCRParExp( RCRFwdExp( s, m ), r ) )( m, n )
                        RCRParExp( fstr, RCRMsgExp( s, m ) )
                      }
                      case unknown => throw new Exception( s"unexpected translation ${unknown}" )
                    }
                  }
                  case unknown => throw new Exception( s"unexpected translation ${unknown}" )
                }
              }
              case unknown => throw new Exception( s"unexpected translation ${unknown}" )
            }
          }
          case unknown => throw new Exception( s"unexpected translation ${unknown}" )
        }        
      }
      case msgExp@RCRMsgExp( a, b )    => {
        ( o == a, o == b ) match {
          case ( false, false ) => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), msgExp ) )
            RCRParExp( RCRSeqExp( s, c, a ), RCRMsgExp( c, b ) )
          }
          case ( false, true )  => {
            RCYFwdExp( s, a )
          }
          case ( true, _ )  => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), msgExp ) )
            val pN = RCRParExp( RCRFwdExp( c, o ), RCRMsgExp( c, b ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case fwdExp@RCRFwdExp( a, b )    => {
        ( o == a, o == b ) match {
          case ( false, false ) => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), fwdExp ) )
            RCRParExp( RCRSeqExp( s, a, c ), RCRFwdExp( c, b ) )
          }
          case ( true, false )  => {
            RCRBrlExp( s, b )
          }
          case ( false, true )  => {
            RCRBrrExp( s, b )
          }        
          case ( true, true )   => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), fwdExp ) )
            val pN = RCRParExp( RCRFwdExp( o, c ), RCRFwdExp( c, b ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case brlExp@RCRBrlExp( a, b )    => {
        ( o == a, o == b ) match {
          case ( false, false ) => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), brlExp ) )
            RCRParExp( RCRSeqExp( s, a, c ), RCRBrlExp( c, b ) )
          }
          case ( false, true )  => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), brlExp ) )
            val pN = RCRParExp( RCRFwdExp( c, o ), RCRBrlExp( a, c ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( true, _ )  => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), brlExp ) )
            val pN = RCRParExp( RCRFwdExp( o, c ), RCRBrlExp( c, b ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case brrExp@RCRBrrExp( a, b )    => {
        ( o == a, o == b ) match {
          case ( false, false ) => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), brrExp ) )
            RCRParExp( RCRSeqExp( s, a, c ), RCRBrrExp( c, b ) )
          }
          case ( true, _ )  => {
            val c = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), brrExp ) )
            val pN = RCRParExp( RCRFwdExp( o, c ), RCRFwdExp( c, b ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( false, true )  => {
            val c1 = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), brrExp ) )
            val ( c2, c3 ) = (
              RCRNameUtil.inL( c1 ), RCRNameUtil.inR( c1 )
            )
            val q = RCRParExp( RCRSeqExp( c1, o, c3 ), RCRBrrExp( c2, c3 ) )
            val qN = RCRParExp( RCRDupExp( a, c1, c2 ), q )
            txPiForToRhoDirect( s, o, qN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }          
        }
      }
      case dupExp@RCRDupExp( a, b, c ) => {
        ( a == o, b == o, c == o ) match {
          case ( false, false, false ) => {
            val c1 = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), dupExp ) )
            RCRParExp( RCRSeqExp( s, a, c1 ), RCRDupExp( c1, b, c ) )
          }
          case ( false, true, _ )      => {
            val c1 = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), dupExp ) )
            val pN = RCRParExp( RCRFwdExp( c1, o ), RCRDupExp( b, c1, c ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }          
          case ( false, false, true )  => {
            val c1 = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), dupExp ) )
            val pN = RCRParExp( RCRFwdExp( c1, c ), RCRDupExp( a, b, c1 ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( true, _, _ )  => {
            val c1 = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), dupExp ) )
            val pN = RCRParExp( RCRFwdExp( o, c1 ), RCRDupExp( c1, b, c ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case seqExp@RCRSeqExp( a, b, c ) => {
        ( a == o, b == o, c == o ) match {
          case ( false, false, false ) => {
            val c1 = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), seqExp ) )
            RCRParExp( RCRSeqExp( s, a, c1 ), RCRSeqExp( c1, b, c ) )
          }
          case ( true, _, _ )  => {
            val c1 = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), seqExp ) )
            val pN = RCRParExp( RCRFwdExp( o, c1 ), RCRSeqExp( c1, b, c ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCYProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( false, false, true )  => {
            val c1 = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), seqExp ) )
            val pN = RCRParExp( RCRFwdExp( c1, c ), RCRSeqExp( a, b, c1 ) )
            txPiForToRhoDirect( s, o, pN )( m, n ) match {
              case fq : RCRProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( false, true, _ )  => {
            val cN = RCRQuotExp( RCRParExp( RCRMsgExp( n, m ), seqExp ) )
            val ( c1, c2 ) = ( RCRNameUtil.inL( cN ), RCRNameUtil.inR( cN ) )
            val q = RCRParExp( RCRMsgExp( c1, o ), RCRBrlExp( c2, c ) )
            val qN = RCRParExp( RCRSeqExp( a, c1, c2 ), q )
            txPiForToRhoDirect( s, o, qN )( m, n ) match {
              case fq : RCYProcExp => fq
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }          
        }
      }
    }
  }

  def txRhoD( x : RCUNameExp, v : RCUNameExp, w : RCUNameExp ) : RCRhoCombExp = {
    RCRParExp( RCRDupExp( x, v, w ), RCRParExp( RCRFwdExp( v, x ), RCRStrExp( w ) ) )
  }

  def txPiToRhoDirect( rcpproc : RCYProcExp )( m : RCUNameExp, n : RCUNameExp ) : RCRhoCombExp = {
    RCRZeroExp
  }

  def txPiToRhoDirect( rcpproc : RCPProcExp )( m : RCUNameExp, n : RCUNameExp ) : RCRhoCombExp = {
    rcpproc match {
      case RCPZeroExp => RCRZeroExp
      case RCPInpExp  ( s, o, p ) => {
        txPiToRhoDirect( p )( m, n ) match {
          case fp : RCRProcExp => txPiForToRhoDirect( s, o, fp )( m, n )
          case unknown => throw new Exception( s"unexpected translations ${unknown}" )
        }
      }
      case RCPOutpExp ( s, o )    => RCRMsgExp( s, o )
      case RCPRepExp  ( p )       => {
        val ( nM, nN ) = ( RCRNameUtil.inL( m ), RCRNameUtil.inL( n ) )
        val seedP =
          txPiToRhoDirect( p )( m, n ) match {
            case sP : RCRProcExp => sP
            case unknown => throw new Exception( s"unexpected translations ${unknown}" )
          }
        val seed = RCRNameUtil.freshFrom( seedP )
        val ( mP, nP ) = ( RCRNameUtil.inL( seed ), RCRNameUtil.inR( seed ) )
        val ( x, v, w ) = ( RCRNameUtil.inL( RCRNameUtil.inL( seed ) ), RCRNameUtil.inL( RCRNameUtil.inR( seed ) ), RCRNameUtil.inR( RCRNameUtil.inL( seed ) ) ) 
        val outerKickOffP = RCRParExp( txRhoD( x, v, w ), RCRParExp( RCRMsgExp( m, nM ), RCRMsgExp( n, nN ) ) )
        val innerKickOffP = RCRParExp( txRhoD( x, v, w ), RCRParExp( RCRMsgExp( nM, nM ), RCRMsgExp( nN, nN ) ) )

        txPiForToRhoDirect( n, nP, seedP )( mP, nP ) match {
          case fp : RCRProcExp => {
            txPiForToRhoDirect( m, mP, fp )( mP, nP ) match {
              case ffp : RCRProcExp => {
                val msgP = RCRMsgExp( x, RCRQuotExp( RCRStrExp( RCRQuotExp( RCRParExp( ffp, innerKickOffP ) ) ) ) )
                RCRParExp( msgP, outerKickOffP )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case unknown => throw new Exception( s"unexpected translations ${unknown}" )        
        }
      }
      case RCPNewExp  ( ns, p )   => {
        txPiToRhoDirect( p )( m, n ) match {
          case fp : RCRProcExp => {
            ns match {
              case newN :: rns => {
                val ( lM, lN ) = ( RCRNameUtil.inL( m ), RCRNameUtil.inL( n ) )
                txPiForToRhoDirect( m, newN, fp )( lM, lN ) match {
                  case ffp : RCRProcExp => {
                    RCRParExp( ffp, RCRMsgExp( m, n ) )
                  }
                  case unknown => throw new Exception( s"unexpected translations ${unknown}" )
                }
              }
              case Nil => throw new Exception( s"empty binder list ${rcpproc}" )
            }
          }
          case unknown => throw new Exception( s"unexpected translations ${unknown}" )
        }
      }
      case RCPParExp  ( l, r )    => {
        ( txPiToRhoDirect( l )( m, n ), txPiToRhoDirect( r )( m, n ) ) match {
          case ( fl : RCRProcExp, fr: RCRProcExp ) =>
            RCRParExp( fl, fr )
          case unknown => throw new Exception( s"unexpected translations ${unknown}" )
        }
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
        ( a == o, b == o, c == o ) match {
          case ( false, false, false ) => {
            val c1 = RCUNameUtil.fresh()
            RCYNewExp( 
              List[RCUNameExp]( c1 ), 
              RCYParExp( RCYSeqExp( s, a, c1 ), RCYDupExp( c1, b, c ) ) 
            )
          }
          case ( false, true, _ )      => {
            val c1 = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( c1, o ), RCYDupExp( b, c1, c ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c1 ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }          
          case ( false, false, true )  => {
            val c1 = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( c1, c ), RCYDupExp( a, b, c1 ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c1 ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( true, _, _ )  => {
            val c1 = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( o, c1 ), RCYDupExp( c1, b, c ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c1 ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
        }
      }
      case RCYSeqExp( a, b, c ) => {
        ( a == o, b == o, c == o ) match {
          case ( false, false, false ) => {
            val c1 = RCUNameUtil.fresh()
            RCYNewExp( 
              List[RCUNameExp]( c1 ), 
              RCYParExp( RCYSeqExp( s, a, c1 ), RCYSeqExp( c1, b, c ) ) 
            )
          }
          case ( true, _, _ )  => {
            val c1 = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( o, c1 ), RCYSeqExp( c1, b, c ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c1 ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( false, false, true )  => {
            val c1 = RCUNameUtil.fresh()
            txPiForToY( s, o, RCYParExp( RCYFwdExp( c1, c ), RCYSeqExp( a, b, c1 ) ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c1 ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }
          case ( false, true, _ )  => {
            val ( c1, c2 ) = ( RCUNameUtil.fresh(), RCUNameUtil.fresh() )
            val q = RCYParExp( RCYMsgExp( c1, o ), RCYBrlExp( c2, c ) )
            txPiForToY( s, o, RCYParExp( RCYSeqExp( a, c1, c2 ), q ) ) match {
              case fq : RCYProcExp => {
                RCYNewExp( List[RCUNameExp]( c1, c2 ), fq )
              }
              case unknown => throw new Exception( s"unexpected translations ${unknown}" )
            }
          }          
        }
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
