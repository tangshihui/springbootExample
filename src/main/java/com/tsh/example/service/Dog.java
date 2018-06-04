package com.tsh.example.service;

import org.springframework.stereotype.Service;


public class Dog implements Animal {

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void eat() {
        System.out.println("dog eat ...");
    }

    @Override
    public void run() {
        System.out.println("dog run ...");
    }

    public void laugh(){
        System.out.println("dog laugh ...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
