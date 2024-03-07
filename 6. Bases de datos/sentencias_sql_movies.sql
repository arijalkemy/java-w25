show databases;
use movies_db;
show tables;
-- 1
select * from movies;
-- 2
select first_name AS 'Nombre', last_name AS 'Apellido', rating as 'Rating' FROM actors;
-- 3
select title as "Titulo" from series; -- pendiente
-- 4
select first_name AS 'Nombre', last_name AS 'Apellido' FROM actors where rating > 7.5;
-- 5 
select title, rating, awards from movies where rating > 7.5 AND awards > 2;
-- 6
select title, rating from movies order by rating ASC;
-- 7
select * from movies limit 3;
-- 8
select * from movies order by rating DESC limit 5;
-- 9
select * from actors limit 10;
-- 10
select * from movies where title LIKE "Toy story%";
-- 11
select * from actors where first_name LIKE "Sam%";
-- 12
select title from movies where release_date between "2004-01-01" and "2008-12-31";
-- 13
select title, rating from movies where rating > 3 and awards > 1 and release_date between "1988-01-01" and "2009-12-31" order by rating;