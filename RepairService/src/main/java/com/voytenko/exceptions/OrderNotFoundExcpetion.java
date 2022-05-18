package com.voytenko.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderNotFoundExcpetion extends RuntimeException {
    public OrderNotFoundExcpetion(Integer orderId) {
        super("Order with id <" + orderId + "> is doesn't exist");
    }
}
