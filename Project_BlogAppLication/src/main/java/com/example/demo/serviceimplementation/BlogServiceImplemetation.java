package com.example.demo.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.BlogCategoryDto;
import com.example.demo.dto.BlogDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Blog;
import com.example.demo.model.BlogCategory;
import com.example.demo.model.User;
import com.example.demo.repository.BlogRepository;
import com.example.demo.service.BlogCategoryService;
import com.example.demo.service.BlogService;
import com.example.demo.service.UserService;

public class BlogServiceImplemetation implements BlogService {

	@Autowired
	BlogRepository blogrepo;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	BlogCategoryService categoryservice;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public BlogDto addBlog(BlogDto dto, Long catid, Long userid) {
		dto.setCategory(categoryservice.blogCategoryById(catid));
		dto.setUser(userservice.UserById(userid));
		 Blog blog =    blogrepo.save(mapper.map(dto, Blog.class));
		return mapper.map(blog, BlogDto.class);
	}

	@Override
	public List<BlogDto> allblog() {
		List<Blog> blog =   blogrepo.findAll();
		List<BlogDto> dtos =   blog.stream().map(blogs->mapper.map(blogs, BlogDto.class)).collect(Collectors.toList());
		return dtos;
	}

	@Override
	public BlogDto blogbyId(Long id) {
	  Blog blog =   	blogrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Blog", "id", id));
		return  mapper.map(blog, BlogDto.class) ;
	}

	@Override
	public BlogDto updateBlog(BlogDto dto, Long id, Long cartid, Long userid) {
		  
		Blog blog = blogrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Blog", "id", id));
		  BlogDto createDto  =   mapper.map(blog, BlogDto.class);
	
		  createDto.setCategory(dto.getCategory());
		  createDto.setContent(dto.getContent());
		  createDto.setImage(dto.getImage());
		  createDto.setTitle(dto.getTitle());
		  createDto.setUser(userservice.UserById(userid));

		  Blog updateBlog =    blogrepo.save(mapper.map(createDto, Blog.class));
		  
		return mapper.map(updateBlog, BlogDto.class);
	}

	@Override
	public void deleteByBlog(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BlogDto> blogByCategory(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogDto> blogByUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
