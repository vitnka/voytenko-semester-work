package com.voytenko.controllers;

import com.voytenko.models.User;
import com.voytenko.security.details.UserDetailsImpl;
import com.voytenko.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/home")
public class HomePageController {

    private final OrderService orderService;

    @GetMapping
    public String getHomePage(Model model, Authentication authentication) {
        if (authentication != null) {
            User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
            model.addAttribute("id", user.getId());
        }
        return "home";
    }


}
