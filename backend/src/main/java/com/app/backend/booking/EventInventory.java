package com.app.backend.booking;

import jakarta.persistence.*;

@Entity
@Table(name = "event_inventory")
public class EventInventory {
    @Id
    @Column(name = "event_id")
    private Long eventId;

    private Integer capacity;
    private Integer sold;

    public Long getEventId() {
        return eventId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getSold() {
        return sold;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}