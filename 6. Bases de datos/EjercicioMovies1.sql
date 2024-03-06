select * from movies;

select first_name as "Nombre", last_name as "apellido", rating from actors;

select title as "Titulo" from series;

select first_name as "Nombre", last_name as "apellido", rating from actors where rating >7.5;

select title , rating, awards from movies where rating > 7.5 and awards > 2 order by rating;

select title , rating from movies order by rating;

select title from movies limit 3;

select title , rating from movies order by rating desc limit 5;

select first_name as "Nombre", last_name as "apellido", rating from actors limit 10;

SELECT * FROM actors LIMIT 10;

SELECT title, rating FROM movies WHERE title LIKE '%Toy Story%';

SELECT * FROM actors WHERE first_name LIKE 'SAM%';

SELECT title FROM movies WHERE release_date BETWEEN '2004-01-01' AND '2008-12-31';

SELECT title, rating, release_date FROM movies WHERE rating > 3 AND awards > 1 AND release_date BETWEEN '1988-01-01' AND '2009-12-31' ORDER BY release_date DESC;