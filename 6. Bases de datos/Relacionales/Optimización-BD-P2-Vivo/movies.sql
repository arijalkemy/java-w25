-- 1. Agregar una película a la tabla movies.
INSERT INTO movies VALUE (22, null, null, 'Interstellar', 8, 2, '2014-01-01', 200, 5);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres VALUE (13, null, null, 'Anime', 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE title = 'Interstellar';

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 22
WHERE first_name = 'Harrison'
AND last_name = 'Ford';

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy
SELECT *
FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy
WHERE awards <= 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name, m.cant_peliculas
FROM genres g JOIN (
    SELECT genre_id, COUNT(*) AS cant_peliculas
    FROM movies
    GROUP BY genre_id
) m ON g.id = m.genre_id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name, m.title, m.awards
FROM actors a JOIN (
    SELECT *
    FROM movies
    WHERE awards > 3
) m ON a.favorite_movie_id = m.id;

-- 9. Crear un índice sobre el nombre en la tabla movies.
ALTER TABLE movies
ADD INDEX name_index (title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Se podría agregar un índice sobre la cantidad de premios, ya que no tiene muchos valores reales posibles, y sobre
-- la fecha de lanzamiento ya que es muy frecuente filtrar por períodos de tiempo.

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Sobre la tabla de episodios se podría hacer lo mismo generando un índice para la fecha de lanzamiento.