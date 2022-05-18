package com.voytenko.dto;

import com.voytenko.models.Order;
import com.voytenko.models.Review;
import com.voytenko.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Integer id;
    private User user;
    private OrderDto order;
    private Timestamp date;
    private String comment;
    private int rating;

    public static ReviewDto from(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .user(review.getUser())
                .order(OrderDto.from(review.getOrder()))
                .date(review.getDate())
                .comment(review.getComment())
                .rating(review.getRating())
                .build();
    }

    public static List<ReviewDto> from(List<Review> reviews){
      return reviews.stream().map(ReviewDto::from).collect(Collectors.toList());
    }
}
