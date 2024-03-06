# Ejercicio grupal (que terminó siendo individual) de Tabla temporal.
# SQL Consultas Avanadas PArte 2 ej grupal 2

USE movies_db;

DROP TABLE IF EXISTS tabla_temporal;
CREATE TEMPORARY TABLE tabla_temporal (
series VARCHAR(50),
season VARCHAR(50),
episode VARCHAR(50) 
);

SELECT series.title, seasons.title, episodes.title FROM series
INNER JOIN seasons ON seasons.serie_id
INNER JOIN episodes ON episodes.season_id = seasons.id;

INSERT INTO tabla_temporal (
SELECT series.title, seasons.title, episodes.title FROM series
INNER JOIN seasons ON seasons.serie_id
INNER JOIN episodes ON episodes.season_id = seasons.id
);

SELECT * FROM tabla_temporal WHERE series = 'The Walking Dead';