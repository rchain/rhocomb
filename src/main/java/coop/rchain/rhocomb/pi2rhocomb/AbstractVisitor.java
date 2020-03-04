package coop.rchain.rhocomb.pi2rhocomb;
import coop.rchain.rhocomb.pi2rhocomb.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Req */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.Req p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCPProc */

    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar p, A arg) { return visitDefault(p, arg); }

    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPProc p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCPComp */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPComp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCPName */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNWild p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPName p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCPVar */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPWild p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPVVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPVar p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCYProc */

    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar p, A arg) { return visitDefault(p, arg); }

    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCYComb */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCYName */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNWild p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYName p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCYVar */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPYWild p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPYVVar p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYVar p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCRProc */

    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar p, A arg) { return visitDefault(p, arg); }

    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRProc p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCRComb */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl p, A arg) { return visitDefault(p, arg); }
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* RCRName */
    public R visit(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRName p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
