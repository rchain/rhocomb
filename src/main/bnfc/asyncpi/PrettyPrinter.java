package asyncpi;
import asyncpi.Absyn.*;

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
  public static String print(asyncpi.Absyn.PProc foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(asyncpi.Absyn.PProc foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(asyncpi.Absyn.PComp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(asyncpi.Absyn.PComp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(asyncpi.Absyn.PName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(asyncpi.Absyn.PName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(asyncpi.Absyn.ListPName foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(asyncpi.Absyn.ListPName foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(asyncpi.Absyn.PVar foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(asyncpi.Absyn.PVar foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(asyncpi.Absyn.PProc foo, int _i_)
  {
    if (foo instanceof asyncpi.Absyn.PPar)
    {
       asyncpi.Absyn.PPar _ppar = (asyncpi.Absyn.PPar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_ppar.pproc_1, 0);
       render("|");
       pp(_ppar.pproc_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof asyncpi.Absyn.PInj)
    {
       asyncpi.Absyn.PInj _pinj = (asyncpi.Absyn.PInj) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_pinj.pcomp_, 0);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof asyncpi.Absyn.PRep)
    {
       asyncpi.Absyn.PRep _prep = (asyncpi.Absyn.PRep) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("*");
       pp(_prep.pproc_, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof asyncpi.Absyn.PNew)
    {
       asyncpi.Absyn.PNew _pnew = (asyncpi.Absyn.PNew) foo;
       if (_i_ > 1) render(_L_PAREN);
       render("new");
       pp(_pnew.listpname_, 0);
       render("in");
       pp(_pnew.pproc_, 1);
       if (_i_ > 1) render(_R_PAREN);
    }
  }

  private static void pp(asyncpi.Absyn.PComp foo, int _i_)
  {
    if (foo instanceof asyncpi.Absyn.PZero)
    {
       asyncpi.Absyn.PZero _pzero = (asyncpi.Absyn.PZero) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("0");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof asyncpi.Absyn.PInp)
    {
       asyncpi.Absyn.PInp _pinp = (asyncpi.Absyn.PInp) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("for");
       render("(");
       pp(_pinp.pname_1, 0);
       render("<-");
       pp(_pinp.pname_2, 0);
       render(")");
       pp(_pinp.pproc_, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof asyncpi.Absyn.POutp)
    {
       asyncpi.Absyn.POutp _poutp = (asyncpi.Absyn.POutp) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_poutp.pname_1, 0);
       render("!");
       render("(");
       pp(_poutp.pname_2, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(asyncpi.Absyn.PName foo, int _i_)
  {
    if (foo instanceof asyncpi.Absyn.NWild)
    {
       asyncpi.Absyn.NWild _nwild = (asyncpi.Absyn.NWild) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("_");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof asyncpi.Absyn.NVar)
    {
       asyncpi.Absyn.NVar _nvar = (asyncpi.Absyn.NVar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_nvar.var_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(asyncpi.Absyn.ListPName foo, int _i_)
  {
     for (java.util.Iterator<PName> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(asyncpi.Absyn.PVar foo, int _i_)
  {
    if (foo instanceof asyncpi.Absyn.PWild)
    {
       asyncpi.Absyn.PWild _pwild = (asyncpi.Absyn.PWild) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("_");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof asyncpi.Absyn.PVVar)
    {
       asyncpi.Absyn.PVVar _pvvar = (asyncpi.Absyn.PVVar) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_pvvar.var_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }


  private static void sh(asyncpi.Absyn.PProc foo)
  {
    if (foo instanceof asyncpi.Absyn.PPar)
    {
       asyncpi.Absyn.PPar _ppar = (asyncpi.Absyn.PPar) foo;
       render("(");
       render("PPar");
       sh(_ppar.pproc_1);
       sh(_ppar.pproc_2);
       render(")");
    }
    if (foo instanceof asyncpi.Absyn.PInj)
    {
       asyncpi.Absyn.PInj _pinj = (asyncpi.Absyn.PInj) foo;
       render("(");
       render("PInj");
       sh(_pinj.pcomp_);
       render(")");
    }
    if (foo instanceof asyncpi.Absyn.PRep)
    {
       asyncpi.Absyn.PRep _prep = (asyncpi.Absyn.PRep) foo;
       render("(");
       render("PRep");
       sh(_prep.pproc_);
       render(")");
    }
    if (foo instanceof asyncpi.Absyn.PNew)
    {
       asyncpi.Absyn.PNew _pnew = (asyncpi.Absyn.PNew) foo;
       render("(");
       render("PNew");
       render("[");
       sh(_pnew.listpname_);
       render("]");
       sh(_pnew.pproc_);
       render(")");
    }
  }

  private static void sh(asyncpi.Absyn.PComp foo)
  {
    if (foo instanceof asyncpi.Absyn.PZero)
    {
       asyncpi.Absyn.PZero _pzero = (asyncpi.Absyn.PZero) foo;
       render("PZero");
    }
    if (foo instanceof asyncpi.Absyn.PInp)
    {
       asyncpi.Absyn.PInp _pinp = (asyncpi.Absyn.PInp) foo;
       render("(");
       render("PInp");
       sh(_pinp.pname_1);
       sh(_pinp.pname_2);
       sh(_pinp.pproc_);
       render(")");
    }
    if (foo instanceof asyncpi.Absyn.POutp)
    {
       asyncpi.Absyn.POutp _poutp = (asyncpi.Absyn.POutp) foo;
       render("(");
       render("POutp");
       sh(_poutp.pname_1);
       sh(_poutp.pname_2);
       render(")");
    }
  }

  private static void sh(asyncpi.Absyn.PName foo)
  {
    if (foo instanceof asyncpi.Absyn.NWild)
    {
       asyncpi.Absyn.NWild _nwild = (asyncpi.Absyn.NWild) foo;
       render("NWild");
    }
    if (foo instanceof asyncpi.Absyn.NVar)
    {
       asyncpi.Absyn.NVar _nvar = (asyncpi.Absyn.NVar) foo;
       render("(");
       render("NVar");
       sh(_nvar.var_);
       render(")");
    }
  }

  private static void sh(asyncpi.Absyn.ListPName foo)
  {
     for (java.util.Iterator<PName> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(asyncpi.Absyn.PVar foo)
  {
    if (foo instanceof asyncpi.Absyn.PWild)
    {
       asyncpi.Absyn.PWild _pwild = (asyncpi.Absyn.PWild) foo;
       render("PWild");
    }
    if (foo instanceof asyncpi.Absyn.PVVar)
    {
       asyncpi.Absyn.PVVar _pvvar = (asyncpi.Absyn.PVVar) foo;
       render("(");
       render("PVVar");
       sh(_pvvar.var_);
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

