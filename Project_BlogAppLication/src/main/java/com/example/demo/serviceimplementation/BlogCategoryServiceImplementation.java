package com.example.demo.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.BlogCategoryDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.BlogCategory;
import com.example.demo.repository.BlogCategoryRepository;
import com.example.demo.service.BlogCategoryService;

public class BlogCategoryServiceImplementation implements BlogCategoryService{

	
	@Autowired
	BlogCategoryRepository repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public BlogCategoryDto addBlogCategory(BlogCategoryDto dto) {
   BlogCategory category =  repo.save(mapper.map(dto, BlogCategory.class));
		return mapper.map(category, BlogCategoryDto.class);
	}

	@Override
	public List<BlogCategoryDto> allBlogCategory() {
		List<BlogCategory> categories = repo.findAll();
		List<BlogCategoryDto> categoryDto = 
				categories.stream().map((ele)->mapper.map(ele, BlogCategoryDto.class)).collect(Collectors.toList());
		return categoryDto;
	}

	@Override
	public BlogCategoryDto blogCategoryById(Long id) {
		BlogCategory blogcategory = 
				repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("BlogCategory", "id", id));
		
		return mapper.map(blogcategory, BlogCategoryDto.class);
	}

	@Override
	public BlogCategoryDto updateCategory(BlogCategoryDto dto, Long id) {
		BlogCategory blogCategory = 
				repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("BlogCategory", "id", id));
		blogCategory.setName(dto.getName());
		
		BlogCategory updatedBlgcat = repo.save(blogCategory);
		
		return mapper.map(updatedBlgcat, BlogCategoryDto.class);
	}

	@Override
	public void deleteCategory(Long id) {
		BlogCategory blogCat = 
				repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("BlogCategory", "id", id));
		repo.deleteById(id);
	}

}
