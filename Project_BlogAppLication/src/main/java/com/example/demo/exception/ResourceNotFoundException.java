	package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	String ResourceName;
	String fieldName;
	Long id;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Long id2) {
		super(resourceName+" with "+fieldName+" : "+id2+"  is not found");
		ResourceName = resourceName;
		fieldName = fieldName;
		this.id = id2;
	}
	

}
