HUMBLE
======================

nb. This project has still in a design phase. The documentation will grow as the project evolves. Thanks for stopping by.

If you want a quick glance at the syntax - check out com/nickpeck/humble/Test.hb I try to keep that up-to-date with the latest grammar.

Humble is a dynamic, lazy functional programming language. It compiles to Java bytecode, so it can be run on the JVM, and is interoprable with standard Java code.

It has a clear syntax that is easy to learn, and allows you to use powerful features that are otherwise very clumbersome, or unnatural in normal Java code.

The project is still in an initial development phase, but the ultimate goal is a platform for solving real-world business problems, with computational load distributed over a series of networked servers.

Why Would I Want to Use This?
-----------------------------
* It is dynamic, and is suited to quick prototyping and development.

* It forces you to break a problem down into small functions. This makes it very easy to test and verify each consituent part, and their integration into the whole.

* It forces a style of programming that tries to avoid side-effects. There are no global variables, and variable assignment (in the traditional sense) is not allowed. This goes a long way to eliminating a number of common errors, and has another unexpected side effect in that it becomes much easier to create applications that can take advantage of parrallel processing opportunities.

* It uses 'lazy' evaluation, in that expressions are only evaluated when required. Say for example that you had a large list of time consuming tasks to perform, but you only require specific members of this collection? It would make sense to evaluate only these results that are to be printed. Humble performs these optimisations for you, so you can get on w

* It allows you to make use of infinate tail recursion - this is a powerful technique used by a declaritive languages to allow you to express complex problems in a concise form. This is very limited in conventional Java, due to the stack limits imposed by the virtual machine. Humble, however, is stackless, so recursion is used as a primary language feature.

* It is interopable with existing Java code, so you can choose which parts of your application are best suited to the tools at your disposal.

Quick Tour
----------

#### 1. Everything is a Function!
The first thing you need to know, is that in Humble, everything is a function. We declare a function by providing a name (or 'alias') precedded by '@'. The declaration lists the expected variables in the familiar manner, followed by '::' which means 'is an alias of'. This follows is a single statment terminated by a semi-colon.

	simple_add as (x,y) ->
	 x + y
	;

Whenever the function is invoked, it will return the result of the statement within. A function should always return a value. There are no 'void' or 'null' types. As we would expect, the function is invoked by calling the alias, providing some values for it to perform upon:

	simple_add(2,5);

Everything is a function, not just in the traditional sense as shown above, but numbers and strings too are functions that perpetually return copies of themselves! There is nothing to stop you writing:

	2();
	23.5();
	"Hello world!"();

There are no 'variables' in the sense that you will be familiar with. This is because of the 2nd principle: "Everything is immutable".


#### 2. Everything is Immutable!
Because of this, you can't go around assigning values to variables like you may be used to:

	greeting = "Hello world";

Humble goes as far as to eliminate the assignment operator '='  altogether. You can, however declare a 'Alias' that returns a value:

	greeting as () -> "hello world";

Now, greeting() will be an alias for the string "hello world" throughout your program. But, because everything is immutable, you cannot re-declare greeting() later on in your program.

#### 3. Functions are First Class Entities!

This may sound terribly restrictive, but in fact, it goes a long way to eliminating an important category of programing errors. Ever written a class that where you initialised a class variable in the constructor, only to accidentally modify it later on and spend ages debugging the error? Or perhaps you declared a class member as 'null' or 'void' and forgot to initialize it when the class is instantiated? You'll be pleased to hear that both of these conditions cannot occur in Humble code. Another instant advantage is that you can pass 'uncalled' functions around and re-use them in different contexts, just like Javascript or Python do. For example:

	addTwo as (x) ->
	 x + 2
	;

	subTwo as (x) ->
	 x - 2
	;

	do_something_with_x as (modifier, x) ->
	 modifier(x)
	;

	do_something_with_x(addTwo, 3);
	do_something_with_x(subTwo, 3);

Or, heres another, more useful application. Say your want to refactor the part of your application that loads files into a common method (or 'load_file'). However, you need to have a different response depending on the kind of file being loaded? This is where you can use a callback:

	@load_file as (filename, callback) ->
	 if load(filename)
	 then callback
	 else "The file could not be loaded!"
	;

	load_file("user.settings", display_user_settings);
	load_file("log.txt", open_logfile_editor);

This helps keep our programs light, small and maintainable!

You may have noticed that we have skipped the traditional hello world example. We have to cover a few more basics before we can write programs that interact with stdout.

#### 4. Use Lambda (inline) functions.

The example above assumed that we had already defined two functions (display_user_settings and open_logfile_editor) in our code. However, for smaller tasks, it is possible to create a lambda or inline function. This look similar to regular functions, except that they have no alias because they exist only inside of statements. Here is an example:

	(x) -> x + 2;

So, in a very simple sense, the last example ('do_something_with_x') could have been written like this:


	do_something_with_x as (modifier, x) ->
	 modifier(x)
	;

	do_something_with_x((x) -> x+2, 3);
	do_something_with_x((x) -> x-2, 3);


#### 5. Functions can Return Functions

Functions can return lambda functions that you can re-use later. This is known as 'currying':

	curried_application as (x) ->
	 (y) ->
	  (z) ->
	    str_cat(x,y,z)
	;

You can call it like this:

	curried_application("Hows")(" it ")("going?");

Or you could just apply partial arguments and use bind the rest later in your application:
	 
	partial_curry as () -> curried_application("Hows")(" it ");

	(...much later on in your application)

	partial_curry()("going?");

#### 6. Creating a module:
In Humble, code is organised into logical units, or modules. A module compiles to a Java .class file contains a number of functions, and any free-standing code that is executed if the class is invoked at the command-line (java MyModule.class).

We are now ready to create a hello world example!

Create a subfolder 'MyPackage' and create a new Humble source code file "HelloWorld.hb":

	package MyPackage;
	import humble.libs.IO;

	print as (str) ->
	 str : IO.print_out
	;

	print("Hello, world!");

Save it, and then, using the command prompt, cd back to the parent folder (the one containing 'MyPackage'), and invoke the Humble compiler:


	$ java -jar Humble.jar MyPackage/HelloWorld.hb
	$ cd MyPackage/
	$ java HelloWorld.class
	Hello, world!
