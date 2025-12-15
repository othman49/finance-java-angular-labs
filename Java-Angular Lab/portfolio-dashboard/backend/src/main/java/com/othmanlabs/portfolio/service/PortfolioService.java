package com.othmanlabs.portfolio.service;

import com.othmanlabs.portfolio.domain.Holding;
import com.othmanlabs.portfolio.repo.HoldingRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PortfolioService {

    private final HoldingRepository repository;

    public PortfolioService(HoldingRepository repository) {
        this.repository = repository;
    }

    public Holding addHolding(String symbol, BigDecimal quantity, BigDecimal avgCost) {
        return repository.save(new Holding(symbol, quantity, avgCost));
    }

    public List<Holding> getAllHoldings() {
        return repository.findAll();
    }
}