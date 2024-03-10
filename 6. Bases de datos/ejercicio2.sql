use movies_db;
#Agregar una película a la tabla movies.
insert into movies values(null, now(),null, "Demon Slayer", 10, 22, now(),135 ,null);
select * from movies m ;
#Agregar un género a la tabla genres.
insert into genres values(null,now(),null, "Anime", 25, 1);
select * from genres g ;
#Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies set movies.genre_id = 16 where movies.id  = 23;
#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set actors.favorite_movie_id = 23 where actors.id = 4;
#Crear una tabla temporal copia de la tabla movies.
create temporary table copy_movies (
	select * from movies
);
#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from copy_movies where copy_movies.awards < 5;
#Obtener la lista de todos los géneros que tengan al menos una película.
select g.name  from genres g join movies m on g.id = m.genre_id  GROUP BY  g.name ;
select g.name from genres g where g.id 
IN(select m.genre_id FROM movies m); 
#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * from actors a join movies m on a.favorite_movie_id = m.id where m.awards > 3;
#Crear un índice sobre el nombre en la tabla movies.
ALTER table movies add index indx_title (title); 
#Chequee que el índice fue creado correctamente.
show index from movies;