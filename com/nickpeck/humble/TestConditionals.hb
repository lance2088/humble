package com.nickpeck.humble;

/*
    test of single and nested conditional statements.
	expected responses:
	[6, 5, x is true, y is true, neither x or y are true, 6]
*/

@logic(x,y) ::
	if x
	then "x is true"
	else if y
		then "y is true"
		else "neither x or y are true"
;

@maths(x,y) ::
	if gtr_than(x,y)
	then x-y
	else y-x
;

[
maths(11,5),
maths(5,10),
logic(true, false),
logic(false, true),
logic(false, false),
3 + (if gtr_than(5,8) then 5-8 else 8-5)
] -> fprint;