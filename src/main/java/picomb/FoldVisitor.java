package picomb;

import picomb.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* YProc */
    public R visit(picomb.Absyn.YPar p, A arg) {
      R r = leaf(arg);
      r = combine(p.yproc_1.accept(this, arg), r, arg);
      r = combine(p.yproc_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YInj p, A arg) {
      R r = leaf(arg);
      r = combine(p.ycomb_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YStr p, A arg) {
      R r = leaf(arg);
      r = combine(p.yproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YNew p, A arg) {
      R r = leaf(arg);
      for (YName x : p.listyname_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.yproc_.accept(this, arg), r, arg);
      return r;
    }

/* YComb */
    public R visit(picomb.Absyn.YZero p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(picomb.Absyn.YMsg p, A arg) {
      R r = leaf(arg);
      r = combine(p.yname_1.accept(this, arg), r, arg);
      r = combine(p.yname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YKill p, A arg) {
      R r = leaf(arg);
      r = combine(p.yname_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YDup p, A arg) {
      R r = leaf(arg);
      r = combine(p.yname_1.accept(this, arg), r, arg);
      r = combine(p.yname_2.accept(this, arg), r, arg);
      r = combine(p.yname_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YSeq p, A arg) {
      R r = leaf(arg);
      r = combine(p.yname_1.accept(this, arg), r, arg);
      r = combine(p.yname_2.accept(this, arg), r, arg);
      r = combine(p.yname_3.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YFwd p, A arg) {
      R r = leaf(arg);
      r = combine(p.yname_1.accept(this, arg), r, arg);
      r = combine(p.yname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YBrl p, A arg) {
      R r = leaf(arg);
      r = combine(p.yname_1.accept(this, arg), r, arg);
      r = combine(p.yname_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(picomb.Absyn.YBrr p, A arg) {
      R r = leaf(arg);
      r = combine(p.yname_1.accept(this, arg), r, arg);
      r = combine(p.yname_2.accept(this, arg), r, arg);
      return r;
    }

/* YName */
    public R visit(picomb.Absyn.NWild p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(picomb.Absyn.NVar p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* YVar */
    public R visit(picomb.Absyn.YWild p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(picomb.Absyn.YVVar p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
