package com.voytenko.controllers;

import com.voytenko.dto.ReviewForm;
import com.voytenko.models.User;
import com.voytenko.security.details.UserDetailsImpl;
import com.voytenko.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping()
    public String getReviews(Authentication authentication, Model model) {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        model.addAttribute("reviews", reviewService.findAll());
        model.addAttribute("userId", user.getId());
        return "reviews";
    }


    @PostMapping("/add/{order_id}")
    public String addReview(@PathVariable("order_id") Integer orderId, ReviewForm review, Authentication authentication) {
        User client = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        reviewService.addReview(review, client.getId(), orderId);
        return "redirect:/reviews";
    }

    @PostMapping("/remove/{review_id}")
    public String deleteReview(@PathVariable("review_id") Integer reviewId) {
        reviewService.deleteReview(reviewId);
        return "redirect:/reviews";
    }

    @GetMapping("/completed")
    public String getCompletedOrderReview(Model model, Authentication authentication){
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        model.addAttribute("reviews", reviewService.getCompletedOrderReview());
        model.addAttribute("userId", user.getId());
        return "reviews";
    }
}
