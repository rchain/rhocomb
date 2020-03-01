package rhocomb;

import rhocomb.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  rhocomb.Absyn.RProc.Visitor<R,A>,
  rhocomb.Absyn.RComb.Visitor<R,A>,
  rhocomb.Absyn.RName.Visitor<R,A>
{}
