package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT * FROM orders WHERE atelie = :id",nativeQuery = true)
    Iterable<Order> getSelectedOrder(@Param("id") int id);
}
