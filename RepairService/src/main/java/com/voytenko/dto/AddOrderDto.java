package com.voytenko.dto;

import com.voytenko.models.Category;
import com.voytenko.models.Client;
import com.voytenko.models.Order;
import com.voytenko.models.Repairman;
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
public class AddOrderDto {

    private Client client;
    private String reason;
    private String comment;
    private Category category;

    public static AddOrderDto from(Order order){
        return AddOrderDto.builder()
                .client(order.getClient())
                .comment(order.getComment())
                .reason(order.getReason())
                .category(order.getCategory())
                .build();
    }

    public static List<AddOrderDto> from(List<Order> orders){
        return orders.stream().map(AddOrderDto::from).collect(Collectors.toList());
    }
}
