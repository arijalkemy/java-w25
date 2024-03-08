-- Agregar una película a la tabla movies.
INSERT INTO movies (id, title, rating, awards, release_date, `length`, genre_id, created_at, updated_at)
VALUES
(22, 'Rapidos y furiosos', 5.0, 10, '2024-06-12', 100, 1, now(), now());
-- Agregar un género a la tabla genres.
INSERT INTO genres (id, name, ranking, active, created_at, updated_at)
VALUES
(13, 'Reliosa', 13, true, now(), now());
-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 
WHERE title = 'Rapidos y furiosos';
-- Modificar la tabla actors para que al menos un actor tenga como favorita la película 
-- agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22
WHERE actors.rating > 8;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp(
	id int(10) unsigned,
	created_at timestamp,
	updated_at timestamp,
	title varchar(500),
	rating decimal(3,1),
	awards int(10) unsigned,
	release_date datetime,
	length int(10) unsigned,
	genre_id int(10) unsigned
);

INSERT INTO movies_temp ( SELECT * FROM movies);

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temp
WHERE movies_temp.awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.id, count(*) FROM genres g
inner join movies m on m.genre_id = g.id
group by g.id
having count(*) < 5;
-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select * from actors a 
inner join movies m on m.id = a.favorite_movie_id
where m.awards > 3;
-- Crear un índice sobre el nombre en la tabla movies.
create index movie_title_idx
	on movies(title); 

-- Chequee que el índice fue creado correctamente.
show indexes from movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? 
-- Analizar y justificar la respuesta.

/*
 * Con la cantidad de datos que tenemos en este momento no tendría una mejora notable
 * pero si aumentamos la cantidad, podría ser muy util algunos indices en tablas como movies, series y
 * géneros.
 * 
 *  * 
 * */

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
 * Crearía un indice en el campo title de la tabla series
 * 
 */*/
