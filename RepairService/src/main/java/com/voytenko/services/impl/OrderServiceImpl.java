package com.voytenko.services.impl;

import com.voytenko.dto.AddOrderDto;
import com.voytenko.dto.OrderDto;
import com.voytenko.repositories.OrderRepository;
import com.voytenko.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<OrderDto> findAll() {
        return null;
    }

    @Override
    public OrderDto getOrderById(Integer orderId) {
        return null;
    }

    @Override
    public void addOrder(AddOrderDto order) {

    }

    @Override
    public void removeOrder(Integer orderId) {

    }
}
