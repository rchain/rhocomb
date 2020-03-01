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

trait RProc
trait RComb extends RProc
trait RName

case object RZeroExp                                    extends RhoCombExp with RComb
case class  RMsgExp ( a : RName, p : RName )            extends RhoCombExp with RComb
case class  RDupExp ( a : RName, b : RName, c : RName ) extends RhoCombExp with RComb
case class  RKillExp( a : RName )                       extends RhoCombExp with RComb
case class  RFwdExp ( a : RName, b : RName )            extends RhoCombExp with RComb
case class  RBlExp  ( a : RName, b : RName )            extends RhoCombExp with RComb
case class  RBrExp  ( a : RName, b : RName )            extends RhoCombExp with RComb
case class  RSeqExp ( a : RName, b : RName, c : RName ) extends RhoCombExp with RComb

case class RStrExp  ( a : RName )                       extends RhoCombExp with RComb
case class RParExp  ( l : RhoCombExp, r : RhoCombExp )  extends RhoCombExp with RProc

case class RQuotExp( p : RhoCombExp )                   extends RName
