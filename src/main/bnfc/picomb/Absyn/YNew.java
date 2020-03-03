package picomb.Absyn; // Java Package generated by the BNF Converter.

public class YNew  extends YProc {
  public final ListYName listyname_;
  public final YProc yproc_;
  public YNew(ListYName p1, YProc p2) { listyname_ = p1; yproc_ = p2; }

  public <R,A> R accept(picomb.Absyn.YProc.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof picomb.Absyn.YNew) {
      picomb.Absyn.YNew x = (picomb.Absyn.YNew)o;
      return this.listyname_.equals(x.listyname_) && this.yproc_.equals(x.yproc_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.listyname_.hashCode())+this.yproc_.hashCode();
  }


}