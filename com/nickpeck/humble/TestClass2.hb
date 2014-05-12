package com.nickpeck.humble;
import humble.libs.IO;


@VectorSum(<TestClass> t) ::
 t.getY() + t.getX()
;


new TestClass(4, 5)
 -> IO( 
     \(<TestClass> x) :: print_out(VectorSum(x))
  );
