package coop.rchain.rhocomb.repl

import org.bitbucket.inkytonik.kiama.attribution.Attribution

/**
 * Use attribution to evaluate an expression.
 */
object Evaluator extends Attribution {

  val value : RhoCombExp => Int =
    attr {
      case Num (i)    => i
      case Add (l, r) => value (l) + value (r)
      case Mul (l, r) => value (l) * value (r)
      case _          => -1
    }

  val reduce : RhoCombExp => RhoCombExp =
    attr {
      case RZeroExp => RZeroExp
      case m@RMsgExp( _, _ )    => m
      case d@RDupExp( _, _, _ ) => d
      case k@RKillExp( _ )      => k
      case fw@RFwdExp( _, _ )   => fw
      case bl@RBrlExp( _, _ )   => bl
      case br@RBrrExp( _, _ )   => br
      case s@RSeqExp( _, _, _ ) => s
      case u@RStrExp( _ )       => u
      case dppar@RParExp( RDupExp( a, b, c ), RMsgExp( ma, mp ) ) => {
        if ( a == ma ) {
          RParExp( RMsgExp( b, mp ), RMsgExp( c, mp ) )
        }
        else dppar
      }
      case kppar@RParExp( RKillExp( a ), RMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RZeroExp } else kppar
      }
      case fwppar@RParExp( RFwdExp( a, b ), RMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RMsgExp( b, mp ) } else fwppar
      }
      case blppar@RParExp( RBrlExp( a, b ), RMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RFwdExp( mp, b ) } else blppar
      }
      case brppar@RParExp( RBrrExp( a, b ), RMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RFwdExp( b, mp ) } else brppar
      }
      case sppar@RParExp( RSeqExp( a, b, c ), RMsgExp( ma, mp ) ) => {
        if ( a == ma ) { RFwdExp( b, c ) } else sppar
      }
      case strppar@RParExp( RStrExp( a ), RMsgExp( ma, mp ) ) => {
        if ( a == ma ) { 
          mp match { 
            case RQuotExp( p ) => p
            case _ => throw new Exception( s"unexpected nominal: ${mp}" )
          } 
        } else strppar
      }
      case ppar@RParExp( l@RParExp( _, _ ), e ) => {
        reduce( RParExp( reduce( l ), e ) )
      }      
    }

}
