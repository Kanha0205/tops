package com.example.demo.dto;

public class ReviewDto {

	private Long id;
	private String title;
	private BlogDto Blog;
	private UserDto user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BlogDto getBlog() {
		return Blog;
	}
	public void setBlog(BlogDto blog) {
		Blog = blog;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	  
}
