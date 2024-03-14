use movies_db;

show tables;

select * from movies;

select * from series;

select * from seasons;

select * from episodes;

create temporary table TWD (
	select e.* 
    from episodes e 
    join seasons s on e.season_id = s.id 
    join series se on s.serie_id = se.id 
    where se.title like "The Walking Dead"
);

select twd.* from TWD twd join seasons s on s.id = twd.season_id where s.number = 1;