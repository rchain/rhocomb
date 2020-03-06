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
      RCRZeroExp
    }
  }

  val txYToRho : RCYProcExp => RCRhoCombExp = {
    ( rcpproc : RCYProcExp ) => {
      RCRZeroExp
    }
  }

  val txPiToY : RCPProcExp => RCRhoCombExp = {
    ( rcpproc : RCPProcExp ) => {
      RCYZeroExp
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
