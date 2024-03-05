use movies_db;

SELECT * FROM movies;
select first_name as Nombre, last_name as Apellido, rating as Rate from actors;
select title as Titulo from series;
select first_name as Nombre, last_name as Apellido from actors where rating >= 7.5;
select title as Titulo, rating as Rating, awards as 'Cant. Premios' from movies where rating >=7.5 and awards >=2;
select title as Titulo, rating as Rating from movies ORDER BY rating;
select title as Titulo from movies LIMIT 3;
select * from movies order by rating DESC;
select * from actors LIMIT 10;
select title as Titulo, rating as Rating from movies WHERE title LIKE '%Toy Story%';
select * from actors where first_name like 'Sam%';
SELECT title as Titulo from movies where year(release_date) >= 2004 and year(release_date) <= 2008;
SELECT title as Titulo from movies where rating >= 3 and awards >1 and year(release_date) >= 1988 and year(release_date) <= 2009 order by rating;