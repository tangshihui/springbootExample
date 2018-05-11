package com.tsh.example.controller;

import com.tsh.example.model.User;
import com.tsh.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello,world";
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser(){

        return userService.getUser();
    }
}
