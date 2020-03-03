package picomb;
import picomb.Absyn.*;

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
  public static String print(picomb.Absyn.YProc foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(picomb.Absyn.YProc foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(picomb.Absyn.YComb foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(picomb.Absyn.YComb foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(picomb.Absyn.YName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(picomb.Absyn.YName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(picomb.Absyn.ListYName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(picomb.Absyn.ListYName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(picomb.Absyn.YVar foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(picomb.Absyn.YVar foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(picomb.Absyn.YProc foo, int _i_)
  {
    if (foo instanceof picomb.Absyn.YPar)
    {
       picomb.Absyn.YPar _ypar = (picomb.Absyn.YPar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_ypar.yproc_1, 0);
       render("|");
       pp(_ypar.yproc_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YInj)
    {
       picomb.Absyn.YInj _yinj = (picomb.Absyn.YInj) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_yinj.ycomb_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YStr)
    {
       picomb.Absyn.YStr _ystr = (picomb.Absyn.YStr) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("*");
       pp(_ystr.yproc_, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YNew)
    {
       picomb.Absyn.YNew _ynew = (picomb.Absyn.YNew) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("new");
       pp(_ynew.listyname_, 0);
       render("in");
       pp(_ynew.yproc_, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
  }

  private static void pp(picomb.Absyn.YComb foo, int _i_)
  {
    if (foo instanceof picomb.Absyn.YZero)
    {
       picomb.Absyn.YZero _yzero = (picomb.Absyn.YZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("0");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YMsg)
    {
       picomb.Absyn.YMsg _ymsg = (picomb.Absyn.YMsg) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("m");
       render("(");
       pp(_ymsg.yname_1, 0);
       render(",");
       pp(_ymsg.yname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YKill)
    {
       picomb.Absyn.YKill _ykill = (picomb.Absyn.YKill) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("k");
       render("(");
       pp(_ykill.yname_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YDup)
    {
       picomb.Absyn.YDup _ydup = (picomb.Absyn.YDup) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("d");
       render("(");
       pp(_ydup.yname_1, 0);
       render(",");
       pp(_ydup.yname_2, 0);
       render(",");
       pp(_ydup.yname_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YSeq)
    {
       picomb.Absyn.YSeq _yseq = (picomb.Absyn.YSeq) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("s");
       render("(");
       pp(_yseq.yname_1, 0);
       render(",");
       pp(_yseq.yname_2, 0);
       render(",");
       pp(_yseq.yname_3, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YFwd)
    {
       picomb.Absyn.YFwd _yfwd = (picomb.Absyn.YFwd) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("fw");
       render("(");
       pp(_yfwd.yname_1, 0);
       render(",");
       pp(_yfwd.yname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YBrl)
    {
       picomb.Absyn.YBrl _ybrl = (picomb.Absyn.YBrl) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("bl");
       render("(");
       pp(_ybrl.yname_1, 0);
       render(",");
       pp(_ybrl.yname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YBrr)
    {
       picomb.Absyn.YBrr _ybrr = (picomb.Absyn.YBrr) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("br");
       render("(");
       pp(_ybrr.yname_1, 0);
       render(",");
       pp(_ybrr.yname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(picomb.Absyn.YName foo, int _i_)
  {
    if (foo instanceof picomb.Absyn.NWild)
    {
       picomb.Absyn.NWild _nwild = (picomb.Absyn.NWild) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("_");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.NVar)
    {
       picomb.Absyn.NVar _nvar = (picomb.Absyn.NVar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_nvar.cvar_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(picomb.Absyn.ListYName foo, int _i_)
  {
     for (java.util.Iterator<YName> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(picomb.Absyn.YVar foo, int _i_)
  {
    if (foo instanceof picomb.Absyn.YWild)
    {
       picomb.Absyn.YWild _ywild = (picomb.Absyn.YWild) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("_");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof picomb.Absyn.YVVar)
    {
       picomb.Absyn.YVVar _yvvar = (picomb.Absyn.YVVar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_yvvar.cvar_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(picomb.Absyn.YProc foo)
  {
    if (foo instanceof picomb.Absyn.YPar)
    {
       picomb.Absyn.YPar _ypar = (picomb.Absyn.YPar) foo;
       render("(");
       render("YPar");
       sh(_ypar.yproc_1);
       sh(_ypar.yproc_2);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YInj)
    {
       picomb.Absyn.YInj _yinj = (picomb.Absyn.YInj) foo;
       render("(");
       render("YInj");
       sh(_yinj.ycomb_);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YStr)
    {
       picomb.Absyn.YStr _ystr = (picomb.Absyn.YStr) foo;
       render("(");
       render("YStr");
       sh(_ystr.yproc_);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YNew)
    {
       picomb.Absyn.YNew _ynew = (picomb.Absyn.YNew) foo;
       render("(");
       render("YNew");
       render("[");
       sh(_ynew.listyname_);
       render("]");
       sh(_ynew.yproc_);
       render(")");
    }
  }

  private static void sh(picomb.Absyn.YComb foo)
  {
    if (foo instanceof picomb.Absyn.YZero)
    {
       picomb.Absyn.YZero _yzero = (picomb.Absyn.YZero) foo;
       render("YZero");
    }
    if (foo instanceof picomb.Absyn.YMsg)
    {
       picomb.Absyn.YMsg _ymsg = (picomb.Absyn.YMsg) foo;
       render("(");
       render("YMsg");
       sh(_ymsg.yname_1);
       sh(_ymsg.yname_2);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YKill)
    {
       picomb.Absyn.YKill _ykill = (picomb.Absyn.YKill) foo;
       render("(");
       render("YKill");
       sh(_ykill.yname_);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YDup)
    {
       picomb.Absyn.YDup _ydup = (picomb.Absyn.YDup) foo;
       render("(");
       render("YDup");
       sh(_ydup.yname_1);
       sh(_ydup.yname_2);
       sh(_ydup.yname_3);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YSeq)
    {
       picomb.Absyn.YSeq _yseq = (picomb.Absyn.YSeq) foo;
       render("(");
       render("YSeq");
       sh(_yseq.yname_1);
       sh(_yseq.yname_2);
       sh(_yseq.yname_3);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YFwd)
    {
       picomb.Absyn.YFwd _yfwd = (picomb.Absyn.YFwd) foo;
       render("(");
       render("YFwd");
       sh(_yfwd.yname_1);
       sh(_yfwd.yname_2);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YBrl)
    {
       picomb.Absyn.YBrl _ybrl = (picomb.Absyn.YBrl) foo;
       render("(");
       render("YBrl");
       sh(_ybrl.yname_1);
       sh(_ybrl.yname_2);
       render(")");
    }
    if (foo instanceof picomb.Absyn.YBrr)
    {
       picomb.Absyn.YBrr _ybrr = (picomb.Absyn.YBrr) foo;
       render("(");
       render("YBrr");
       sh(_ybrr.yname_1);
       sh(_ybrr.yname_2);
       render(")");
    }
  }

  private static void sh(picomb.Absyn.YName foo)
  {
    if (foo instanceof picomb.Absyn.NWild)
    {
       picomb.Absyn.NWild _nwild = (picomb.Absyn.NWild) foo;
       render("NWild");
    }
    if (foo instanceof picomb.Absyn.NVar)
    {
       picomb.Absyn.NVar _nvar = (picomb.Absyn.NVar) foo;
       render("(");
       render("NVar");
       sh(_nvar.cvar_);
       render(")");
    }
  }

  private static void sh(picomb.Absyn.ListYName foo)
  {
     for (java.util.Iterator<YName> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(picomb.Absyn.YVar foo)
  {
    if (foo instanceof picomb.Absyn.YWild)
    {
       picomb.Absyn.YWild _ywild = (picomb.Absyn.YWild) foo;
       render("YWild");
    }
    if (foo instanceof picomb.Absyn.YVVar)
    {
       picomb.Absyn.YVVar _yvvar = (picomb.Absyn.YVVar) foo;
       render("(");
       render("YVVar");
       sh(_yvvar.cvar_);
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

