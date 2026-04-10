package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.dto.RoleDto;
import com.example.demo.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {
@Autowired
	RoleService roleService;

@PostMapping("/")
public ResponseEntity<RoleDto> addRole(@RequestBody RoleDto dto) {
	RoleDto createRole =  roleService.addRole(dto);
	return new ResponseEntity<>(createRole, HttpStatus.CREATED);
}

@GetMapping("/")
public ResponseEntity<List<RoleDto>> allRole() {
	List<RoleDto>  roles =   roleService.allRole();
	return new ResponseEntity<>(roles, HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<RoleDto> roleByid(@PathVariable("id") Long id){
  RoleDto role =	 roleService.roleById(id);
  return new ResponseEntity<>(role, HttpStatus.OK);
}

@PutMapping("/{id}")
public ResponseEntity<RoleDto> updateRole(@RequestBody RoleDto role, @PathVariable("id") Long id) {
     RoleDto dto = 	roleService.updateRole(role, id);
     return new ResponseEntity<>(dto, HttpStatus.CREATED);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> roleDelete(@PathVariable Long id) {
	roleService.deleteRole(id);
	return new ResponseEntity<>("Role deleted Successfully", HttpStatus.OK);
}






}
