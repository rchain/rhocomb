package coop.rchain.rhocomb.pi2rhocomb.Absyn; // Java Package generated by the BNF Converter.

public class RCUNWild  extends RCUName {
  public RCUNWild() { }

  public <R,A> R accept(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUName.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}