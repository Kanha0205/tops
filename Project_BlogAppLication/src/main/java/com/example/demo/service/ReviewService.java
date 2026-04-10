package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReviewDto;

public interface ReviewService {

	public ReviewDto addReview(ReviewDto dto, Long bid, Long uid);
	public List<ReviewDto> reviews();
	public ReviewDto	review(Long id);
	public ReviewDto updateReview(ReviewDto dto, Long rid);
	public void deleteReview(Long rid);
}
