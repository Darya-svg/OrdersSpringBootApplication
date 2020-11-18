package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Manufact;
import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.model.Role;
import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("registr",new User());
        return "registration";
    }


    @PostMapping("/registration")
    public String addUser(@ModelAttribute("registr")@Valid User user, Model model,BindingResult result){

        if(result.hasErrors()){
            return "registration";
        }

        User userFromDb = usersRepository.findByUsername(user.getUsername());
        if(userFromDb != null){
            model.addAttribute("message","user with the same name already exists!");
            return "registration";
        }

        if(!user.getPassword().equals(user.getConfirmPassword())){
            model.addAttribute("message","passwords don't match");
            return "registration";
        }

        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.USER));
        usersRepository.save(user);

        return "redirect:/login";
    }

}
