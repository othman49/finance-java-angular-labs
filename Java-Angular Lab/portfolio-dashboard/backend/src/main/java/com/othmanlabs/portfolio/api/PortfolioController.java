package com.othmanlabs.portfolio.api;

import com.othmanlabs.portfolio.domain.Holding;
import com.othmanlabs.portfolio.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService service;

    public PortfolioController(PortfolioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Holding> getHoldings() {
        return service.getAllHoldings();
    }

    @PostMapping
    public Holding addHolding(@RequestBody CreateHoldingRequest request) {
        return service.addHolding(
                request.symbol(),
                request.quantity(),
                request.avgCost()
        );
    }

    public record CreateHoldingRequest(
            String symbol,
            BigDecimal quantity,
            BigDecimal avgCost
    ) {}
}