package com.freelance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This project is a Javascript client that will consume the greeting service.
 * To run the client, we need to serve it from a web server, in our case an
 * embedded Tomcat server.
 * 
 * <p>
 * Spring Boot WebMvcAutoConfiguration will set index.html as the default
 * welcome page.
 * <p>
 * 
 * @author mugiwaranorufi
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
