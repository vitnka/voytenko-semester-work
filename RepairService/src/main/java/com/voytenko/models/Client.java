package com.voytenko.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "profile_img")
    private String profileImg;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


}
