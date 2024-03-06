-- Ejercicio 1
/*
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/

CREATE TEMPORARY TABLE TWD (
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR(500),
    episode_num INT,
    release_date DATETIME,
    rating DECIMAL(3,1),
    season VARCHAR(500),
    season_num INT
);

INSERT INTO TWD (id, title, episode_num, release_date, rating, season, season_num)
SELECT ep.id, ep.title, ep.number, ep.release_date, ep.rating, sea.title, sea.number
FROM episodes ep
JOIN seasons sea ON sea.id = ep.season_id
WHERE sea.serie_id IN (
    SELECT id
    FROM series 
    WHERE title LIKE '%The Walking Dead%'
)
ORDER BY sea.number ASC
;

SELECT * FROM TWD;

-- Ejercicio 2
/*
En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
*/

SHOW INDEX FROM episodes;
SHOW INDEX FROM movies;
SHOW INDEX FROM series;

CREATE INDEX movies_date_idx
ON movies(release_date);

CREATE INDEX series_date_idx
ON series(release_date);

CREATE INDEX episodes_date_idx
ON episodes(release_date);
