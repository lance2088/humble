package com.nickpeck.humble;

/* 
 test the list slice / dereferencing of a list in a function header.
 
 there are two forms:
 (list as [X:Y]) splits the list into head and tail (X and Y)
 (list as [a,b,c]) splits the list into list members

 expected responses:
 [[[1,2,3,4,5], 1, [2,3,4,5]]
 [[1], 1, []]
 [[], [], []]
 [[1,2,3], 1, 2, 3]]
*/

@slice(list as [H:T]) :: [list, H, T];

@slice2(list as [a,b,c]) :: [list, a,b,c];

[slice([1,2,3,4,5]), slice([1]), slice([]), slice2([1,2,3])] -> fprint;