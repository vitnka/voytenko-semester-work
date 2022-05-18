package com.voytenko.dto;

import com.voytenko.models.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountProfileDto {

    private String email;
    private String firstName;
    private String lastName;
    private String profileImg;

    public static AccountProfileDto from(Client client) {
        return AccountProfileDto.builder()
                .email(client.getEmail())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .profileImg(client.getProfileImg())
                .build();
    }
}
