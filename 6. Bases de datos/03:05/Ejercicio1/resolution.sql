USE movies_db;

SELECT * FROM movies;
SELECT first_name, last_name, rating FROM actors;
SELECT title AS titulo FROM series AS tabla_series;
SELECT first_name, last_name FROM actors WHERE rating > 7.5;
SELECT title, rating, awards FROM movies WHERE rating > 7.5 AND awards > 2;
SELECT title, rating FROM movies ORDER BY rating ASC;
SELECT awards FROM movies LIMIT 3;
SELECT * FROM movies ORDER BY rating DESC LIMIT 5;
SELECT * FROM actors LIMIT 10;
SELECT title, rating FROM movies WHERE title LIKE "%toy story%";
SELECT * FROM actors WHERE first_name LIKE "sam%";
SELECT title FROM movies WHERE release_date >= '2004-01-01 00:00:00' AND release_date <= '2008-12-31 23:59:59';
SELECT title FROM movies WHERE rating > 3 AND awards > 1 AND release_date >= '1988-01-01 00:00:00' AND release_date <= '2009-12-31 23:59:59' ORDER BY rating;