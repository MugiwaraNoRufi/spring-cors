package com.freelance.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freelance.model.Greeting;

/**
 * In Spring’s approach to building RESTful web services, HTTP requests are
 * handled by a controller.
 * 
 * @author mugiwaranorufi
 *
 */
@RestController
public class GreetingController {

	private static final String template = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();

	/**
	 * <p>
	 * The {@code @RequestMapping} annotation ensures that HTTP requests to
	 * <b>"/greeting"</b> are mapped to the <b>"greeting()"</b> method.
	 * </p>
	 * <p>
	 * {@code @GetMapping} annotation acts as a shortcut for
	 * {@code @RequestMapping(method = RequestMethod.GET)}
	 * </p>
	 * 
	 * <p>
	 * {@code @RequestParam} binds the value of the query string parameter name
	 * into the name parameter of the greeting() method. This query string
	 * parameter is not required; if it is absent in the request, the
	 * defaultValue of <b>"World"</b> is used.
	 * </p>
	 * 
	 * <p>
	 * The Greeting object must be converted to JSON. Thanks to Spring’s HTTP
	 * message converter support, you don’t need to do this conversion manually.
	 * Because Jackson is on the classpath, Spring’s
	 * <code>MappingJackson2HttpMessageConverter</code> is automatically chosen
	 * to convert the Greeting instance to JSON.
	 * </p>
	 */
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
		System.out.println("==== Greetings ! ====");
		// The ID value will increment each time we refresh the page.
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
