#Agregar una película a la tabla movies.
INSERT INTO movies values(21331, "2018-12-12", "2018-12-12", "Pelicula1", 7.5, 3, "2018-12-12", 132, 1);
#Agregar un género a la tabla genres.
INSERT INTO genres values(123131, "2018-12-12", "2018-12-12", "Genero1", 13, 1);
#Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies set genre_id = 123131 where id = 21331; 
#Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 21331 WHERE id =1;
#Crear una tabla temporal copia de la tabla movies.
drop TABLE movies_temporary;
CREATE TEMPORARY TABLE movies_temporary SELECT * FROM movies ;
#Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temporary WHERE awards < 5;
#Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * from genres g WHERE id in (SELECT genre_id from movies);
#Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * from actors a WHERE id in (SELECT id from movies m WHERE awards > 3);
#Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movies_name on movies(title);
#Chequee que el índice fue creado correctamente.
SHOW INDEX from movies ;
#En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
# creemos que el nombre de la pelicula es un buen indice ya que en general buscamos peliculas por nombre
# y no por otro campo, por lo que una consulta indexada por nombre obtendria buenos resultados en la mayoria de casos
#¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
# en series se da un caso similar al anterior con el titulo de la serie, por lo que creemos que un indice en este campo beneficiaria las consultas;
