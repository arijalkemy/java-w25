USE movies_db;


# 1 - Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, `length`, genre_id)
VALUES ('Novak Djokovic: La historia', 10.0, 24, '2010-10-04 00:00:00', 100, 1);

# 2 - Agregar un género a la tabla genres.
INSERT INTO genres (created_at, name, ranking, active)
VALUES ('2014-07-04 00:00:00', 'Deporte', 13, 1);

# 3 - Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE movies.id = 22;

# 4 - Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE actors.first_name = 'Sam';

# 5 - Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS (SELECT * FROM movies m);

# 6 - Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy WHERE awards < 5;

# 7 - Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name 
FROM genres g 
WHERE g.id IN (
	SELECT m.genre_id
	FROM movies m
)

# 8 - Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name, a.favorite_movie_id 
FROM actors a 
INNER JOIN movies m ON a.favorite_movie_id = m.id 
WHERE m.awards > 3;

# 9 - Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_titlex ON movies(title);

# 10 - Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

# 11 - En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
 * Creo que crear índices en las tablas que son más consultadas podría ayudar mucho al rendimiento de las consultas
 * 	porque al tener tantas tablas intermedias pueden hacerse más costosas las consultas.
 *  
 */


# 12 - ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/* 
 * Crearía un índice en la tabla 'actors' que incluya nombre y apellido porque
 * 	son columnas que no se actualizan frecuentemente, son consultadas con frecuencia y
 *  es una tabla que puede crecer mucho más rápido que las demás.
 * 
 * También porque en sobre estas columnas suele usarse LIKE que es muy costoso.
 * 	
*/
