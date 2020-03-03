package asyncpi;

import asyncpi.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  asyncpi.Absyn.PProc.Visitor<R,A>,
  asyncpi.Absyn.PComp.Visitor<R,A>,
  asyncpi.Absyn.PName.Visitor<R,A>,
  asyncpi.Absyn.PVar.Visitor<R,A>
{}
