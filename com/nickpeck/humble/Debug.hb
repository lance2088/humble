package com.nickpeck.humble;
import humble.runtime.IO;

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
map (\(a) :: a, range(1,20)) -> fprint;
/*
	Read from a URL
*/

IO(
	::url("http://www.google.com") 
	->\(u) :: url_read(u)
	->\(r as [res, url]) :: toStr(res)
)
	-> fprint;
	