package com.example.springbootdemo.repository;

import com.example.springbootdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Product,Integer> {

    @Modifying
    @Query(value = "UPDATE product SET lastdateorder = :lastDate" +
            " WHERE id_product = :idProduct",nativeQuery = true)
    void updateTableProduct(@Param("lastDate") String lastDate, @Param("idProduct") int idProduct);
}
