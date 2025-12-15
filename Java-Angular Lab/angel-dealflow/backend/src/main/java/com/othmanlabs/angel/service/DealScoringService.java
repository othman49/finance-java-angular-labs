package com.othmanlabs.angel.service;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class DealScoringService {

    public int score(String stage, BigDecimal ticketSize, String country) {
        int score = 0;

        if ("seed".equalsIgnoreCase(stage)) score += 30;
        if ("pre-seed".equalsIgnoreCase(stage)) score += 35;
        if ("series a".equalsIgnoreCase(stage)) score += 20;

        if (ticketSize.compareTo(new BigDecimal("25000")) <= 0) score += 20;
        else if (ticketSize.compareTo(new BigDecimal("100000")) <= 0) score += 10;

        if ("morocco".equalsIgnoreCase(country)) score += 10;
        if ("uk".equalsIgnoreCase(country)) score += 8;

        return Math.min(score, 100);
    }
}