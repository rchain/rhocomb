package rhocomb;

import rhocomb.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* RProc */
    public R visit(rhocomb.Absyn.RPar p, A arg) {
      R r = leaf(arg);
      r = combine(p.rproc_1.accept(this, arg), r, arg);
      r = combine(p.rproc_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RInj p, A arg) {
      R r = leaf(arg);
      r = combine(p.rcomb_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RStr p, A arg) {
      R r = leaf(arg);
      r = combine(p.rname_.accept(this, arg), r, arg);
      return r;
    }

/* RComb */
    public R visit(rhocomb.Absyn.RZero p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RMsg p, A arg) {
      R r = leaf(arg);
      r = combine(p.rname_1.accept(this, arg), r, arg);
      r = combine(p.rname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RKill p, A arg) {
      R r = leaf(arg);
      r = combine(p.rname_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RDup p, A arg) {
      R r = leaf(arg);
      r = combine(p.rname_1.accept(this, arg), r, arg);
      r = combine(p.rname_2.accept(this, arg), r, arg);
      r = combine(p.rname_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RSeq p, A arg) {
      R r = leaf(arg);
      r = combine(p.rname_1.accept(this, arg), r, arg);
      r = combine(p.rname_2.accept(this, arg), r, arg);
      r = combine(p.rname_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RFwd p, A arg) {
      R r = leaf(arg);
      r = combine(p.rname_1.accept(this, arg), r, arg);
      r = combine(p.rname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RBrl p, A arg) {
      R r = leaf(arg);
      r = combine(p.rname_1.accept(this, arg), r, arg);
      r = combine(p.rname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(rhocomb.Absyn.RBrr p, A arg) {
      R r = leaf(arg);
      r = combine(p.rname_1.accept(this, arg), r, arg);
      r = combine(p.rname_2.accept(this, arg), r, arg);
      return r;
    }

/* RName */
    public R visit(rhocomb.Absyn.RQuot p, A arg) {
      R r = leaf(arg);
      r = combine(p.rproc_.accept(this, arg), r, arg);
      return r;
    }


}
