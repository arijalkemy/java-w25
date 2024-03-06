INSERT INTO movies_db.movies
(id, created_at, updated_at, title, rating, awards, release_date, `length`, genre_id)
VALUES(22, null,null, 'Scott Pilgrim vs the world', 8.0, 2, '1980-07-04 00:00:00', 130,1);

select * from movies m ;
select *  from genres g ;

INSERT  INTO  genres
(id,name,ranking,active)
values(13,"Cine de arte",13,1);

UPDATE movies m set genre_id=13 where m.id = 22;

select * from actors a;

update actors a set favorite_movie_id = 22 where a.id =3;

create TEMPORARY TABLE movie_copy AS
Select * from movies m;

select * from movie_copy;

delete from movie_copy WHERE awards <5;


select DISTINCT  g.name from movies m
                                 join genres g on m.genre_id  = g.id ;

select a.first_name ,a.last_name ,m.title ,m.awards  from actors a
                                                              join movies m ON  a.favorite_movie_id  = m.id
where m.awards >3;

create index index_name on movies(title);

select * from episodes e ;