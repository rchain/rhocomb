
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package asyncpi;

import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\021\000\002\002\004\000\002\002\003\000\002\002" +
    "\005\000\002\003\005\000\002\003\003\000\002\003\004" +
    "\000\002\003\006\000\002\004\003\000\002\004\011\000" +
    "\002\004\007\000\002\005\003\000\002\005\003\000\002" +
    "\006\002\000\002\006\003\000\002\006\005\000\002\007" +
    "\003\000\002\007\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\042\000\020\004\007\006\006\013\005\015\016\017" +
    "\013\021\012\022\015\001\002\000\006\002\044\014\041" +
    "\001\002\000\020\004\007\006\006\013\005\015\016\017" +
    "\013\021\012\022\015\001\002\000\010\002\ufffa\005\ufffa" +
    "\014\ufffa\001\002\000\020\004\007\006\006\013\005\015" +
    "\016\017\013\021\012\022\015\001\002\000\004\012\033" +
    "\001\002\000\010\002\000\005\000\014\000\001\002\000" +
    "\010\015\016\020\ufff5\022\015\001\002\000\004\007\017" +
    "\001\002\000\010\002\ufffd\005\ufffd\014\ufffd\001\002\000" +
    "\014\010\ufff6\011\ufff6\012\ufff6\016\ufff6\020\ufff6\001\002" +
    "\000\014\010\ufff7\011\ufff7\012\ufff7\016\ufff7\020\ufff7\001" +
    "\002\000\006\015\016\022\015\001\002\000\004\010\021" +
    "\001\002\000\006\015\016\022\015\001\002\000\004\011" +
    "\023\001\002\000\020\004\007\006\006\013\005\015\016" +
    "\017\013\021\012\022\015\001\002\000\010\002\ufff9\005" +
    "\ufff9\014\ufff9\001\002\000\004\020\031\001\002\000\006" +
    "\016\027\020\ufff4\001\002\000\010\015\016\020\ufff5\022" +
    "\015\001\002\000\004\020\ufff3\001\002\000\020\004\007" +
    "\006\006\013\005\015\016\017\013\021\012\022\015\001" +
    "\002\000\010\002\ufffb\005\ufffb\014\ufffb\001\002\000\004" +
    "\007\034\001\002\000\006\015\016\022\015\001\002\000" +
    "\004\011\036\001\002\000\010\002\ufff8\005\ufff8\014\ufff8" +
    "\001\002\000\006\005\040\014\041\001\002\000\010\002" +
    "\ufffe\005\ufffe\014\ufffe\001\002\000\020\004\007\006\006" +
    "\013\005\015\016\017\013\021\012\022\015\001\002\000" +
    "\010\002\uffff\005\uffff\014\uffff\001\002\000\010\002\ufffc" +
    "\005\ufffc\014\ufffc\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\042\000\012\002\003\003\010\004\013\005\007\001" +
    "\001\000\002\001\001\000\010\003\042\004\013\005\007" +
    "\001\001\000\002\001\001\000\012\002\036\003\010\004" +
    "\013\005\007\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\005\025\006\024\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\005\017\001\001\000\002\001\001\000\004\005\021\001" +
    "\001\000\002\001\001\000\010\003\023\004\013\005\007" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\005\025\006\027\001\001\000\002\001\001" +
    "\000\010\003\031\004\013\005\007\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\005\034\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\003\041\004\013\005\007\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



  public asyncpi.Absyn.PProc pPProc() throws Exception
  {
    java_cup.runtime.Symbol res = parse();
    return (asyncpi.Absyn.PProc) res.value;
  }

public <B,A extends java.util.LinkedList<? super B>> A cons_(B x, A xs) { xs.addFirst(x); return xs; }

public void syntax_error(java_cup.runtime.Symbol cur_token)
{
  report_error("Syntax Error, trying to recover and continue parse...", cur_token);
}

public void unrecovered_syntax_error(java_cup.runtime.Symbol cur_token) throws java.lang.Exception
{
  throw new Exception("Unrecoverable Syntax Error");
}



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {


public java_cup.runtime.ComplexSymbolFactory.Location getLeftLocation(
    java_cup.runtime.ComplexSymbolFactory.Location ... locations) {
  for (java_cup.runtime.ComplexSymbolFactory.Location l : locations) {
    if (l != null) {
      return l;
    }
  }
  return null;
}

  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= PProc EOF 
            {
              Object RESULT =null;
		asyncpi.Absyn.PProc start_val = (asyncpi.Absyn.PProc)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // PProc ::= PProc1 
            {
              asyncpi.Absyn.PProc RESULT =null;
		asyncpi.Absyn.PProc p_1 = (asyncpi.Absyn.PProc)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = p_1; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PProc",0, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // PProc ::= PProc _SYMB_8 PProc1 
            {
              asyncpi.Absyn.PProc RESULT =null;
		asyncpi.Absyn.PProc p_1 = (asyncpi.Absyn.PProc)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Object p_2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		asyncpi.Absyn.PProc p_3 = (asyncpi.Absyn.PProc)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.PPar(p_1,p_3); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PProc",0, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // PProc1 ::= _SYMB_0 PProc _SYMB_1 
            {
              asyncpi.Absyn.PProc RESULT =null;
		Object p_1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		asyncpi.Absyn.PProc p_2 = (asyncpi.Absyn.PProc)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Object p_3 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = p_2; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PProc1",1, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // PProc1 ::= PComp 
            {
              asyncpi.Absyn.PProc RESULT =null;
		asyncpi.Absyn.PComp p_1 = (asyncpi.Absyn.PComp)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.PInj(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PProc1",1, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // PProc1 ::= _SYMB_7 PProc1 
            {
              asyncpi.Absyn.PProc RESULT =null;
		Object p_1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		asyncpi.Absyn.PProc p_2 = (asyncpi.Absyn.PProc)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.PRep(p_2); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PProc1",1, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // PProc1 ::= _SYMB_13 ListPName _SYMB_12 PProc1 
            {
              asyncpi.Absyn.PProc RESULT =null;
		Object p_1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		asyncpi.Absyn.ListPName p_2 = (asyncpi.Absyn.ListPName)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Object p_3 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		asyncpi.Absyn.PProc p_4 = (asyncpi.Absyn.PProc)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.PNew(p_2,p_4); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PProc1",1, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // PComp ::= _SYMB_2 
            {
              asyncpi.Absyn.PComp RESULT =null;
		Object p_1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.PZero(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PComp",2, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // PComp ::= _SYMB_11 _SYMB_3 PName _SYMB_4 PName _SYMB_5 PProc1 
            {
              asyncpi.Absyn.PComp RESULT =null;
		Object p_1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		Object p_2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		asyncpi.Absyn.PName p_3 = (asyncpi.Absyn.PName)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		Object p_4 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		asyncpi.Absyn.PName p_5 = (asyncpi.Absyn.PName)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Object p_6 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		asyncpi.Absyn.PProc p_7 = (asyncpi.Absyn.PProc)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.PInp(p_3,p_5,p_7); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PComp",2, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // PComp ::= PName _SYMB_6 _SYMB_3 PName _SYMB_5 
            {
              asyncpi.Absyn.PComp RESULT =null;
		asyncpi.Absyn.PName p_1 = (asyncpi.Absyn.PName)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		Object p_2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		Object p_3 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		asyncpi.Absyn.PName p_4 = (asyncpi.Absyn.PName)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Object p_5 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.POutp(p_1,p_4); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PComp",2, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // PName ::= _SYMB_9 
            {
              asyncpi.Absyn.PName RESULT =null;
		Object p_1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.NWild(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PName",3, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // PName ::= Var 
            {
              asyncpi.Absyn.PName RESULT =null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.NVar(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PName",3, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // ListPName ::= 
            {
              asyncpi.Absyn.ListPName RESULT =null;
		 RESULT = new asyncpi.Absyn.ListPName(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListPName",4, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // ListPName ::= PName 
            {
              asyncpi.Absyn.ListPName RESULT =null;
		asyncpi.Absyn.PName p_1 = (asyncpi.Absyn.PName)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.ListPName(); RESULT.addLast(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListPName",4, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // ListPName ::= PName _SYMB_10 ListPName 
            {
              asyncpi.Absyn.ListPName RESULT =null;
		asyncpi.Absyn.PName p_1 = (asyncpi.Absyn.PName)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Object p_2 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		asyncpi.Absyn.ListPName p_3 = (asyncpi.Absyn.ListPName)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = p_3; p_3.addFirst(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("ListPName",4, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // PVar ::= _SYMB_9 
            {
              asyncpi.Absyn.PVar RESULT =null;
		Object p_1 = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.PWild(); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PVar",5, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // PVar ::= Var 
            {
              asyncpi.Absyn.PVar RESULT =null;
		String p_1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new asyncpi.Absyn.PVVar(p_1); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("PVar",5, RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}