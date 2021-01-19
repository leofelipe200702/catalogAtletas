package com.atletas.catalogAtletas.resources.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.atletas.catalogAtletas.services.exception.DataBaseException;
import com.atletas.catalogAtletas.services.exception.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
		StandardError err = new StandardError();

		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError(ex.getMessage());
		err.setMessage("Resource Not Found");
		err.setPath(req.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBaseViolation(DataBaseException ex, HttpServletRequest req) {
		StandardError err = new StandardError();

		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError(ex.getMessage());
		err.setMessage("Database Exception");
		err.setPath(req.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException ex, HttpServletRequest req) {
		ValidationError err = new ValidationError();

		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		err.setError(ex.getMessage());
		err.setMessage("Argumento não Válido");
		err.setPath(req.getRequestURI());
		
		for(FieldError fieldError: ex.getBindingResult().getFieldErrors()) {
			err.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);

	}
	
	

}
