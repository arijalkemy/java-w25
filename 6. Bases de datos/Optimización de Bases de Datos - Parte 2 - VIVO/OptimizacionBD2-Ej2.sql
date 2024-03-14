# Agregar una película a la tabla movies.
insert into movies (title, rating, awards, release_date, length, genre_id) 
values ("Los bañeros 3", 1.5, 0, "2012-01-10", 90, 1);

# Agregar un género a la tabla genres.
insert into genres (created_at, name, ranking, active) 
values (current_timestamp,"Anime", 13, 1);

# Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies set genre_id = 16 where title like "Los bañeros 3";

# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
update actors set favorite_movie_id = 22 where id = 12;

# Crear una tabla temporal copia de la tabla movies.
create temporary table movies_copy (select * from movies);

# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
delete from movies_copy where awards < 5;

# Obtener la lista de todos los géneros que tengan al menos una película.
select DISTINCT g.name, g.ranking, g.active from genres g join movies m on g.id = m.genre_id;

# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.first_name, a.last_name, m.awards from actors a join movies m on a.favorite_movie_id = m.id where m.awards > 3;

# Crear un índice sobre el nombre en la tabla movies.
create index indice_title on movies (title);

# Chequee que el índice fue creado correctamente.
show index from movies;

# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/* Si, porque el punto de entrada a la tabla es el titulo, no el id*/

# ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/* En la de actors ya que se busca por el nombre y apellido*/
create index indice_nomyape on actors (first_name, last_name);