package rhocomb;
import rhocomb.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class RProcVisitor<R,A> implements RProc.Visitor<R,A>
  {
        public R visit(rhocomb.Absyn.RPar p, A arg)
    { /* Code For RPar Goes Here */
      p.rproc_1.accept(new RProcVisitor<R,A>(), arg);
      p.rproc_2.accept(new RProcVisitor<R,A>(), arg);
      return null;
    }        public R visit(rhocomb.Absyn.RInj p, A arg)
    { /* Code For RInj Goes Here */
      p.rcomb_.accept(new RCombVisitor<R,A>(), arg);
      return null;
    }    public R visit(rhocomb.Absyn.RStr p, A arg)
    { /* Code For RStr Goes Here */
      p.rname_.accept(new RNameVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RCombVisitor<R,A> implements RComb.Visitor<R,A>
  {
    public R visit(rhocomb.Absyn.RZero p, A arg)
    { /* Code For RZero Goes Here */
      return null;
    }    public R visit(rhocomb.Absyn.RMsg p, A arg)
    { /* Code For RMsg Goes Here */
      p.rname_1.accept(new RNameVisitor<R,A>(), arg);
      p.rname_2.accept(new RNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(rhocomb.Absyn.RKill p, A arg)
    { /* Code For RKill Goes Here */
      p.rname_.accept(new RNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(rhocomb.Absyn.RDup p, A arg)
    { /* Code For RDup Goes Here */
      p.rname_1.accept(new RNameVisitor<R,A>(), arg);
      p.rname_2.accept(new RNameVisitor<R,A>(), arg);
      p.rname_3.accept(new RNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(rhocomb.Absyn.RSeq p, A arg)
    { /* Code For RSeq Goes Here */
      p.rname_1.accept(new RNameVisitor<R,A>(), arg);
      p.rname_2.accept(new RNameVisitor<R,A>(), arg);
      p.rname_3.accept(new RNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(rhocomb.Absyn.RFwd p, A arg)
    { /* Code For RFwd Goes Here */
      p.rname_1.accept(new RNameVisitor<R,A>(), arg);
      p.rname_2.accept(new RNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(rhocomb.Absyn.RBrl p, A arg)
    { /* Code For RBrl Goes Here */
      p.rname_1.accept(new RNameVisitor<R,A>(), arg);
      p.rname_2.accept(new RNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(rhocomb.Absyn.RBrr p, A arg)
    { /* Code For RBrr Goes Here */
      p.rname_1.accept(new RNameVisitor<R,A>(), arg);
      p.rname_2.accept(new RNameVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RNameVisitor<R,A> implements RName.Visitor<R,A>
  {
    public R visit(rhocomb.Absyn.RQuot p, A arg)
    { /* Code For RQuot Goes Here */
      p.rproc_.accept(new RProcVisitor<R,A>(), arg);
      return null;
    }
  }
}