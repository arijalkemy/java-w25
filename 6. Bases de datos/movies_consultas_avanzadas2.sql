USE movies_db;
SHOW TABLES;

SELECT * FROM genres;
SELECT * FROM movies;
SELECT * FROM actors;
SELECT * FROM movies_copy;

#Punto 1 - Agregar una película a la tabla movies.
INSERT INTO movies (id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (1000, null, null, 'Kimetsu No Yaiba: Demon Slayer - Arco de entrenamiento pilar', 4.8, 0, '2024-02-22', '100', 7);

#Punto 2 - Agregar un género a la tabla genres.
INSERT INTO genres (id, name, ranking, active)
VALUES (14,"Anime",14,1);

#Punto 3 - Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 14
WHERE id = 1000;

#Punto 4 - Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1
UPDATE actors SET favorite_movie_id = 1000
WHERE id = 34;

#Punto 5 - Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_copy AS
SELECT * FROM movies;

#Punto 6 - Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movie_copy WHERE awards < 5;  

#Punto 7 - Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.name 
FROM movies m INNER JOIN genres g 
ON m.genre_id  = g.id;

#Punto 8 - Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name ,a.last_name ,m.title ,m.awards  
FROM actors a INNER JOIN movies m 
ON a.favorite_movie_id = m.id 
WHERE m.awards > 3;

#Punto 9 - Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_name
ON movies(title);

#Punto 10 - Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;
