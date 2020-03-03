package asyncpi;
import asyncpi.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* PProc */

    public R visit(asyncpi.Absyn.PPar p, A arg) { return visitDefault(p, arg); }

    public R visit(asyncpi.Absyn.PInj p, A arg) { return visitDefault(p, arg); }
    public R visit(asyncpi.Absyn.PRep p, A arg) { return visitDefault(p, arg); }
    public R visit(asyncpi.Absyn.PNew p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(asyncpi.Absyn.PProc p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* PComp */
    public R visit(asyncpi.Absyn.PZero p, A arg) { return visitDefault(p, arg); }
    public R visit(asyncpi.Absyn.PInp p, A arg) { return visitDefault(p, arg); }
    public R visit(asyncpi.Absyn.POutp p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(asyncpi.Absyn.PComp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* PName */
    public R visit(asyncpi.Absyn.NWild p, A arg) { return visitDefault(p, arg); }
    public R visit(asyncpi.Absyn.NVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(asyncpi.Absyn.PName p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* PVar */
    public R visit(asyncpi.Absyn.PWild p, A arg) { return visitDefault(p, arg); }
    public R visit(asyncpi.Absyn.PVVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(asyncpi.Absyn.PVar p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
