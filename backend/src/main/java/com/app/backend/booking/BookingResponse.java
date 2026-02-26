package com.app.backend.booking;

import java.time.OffsetDateTime;

public record BookingResponse(
        Long id,
        Long eventId,
        Integer quantity,
        String status,
        OffsetDateTime createdAt) {
    static BookingResponse from(Booking b) {
        return new BookingResponse(b.getId(), b.getEventId(), b.getQuantity(), b.getStatus(), b.getCreatedAt());
    }
}