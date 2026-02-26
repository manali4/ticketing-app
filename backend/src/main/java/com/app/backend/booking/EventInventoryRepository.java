package com.app.backend.booking;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

public interface EventInventoryRepository extends JpaRepository<EventInventory, Long> {

    // Atomic: only updates if enough tickets remain
    @Modifying
    @Query("""
                UPDATE EventInventory i
                SET i.sold = i.sold + :qty
                WHERE i.eventId = :eventId
                  AND (i.capacity - i.sold) >= :qty
            """)
    int trySell(@Param("eventId") Long eventId, @Param("qty") int qty);
}