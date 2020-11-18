package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Order;
import com.example.springbootdemo.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Order findById(int idOrder){
        return ordersRepository.getOne(idOrder);
    }

    public List<Order> findAll(){
        return ordersRepository.findAll();
    }

    public Order saveOrder(Order order){
        return ordersRepository.save(order);
    }

    public void deleteById(int idOrder){
        ordersRepository.deleteById(idOrder);
    }

    public Iterable<Order> getSelectedOrder(int id){
        return ordersRepository.getSelectedOrder(id);
    }
}
