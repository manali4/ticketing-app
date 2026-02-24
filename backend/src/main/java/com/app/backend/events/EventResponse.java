package com.app.backend.events;

import java.time.OffsetDateTime;

public record EventResponse(
        Long id,
        String title,
        String city,
        String venue,
        OffsetDateTime startTime,
        Integer minPriceCents,
        Integer maxPriceCents) {
    static EventResponse from(Event e) {
        return new EventResponse(
                e.getId(),
                e.getTitle(),
                e.getCity(),
                e.getVenue(),
                e.getStartTime(),
                e.getMinPriceCents(),
                e.getMaxPriceCents());
    }
}