use movies_db;

-- 1. Agregar una película a la tabla movies.
INSERT INTO movies VALUES (22, NULL, NULL, 'El secreto de sus ojos', 9.9, 5, '2010-03-02', 200, 3);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13, '2023-06-03',NULL,'Horror', 13, true);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies 
SET genre_id = 13 
WHERE id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors 
SET favorite_movie_id = 22 
WHERE id = 4;

-- 5. Crear una tabla temporal copia de la tabla movies.
-- DROP TABLE moviesTMP;
CREATE TEMPORARY TABLE moviesTMP(SELECT * FROM movies);
SELECT * FROM moviesTMP;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
-- SET SQL_SAFE_UPDATES=0;
DELETE FROM moviesTMP WHERE awards<5;
SELECT * FROM moviesTMP;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT gn.name, COUNT(gn.name) AS 'Total peliculas'
FROM genres gn 
JOIN movies mv ON mv.genre_id = gn.id
GROUP BY gn.name 
HAVING COUNT(gn.name) >= 1;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT act.first_name, act.last_name, mv.awards
FROM actors act
JOIN movies mv ON mv.id = act.favorite_movie_id
WHERE mv.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX idx_movies ON movies(title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

