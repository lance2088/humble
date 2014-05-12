package com.nickpeck.humble;

import humble.runtime.monads.State;
import humble.libs.IO;

/*
	testing the state monad.
	
	the state monad enables us to perform a series of
	operations on a data structure, whilst enabling us the
	ability to roll back to a previous call.
	
	so in this case, we evaluated (10*10) -> + 1 -> square_root (ie 10201)
        then rolled back one stage (to 101).
	
	expected result: [101, [100, 10]]
*/

@itterPrint(list as [H:T], str_result) ::
	if equals(length(list), 0)
	then str_cat(str_result, "]")
	else
		if equals(str_result, "")
		then itterPrint(T, str_cat("[", H)) 
		else itterPrint(T, str_cat(str_result, ",", H))
;


@square_root(x) :: x*x;

State(
	::raise(10)
	-> \(x) :: call(x, square_root)
	-> \(x) :: call(x, \(x) :: x + 1)
	-> \(x) :: call(x, square_root)
	-> rollback
	) 
-> \(x) :: itterPrint(x, "") 
-> IO( \(x) :: print_out(x));
