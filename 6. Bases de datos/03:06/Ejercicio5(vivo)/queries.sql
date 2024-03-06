# 1.-
INSERT INTO movies(created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (NOW(), NOW(), "Avengers", 10, 0, "2019-04-04", 180, 5);

# 2.-
INSERT INTO genres(created_at, updated_at, name, ranking, active)
VALUES (NOW(), NOW(), "SuperHeros", 13, 1);

# 3.-
UPDATE movies
SET genre_id = 13
WHERE id = 22;

# 4.-
UPDATE actors
SET favorite_movie_id = 22
WHERE id = 1;

# 5.-
CREATE TEMPORARY TABLE IF NOT EXISTS movies_temp AS
SELECT * FROM movies;

# 6.-
DELETE FROM movies_temp
WHERE awards < 5;

# 7.-
SELECT DISTINCT g.*
FROM genres AS g
INNER JOIN movies AS m ON m.genre_id = g.id;

# 8.-
SELECT a.*
FROM actors AS a
INNER JOIN actor_movie AS am ON am.actor_id = a.id
INNER JOIN movies AS m ON m.id = am.movie_id
WHERE m.awards > 3;

# 9.-
CREATE INDEX title_idx
ON movies(title);

# 10.- Fue creado, ya que no escanea todas las filas.
SHOW INDEX FROM movies;

# 11.-
/*
Debido a la mejora realizada en el punto 9, la búsqueda por nombre en la tabla "movies" no escanea todas las filas. 
Esto es conveniente, ya que en muchos casos nos vamos a referir a una película por su nombre, y no por su id.
Esta mejora se puede ver al ejecutar la siguiente consulta:
*/
EXPLAIN SELECT * FROM movies
WHERE title = "titanic";

# 12.-
/*
Crearía otro índice para la tabla "actors", para la columna "last_name". 
Creo que esto es conveniente, ya que en muchos casos nos vamos a referir a un actor por su apellido, y no por su id o su nombre.
*/
CREATE INDEX last_name_idx
ON actors(last_name);
SHOW INDEX FROM actors;