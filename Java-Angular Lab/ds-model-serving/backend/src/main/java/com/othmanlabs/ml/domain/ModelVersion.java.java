package com.othmanlabs.ml.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "model_versions")
public class ModelVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int version;

    @Lob
    private String weightsJson;

    private Instant createdAt = Instant.now();

    protected ModelVersion() {}

    public ModelVersion(String name, int version, String weightsJson) {
        this.name = name;
        this.version = version;
        this.weightsJson = weightsJson;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getVersion() { return version; }
    public String getWeightsJson() { return weightsJson; }
    public Instant getCreatedAt() { return createdAt; }
}