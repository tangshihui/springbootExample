package com.tsh.example.Configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {


    @Bean
    public CommonProperties getCommonProperties(){
        return new CommonProperties();
    }
}
