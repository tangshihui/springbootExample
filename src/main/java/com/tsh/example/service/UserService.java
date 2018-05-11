package com.tsh.example.service;

import com.tsh.example.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public User getUser(){
        User user=new User();
        user.setId(1);
        user.setName("Tom");
        user.setGender("M");
        user.setAddress("Nanjing");
        return user;
    }

}
