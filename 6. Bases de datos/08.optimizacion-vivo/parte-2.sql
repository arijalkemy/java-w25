use movies_db;
-- sql avanzadas 2
-- Agregar una película a la tabla movies
insert into movies(title, rating, awards, release_date, length, genre_id)
values('Muchachos', 8.0, 2, '2024-01-03', 123, 1);

-- Agregar un género a la tabla genres
insert into genres(name, ranking, active)
values('Drama intenso', 14 , 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2
update movies
set genre_id = 14
where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1
update actors
set favorite_movie_id = 14
where id = 2;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temp
SELECT * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM movies_temp
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
select g.name from movies m
	inner join genres g on m.genre_id = g.id
group by g.name
having count(*) > 1;

select g.name from movies m
	inner join genres g on m.genre_id = g.id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select concat(a.first_name, ' ',  a.last_name) as 'Nombre' from actors a
	inner join movies m on a.favorite_movie_id = m.id and m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX nombre_indice ON movies (title);

-- Chequee que el índice fue creado correctamente.
show index from movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Depende el uso de la misma. El índice sobre el nombre de las películas podría ser una mejora
-- considerable en la perfo de la misma

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- En la tabla de episodios en relación a la de cantidad de episodios que existen para cada serie y los costos que eso puede implicar