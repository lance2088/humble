package com.nickpeck.humble;

/*
    Testing the built-in generator function.
	
	The generator acts like an iterator / sequence builder, but only
	yields results as requested.
	
	calling generator(value, functor) returns [functor(value), new_generator]
	
	where new_generator is a function that can be called to return the next
	sequence in the chain, ie: functor(functor(value))
	
	expected response:
	32
*/

generator(1, \(x) :: x+x)
	->\(gen as [v, f]) :: f() 
	->\(gen as [v, f]) :: f() 
	->\(gen as [v, f]) :: f() 
	->\(gen as [v, f]) :: f() 
	-> \(res as [number, lambda]) :: fprint(number);



