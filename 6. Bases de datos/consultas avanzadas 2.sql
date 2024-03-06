/*
Crear un índice sobre el nombre en la tabla movies.
Chequee que el índice fue creado correctamente.
En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
*/

USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (NULL, NULL, "Karate Kid", "8.0", 4, "1984-01-01", 126, NULL);

INSERT INTO movies (title, rating, awards, release_date, length)
VALUES ("Karate Kid 2", 6.0, 1, "1986-01-01", 120);

-- Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ("Deportes", 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE title LIKE "Karate Kid%";

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = "Karate Kid")
WHERE last_name = 'Bernthal';

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy
SELECT * FROM movies;

SELECT * FROM movies_copy;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT name
FROM genres
WHERE id IN (SELECT genre_id FROM movies);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name, m.title
FROM actors a
	INNER JOIN movies m
		ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
EXPLAIN select * from movies where title like 'T%';
CREATE INDEX movie_title ON movies(title);
EXPLAIN select * from movies where title like 'T%';
-- Se puede evidenciar que sin el indice analiza todas las filas para encontrar los resultados, pero con el indice
-- solo las que coinciden con esta condicion por lo que se ahorra todo el tiempo de recorrido.

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Se puede ver reflejado este mismo comportamiento en tablas como episodes, series, actores en las que se puede agregar un nuevo
-- indice para los nombres o titulos.




