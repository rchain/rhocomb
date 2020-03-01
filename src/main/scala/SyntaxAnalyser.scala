package coop.rchain.rhocomb.repl
import org.bitbucket.inkytonik.kiama.parsing.Parsers
import org.bitbucket.inkytonik.kiama.util.Positions

class SyntaxAnalyser (positions : Positions) extends Parsers (positions) {

    lazy val parser =
        phrase (exp)

    lazy val exp : PackratParser[RhoCombExp] =
        exp ~ ("+" ~> term) ^^ Add |
        term

    lazy val term : PackratParser[RhoCombExp] =
        term ~ ("*" ~> factor) ^^ Mul |
        factor

    lazy val factor : PackratParser[RhoCombExp] =
        integer | "(" ~> exp <~ ")"

    lazy val integer =
        "[0-9]+".r ^^ (s => Num (s.toInt))

}
