package com.nickpeck.humble;

/*
	A generic implementation of the maybe monad
*/

/*
@just(value) ::
	if is_nothing(value):	
	then \(modifier) :: nothing
	else \(modifier) :: modifier(value) -> \(result) :: just(result)
	;
*/