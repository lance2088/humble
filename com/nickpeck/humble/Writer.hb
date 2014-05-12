package com.nickpeck.humble;

/*
	A generic implementation of the writer monad
*/

@raise(value):: [value,[]];

@call(writer as [value, log], modifier, log_msg) ::
	[modifier(value), append(log, log_msg)]
;

@get_log(writer as [value, log]) ::
	log
;

@get_value(writer as [value, log]) ::
	value
;