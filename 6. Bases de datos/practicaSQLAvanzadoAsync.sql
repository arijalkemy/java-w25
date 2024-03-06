SELECT s.title, g.name AS 'genre' FROM series s
INNER JOIN genres g;

SELECT e.title AS 'episode title', a.first_name, a.last_name AS 'episode' FROM actors a
INNER JOIN actor_episode ae
INNER JOIN episodes e;

SELECT s.title, COUNT(*) AS 'Seasons' FROM seasons se
INNER JOIN series s ON se.serie_id = s.id
GROUP BY s.title;

SELECT g.name AS 'Genre', COUNT(*) AS 'Number of movies' FROM movies m
INNER JOIN genres g ON m.genre_id = g.id
GROUP BY g.name
HAVING COUNT(*) > 3;

SELECT DISTINCT a.first_name, a.last_name FROM actors a
INNER JOIN actor_movie am ON a.id = am.actor_id
INNER JOIN movies m ON am.movie_id = m.id
WHERE m.title LIKE '%Guerra%';