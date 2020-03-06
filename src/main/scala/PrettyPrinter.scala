package coop.rchain.rhocomb.repl
/**
 * AST pretty-printing.
 */
object PrettyPrinter extends org.bitbucket.inkytonik.kiama.output.PrettyPrinter {

  /**
    * Return a pretty-printed version of a node.
    */
  def layout (t : RCRhoCombExp) : String =
    super.layout (show (t))

  /**
    * Convert an expression node to a pretty-printing document.
    */
  def show (t : RCRhoCombExp) : Doc =
    t match {
      case Num (d)               => value (d)
      case Add (l, r)            => showbin (l, "+", r)
      case Mul (l, r)            => showbin (l, "*", r)
      case RCPZeroExp            => "0"
      case RCPInpExp( x, y, p )  => "for" <+> "(" <+> showRCUName( y ) <+> "<-" <+> showRCUName( x ) <+> showRCPProc( p ) <+> ")"
      case RCPOutpExp( x, y )    => showRCUName( x ) <+> "!" <+> "(" <+> showRCUName( y ) <+> ")"
      
      case RCYZeroExp            => "0"
      case RCYMsgExp( a, p )     => "m" <+> "(" <+> showRCUName( a ) <+> "," <+> showRCUName( p ) <+> ")"
      case RCYDupExp( a, b, c )  => "d" <+> "(" <+> showRCUName( a ) <+> "," <+> showRCUName( b ) <+> "," <+> showRCUName( c ) <+> ")"
      case RCYKillExp( a )       => "k" <+> "(" <+> showRCUName( a ) <+> ")"
      case RCYFwdExp( a, b )     => "fw" <+> "(" <+> showRCUName( a ) <+> "," <+> showRCUName( b ) <+> ")"
      case RCYBrlExp( a, b )     => "bl" <+> "(" <+> showRCUName( a ) <+> "," <+> showRCUName( b ) <+> ")"
      case RCYBrrExp( a, b )     => "br" <+> "(" <+> showRCUName( a ) <+> "," <+> showRCUName( b ) <+> ")"
      case RCYSeqExp( a, b, c )  => "s" <+> "(" <+> showRCUName( a ) <+> "," <+> showRCUName( b ) <+> "," <+> showRCUName( c ) <+> ")"

      case RCRZeroExp            => "0"
      case RCRMsgExp( a, p )     => "m" <+> "(" <+> showRCRName( a ) <+> "," <+> showRCRName( p ) <+> ")"
      case RCRDupExp( a, b, c )  => "d" <+> "(" <+> showRCRName( a ) <+> "," <+> showRCRName( b ) <+> "," <+> showRCRName( c ) <+> ")"
      case RCRKillExp( a )       => "k" <+> "(" <+> showRCRName( a ) <+> ")"
      case RCRFwdExp( a, b )     => "fw" <+> "(" <+> showRCRName( a ) <+> "," <+> showRCRName( b ) <+> ")"
      case RCRBrlExp( a, b )     => "bl" <+> "(" <+> showRCRName( a ) <+> "," <+> showRCRName( b ) <+> ")"
      case RCRBrrExp( a, b )     => "br" <+> "(" <+> showRCRName( a ) <+> "," <+> showRCRName( b ) <+> ")"
      case RCRSeqExp( a, b, c )  => "s" <+> "(" <+> showRCRName( a ) <+> "," <+> showRCRName( b ) <+> "," <+> showRCRName( c ) <+> ")"

      case rcpproc : RCPProcExp  => showRCPProc( rcpproc )
      case rcyproc : RCYProcExp  => showRCYProc( rcyproc )      
      case rcrproc : RCRProcExp  => showRCRProc( rcrproc )
    }

  def showRCPProc( rcpproc : RCPProcExp ) : Doc = {
    rcpproc match {
      case RCPRepExp( p )        => "*" <+> showRCPProc( p )
      case RCPNewExp( ns, p )    => "new" <+> showRCUNames( ns ) <+> "in" <+> showRCPProc( p )
      case RCPParExp( l, r )     => showRCPProc( l ) <+> "|" <+> showRCPProc( r )
    }
  }

  def showRCUName( rcpname : RCUNameExp ) : Doc = {
    rcpname match {
      case RCUWildExp            => "_"
      case RCUVarExp( id )       => id
      case _ => "???"
    }
  }

  def showRCUNames( rcpns : List[RCUNameExp] ) : Doc = {
    rcpns match {
      case Nil                   => ""
      case rcpname :: Nil        => showRCUName( rcpname )
      case rcpname :: rrcpns     => showRCUName( rcpname ) <+> "," <+> showRCUNames( rrcpns )
    }
  }

  def showRCYProc( rcyproc : RCYProcExp ) : Doc = {
    rcyproc match {
      case RCYStrExp( p )        => "*" <+> showRCYProc( p )
      case RCYNewExp( ns, p )    => "new" <+> showRCUNames( ns ) <+> "in" <+> showRCYProc( p )
      case RCYParExp( l, r )     => showRCYProc( l ) <+> "|" <+> showRCYProc( r )
    }
  }
  
  def showRCRProc( rproc : RCRProcExp ) : Doc = {
    rproc match {
      case RCRStrExp( a )    => "*" <+> showRCRName( a )
      case RCRParExp( l, r ) => show( l ) <+> "|" <+> show( r )
    }
  }

  def showRCRName( rproc : RCRNameExp ) : Doc = {
    rproc match {
      case RCRQuotExp( p )    => "@" <+> show( p )
      case _ => "???"
    }
  }

  /**
    * Return a pretty-printing document for an instance of a binary expression.
    */
  def showbin (l : RCRhoCombExp, op : String, r : RCRhoCombExp) : Doc =
    parens (show (l) <+> op <+> show (r))

}
