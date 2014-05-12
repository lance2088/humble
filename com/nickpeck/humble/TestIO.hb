package com.nickpeck.humble;

import humble.runtime.IO;

/*
 Demonstration of using the built-in IO module for scraping a webpage
 Note that url_read and file_read both return IOStr (a wrapper for String | Nothing),
 so it is important to call IO(::toStr()) on this before passing it back for use in the outside world
*/

@url_scraper(url_as_str, filename) ::
	IO(
		::url(url_as_str) 
		-> \(url) :: url_read(url)
		-> \(get as [response, u]) :: [file(filename), response]
		-> \(get as [f, response]) :: file_write(f, toStr(response))
	);
	
url_scraper("http://google.com", "scrape_result.html") -> fprint;