use movies_db;
select * from genres;
# Agregar una película a la tabla movies.
insert into movies values(999,null,null,"Dune 2",8.0,0,"2024-02-29",180,5);
# Agregar un genero a la tabla genres
insert into genres values(13,"2024-03-06 15:30:00",null,"Independiente",13,1);
# Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies mo
set mo.genre_id = 13
where mo.id = 999;
select * from movies where id = 999;
# Modifica la tabla actors para que algun actor tenga favorita la nueva pelicula
update actors ac
set ac.favorite_movie_id = 999
where ac.id = 12;
# Crear una tabla temporal copia de la tabla movies
create temporary table movies_copy (
	select * from movies
);
select * from movies_copy;
# Eliminar de esa tabla temporal todas las peliculas con awards < 5
delete from movies_copy
where awards < 5;
# Obtener la lista de todos los generos que tengan al menos una pelicula
select ge.name, count(mo.genre_id) as generos from genres ge
inner join movies mo on mo.genre_id = ge.id
group by mo.genre_id
having generos >= 1
order by generos;
# Obtener la lista de actores cuya pelicula favorita tenga mas de 3 awards
select ac.first_name, ac.last_name, mo.title, mo.awards
from actors ac
inner join movies mo on ac.favorite_movie_id = mo.id
where mo.awards > 3
order by mo.awards desc;
# Crear un indice sobre el nombre de la tabla movies
create index nombre_pelicula on movies(title);
show index from movies;
# Verificar el rendimiento con el index y sin index
select * from movies
where title = "Avatar";
select * from movies_copy
where title = "Avatar";