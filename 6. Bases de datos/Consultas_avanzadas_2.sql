-- Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id)
values ("Bootcamp Java W25", 9.9, 24, CURRENT_TIMESTAMP, 120, 2);

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, name, ranking, active)
values (CURRENT_TIMESTAMP, "Informatica", 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE temporary table t_movies select * from movies m ;
SELECT * from t_movies tm;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM t_movies tm WHERE tm.awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.* from genres g join movies m on m.genre_id = g.id ;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* from actors a join movies m on m.id = a.favorite_movie_id WHERE m.awards > 3 ORDER by a.id ;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE index title_movie_idx on movies (title);

-- Chequee que el índice fue creado correctamente.
-- Checkeado.

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
CREATE temporary table t_movies2 select * from movies m ;
explain select * from t_movies2 where title = "Avatar";
explain select * from movies where title = "Avatar";
-- Existe una mejora ya que no recorre todos los campos de la tabla sino que al existir un indice busca directamente la fila.

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- actors -> first_name y last_name, genre -> name, series -> title.

