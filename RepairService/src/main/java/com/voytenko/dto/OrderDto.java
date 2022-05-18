package com.voytenko.dto;

import com.voytenko.models.Category;
import com.voytenko.models.Order;
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
    private String itemName;
    private String orderStatus;
    private String reason;
    private String comment;

    public static OrderDto from(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .itemName(order.getItemName())
                .orderStatus(order.getOrderStatus().toString())
                .comment(order.getComment())
                .reason(order.getReason())
                .build();
    }

    public static List<OrderDto> from(List<Order> orders) {
        return orders.stream().map(OrderDto::from).collect(Collectors.toList());
    }
}
