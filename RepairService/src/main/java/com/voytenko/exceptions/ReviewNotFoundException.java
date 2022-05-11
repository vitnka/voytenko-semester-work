package com.voytenko.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Integer orderId) {
        super("There is no review with order id <" + orderId + ">");
    }
}
