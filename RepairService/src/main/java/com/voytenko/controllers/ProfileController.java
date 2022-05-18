package com.voytenko.controllers;

import com.voytenko.models.User;
import com.voytenko.security.details.UserDetailsImpl;
import com.voytenko.services.ClientProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller()
@RequestMapping("/profile")
public class ProfileController {

    private final ClientProfileService profileService;

    @GetMapping
    public String getProfilePage(Authentication authentication, Model model) {
        if (authentication == null) {
            return "redirect:/signIn";
        }
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();
        model.addAttribute("user", profileService.getById(user.getId()));
        return "profile";
    }

}
