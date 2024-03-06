SELECT s.title, g.name 
FROM series s 
LEFT JOIN genres g ON s.genre_id = g.id;

SELECT CONCAT(a.first_name, " ", a.last_name) AS full_name , e.title AS episode 
FROM actor_episode ae 
INNER JOIN episodes e ON ae.episode_id = e.id 
INNER JOIN actors a ON ae.actor_id = a.id;

SELECT s.title, COUNT(*) AS number_of_seasons 
FROM series s 
INNER JOIN seasons s2 ON s.id = s2.serie_id 
GROUP BY s.id 
ORDER BY number_of_seasons DESC;

SELECT g.name AS genre, COUNT(*) AS number_of_movies 
FROM genres g 
INNER JOIN movies m  ON g.id = m.genre_id 
GROUP BY g.id 
HAVING number_of_movies >= 3;

SELECT DISTINCT a.first_name, a.last_name 
FROM actor_movie am 
INNER JOIN actors a ON am.actor_id  = a.id 
INNER JOIN movies m ON am.movie_id = m.id 
WHERE m.title LIKE "La Guerra de las galaxias%";