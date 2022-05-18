package com.voytenko.services;

import com.voytenko.dto.OrderDto;
import com.voytenko.dto.OrderForm;

import java.util.List;

public interface OrderService {

    List<OrderDto> findAllByClient(Integer clientId);
    OrderDto getOrderById(Integer orderId);
    void addOrder(OrderForm order, Integer clientId);
    void removeOrder(Integer orderId);
    List<OrderDto> findByItem(String item, Integer userId);

}
