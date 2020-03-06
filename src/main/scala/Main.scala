package coop.rchain.rhocomb.repl
import org.bitbucket.inkytonik.kiama.util.ParsingREPL
import org.bitbucket.inkytonik.kiama.util.REPLConfig

import coop.rchain.rhocomb.pi2rhocomb._;
import coop.rchain.rhocomb.pi2rhocomb.Absyn._;
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
object Main extends ParsingREPL[RCRhoCombExp] {

  import org.bitbucket.inkytonik.kiama.util.{REPLConfig, Source}
  import org.bitbucket.inkytonik.kiama.parsing.{NoSuccess, ParseResult, Success}
  import org.bitbucket.inkytonik.kiama.util.Messaging.{message, Messages}

  import Evaluator.value
  import Evaluator.reduce
  import Evaluator.txPiToRho
  import Evaluator.txPiToY
  import Evaluator.txYToRho
  import PrettyPrinter.{any, layout}
  import Optimiser.optimise
  import Optimiser.normalizeRCRequest

  val parsers = new SyntaxAnalyser (positions)
  val parser = parsers.exp

  val banner =
    """Enter expressions using the rho combinators.
          |  e.g., k(@0)|m(@0,@0)
          |""".stripMargin
  val lvl : Int = 0

  override def prompt () = "rho> "

  /**
    * Print the expression as a value, as a tree, pretty printed.
    * Print its value. Optimise it and then print the optimised
    * expression and its value.
    */
  override def process (source : Source, e : RCRhoCombExp, config : REPLConfig) {
    val output = config.output()
    lvl match {
      case l2 if l2 > 2 => {
        output.emitln ("e = " + e)
        output.emitln ("e tree:")
        output.emitln (layout (any (e)))
        output.emitln ("e tree pretty printed:")

        val ppE = layout (e)
        output.emitln (ppE)
      }
      case _ => { }
    }

    e match {
      case RCPiToRho( rcpproc ) => {
        //output.emitln ( s"in rproc case" )
        output.emitln ( s"${layout( txPiToRho ( rcpproc ) )}" )
      }
      case RCYToRho( rcyproc ) => {
        //output.emitln ( s"in rproc case" )
        output.emitln ( s"${layout( txYToRho ( rcyproc ) )}" )
      }
      case RCPiToY( rcpproc ) => {
        //output.emitln ( s"in rproc case" )
        output.emitln ( s"${layout( txPiToY ( rcpproc ) )}" )
      }
      case RCEval( rcrproc ) => {
        //output.emitln ( s"in rproc case" )
        output.emitln ( s"${layout( reduce ( rcrproc ) )}" )
      }
      case Quit => {
        output.emitln ( s"exiting..." )
      }
      case _ : ArithmeticExp => {
        output.emitln ("value (e) = " + value (e))
        val o = optimise (e)
        output.emitln ("e optimised = " + o)
        output.emitln ("value (e optimised) = " + value (o))
      }     
    }
  }

  override def processline(
    source  : org.bitbucket.inkytonik.kiama.util.Source,
    console : org.bitbucket.inkytonik.kiama.util.Console,
    config  : org.bitbucket.inkytonik.kiama.util.REPLConfig
  ) : Option[org.bitbucket.inkytonik.kiama.util.REPLConfig] = {
    val output = config.output()
    if (config.processWhitespaceLines() || (source.content.trim.length != 0)) {
      try {
        //output.emitln( "trying rproc parse first" )
        val l   = new Yylex( new StringReader( source.content ) )
        val p   = new parser(l, l.getSymbolFactory())
        //val ast = p.pRProc()
        val ast = p.pReq()
        //process( source, normalizeProcess( ast ), config )
        process( source, normalizeRCRequest( ast ), config )
      }
      catch {
        case except : Throwable => {
          //output.emitln( s"${except}" )
          //output.emitln( "failed rproc parse; trying arithmetic parse" )
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
