package com.voytenko.services.impl;

import com.voytenko.dto.SignUpForm;
import com.voytenko.models.Client;
import com.voytenko.models.User;
import com.voytenko.repositories.UserRepository;
import com.voytenko.services.SignUpService;
import com.voytenko.util.EmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private EmailUtil emailUtil;

    @Value("${spring.mail.confirm_url}")
    private String confirmUrl;

    @Transactional
    @Override
    public void signUp(SignUpForm form) {

        Client client = Client.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail().toLowerCase(Locale.ROOT))
                .password(passwordEncoder.encode(form.getPassword()))
                .role(User.Role.USER)
                .state(User.State.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        userRepository.save(client);

        Map<String,String> userData = new HashMap<>();
        userData.put("name", client.getFirstName());
        userData.put("surname", client.getLastName());
        userData.put("confirmLink", confirmUrl + client.getConfirmCode());

        emailUtil.sendEmail(client.getEmail(),"confirm_mail.ftlh", "confirm_mail",
                userData);
    }

    @Override
    public Boolean getUserByConfirmCode(String confirmCode) {
        Optional<User> user = userRepository.getByConfirmCode(confirmCode);
        if (user.isPresent() && user.get().getState().equals(User.State.NOT_CONFIRMED)){
            user.get().setState(User.State.CONFIRMED);
            userRepository.save(user.get());
            return true;
        }
        return false;
    }

}
