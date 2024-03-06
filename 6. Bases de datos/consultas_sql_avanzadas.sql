
-- Agregar una película a la tabla movies.
INSERT INTO movies_db.movies
VALUES (22, null, null, 'Poor things', 8.4, 3, '2023-10-04 00:00:00',270, 5);
-- Agregar un género a la tabla genres.
INSERT INTO movies_db.genres
VALUES (13, '2013-07-04 00:00:00', null, 'Satira', 13, 1 );
-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies_db.movies
SET genre_id = 12
WHERE id = 22 ;
SELECT * FROM movies_db.movies;
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE movies_db.actors
SET favorite_movie_id = 22
WHERE id = 1 ;
SELECT * FROM movies_db.actors;
-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy (
    id INT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    title VARCHAR(255),
    rating DECIMAL(10, 2),
    awards INT,
    release_date DATETIME,
    length INT,
    genre_id INT
);
INSERT INTO movies_copy
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies_db.movies;
SELECT * from movies_copy;
-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_copy
WHERE awards < 5;
SELECT * from movies_copy;
-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name
from movies_db.genres g
join movies_db.movies m on g.id = m.genre_id
group by g.id, g.name;
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*
from movies_db.actors a
join movies_db.movies m on m.id = a.favorite_movie_id WHERE m.awards > 3 ORDER by a.id;
-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_index
ON movies_db.movies(title);
-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
