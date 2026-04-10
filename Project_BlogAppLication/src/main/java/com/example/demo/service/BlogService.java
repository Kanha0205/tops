package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BlogDto;

public interface BlogService {

	public BlogDto addBlog(BlogDto dto, Long catid, Long userid);
	public List<BlogDto> allblog();
	public BlogDto blogbyId(Long id);
	public BlogDto updateBlog (BlogDto dto,Long id, Long cartid, Long userid);
	public void deleteByBlog(Long id);
	public List<BlogDto> blogByCategory(Long id);
	public List<BlogDto> blogByUser(Long id);
	
	
}
