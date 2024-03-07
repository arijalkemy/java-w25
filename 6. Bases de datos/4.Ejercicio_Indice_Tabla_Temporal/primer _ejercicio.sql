USE movies_db;

-- Crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD
	(
		id int NOT NULL primary key,
        title varchar(500),
        number int
	);

INSERT INTO TWD 
SELECT e.id, e.title, e.number
FROM episodes e
JOIN seasons ss ON ss.id = e.season_id
JOIN series s ON s.id = ss.serie_id
WHERE s.title LIKE 'The Walking Dead';

SELECT * FROM TWD;

-- Seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX movies_idx
ON genres(created_at);

SHOW INDEX FROM genres;
