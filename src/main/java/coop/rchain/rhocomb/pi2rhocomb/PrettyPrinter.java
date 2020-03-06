package coop.rchain.rhocomb.pi2rhocomb;
import coop.rchain.rhocomb.pi2rhocomb.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.Req foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.Req foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPProc foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPProc foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPComp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPComp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.ListRCUName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.ListRCUName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRProc foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRProc foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.Req foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R _rqp2r = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R) foo;
       if (_i_ > 0) render(_L_PAREN);
       render(":rho");
       pp(_rqp2r.rcpproc_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R _rqy2r = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R) foo;
       if (_i_ > 0) render(_L_PAREN);
       render(":rho");
       pp(_rqy2r.rcyproc_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y _rqp2y = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y) foo;
       if (_i_ > 0) render(_L_PAREN);
       render(":cc");
       pp(_rqp2y.rcpproc_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval _rqeval = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rqeval.rcrproc_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd _rqcmd = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd) foo;
       if (_i_ > 0) render(_L_PAREN);
       render(":q");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPProc foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar _rcppar = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rcppar.rcpproc_1, 0);
       render("|");
       pp(_rcppar.rcpproc_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj _rcpinj = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_rcpinj.rcpcomp_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep _rcprep = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("*");
       pp(_rcprep.rcpproc_, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew _rcpnew = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("new");
       pp(_rcpnew.listrcuname_, 0);
       render("in");
       pp(_rcpnew.rcpproc_, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPComp foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero _rcpzero = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("0");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp _rcpinp = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("for");
       render("(");
       pp(_rcpinp.rcuname_1, 0);
       render("<-");
       pp(_rcpinp.rcuname_2, 0);
       render(")");
       pp(_rcpinp.rcpproc_, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp _rcpoutp = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rcpoutp.rcuname_1, 0);
       render("!");
       render("(");
       pp(_rcpoutp.rcuname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar _rcypar = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rcypar.rcyproc_1, 0);
       render("|");
       pp(_rcypar.rcyproc_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj _rcyinj = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_rcyinj.rcycomb_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr _rcystr = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("*");
       pp(_rcystr.rcyproc_, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew _rcynew = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("new");
       pp(_rcynew.listrcuname_, 0);
       render("in");
       pp(_rcynew.rcyproc_, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero _rcyzero = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("z");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg _rcymsg = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("m");
       render("(");
       pp(_rcymsg.rcuname_1, 0);
       render(",");
       pp(_rcymsg.rcuname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill _rcykill = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("k");
       render("(");
       pp(_rcykill.rcuname_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup _rcydup = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("d");
       render("(");
       pp(_rcydup.rcuname_1, 0);
       render(",");
       pp(_rcydup.rcuname_2, 0);
       render(",");
       pp(_rcydup.rcuname_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq _rcyseq = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("s");
       render("(");
       pp(_rcyseq.rcuname_1, 0);
       render(",");
       pp(_rcyseq.rcuname_2, 0);
       render(",");
       pp(_rcyseq.rcuname_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd _rcyfwd = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("fw");
       render("(");
       pp(_rcyfwd.rcuname_1, 0);
       render(",");
       pp(_rcyfwd.rcuname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl _rcybrl = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("bl");
       render("(");
       pp(_rcybrl.rcuname_1, 0);
       render(",");
       pp(_rcybrl.rcuname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr _rcybrr = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("br");
       render("(");
       pp(_rcybrr.rcuname_1, 0);
       render(",");
       pp(_rcybrr.rcuname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUName foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild _rcunwild = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("_");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar _rcunvar = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rcunvar.var_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.ListRCUName foo, int _i_)
  {
     for (java.util.Iterator<RCUName> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRProc foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar _rcrpar = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rcrpar.rcrproc_1, 0);
       render("|");
       pp(_rcrpar.rcrproc_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj _rcrinj = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_rcrinj.rcrcomb_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr _rcrstr = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("*");
       render("(");
       pp(_rcrstr.rcrname_, 0);
       render(")");
       if (_i_ > 1) render(_R_PAREN);
    }
  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero _rcrzero = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("0");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg _rcrmsg = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("m");
       render("(");
       pp(_rcrmsg.rcrname_1, 0);
       render(",");
       pp(_rcrmsg.rcrname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill _rcrkill = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("k");
       render("(");
       pp(_rcrkill.rcrname_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup _rcrdup = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("d");
       render("(");
       pp(_rcrdup.rcrname_1, 0);
       render(",");
       pp(_rcrdup.rcrname_2, 0);
       render(",");
       pp(_rcrdup.rcrname_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq _rcrseq = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("s");
       render("(");
       pp(_rcrseq.rcrname_1, 0);
       render(",");
       pp(_rcrseq.rcrname_2, 0);
       render(",");
       pp(_rcrseq.rcrname_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd _rcrfwd = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("fw");
       render("(");
       pp(_rcrfwd.rcrname_1, 0);
       render(",");
       pp(_rcrfwd.rcrname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl _rcrbrl = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("bl");
       render("(");
       pp(_rcrbrl.rcrname_1, 0);
       render(",");
       pp(_rcrbrl.rcrname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr _rcrbrr = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("br");
       render("(");
       pp(_rcrbrr.rcrname_1, 0);
       render(",");
       pp(_rcrbrr.rcrname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRName foo, int _i_)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot _rcrquot = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("@");
       pp(_rcrquot.rcrproc_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.Req foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R _rqp2r = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2R) foo;
       render("(");
       render("RqP2R");
       sh(_rqp2r.rcpproc_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R _rqy2r = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqY2R) foo;
       render("(");
       render("RqY2R");
       sh(_rqy2r.rcyproc_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y _rqp2y = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqP2Y) foo;
       render("(");
       render("RqP2Y");
       sh(_rqp2y.rcpproc_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval _rqeval = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqEval) foo;
       render("(");
       render("RqEval");
       sh(_rqeval.rcrproc_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd _rqcmd = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RqCmd) foo;
       render("RqCmd");
    }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPProc foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar _rcppar = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPPar) foo;
       render("(");
       render("RCPPar");
       sh(_rcppar.rcpproc_1);
       sh(_rcppar.rcpproc_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj _rcpinj = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInj) foo;
       render("(");
       render("RCPInj");
       sh(_rcpinj.rcpcomp_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep _rcprep = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPRep) foo;
       render("(");
       render("RCPRep");
       sh(_rcprep.rcpproc_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew _rcpnew = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPNew) foo;
       render("(");
       render("RCPNew");
       render("[");
       sh(_rcpnew.listrcuname_);
       render("]");
       sh(_rcpnew.rcpproc_);
       render(")");
    }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPComp foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero _rcpzero = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPZero) foo;
       render("RCPZero");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp _rcpinp = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPInp) foo;
       render("(");
       render("RCPInp");
       sh(_rcpinp.rcuname_1);
       sh(_rcpinp.rcuname_2);
       sh(_rcpinp.rcpproc_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp _rcpoutp = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPOutp) foo;
       render("(");
       render("RCPOutp");
       sh(_rcpoutp.rcuname_1);
       sh(_rcpoutp.rcuname_2);
       render(")");
    }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar _rcypar = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYPar) foo;
       render("(");
       render("RCYPar");
       sh(_rcypar.rcyproc_1);
       sh(_rcypar.rcyproc_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj _rcyinj = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYInj) foo;
       render("(");
       render("RCYInj");
       sh(_rcyinj.rcycomb_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr _rcystr = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYStr) foo;
       render("(");
       render("RCYStr");
       sh(_rcystr.rcyproc_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew _rcynew = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYNew) foo;
       render("(");
       render("RCYNew");
       render("[");
       sh(_rcynew.listrcuname_);
       render("]");
       sh(_rcynew.rcyproc_);
       render(")");
    }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero _rcyzero = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYZero) foo;
       render("RCYZero");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg _rcymsg = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYMsg) foo;
       render("(");
       render("RCYMsg");
       sh(_rcymsg.rcuname_1);
       sh(_rcymsg.rcuname_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill _rcykill = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYKill) foo;
       render("(");
       render("RCYKill");
       sh(_rcykill.rcuname_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup _rcydup = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYDup) foo;
       render("(");
       render("RCYDup");
       sh(_rcydup.rcuname_1);
       sh(_rcydup.rcuname_2);
       sh(_rcydup.rcuname_3);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq _rcyseq = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYSeq) foo;
       render("(");
       render("RCYSeq");
       sh(_rcyseq.rcuname_1);
       sh(_rcyseq.rcuname_2);
       sh(_rcyseq.rcuname_3);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd _rcyfwd = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYFwd) foo;
       render("(");
       render("RCYFwd");
       sh(_rcyfwd.rcuname_1);
       sh(_rcyfwd.rcuname_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl _rcybrl = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrl) foo;
       render("(");
       render("RCYBrl");
       sh(_rcybrl.rcuname_1);
       sh(_rcybrl.rcuname_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr _rcybrr = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYBrr) foo;
       render("(");
       render("RCYBrr");
       sh(_rcybrr.rcuname_1);
       sh(_rcybrr.rcuname_2);
       render(")");
    }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUName foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild _rcunwild = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNWild) foo;
       render("RCUNWild");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar _rcunvar = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCUNVar) foo;
       render("(");
       render("RCUNVar");
       sh(_rcunvar.var_);
       render(")");
    }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.ListRCUName foo)
  {
     for (java.util.Iterator<RCUName> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRProc foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar _rcrpar = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRPar) foo;
       render("(");
       render("RCRPar");
       sh(_rcrpar.rcrproc_1);
       sh(_rcrpar.rcrproc_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj _rcrinj = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRInj) foo;
       render("(");
       render("RCRInj");
       sh(_rcrinj.rcrcomb_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr _rcrstr = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRStr) foo;
       render("(");
       render("RCRStr");
       sh(_rcrstr.rcrname_);
       render(")");
    }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero _rcrzero = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRZero) foo;
       render("RCRZero");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg _rcrmsg = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRMsg) foo;
       render("(");
       render("RCRMsg");
       sh(_rcrmsg.rcrname_1);
       sh(_rcrmsg.rcrname_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill _rcrkill = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRKill) foo;
       render("(");
       render("RCRKill");
       sh(_rcrkill.rcrname_);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup _rcrdup = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRDup) foo;
       render("(");
       render("RCRDup");
       sh(_rcrdup.rcrname_1);
       sh(_rcrdup.rcrname_2);
       sh(_rcrdup.rcrname_3);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq _rcrseq = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRSeq) foo;
       render("(");
       render("RCRSeq");
       sh(_rcrseq.rcrname_1);
       sh(_rcrseq.rcrname_2);
       sh(_rcrseq.rcrname_3);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd _rcrfwd = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRFwd) foo;
       render("(");
       render("RCRFwd");
       sh(_rcrfwd.rcrname_1);
       sh(_rcrfwd.rcrname_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl _rcrbrl = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrl) foo;
       render("(");
       render("RCRBrl");
       sh(_rcrbrl.rcrname_1);
       sh(_rcrbrl.rcrname_2);
       render(")");
    }
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr _rcrbrr = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRBrr) foo;
       render("(");
       render("RCRBrr");
       sh(_rcrbrr.rcrname_1);
       sh(_rcrbrr.rcrname_2);
       render(")");
    }
  }

  private static void sh(coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRName foo)
  {
    if (foo instanceof coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot)
    {
       coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot _rcrquot = (coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRQuot) foo;
       render("(");
       render("RCRQuot");
       sh(_rcrquot.rcrproc_);
       render(")");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

