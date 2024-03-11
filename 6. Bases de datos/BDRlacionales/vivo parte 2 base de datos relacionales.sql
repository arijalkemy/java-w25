show databases;

use movies_db;

select * from movies;

select first_name, last_name, rating from actors;

select title  titulo from series;

select first_name, last_name, rating from actors where rating > 7.5;

select title, rating, awards from movies where awards > 2 and rating > 7.5;

select title, rating from movies order by rating ASC;

select title, rating from movies order by rating DESC limit 5;

select title from movies limit 3;

select concat(last_name, " ", first_name) as nombre from actors limit 10;

select title, rating from movies where title like '%Toy Story%';

select concat(last_name, " ", first_name) as nombre from actors where first_name like '%Sam%';

select title, release_date from movies where release_date between '2004-01-01' and '2008-01-01'  ;

select title, release_date, rating, awards from movies where release_date between '1988-01-01' and '2009-01-01' and awards > 1 and rating > 3 order by rating;









