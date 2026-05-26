package com.itp.amazon.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itp.amazon.service.StudentService;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

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

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception e) {

		logger.error("Unexpected server error", e);

		return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
