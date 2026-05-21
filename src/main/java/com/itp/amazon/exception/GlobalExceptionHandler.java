package com.itp.amazon.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<APIError>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		List<APIError> errors=new ArrayList();
		for(FieldError error: ex.getBindingResult().getFieldErrors())
		{
			APIError er1=new APIError(error.getField(),error.getRejectedValue(),error.getDefaultMessage());
			errors.add(er1);
		}
		return new ResponseEntity<List<APIError>>(errors,HttpStatus.BAD_REQUEST);
	}
	
}
