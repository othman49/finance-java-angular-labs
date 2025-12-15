package com.othmanlabs.angel.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "deals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startupName;
    private String sector;
    private String stage;
    private String country;
    private BigDecimal ticketSize;
    private int score;

    protected Deal() {}

    public Deal(
        String startupName,
        String sector,
        String stage,
        String country,
        BigDecimal ticketSize,
        int score
    ) {
        this.startupName = startupName;
        this.sector = sector;
        this.stage = stage;
        this.country = country;
        this.ticketSize = ticketSize;
        this.score = score;
    }

    public Long getId() { return id; }
    public String getStartupName() { return startupName; }
    public String getSector() { return sector; }
    public String getStage() { return stage; }
    public String getCountry() { return country; }
    public BigDecimal getTicketSize() { return ticketSize; }
    public int getScore() { return score; }
}