package coop.rchain.rhocomb.repl

/**
 * Node of abstract syntax tree.
 */
abstract class RCRhoCombExp
trait ArithmeticExp

/**
 * Numeric literal expression.
 */
case class Num (i : Int) extends RCRhoCombExp with ArithmeticExp

/**
 * Addition of two expressions.
 */
case class Add (l : RCRhoCombExp, r : RCRhoCombExp) extends RCRhoCombExp with ArithmeticExp

/**
 * Multiplication of two expressions.
 */
case class Mul (l : RCRhoCombExp, r : RCRhoCombExp) extends RCRhoCombExp with ArithmeticExp

/**
 * Async Pi Calculus
 */

trait RCUNameExp
case object RCUWildExp                                                   extends RCUNameExp
case class  RCUVarExp ( id : String )                                    extends RCUNameExp

trait RCPProcExp
trait RCPCompExp extends RCPProcExp

case object RCPZeroExp                                                    extends RCRhoCombExp with RCPCompExp
case class  RCPInpExp  ( s : RCUNameExp, o : RCUNameExp, c : RCPProcExp ) extends RCRhoCombExp with RCPCompExp
case class  RCPOutpExp ( s : RCUNameExp, o : RCUNameExp )                 extends RCRhoCombExp with RCPCompExp

case class  RCPRepExp ( p : RCPProcExp )                                  extends RCRhoCombExp with RCPProcExp
case class  RCPNewExp ( ns : List[RCUNameExp], p : RCPProcExp )              extends RCRhoCombExp with RCPProcExp
case class  RCPParExp ( l : RCPProcExp, r : RCPProcExp )                  extends RCRhoCombExp with RCPProcExp

/**
 * (Honda) Yoshida Combinators
 */

trait RCYProcExp
trait RCYCombExp extends RCYProcExp

case object RCYZeroExp                                                   extends RCRhoCombExp with RCYCombExp
case class  RCYMsgExp ( a : RCUNameExp, p : RCUNameExp )                 extends RCRhoCombExp with RCYCombExp
case class  RCYDupExp ( a : RCUNameExp, b : RCUNameExp, c : RCUNameExp ) extends RCRhoCombExp with RCYCombExp
case class  RCYKillExp( a : RCUNameExp )                                 extends RCRhoCombExp with RCYCombExp
case class  RCYFwdExp ( a : RCUNameExp, b : RCUNameExp )                 extends RCRhoCombExp with RCYCombExp
case class  RCYBrlExp ( a : RCUNameExp, b : RCUNameExp )                 extends RCRhoCombExp with RCYCombExp
case class  RCYBrrExp ( a : RCUNameExp, b : RCUNameExp )                 extends RCRhoCombExp with RCYCombExp
case class  RCYSeqExp ( a : RCUNameExp, b : RCUNameExp, c : RCUNameExp ) extends RCRhoCombExp with RCYCombExp

case class  RCYStrExp ( p : RCYProcExp )                                 extends RCRhoCombExp with RCYProcExp
case class  RCYNewExp ( ns : List[RCUNameExp], p : RCYProcExp )          extends RCRhoCombExp with RCYProcExp
case class  RCYParExp ( l : RCYProcExp, r : RCYProcExp )                 extends RCRhoCombExp with RCYProcExp

/**
 * Rho Combinators
 */

trait RCRProcExp 
trait RCRCombExp extends RCRProcExp
trait RCRNameExp

case object RCRZeroExp                                                   extends RCRhoCombExp with RCRCombExp
case class  RCRMsgExp ( a : RCRNameExp, p : RCRNameExp )                 extends RCRhoCombExp with RCRCombExp
case class  RCRDupExp ( a : RCRNameExp, b : RCRNameExp, c : RCRNameExp ) extends RCRhoCombExp with RCRCombExp
case class  RCRKillExp( a : RCRNameExp )                                 extends RCRhoCombExp with RCRCombExp
case class  RCRFwdExp ( a : RCRNameExp, b : RCRNameExp )                 extends RCRhoCombExp with RCRCombExp
case class  RCRBrlExp ( a : RCRNameExp, b : RCRNameExp )                 extends RCRhoCombExp with RCRCombExp
case class  RCRBrrExp ( a : RCRNameExp, b : RCRNameExp )                 extends RCRhoCombExp with RCRCombExp
case class  RCRSeqExp ( a : RCRNameExp, b : RCRNameExp, c : RCRNameExp ) extends RCRhoCombExp with RCRCombExp

case class  RCRStrExp  ( a : RCRNameExp )                                extends RCRhoCombExp with RCRProcExp
case class  RCRParExp  ( l : RCRhoCombExp, r : RCRhoCombExp )            extends RCRhoCombExp with RCRProcExp

case class  RCRQuotExp( p : RCRhoCombExp )                               extends RCRNameExp

/**
 * User requests
 */

trait RCTranslationReq
trait RCREPLReq

case object Quit extends RCRhoCombExp with RCREPLReq
case class RCPiToRho( proc : RCPProcExp ) extends RCRhoCombExp with RCTranslationReq
case class RCYToRho( proc : RCYProcExp ) extends RCRhoCombExp with RCTranslationReq
case class RCPiToY( proc : RCPProcExp ) extends RCRhoCombExp with RCTranslationReq
case class RCEval( proc : RCRhoCombExp ) extends RCRhoCombExp with RCTranslationReq
