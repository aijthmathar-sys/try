package com.example.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.work.Repositary.UserRepositary;
import com.example.work.model.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepositary userRepositary;
    @GetMapping
    public String form() {
        return "form";
    }
    


    @PostMapping("/create")
    public String postMethodName(@ModelAttribute User user) {
   userRepositary.save(user);
        
        
        return "redirect:/users/get";
    }
    @GetMapping("/get")
    public String getMethodName(Model model) {
        List<User> users = userRepositary.findAll();
        model.addAttribute("users", users);
        return "table";
    }
    
    
    
}
