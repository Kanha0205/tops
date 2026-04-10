package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIResponse> HandelResourceNotFoundException(ResourceNotFoundException e) {
		
		APIResponse api = new APIResponse();
		api.setMessage(e.getMessage());
		api.setSuccess("false");
		
		return new ResponseEntity<>( api, HttpStatus.BAD_REQUEST);
      
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> HandleMethodArgumentException (MethodArgumentNotValidException e) {
		
		Map<String, String> map = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach((err)->{
			
			map.put(err.getField(), err.getDefaultMessage());	
		});;
		
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}
