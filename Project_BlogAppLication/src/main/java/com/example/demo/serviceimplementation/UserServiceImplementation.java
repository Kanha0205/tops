package com.example.demo.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper mapper;
	
	@Autowired
	RoleService roleService;

	
	@Override
	public UserDto addUser(UserDto dto, Long id) {
		dto.setRole(roleService.roleById(id));
	User user = 	userRepository.save(mapper.map(dto, User.class));
		return mapper.map(user, UserDto.class);
	}

	@Override
	public List<UserDto> allUser() {
	List<User> user =  userRepository.findAll();
      List<UserDto>  dtos = 	user.stream().map(users-> mapper.map(users, UserDto.class)).collect(Collectors.toList());
	
		return dtos;
	}

	@Override
	public UserDto UserById(Long id) {
		User user =   userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		return mapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto dto, Long id) {
	  User user = 	 userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
	    UserDto updateUser =   mapper.map(user, UserDto.class);
	    
	  updateUser.setUsername(dto.getUsername());
	  updateUser.setPassword(dto.getPassword());
	  updateUser.setRole(dto.getRole());
	  
	           User UserUpdated =    userRepository.save(mapper.map(updateUser, User.class));
	   
	  
		return mapper.map(UserUpdated, UserDto.class);
	}

	@Override
	public void deleteUser(Long id) {
	User user =	 userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));
		userRepository.delete(user);
	}

}
