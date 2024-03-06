-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
create temporary table Walking (id int,created_at timestamp,updated_at timestamp,title varchar(500),release_date datetime,release_date datetime,genre_id int);
insert into Walking
Select id, created_at,    updated_at,title,release_date,end_date,genre_id
from series
where title Like "The Walking%";
-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select * from walking w
inner join episodes e on e.serie_id= w.id
where w.number=1;

-- Ejercicio 2
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

-- 6
DELETE FROM temporalMovie WHERE awards < 5;
SET SQL_SAFE_UPDATES = 0;
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
-- 9
CREATE INDEX movie_namex
ON movies(title);
-- 10
SHOW INDEX FROM movies;
-- 11
EXPLAIN SELECT * FROM movies m WHERE m.title LIKE "H%";
SHOW INDEX FROM series;
-- 12
-- Podriamos crear un indice para la tabla de series en la columna title, esto nos permitira reducir la consulta de filas.