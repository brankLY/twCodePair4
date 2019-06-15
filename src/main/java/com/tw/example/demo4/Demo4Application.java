package com.tw.example.demo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Demo4Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Demo4Application.class, args);
    }
}
