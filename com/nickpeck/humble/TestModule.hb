/*
	humble introductory examples.

	Some examples of the humble language in action.
	humble is a functional, dynamically typed scripting 
	language that uses lazy evaluation.
	
	The source code is compiled to a java class file, so you can package it
	in a jar, and link to it from other code written in the Java language.
*/
package com.nickpeck.humble;

import humble.runtime.Constants;
import humble.runtime.IO;


/*
	hello world
*/
fprint("Hello world!");

/*
	bind the output to a new lambda function (->)
	(this is another way of writing the above, only
	that if the left arg is Nothing then the right is
	never evaluated).
*/

"Hello again!" -> fprint;

/*
	Example of using recursion to make a simple iterator.
	There is no language construct that allows a 'for loop', 
	and that without optimisations, the JVM does not allow
	for infinite recursion
*/
@iterator(x,y) ::
	fprint(x) ->
	if equals(x,y)
	then fprint("Values are equal!!!")
	else iterator(x + 1, y)
;

iterator(11,20);


/* 
	map and filter are important functional concepts,
	that remove the need for loops. Here they are in 
	action.
	
	map applies a function to every item in a list:
*/

map(\(a) :: plus(a,1), [1,2,3,4,5,6]) -> fprint;

/*
	filter removes items from a list that fail
	a given evaluation function:
*/
filter(\(a) :: equals(a,2), [1,2,3,4,2,6]) -> fprint;

/* map and filter combined */
map(\(a) :: a+1, filter(\(a) :: equals(a,2), [1,2,3,4,2,6])) -> fprint;

/* 
	now, lets use the range function to generate a list for us,
	and print each item
*/
map (\(a) :: fprint(a), range(1,20));

/* 
	Glue is a handy operation for joining a list of items with
	given spacer. Other useful String operators such as str_cat
	are built in.
*/
glue(" ", ["I", "like", 2, "boogie"]) -> fprint;


/*
	This is an example of 'currying'.
	The function f returns a lambda (anonymous) function back
	up to the caller.
	The caller can then supply a new argument, and the process continues...
	
	Note that the returned value will be displayed as 'lambda', unless
	you use debugging statements in your code
*/
@f(a) :: 
	\(b) :: f(plus(fprint(a), b));

f(3)(4)(5)(6)(7)(8);

/*
	Finally, an example of maintaining state in a functional manner.
	We cannot assign values to variables in the traditional manner,
	but that does not stop us using functional calculus to chain a value
	from one function to the next.
	
	Combined with the fact that humble uses 'lazy evaluation' (i.e. the each stage
	is not evaluated until required, we are effectively passing the state of the
	bank balance from one modifier to the next.
	
	Once again, the displayed return value is 'lambda', unless you modify the function
	to include logging, or insert print statements in your code.
*/
@bank(initial_amount) ::
	\ (modifier) :: modifier(fprint(initial_amount))
		-> bank
;

@add10(i) :: i + 10;
@sub10(i) :: i - 10;

bank(10)(add10)(add10)(sub10);

/*
	factorial example, to make life interesting,
	launch in a new thread and set the print statement
	as a callback.
*/

@_factorial(n, accumulator):: 
	if equals(n, 0)
	then accumulator
	else _factorial(n - 1, n * accumulator)
;

@factorial(n)::
	_factorial(n,1)
;

thread(
	factorial(1), 
	\(i) :: fprint(str_cat("The factorial is : ", i))
	);

/*
	Threads are interesting in that they immediately return a 'Guardian' object.
	The guardian can be called like any regular function - if the thread has completed
	it will return the result - otherwise it will return a lambda function that can be called
	later on the yield the result.
*/
thread(
	map(\(i) :: i*i, range(1,10000))
		,
		fprint("finished")
	) -> \(res) :: fprint(res());
	
/*
	humble supports tail recursion in limited circumstances
	The following example outlines a function with a 'tail'
	optimisation. This is a language-level feature that can only
	be used in this given context:
	tail {terminating condition} : {recursion};
	
*/
	
@r(v)::
	tail equals(v,10) : v+1;
	;
	
	
r(1) -> fprint;

/*
	Import from another module. You must match fully qualified name in the import statement.
	Supply a lambda function that takes no arguments.
*/
Constants(:: MONTHS_IN_A_YEAR()) 
	-> \(i) :: 
		fprint(str_cat("There are ", i, " months in a year."));
		
/*
	Heres another example, lets read some input (run this in a console session)
*/
IO(
	::read_in("What is your name?")
	->\(s) :: toStr(s)
)
	->\(name) ::
		fprint(str_cat("Welcome ", name));


/*
	Read from a URL
*/

IO(
	::url("http://www.google.com") 
	->\(u) :: url_read(u)
	->\(r as [res, url]) :: toStr(res)
)
	-> fprint;
	
		
/*
	dereferencing the members of a list:
*/
@deref(l as [x,y]) ::
	x+y;
	
deref([4, 5]) -> fprint;

/*
	Finally, basic writer monad. This enables us to debug a complex statement:
	
	firstly, we need a function to raise a simple 'value' to a complex that 
	supports logging:
*/
@writer_raise(value):: [value,[]];

/*
	Define a function that increments a value and logs this event.
	Also define one that carries out the subtraction.
*/
@writer_add(writer as [value, log]) :: [value+1, append(log, " add 1 ")];

@writer_sub(writer as [value, log]) :: [value-1, append(log, " sub 1 ")];

/*
	Define a function that takes the result of this writer and prints a verbose 
	trace:
*/
@writer_print(writer as [value, log]):: 
	str_cat("The final value is ", value, " and the log is : ", log)
		->fprint
	;

/*
	Finally, the full expression:
*/
writer_raise(1) 
	-> \(writer) :: writer_add(writer)
		->\(writer1) :: writer_sub(writer1)
			->\(writer2) :: writer_print(writer2)
	;





