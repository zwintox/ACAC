package com.example.acac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AcacApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcacApplication.class, args);
    }
}
