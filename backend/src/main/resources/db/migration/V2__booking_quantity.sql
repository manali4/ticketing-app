CREATE TABLE event_inventory (
  event_id BIGINT PRIMARY KEY REFERENCES events(id) ON DELETE CASCADE,
  capacity INT NOT NULL CHECK (capacity >= 0),
  sold INT NOT NULL DEFAULT 0 CHECK (sold >= 0)
);

CREATE TABLE bookings (
  id BIGSERIAL PRIMARY KEY,
  event_id BIGINT NOT NULL REFERENCES events(id) ON DELETE RESTRICT,
  quantity INT NOT NULL CHECK (quantity > 0),
  status TEXT NOT NULL,
  created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);

-- Seed inventory for existing events (set capacity to something)
INSERT INTO event_inventory (event_id, capacity, sold)
SELECT id, 100, 0 FROM events;