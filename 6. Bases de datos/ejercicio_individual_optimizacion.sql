CREATE TEMPORARY TABLE twd
SELECT  s.title, seas.title as "Season", e.title as "Episode" 
FROM series s
Inner join seasons seas on s.id = seas.serie_id
inner join episodes e on seas.id = e.season_id 
where s.id = 3;


select * from twd
where Season = "Primer Temporada";

#Crearia un Index en la columna first_Name y last_name de la tabla Actors ya que la parte más importante del nombre de un actor es su nombre y se buscará mucho

CREATE INDEX name_idx ON actors(first_name,last_name);
show index from actors;