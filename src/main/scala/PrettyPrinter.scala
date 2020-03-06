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
      case RCPInpExp( x, y, p )  => "for" <+> "(" <+> showRCPName( y ) <+> "<-" <+> showRCPName( x ) <+> showRCPProc( p ) <+> ")"
      case RCPOutpExp( x, y )    => showRCPName( x ) <+> "!" <+> "(" <+> showRCPName( y ) <+> ")"
      
      case RCYZeroExp            => "0"
      case RCYMsgExp( a, p )     => "m" <+> "(" <+> showRCYName( a ) <+> "," <+> showRCYName( p ) <+> ")"
      case RCYDupExp( a, b, c )  => "d" <+> "(" <+> showRCYName( a ) <+> "," <+> showRCYName( b ) <+> "," <+> showRCYName( c ) <+> ")"
      case RCYKillExp( a )       => "k" <+> "(" <+> showRCYName( a ) <+> ")"
      case RCYFwdExp( a, b )     => "fw" <+> "(" <+> showRCYName( a ) <+> "," <+> showRCYName( b ) <+> ")"
      case RCYBrlExp( a, b )     => "bl" <+> "(" <+> showRCYName( a ) <+> "," <+> showRCYName( b ) <+> ")"
      case RCYBrrExp( a, b )     => "br" <+> "(" <+> showRCYName( a ) <+> "," <+> showRCYName( b ) <+> ")"
      case RCYSeqExp( a, b, c )  => "s" <+> "(" <+> showRCYName( a ) <+> "," <+> showRCYName( b ) <+> "," <+> showRCYName( c ) <+> ")"

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
      case RCPNewExp( ns, p )    => "new" <+> showRCPNames( ns ) <+> "in" <+> showRCPProc( p )
      case RCPParExp( l, r )     => showRCPProc( l ) <+> "|" <+> showRCPProc( r )
    }
  }

  def showRCPName( rcpname : RCPNameExp ) : Doc = {
    rcpname match {
      case RCPWildExp            => "_"
      case RCPVarExp( id )       => id
      case _ => "???"
    }
  }

  def showRCPNames( rcpns : List[RCPNameExp] ) : Doc = {
    rcpns match {
      case Nil                   => ""
      case rcpname :: Nil        => showRCPName( rcpname )
      case rcpname :: rrcpns     => showRCPName( rcpname ) <+> "," <+> showRCPNames( rrcpns )
    }
  }

  def showRCYProc( rcyproc : RCYProcExp ) : Doc = {
    rcyproc match {
      case RCYStrExp( p )        => "*" <+> showRCYProc( p )
      case RCYNewExp( ns, p )    => "new" <+> showRCYNames( ns ) <+> "in" <+> showRCYProc( p )
      case RCYParExp( l, r )     => showRCYProc( l ) <+> "|" <+> showRCYProc( r )
    }
  }

  def showRCYName( rcyname : RCYNameExp ) : Doc = {
    rcyname match {
      case RCYWildExp            => "_"
      case RCYVarExp( id )       => id
      case _ => "???"
    }
  }

  def showRCYNames( rcyns : List[RCYNameExp] ) : Doc = {
    rcyns match {
      case Nil                   => ""
      case rcyname :: Nil        => showRCYName( rcyname )
      case rcyname :: rrcyns     => showRCYName( rcyname ) <+> "," <+> showRCYNames( rrcyns )
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
