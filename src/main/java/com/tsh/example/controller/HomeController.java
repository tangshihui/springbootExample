package com.tsh.example.controller;

import com.tsh.example.model.User;
import com.tsh.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@PathVariable(value = "homeId",required = false) String homeId,@PathVariable( value="detailId",required = false) String detailId) {

        System.out.println("访问量999");
        return "hello,world!"
                + "homeId:" + homeId
                + (detailId != null ? "detailId:" + detailId : "");
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.GET)
    public User getUser(@PathVariable( value = "homeId",required = false) String homeId){



        return userService.getUser();
    }
}
