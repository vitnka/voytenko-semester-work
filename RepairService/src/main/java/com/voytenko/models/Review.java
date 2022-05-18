package com.voytenko.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Timestamp date;

    private String comment;

    private int rating;
}
