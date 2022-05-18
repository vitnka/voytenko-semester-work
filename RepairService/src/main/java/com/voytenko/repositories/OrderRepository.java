package com.voytenko.repositories;

import com.voytenko.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer > {

    @Query(value = "select * from orders o where o.user_id = :client_id and o.order_status != 'COMPLETED'",
    nativeQuery = true)
    List<Order> findAllByClientId(@Param("client_id") Integer clientId);

    Optional<Order> findById(Integer orderId);

    @Query(value = "select o from orders o where o.user_id = :user_id and o.item_name like %:item_name%",
    nativeQuery = true)
    List<Order> findByUserIdAndItemNameContains(@Param("user_id") Integer userId, @Param("item_name") String itemName);

}
