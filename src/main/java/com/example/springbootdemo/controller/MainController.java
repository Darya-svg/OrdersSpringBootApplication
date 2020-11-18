package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Manufact;
import com.example.springbootdemo.model.Order;
import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.model.Shop;
import com.example.springbootdemo.service.ManufactoriesService;
import com.example.springbootdemo.service.OrdersService;
import com.example.springbootdemo.service.ProductsService;
import com.example.springbootdemo.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    private final ShopsService shopsService;
    private final ProductsService productsService;
    private final ManufactoriesService manufactoriesService;
    private final OrdersService ordersService;

    @Autowired
    public MainController(ShopsService shopsService, ProductsService productsService, ManufactoriesService manufactoriesService, OrdersService ordersService) {
        this.shopsService = shopsService;
        this.productsService = productsService;
        this.manufactoriesService = manufactoriesService;
        this.ordersService = ordersService;
    }

    @GetMapping
    public String findAllShops(Model model){

        List<Shop> shopList = shopsService.findAll();
        model.addAttribute("shop",shopList);

        List<Product> productList = productsService.findAll();
        model.addAttribute("product",productList);

        List<Manufact> manufactList = manufactoriesService.findAll();
        model.addAttribute("manufactory",manufactList);

        List<Order> orderList = ordersService.findAll();
        model.addAttribute("order",orderList);

        return "main";


    }








}
