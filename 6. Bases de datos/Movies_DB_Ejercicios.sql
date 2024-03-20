
USE movies_db;

# Mostrar todos los registros de la tabla de movies.
SELECT * FROM movies m ;
# Mostrar el nombre, apellido y rating de todos los actores.
SELECT a.first_name , a.last_name , a.rating  FROM actors a;
# Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.
SELECT s.title as "Titulo" FROM series s ;
# Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT a.first_name, a.last_name FROM actors a WHERE a.rating  > 7.5;
# Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT m.title , m.rating ,  FROM movies m ;
# Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT m.title, m.rating  FROM	movies m ORDER BY m.rating ;
# Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT m.title  FROM movies m Limit 3;
# Mostrar el top 5 de las películas con mayor rating.
SELECT m.title  FROM movies m ORDER BY m.rating  LIMIT 5 ;
# Listar los primeros 10 actores.
SELECT a.first_name, a.last_name  FROM actors a LIMIT 10;
# Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT m.title FROM movies m WHERE m.title LIKE "Toy Story%";
# Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT a.first_name, a.last_name  FROM actors a WHERE a.first_name LIKE "Sam%";
# Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT m.title  FROM movies m WHERE m.release_date BETWEEN "2004-01-01" AND "2008-12-31";
# Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT m.title FROM movies m WHERE m.rating > 3 AND m.awards > 1 AND m.release_date BETWEEN "1988-01-01" AND "2009-12-31";



