package com.nickpeck.humble;

import humble.libs.IO;
/*
	A test scenario that demonstrates arbitrary chaining of various
	filter conditions.
	
	expected responses:
	
	[Validation OK, Validation failed, Validation failed]
*/


@itterPrint(list as [H:T], str_result) ::
	if equals(length(list), 0)
	then str_cat(str_result, "]")
	else
		if equals(str_result, "")
		then itterPrint(T, str_cat("[", H)) 
		else itterPrint(T, str_cat(str_result, ",", H))
;

	
@validation_chain(n, filters as [Head:Tail]) ::
	if length(filters) is 0
	then true
	else if Head(n) 
    	then validation_chain(n, Tail)
		 else false
	;

@test_upr_boundary(n) :: less_than(n, 100);
	
@test_lwr_boundary(n) :: gtr_than(n, 20);
	
@test_equ_50(n) :: n is 50;

@test1()::
if validation_chain(50, [test_upr_boundary, test_lwr_boundary, test_equ_50])  
then "Validation OK" 
else "Validation Failed"
;

@test2()::
if validation_chain(101, [test_upr_boundary, test_lwr_boundary, test_equ_50])  
then "Validation OK" 
else "Validation Failed" 
;

@test3()::
if validation_chain(19, [test_upr_boundary, test_lwr_boundary, test_equ_50])  
then "Validation OK" 
else "Validation Failed" 
;

[test1(), test2(), test3()] -> \(x) :: itterPrint(x, "") -> IO( \(x) :: print_out(x));
