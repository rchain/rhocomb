package coop.rchain.rhocomb.pi2rhocomb;

import coop.rchain.rhocomb.pi2rhocomb.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Req */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcpproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcyproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcpproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* RCPProc */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcpproc_1.accept(this, arg), r, arg);
      r = combine(p.rcpproc_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcpcomp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcpproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew p, A arg) {
      R r = leaf(arg);
      for (RCUName x : p.listrcuname_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.rcpproc_.accept(this, arg), r, arg);
      return r;
    }

/* RCPComp */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_1.accept(this, arg), r, arg);
      r = combine(p.rcuname_2.accept(this, arg), r, arg);
      r = combine(p.rcpproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_1.accept(this, arg), r, arg);
      r = combine(p.rcuname_2.accept(this, arg), r, arg);
      return r;
    }

/* RCYProc */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcyproc_1.accept(this, arg), r, arg);
      r = combine(p.rcyproc_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcycomb_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcyproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew p, A arg) {
      R r = leaf(arg);
      for (RCUName x : p.listrcuname_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.rcyproc_.accept(this, arg), r, arg);
      return r;
    }

/* RCYComb */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_1.accept(this, arg), r, arg);
      r = combine(p.rcuname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_1.accept(this, arg), r, arg);
      r = combine(p.rcuname_2.accept(this, arg), r, arg);
      r = combine(p.rcuname_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_1.accept(this, arg), r, arg);
      r = combine(p.rcuname_2.accept(this, arg), r, arg);
      r = combine(p.rcuname_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_1.accept(this, arg), r, arg);
      r = combine(p.rcuname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_1.accept(this, arg), r, arg);
      r = combine(p.rcuname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcuname_1.accept(this, arg), r, arg);
      r = combine(p.rcuname_2.accept(this, arg), r, arg);
      return r;
    }

/* RCUName */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* RCRProc */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrproc_1.accept(this, arg), r, arg);
      r = combine(p.rcrproc_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrcomb_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrname_.accept(this, arg), r, arg);
      return r;
    }

/* RCRComb */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrname_1.accept(this, arg), r, arg);
      r = combine(p.rcrname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrname_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrname_1.accept(this, arg), r, arg);
      r = combine(p.rcrname_2.accept(this, arg), r, arg);
      r = combine(p.rcrname_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrname_1.accept(this, arg), r, arg);
      r = combine(p.rcrname_2.accept(this, arg), r, arg);
      r = combine(p.rcrname_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrname_1.accept(this, arg), r, arg);
      r = combine(p.rcrname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrname_1.accept(this, arg), r, arg);
      r = combine(p.rcrname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrname_1.accept(this, arg), r, arg);
      r = combine(p.rcrname_2.accept(this, arg), r, arg);
      return r;
    }

/* RCRName */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcrproc_.accept(this, arg), r, arg);
      return r;
    }


}
