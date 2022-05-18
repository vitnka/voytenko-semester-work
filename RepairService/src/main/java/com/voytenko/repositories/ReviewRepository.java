package com.voytenko.repositories;

import com.voytenko.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    @Query(value = "select * from review r where r.order_id in " +
            "(select o.id from orders o where o.order_status = 'COMPLETED')",
    nativeQuery = true)
    List<Review> findAllByOrderCompleted();
}










