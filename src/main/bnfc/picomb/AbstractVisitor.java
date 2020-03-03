package picomb;
import picomb.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* YProc */

    public R visit(picomb.Absyn.YPar p, A arg) { return visitDefault(p, arg); }

    public R visit(picomb.Absyn.YInj p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YStr p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YNew p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(picomb.Absyn.YProc p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* YComb */
    public R visit(picomb.Absyn.YZero p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YMsg p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YKill p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YDup p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YSeq p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YFwd p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YBrl p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YBrr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(picomb.Absyn.YComb p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* YName */
    public R visit(picomb.Absyn.NWild p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.NVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(picomb.Absyn.YName p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* YVar */
    public R visit(picomb.Absyn.YWild p, A arg) { return visitDefault(p, arg); }
    public R visit(picomb.Absyn.YVVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(picomb.Absyn.YVar p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
