package com.sample.jpaglobalexceptiondemo.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sample.jpaglobalexceptiondemo.pojos.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleApplicationExceptions(Exception ex, WebRequest webReq) {
		List<String> errorMsg = new ArrayList<String>();
		errorMsg.add(ex.getLocalizedMessage());
		ErrorResponse errRes = new ErrorResponse("410", errorMsg);
		return new ResponseEntity<>(errRes,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException userEx){
		List<String> errorMsg = new ArrayList<String>();
		errorMsg.add(userEx.getLocalizedMessage());
		ErrorResponse errRes = new ErrorResponse("411", errorMsg);
		
		return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateUserException.class)
	public final ResponseEntity<Object> handleDuplicateuserException(DuplicateUserException duplicateUserEx){
		List<String> errorMsg = new ArrayList<String>();
		errorMsg.add(duplicateUserEx.getLocalizedMessage());
		ErrorResponse errRes = new ErrorResponse("412", errorMsg);
		
		return new ResponseEntity<>(errRes,HttpStatus.BAD_REQUEST);
	}
	
}
