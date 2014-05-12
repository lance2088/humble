package com.nickpeck.humble;

/* 
	Test implementation of Either.
	Either evaluates any number of expressions in order, and returns the
	result of the first one that does not yield nothing.
	
	If they all yield nothing, then nothing is returned.
	
	expected response: [2, 3, Hello nick, 4, Hello sally, 5, Hello joan]
*/

@add_one(n) :: n + 1;

@compose_greeting(name) :: str_cat("Hello ", name);

map(
	\(item) :: either(add_one(item), compose_greeting(item)),
	[1, 2, "nick", 3, "sally", 4, "joan"]
	) -> fprint;