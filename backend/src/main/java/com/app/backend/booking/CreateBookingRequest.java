package com.app.backend.booking;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreateBookingRequest(
        @NotNull Long eventId,
        @NotNull @Min(1) Integer quantity) {
}