USE movies_db;

#Agregar una película a la tabla movies.
INSERT INTO movies (id, title, rating, awards, genre_id, `length`, release_date) VALUES (100, "peliNueva", 6.9, 3, 1, 155, "2015-03-06");
#Agregar un género a la tabla genres.
INSERT INTO genres (id, name, ranking, active) VALUES (178, "Genero nuevo", 173, 1);
#Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 178 WHERE id = 10000;
#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 10000 WHERE id = 12;
#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy (SELECT * FROM movies m);
#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_copy2 WHERE awards < 5;
#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, g.name, COUNT(*) AS movies_count FROM genres g JOIN movies m  ON g.id = m.genre_id GROUP BY m.genre_id HAVING COUNT(*) >= 1;
#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT ac.first_name, ac.last_name, mo.awards FROM actors ac JOIN movies mo ON ac.favorite_movie_id = mo.id WHERE mo.awards > 3;
#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX mo_index ON movies_copy (title);
#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies_copy;
#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Ahora mismo la cantidad de registros permite un manejo veloz de los datos, pero al crecer definitivamente sí mejoraría el procesamiento al buscar una película por título.
#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Yo lo aplicaría en la tabla de "episodes" para poder facilitar la búsqueda de los mismos.