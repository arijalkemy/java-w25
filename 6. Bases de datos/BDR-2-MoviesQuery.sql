show tables;

select * from movies;#1
select first_name,last_name,rating from actors;#2
select title as titulo from series; #3
select first_name,last_name from actors where rating > 7.5;#4
select title,rating,awards from movies where rating > 7.5 and awards > 2; #5
select title,rating from movies order by rating;#6
select title from movies limit 3;#7
select * from movies order by rating desc limit 5;#8
select * from actors limit 10;#9
select title,rating from movies where title like '%Toy Story%';#10
select * from actors where first_name like 'Sam%';#11
select title from movies where release_date between '2004-01-01' and '2008-12-31';#12
select title from movies where awards > 1 and rating > 3 and release_date between '1988-01-01' and '2009-12-31' order by rating;#13


