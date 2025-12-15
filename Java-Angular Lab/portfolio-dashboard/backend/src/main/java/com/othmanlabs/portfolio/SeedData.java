package com.othmanlabs.portfolio;

import com.othmanlabs.portfolio.service.PortfolioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

import java.math.BigDecimal;

@Configuration
public class SeedData {

    @Bean
    CommandLineRunner seed(PortfolioService service) {
        return args -> {
            service.addHolding("AAPL", new BigDecimal("5"), new BigDecimal("150"));
            service.addHolding("QQQ", new BigDecimal("2"), new BigDecimal("320"));
        };
    }
}