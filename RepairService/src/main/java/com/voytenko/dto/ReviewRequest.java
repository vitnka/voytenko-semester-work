package com.voytenko.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    private Integer orderId;
    private String comment;
    private int rating;
}
