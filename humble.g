/*
This grammar is used to generate java code for the classes
	humble.compiler.humbleLexer
	humble.compiler.humbleParser

using Antlrworks 1.4.3 and the Antlr-3.1.1 runtime
*/

grammar humble;

options {
language = Java;
}

@lexer::header {
package humble.compiler;
}

@parser::header {
package humble.compiler;
import java.util.LinkedList;
}

@parser::members {
  private String moduleName;
  private ArrayList<String> imports = new ArrayList<String>();

  public String getModuleName() {
    return moduleName;
  }
  
  public void setModuleName(String name) {
  	moduleName = name;
  }
}


IMPORT	:	'import';
PACKAGE	:	'package';
DEF	:	'@';
AS	:	'::';
DEREF	:	'as';
TAIL	:	'tail';
EOL	:	';';
COLON	:	':';
BINDS	:	'->';
LPAREN :	'(';
RPAREN :	')';
COMMA	:	',';
LSB	:	'[';
RSB	:	']';
LAB	:	'<';
RAB	:	'>';
BOOL	:	'true' | 'false';
LAMBDA	:	'\\';
DO	:	'do';
IF	:	'if';
ELSE	:	'else';
THEN	:	'then';
//NOTHING	:	'nothing';
OR	:	'|';
//ERROR	:	'error';
EXTENDS :	'extends';
AND	:	'&';
NOT	:	'!';
IS	:	'is';
PLUS	:	'+';
MINUS	:	'-';
MULT	:	'*';
DIV	:	'/';
MOD	:	'%';
NEW	:	'new';
DOT 	:	'.';
//YIELD	:	'yield';
/*INT	:	('0'..'9')+;
LONG	:	('0'..'9')+ 'L';
DOUBLE	:	('0'..'9')+ '.' ('0'..'9')+;
FLOAT	:	('0'..'9')+ '.' ('0'..'9')+ 'f';*/
NUMBER 	:	('0'..'9')+ /*| (('0'..'9')+ '.' ('0'..'9')+)*/;
IDENT : ('a'..'z'|'A'..'Z'|'0'..'9'|'_')+;
STR 	:	'"' ~('"')* '"';
COMMENT
    : '/*' .* '*/' {$channel=HIDDEN;};
LINE_COMMENT
    : '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;};
WHITESPACE : ( '\t' | ' ' | '\r' | '\n'| '\u000C' )+    { $channel = HIDDEN; } ;


package_statement returns [String result]
	:	PACKAGE i1=IDENT {$result = i1.getText();}
		(
			DOT i2=IDENT {$result = $result + "." + i2.getText();}
		)* EOL
		{$result="package " + $result + ";";}
	;
	
extends_statement returns [String result]
	:	EXTENDS i=IDENT EOL
		{$result="extends " + i.getText();}
	;

import_statment returns [String result]
	:	IMPORT i1=IDENT {$result = i1.getText();}
		(
			DOT i2=IDENT {$result = $result + "." + i2.getText();}
		)* EOL
		{
			if($result.endsWith(".*")) {
				System.err.println("Package imports are not allowed in Humble.");
				System.exit(1);
			}
		}
		{imports.add($result);}
		{$result="import " + $result + ";";}
	;
	
dereference	returns [LinkedList<String> result]
	:	{$result = new LinkedList<String>();}
		i=IDENT {$result.add(i.getText());}
		DEREF 		
		LSB
		(
			(
				 i2=IDENT
				 {$result.add(i2.getText());}
			)
		
			(
				COMMA 
				(
					i3=IDENT
					{$result.add(i3.getText());}
				)
			)*
		)? RSB
	;
	
//allows you to split a list into Head/tail a la Prolog
//eg l as[H:T]
//l as [Head:] 
//l as [:T]
list_slice returns [LinkedList<String> result]
	:	{$result = new LinkedList<String>();}
		i1=IDENT {$result.add(i1.getText());}
		DEREF 		
		LSB
		i2=IDENT  {$result.add(i2.getText());}
		COLON
		i3=IDENT {$result.add(i3.getText());}
		RSB
	;
	
type	returns [String result]
	:	
		LAB i=IDENT RAB {$result = " new _Class(" + i.getText() + ".class)";}
	;
	
obj returns [String result]
	:
	 NEW i=IDENT
			{StringBuilder args = new StringBuilder("(");} 
			LPAREN 
			c1=callable {args.append(c1.toString());}
			(
				COMMA 
				c2=callable 
				{args.append(", ");}
				{args.append(c2.toString());}
			)* 
			RPAREN {args.append(")");}
		{$result = " new " + i.getText() + args.toString();}
	;


callable	returns [String result]
	:	id=IDENT {$result = id.getText();}
		| s=STR{$result = " new _String(" + s.getText() + ")";}
		//| in=INT {$result = " new _Int(" + in.getText() + ").setLocation(new Location(" + in.getLine() + ", " + in.getCharPositionInLine() + ", \"" + getModuleName() + "\"))";}
		| b=BOOL {$result = " new _Boolean(" + b.getText() + ")";}
		//| f=FLOAT {$result = " new _Float(" + f.getText() + ").setLocation(new Location(" + f.getLine() + ", " + f.getCharPositionInLine() + ", \"" + getModuleName() + "\"))";}
		//| d=DOUBLE {$result = " new _Double(" + d.getText() + ").setLocation(new Location(" + d.getLine() + ", " + d.getCharPositionInLine() + ", \"" + getModuleName() + "\"))";}
		//| l=LONG {$result = " new _Long(" + l.getText() + ").setLocation(new Location(" + l.getLine() + ", " + l.getCharPositionInLine() + ", \"" + getModuleName() + "\"))";}
		//| n=NOTHING {$result = " new Nothing().setLocation(new Location(" + n.getLine() + ", " + n.getCharPositionInLine() + ", \"" + getModuleName() + "\"))";}
		| n=NUMBER {$result = " new _Number(" + n.getText() + ")";}
		| t=type {$result = t.toString();}
		;
		

tuple	returns [StringBuilder result]
	:	
		{$result = new StringBuilder();}
		LPAREN {$result.append('(');}
		(
			(
				 e1=statement {$result.append(e1.toString());}
				 | f1=function  {$result.append(f1.toString());}
			)
		
			(
				COMMA {$result.append(", ");}
				(
					e2=statement {$result.append(e2.toString());}
					| f2=function  {$result.append(f2.toString());}
				)
			)*
		)? RPAREN {$result.append(')');}
		;

list	returns [StringBuilder result]
	:	
		{$result = new StringBuilder();}
		l=LSB {$result.append(" new _List(");}
		(
			(
				 e1=compound_expression {$result.append(e1.toString());}
			)
		
			(
				COMMA {$result.append(", ");}
				(
					e2=compound_expression {$result.append(e2.toString());}
				)
			)*
		)? RSB {$result.append(")");}
		;
		
		
expression returns [StringBuilder result]
	:	
		{$result = new StringBuilder();}
		(
			a1=callable {$result.append(a1);}
			| 	(

					a2=callable
					{StringBuilder tuples1 = new StringBuilder();}
					{StringBuilder tuples2 = new StringBuilder();}
					(//eg a(b,c) => a.call(b,c)
						t1=tuple {tuples1.append(".call" + t1.toString());}
						{tuples2.append(t1.toString());}
					)+
					{//if the callable is an imported module, then create and instance and
					//execute the 'tuple' within the module's callable section
						Boolean isImportClass = false;
						for(int i=0;i<imports.size();i++){
							if(imports.get(i).endsWith("." + a2.toString())) {
								isImportClass = true;
							}
						}
						if(isImportClass) {
							$result.append(" new " + a2.toString() + "(){");
							$result.append("	@Override");
							//append 'call', in case this is a bind operation, eg x->IO(\(x) :: print_out(x))
							$result.append("	public Callable call(final Callable ... args){");
							$result.append("		return " + tuples2.toString() + ".call(args);");
							$result.append("	}");
							$result.append("}");
						} else {
							$result.append(a2);
							$result.append(tuples1.toString());
						}	
					}
				)
			/*| i=IDENT COLON t3=tuple
				{$result.append(" new " + i.toString() + "(){");
				$result.append("	@Override");
							
				$result.append("	public Callable call(final Callable ... args){");
				$result.append("		return " + t3.toString() + ".call(args);");
				$result.append("	}");
				$result.append("}");}*/
			| t2=tuple {$result.append(t2.toString());}
			| li=list {$result.append(li.toString());}
			| o=obj t3=tuple 							
			{
				$result.append(o.toString() + "{");
				$result.append("	@Override");
		
				$result.append("	public Callable call(final Callable ... args){");
				$result.append("		return " + t3.toString() + ".call(args);");
				$result.append("	}");
				$result.append("}");
			}
			| o2=obj {$result.append(o2.toString());}
			
		)
	;
	
//The following 'compound_expression' sections are nested to yeild the correct order of operators.
//for reference, we use the python convention: http://www.informit.com/articles/article.aspx?p=459269&seqNum=11
compound_expression_dot returns [String result]
	:
		e1=expression {$result = e1.toString();}
		(
			DOT e2=expression {$result = $result + "." + e2.toString();}
		)*
	;

compound_expression_mult_div returns [String result]
	:
		e=compound_expression_dot {$result = e.toString();}
		(
			MULT  e2=compound_expression_dot {$result = "multiply.call(" + $result + ", " + e2.toString() + ")";}
			| DIV  e3=compound_expression_dot {$result = "divide.call(" + $result + ", " + e3.toString() + ")";}
			| MOD e4=compound_expression_dot {$result = "modulus.call(" + $result + ", " + e4.toString() + ")";}
		)*	
	;
	

compound_expression_plus_minus returns [String result]
	:
		e=compound_expression_mult_div {$result = e.toString();}
		(
			PLUS e2=compound_expression_mult_div {$result = "plus.call(" + $result + ", " + e2.toString() + ")";}
			| MINUS e3=compound_expression_mult_div {$result = "minus.call(" + $result + ", " + e3.toString() + ")";}
		)*	
	;
	
compound_expression_is returns [String result]
	:
		e=compound_expression_plus_minus {$result = e.toString();}
		(
			IS e2=compound_expression_plus_minus {$result = "equals.call(" + $result + ", " + e2.toString() + ")";}
		)*	
	;
	
compound_expression_not returns [String result]
	:
		e=compound_expression_is{$result = e.toString();}
		|
			NOT  e2=compound_expression_is {$result = "not.call(" + e2.toString() + ")";}
	;
	
compound_expression_and returns [String result]
	:
		e=compound_expression_not {$result = e.toString();}
		(
			AND  e2=compound_expression_not{$result = "and.call(" + $result + ", " + e2.toString() + ")";}
		)*	
	;
	
compound_expression_or returns [String result]
	:
		e=compound_expression_and {$result = e.toString();}
		(
			OR  e2=compound_expression_and  {$result = "or.call(" + $result + ", " + e2.toString() + ")";}
		)*	
	;
	
/*
compound_expression_yield returns [String result]
	:
		e=compound_expression_or {$result = e.toString();}
		|
			YIELD e2=compound_expression_or  {$result = "yeild(" + e2.toString() + ")";}
			
	;*/
	
compound_expression returns [String result]
	:
	e=compound_expression_or {$result = e.toString();}
	| c=conditional {$result = c.toString();}
	;


conditional returns [StringBuilder result]
	:	
			i=IF e2=compound_expression THEN e3=compound_expression ELSE e4=compound_expression
			{$result = new StringBuilder();}
			{$result.append(" new Conditional() {");}
			
			{$result.append("	@Override");}
			{$result.append("	public final _Boolean condition() throws HumbleRuntimeException {");}
							//use yeild to force immediate evaluation
			{$result.append("		return (_Boolean) yield(" + e2.toString() + ");");}	
			{$result.append("	}");}
			
			{$result.append("	@Override");}
			{$result.append("	public final Callable onIf() {");}
			{$result.append("		return " + e3.toString() + ";");}
			{$result.append("	}");}
			
			{$result.append("	@Override");}
			{$result.append("	public final Callable onElse() {");}
			{$result.append("		return " + e4.toString() + ";");}
			{$result.append("	}");}
			
			{$result.append("}.call()");}//call so that it yeilds a callable and satisfies the semantics
		;
		
		
lambda 	returns [StringBuilder result]
	:	
		{$result = new StringBuilder();}
		{StringBuilder args = new StringBuilder();}
		//{ArrayList<String> argTypes = new ArrayList();}
		{int argIndex=0;}
		(
			LAMBDA
		
			LPAREN
			(
				(
					(
						LAB tp=IDENT RAB i1=IDENT {args.append(" final " + tp.getText() + " ");}
						{args.append(i1.getText());}
						{args.append(" = (" + tp.getText() + ")args[" + argIndex + "];");}
					)
					|
					(
						i11=IDENT {args.append(" final Callable ");}
						{args.append(i11.getText());}
						{args.append(" = args[" + argIndex + "];");}
					)
					| d1=dereference
					{
						args.append(" final Callable " + d1.get(0) + " = ((_List)args[0]);");
						for(int index=1;index<d1.size();index++) {
							args.append(" final Callable " + d1.get(index) + " = ((_List)args[" + argIndex + "]).get(" + (index-1) + ");");
						}
					}
					| ls1=list_slice
					{
						args.append(" final Callable " + ls1.get(0) + " = ((_List)args[0]);");
						args.append(" final Callable " + ls1.get(1) + " = list_head.call(((_List)args[0]));");
						args.append(" final Callable " + ls1.get(2) + " = list_tail.call(((_List)args[0]));");
					}
				)
				
				(
					COMMA {argIndex ++;}
					({args.append(",");}
					i2=IDENT {args.append(" final Callable ");}
					{args.append(i2.getText());}
					{args.append(" = args[" + argIndex + "];");}
					|d2=dereference
					{
						args.append(" final Callable " + d2.get(0) + " = ((_List)args[" + argIndex + "]);");
						for(int index2=1;index2<d2.size();index2++) {
							args.append(" final Callable " + d2.get(index2) + " = ((_List)args[" + argIndex + "]).get(" + (index2-1) + ");");
						}
					}
					| ls2=list_slice
					{
						args.append(" final Callable " + ls1.get(0) + " = ((_List)args[0]);");
						args.append(" final Callable " + ls2.get(1) + " = list_head.call(((_List)args[" + argIndex + "]));");
						args.append(" final Callable " + ls2.get(2) + " = list_tail.call(((_List)args[" + argIndex + "]));");
					}
					)
				)*
			)?
			RPAREN
		)? 

		
		a=AS 
		(
			e=compound_expression
			{
				$result.append(" new Lambda() {");
				$result.append("	@Override");
				$result.append("	protected final Callable evaluate(Callable... args) {");
				$result.append("		" + args.toString());
				$result.append("		return " + e.toString() + ";");
				$result.append("	}");
				$result.append("}");
			}
			//| l=lambda {$result.append(l.toString());}
			| l=lambda
			{	
				$result.append(" new Lambda() {");
				$result.append("	@Override");
				$result.append("	protected final Callable evaluate(Callable... args) {");
				$result.append("		" + args.toString());
				$result.append("		return " + l.toString() + ";");
				$result.append("	}");
				$result.append("}");
			}
			
		)

	;


statement	returns [StringBuilder result]
	:	{$result = new StringBuilder();}
		(
			(
				e1=compound_expression
				{$result.append(e1.toString());}
				| l1=lambda {$result.append(l1.toString());}
				
			)
			(
				BINDS e2=compound_expression
				{$result.append( ".bindTo(new Lambda() {");}			
				{$result.append("	@Override");}
				{$result.append("	protected final Callable evaluate(Callable... args) {");}
				{$result.append("		return " + e2.toString() + ".call(args);");}
				{$result.append("	}");}
				{$result.append("})");}
				| BINDS l2=lambda
				{$result.append( ".bindTo(" + l2.toString() + ")");}
			)* 
			
				
		) 
		;

function	returns [StringBuilder result]
	:	
		{$result = new StringBuilder();}
		{LinkedList<String> args = new LinkedList<String>();}
		DEF i=IDENT
	
		{int argIndex=0;}
		LPAREN
		(
			(
				//i1=IDENT 
				
				//{args.add(" final Callable " + i1.getText() + " = args[" + argIndex + "];");}
				(
					LAB tp=IDENT RAB i1=IDENT {args.add(" final " + tp.getText() + " ");}
					{args.add(i1.getText());}
					{args.add(" = (" + tp.getText() + ")args[" + argIndex + "];");}
				)
				|
				(
					i11=IDENT {args.add(" final Callable ");}
					{args.add(i11.getText());}
					{args.add(" = args[" + argIndex + "];");}
				)
				| d1=dereference					
				{
					args.add(" final Callable " + d1.get(0) + " = ((_List)args[0]);");
					for(int index=1;index<d1.size();index++) {
						args.add(" final Callable " + d1.get(index) + " = ((_List)args[0]).get(" + (index-1) + ");");
					}
				}
				| ls1=list_slice
				{
					args.add(" final Callable " + ls1.get(0) + " = ((_List)args[0]);");
					args.add(" final Callable " + ls1.get(1) + " = list_head.call(((_List)args[0]));");
					args.add(" final Callable " + ls1.get(2) + " = list_tail.call(((_List)args[0]));");
				}
				
			)
			(
				COMMA {argIndex ++;}
				(i2=IDENT 
				
				{args.add(" final Callable " + i2.getText() + " = args[" + argIndex + "];");}
				| d2=dereference
				{
					args.add(" final Callable " + d2.get(0) + " = ((_List)args[" + argIndex + "]);");
					for(int index2=1;index2<d2.size();index2++) {
						args.add(" final Callable " + d2.get(index2) + " = ((_List)args[" + argIndex + "]).get(" + (index2-1) + ");");
					}
				}
				| ls2=list_slice
				{
					args.add(" final Callable " + ls2.get(0) + " = ((_List)args[" + argIndex + "]);");
					args.add(" final Callable " + ls2.get(1) + " = list_head.call(((_List)args[" + argIndex + "]));");
					args.add(" final Callable " + ls2.get(2) + " = list_tail.call(((_List)args[" + argIndex + "]));");
				}
				)
				
			)*
		)?
		RPAREN 
		
		
		{$result.append("public final static Lambda " + i.getText() + " = new Lambda() {");}
		
		{$result.append("		@Override");}
		{$result.append("		protected final Callable evaluate(Callable... args) {");}
		AS
		(
			
			s1=statement
			{
	
				for(int i3=0;i3<args.size();i3++) {
					$result.append(args.get(i3));
				}
				$result.append("			return " + s1.toString() + ";");
			}
			
			
			/*(
				YIELD s2=statement
				ERROR l=lambda
					{
						for(int i3=0;i3<args.size();i3++) {
							$result.append(args.get(i3));
						}
						$result.append("			try{ " + s2.toString() + ";");
						$result.append("				return yield(" + s2.toString() + ");");
						$result.append("			} catch (Exception e) {");
						$result.append("				return " + l.toString() + ".call(e.getException());");
						$result.append("			}");
					}
			)*/
			
		)
		{$result.append("		}");}
		
		{$result.append("	}");}
		EOL {$result.append(";");}
	;
	
typedef	 returns [StringBuilder result]
	:	
		{$result = new StringBuilder();}
		DEF LAB id=IDENT RAB
		
		//{$result.append("public class " + id.getText() + "{");}
		
		{LinkedList<String> args = new LinkedList();}
		{int argIndex = 0;}
		LPAREN
		(
			(
				i1=IDENT 
				{args.add(i1.getText());}
			)
			(
				COMMA {argIndex ++;}
				(i2=IDENT 
					{args.add(i2.getText());}
				)
				
			)*
		)?
		RPAREN
		{
			for(int i=0;i<args.size();i++) {		
				$result.append(" private static Callable " + args.get(i) + ";");
			}
		}
				
		{$result.append("	public " + id.getText() + "(Callable... args){");}

		{
			for(int i=0;i<args.size();i++) {
				{$result.append(args.get(i) + " = args[" + i + "];");}
			}
		}
		{$result.append("}");}
		
		AS
		
		(f=function {$result.append(f.toString());})* 
		
		//{$result.append("}");}
		
		EOL
	;
	
	
module		returns [StringBuilder result]
	:	
		{$result = new StringBuilder();}
		
		p=package_statement {$result.append(p.toString());}
		
		{$result.append("import humble.runtime.*;");}
		{$result.append("import humble.primitives.*;");}
		{$result.append("import humble.runtime.HumbleRuntimeException;");}
		(
			i=import_statment {$result.append(i.toString());}
		)*
		
		{String _extends=" extends Module ";}
		
		(	
			es=extends_statement
			{_extends = es.toString();}
		)?
		
		{$result.append("public class " + getModuleName() + " " + _extends + " {");}
		{StringBuilder statements = new StringBuilder();}
		(
			t=typedef  {$result.append(t.toString());}
			| 
			(
				{statements.append("public static void main(String[] args) throws HumbleRuntimeException{");}
				(
					f=function {$result.append(f.toString());}
					| s=statement
					(
						{String theStatement = s.toString();} 
						{statements.append(theStatement.substring(0, theStatement.length()));}
						EOL {statements.append(".call();");}
					)
					
				)*
				{statements.append("}");}
			)
		)
		
		{$result.append(" @Override public Callable call(Callable... args) {return this;}");}
		{statements.append("}");}
		{$result.append(statements);}
		EOF;