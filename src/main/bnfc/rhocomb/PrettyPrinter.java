package rhocomb;
import rhocomb.Absyn.*;

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
  public static String print(rhocomb.Absyn.RProc foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(rhocomb.Absyn.RProc foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(rhocomb.Absyn.RComb foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(rhocomb.Absyn.RComb foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(rhocomb.Absyn.RName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(rhocomb.Absyn.RName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(rhocomb.Absyn.RProc foo, int _i_)
  {
    if (foo instanceof rhocomb.Absyn.RPar)
    {
       rhocomb.Absyn.RPar _rpar = (rhocomb.Absyn.RPar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_rpar.rproc_1, 0);
       render("|");
       pp(_rpar.rproc_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RInj)
    {
       rhocomb.Absyn.RInj _rinj = (rhocomb.Absyn.RInj) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_rinj.rcomb_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RStr)
    {
       rhocomb.Absyn.RStr _rstr = (rhocomb.Absyn.RStr) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("*");
       render("(");
       pp(_rstr.rname_, 0);
       render(")");
       if (_i_ > 1) render(_R_PAREN);
    }
  }

  private static void pp(rhocomb.Absyn.RComb foo, int _i_)
  {
    if (foo instanceof rhocomb.Absyn.RZero)
    {
       rhocomb.Absyn.RZero _rzero = (rhocomb.Absyn.RZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("0");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RMsg)
    {
       rhocomb.Absyn.RMsg _rmsg = (rhocomb.Absyn.RMsg) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("m");
       render("(");
       pp(_rmsg.rname_1, 0);
       render(",");
       pp(_rmsg.rname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RKill)
    {
       rhocomb.Absyn.RKill _rkill = (rhocomb.Absyn.RKill) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("k");
       render("(");
       pp(_rkill.rname_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RDup)
    {
       rhocomb.Absyn.RDup _rdup = (rhocomb.Absyn.RDup) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("d");
       render("(");
       pp(_rdup.rname_1, 0);
       render(",");
       pp(_rdup.rname_2, 0);
       render(",");
       pp(_rdup.rname_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RSeq)
    {
       rhocomb.Absyn.RSeq _rseq = (rhocomb.Absyn.RSeq) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("s");
       render("(");
       pp(_rseq.rname_1, 0);
       render(",");
       pp(_rseq.rname_2, 0);
       render(",");
       pp(_rseq.rname_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RFwd)
    {
       rhocomb.Absyn.RFwd _rfwd = (rhocomb.Absyn.RFwd) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("fw");
       render("(");
       pp(_rfwd.rname_1, 0);
       render(",");
       pp(_rfwd.rname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RBrl)
    {
       rhocomb.Absyn.RBrl _rbrl = (rhocomb.Absyn.RBrl) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("bl");
       render("(");
       pp(_rbrl.rname_1, 0);
       render(",");
       pp(_rbrl.rname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof rhocomb.Absyn.RBrr)
    {
       rhocomb.Absyn.RBrr _rbrr = (rhocomb.Absyn.RBrr) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("br");
       render("(");
       pp(_rbrr.rname_1, 0);
       render(",");
       pp(_rbrr.rname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(rhocomb.Absyn.RName foo, int _i_)
  {
    if (foo instanceof rhocomb.Absyn.RQuot)
    {
       rhocomb.Absyn.RQuot _rquot = (rhocomb.Absyn.RQuot) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("@");
       pp(_rquot.rproc_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(rhocomb.Absyn.RProc foo)
  {
    if (foo instanceof rhocomb.Absyn.RPar)
    {
       rhocomb.Absyn.RPar _rpar = (rhocomb.Absyn.RPar) foo;
       render("(");
       render("RPar");
       sh(_rpar.rproc_1);
       sh(_rpar.rproc_2);
       render(")");
    }
    if (foo instanceof rhocomb.Absyn.RInj)
    {
       rhocomb.Absyn.RInj _rinj = (rhocomb.Absyn.RInj) foo;
       render("(");
       render("RInj");
       sh(_rinj.rcomb_);
       render(")");
    }
    if (foo instanceof rhocomb.Absyn.RStr)
    {
       rhocomb.Absyn.RStr _rstr = (rhocomb.Absyn.RStr) foo;
       render("(");
       render("RStr");
       sh(_rstr.rname_);
       render(")");
    }
  }

  private static void sh(rhocomb.Absyn.RComb foo)
  {
    if (foo instanceof rhocomb.Absyn.RZero)
    {
       rhocomb.Absyn.RZero _rzero = (rhocomb.Absyn.RZero) foo;
       render("RZero");
    }
    if (foo instanceof rhocomb.Absyn.RMsg)
    {
       rhocomb.Absyn.RMsg _rmsg = (rhocomb.Absyn.RMsg) foo;
       render("(");
       render("RMsg");
       sh(_rmsg.rname_1);
       sh(_rmsg.rname_2);
       render(")");
    }
    if (foo instanceof rhocomb.Absyn.RKill)
    {
       rhocomb.Absyn.RKill _rkill = (rhocomb.Absyn.RKill) foo;
       render("(");
       render("RKill");
       sh(_rkill.rname_);
       render(")");
    }
    if (foo instanceof rhocomb.Absyn.RDup)
    {
       rhocomb.Absyn.RDup _rdup = (rhocomb.Absyn.RDup) foo;
       render("(");
       render("RDup");
       sh(_rdup.rname_1);
       sh(_rdup.rname_2);
       sh(_rdup.rname_3);
       render(")");
    }
    if (foo instanceof rhocomb.Absyn.RSeq)
    {
       rhocomb.Absyn.RSeq _rseq = (rhocomb.Absyn.RSeq) foo;
       render("(");
       render("RSeq");
       sh(_rseq.rname_1);
       sh(_rseq.rname_2);
       sh(_rseq.rname_3);
       render(")");
    }
    if (foo instanceof rhocomb.Absyn.RFwd)
    {
       rhocomb.Absyn.RFwd _rfwd = (rhocomb.Absyn.RFwd) foo;
       render("(");
       render("RFwd");
       sh(_rfwd.rname_1);
       sh(_rfwd.rname_2);
       render(")");
    }
    if (foo instanceof rhocomb.Absyn.RBrl)
    {
       rhocomb.Absyn.RBrl _rbrl = (rhocomb.Absyn.RBrl) foo;
       render("(");
       render("RBrl");
       sh(_rbrl.rname_1);
       sh(_rbrl.rname_2);
       render(")");
    }
    if (foo instanceof rhocomb.Absyn.RBrr)
    {
       rhocomb.Absyn.RBrr _rbrr = (rhocomb.Absyn.RBrr) foo;
       render("(");
       render("RBrr");
       sh(_rbrr.rname_1);
       sh(_rbrr.rname_2);
       render(")");
    }
  }

  private static void sh(rhocomb.Absyn.RName foo)
  {
    if (foo instanceof rhocomb.Absyn.RQuot)
    {
       rhocomb.Absyn.RQuot _rquot = (rhocomb.Absyn.RQuot) foo;
       render("(");
       render("RQuot");
       sh(_rquot.rproc_);
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

