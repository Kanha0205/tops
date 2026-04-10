package com.example.demo;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProjectBlogAppLicationApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ProjectBlogAppLicationApplication.class, args);
	}
	
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
