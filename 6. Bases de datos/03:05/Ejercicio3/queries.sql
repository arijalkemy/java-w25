# 1.-
SELECT s.title, g.name 
FROM series AS s
INNER JOIN genres AS g ON s.genre_id = g.id;

# 2.-
SELECT e.title, s.title, CONCAT(a.first_name, " ", a.last_name) AS full_name
FROM series AS s
INNER JOIN seasons AS ss ON ss.serie_id = s.id
INNER JOIN episodes AS e ON e.season_id = ss.id
INNER JOIN actor_episode AS ae ON ae.episode_id = e.id
INNER JOIN actors AS a ON a.id = ae.actor_id
ORDER BY s.title AND e.number;

# 3.-
SELECT s.title, COUNT(ss.id)
FROM seasons AS ss
INNER JOIN series AS s ON s.id = ss.serie_id
GROUP BY ss.serie_id;

# 4.-
SELECT g.name, COUNT(m.id) AS q_movies
FROM genres AS g
INNER JOIN movies AS m ON m.genre_id = g.id
GROUP BY g.id
HAVING q_movies >=3;

# 5.-
SELECT DISTINCT CONCAT(a.first_name, " ", a.last_name) AS full_name
FROM actors AS a
INNER JOIN actor_movie AS am ON am.actor_id = a.id
INNER JOIN movies AS m ON m.id = am.movie_id
WHERE m.title LIKE "%guerra%galaxias%";