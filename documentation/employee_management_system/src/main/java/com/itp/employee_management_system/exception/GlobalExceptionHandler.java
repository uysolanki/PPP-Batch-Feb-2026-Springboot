package com.itp.employee_management_system.exception;

import com.itp.employee_management_system.dto.ResponseDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.method.ParameterErrors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ResponseDTO> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> fieldErrors.put(error.getField(), error.getDefaultMessage()));
        ResponseDTO response = new ResponseDTO(HttpStatus.BAD_REQUEST.value(), "Validation failed", fieldErrors,
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseDTO> handleConstraintViolationException(ConstraintViolationException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getConstraintViolations().forEach(error -> {
            String[] fieldNameArray = error.getPropertyPath().toString().split("\\.");
            String fieldName = fieldNameArray[fieldNameArray.length-1];
            fieldErrors.put(fieldName, error.getMessage());
        });
        ResponseDTO response = new ResponseDTO(HttpStatus.BAD_REQUEST.value(), "Validation failed", fieldErrors,
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseDTO> handleHandlerMethodValidationException(HandlerMethodValidationException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        ex.getParameterValidationResults().forEach(result -> {
            if (result instanceof ParameterErrors errors) {
                errors.getFieldErrors().forEach(error -> {
                    fieldErrors.put(error.getField(), error.getDefaultMessage());
                });
            }
        });
        ResponseDTO response = new ResponseDTO(HttpStatus.BAD_REQUEST.value(), "Validation failed", fieldErrors,
                LocalDateTime.now());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleResponseNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return new ResponseEntity<String>(resourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
