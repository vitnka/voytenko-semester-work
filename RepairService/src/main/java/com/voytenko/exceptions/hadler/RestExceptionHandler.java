package com.voytenko.exceptions.hadler;

import com.voytenko.dto.ExceptionDto;
import com.voytenko.dto.ValidationErrorDto;
import com.voytenko.exceptions.*;
import com.voytenko.models.User;
import com.voytenko.security.details.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    private final String ENTITY_NOT_FOUND_STATUS = "404";

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public String handleEmailAlreadyExistsException() {
        return "redirect:/signIn?exists";
    }

    @ExceptionHandler(UserEmailNotFoundException.class)
    public String handleUserEmailNotFoundException(UserEmailNotFoundException exception, Model model, Authentication authentication) {
        return addExceptionOnPage(model, authentication, exception.getMessage());
    }


    @ExceptionHandler(EmptyMessageException.class)
    public String handleEmptyMessageException(EmptyMessageException exception, Model model, Authentication authentication) {
        return addExceptionOnPage(model, authentication, exception.getMessage());
    }

    private String addExceptionOnPage(Model model, Authentication authentication, String message) {
        User user = ((UserDetailsImpl) authentication.getPrincipal()).getUser();

        if (user.getRole().toString().equals("ADMIN")) {
            model.addAttribute("isAdmin", true);
        } else {
            model.addAttribute("isAdmin", false);
        }

        model.addAttribute("error", message);
        model.addAttribute("canReply", true);

        return "message";
    }

}
