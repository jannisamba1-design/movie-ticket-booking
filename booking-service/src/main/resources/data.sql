-- MOVIES
INSERT INTO movie (id, name, language, genre, duration_minutes)
VALUES
('550e8400-e29b-41d4-a716-446655440000', 'Inception', 'EN', 'Sci-Fi', 148);

-- THEATRES
INSERT INTO theatre (id, name, city)
VALUES
('660e8400-e29b-41d4-a716-446655440000', 'PVR Orion', 'Bangalore');

-- SCREENS
INSERT INTO screen (id, name, total_seats, theatre_id)
VALUES
('770e8400-e29b-41d4-a716-446655440000', 'Screen 1', 100,
 '660e8400-e29b-41d4-a716-446655440000');

-- SEATS
INSERT INTO seat (id, screen_id)
VALUES
('A1', '770e8400-e29b-41d4-a716-446655440000'),
('A2', '770e8400-e29b-41d4-a716-446655440000'),
('A3', '770e8400-e29b-41d4-a716-446655440000');

-- SHOWS
INSERT INTO show (id, movie_id, screen_id, show_time)
VALUES
('880e8400-e29b-41d4-a716-446655440000',
 '550e8400-e29b-41d4-a716-446655440000',
 '770e8400-e29b-41d4-a716-446655440000',
 '2026-02-01 18:30:00');
