package com.voytenko.services;

import com.voytenko.dto.AddOrderDto;
import com.voytenko.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> findAll();
    OrderDto getOrderById(Integer orderId);
    void addOrder(AddOrderDto order);
    void removeOrder(Integer orderId);

}
