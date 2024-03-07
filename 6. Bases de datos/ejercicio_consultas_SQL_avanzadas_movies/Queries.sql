use movies_db;

-- Mostrar el título y el nombre del género de todas las series.
SELECT g.name, s.title FROM genres AS g
INNER JOIN series AS s
WHERE s.genre_id = g.id;

-- Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name FROM episodes AS e
INNER JOIN actor_episode AS ae ON ae.episode_id=e.id
INNER JOIN actors AS a ON a.id=ae.actor_id;

-- Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT s.title, count(*) AS 'num_temporadas' FROM series AS s
INNER JOIN seasons AS se ON s.id=se.serie_id
GROUP BY se.serie_id;

-- Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name, count(*) AS 'num_movies' FROM genres AS g
INNER JOIN movies AS m ON g.id=m.genre_id
GROUP BY m.genre_id
HAVING num_movies >=3;

-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT a.first_name, a.last_name FROM actors as a
INNER JOIN actor_movie AS am ON am.actor_id=a.id
INNER JOIN movies AS m ON m.id=am.movie_id
WHERE m.title LIKE 'La Guerra de las galaxias%';