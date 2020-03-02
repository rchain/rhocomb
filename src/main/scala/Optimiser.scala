package coop.rchain.rhocomb.repl
import rhocomb.Absyn._;

object Optimiser {

  import org.bitbucket.inkytonik.kiama.rewriting.Rewriter.{attempt, bottomup, rewrite, rule}

  def normalizeCombinator( ast : RComb ) : RhoCombExp = {
    ast match {
      case rz   : RZero => RZeroExp
      case rm   : RMsg  => RMsgExp ( normalizeName( rm.rname_1 ), normalizeName( rm.rname_2 ) )
      case rd   : RDup  => RDupExp ( normalizeName( rd.rname_1 ), normalizeName( rd.rname_2 ), normalizeName( rd.rname_3 ) )
      case rk   : RKill => RKillExp( normalizeName( rk.rname_ ) )
      case rfw  : RFwd  => RFwdExp ( normalizeName( rfw.rname_1 ), normalizeName( rfw.rname_2 ) )
      case rbl  : RBrl  => RBrlExp ( normalizeName( rbl.rname_1 ), normalizeName( rbl.rname_2 ) )
      case rbr  : RBrr  => RBrrExp ( normalizeName( rbr.rname_1 ), normalizeName( rbr.rname_2 ) )
      case rs   : RSeq  => RSeqExp ( normalizeName( rs.rname_1 ), normalizeName( rs.rname_2 ), normalizeName( rs.rname_3 ) )
      case _            => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  def normalizeProcess( ast : RProc ) : RhoCombExp = {
    ast match {
      case rinj : RInj  => normalizeCombinator( rinj.rcomb_ )
      case rstr : RStr  => RStrExp( normalizeName( rstr.rname_ ) )
      case rpar : RPar  => RParExp( normalizeProcess( rpar.rproc_1 ), normalizeProcess( rpar.rproc_2 ) )
      case _            => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

  def normalizeName( ast : RName ) : RNameExp = {
    ast match {
      case rq : RQuot => RQuotExp( normalizeProcess( rq.rproc_ ) )
      case _          => throw new Exception( s"unexpected ast: ${ast}" )
    }
  }

    def optimise (e : RhoCombExp) : RhoCombExp =
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
        rule[RhoCombExp] {
            case Add (Num (0), e)     => e
            case Add (e, Num (0))     => e
            case Mul (Num (1), e)     => e
            case Mul (e, Num (1))     => e
            case Mul (z @ Num (0), _) => z
            case Mul (_, z @ Num (0)) => z
        }

}
