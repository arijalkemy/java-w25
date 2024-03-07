USE movies_db;

CREATE TEMPORARY TABLE TWD
SELECT e.*
FROM episodes e 
JOIN seasons s ON e.season_id = s.id
JOIN series s2 ON s.serie_id = s2.id
WHERE s2.title = 'The Walking Dead'
;

SELECT title 
FROM TWD;

CREATE INDEX series_titlex
ON series (title);

#Alternativa
ALTER TABLE series
ADD INDEX series_titlex (title);

EXPLAIN SELECT *
FROM series
WHERE title = 'The Walking Dead';