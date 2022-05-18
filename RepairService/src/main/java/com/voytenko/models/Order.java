package com.voytenko.models;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public enum Status {
        NOT_STARTED, IN_PROGRESS, COMPLETED
    }

    @Column(name = "order_status")
    @Enumerated(value = EnumType.STRING)
    private Status orderStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true,
            fetch = FetchType.EAGER)
    public Review reviews;

    @Column(name = "item_name")
    private String itemName;

    private String reason;

    private String comment;


}
