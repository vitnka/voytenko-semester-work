package com.voytenko.services;

import com.voytenko.dto.ReviewDto;
import com.voytenko.dto.ReviewForm;
import com.voytenko.models.Review;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAll();

    ReviewDto addReview(ReviewForm review, Integer clientId, Integer orderId);

    void deleteReview(Integer reviewId);


    List<ReviewDto> getCompletedOrderReview();
}

