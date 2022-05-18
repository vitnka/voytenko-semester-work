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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderForm {
    private String item;
    private String reason;
    private String comment;
    private Integer userId;

    public static OrderForm from(Order order){
        return OrderForm.builder()
                .item(order.getItemName())
                .comment(order.getComment())
                .reason(order.getReason())
                .userId(order.getUser().getId())
                .build();
    }

    public static List<OrderForm> from(List<Order> orders){
        return orders.stream().map(OrderForm::from).collect(Collectors.toList());
    }
}
