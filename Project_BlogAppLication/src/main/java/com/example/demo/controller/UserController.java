package com.example.demo.controller;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ModelMapper mapper;
	

	
	@PostMapping("/role/{id}")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto dto,@PathVariable("id") Long id) {
		
		UserDto user =  userService.addUser(dto, id);
	return new ResponseEntity<> (user, HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> allUser() {
	  List<UserDto> dtos = 	userService.allUser();
		return new ResponseEntity<>(dtos,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> userById(@PathVariable("id") Long id) {
		 UserDto dto =  userService.UserById(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto dto,@PathVariable("id") Long id) {
       UserDto userDto =   userService.updateUser(dto, id);
		return new ResponseEntity<>(userDto,HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/{id}")
	public  ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
	    userService.deleteUser(id);
	    return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);		
	}

}