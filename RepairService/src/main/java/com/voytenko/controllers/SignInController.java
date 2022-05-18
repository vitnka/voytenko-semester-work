package com.voytenko.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/signIn")
public class SignInController {

    @GetMapping
    public String getSignInPage(Authentication authentication, Model model, @RequestParam(required = false) String error,
                                @RequestParam(required = false) String logout, @RequestParam(required = false) String registered,
                                @RequestParam(required = false) String exists) {
        if (authentication != null) {
            return "redirect:/";
        }

        if (!(error == null)) {
            model.addAttribute("error", "");
        }

        if (!(logout == null)) {
            model.addAttribute("logout", "");
        }

        if (!(registered == null)) {
            model.addAttribute("registered", "");
        }

        if (!(exists == null)) {
            model.addAttribute("exists", "");
        }

        return "signIn";
    }

}
