package com.othmanlabs.portfolio.repo;

import com.othmanlabs.portfolio.domain.Holding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldingRepository extends JpaRepository<Holding, Long> {
}