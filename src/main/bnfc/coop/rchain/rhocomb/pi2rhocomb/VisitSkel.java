package coop.rchain.rhocomb.pi2rhocomb;
import coop.rchain.rhocomb.pi2rhocomb.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ReqVisitor<R,A> implements Req.Visitor<R,A>
  {
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R p, A arg)
    { /* Code For RqP2R Goes Here */
      p.rcpproc_.accept(new RCPProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R p, A arg)
    { /* Code For RqY2R Goes Here */
      p.rcyproc_.accept(new RCYProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y p, A arg)
    { /* Code For RqP2Y Goes Here */
      p.rcpproc_.accept(new RCPProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval p, A arg)
    { /* Code For RqEval Goes Here */
      p.rcrproc_.accept(new RCRProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd p, A arg)
    { /* Code For RqCmd Goes Here */
      return null;
    }
  }
  public class RCPProcVisitor<R,A> implements RCPProc.Visitor<R,A>
  {
        public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar p, A arg)
    { /* Code For RCPPar Goes Here */
      p.rcpproc_1.accept(new RCPProcVisitor<R,A>(), arg);
      p.rcpproc_2.accept(new RCPProcVisitor<R,A>(), arg);
      return null;
    }        public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj p, A arg)
    { /* Code For RCPInj Goes Here */
      p.rcpcomp_.accept(new RCPCompVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep p, A arg)
    { /* Code For RCPRep Goes Here */
      p.rcpproc_.accept(new RCPProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew p, A arg)
    { /* Code For RCPNew Goes Here */
      for (RCUName x: p.listrcuname_)
      { /* ... */ }
      p.rcpproc_.accept(new RCPProcVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RCPCompVisitor<R,A> implements RCPComp.Visitor<R,A>
  {
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero p, A arg)
    { /* Code For RCPZero Goes Here */
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp p, A arg)
    { /* Code For RCPInp Goes Here */
      p.rcuname_1.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_2.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcpproc_.accept(new RCPProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp p, A arg)
    { /* Code For RCPOutp Goes Here */
      p.rcuname_1.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_2.accept(new RCUNameVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RCYProcVisitor<R,A> implements RCYProc.Visitor<R,A>
  {
        public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar p, A arg)
    { /* Code For RCYPar Goes Here */
      p.rcyproc_1.accept(new RCYProcVisitor<R,A>(), arg);
      p.rcyproc_2.accept(new RCYProcVisitor<R,A>(), arg);
      return null;
    }        public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj p, A arg)
    { /* Code For RCYInj Goes Here */
      p.rcycomb_.accept(new RCYCombVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr p, A arg)
    { /* Code For RCYStr Goes Here */
      p.rcyproc_.accept(new RCYProcVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew p, A arg)
    { /* Code For RCYNew Goes Here */
      for (RCUName x: p.listrcuname_)
      { /* ... */ }
      p.rcyproc_.accept(new RCYProcVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RCYCombVisitor<R,A> implements RCYComb.Visitor<R,A>
  {
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero p, A arg)
    { /* Code For RCYZero Goes Here */
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg p, A arg)
    { /* Code For RCYMsg Goes Here */
      p.rcuname_1.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_2.accept(new RCUNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill p, A arg)
    { /* Code For RCYKill Goes Here */
      p.rcuname_.accept(new RCUNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup p, A arg)
    { /* Code For RCYDup Goes Here */
      p.rcuname_1.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_2.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_3.accept(new RCUNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq p, A arg)
    { /* Code For RCYSeq Goes Here */
      p.rcuname_1.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_2.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_3.accept(new RCUNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd p, A arg)
    { /* Code For RCYFwd Goes Here */
      p.rcuname_1.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_2.accept(new RCUNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl p, A arg)
    { /* Code For RCYBrl Goes Here */
      p.rcuname_1.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_2.accept(new RCUNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr p, A arg)
    { /* Code For RCYBrr Goes Here */
      p.rcuname_1.accept(new RCUNameVisitor<R,A>(), arg);
      p.rcuname_2.accept(new RCUNameVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RCUNameVisitor<R,A> implements RCUName.Visitor<R,A>
  {
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild p, A arg)
    { /* Code For RCUNWild Goes Here */
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar p, A arg)
    { /* Code For RCUNVar Goes Here */
      //p.var_;
      return null;
    }
  }
  public class RCRProcVisitor<R,A> implements RCRProc.Visitor<R,A>
  {
        public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar p, A arg)
    { /* Code For RCRPar Goes Here */
      p.rcrproc_1.accept(new RCRProcVisitor<R,A>(), arg);
      p.rcrproc_2.accept(new RCRProcVisitor<R,A>(), arg);
      return null;
    }        public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj p, A arg)
    { /* Code For RCRInj Goes Here */
      p.rcrcomb_.accept(new RCRCombVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr p, A arg)
    { /* Code For RCRStr Goes Here */
      p.rcrname_.accept(new RCRNameVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RCRCombVisitor<R,A> implements RCRComb.Visitor<R,A>
  {
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero p, A arg)
    { /* Code For RCRZero Goes Here */
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg p, A arg)
    { /* Code For RCRMsg Goes Here */
      p.rcrname_1.accept(new RCRNameVisitor<R,A>(), arg);
      p.rcrname_2.accept(new RCRNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill p, A arg)
    { /* Code For RCRKill Goes Here */
      p.rcrname_.accept(new RCRNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup p, A arg)
    { /* Code For RCRDup Goes Here */
      p.rcrname_1.accept(new RCRNameVisitor<R,A>(), arg);
      p.rcrname_2.accept(new RCRNameVisitor<R,A>(), arg);
      p.rcrname_3.accept(new RCRNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq p, A arg)
    { /* Code For RCRSeq Goes Here */
      p.rcrname_1.accept(new RCRNameVisitor<R,A>(), arg);
      p.rcrname_2.accept(new RCRNameVisitor<R,A>(), arg);
      p.rcrname_3.accept(new RCRNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd p, A arg)
    { /* Code For RCRFwd Goes Here */
      p.rcrname_1.accept(new RCRNameVisitor<R,A>(), arg);
      p.rcrname_2.accept(new RCRNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl p, A arg)
    { /* Code For RCRBrl Goes Here */
      p.rcrname_1.accept(new RCRNameVisitor<R,A>(), arg);
      p.rcrname_2.accept(new RCRNameVisitor<R,A>(), arg);
      return null;
    }    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr p, A arg)
    { /* Code For RCRBrr Goes Here */
      p.rcrname_1.accept(new RCRNameVisitor<R,A>(), arg);
      p.rcrname_2.accept(new RCRNameVisitor<R,A>(), arg);
      return null;
    }
  }
  public class RCRNameVisitor<R,A> implements RCRName.Visitor<R,A>
  {
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot p, A arg)
    { /* Code For RCRQuot Goes Here */
      p.rcrproc_.accept(new RCRProcVisitor<R,A>(), arg);
      return null;
    }
  }
}