package com.othmanlabs.ml.service;

import com.othmanlabs.ml.domain.ModelVersion;
import com.othmanlabs.ml.repo.ModelRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class InferenceService {

    private final ModelRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public InferenceService(ModelRepository repository) {
        this.repository = repository;
    }

    public PredictionResult predict(String modelName, double[] features) {

        ModelVersion model = repository
            .findTopByNameOrderByVersionDesc(modelName)
            .orElseThrow(() -> new IllegalArgumentException("Model not found"));

        try {
            JsonNode root = mapper.readTree(model.getWeightsJson());
            double bias = root.get("bias").asDouble();
            JsonNode weights = root.get("w");

            double z = bias;
            for (int i = 0; i < weights.size(); i++) {
                z += weights.get(i).asDouble() * features[i];
            }

            double probability = 1 / (1 + Math.exp(-z));
            return new PredictionResult(model.getName(), model.getVersion(), probability);

        } catch (Exception e) {
            throw new RuntimeException("Invalid model weights", e);
        }
    }

    public record PredictionResult(
        String modelName,
        int version,
        double probability
    ) {}
}