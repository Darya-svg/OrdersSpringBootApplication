package com.example.springbootdemo.service;


import com.example.springbootdemo.model.Shop;
import com.example.springbootdemo.repository.ShopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopsService {

    private final ShopsRepository shopsRepository;

    @Autowired
    public ShopsService(ShopsRepository shopsRepository) {
        this.shopsRepository = shopsRepository;
    }

    public Shop findById(int idShop){
        return shopsRepository.getOne(idShop);
    }

    public List<Shop> findAll(){
        return shopsRepository.findAll();
    }

    public Shop saveShop(Shop shop){
        return shopsRepository.save(shop);
    }

    public void deleteById(int idShop){
        shopsRepository.deleteById(idShop);
    }
}
