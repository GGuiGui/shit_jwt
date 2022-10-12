package com.holy.shit_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShitJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShitJwtApplication.class, args);
    }

}
