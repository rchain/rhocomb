package rhocomb.Absyn; // Java Package generated by the BNF Converter.

public class RPar  extends RProc {
  public final RProc rproc_1, rproc_2;
  public RPar(RProc p1, RProc p2) { rproc_1 = p1; rproc_2 = p2; }

  public <R,A> R accept(rhocomb.Absyn.RProc.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof rhocomb.Absyn.RPar) {
      rhocomb.Absyn.RPar x = (rhocomb.Absyn.RPar)o;
      return this.rproc_1.equals(x.rproc_1) && this.rproc_2.equals(x.rproc_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.rproc_1.hashCode())+this.rproc_2.hashCode();
  }


}
