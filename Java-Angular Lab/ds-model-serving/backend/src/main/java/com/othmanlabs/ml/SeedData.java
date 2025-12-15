package com.othmanlabs.ml;

import com.othmanlabs.ml.domain.ModelVersion;
import com.othmanlabs.ml.repo.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;

@Configuration
public class SeedData {

    @Bean
    CommandLineRunner seed(ModelRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(
                    new ModelVersion(
                        "credit_model",
                        1,
                        "{\"bias\":-0.8,\"w\":[1.2,-2.0,0.7]}"
                    )
                );
            }
        };
    }
}