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
