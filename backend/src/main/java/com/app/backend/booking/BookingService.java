package com.app.backend.booking;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookingService {

    private final EventInventoryRepository inventoryRepo;
    private final BookingRepository bookingRepo;

    public BookingService(EventInventoryRepository inventoryRepo, BookingRepository bookingRepo) {
        this.inventoryRepo = inventoryRepo;
        this.bookingRepo = bookingRepo;
    }

    @Transactional
    public Booking create(Long eventId, int qty) {
        int updated = inventoryRepo.trySell(eventId, qty);
        if (updated == 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not enough tickets available");
        }

        Booking b = new Booking();
        b.setEventId(eventId);
        b.setQuantity(qty);
        b.setStatus("CONFIRMED");
        return bookingRepo.save(b);
    }
}