package coop.rchain.rhocomb.pi2rhocomb;

import coop.rchain.rhocomb.pi2rhocomb.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  coop.rchain.rhocomb.pi2rhocomb.Absyn.Req.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPProc.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPComp.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPName.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCPVar.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYProc.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYComb.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYName.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCYVar.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRProc.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRComb.Visitor<R,A>,
  coop.rchain.rhocomb.pi2rhocomb.Absyn.RCRName.Visitor<R,A>
{}
