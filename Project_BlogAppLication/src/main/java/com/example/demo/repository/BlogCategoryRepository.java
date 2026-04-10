package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BlogCategory;

public interface BlogCategoryRepository extends JpaRepository<BlogCategory, Long> {

}
