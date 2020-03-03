package asyncpi;

import asyncpi.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* PProc */
    public R visit(asyncpi.Absyn.PPar p, A arg) {
      R r = leaf(arg);
      r = combine(p.pproc_1.accept(this, arg), r, arg);
      r = combine(p.pproc_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(asyncpi.Absyn.PInj p, A arg) {
      R r = leaf(arg);
      r = combine(p.pcomp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(asyncpi.Absyn.PRep p, A arg) {
      R r = leaf(arg);
      r = combine(p.pproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(asyncpi.Absyn.PNew p, A arg) {
      R r = leaf(arg);
      for (PName x : p.listpname_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      r = combine(p.pproc_.accept(this, arg), r, arg);
      return r;
    }

/* PComp */
    public R visit(asyncpi.Absyn.PZero p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(asyncpi.Absyn.PInp p, A arg) {
      R r = leaf(arg);
      r = combine(p.pname_1.accept(this, arg), r, arg);
      r = combine(p.pname_2.accept(this, arg), r, arg);
      r = combine(p.pproc_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(asyncpi.Absyn.POutp p, A arg) {
      R r = leaf(arg);
      r = combine(p.pname_1.accept(this, arg), r, arg);
      r = combine(p.pname_2.accept(this, arg), r, arg);
      return r;
    }

/* PName */
    public R visit(asyncpi.Absyn.NWild p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(asyncpi.Absyn.NVar p, A arg) {
      R r = leaf(arg);
      return r;
    }

/* PVar */
    public R visit(asyncpi.Absyn.PWild p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(asyncpi.Absyn.PVVar p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
