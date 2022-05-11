package com.voytenko.services;

import com.voytenko.dto.ReviewDto;
import com.voytenko.dto.ReviewRequest;

import java.util.List;

public interface ReviewService {

    ReviewDto getReviewByOrderId(Integer orderId);

    List<ReviewDto> getReviewByClient(Integer clientId);

    ReviewDto addReview(ReviewRequest review, Integer clientId);

    void deleteReview(Integer reviewId);
}
