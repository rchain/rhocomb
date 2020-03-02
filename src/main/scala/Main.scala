package coop.rchain.rhocomb.repl
import org.bitbucket.inkytonik.kiama.util.ParsingREPL
import org.bitbucket.inkytonik.kiama.util.REPLConfig

import rhocomb._;
import rhocomb.Absyn._;
import java.io._;
import java_cup.runtime._;

/**
 * A top-level read-eval-print loop.  Reads a simple arithmetic expression
 * and prints it, its value and variants.  E.g.
 *
 * exp> 0 + 4 * 1
 * e = Add(Num(0),Mul(Num(4),Num(1)))
 * e tree:
 * Add (Num (0), Mul (Num (4), Num (1)))
 * e tree pretty printed:
 * (0 + (4 * 1))
 * value (e) = 4
 * e optimised = Num(4)
 * value (e optimised) = 4
 */
object Main extends ParsingREPL[RhoCombExp] {

  import org.bitbucket.inkytonik.kiama.util.{REPLConfig, Source}
  import org.bitbucket.inkytonik.kiama.parsing.{NoSuccess, ParseResult, Success}
  import org.bitbucket.inkytonik.kiama.util.Messaging.{message, Messages}

  import Evaluator.value
  import Evaluator.reduce
  import PrettyPrinter.{any, layout}
  import Optimiser.optimise
  import Optimiser.normalizeProcess

  val parsers = new SyntaxAnalyser (positions)
  val parser = parsers.exp

  val banner =
    """Enter expressions using numbers, addition and multiplication.
          |  e.g., (1 + 2) * 3 or 0 + 4 * 1
          |""".stripMargin

  override def prompt () = "exp> "

  /**
    * Print the expression as a value, as a tree, pretty printed.
    * Print its value. Optimise it and then print the optimised
    * expression and its value.
    */
  override def process (source : Source, e : RhoCombExp, config : REPLConfig) {
    val output = config.output()
    output.emitln ("e = " + e)
    output.emitln ("e tree:")
    output.emitln (layout (any (e)))
    output.emitln ("e tree pretty printed:")
    output.emitln (layout (e))

    e match {
      case _ : ArithmeticExp => {
        output.emitln ("value (e) = " + value (e))
        val o = optimise (e)
        output.emitln ("e optimised = " + o)
        output.emitln ("value (e optimised) = " + value (o))
      }
      case rproc : RProcExp => {
        output.emitln ( s"reduction (${rproc}) = ${reduce (rproc)}" )
      }
    }
  }

  override def processline(
    source  : org.bitbucket.inkytonik.kiama.util.Source,
    console : org.bitbucket.inkytonik.kiama.util.Console,
    config  : org.bitbucket.inkytonik.kiama.util.REPLConfig
  ) : Option[org.bitbucket.inkytonik.kiama.util.REPLConfig] = {
    if (config.processWhitespaceLines() || (source.content.trim.length != 0)) {
      try {
        val l   = new Yylex( new StringReader( source.content ) )
        val p   = new parser(l, l.getSymbolFactory())
        val ast = p.pRProc()
        process( source, normalizeProcess( ast ), config )
      }
      catch {
        case except : Throwable => {
          parsers.parseAll(parser, source) match {
            case Success(e, _) =>
              process(source, e, config)
            case res : NoSuccess =>
              val pos = res.next.position
              positions.setStart(res, pos)
              positions.setFinish(res, pos)
              val messages = message(res, res.message)
              report(messages, config.output())
          }
        }
      }      
    }
    Some(config)
  }

}
