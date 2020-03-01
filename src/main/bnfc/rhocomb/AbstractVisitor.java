package rhocomb;
import rhocomb.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* RProc */

    public R visit(rhocomb.Absyn.RPar p, A arg) { return visitDefault(p, arg); }

    public R visit(rhocomb.Absyn.RInj p, A arg) { return visitDefault(p, arg); }
    public R visit(rhocomb.Absyn.RStr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(rhocomb.Absyn.RProc p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RComb */
    public R visit(rhocomb.Absyn.RZero p, A arg) { return visitDefault(p, arg); }
    public R visit(rhocomb.Absyn.RMsg p, A arg) { return visitDefault(p, arg); }
    public R visit(rhocomb.Absyn.RKill p, A arg) { return visitDefault(p, arg); }
    public R visit(rhocomb.Absyn.RDup p, A arg) { return visitDefault(p, arg); }
    public R visit(rhocomb.Absyn.RSeq p, A arg) { return visitDefault(p, arg); }
    public R visit(rhocomb.Absyn.RFwd p, A arg) { return visitDefault(p, arg); }
    public R visit(rhocomb.Absyn.RBrl p, A arg) { return visitDefault(p, arg); }
    public R visit(rhocomb.Absyn.RBrr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(rhocomb.Absyn.RComb p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RName */
    public R visit(rhocomb.Absyn.RQuot p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(rhocomb.Absyn.RName p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
