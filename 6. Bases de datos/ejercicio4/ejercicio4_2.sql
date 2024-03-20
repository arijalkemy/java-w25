USE movies_db;

-- EJERCICIO 1

DROP TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD (titulo VARCHAR(80),rating FLOAT);

INSERT INTO TWD SELECT episodes.title, episodes.rating
FROM episodes
JOIN seasons
ON episodes.season_id = seasons.id
JOIN series
ON seasons.serie_id = series.id
WHERE series.title = 'The Walking Dead' AND seasons.number = 1;

-- EJERCICIO 2
SELECT * FROM TWD;
CREATE UNIQUE INDEX name_search ON genres(name);
SHOW INDEX FROM genres;

