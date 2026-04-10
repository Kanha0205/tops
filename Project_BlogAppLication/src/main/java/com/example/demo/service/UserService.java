package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDto;

public interface UserService {

	public UserDto addUser(UserDto dto, Long id);
	public List<UserDto> allUser();
	public UserDto UserById(Long id);
	public UserDto updateUser(UserDto dto, Long id);
	public void deleteUser(Long id);
	
}
