package com.example.springbootdemo.controller;


import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
@PreAuthorize("hasAuthority('ADMIN')")
public class ProductsController {

    private final ProductsService productsService;
    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String findAll(Model model){
        List<Product> productList = productsService.findAll();
        model.addAttribute("product",productList);
        return "product/product-list";
    }

    @GetMapping("/product-create")
    public String createProductForm(Model model){
        model.addAttribute("product",new Product());
        return "product/product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(@ModelAttribute("product")@Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product/product-create";
        }
        productsService.saveProduct(product);
        return "redirect:/main";
    }

    @GetMapping("/product-update/{idProduct}")
    public String updateProductForm(@PathVariable("idProduct")int idProduct, Model model){
        Product product = productsService.findById(idProduct);
        model.addAttribute("product",product);
        return "product/product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(@ModelAttribute("product")@Valid Product product, BindingResult result){
        if(result.hasErrors()){
            return "product/product-update";
        }
        productsService.saveProduct(product);
        return "redirect:/main";
    }



    @GetMapping("/product-delete/{idProduct}")
    public String deleteProduct(@PathVariable("idProduct")int idProduct){
        productsService.deleteById(idProduct);
        return "redirect:/main";
    }
}
