package com.tsh.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BigCat extends Cat {

    @Override
    public void eat() {
        System.out.println("big cat eat...");
    }
}
