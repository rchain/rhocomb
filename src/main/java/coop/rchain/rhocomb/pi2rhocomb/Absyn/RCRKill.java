package coop.rchain.rhocomb.pi2rhocomb.Absyn; // Java Package generated by the BNF Converter.

public class RCRKill  extends RCRComb {
  public final RCRName rcrname_;
  public RCRKill(RCRName p1) { rcrname_ = p1; }

  public <R,A> R accept(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill) {
      coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill x = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill)o;
      return this.rcrname_.equals(x.rcrname_);
    }
    return false;
  }

  public int hashCode() {
    return this.rcrname_.hashCode();
  }


}