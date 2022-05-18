package com.voytenko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpForm {

    private String firstName;
    private String lastName;
    private String password;
    private String email;
}
