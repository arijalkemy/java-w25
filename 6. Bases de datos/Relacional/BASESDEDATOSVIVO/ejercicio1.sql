-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

USE movies_db;
CREATE TEMPORARY TABLE my_table (
    SELECT t1.title, t2.title AS season
    FROM series AS t1
    INNER JOIN seasons AS t2
    ON t1.id = t2.series_id
    WHERE t1.title = "The Walking Dead"
);

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT *
FROM my_table

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
USE movies_db;
CREATE TEMPORARY TABLE movies_temp (
    SELECT *
    FROM movies
);

CREATE INDEX idx_title ON movies_temp (title);

SHOW INDEX FROM movies_temp;