package picomb;

import picomb.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  picomb.Absyn.YProc.Visitor<R,A>,
  picomb.Absyn.YComb.Visitor<R,A>,
  picomb.Absyn.YName.Visitor<R,A>,
  picomb.Absyn.YVar.Visitor<R,A>
{}
