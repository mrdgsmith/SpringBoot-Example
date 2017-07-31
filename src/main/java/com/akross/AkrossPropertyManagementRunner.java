package com.akross;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class AkrossPropertyManagementRunner {

    public static void main(String... args) {
        SpringApplication.run(AkrossPropertyManagementRunner.class);
    }
}