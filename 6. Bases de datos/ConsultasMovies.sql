show databases;
use movies_db;
show tables;

SELECT * FROM movies;

SELECT first_name AS Nombre, last_name AS Apellido, rating AS Rating FROM actors;

SELECT title AS Titulo FROM series;

SELECT first_name AS Nombre, last_name AS Apellido FROM actors WHERE rating > 7.5;

SELECT title AS Titulo, rating AS Rating, awards AS Premios FROM movies WHERE rating > 7.5 AND awards>2;

SELECT title AS Titulo, rating AS Rating FROM movies ORDER BY rating ASC;

SELECT title AS Titulo FROM movies LIMIT 3;

SELECT title AS Titulo FROM movies ORDER BY rating DESC LIMIT 5;

SELECT first_name AS Nombre, last_name AS Apellido FROM actors LIMIT 10;

SELECT title AS Titulo, rating AS Rating FROM movies WHERE title LIKE "Toy Story";

SELECT first_name AS Nombre, last_name AS Apellido FROM actors WHERE first_name LIKE "Sam%";

SELECT title AS Titulo FROM movies WHERE release_date BETWEEN "2004-01-01" AND "2008-01-01";

SELECT title AS Titulo FROM movies WHERE rating>3 AND awards>1 AND release_date BETWEEN "1988-01-01" AND "2009-01-01" ORDER BY rating;