package com.voytenko.dto;

import com.voytenko.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Integer id;
    private String email;
    private User.State state;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .state(user.getState())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
       return users.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
