use movies_db;

SELECT * FROM movies;
#Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
VALUES ("La bella y la bestia", 7.5, 2, "1998-10-15", 120, 7);
#Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ("Melodrama", 13, 1);
#Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = 13
WHERE id = 22;
#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE actors
SET favorite_movie_id = 22
WHERE id = 3;
#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy_ SELECT * FROM movies;
SELECT * FROM movies_copy_;
#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy_
WHERE awards < 5;
#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT name FROM genres g 
WHERE g.id IN (
	SELECT genre_id from movies
	GROUP BY genre_id
	HAVING COUNT(genre_id) > 1
)

SELECT name FROM genres g 
INNER JOIN movies m ON g.id = m.genre_id 
GROUP BY m.genre_id 
HAVING COUNT(m.genre_id) > 1;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT first_name, last_name FROM actors a 
INNER JOIN movies m ON m.id = a.favorite_movie_id 
WHERE m.awards >3;
#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_movies_index
ON movies (title);
#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
 Si existiria una mejora, en caso que creemos el indice en el titulo de la pelicula como es una tabla bastante consultada
 normalmente consultamos por el titulo de la pelicula mas no por su id, al tener un indice en este se generarian las
 consultas de una mánera mas agil
 */

#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
 Otra tabla en la que podemos crear un indice es en la tabla de actores, teniendo la misma postura que con la tabla
 movies, en la tabla de actores las consultas normalmente se hacen por el nombre y apellido del actor.
 Si hacemos una consulta sin indice, el motoro recorre 49 filas buscando al actor "Sam" "Worthington".
 En cambio si creamos un indice en actors de nombre y apellido unicamente recorre una columna para realizar la consulta.
 */
CREATE INDEX actor_name_movies_index
ON actors (first_name, last_name);
EXPLAIN SELECT * FROM actors 
WHERE first_name = "Sam" AND last_name = "Worthington";


