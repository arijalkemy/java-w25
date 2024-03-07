-- 1
INSERT INTO `movies_db`.`movies`
(`id`,
`created_at`,
`updated_at`,
`title`,
`rating`,
`awards`,
`release_date`,
`length`,
`genre_id`)
VALUES
(99,
null,
null,
"Spiderman",
5.0,
2,
current_date(),
1,
1);

-- 2
INSERT INTO `movies_db`.`genres`
(`id`,
`created_at`,
`updated_at`,
`name`,
`ranking`,
`active`)
VALUES
(99,
null,
null,
"Ficcion",
99,
1);

-- 3 
UPDATE movies SET genre_id=99 WHERE id = 99;


-- 4
UPDATE `movies_db`.`actors`
SET
`favorite_movie_id` = 99
WHERE `id` = 3;

-- 5
CREATE TEMPORARY TABLE temporalMovie
SELECT * FROM movies;

SELECT * FROM temporalMovie;

SET SQL_SAFE_UPDATES = 0;

-- 6
DELETE FROM temporalMovie WHERE awards < 5;

-- 7
SELECT title, genres.name
FROM movies
JOIN genres on movies.genre_id = genres.id
WHERE genre_id IS NOT NULL;

-- 8
SELECT first_name, last_name
FROM actors
JOIN movies on actors.favorite_movie_id = movies.id
WHERE movies.awards > 3;

-- 10
CREATE INDEX movie_namex
ON movies(title);

EXPLAIN SELECT * FROM movies m WHERE m.title LIKE "H%";

SHOW INDEX FROM series;

-- 11
-- Existiria una mejora notable en crear un indice por ejemplo en la columna title, ya que es comun hacer consultas por el titulo de peliculas y no suele ser una tabla que se actualice
-- muy a menudo. De esta manera, con un indice en esta tabla, podemos observar que por ejemplo con la sentencia EXPLAIN SELECT * FROM movies m WHERE m.title LIKE "H%";
-- se pasa de recorrer 22 filas para encontrar todas las filas coincidentes con la clausula, a solo tener que recorrer 4 filas en total.

-- 12
-- Podriamos crear un indice para la tabla de series en la columna title. Suponiendo que se realizaran consultas mediante el valor de dicha columna, incluida la clausula LIKE y Wildcards
-- con un indice en dicha columna estas consultas serian mucho mas eficientes y veloces, mejorando el performance de la base de datos.