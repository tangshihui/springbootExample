package com.tsh.example.service;

import com.tsh.example.Configuration.CommonProperties;
import com.tsh.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    CommonProperties commonProperties;

    private String appId;


    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("Tom");
        user.setGender("M");
        user.setAddress("Nanjing");
        return user;
    }

    public UserService() {
        this.appId = commonProperties!=null?commonProperties.getAppId():"";
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        return appId;
    }

    public String getKey() {
        return this.commonProperties.getKey();
    }

}
