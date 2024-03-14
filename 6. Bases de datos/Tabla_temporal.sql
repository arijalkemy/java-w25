use movies_db;

select * from series s ;

select * from seasons s ;

select * from episodes e;

select * from series s join seasons s2 join episodes e on s.id = s2.serie_id and s2.id = e.season_id where s.id = 3;

drop table TWD;

create temporary table TWD (
serie_title varchar(40),
season_title varchar(40),
episode_title varchar(40)
);

insert into TWD select s.title , s2.title , e.title from series s join seasons s2 join episodes e on s.id = s2.serie_id and s2.id = e.season_id where s.id = 3;

select * from TWD;