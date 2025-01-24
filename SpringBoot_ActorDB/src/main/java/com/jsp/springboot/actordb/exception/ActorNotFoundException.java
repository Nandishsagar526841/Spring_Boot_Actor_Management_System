package com.jsp.springboot.actordb.exception;

public class ActorNotFoundException extends RuntimeException {

	private String message;

	public ActorNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	} 
}
