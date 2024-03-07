/* 1. Agregar una película a la tabla movies. */
INSERT INTO movies(title, rating, awards, release_date, length, genre_id) 
VALUES('Wini the Pu', 10.0, 10, '2003-12-11', 180, 2); -- película nº 22

/* 2. Agregar un género a la tabla genres. */
INSERT INTO genres(name, ranking, active) 
VALUES('Thriller Post-Apocalíptico', 13, 1); -- género nº 13

/* 3. Asociar a la película del punto 1. genre el género creado en el punto 2. */
UPDATE movies 
SET genre_id = 13
WHERE id = 22;

/* 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1. */
UPDATE actors 
SET favorite_movie_id = 22 
WHERE id = 39; -- actor con favorite_movie_id nulo

/* 5. Crear una tabla temporal copia de la tabla movies. */

-- FORMA 1
CREATE TEMPORARY TABLE temporal_movies (
    id INT NOT NULL PRIMARY KEY,
    created_at DATETIME,
    updated_at DATETIME,
    title VARCHAR(500),
    rating DECIMAL(3,1),
    awards INT,
    release_date DATETIME,
    length INT,
    genre_id INT
);

INSERT INTO temporal_movies (id, created_at, updated_at, title, rating, awards, release_date, length, genre_id)
SELECT id, created_at, updated_at, title, rating, awards, release_date, length, genre_id
FROM movies;

-- FORMA 2
CREATE TEMPORARY TABLE temporal_movies3 (
    SELECT * FROM movies
);
SELECT * FROM temporal_movies3;

/* 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards. */
DELETE FROM temporal_movies
WHERE awards < 5;

/* 7. Obtener la lista de todos los géneros que tengan al menos una película. */
SELECT g.name, count(m.genre_id) movie_quantity
FROM genres g 
JOIN movies m ON g.id = m.genre_id
GROUP BY g.name;

/* 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards. */
SELECT concat(a.first_name, ' ', a.last_name), m.title, m.awards
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3
ORDER BY m.awards DESC;

/* 9. Crear un índice sobre el nombre en la tabla movies. */
CREATE INDEX movies_title_idx
ON movies(title);

/* 10. Chequee que el índice fue creado correctamente. */
SHOW INDEX FROM movies;

/* 
11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

Pensamos que sí existiría una mejora al crear un índice ej.: índice por título de película. Este índice nos permite
encontrar la película inmediatamente si sabemos el nombre exacto de la misma. Aquí el índice sirve por que sabemos
que el título de la película no va a cambiar en el tiempo (o es muy poco probable que pase).
*/

/*
12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta 

Crearíamos índices en el campo release_date de las tablas, ya que las búsquedas por fecha suelen ser
comunes en los usuarios y es conveniente indexarlas.
*/