use movies_db;
create temporary table TWD(
	(select e.title, e., rating, numero_temporada from episodes e) 
);
title varchar(45),
	numero int,
	rating decimal(1),
	numero_temporada int
insert into TWD
select * from series s ;

SELECT * FROM seasons s ;
SELECT * FROM episodes e ;