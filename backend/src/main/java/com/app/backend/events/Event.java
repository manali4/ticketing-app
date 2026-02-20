package com.app.backend.events;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String city;
    private String venue;

    @Column(name = "start_time")
    private OffsetDateTime startTime;

    @Column(name = "min_price_cents")
    private Integer minPriceCents;

    @Column(name = "max_price_cents")
    private Integer maxPriceCents;

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCity() { return city; }
    public String getVenue() { return venue; }
    public OffsetDateTime getStartTime() { return startTime; }
    public Integer getMinPriceCents() { return minPriceCents; }
    public Integer getMaxPriceCents() { return maxPriceCents; }
}