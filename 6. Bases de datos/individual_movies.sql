use movies_db;
show tables;
CREATE TEMPORARY TABLE the_walking_dead (
    title VARCHAR(255),
    rating DECIMAL(10, 2)
);

INSERT INTO the_walking_dead
SELECT title, rating
FROM episodes
WHERE season_id IN (SELECT id
					FROM seasons
					WHERE serie_id = (	SELECT id
										FROM series
                                        WHERE title = 'The Walking Dead'
									)
					);

SELECT * FROM the_walking_dead;