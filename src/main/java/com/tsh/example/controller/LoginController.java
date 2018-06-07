package com.tsh.example.controller;

import com.tsh.LoginModel.AndoridLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    AndoridLogin andoridLogin;

    public String login(){
        return andoridLogin.login("","");
    }
}
