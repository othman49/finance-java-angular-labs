package com.othmanlabs.angel.repo;

import com.othmanlabs.angel.domain.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<Deal, Long> {
}