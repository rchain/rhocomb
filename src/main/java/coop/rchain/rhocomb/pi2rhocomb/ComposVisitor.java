package coop.rchain.rhocomb.pi2rhocomb;
import coop.rchain.rhocomb.pi2rhocomb.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  coop.rchain.rhocomb.pi2rhocomb.Absyn.Req.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.Req,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPProc.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPProc,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPComp.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPComp,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUName.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUName,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRProc.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRProc,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRName.Visitor<coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRName,A>
{
/* Req */
    public Req visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R p, A arg)
    {
      RCPProc rcpproc_ = p.rcpproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R(rcpproc_);
    }    public Req visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R p, A arg)
    {
      RCYProc rcyproc_ = p.rcyproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R(rcyproc_);
    }    public Req visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y p, A arg)
    {
      RCPProc rcpproc_ = p.rcpproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y(rcpproc_);
    }    public Req visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval p, A arg)
    {
      RCRProc rcrproc_ = p.rcrproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval(rcrproc_);
    }    public Req visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd p, A arg)
    {
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd();
    }
/* RCPProc */
    public RCPProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar p, A arg)
    {
      RCPProc rcpproc_1 = p.rcpproc_1.accept(this, arg);
      RCPProc rcpproc_2 = p.rcpproc_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar(rcpproc_1, rcpproc_2);
    }    public RCPProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj p, A arg)
    {
      RCPComp rcpcomp_ = p.rcpcomp_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj(rcpcomp_);
    }    public RCPProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep p, A arg)
    {
      RCPProc rcpproc_ = p.rcpproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep(rcpproc_);
    }    public RCPProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew p, A arg)
    {
      ListRCUName listrcuname_ = new ListRCUName();
      for (RCUName x : p.listrcuname_)
      {
        listrcuname_.add(x.accept(this,arg));
      }
      RCPProc rcpproc_ = p.rcpproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew(listrcuname_, rcpproc_);
    }
/* RCPComp */
    public RCPComp visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero p, A arg)
    {
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero();
    }    public RCPComp visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp p, A arg)
    {
      RCUName rcuname_1 = p.rcuname_1.accept(this, arg);
      RCUName rcuname_2 = p.rcuname_2.accept(this, arg);
      RCPProc rcpproc_ = p.rcpproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp(rcuname_1, rcuname_2, rcpproc_);
    }    public RCPComp visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp p, A arg)
    {
      RCUName rcuname_1 = p.rcuname_1.accept(this, arg);
      RCUName rcuname_2 = p.rcuname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp(rcuname_1, rcuname_2);
    }
/* RCYProc */
    public RCYProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar p, A arg)
    {
      RCYProc rcyproc_1 = p.rcyproc_1.accept(this, arg);
      RCYProc rcyproc_2 = p.rcyproc_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar(rcyproc_1, rcyproc_2);
    }    public RCYProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj p, A arg)
    {
      RCYComb rcycomb_ = p.rcycomb_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj(rcycomb_);
    }    public RCYProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr p, A arg)
    {
      RCYProc rcyproc_ = p.rcyproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr(rcyproc_);
    }    public RCYProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew p, A arg)
    {
      ListRCUName listrcuname_ = new ListRCUName();
      for (RCUName x : p.listrcuname_)
      {
        listrcuname_.add(x.accept(this,arg));
      }
      RCYProc rcyproc_ = p.rcyproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew(listrcuname_, rcyproc_);
    }
/* RCYComb */
    public RCYComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero p, A arg)
    {
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero();
    }    public RCYComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg p, A arg)
    {
      RCUName rcuname_1 = p.rcuname_1.accept(this, arg);
      RCUName rcuname_2 = p.rcuname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg(rcuname_1, rcuname_2);
    }    public RCYComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill p, A arg)
    {
      RCUName rcuname_ = p.rcuname_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill(rcuname_);
    }    public RCYComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup p, A arg)
    {
      RCUName rcuname_1 = p.rcuname_1.accept(this, arg);
      RCUName rcuname_2 = p.rcuname_2.accept(this, arg);
      RCUName rcuname_3 = p.rcuname_3.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup(rcuname_1, rcuname_2, rcuname_3);
    }    public RCYComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq p, A arg)
    {
      RCUName rcuname_1 = p.rcuname_1.accept(this, arg);
      RCUName rcuname_2 = p.rcuname_2.accept(this, arg);
      RCUName rcuname_3 = p.rcuname_3.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq(rcuname_1, rcuname_2, rcuname_3);
    }    public RCYComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd p, A arg)
    {
      RCUName rcuname_1 = p.rcuname_1.accept(this, arg);
      RCUName rcuname_2 = p.rcuname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd(rcuname_1, rcuname_2);
    }    public RCYComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl p, A arg)
    {
      RCUName rcuname_1 = p.rcuname_1.accept(this, arg);
      RCUName rcuname_2 = p.rcuname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl(rcuname_1, rcuname_2);
    }    public RCYComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr p, A arg)
    {
      RCUName rcuname_1 = p.rcuname_1.accept(this, arg);
      RCUName rcuname_2 = p.rcuname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr(rcuname_1, rcuname_2);
    }
/* RCUName */
    public RCUName visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild p, A arg)
    {
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild();
    }    public RCUName visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar p, A arg)
    {
      String var_ = p.var_;
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar(var_);
    }
/* RCRProc */
    public RCRProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar p, A arg)
    {
      RCRProc rcrproc_1 = p.rcrproc_1.accept(this, arg);
      RCRProc rcrproc_2 = p.rcrproc_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar(rcrproc_1, rcrproc_2);
    }    public RCRProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj p, A arg)
    {
      RCRComb rcrcomb_ = p.rcrcomb_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj(rcrcomb_);
    }    public RCRProc visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr p, A arg)
    {
      RCRName rcrname_ = p.rcrname_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr(rcrname_);
    }
/* RCRComb */
    public RCRComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero p, A arg)
    {
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero();
    }    public RCRComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg p, A arg)
    {
      RCRName rcrname_1 = p.rcrname_1.accept(this, arg);
      RCRName rcrname_2 = p.rcrname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg(rcrname_1, rcrname_2);
    }    public RCRComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill p, A arg)
    {
      RCRName rcrname_ = p.rcrname_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill(rcrname_);
    }    public RCRComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup p, A arg)
    {
      RCRName rcrname_1 = p.rcrname_1.accept(this, arg);
      RCRName rcrname_2 = p.rcrname_2.accept(this, arg);
      RCRName rcrname_3 = p.rcrname_3.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup(rcrname_1, rcrname_2, rcrname_3);
    }    public RCRComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq p, A arg)
    {
      RCRName rcrname_1 = p.rcrname_1.accept(this, arg);
      RCRName rcrname_2 = p.rcrname_2.accept(this, arg);
      RCRName rcrname_3 = p.rcrname_3.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq(rcrname_1, rcrname_2, rcrname_3);
    }    public RCRComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd p, A arg)
    {
      RCRName rcrname_1 = p.rcrname_1.accept(this, arg);
      RCRName rcrname_2 = p.rcrname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd(rcrname_1, rcrname_2);
    }    public RCRComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl p, A arg)
    {
      RCRName rcrname_1 = p.rcrname_1.accept(this, arg);
      RCRName rcrname_2 = p.rcrname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl(rcrname_1, rcrname_2);
    }    public RCRComb visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr p, A arg)
    {
      RCRName rcrname_1 = p.rcrname_1.accept(this, arg);
      RCRName rcrname_2 = p.rcrname_2.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr(rcrname_1, rcrname_2);
    }
/* RCRName */
    public RCRName visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot p, A arg)
    {
      RCRProc rcrproc_ = p.rcrproc_.accept(this, arg);
      return new coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot(rcrproc_);
    }
}