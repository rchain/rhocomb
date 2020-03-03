package asyncpi;
import asyncpi.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  asyncpi.Absyn.PProc.Visitor<asyncpi.Absyn.PProc,A>,
  asyncpi.Absyn.PComp.Visitor<asyncpi.Absyn.PComp,A>,
  asyncpi.Absyn.PName.Visitor<asyncpi.Absyn.PName,A>,
  asyncpi.Absyn.PVar.Visitor<asyncpi.Absyn.PVar,A>
{
/* PProc */
    public PProc visit(asyncpi.Absyn.PPar p, A arg)
    {
      PProc pproc_1 = p.pproc_1.accept(this, arg);
      PProc pproc_2 = p.pproc_2.accept(this, arg);
      return new asyncpi.Absyn.PPar(pproc_1, pproc_2);
    }    public PProc visit(asyncpi.Absyn.PInj p, A arg)
    {
      PComp pcomp_ = p.pcomp_.accept(this, arg);
      return new asyncpi.Absyn.PInj(pcomp_);
    }    public PProc visit(asyncpi.Absyn.PRep p, A arg)
    {
      PProc pproc_ = p.pproc_.accept(this, arg);
      return new asyncpi.Absyn.PRep(pproc_);
    }    public PProc visit(asyncpi.Absyn.PNew p, A arg)
    {
      ListPName listpname_ = new ListPName();
      for (PName x : p.listpname_)
      {
        listpname_.add(x.accept(this,arg));
      }
      PProc pproc_ = p.pproc_.accept(this, arg);
      return new asyncpi.Absyn.PNew(listpname_, pproc_);
    }
/* PComp */
    public PComp visit(asyncpi.Absyn.PZero p, A arg)
    {
      return new asyncpi.Absyn.PZero();
    }    public PComp visit(asyncpi.Absyn.PInp p, A arg)
    {
      PName pname_1 = p.pname_1.accept(this, arg);
      PName pname_2 = p.pname_2.accept(this, arg);
      PProc pproc_ = p.pproc_.accept(this, arg);
      return new asyncpi.Absyn.PInp(pname_1, pname_2, pproc_);
    }    public PComp visit(asyncpi.Absyn.POutp p, A arg)
    {
      PName pname_1 = p.pname_1.accept(this, arg);
      PName pname_2 = p.pname_2.accept(this, arg);
      return new asyncpi.Absyn.POutp(pname_1, pname_2);
    }
/* PName */
    public PName visit(asyncpi.Absyn.NWild p, A arg)
    {
      return new asyncpi.Absyn.NWild();
    }    public PName visit(asyncpi.Absyn.NVar p, A arg)
    {
      String var_ = p.var_;
      return new asyncpi.Absyn.NVar(var_);
    }
/* PVar */
    public PVar visit(asyncpi.Absyn.PWild p, A arg)
    {
      return new asyncpi.Absyn.PWild();
    }    public PVar visit(asyncpi.Absyn.PVVar p, A arg)
    {
      String var_ = p.var_;
      return new asyncpi.Absyn.PVVar(var_);
    }
}