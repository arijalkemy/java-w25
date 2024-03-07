USE movies_db;

#Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s
INNER JOIN genres g ON s.genre_id = g.id;

#Mostrar el título de los episodios, el nombre y apellido de los actores que 
#trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name
FROM actors a
INNER JOIN actor_episode ae ON a.id = ae.actor_id
INNER JOIN episodes e ON ae.episode_id = e.id;

#Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, COUNT(*) AS total_temporadas
FROM series s
INNER JOIN seasons se ON s.id = se.serie_id
GROUP BY s.id;

#Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, 
#siempre que sea mayor o igual a 3.
SELECT g.name, COUNT(*) AS total_peliculas
FROM genres g
INNER JOIN movies m ON g.id = m.genre_id
GROUP by g.id
HAVING total_peliculas >= 3
;

#Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas 
#de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name
FROM actors a
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies m ON am.movie_id = m.id
WHERE 
	m.title LIKE 'La Guerra de las galaxias%'
;