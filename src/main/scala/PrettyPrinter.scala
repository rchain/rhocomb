package coop.rchain.rhocomb.repl
/**
 * AST pretty-printing.
 */
object PrettyPrinter extends org.bitbucket.inkytonik.kiama.output.PrettyPrinter {

  /**
    * Return a pretty-printed version of a node.
    */
  def layout (t : RhoCombExp) : String =
    super.layout (show (t))

  /**
    * Convert an expression node to a pretty-printing document.
    */
  def show (t : RhoCombExp) : Doc =
    t match {
      case Num (d)             => value (d)
      case Add (l, r)          => showbin (l, "+", r)
      case Mul (l, r)          => showbin (l, "*", r)
      case RZeroExp            => "0"
      case RMsgExp( a, p )     => "m" <+> "(" <+> showName( a ) <+> "," <+> showName( p ) <+> ")"
      case RDupExp( a, b, c )  => "d" <+> "(" <+> showName( a ) <+> "," <+> showName( b ) <+> "," <+> showName( c ) <+> ")"
      case RKillExp( a )       => "k" <+> "(" <+> showName( a ) <+> ")"
      case RFwdExp( a, b )     => "fw" <+> "(" <+> showName( a ) <+> "," <+> showName( b ) <+> ")"
      case RBrlExp( a, b )     => "bl" <+> "(" <+> showName( a ) <+> "," <+> showName( b ) <+> ")"
      case RBrrExp( a, b )     => "br" <+> "(" <+> showName( a ) <+> "," <+> showName( b ) <+> ")"
      case RSeqExp( a, b, c )  => "s" <+> "(" <+> showName( a ) <+> "," <+> showName( b ) <+> "," <+> showName( c ) <+> ")"
      case rproc : RProcExp    => showProc( rproc )
    }

  def showProc( rproc : RProcExp ) : Doc = {
    rproc match {
      case RStrExp( a )    => "*" <+> showName( a )
      case RParExp( l, r ) => show( l ) <+> "|" <+> show( r )
    }
  }

  def showName( rproc : RNameExp ) : Doc = {
    rproc match {
      case RQuotExp( p )    => "@" <+> show( p )
      case _ => "???"
    }
  }

  /**
    * Return a pretty-printing document for an instance of a binary expression.
    */
  def showbin (l : RhoCombExp, op : String, r : RhoCombExp) : Doc =
    parens (show (l) <+> op <+> show (r))

}
