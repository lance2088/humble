package com.nickpeck.humble;

/*
	test that an exception is correctly caught and that 
	nothing is retuned.
	
	expected response:
	[
	Run for your life, Frodo!,
	Run for your life, Sam!,
	Thou shalt not pass!,
	Run for your life, Legolas!
	]
*/

@monster_check(name) ::
	if name is "Bal-roc"
	then nothing
	else run_hobbit_run(name)
	;
	
@run_hobbit_run(name) ::
	str_cat("Run for your life, ", name, "!");


map(
	\(name) :: 
		either (
			monster_check(name),
			"Thou shalt not pass!"
		),
		["Frodo", "Sam", "Bal-roc", "Legolas"]		
) -> fprint;