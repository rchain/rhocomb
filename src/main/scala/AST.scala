package coop.rchain.rhocomb.repl

/**
 * Node of abstract syntax tree.
 */
abstract class RhoCombExp

/**
 * Numeric literal expression.
 */
case class Num (i : Int) extends RhoCombExp

/**
 * Addition of two expressions.
 */
case class Add (l : RhoCombExp, r : RhoCombExp) extends RhoCombExp

/**
 * Multiplication of two expressions.
 */
case class Mul (l : RhoCombExp, r : RhoCombExp) extends RhoCombExp

trait RProcExp 
trait RCombExp extends RProcExp
trait RNameExp

case object RZeroExp                                             extends RhoCombExp with RCombExp
case class  RMsgExp ( a : RNameExp, p : RNameExp )               extends RhoCombExp with RCombExp
case class  RDupExp ( a : RNameExp, b : RNameExp, c : RNameExp ) extends RhoCombExp with RCombExp
case class  RKillExp( a : RNameExp )                             extends RhoCombExp with RCombExp
case class  RFwdExp ( a : RNameExp, b : RNameExp )               extends RhoCombExp with RCombExp
case class  RBrlExp ( a : RNameExp, b : RNameExp )               extends RhoCombExp with RCombExp
case class  RBrrExp ( a : RNameExp, b : RNameExp )               extends RhoCombExp with RCombExp
case class  RSeqExp ( a : RNameExp, b : RNameExp, c : RNameExp ) extends RhoCombExp with RCombExp

case class  RStrExp  ( a : RNameExp )                            extends RhoCombExp with RCombExp
case class  RParExp  ( l : RhoCombExp, r : RhoCombExp )          extends RhoCombExp with RProcExp

case class  RQuotExp( p : RhoCombExp )                           extends RNameExp
