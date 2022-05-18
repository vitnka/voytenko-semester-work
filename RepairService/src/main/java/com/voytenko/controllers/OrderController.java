package com.voytenko.controllers;

import com.voytenko.dto.OrderDto;
import com.voytenko.dto.OrderForm;
import com.voytenko.models.User;
import com.voytenko.security.details.UserDetailsImpl;
import com.voytenko.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public String getOrderPage(Model model, Authentication authentication) {
        User client = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        model.addAttribute("orders", orderService.findAllByClient(client.getId()));
        model.addAttribute("id", client.getId());
        return "orders";
    }

    @PostMapping(path = "/add")
    public String createOrder(OrderForm order, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/signIn";
        }
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        orderService.addOrder(order, user.getId());
        return "redirect:/order";
    }

    @PostMapping("/cancel/{order_id}")
    public String removeOrder(@PathVariable("order_id") Integer orderId) {
        orderService.removeOrder(orderId);
        return "redirect:/order";
    }

    @GetMapping("/search/{itemName}")
    @ResponseBody
    public List<OrderDto> searchOrderByItem(@PathVariable("itemName") String itemName, Authentication authentication, Model model) {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        return orderService.findByItem(itemName, user.getId());
    }

    @GetMapping("/{order_id}")
    public String getOrder(Model model, @PathVariable("order_id") Integer orderId) {
        model.addAttribute("order", orderService.getOrderById(orderId));
        return "order";
    }
}
