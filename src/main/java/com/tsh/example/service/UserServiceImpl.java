package com.tsh.example.service;

import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;

@Service
public class UserServiceImpl {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {

        if ("tsh".equals(this.name)) {
            return "Success";
        } else {

            throw new InfoException();
        }
    }

    public class InfoException extends RuntimeException {
        @Override
        public String getMessage() {
            return super.getMessage() + "获取用户信息异常";
        }
    }

}
