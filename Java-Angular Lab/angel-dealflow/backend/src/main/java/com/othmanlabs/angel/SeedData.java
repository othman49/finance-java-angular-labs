package com.othmanlabs.angel;

import com.othmanlabs.angel.service.DealService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import java.math.BigDecimal;

@Configuration
public class SeedData {

    @Bean
    CommandLineRunner seed(DealService service) {
        return args -> {
            service.createDeal(
                "FintechX",
                "Fintech",
                "Seed",
                "Morocco",
                new BigDecimal("25000")
            );
            service.createDeal(
                "GreenEnergy",
                "Climate",
                "Pre-Seed",
                "UK",
                new BigDecimal("40000")
            );
        };
    }
}