package com.app.backend.booking;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:5173")
public class BookingController {

    private final BookingService service;
    private final BookingRepository repo;

    public BookingController(BookingService service, BookingRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping
    public BookingResponse create(@Valid @RequestBody CreateBookingRequest req) {
        return BookingResponse.from(service.create(req.eventId(), req.quantity()));
    }

    @GetMapping("/{id}")
    public BookingResponse get(@PathVariable Long id) {
        Booking b = repo.findById(id).orElseThrow();
        return BookingResponse.from(b);
    }
}