package com.example.confiserie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ConfiserieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfiserieApplication.class, args);

    }

}
