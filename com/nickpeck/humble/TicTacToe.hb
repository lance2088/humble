package com.nickpeck.humble;

import humble.runtime.IO;

/*******************/
/***Tick Tac Toe****/
/*******************/

//nick peck 2013

@new_matrix():: 
	["-", "-", "-", 
	 "-", "-", "-", 
	 "-", "-", "-"];
	 
@print_matrix(matrix as [a,b,c,d,e,f,g,h,i]) ::
	str_cat(" a b c", 
		"\n1", glue(" ", [a,b,c]), 
		"\n2", glue(" ", [d,e,f]), 
		"\n3", glue(" ", [g,h,i]))
	-> fprint;
	
@prompt_next_slot() ::
	IO(::read_in("Which col? (a1,b2,c3 etc...)") -> toStr)
	;

@aquire_slot(symbol, slot, new_matrix, old_matrix as [mH:mT], slot_names as [sH:sT]) ::
    if length(old_matrix) is 0
	then false
	else if slot is sH
		 then if mH is "-"
			 then new_matrix + [symbol] + mT
			 else false
		 else aquire_slot(symbol, slot, new_matrix + [mH], mT, sT)
	;

@aquire_next_empty_slot(new_matrix, original_matrix as [H:T], player_symbol) ::
	if length(original_matrix) is 0
	then false
	else if H is "-"
		then (new_matrix + [player_symbol]) + T
		else if length(new_matrix) is 0
			 then aquire_next_empty_slot([H],T,player_symbol)
             else aquire_next_empty_slot(new_matrix + [H],T,player_symbol)
	;

@win(matrix, vectors as [v1,v2,v3], player_symbol)::
	//fprint(get(matrix, v1)) -> 
	get(matrix, v1) is player_symbol
	& get(matrix, v2) is player_symbol
	& get(matrix, v3) is player_symbol
	;
	
@win_condition(matrix, player_symbol)::
	win(matrix, [0,1,2], player_symbol)
	| win(matrix, [3,4,5], player_symbol)
	| win(matrix, [6,7,8], player_symbol)
	| win(matrix, [0,3,6], player_symbol)
	| win(matrix, [1,4,7], player_symbol)
	| win(matrix, [2,5,8], player_symbol)
	| win(matrix, [0,4,8], player_symbol)
	| win(matrix, [0,2,4], player_symbol)
	;
	

@gen_slot_names()::
	map(
		\(i) :: map(
			\(c) :: str_cat(c,i),
			["a", "b", "c"])
		, range(1,3)
	);
	
@SLOT_NAMES() :: ["a1","b1","c1","a2","b2","c2","a3","b3","c3"];
	
@turn(matrix) ::
	print_matrix(matrix) -> matrix -> prompt_next_slot()
	-> \(slot) :: aquire_slot("0", slot, [], matrix, SLOT_NAMES())
	-> \(matrix) ::
		if fprint(matrix) is false
		then fprint("Requested slot not available")
		else aquire_next_empty_slot([], matrix, "X")
		-> \(matrix) :: 
			if win_condition(matrix, "X")
			then fprint("Player X has won")
			else if win_condition(matrix, "0")
				then fprint("Player 0 has won")
				else turn(matrix)
	;

turn(new_matrix());
