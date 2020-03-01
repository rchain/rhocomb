JAVAC=javac
JAVAC_FLAGS=-sourcepath . -cp /Users/lgm/work/src/devtools/java-cup-bin-11b-20160615/java-cup-11b-runtime.jar:/Users/lgm/work/src/devtools/java-cup-bin-11b-20160615/java-cup-11b.jar:/Users/lgm/work/src/devtools/jlex/JLex-0.0.jar
JAVA=java
JAVA_FLAGS= -cp /Users/lgm/work/src/devtools/java-cup-bin-11b-20160615/java-cup-11b-runtime.jar:/Users/lgm/work/src/devtools/java-cup-bin-11b-20160615/java-cup-11b.jar:/Users/lgm/work/src/devtools/jlex/JLex-0.0.jar
PARSER=${JAVA} ${JAVA_FLAGS} java_cup.Main
PARSER_FLAGS=-nopositions -expect 100
LEXER=${JAVA} ${JAVA_FLAGS} JLex.Main
LEXER_FLAGS=
all: test

test: absyn rhocomb/Yylex.class rhocomb/PrettyPrinter.class rhocomb/Test.class rhocomb/ComposVisitor.class rhocomb/AbstractVisitor.class rhocomb/FoldVisitor.class rhocomb/AllVisitor.class rhocomb/parser.class rhocomb/sym.class rhocomb/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: rhocomb/Absyn/RProc.java rhocomb/Absyn/RInj.java rhocomb/Absyn/RStr.java rhocomb/Absyn/RPar.java rhocomb/Absyn/RComb.java rhocomb/Absyn/RZero.java rhocomb/Absyn/RMsg.java rhocomb/Absyn/RKill.java rhocomb/Absyn/RDup.java rhocomb/Absyn/RSeq.java rhocomb/Absyn/RFwd.java rhocomb/Absyn/RBrl.java rhocomb/Absyn/RBrr.java rhocomb/Absyn/RName.java rhocomb/Absyn/RQuot.java
	${JAVAC} ${JAVAC_FLAGS} $^

rhocomb/Yylex.java: rhocomb/Yylex
	${LEXER} ${LEXER_FLAGS} rhocomb/Yylex

rhocomb/parser.java rhocomb/sym.java: rhocomb/_cup.cup
	${PARSER} ${PARSER_FLAGS} rhocomb/_cup.cup
	mv parser.java sym.java rhocomb/

rhocomb/Yylex.class: rhocomb/Yylex.java rhocomb/parser.java rhocomb/sym.java

rhocomb/sym.class: rhocomb/sym.java

rhocomb/parser.class: rhocomb/parser.java rhocomb/sym.java

rhocomb/PrettyPrinter.class: rhocomb/PrettyPrinter.java

clean:
	rm -f rhocomb/Absyn/*.class rhocomb/*.class

distclean: vclean

vclean:
	 rm -f rhocomb/Absyn/RProc.java rhocomb/Absyn/RInj.java rhocomb/Absyn/RStr.java rhocomb/Absyn/RPar.java rhocomb/Absyn/RComb.java rhocomb/Absyn/RZero.java rhocomb/Absyn/RMsg.java rhocomb/Absyn/RKill.java rhocomb/Absyn/RDup.java rhocomb/Absyn/RSeq.java rhocomb/Absyn/RFwd.java rhocomb/Absyn/RBrl.java rhocomb/Absyn/RBrr.java rhocomb/Absyn/RName.java rhocomb/Absyn/RQuot.java rhocomb/Absyn/RProc.class rhocomb/Absyn/RInj.class rhocomb/Absyn/RStr.class rhocomb/Absyn/RPar.class rhocomb/Absyn/RComb.class rhocomb/Absyn/RZero.class rhocomb/Absyn/RMsg.class rhocomb/Absyn/RKill.class rhocomb/Absyn/RDup.class rhocomb/Absyn/RSeq.class rhocomb/Absyn/RFwd.class rhocomb/Absyn/RBrl.class rhocomb/Absyn/RBrr.class rhocomb/Absyn/RName.class rhocomb/Absyn/RQuot.class
	 rm -f rhocomb/Absyn/*.class
	 rmdir rhocomb/Absyn/
	 rm -f rhocomb/Yylex rhocomb/_cup.cup rhocomb/Yylex.java rhocomb/VisitSkel.java rhocomb/ComposVisitor.java rhocomb/AbstractVisitor.java rhocomb/FoldVisitor.java rhocomb/AllVisitor.java rhocomb/PrettyPrinter.java rhocomb/Skeleton.java rhocomb/Test.java rhocomb/parser.java rhocomb/sym.java rhocomb/*.class
	 rm -f Makefile
	 rmdir -p rhocomb/
