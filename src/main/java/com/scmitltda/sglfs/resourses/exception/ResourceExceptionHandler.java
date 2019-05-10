package com.scmitltda.sglfs.resourses.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.scmitltda.sglfs.services.exception.InvalidArgumentNumberException;
import com.scmitltda.sglfs.services.exception.ObjectFoundException;
import com.scmitltda.sglfs.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError err = 
				new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(ObjectFoundException.class)
	public ResponseEntity<StandardError> objectFound(ObjectFoundException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.FOUND;
		
		StandardError err = 
				new StandardError(System.currentTimeMillis(), status.value(), "Já existe no banco de dados", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
		
	}
	
	@ExceptionHandler(InvalidArgumentNumberException.class)
	public ResponseEntity<StandardError> invalidArgument(InvalidArgumentNumberException e, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.FOUND;
		
		StandardError err = 
				new StandardError(System.currentTimeMillis(), status.value(), "Número de parâmetros invalidos.", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
		
	}
}
