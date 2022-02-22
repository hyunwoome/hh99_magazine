package com.sparta.hh99_magazine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // (exclude = SecurityAutoConfiguration.class)
public class Hh99MagazineApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hh99MagazineApplication.class, args);
    }
}