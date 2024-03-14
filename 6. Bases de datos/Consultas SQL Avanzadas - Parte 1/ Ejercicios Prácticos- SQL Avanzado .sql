##Segunda Parte

#. Mostrar el título y el nombre del género de todas las series.
SELECT se.title, ge.name FROM series se
INNER JOIN genres ge ON se.genre_id = ge.id;

#. Mostrar el título de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT ep.title as Titulo, ac.first_name as Nombre, ac.last_name as Apellido FROM actor_episode ae
INNER JOIN actors ac ON ae.actor_id = ac.id
INNER JOIN episodes ep ON ae.episode_id = ep.id
ORDER BY ep.title;

#. Mostrar el título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT se.title as Titulo, COUNT(*) as Temporadas FROM series se
INNER JOIN seasons sea ON sea.serie_id = se.id
GROUP BY se.title;

#. Mostrar el nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT ge.name as Nombre, COUNT(*) as Total FROM movies mo
INNER JOIN genres ge ON mo.genre_id = ge.id
GROUP BY ge.name
HAVING Total >= 3;

#. Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT ac.first_name as Nombre, ac.last_name as Apellido FROM actor_movie am
INNER JOIN actors ac ON am.actor_id = ac.id
INNER JOIN movies mo ON am.movie_id = mo.id
WHERE mo.title LIKE "%la guerra de las galaxias%"
GROUP BY ac.id;
