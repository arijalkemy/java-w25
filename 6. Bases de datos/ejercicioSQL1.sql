SELECT * FROM movies; #Mostrar todos los registros de la tabla de movies.

SELECT first_name, last_name, rating FROM actors; #Mostrar el nombre, apellido y rating de todos los actores.

SELECT title titulo FROM series s; #Mostrar el título de todas las series y usar alias para que tanto el nombre de la tabla como el campo estén en español.

SELECT first_name,  last_name FROM actors a WHERE rating > 7.5; #Mostrar el nombre y apellido de los actores cuyo rating sea mayor a 7.5.

SELECT title, rating, awards FROM movies m WHERE rating >7.5 AND awards >2; #Mostrar el título de las películas, el rating y los premios de las películas con un rating mayor a 7.5 y con más de dos premios.

SELECT title, rating FROM movies ORDER BY rating; # Mostrar el título de las películas y el rating ordenadas por rating en forma ascendente.

SELECT title FROM movies LIMIT 3;  # Mostrar los títulos de las primeras tres películas en la base de datos.

SELECT title, rating,awards FROM movies ORDER BY rating DESC, awards DESC LIMIT 5;  # Mostrar el top 5 de las películas con mayor rating.

SELECT first_name, last_name FROM actors a LIMIT 10;# Listar los primeros 10 actores.

SELECT title, rating FROM movies m WHERE title LIKE '%Toy Story%'; # Mostrar el título y rating de todas las películas cuyo título sea de Toy Story.

SELECT first_name, last_name FROM actors a WHERE  first_name LIKE 'Sam%'; # Mostrar a todos los actores cuyos nombres empiezan con Sam.

SELECT title, rating, awards, release_date FROM movies m 
WHERE rating > 3 AND awards > 1 AND YEAR(release_date) BETWEEN '1988' AND '2009' ORDER BY rating; # Traer el título de las películas con el rating mayor a 3, con más de 1 premio y con fecha de lanzamiento entre el año 1988 al 2009. Ordenar los resultados por rating.

SELECT s.title,  g.name FROM series s JOIN genres g  ON s.genre_id = g.id ; #Mostrar el título y el nombre del género de todas las series.

SELECT e.title, a.first_name, a.last_name FROM episodes e JOIN actor_episode ae ON e.id = ae.episode_id JOIN actors a on a.id = ae.actor_id; # Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT s.title, MAX(s2.`number`) FROM series s JOIN seasons s2 ON s.id = s2.serie_id GROUP BY s.title ;# Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT g.name, COUNT(m.id) as total_peliculas FROM genres g JOIN movies m ON m.genre_id = g.id GROUP BY g.name HAVING COUNT(m.id >=3);# Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT DISTINCT a.first_name, a.last_name FROM actors a JOIN actor_movie am ON a.id = am.actor_id JOIN movies m ON m.id = am.movie_id WHERE m.title LIKE '%GUERRA%'; # Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.SELECT g.name, COUNT(m.id) FROM genres g JOIN movies m ON m.genre_id = g.id ;# Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
