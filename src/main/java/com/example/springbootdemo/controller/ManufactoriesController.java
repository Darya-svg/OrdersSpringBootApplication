package com.example.springbootdemo.controller;


import com.example.springbootdemo.model.Manufact;
import com.example.springbootdemo.service.ManufactoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/manufact")
@PreAuthorize("hasAuthority('ADMIN')")
public class ManufactoriesController {

    public final ManufactoriesService manufactoriesService;

    @Autowired
    public ManufactoriesController(ManufactoriesService manufactoriesService) {
        this.manufactoriesService = manufactoriesService;
    }


    @GetMapping
    public String findAll(Model model){
        List<Manufact> manufactList = manufactoriesService.findAll();
        model.addAttribute("manufactory",manufactList);
        return "manufact/manufact-list";
    }

    @GetMapping("/manufact-create")
    public String createManufactForm(Model model){
        model.addAttribute("manufactory",new Manufact());
        return "manufact/manufact-create";
    }

    @PostMapping("/manufact-create")
    public String createManufact(@ModelAttribute("manufactory")@Valid Manufact manufact, BindingResult result){
        if(result.hasErrors()){
            return "manufact/manufact-create";
        }
        manufactoriesService.saveManufact(manufact);
        return "redirect:/main";
    }

    @GetMapping("/manufact-update/{idManufact}")
    public String updateManufactForm(@PathVariable("idManufact")int idManufact,Model model){
        Manufact manufact = manufactoriesService.findById(idManufact);
        model.addAttribute("manufactory",manufact);
        return "manufact/manufact-update";
    }

    @PostMapping("/manufact-update")
    public String updateManufact(@ModelAttribute("manufactory")@Valid Manufact manufact, BindingResult result){
        if(result.hasErrors()){
            return "manufact/manufact-update";
        }
        manufactoriesService.saveManufact(manufact);
        return "redirect:/main";
    }



    @GetMapping("/manufact-delete/{idManufact}")
    public String deleteManyfact(@PathVariable("idManufact")int idManufact){
        manufactoriesService.deleteById(idManufact);
        return "redirect:/main";
    }




}
