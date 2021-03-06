package com.voytenko.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    @GetMapping
    public String redirect() {
        return "redirect:/profile";
    }

    @GetMapping("/admin")
    public String getBanPage() {
        return "admin";
    }
}
