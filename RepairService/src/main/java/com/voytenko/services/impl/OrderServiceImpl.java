package com.voytenko.services.impl;

import com.voytenko.dto.OrderDto;
import com.voytenko.dto.OrderForm;
import com.voytenko.exceptions.OrderNotFoundExcpetion;
import com.voytenko.models.Category;
import com.voytenko.models.Order;
import com.voytenko.models.User;
import com.voytenko.repositories.CategoryRepository;
import com.voytenko.repositories.OrderRepository;
import com.voytenko.repositories.UserRepository;
import com.voytenko.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public List<OrderDto> findAllByClient(Integer clientId) {
        return OrderDto.from(orderRepository.findAllByClientId(clientId));
    }

    @Override
    public OrderDto getOrderById(Integer orderId) {
        return OrderDto.from(orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundExcpetion(orderId)));
    }

    @Override
    public void addOrder(OrderForm orderRequest, Integer clientId) {

        User user = userRepository.getById(clientId);

        Order order = Order.builder()
                .itemName(orderRequest.getItem())
                .comment(orderRequest.getComment())
                .user(user)
                .reason(orderRequest.getReason())
                .orderStatus(Order.Status.NOT_STARTED)
                .build();

        orderRepository.save(order);
    }

    @Override
    public void removeOrder(Integer orderId) {

        Optional<Order> order = orderRepository.findById(orderId);

        if (order.isPresent()) {
            orderRepository.delete(order.get());
        } else {
            throw new OrderNotFoundExcpetion(orderId);
        }
    }


    @Override
    public List<OrderDto> findByItem(String item, Integer userId) {
        return OrderDto.from(orderRepository.findByUserIdAndItemNameContains(userId, item.toLowerCase()));
    }
}
