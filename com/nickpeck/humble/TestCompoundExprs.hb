package com.nickpeck.humble;

/*
	test that the order of numeric and logical operators is correctly 
	determined by the parser:
	
	correct responses, in order : 
	[29, 65, 10, 12, 9, 80, true, false, false, true, true, false, false, true]
*/

[
	5 + 6 * 4,
	7 * 8 + (3*3),
	9 + 16 - 15,
	12 / 6 + 10,
	6 + (9/3),
	(2*2*2) * (3+7),
	true & true,
	true & false,
	false & false,
	true | true,
	true | false,
	false | false,
	!true,
	!false
] -> fprint;