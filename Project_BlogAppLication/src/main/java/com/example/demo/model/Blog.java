package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	
private String title;
@Column(columnDefinition = "TEXT")
private String content;
private String image;

@ManyToOne
@JoinColumn(name="category_id", nullable = false)
private BlogCategory category;

@ManyToOne
@JoinColumn(name="user_id", nullable = false)
private User user;

@OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
private List<Review> reviews;

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

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public BlogCategory getCategory() {
	return category;
}

public void setCategory(BlogCategory category) {
	this.category = category;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public List<Review> getReviews() {
	return reviews;
}

public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}



}
