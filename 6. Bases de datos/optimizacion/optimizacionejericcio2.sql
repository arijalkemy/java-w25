use movies_db;
SET SQL_SAFE_UPDATES=0;
#1
insert into  movies values(22,null,null,'avatar 2',8.2,3,'2023-11-11', 300, 1);
#2
insert into genres values (22,null,null, 'Fantasia',46, 1);
#3
update movies set genre_id =22
where movies.id=22;
#4
update actors  set favorite_movie_id = 22
where actors.id = 4;
#$
create temporary table TEMPMOVIE(select * from movies);

select * from tempmovie;
#6
delete from TEMPMOVIE where awards < 5;

select * from tempmovie;
SET SQL_SAFE_UPDATES=1;

#7
select g.name, count(*) total_movie
from genres g 
inner join  movies m
on g.id = m.genre_id
group by g.name
having total_movie >1;

#8
select first_name 
from actors 
where favorite_movie_id in (select id from movies where awards >= 5); 

#9
create index length_index on movies (length) ;

#10
explain select * from movies where length >150;
#Rows iterados 7 con index

#11
drop index length_index on movies;
explain select * from movies where length >150;
#Rows iterados 22 sin index

#12
#Se propone el indice para genero por nombre 
#Debido a que se puede hacer busquedad de la peliculas por el 
#genero para las personas que buscan peliculas del mismo genero



