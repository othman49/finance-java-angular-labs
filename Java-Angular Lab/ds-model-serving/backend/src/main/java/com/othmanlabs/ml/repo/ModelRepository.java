package com.othmanlabs.ml.repo;

import com.othmanlabs.ml.domain.ModelVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<ModelVersion, Long> {

    Optional<ModelVersion> findTopByNameOrderByVersionDesc(String name);
}