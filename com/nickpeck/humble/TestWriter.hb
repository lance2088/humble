package com.nickpeck.humble;

import humble.runtime.monads.Writer;
import humble.libs.IO;

/*
	test of the writer monad.
	writer enables us to create a log trace that can be unveiled at the end 
	of an evaluation - a more 'functional' approach than inserting print
	statements in your code.
	
	expected result: [144, [ added 1 ,  added 1 ,  square root ]]
*/

@itterPrint(list as [H:T], str_result) ::
	if equals(length(list), 0)
	then str_cat(str_result, "]")
	else
		if equals(str_result, "")
		then itterPrint(T, str_cat("[", H)) 
		else itterPrint(T, str_cat(str_result, ",", H))
;

Writer(
	:: call(raise(10), \(x) :: x+1, " added 1 ")
	-> \(result) :: call(result, \(x) :: x+1, " added 1 ")
	-> \(result) :: call(result, \(x) :: x*x, " square root ")
) 
-> \(x) :: itterPrint(x, "") 
-> IO( \(x) :: print_out(x));
