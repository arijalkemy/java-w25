use movies_db;
-- Crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
CREATE TEMPORARY TABLE TWD (
    `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
    serie varchar(500),
    season varchar(500),
    episode_number int NOT NULL,
    release_date datetime NOT NULL,
    rating decimal(3, 1) NOT NULL,
    PRIMARY KEY (`id`)
);

-- Insertar los episodios de "The Walking Dead" en la tabla temporal "TWD"
INSERT INTO TWD (serie, season, episode_number, release_date, rating)
SELECT s.title, ss.title, e.number, e.release_date, e.rating
FROM series s 
INNER JOIN seasons ss ON s.id = ss.serie_id 
INNER JOIN episodes e ON ss.id = e.season_id
WHERE s.title LIKE '%The Walking Dead%';

-- Consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT serie AS Serie, season as Temporada, episode_number as Episodio, release_date as Lanzamiento, rating as Rating
FROM TWD
WHERE season="Primer Temporada";

-- Seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX idx_movies_title ON movies (title);
SHOW INDEX FROM movies;

-- movies: Es una tabla que se consulta con frecuencia y que tiene consultas que podrían beneficiarse de un acceso más rápido a los datos.
-- title: Se utiliza frecuentemente en cláusulas WHERE de consultas SELECT, así como en cláusulas JOIN o GROUP BY.
