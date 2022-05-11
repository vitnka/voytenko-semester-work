package com.voytenko.controllers;

import com.voytenko.dto.AddOrderDto;
import com.voytenko.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequiredArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public String getOrderPage(Model model, Authentication authentication){
        model.addAttribute("orders", orderService.findAll());
        return "home.html";
    }

    @GetMapping("/{order_id}")
    public String getOrder(Model model, @PathVariable("order_id") Integer orderId){
        model.addAttribute("order", orderService.getOrderById(orderId));
        return "order";
    }

    @GetMapping("/add")
    public String addOrder(Model model) {

        AddOrderDto order = new AddOrderDto();
        model.addAttribute("order", order);

        return "addOrder";
    }

    @PostMapping("/add")
    public String createOrder(AddOrderDto order){
        orderService.addOrder(order);
        return "orders";
    }

    @PostMapping("/cancel/{order_id}")
    public String removeOrder(@PathVariable("order_id") Integer orderId){
        orderService.removeOrder(orderId);
        return "orders";
    }
}
