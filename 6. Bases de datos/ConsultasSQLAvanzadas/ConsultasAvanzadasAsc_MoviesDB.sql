use movies_db;
-- TItulo y el nombre del género de todas las series.
SELECT s.title as Titulo, g.name as Genero
FROM series s INNER JOIN genres g ON s.genre_id = g.id;
-- Titulo de los episodios, el nombre y apellido de los actores que trabajan en cada uno de ellos.
SELECT e.title as "Titulo Episodio", concat(a.first_name," ",a.last_name) as Actor
FROM episodes e INNER JOIN actors a ON e.id = a.id;
-- Título de todas las series y el total de temporadas que tiene cada una de ellas.
SELECT sr.title as Titulo, count(ss.number)
FROM series sr INNER JOIN seasons ss ON sr.id = ss.serie_id
GROUP BY sr.title;
-- Nombre de todos los géneros y la cantidad total de películas por cada uno, siempre que sea mayor o igual a 3.
SELECT g.name as Genero, count(m.title) as "Cantidad Peliculas"
FROM genres g INNER JOIN movies m ON g.id = m.genre_id
GROUP BY g.name HAVING count(m.title)>=3;
-- Mostrar sólo el nombre y apellido de los actores que trabajan en todas las películas de la guerra de las galaxias y que estos no se repitan.
SELECT DISTINCT concat(a.first_name," ",a.last_name) as Actor, m.title as Pelicula
FROM movies m INNER JOIN actors a ON m.id = a.favorite_movie_id
WHERE m.title LIKE "La Guerra de las galaxias%";
