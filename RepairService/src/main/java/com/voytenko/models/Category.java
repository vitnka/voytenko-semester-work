package com.voytenko.models;


import lombok.*;

import javax.persistence.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public Category setName(String name){
        return this.setName(name);
    }
}
