package com.nickpeck.humble;

import humble.libs.IO;
import humble.libs.Yield;

@long_process(x) ::
 if equals(x, 1000)
 then x
 else long_process(x + 1)
;

@print(x)::
 x->IO(\(x) :: print_out(x))
;

@itter(x as [H:T], l) ::
 if equals(length(x), 0)
 then l
 else Yield(::attempt(H))
  ->\(x) :: append(x,l)
   ->\(new_l) :: itter(T, new_l) 
;

itter([1+1,2+2,3+3,4+4,5+5], []) -> print;
