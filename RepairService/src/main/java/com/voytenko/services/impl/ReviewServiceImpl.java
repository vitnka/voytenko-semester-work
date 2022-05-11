package com.voytenko.services.impl;

import com.voytenko.dto.ReviewDto;
import com.voytenko.dto.ReviewRequest;
import com.voytenko.exceptions.ReviewNotFoundException;
import com.voytenko.models.Client;
import com.voytenko.models.Review;
import com.voytenko.repositories.ClientRepository;
import com.voytenko.repositories.ReviewRepository;
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
    private final ClientRepository clientRepository;

    @Override
    public ReviewDto getReviewByOrderId(Integer orderId) {
        return ReviewDto.from(reviewRepository.findByOrderId(orderId)
                .orElseThrow(() -> new ReviewNotFoundException(orderId)));
    }

    @Override
    public List<ReviewDto> getReviewByClient(Integer clientId) {
        return ReviewDto.from(reviewRepository.findByClientId(clientId));
    }

    @Override
    public ReviewDto addReview(ReviewRequest reviewRequest, Integer clientId) {

        Client client = clientRepository.getById(clientId);

        Review review = Review.builder()
                .client(client)
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
}
