#Agregar una película a la tabla movies.
INSERT INTO movies (id,created_at,updated_at,title,rating,awards,release_date,length,genre_id) VALUES (23,null,null,"w25",8.2, 2, '2024-03-05',110,null);

#Agregar un género a la tabla genres.
INSERT INTO genres (id,created_at,updated_at,name,ranking,active) VALUES (14,'2024-01-01',null,"Bootcamp",13, 1);

#Asociar a la película del punto 1. genre el género creado en el punto 2.
update movies set genre_id = 14 where id = 23;

#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 23 WHERE id = 1;

#Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE tem_movies2 SELECT * FROM movies m ;
SELECT * FROM tem_movies2;

#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM tem_movies2 where awards <= 5;

#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT  g.name  from movies m 
inner join genres g on m.genre_id = g.id ;

#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name ,a.last_name , m.title ,m.awards 
FROM actors a 
INNER JOIN movies m on a.favorite_movie_id = m.id 
WHERE m.awards > 3;

#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_movie_name ON movies (title);

#Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
#Depende de la lógica de negcio y de que tan importante es la tabla movies en ella, por ende, si 
#yo identifico que realizo muchas consultas con una frecuecia alta a la tabla movies y por ejemplo usando la columna 
#title sería beneficio a nivel de performance agregar un indice a esta columna.

#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
#Crearía indices en las tablas series y actors ya que son tablas que dentro de este contexto tendrían bastante uso y
#mediante indices se puede llegar a mejorar el rendimiento de las consultas mas frecuentes sobre estas tablas



SELECT * FROM actors a ;
SELECT * FROM movies m ;
select * from genres g ;