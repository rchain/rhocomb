package picomb.Absyn; // Java Package generated by the BNF Converter.

public class YWild  extends YVar {
  public YWild() { }

  public <R,A> R accept(picomb.Absyn.YVar.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof picomb.Absyn.YWild) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}
