package com.jsp.springboot.actordb.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springboot.actordb.exception.ActorNotFoundByIdException;
import com.jsp.springboot.actordb.exception.ActorNotFoundException;
@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorNotFoundById(ActorNotFoundByIdException ex){
		
		ErrorStructure<String> es=new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setError(ex.getMessage());
		es.setMessage("Actor Object with the requested id is not available in the DataBase!!");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> actorNotFound(ActorNotFoundException e){
		ErrorStructure<String> es=new ErrorStructure<String>();
		es.setErrorCode(HttpStatus.NOT_FOUND.value());
		es.setError(e.getMessage());
		es.setMessage("Actor Object is not in the DataBase!!");
		
		return new ResponseEntity<ErrorStructure<String>>(es,HttpStatus.NOT_FOUND);
	}

}
