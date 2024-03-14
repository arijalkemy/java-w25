-- 1. Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name
FROM series LEFT JOIN genres ON series.genre_id = genres.id;

-- 2. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title, a.first_name, a.last_name
FROM episodes e LEFT JOIN
    (SELECT actor_episode.episode_id, actors.first_name, actors.last_name
    FROM actor_episode JOIN actors ON actor_episode.actor_id = actors.id) a
ON e.id = a.episode_id;

-- 3. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT series.title, COUNT(*) AS seasons
FROM series JOIN seasons ON series.id = seasons.serie_id
GROUP BY series.id;

-- 4. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT genres.name, COUNT(*) as movies
FROM genres JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.id
HAVING movies >= 3;

-- 5. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT actors.first_name, actors.last_name
FROM actors JOIN
    (SELECT actor_movie.actor_id
     FROM movies JOIN actor_movie ON movies.id = actor_movie.movie_id
     WHERE movies.title LIKE 'La Guerra de las galaxias%') a
ON actors.id = a.actor_id;
