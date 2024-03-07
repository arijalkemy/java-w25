use movies_db;

CREATE TEMPORARY TABLE TWD (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    number INT,
	release_date DATE,
    rating FLOAT,
    season INT
);

INSERT INTO TWD (title, number, release_date, rating, season)
SELECT e.title, e.number, e.release_date, e.rating, s.number
FROM episodes e
JOIN seasons s ON e.season_id = s.id
JOIN series s2 ON s.serie_id = s2.id
WHERE s2.title LIKE 'The Walking Dead';


SELECT *
FROM TWD
WHERE season = 2;

CREATE INDEX idx_title ON movies (title);