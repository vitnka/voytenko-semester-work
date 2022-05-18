package com.voytenko.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    public enum Role {
        USER, ADMIN
    }

    public enum State {
        NOT_CONFIRMED, CONFIRMED, BANNED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    private String confirmCode;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
