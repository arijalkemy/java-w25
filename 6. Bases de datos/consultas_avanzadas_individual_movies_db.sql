USE movies_db;
SELECT series.title, genres.name AS genre
FROM series
INNER JOIN genres ON series.genre_id = genres.id;
SELECT episodes.title AS episode_title, actors.first_name, actors.last_name
FROM episodes
INNER JOIN actor_episode ON episodes.id = actor_episode.episode_id
INNER JOIN actors ON actor_episode.actor_id = actors.id;
SELECT genres.name AS genre_name, COUNT(*) AS movie_count
FROM genres
INNER JOIN movies ON genres.id = movies.genre_id
GROUP BY genres.name
HAVING COUNT(*) >= 3;

SELECT DISTINCT actors.first_name, actors.last_name
FROM actors
JOIN actor_movie ON actors.id = actor_movie.actor_id
JOIN movies ON actor_movie.movie_id = movies.id
WHERE movies.title LIKE '%Guerra de las Galaxias%'
GROUP BY actors.id
HAVING COUNT(DISTINCT movies.id) = (
    SELECT COUNT(*)
    FROM movies
    WHERE title LIKE '%Guerra de las Galaxias%'
);




