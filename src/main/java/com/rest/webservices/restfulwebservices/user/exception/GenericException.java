package com.rest.webservices.restfulwebservices.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.restfulwebservices.user.UserNotFoundException;
@ControllerAdvice
public class GenericException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails details = new ExceptionDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(true));
		return new ResponseEntity<Object>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails details = new ExceptionDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(true));
		return new ResponseEntity<Object>(details,HttpStatus.NOT_FOUND);
	}
@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request	) {
		ExceptionDetails details = new ExceptionDetails(LocalDateTime.now(),ex.getFieldError().getDefaultMessage(),request.getDescription(true));
		return new ResponseEntity<Object>(details,HttpStatus.BAD_REQUEST);
	}
}
