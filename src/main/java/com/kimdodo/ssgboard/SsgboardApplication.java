package com.kimdodo.ssgboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SsgboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsgboardApplication.class, args);
    }

}
