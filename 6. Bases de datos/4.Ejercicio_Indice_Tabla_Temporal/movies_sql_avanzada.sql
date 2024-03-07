use movies_db;
-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id) 
	VALUES(null,null, 'Narnia', 4.5, 4,  '2003-11-04 00:00:00', 300, 6);

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active) VALUES (null, null, 'Deporte', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 28;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy (
	select * from movies
);

SELECT * FROM movies_copy;

-- eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
explain SELECT *
FROM genres
WHERE id IN (SELECT distinct genre_id FROM movies);

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.*
FROM actors a
JOIN movies m ON m.id = a.favorite_movie_id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX title_idx 
ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Sí, al crear indices se observa una mejora en el rendimiento de las consultas, especialmente cuando se realizan búsquedas frecuentes,  
-- en las tablas, ya que la velocidad de la consulta es significativamente menor cuando se utiliza un índice.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En la otra tabla que crearía un índice es en la tabla de series. Aunque en este esquema la tabla puede no tener una gran cantidad 
-- de filas, es mas frecuente buscar por series. Ademas, considero que es una tabla que se actualizaría con menos frecuencia, 
-- en comparación a las otras tablas.