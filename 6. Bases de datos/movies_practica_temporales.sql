USE movies_db;
SHOW TABLES;

CREATE TEMPORARY TABLE TWD (
SELECT ser.title AS serie_title, sea.title AS season_title, epi.title AS episode_title, epi.number, epi.rating
FROM seasons sea INNER JOIN series ser INNER JOIN episodes epi
ON sea.id = epi.season_id
WHERE ser.title = "The Walking Dead"
);

#Punto 1
SELECT episode_title, number, rating
FROM TWD
WHERE season_title = 'Primer Temporada';

#Punto 2
CREATE INDEX movies_idx
ON movies (id);
SHOW INDEX FROM movies;



