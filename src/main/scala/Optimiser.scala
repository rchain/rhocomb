package coop.rchain.rhocomb.repl
//import rhocomb.Absyn._;
import coop.rchain.rhocomb.pi2rhocomb.Absyn._;

object Optimiser {

  import org.bitbucket.inkytonik.kiama.rewriting.Rewriter.{attempt, bottomup, rewrite, rule}
  import scala.collection.JavaConverters._

  /**
   * User requests
   */

  def normalizeRCRequest( ast : Req ) : RCRhoCombExp = {
    ast match {
      case rqquit : RqCmd  => Quit
      case rqeval : RqEval => RCEval( normalizeRCRProcess( rqeval.rcrproc_ ) )
      case rqp2r  : RqP2R  => RCPiToRho( normalizeRCPProcess( rqp2r.rcpproc_ ) )
      case rqp2y  : RqP2Y  => RCPiToY( normalizeRCPProcess( rqp2y.rcpproc_ ) )
      case rqy2r  : RqY2R  => RCYToRho( normalizeRCYProcess( rqy2r.rcyproc_ ) )
    }
  }

  /**
   * Async Pi Calculus
   */

  def normalizeRCPComponent( ast : RCPComp ) : RCPCompExp = {
    ast match {
      case rcpz    : RCPZero => RCPZeroExp
      case rcpinp  : RCPInp  => RCPInpExp ( normalizeRCUName( rcpinp.rcuname_1 ), normalizeRCUName( rcpinp.rcuname_2 ), normalizeRCPProcess( rcpinp.rcpproc_ ) )
      case rcpoutp : RCPOutp => RCPOutpExp ( normalizeRCUName( rcpoutp.rcuname_1 ), normalizeRCUName( rcpoutp.rcuname_2 ) )
      case _            => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  def normalizeRCPProcess( ast : RCPProc ) : RCPProcExp = {
    ast match {
      case rcpinj : RCPInj  => normalizeRCPComponent( rcpinj.rcpcomp_ )
      case rcprep : RCPRep  => RCPRepExp( normalizeRCPProcess( rcprep.rcpproc_ ) )
      case rcpnew : RCPNew  => {
        val nlist = rcpnew.listrcuname_.asScala.toList
        RCPNewExp( nlist.map( normalizeRCUName ), normalizeRCPProcess( rcpnew.rcpproc_ ) )
      }
      case rcppar : RCPPar  => RCPParExp( normalizeRCPProcess( rcppar.rcpproc_1 ), normalizeRCPProcess( rcppar.rcpproc_2 ) )
      case _            => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  def normalizeRCUName( ast : RCUName ) : RCUNameExp = {
    ast match {
      case rcunwild : RCUNWild => RCUWildExp
      case rcunvar  : RCUNVar  => RCUVarExp( rcunvar.var_ )
      case _          => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  /**
   * (Honda) Yoshida Combinators
   */

  def normalizeRCYCombinator( ast : RCYComb ) : RCYCombExp = {
    ast match {
      case rz   : RCYZero => RCYZeroExp
      case rm   : RCYMsg  => RCYMsgExp ( normalizeRCUName( rm.rcuname_1 ), normalizeRCUName( rm.rcuname_2 ) )
      case rd   : RCYDup  => RCYDupExp ( normalizeRCUName( rd.rcuname_1 ), normalizeRCUName( rd.rcuname_2 ), normalizeRCUName( rd.rcuname_3 ) )
      case rk   : RCYKill => RCYKillExp( normalizeRCUName( rk.rcuname_ ) )
      case rfw  : RCYFwd  => RCYFwdExp ( normalizeRCUName( rfw.rcuname_1 ), normalizeRCUName( rfw.rcuname_2 ) )
      case rbl  : RCYBrl  => RCYBrlExp ( normalizeRCUName( rbl.rcuname_1 ), normalizeRCUName( rbl.rcuname_2 ) )
      case rbr  : RCYBrr  => RCYBrrExp ( normalizeRCUName( rbr.rcuname_1 ), normalizeRCUName( rbr.rcuname_2 ) )
      case rs   : RCYSeq  => RCYSeqExp ( normalizeRCUName( rs.rcuname_1 ), normalizeRCUName( rs.rcuname_2 ), normalizeRCUName( rs.rcuname_3 ) )
      case _            => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  def normalizeRCYProcess( ast : RCYProc ) : RCYProcExp = {
    ast match {
      case rcyinj : RCYInj  => normalizeRCYCombinator( rcyinj.rcycomb_ )
      case rcystr : RCYStr  => RCYStrExp( normalizeRCYProcess( rcystr.rcyproc_ ) )
      case rcynew : RCYNew  => {
        val nlist = rcynew.listrcuname_.asScala.toList
        RCYNewExp( nlist.map( normalizeRCUName ), normalizeRCYProcess( rcynew.rcyproc_ ) )
      }
      case rcypar : RCYPar  => RCYParExp( normalizeRCYProcess( rcypar.rcyproc_1 ), normalizeRCYProcess( rcypar.rcyproc_2 ) )
      case _            => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  /**
   * Rho Combinators
   */

  def normalizeRCRCombinator( ast : RCRComb ) : RCRhoCombExp = {
    ast match {
      case rz   : RCRZero => RCRZeroExp
      case rm   : RCRMsg  => RCRMsgExp ( normalizeRCRName( rm.rcrname_1 ), normalizeRCRName( rm.rcrname_2 ) )
      case rd   : RCRDup  => RCRDupExp ( normalizeRCRName( rd.rcrname_1 ), normalizeRCRName( rd.rcrname_2 ), normalizeRCRName( rd.rcrname_3 ) )
      case rk   : RCRKill => RCRKillExp( normalizeRCRName( rk.rcrname_ ) )
      case rfw  : RCRFwd  => RCRFwdExp ( normalizeRCRName( rfw.rcrname_1 ), normalizeRCRName( rfw.rcrname_2 ) )
      case rbl  : RCRBrl  => RCRBrlExp ( normalizeRCRName( rbl.rcrname_1 ), normalizeRCRName( rbl.rcrname_2 ) )
      case rbr  : RCRBrr  => RCRBrrExp ( normalizeRCRName( rbr.rcrname_1 ), normalizeRCRName( rbr.rcrname_2 ) )
      case rs   : RCRSeq  => RCRSeqExp ( normalizeRCRName( rs.rcrname_1 ), normalizeRCRName( rs.rcrname_2 ), normalizeRCRName( rs.rcrname_3 ) )
      case _            => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  def normalizeRCRProcess( ast : RCRProc ) : RCRhoCombExp = {
    ast match {
      case rinj : RCRInj  => normalizeRCRCombinator( rinj.rcrcomb_ )
      case rstr : RCRStr  => RCRStrExp( normalizeRCRName( rstr.rcrname_ ) )
      case rpar : RCRPar  => RCRParExp( normalizeRCRProcess( rpar.rcrproc_1 ), normalizeRCRProcess( rpar.rcrproc_2 ) )
      case _            => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  def normalizeRCRName( ast : RCRName ) : RCRNameExp = {
    ast match {
      case rq : RCRQuot => RCRQuotExp( normalizeRCRProcess( rq.rcrproc_ ) )
      case _          => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

    def optimise (e : RCRhoCombExp) : RCRhoCombExp =
        rewrite (optimiser) (e)

    /**
     * Try to optimise every expression in a tree. Do it bottom
     * up so higher up tries get the advantage of things done
     * at lower levels.
     */
    lazy val optimiser =
        bottomup (attempt (simplifier))

    /**
     * Simplify an expression using simple equivalences.
     */
    lazy val simplifier =
        rule[RCRhoCombExp] {
            case Add (Num (0), e)     => e
            case Add (e, Num (0))     => e
            case Mul (Num (1), e)     => e
            case Mul (e, Num (1))     => e
            case Mul (z @ Num (0), _) => z
            case Mul (_, z @ Num (0)) => z
        }

}
