use movies_db;

CREATE TEMPORARY TABLE TWD (
	id INT NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    number INT NOT NULL,
    release_date DATETIME,
    rating DECIMAL(3,1),
    season_id INT
);

INSERT INTO TWD (id, title, number, release_date, rating, season_id)
SELECT id, title, number, release_date, rating, season_id
FROM episodes
WHERE season_id IN (SELECT id 
					FROM seasons
					WHERE serie_id = (	SELECT id 
										FROM series 
                                        WHERE title = 'The Walking Dead'
									)
					);
                    
SELECT * FROM TWD;