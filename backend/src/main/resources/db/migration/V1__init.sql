CREATE TABLE events (
  id BIGSERIAL PRIMARY KEY,
  title TEXT NOT NULL,
  city TEXT NOT NULL,
  venue TEXT NOT NULL,
  start_time TIMESTAMPTZ NOT NULL,
  min_price_cents INT NOT NULL,
  max_price_cents INT NOT NULL
);

INSERT INTO events (title, city, venue, start_time, min_price_cents, max_price_cents)
VALUES
('Standup Night', 'Chicago', 'Laugh House', NOW() + INTERVAL '7 days', 2500, 6000),
('Indie Concert', 'Austin', 'Neon Arena', NOW() + INTERVAL '14 days', 4000, 12000);