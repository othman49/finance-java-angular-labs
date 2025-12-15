package com.othmanlabs.angel.service;

import com.othmanlabs.angel.domain.Deal;
import com.othmanlabs.angel.repo.DealRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DealService {

    private final DealRepository repository;
    private final DealScoringService scoringService;

    public DealService(
        DealRepository repository,
        DealScoringService scoringService
    ) {
        this.repository = repository;
        this.scoringService = scoringService;
    }

    public Deal createDeal(
        String startupName,
        String sector,
        String stage,
        String country,
        BigDecimal ticketSize
    ) {
        int score = scoringService.score(stage, ticketSize, country);
        return repository.save(
            new Deal(startupName, sector, stage, country, ticketSize, score)
        );
    }

    public List<Deal> getAllDeals() {
        return repository.findAll();
    }
}