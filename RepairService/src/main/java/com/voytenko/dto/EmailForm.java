package com.voytenko.dto;

import com.voytenko.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmailForm {
    private String email;

    public static EmailForm from(User user) {
        return EmailForm.builder()
                .email(user.getEmail())
                .build();
    }

    public static List<EmailForm> from(List<User> users) {
        return users.stream().map(EmailForm::from).collect(Collectors.toList());
    }
}
