package com.voytenko.services.impl;

import com.voytenko.dto.SignUpForm;
import com.voytenko.models.User;
import com.voytenko.repositories.UserRepository;
import com.voytenko.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm form) {
        User user = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail().toLowerCase(Locale.ROOT))
                .password(passwordEncoder.encode(form.getPassword()))
                .role(User.Role.ROLE_CLIENT)
                .state(User.State.NOT_CONFIRMED)
                .build();

        userRepository.save(user);
    }

}
