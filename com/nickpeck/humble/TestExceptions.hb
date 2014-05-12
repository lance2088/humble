package com.nickpeck.humble;

import humble.libs.IO;
import humble.libs.Yield;



@unsafeMethod(x) :: 2 + x; /*This could fail! can't add something that isn't a _Number*/

@print(x) :: x -> IO(:: print_out(x));

@dodgyConditional() ::
 if gtr_than("hello", 5)
 then "got if"
 else "got else"
;

/*
 Runtime exceptions only manifest when yield is invoked.
 To prevent you 'forgetting' exceptions in lower-level code, you can only catch them in the top level, like this:

*/


/* calling a function that will fail, intercepting the error before leaving Yield*/
Yield(
 ::attempt(unsafeMethod("Hello!"))
 ->\(outcome) ::
  grab(
   <humble.runtime._Exception>,
   outcome, 
   \(e) :: str_cat("there was a runtime error : ", e)
  )
) -> \(e) :: print(e);

/* this time, it should be OK*/
Yield(
 ::attempt(unsafeMethod(2))
 ->\(outcome) ::
  grab(
   <humble.runtime._Exception>,
   outcome, 
   \(e) :: str_cat("there was a runtime error : ", e)
  )
) -> \(e) :: print(e);


Yield( 
 ::attempt(dodgyConditional())
 ->\(outcome) ::
  grab(
   <humble.runtime._Exception>,
   outcome, 
   \(e) :: str_cat("there was a runtime error : ", e)
  )
) -> \(e) :: print(e);


/* another failure, but no error handling... at your own risk! */
Yield( 
 ::attempt(dodgyConditional())
) -> \(e) :: print(e);
