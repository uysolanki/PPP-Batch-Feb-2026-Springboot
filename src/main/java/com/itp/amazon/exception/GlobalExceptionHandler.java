package com.itp.amazon.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.itp.amazon.controller.ProductController;
import com.itp.amazon.controller.StudentControllerFE;
import com.itp.amazon.util.ProductCategory;

//@ControllerAdvice
@RestControllerAdvice(assignableTypes = {
	    ProductController.class, StudentControllerFE.class
	})
public class GlobalExceptionHandler {

	//private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

	private static final Logger logger =LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<APIError>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		logger.warn("Validation Problem while adding Student ");
		List<APIError> errors = new ArrayList();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			logger.warn("Field {} ", error.getField());
			logger.warn("Rejected Value {} ", error.getRejectedValue());
			logger.warn("Message {} ", error.getDefaultMessage());
			APIError er1 = new APIError(error.getField(), error.getRejectedValue(), error.getDefaultMessage());
			errors.add(er1);
		}
		return new ResponseEntity<List<APIError>>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<APIError> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		logger.warn("Validation Problem while adding Product ");
		
		 Throwable cause=ex.getCause();
		 Object rejected = null; 
		 String fieldName=null;
		 String message="Invalid Request";
		 String allowedValues=null; 
		 
		 
		 if(cause instanceof com.fasterxml.jackson.databind.exc.InvalidFormatException invalidFormatEx)
		 {
			 rejected=invalidFormatEx.getValue();
			 
			 if (!invalidFormatEx.getPath().isEmpty()) 
			 fieldName=invalidFormatEx.getPath().get(0).getFieldName();
		 }
		 

		// message=ex.getCause() !=null ? ex.getCause().getMessage() : ex.getMessage();
		 
		 allowedValues= Arrays.stream(ProductCategory.values())
				 .map(ProductCategory::getCategory)
				 .collect(Collectors.joining(", "));
		
		 APIError error = new APIError("Invalid "+fieldName+", Allowed values ["+allowedValues+"]", rejected, message);

		return new ResponseEntity<APIError>(error,HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception e) {

		logger.error("Unexpected server error", e);

		return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
