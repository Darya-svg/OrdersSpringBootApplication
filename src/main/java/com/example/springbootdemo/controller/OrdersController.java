package com.example.springbootdemo.controller;


import com.example.springbootdemo.model.Order;
import com.example.springbootdemo.service.ManufactoriesService;
import com.example.springbootdemo.service.OrdersService;
import com.example.springbootdemo.service.ProductsService;
import com.example.springbootdemo.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/order")
@PreAuthorize("hasAuthority('ADMIN')")
public class OrdersController {
    private final OrdersService ordersService;
    private final ManufactoriesService manufactoriesService;
    private final ShopsService shopsService;
    private final ProductsService productsService;

    @Autowired
    public OrdersController(OrdersService ordersService, ManufactoriesService manufactoriesService, ShopsService shopsService, ProductsService productsService) {
        this.ordersService = ordersService;
        this.manufactoriesService = manufactoriesService;
        this.shopsService = shopsService;
        this.productsService = productsService;
    }


    @GetMapping
    public String findAll(Model model){
        List<Order> orderList = ordersService.findAll();
        model.addAttribute("order",orderList);
        return "order/order-list";
    }


    @GetMapping("/order-create")
    public String createOrderForm(Model model){
        model.addAttribute("order",new Order());
        model.addAttribute("manufactory",manufactoriesService.findAll());
        model.addAttribute("shop",shopsService.findAll());
        model.addAttribute("product",productsService.findAll());
        return "order/order-create";
    }

    @PostMapping("/order-create")
    public String createOrder(@ModelAttribute("order")@Valid Order order, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("manufactory",manufactoriesService.findAll());
            model.addAttribute("shop",shopsService.findAll());
            model.addAttribute("product",productsService.findAll());
            return "order/order-create";
        }

         productsService.updateTableProduct(order.getDateOrder(),order.getProduct().getIdProduct());

        ordersService.saveOrder(order);
        return "redirect:/main";
    }

    @GetMapping("/order-update/{idOrder}")
    public String updateOrderForm(@PathVariable("idOrder")int idOrder, Model model){
        Order order = ordersService.findById(idOrder);
        model.addAttribute("order",order);
        model.addAttribute("manufactory",manufactoriesService.findAll());
        model.addAttribute("shop",shopsService.findAll());
        model.addAttribute("product",productsService.findAll());
        return "order/order-update";
    }

    @PostMapping("/order-update")
    public String updateOrder(@ModelAttribute("order")@Valid Order order, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("manufactory",manufactoriesService.findAll());
            model.addAttribute("shop",shopsService.findAll());
            model.addAttribute("product",productsService.findAll());
            return "order/order-update";
        }
        ordersService.saveOrder(order);
        return "redirect:/main";
    }


    @GetMapping("/order-delete/{idOrder}")
    public String deleteOrder(@PathVariable("idOrder")int idOrder){
        ordersService.deleteById(idOrder);
        return "redirect:/main";
    }


    // получаем данные из формы
    @PostMapping("/sendManufact")
    public String sendManufactory(@RequestParam(name = "idManufact") Integer id, Model model){
        Iterable<Order> selectedOrder = ordersService.getSelectedOrder(id);
        model.addAttribute("selectedOrders",selectedOrder);

        return "order/order-selected";

    }

}
