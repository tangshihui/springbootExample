package com.tsh.LoginModel;

import org.springframework.stereotype.Service;

@Service
public class AndoridLogin {

    public String login(String username,String passsord){
        System.out.println("username:"+username+" password:"+passsord);
        return "success";
    }
}
