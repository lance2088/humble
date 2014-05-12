package com.nickpeck.humble;

/*
	A generic implementation of the state monad
*/

@raise(value) :: [value, []];

@call(state as [value:states], modifier) ::
	[modifier(value), push(states, value)]
;

@rollback(state as [value:states]) ::
	[list_head(states), list_tail(states)]
;

@get_value(state as [value:states]) ::
	value
;
