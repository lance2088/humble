package com.nickpeck.humble;

@bank(initial_amount) ::
	\ (modifier) :: modifier(initial_amount)
		-> bank
;

@add10(i) :: i + 10;
@sub10(i) :: i - 10;

bank(10)(add10)(add10)
		-> fprint;