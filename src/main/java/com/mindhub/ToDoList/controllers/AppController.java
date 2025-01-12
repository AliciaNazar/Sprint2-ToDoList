package com.mindhub.ToDoList.controllers;

//import com.mindhub.ToDoList.models.EntityUser;
//import com.mindhub.ToDoList.repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AppController {

    //@Autowired
    //UserRepository userRepository;


    @GetMapping
    public String getUsername(Authentication authentication){

        //EntityUser user = userRepository.findByUsername(authentication.getName()).orElse(null);

        return authentication.getName();
    }

}
