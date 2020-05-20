package com.example.cicddemo.config;

import com.example.cicddemo.entity.Product;
import com.example.cicddemo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepo) {
        return args -> {
            log.info("Preloading" + productRepo.save(new Product("Acoustic", "Guitar", "Taylors", 5)));
            log.info("Preloading" + productRepo.save(new Product("Grand", "Piano", "Yamaha", 3)));
        };
    }
}
