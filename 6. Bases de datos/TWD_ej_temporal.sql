USE movies_db;

SELECT e.title, se.`number`
FROM series sr
JOIN seasons se ON  se.serie_id = sr.id 
JOIN episodes e ON se.id = e.season_id 
WHERE sr.title = "The Walking Dead";

#1
#Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
#Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
CREATE TEMPORARY TABLE TWD (
SELECT e.title as capNombre, se.`number` as tempNum
FROM series sr
JOIN seasons se ON  se.serie_id = sr.id 
JOIN episodes e ON se.id = e.season_id 
WHERE sr.title = "The Walking Dead");

SELECT * FROM  TWD WHERE tempNum = 1;

#2
#En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
#Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

EXPLAIN SELECT * FROM episodes e WHERE title LIKE "The%"; #busca en 57 filas
CREATE INDEX capName ON episodes (title);
EXPLAIN SELECT * FROM episodes e WHERE title LIKE "The%"; #busca en 13 filas