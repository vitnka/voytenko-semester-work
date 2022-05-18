package com.voytenko.controllers;

import com.voytenko.dto.SignUpForm;
import com.voytenko.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/signUp")
public class SignUpController {


    private final SignUpService signUpService;

    @GetMapping
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping
    public String signUp(SignUpForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("signUpForm", form);
            return "signUp";
        }
        signUpService.signUp(form);
        return "redirect:/signIn?registered";
    }

    @GetMapping(value = "/confirmEmail/{confirm-code}")
    public String getVerification(Model model, @PathVariable("confirm-code") String confirmCode) {
        Boolean result = signUpService.getUserByConfirmCode(confirmCode);
        model.addAttribute("confirmResult", result);
        return "redirect:/signIn";
    }

}
