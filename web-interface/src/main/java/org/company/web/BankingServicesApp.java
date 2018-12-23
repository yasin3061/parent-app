package org.company.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.company")
@EnableAutoConfiguration
public class BankingServicesApp {

    public static void main(String[] args) {
        SpringApplication.run(BankingServicesApp.class, args);
    }
}
