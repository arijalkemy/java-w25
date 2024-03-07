use movies_db;

-- sql avanzadas 2
-- Agregar una película a la tabla movies
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ('Test Movie', 9.0, 5, '2024-02-02', 120, 1);

-- Agregar un género a la tabla genres
INSERT INTO genres (name, ranking, active)
VALUES ('Test Genre', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2
UPDATE movies
SET genre_id = 13
WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita
-- la película agregada en el punto 1
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 34;


-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp (
	SELECT *
    FROM movies
);
SELECT * FROM movies_temp;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_temp
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una pelí
SELECT DISTINCT g.name 
FROM movies m
JOIN genres g ON m.genre_id = g.id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT concat(a.first_name, ' ',  a.last_name) as 'Nombre'
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id AND m.awards > 3;


-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX name_idx
ON movies (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices?
--  Analizar y justificar la respuesta.
CREATE TEMPORARY TABLE t_movies2 SELECT * FROM movies m;
EXPLAIN SELECT * FROM t_movies2 where title = 'Avatar';
EXPLAIN SELECT * FROM movies where title = 'Avatar';

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta


