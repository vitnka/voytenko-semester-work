package com.voytenko.dto;

import com.voytenko.models.Client;
import com.voytenko.models.Order;
import com.voytenko.models.Repairman;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Integer id;
    private Repairman repairman;
    private Client client;
    private String orderStatus;
    private String reason;
    private String comment;

    public static OrderDto from(Order order){
        return OrderDto.builder()
                .repairman(order.getRepairman())
                .client(order.getClient())
                .orderStatus(order.getOrderStatus())
                .comment(order.getComment())
                .reason(order.getReason())
                .build();
    }

    public static List<OrderDto> from(List<Order> orders){
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}
