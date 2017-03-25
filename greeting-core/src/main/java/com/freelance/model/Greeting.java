package com.freelance.model;

/**
 * 
 * Spring uses the Jackson JSON library to automatically marshal instances of
 * type Greeting into JSON.
 * 
 * 
 * @author mugiwaranorufi
 *
 */
public class Greeting {

	private final long id;
	private final String content;

	public Greeting() {
		this.id = -1;
		this.content = "";
	}

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}