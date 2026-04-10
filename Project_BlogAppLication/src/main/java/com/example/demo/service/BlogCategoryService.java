package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BlogCategoryDto;

public interface BlogCategoryService {

	public 	BlogCategoryDto addBlogCategory(BlogCategoryDto dto);
	public List<BlogCategoryDto> allBlogCategory();
	public BlogCategoryDto blogCategoryById(Long id);
	public BlogCategoryDto updateCategory(BlogCategoryDto dto, Long id);
	public void deleteCategory(Long id);
}
