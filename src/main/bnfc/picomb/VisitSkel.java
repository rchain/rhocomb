package picomb;
import picomb.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class YProcVisitor<R,A> implements YProc.Visitor<R,A>
  {
        public R visit(picomb.Absyn.YPar p, A arg)
    { /* Code For YPar Goes Here */
      p.yproc_1.accept(new YProcVisitor<R,A>(), arg);
      p.yproc_2.accept(new YProcVisitor<R,A>(), arg);
      return null;
    }        public R visit(picomb.Absyn.YInj p, A arg)
    { /* Code For YInj Goes Here */
      p.ycomb_.accept(new YCombVisitor<R,A>(), arg);
      return null;
    }    public R visit(picomb.Absyn.YStr p, A arg)
    { /* Code For YStr Goes Here */
      p.yproc_.accept(new YProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(picomb.Absyn.YNew p, A arg)
    { /* Code For YNew Goes Here */
      for (YName x: p.listyname_)
      { /* ... */ }
      p.yproc_.accept(new YProcVisitor<R,A>(), arg);
      return null;
    }
  }
  public class YCombVisitor<R,A> implements YComb.Visitor<R,A>
  {
    public R visit(picomb.Absyn.YZero p, A arg)
    { /* Code For YZero Goes Here */
      return null;
    }    public R visit(picomb.Absyn.YMsg p, A arg)
    { /* Code For YMsg Goes Here */
      p.yname_1.accept(new YNameVisitor<R,A>(), arg);
      p.yname_2.accept(new YNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(picomb.Absyn.YKill p, A arg)
    { /* Code For YKill Goes Here */
      p.yname_.accept(new YNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(picomb.Absyn.YDup p, A arg)
    { /* Code For YDup Goes Here */
      p.yname_1.accept(new YNameVisitor<R,A>(), arg);
      p.yname_2.accept(new YNameVisitor<R,A>(), arg);
      p.yname_3.accept(new YNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(picomb.Absyn.YSeq p, A arg)
    { /* Code For YSeq Goes Here */
      p.yname_1.accept(new YNameVisitor<R,A>(), arg);
      p.yname_2.accept(new YNameVisitor<R,A>(), arg);
      p.yname_3.accept(new YNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(picomb.Absyn.YFwd p, A arg)
    { /* Code For YFwd Goes Here */
      p.yname_1.accept(new YNameVisitor<R,A>(), arg);
      p.yname_2.accept(new YNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(picomb.Absyn.YBrl p, A arg)
    { /* Code For YBrl Goes Here */
      p.yname_1.accept(new YNameVisitor<R,A>(), arg);
      p.yname_2.accept(new YNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(picomb.Absyn.YBrr p, A arg)
    { /* Code For YBrr Goes Here */
      p.yname_1.accept(new YNameVisitor<R,A>(), arg);
      p.yname_2.accept(new YNameVisitor<R,A>(), arg);
      return null;
    }
  }
  public class YNameVisitor<R,A> implements YName.Visitor<R,A>
  {
    public R visit(picomb.Absyn.NWild p, A arg)
    { /* Code For NWild Goes Here */
      return null;
    }    public R visit(picomb.Absyn.NVar p, A arg)
    { /* Code For NVar Goes Here */
      //p.cvar_;
      return null;
    }
  }
  public class YVarVisitor<R,A> implements YVar.Visitor<R,A>
  {
    public R visit(picomb.Absyn.YWild p, A arg)
    { /* Code For YWild Goes Here */
      return null;
    }    public R visit(picomb.Absyn.YVVar p, A arg)
    { /* Code For YVVar Goes Here */
      //p.cvar_;
      return null;
    }
  }
}