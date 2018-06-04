package com.tsh.example.service;

import org.springframework.stereotype.Service;

@Service
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println(" 55  a cat eats  quickly and nicely using jrebel ...");
    }

    @Override
    public void run() {
        System.out.println("cat run ...");
    }

    public void cry(){
        System.out.println("cat cry ...");
    }
}
