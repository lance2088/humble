package com.nickpeck.humble;

/*
A series of tests of the integrity of the bind operator.
As a reminder, the grammar for this is:
statement :
		(
			(
				compound_expression
				| lambda
			)
			(
				BINDS compound_expression
				| BINDS lambda
			)* 
			
				
		);
We test various permutations of this,		
the expected result of running this module is:
[Hello nick, Hello nick, Hello nick, IF]

*/

//test compound_expression -> lambda -> compound_expression
@test1() :: "nick" -> \(name) :: str_cat("Hello ", name);

//ditto, but this time returning a lambda statement from a function
@f() :: \(name) :: str_cat("Hello ", name);

@test2() :: f()("nick");

@f2() ::
\(name) :: str_cat("Hello ", name) -> \(name) :: name;

@test3() :: f2()("nick");

//With some logic mixed in too...
@test4() :: if true & !false then "IF" else "ELSE" -> \(result) :: result;

[test1(), test2(), test3(), test4()] -> fprint;

