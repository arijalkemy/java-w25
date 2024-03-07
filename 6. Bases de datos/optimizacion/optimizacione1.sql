use movies_db;


create temporary table TWD(
select episodes.* 
from episodes
inner join seasons 
on episodes.season_id = seasons.id
inner join series 
on seasons.serie_id = series.id
where series.title = 'The Walking Dead');

select * from TWD;

ALTER TABLE `movies_db`.`actors` 
ADD INDEX `rating-index` (`rating` ASC) VISIBLE;
;

explain select * from actors
where rating > 6

;
