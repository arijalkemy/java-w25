-- Mostrar el título y el nombre del género de todas las series.
SELECT s.title, g.name
FROM series s
	INNER JOIN genres g
		ON g.id = s.genre_id;


-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.

SELECT e.title, a.first_name, a.last_name
FROM actors a
	INNER JOIN actor_episode ae
		ON ae.actor_id = a.id
	INNER JOIN episodes e
		ON e.id = ae.episode_id
ORDER BY title ASC;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.

SELECT ser.title, COUNT(1) as TOTAL
FROM series ser
	INNER JOIN seasons sea
		ON sea.serie_id = ser.id
GROUP BY ser.title;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.

SELECT gen.name, COUNT(1) AS cantidad_peliculas
FROM genres gen
	INNER JOIN movies mov
		ON mov.genre_id = gen.id
GROUP BY gen.name
HAVING COUNT(1) >= 3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.

SELECT DISTINCT first_name, last_name
FROM actors act
	INNER JOIN actor_movie am
		ON am.actor_id = act.id
	INNER JOIN movies mov
		ON mov.id = am.movie_id
WHERE mov.title LIKE 'La Guerra de las galaxias:%';

