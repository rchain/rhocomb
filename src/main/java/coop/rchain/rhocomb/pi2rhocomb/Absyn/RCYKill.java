package coop.rchain.rhocomb.pi2rhocomb.Absyn; // Java Package generated by the BNF Converter.

public class RCYKill  extends RCYComb {
  public final RCUName rcuname_;
  public RCYKill(RCUName p1) { rcuname_ = p1; }

  public <R,A> R accept(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill) {
      coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill x = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill)o;
      return this.rcuname_.equals(x.rcuname_);
    }
    return false;
  }

  public int hashCode() {
    return this.rcuname_.hashCode();
  }


}
