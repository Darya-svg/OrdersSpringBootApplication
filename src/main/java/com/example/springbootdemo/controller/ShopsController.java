package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Shop;
import com.example.springbootdemo.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller
@RequestMapping("/shop")
@PreAuthorize("hasAuthority('ADMIN')")
public class ShopsController {
    private final ShopsService shopsService;

    @Autowired
    public ShopsController(ShopsService shopsService) {
        this.shopsService = shopsService;
    }


    @GetMapping("/shop-create")
    public String createShopForm(Model model){
        model.addAttribute("shop",new Shop());
        return "shop/shop-create";
    }

    @PostMapping("/shop-create")
    public String createShop(@ModelAttribute("shop")@Valid Shop shop, BindingResult result){
        if(result.hasErrors()){
            return "shop/shop-create";
        }
        shopsService.saveShop(shop);
        return "redirect:/main";
    }

    @GetMapping("/shop-update/{idShop}")
    public String updateShopForm(@PathVariable("idShop")int idShop, Model model){
        Shop shop = shopsService.findById(idShop);
        model.addAttribute("shop",shop);
        return "shop/shop-update";
    }

    @PostMapping("/shop-update")
    public String updateShop(@ModelAttribute("shop")@Valid Shop shop, BindingResult result){
        if(result.hasErrors()){
            return "shop/shop-update";
        }
        shopsService.saveShop(shop);
        return "redirect:/main";
    }



    @GetMapping("/shop-delete/{idShop}")
    public String deleteShop(@PathVariable("idShop")int idShop){
        shopsService.deleteById(idShop);
        return "redirect:/main";
    }
}
