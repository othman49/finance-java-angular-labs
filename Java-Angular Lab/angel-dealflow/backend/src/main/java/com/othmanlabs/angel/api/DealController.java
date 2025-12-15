package com.othmanlabs.angel.api;

import com.othmanlabs.angel.domain.Deal;
import com.othmanlabs.angel.service.DealService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class DealController {

    private final DealService service;

    public DealController(DealService service) {
        this.service = service;
    }

    @GetMapping
    public List<Deal> listDeals() {
        return service.getAllDeals();
    }

    @PostMapping
    public Deal createDeal(@RequestBody CreateDealRequest request) {
        return service.createDeal(
            request.startupName(),
            request.sector(),
            request.stage(),
            request.country(),
            request.ticketSize()
        );
    }

    public record CreateDealRequest(
        String startupName,
        String sector,
        String stage,
        String country,
        BigDecimal ticketSize
    ) {}
}