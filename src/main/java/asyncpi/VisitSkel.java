package asyncpi;
import asyncpi.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class PProcVisitor<R,A> implements PProc.Visitor<R,A>
  {
        public R visit(asyncpi.Absyn.PPar p, A arg)
    { /* Code For PPar Goes Here */
      p.pproc_1.accept(new PProcVisitor<R,A>(), arg);
      p.pproc_2.accept(new PProcVisitor<R,A>(), arg);
      return null;
    }        public R visit(asyncpi.Absyn.PInj p, A arg)
    { /* Code For PInj Goes Here */
      p.pcomp_.accept(new PCompVisitor<R,A>(), arg);
      return null;
    }    public R visit(asyncpi.Absyn.PRep p, A arg)
    { /* Code For PRep Goes Here */
      p.pproc_.accept(new PProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(asyncpi.Absyn.PNew p, A arg)
    { /* Code For PNew Goes Here */
      for (PName x: p.listpname_)
      { /* ... */ }
      p.pproc_.accept(new PProcVisitor<R,A>(), arg);
      return null;
    }
  }
  public class PCompVisitor<R,A> implements PComp.Visitor<R,A>
  {
    public R visit(asyncpi.Absyn.PZero p, A arg)
    { /* Code For PZero Goes Here */
      return null;
    }    public R visit(asyncpi.Absyn.PInp p, A arg)
    { /* Code For PInp Goes Here */
      p.pname_1.accept(new PNameVisitor<R,A>(), arg);
      p.pname_2.accept(new PNameVisitor<R,A>(), arg);
      p.pproc_.accept(new PProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(asyncpi.Absyn.POutp p, A arg)
    { /* Code For POutp Goes Here */
      p.pname_1.accept(new PNameVisitor<R,A>(), arg);
      p.pname_2.accept(new PNameVisitor<R,A>(), arg);
      return null;
    }
  }
  public class PNameVisitor<R,A> implements PName.Visitor<R,A>
  {
    public R visit(asyncpi.Absyn.NWild p, A arg)
    { /* Code For NWild Goes Here */
      return null;
    }    public R visit(asyncpi.Absyn.NVar p, A arg)
    { /* Code For NVar Goes Here */
      //p.var_;
      return null;
    }
  }
  public class PVarVisitor<R,A> implements PVar.Visitor<R,A>
  {
    public R visit(asyncpi.Absyn.PWild p, A arg)
    { /* Code For PWild Goes Here */
      return null;
    }    public R visit(asyncpi.Absyn.PVVar p, A arg)
    { /* Code For PVVar Goes Here */
      //p.var_;
      return null;
    }
  }
}