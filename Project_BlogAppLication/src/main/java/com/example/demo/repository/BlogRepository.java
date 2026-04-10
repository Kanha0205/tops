package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Blog;
import com.example.demo.model.BlogCategory;
import com.example.demo.model.User;

public interface BlogRepository extends JpaRepository<Blog, Long>{

	public List<Blog> findByCategory(BlogCategory bc);
	public List<Blog> findByUser( User user);
}
