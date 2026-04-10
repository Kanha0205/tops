package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.RoleDto;

public interface RoleService {

	public RoleDto addRole(RoleDto dto);
	public List<RoleDto> allRole();
	public RoleDto roleById(Long id);
	public RoleDto updateRole(RoleDto dto,Long  id);
	public  void deleteRole(Long id);
	
}
