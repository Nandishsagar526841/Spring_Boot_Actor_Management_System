package com.jsp.springboot.actordb.utility;

public class ErrorStructure<T>{
	
	private int errorCode;
	private String message;
	private T error;
	
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getError() {
		return error;
	}
	public void setError(T error) {
		this.error = error;
	}
	
	
	

}
