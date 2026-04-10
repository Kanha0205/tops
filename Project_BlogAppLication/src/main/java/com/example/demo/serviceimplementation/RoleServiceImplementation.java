package com.example.demo.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RoleDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImplementation implements RoleService{
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ModelMapper   mapper;
	
	@Override
	public RoleDto addRole(RoleDto dto) {
		Role role =   roleRepository.save(mapper.map(dto, Role.class));
		return mapper.map(role, RoleDto.class);
	}

	@Override
	public List<RoleDto> allRole() {
	  List<Role>	roles = roleRepository.findAll();
	  List<RoleDto> dtos =   roles.stream().map(role-> mapper.map(role, RoleDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public RoleDto roleById(Long id) {
	      Role role = 	roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));
		return mapper.map(role, RoleDto.class);
	}

	@Override
	public RoleDto updateRole(RoleDto dto, Long id) {
		Role role =   roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));
		role.setName(dto.getName());
		 Role roleUpdated = roleRepository.save(role);
		return mapper.map(roleUpdated, RoleDto.class);
	}

	@Override
	public void deleteRole(Long id) {
	    Role role = 	roleRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Role", "id", id));
		roleRepository.delete(role);
	}

}
