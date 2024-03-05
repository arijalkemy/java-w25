/*Mostrar todos los registros de la tabla de movies.*/
USE movies_db;         
SELECT * FROM movies;

/*Mostrar el nombre, apellido y rating de todos los actores.*/
SELECT first_name, last_name,rating FROM movies_db.actors;

/*Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.*/
SELECT serie.title AS Titulo FROM movies_db.series AS serie; 

#Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.
SELECT first_name, last_name FROM movies_db.actors WHERE rating > 7.5;

#Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.
SELECT title, rating, awards FROM movies_db.movies WHERE rating>7.5 AND awards>2;

#Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.
SELECT title, rating FROM movies_db.movies ORDER BY rating ASC;

#Mostrar los títulos de las primeras tres películas en la base de datos.
SELECT title FROM movies_db.movies LIMIT 3;

#Mostrar el top 5 de las películas con mayor rating.
SELECT title, rating FROM movies_db.movies ORDER BY rating DESC LIMIT 5;

#Listar los primeros 10 actores.
SELECT * FROM movies_db.actors LIMIT 10;

#Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.
SELECT title, rating FROM movies_db.movies WHERE title LIKE "%toy story%";

#Mostrar a todos los actores cuyos nombres empiezan con Sam.
SELECT * FROM movies_db.actors WHERE first_name LIKE "sam%";

#Mostrar el título de las películas que salieron entre el 2004 y 2008.
SELECT * FROM movies_db.movies WHERE release_date BETWEEN "2004-01-01" AND "2008-12-31";

#Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.
SELECT * FROM movies_db.movies WHERE (release_date BETWEEN "1988-01-01" AND "2009-12-31") AND rating > 3 AND awards > 1 ORDER BY rating DESC;