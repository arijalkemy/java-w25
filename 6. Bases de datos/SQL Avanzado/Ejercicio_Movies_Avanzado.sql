USE movies_db;

-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (NULL, NULL, "Karate Kid", "8.0", 4, "1984-01-01", 126, NULL);

INSERT INTO movies (title, rating, awards, release_date, length)
VALUES ("Karated Kid 2", 6.0, 1, "1986-01-01", 120);

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

-- Chequear datos de la temporal 
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
ALTER TABLE movies
ADD INDEX (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEXES FROM movies;

-- En la tabla movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*	La mejora se puede apreciar al momento de realizar consultas utilizando el campo "title". Pero, dado que
	es una tabla con poca información dentro, no se va a percibir un cambio notable mas alla de unos milisegundos.
*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*	Podria crear un indice en la tabla actors, concretamente en los campos "first_name" y "last_name",
	dado que son campos utilizados frecuentemente en las operaciones realizadas recientemente.
*/