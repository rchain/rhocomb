package rhocomb;
import rhocomb.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  rhocomb.Absyn.RProc.Visitor<rhocomb.Absyn.RProc,A>,
  rhocomb.Absyn.RComb.Visitor<rhocomb.Absyn.RComb,A>,
  rhocomb.Absyn.RName.Visitor<rhocomb.Absyn.RName,A>
{
/* RProc */
    public RProc visit(rhocomb.Absyn.RPar p, A arg)
    {
      RProc rproc_1 = p.rproc_1.accept(this, arg);
      RProc rproc_2 = p.rproc_2.accept(this, arg);
      return new rhocomb.Absyn.RPar(rproc_1, rproc_2);
    }    public RProc visit(rhocomb.Absyn.RInj p, A arg)
    {
      RComb rcomb_ = p.rcomb_.accept(this, arg);
      return new rhocomb.Absyn.RInj(rcomb_);
    }    public RProc visit(rhocomb.Absyn.RStr p, A arg)
    {
      RName rname_ = p.rname_.accept(this, arg);
      return new rhocomb.Absyn.RStr(rname_);
    }
/* RComb */
    public RComb visit(rhocomb.Absyn.RZero p, A arg)
    {
      return new rhocomb.Absyn.RZero();
    }    public RComb visit(rhocomb.Absyn.RMsg p, A arg)
    {
      RName rname_1 = p.rname_1.accept(this, arg);
      RName rname_2 = p.rname_2.accept(this, arg);
      return new rhocomb.Absyn.RMsg(rname_1, rname_2);
    }    public RComb visit(rhocomb.Absyn.RKill p, A arg)
    {
      RName rname_ = p.rname_.accept(this, arg);
      return new rhocomb.Absyn.RKill(rname_);
    }    public RComb visit(rhocomb.Absyn.RDup p, A arg)
    {
      RName rname_1 = p.rname_1.accept(this, arg);
      RName rname_2 = p.rname_2.accept(this, arg);
      RName rname_3 = p.rname_3.accept(this, arg);
      return new rhocomb.Absyn.RDup(rname_1, rname_2, rname_3);
    }    public RComb visit(rhocomb.Absyn.RSeq p, A arg)
    {
      RName rname_1 = p.rname_1.accept(this, arg);
      RName rname_2 = p.rname_2.accept(this, arg);
      RName rname_3 = p.rname_3.accept(this, arg);
      return new rhocomb.Absyn.RSeq(rname_1, rname_2, rname_3);
    }    public RComb visit(rhocomb.Absyn.RFwd p, A arg)
    {
      RName rname_1 = p.rname_1.accept(this, arg);
      RName rname_2 = p.rname_2.accept(this, arg);
      return new rhocomb.Absyn.RFwd(rname_1, rname_2);
    }    public RComb visit(rhocomb.Absyn.RBrl p, A arg)
    {
      RName rname_1 = p.rname_1.accept(this, arg);
      RName rname_2 = p.rname_2.accept(this, arg);
      return new rhocomb.Absyn.RBrl(rname_1, rname_2);
    }    public RComb visit(rhocomb.Absyn.RBrr p, A arg)
    {
      RName rname_1 = p.rname_1.accept(this, arg);
      RName rname_2 = p.rname_2.accept(this, arg);
      return new rhocomb.Absyn.RBrr(rname_1, rname_2);
    }
/* RName */
    public RName visit(rhocomb.Absyn.RQuot p, A arg)
    {
      RProc rproc_ = p.rproc_.accept(this, arg);
      return new rhocomb.Absyn.RQuot(rproc_);
    }
}