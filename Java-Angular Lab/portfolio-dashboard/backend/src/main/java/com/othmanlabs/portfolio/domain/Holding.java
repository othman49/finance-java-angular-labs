package com.othmanlabs.portfolio.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "holdings")
public class Holding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private BigDecimal quantity;
    private BigDecimal avgCost;

    protected Holding() {}

    public Holding(String symbol, BigDecimal quantity, BigDecimal avgCost) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.avgCost = avgCost;
    }

    public Long getId() { return id; }
    public String getSymbol() { return symbol; }
    public BigDecimal getQuantity() { return quantity; }
    public BigDecimal getAvgCost() { return avgCost; }
}