//TestLazyEval
package com.nickpeck.humble;

@f(x)::
	if x is 100
	then x
	else f(x+1)
	;
	
f(1) -> fprint;


