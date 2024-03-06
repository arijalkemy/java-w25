USE movies_db;

# Mostrar el título y el nombre del género de todas las series.
SELECT series.title, genres.name FROM series
JOIN genres ON series.genre_id = genres.id;

# Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT episodes.title, actors.first_name, actors.last_name FROM episodes
JOIN actor_episode as ae ON ae.episode_id = episodes.id
JOIN actors ON ae.actor_id = actors.id;

# Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.





