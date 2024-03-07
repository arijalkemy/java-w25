-- Consultas SQL Avanzadas 2 - Práctica Grupal
USE movies_db;

SELECT * FROM movies;
SELECT * FROM genres;
SELECT * FROM actors;

-- Agregar una película a la tabla movies.
INSERT INTO movies (id, title, rating, awards, release_date, `length`) VALUES (22, "Pelicula", 6.9, 3, "2024-03-06", 140);

-- Agregar un género a la tabla genres.
INSERT INTO genres (id, name, ranking, active) VALUES (13, "Genero", 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 12;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy (
	SELECT * FROM movies
);

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy WHERE awards < 5;
SELECT * FROM movies_copy;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name, COUNT(*) AS movies_count 
FROM genres g 
JOIN movies m 
ON g.id = m.genre_id
GROUP BY m.genre_id
HAVING COUNT(*) >= 1;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT ac.first_name, ac.last_name, mo.awards 
FROM actors ac 
JOIN movies mo 
ON ac.favorite_movie_id = mo.id 
WHERE mo.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE TEMPORARY TABLE movies_copy2 (
	SELECT * FROM movies
);
ALTER TABLE movies_copy2 ADD INDEX movies_awards (awards);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies_copy2;