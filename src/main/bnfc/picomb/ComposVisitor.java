package picomb;
import picomb.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  picomb.Absyn.YProc.Visitor<picomb.Absyn.YProc,A>,
  picomb.Absyn.YComb.Visitor<picomb.Absyn.YComb,A>,
  picomb.Absyn.YName.Visitor<picomb.Absyn.YName,A>,
  picomb.Absyn.YVar.Visitor<picomb.Absyn.YVar,A>
{
/* YProc */
    public YProc visit(picomb.Absyn.YPar p, A arg)
    {
      YProc yproc_1 = p.yproc_1.accept(this, arg);
      YProc yproc_2 = p.yproc_2.accept(this, arg);
      return new picomb.Absyn.YPar(yproc_1, yproc_2);
    }    public YProc visit(picomb.Absyn.YInj p, A arg)
    {
      YComb ycomb_ = p.ycomb_.accept(this, arg);
      return new picomb.Absyn.YInj(ycomb_);
    }    public YProc visit(picomb.Absyn.YStr p, A arg)
    {
      YProc yproc_ = p.yproc_.accept(this, arg);
      return new picomb.Absyn.YStr(yproc_);
    }    public YProc visit(picomb.Absyn.YNew p, A arg)
    {
      ListYName listyname_ = new ListYName();
      for (YName x : p.listyname_)
      {
        listyname_.add(x.accept(this,arg));
      }
      YProc yproc_ = p.yproc_.accept(this, arg);
      return new picomb.Absyn.YNew(listyname_, yproc_);
    }
/* YComb */
    public YComb visit(picomb.Absyn.YZero p, A arg)
    {
      return new picomb.Absyn.YZero();
    }    public YComb visit(picomb.Absyn.YMsg p, A arg)
    {
      YName yname_1 = p.yname_1.accept(this, arg);
      YName yname_2 = p.yname_2.accept(this, arg);
      return new picomb.Absyn.YMsg(yname_1, yname_2);
    }    public YComb visit(picomb.Absyn.YKill p, A arg)
    {
      YName yname_ = p.yname_.accept(this, arg);
      return new picomb.Absyn.YKill(yname_);
    }    public YComb visit(picomb.Absyn.YDup p, A arg)
    {
      YName yname_1 = p.yname_1.accept(this, arg);
      YName yname_2 = p.yname_2.accept(this, arg);
      YName yname_3 = p.yname_3.accept(this, arg);
      return new picomb.Absyn.YDup(yname_1, yname_2, yname_3);
    }    public YComb visit(picomb.Absyn.YSeq p, A arg)
    {
      YName yname_1 = p.yname_1.accept(this, arg);
      YName yname_2 = p.yname_2.accept(this, arg);
      YName yname_3 = p.yname_3.accept(this, arg);
      return new picomb.Absyn.YSeq(yname_1, yname_2, yname_3);
    }    public YComb visit(picomb.Absyn.YFwd p, A arg)
    {
      YName yname_1 = p.yname_1.accept(this, arg);
      YName yname_2 = p.yname_2.accept(this, arg);
      return new picomb.Absyn.YFwd(yname_1, yname_2);
    }    public YComb visit(picomb.Absyn.YBrl p, A arg)
    {
      YName yname_1 = p.yname_1.accept(this, arg);
      YName yname_2 = p.yname_2.accept(this, arg);
      return new picomb.Absyn.YBrl(yname_1, yname_2);
    }    public YComb visit(picomb.Absyn.YBrr p, A arg)
    {
      YName yname_1 = p.yname_1.accept(this, arg);
      YName yname_2 = p.yname_2.accept(this, arg);
      return new picomb.Absyn.YBrr(yname_1, yname_2);
    }
/* YName */
    public YName visit(picomb.Absyn.NWild p, A arg)
    {
      return new picomb.Absyn.NWild();
    }    public YName visit(picomb.Absyn.NVar p, A arg)
    {
      String cvar_ = p.cvar_;
      return new picomb.Absyn.NVar(cvar_);
    }
/* YVar */
    public YVar visit(picomb.Absyn.YWild p, A arg)
    {
      return new picomb.Absyn.YWild();
    }    public YVar visit(picomb.Absyn.YVVar p, A arg)
    {
      String cvar_ = p.cvar_;
      return new picomb.Absyn.YVVar(cvar_);
    }
}