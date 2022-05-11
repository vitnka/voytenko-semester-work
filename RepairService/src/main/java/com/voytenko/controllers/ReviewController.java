package com.voytenko.controllers;

import com.voytenko.dto.ReviewDto;
import com.voytenko.dto.ReviewRequest;
import com.voytenko.models.User;
import com.voytenko.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping("/{order_id}")
    public ResponseEntity<ReviewDto> getReviewByOrder(@PathVariable("order_id") Integer orderId){
        return ResponseEntity.ok().body(reviewService.getReviewByOrderId(orderId));
    }

    @GetMapping()
    public ResponseEntity<List<ReviewDto>> getReviewByClient(Authentication authentication){
        Integer clientId = ((User) authentication.getPrincipal()).getId();
        return ResponseEntity.ok().body(reviewService.getReviewByClient(clientId));
    }

    @PostMapping("add")
    public ResponseEntity<ReviewDto> addReview(@RequestBody ReviewRequest review, Authentication authentication){
        Integer clientId = ((User) authentication.getPrincipal()).getId();
        return ResponseEntity.ok().body(reviewService.addReview(review, clientId));
    }

    @DeleteMapping("/remove/{review_id}")
    public ResponseEntity<?> addReview(@PathVariable("review_id") Integer reviewId){
        reviewService.deleteReview(reviewId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
