package rhocomb.Absyn; // Java Package generated by the BNF Converter.

public class RInj  extends RProc {
  public final RComb rcomb_;
  public RInj(RComb p1) { rcomb_ = p1; }

  public <R,A> R accept(rhocomb.Absyn.RProc.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof rhocomb.Absyn.RInj) {
      rhocomb.Absyn.RInj x = (rhocomb.Absyn.RInj)o;
      return this.rcomb_.equals(x.rcomb_);
    }
    return false;
  }

  public int hashCode() {
    return this.rcomb_.hashCode();
  }


}
