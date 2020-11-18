package com.example.springbootdemo.service;


import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsService {
    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product findById(int idProduct){
        return productsRepository.getOne(idProduct);
    }

    public List<Product> findAll(){
        return productsRepository.findAll();
    }

    public Product saveProduct(Product product){
        return productsRepository.save(product);
    }

    public void deleteById(int idProduct){
        productsRepository.deleteById(idProduct);
    }

    @Transactional
    public void updateTableProduct(String lastDate,int idProduct){
         productsRepository.updateTableProduct(lastDate,idProduct);
    };
}
