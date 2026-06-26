package com.example.shineshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ShineShoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShineShoesApplication.class, args);
    }

}
