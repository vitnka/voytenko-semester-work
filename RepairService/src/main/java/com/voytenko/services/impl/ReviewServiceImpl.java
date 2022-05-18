package com.voytenko.services.impl;

import com.voytenko.dto.ReviewDto;
import com.voytenko.dto.ReviewForm;
import com.voytenko.models.Order;
import com.voytenko.models.Review;
import com.voytenko.models.User;
import com.voytenko.repositories.OrderRepository;
import com.voytenko.repositories.ReviewRepository;
import com.voytenko.repositories.UserRepository;
import com.voytenko.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<ReviewDto> findAll() {
        return ReviewDto.from(reviewRepository.findAll());
    }

    @Override
    public ReviewDto addReview(ReviewForm reviewRequest, Integer clientId, Integer orderId) {

        User user = userRepository.getById(clientId);
        Order order = orderRepository.getById(orderId);

        Review review = Review.builder()
                .user(user)
                .order(order)
                .comment(reviewRequest.getComment())
                .date(Timestamp.valueOf(LocalDateTime.now()))
                .rating(reviewRequest.getRating())
                .build();

        reviewRepository.save(review);
        return ReviewDto.from(review);
    }

    @Override
    public void deleteReview(Integer reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);

        review.ifPresent(reviewRepository::delete);

    }

    @Override
    public List<ReviewDto> getCompletedOrderReview() {
        return ReviewDto.from(reviewRepository.findAllByOrderCompleted());
    }
}
