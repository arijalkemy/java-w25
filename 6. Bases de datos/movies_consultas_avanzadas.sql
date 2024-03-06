-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT mo.title AS Movie, ge.name AS Genre
FROM movies_db.movies mo
JOIN movies_db.genres ge ON mo.genre_id = ge.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title, ac.first_name, ac.last_name
FROM movies_db.episodes ep
JOIN movies_db.actor_episode ae ON ae.episode_id = ep.id
JOIN movies_db.actors ac ON ac.id = ae.actor_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title AS Serie, SUM(ss.serie_id) AS Temporadas
FROM movies_db.series se
JOIN movies_db.seasons ss ON ss.serie_id = se.id
GROUP BY ss.serie_id;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT ge.name AS Genero, SUM(se.genre_id) AS Peliculas
FROM movies_db.genres ge 
JOIN movies_db.series se ON se.genre_id = ge.id
GROUP BY se.genre_id
HAVING SUM(se.genre_id) >= 3;


-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y 
-- que estos no se repitan.
SELECT first_name, last_name
FROM movies_db.actors 
WHERE id IN (SELECT act.id
				FROM movies_db.actors act 
				JOIN movies_db.actor_movie am ON am.actor_id = act.id
                JOIN movies_db.movies mv ON mv.id = am.movie_id
                WHERE mv.title LIKE '%Guerra de las galaxias%'
                GROUP BY act.id
                HAVING SUM(am.movie_id) = SUM(mv.id));


