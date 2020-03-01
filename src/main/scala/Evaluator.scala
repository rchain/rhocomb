package coop.rchain.rhocomb.repl

import org.bitbucket.inkytonik.kiama.attribution.Attribution

/**
 * Use attribution to evaluate an expression.
 */
object Evaluator extends Attribution {

    val value : RhoCombExp => Int =
        attr {
            case Num (i)    => i
            case Add (l, r) => value (l) + value (r)
            case Mul (l, r) => value (l) * value (r)
        }

}
