use movies_db;
-- tablas temporales e indices
-- Ej 1
-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
-- y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD 
SELECT e.id, e.title from episodes e
	inner join seasons s on s.id = e.season_id
    inner join series se on se.id = s.serie_id and se.title like '%The Walking Dead%';

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
select * from TWD;
-- Ej 2
-- En la base de datos “movies”, seleccionar una tabla donde 
-- crear un índice y luego chequear la creación del mismo.
CREATE INDEX nombre_indice ON movies (title);
show index from movies;
-- Analizar por qué crearía un índice en la tabla indicada 

-- y con qué criterio se elige/n el/los campos.
