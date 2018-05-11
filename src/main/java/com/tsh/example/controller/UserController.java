package com.tsh.example.controller;

import com.tsh.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/userinfo")
    public String userinfo(ModelMap modelMap){

      modelMap.put("user",userService.getUser());
      return "userinfo";
    }
}
