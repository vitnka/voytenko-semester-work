package com.voytenko.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@SuperBuilder
@RequiredArgsConstructor
@ToString
@Entity
public class Client extends User {

    @OneToMany(mappedBy = "client")
    private List<Order> orders;

}
