package org.company.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.company")
@EnableJpaRepositories(basePackages = "org.company")
@EnableAutoConfiguration
public class BankingServicesApp {

    public static void main(String[] args) {
        SpringApplication.run(BankingServicesApp.class, args);
    }
}
