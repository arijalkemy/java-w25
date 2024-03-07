use movies_db;

create temporary table TWD 
select e.* from episodes e join seasons s on e.season_id = s.id join series s2 on s2.id = s.serie_id 
where s2.title = "The Walking Dead";

select * from TWD;


alter table series add index (release_date);



show index from series;

#Se eligio la tabla series junto con la columna release_date ya que estos pueden ser datos 
#que se utilizaran para hacer muchas queries diferentes.