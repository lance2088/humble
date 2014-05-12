/*
	humble introductory examples.

	Some examples of the humble language in action.
	humble is a functional, dynamically typed scripting 
	language that uses lazy evaluation.
	
	The source code is compiled to a java class file, so you can package it
	in a jar, and link to it from other code written in the Java language.
*/
package com.nickpeck.humble;


import humble.libs.IO;


/*
	hello world
*/
IO.print_out("Hello world 1!");


"Hello world 2!" : IO.print_out;


f as () -> "Hello, world 3!";

IO.print_out(f());

/*nb the following is lazy, so it will print a list of futurepromises!*/
map((a) -> plus(a,1), [1,2,3,4,5,6]) : IO.print_out;
/*if you specifically request a list member, then it will be evaluated */
map((a) -> plus(a,1), [1,2,3,4,5,6]) : (x) -> IO.print_out(get(x,0));


iterator as (x,y) ->
	if equals(x,y)
	then "Values are equal!!!"
	else iterator(x + 1, y)
;

/*won't throw a stack overflow error!*/
iterator(11,200000) : IO.print_out;



itterPrint as (list as [H:T], str_result) ->
	if equals(length(list), 0)
	then str_cat(str_result, "]")
	else if equals(str_result, "")
	then itterPrint(T, str_cat("[", H)) 
	else itterPrint(T, str_cat(str_result, ",", H))
;

itterPrint([1,2,3,4,5], "") : IO.print_out;


/* example of a filter statement */
filter((a) -> equals(a,2), [1,2,3,4,2,6]) : (x) -> IO.print_out(itterPrint(x, ""));

/* map and filter combined */
map((a) -> a+1, filter((a) -> equals(a,2), [1,2,3,4,2,6])) : (x) -> IO.print_out(itterPrint(x, ""));


/* 
	now, lets use the range function to generate a list for us,
	and print each item
*/
IO.print_out(range(0,20));


/* 
	Glue is a handy operation for joining a list of items with
	given spacer. Other useful String operators such as str_cat
	are built in.
*/
glue(" ", ["I", "like", "2", "boogie"]) : IO.print_out;



/*
	test that the order of numeric and logical operators is correctly 
	determined by the parser:
	
	correct responses, in order : 
	[29, 65, 10, 12, 9, 80, true, false, false, true, true, false, false, true]
        [29, 65, 10, 12, 9, 80, true, true,  false, true, true, false, false, true]
*/

IO.print_out(
itterPrint([
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
], ""));


_factorial as (n, accumulator)-> 
	if equals(n, 0)
	then accumulator
	else _factorial(n - 1, n * accumulator)
;

factorial as (n)->
	_factorial(n,1)
;

factorial(100) : IO.print_out;


curry as (x) ->
 (y) ->
   (z) ->
     str_cat(x,y,z)
;

curry("hello")("-")("world") : IO.print_out;

curry2 as (x)->
	x + 2 : (y) -> y + 2 : (z) -> z + 2 : IO.print_out
;

curry2(1);

curry3 as (x) ->  (y) -> y + 2 : ((e) -> e + x);

curry3(1)(2) : IO.print_out;


bank as (initial_amount) ->
	(modifier) -> modifier(initial_amount)
	: IO((x) -> print_out(x))
	: bank
;

add10 as (i) -> i + 10;
sub10 as (i) -> i - 10;

bank(10)(add10)(add10);

