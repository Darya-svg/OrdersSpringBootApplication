package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopsRepository extends JpaRepository<Shop,Integer> {
}
