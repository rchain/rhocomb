package coop.rchain.rhocomb.pi2rhocomb.Absyn; // Java Package generated by the BNF Converter.

public class RCYStr  extends RCYProc {
  public final RCYProc rcyproc_;
  public RCYStr(RCYProc p1) { rcyproc_ = p1; }

  public <R,A> R accept(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr) {
      coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr x = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr)o;
      return this.rcyproc_.equals(x.rcyproc_);
    }
    return false;
  }

  public int hashCode() {
    return this.rcyproc_.hashCode();
  }


}