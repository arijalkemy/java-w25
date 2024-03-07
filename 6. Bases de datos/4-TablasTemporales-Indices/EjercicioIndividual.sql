#EJERCICIO 1
# Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE twd (season varchar(40), episode varchar(40));

INSERT INTO twd (SELECT sea.title as titleSeason, e.title as titleEpisode 
From series s 
inner join seasons sea on s.id = sea.serie_id 
inner join episodes e on sea.id = e.season_id 
Where s.id = 3);

# Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * FROM twd where season = 'Primer Temporada';


#EJERCICIO 2
CREATE INDEX index_serie_name ON series (title);
SHOW INDEX FROM series;	
#Cree un indice en la tabla series porque según el contexto es una tabla que tendra bastantes consultas con una alta frecuencia.
#Seleccione como indice la columna title ya que el criterio para elijer el campo es saber que campo posiblemente sera muy usado para 
#filtrar las busquedas y normalmente las personas buscan series por su nombre o una parte de él.