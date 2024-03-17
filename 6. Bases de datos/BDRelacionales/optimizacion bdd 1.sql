#VIVO OPTIMIZACION 2 2
INSERT INTO movies VALUES (10000,null,null,"el niño y la garza", 9.8, 3 , "2024-01-22", 200, 1);

INSERT INTO genres VALUES (13,NULL,NULL,"Gore", 13, 1);

UPDATE movies SET genre_id = 13 WHERE id = 10000;

UPDATE actors SET favorite_movie_id = 10000 WHERE id = 49;

CREATE TEMPORARY TABLE movies_copy (id int, created_at timestamp, updated_at timestamp, 
									title varchar(500), rating decimal(3,1), awards int, 
									release_date datetime, lenght int, genre_id int,
                                    PRIMARY KEY (id));
                                    
INSERT INTO movies_copy SELECT * FROM movies;


SELECT * FROM movies_copy;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM movies_copy WHERE awards < 5;

SELECT name FROM genres JOIN movies_copy ON genres.id = movies_copy.genre_id GROUP BY name;

SELECT first_name,last_name 
FROM actors 
JOIN movies ON actors.favorite_movie_id = movies.id
WHERE movies.awards > 3;