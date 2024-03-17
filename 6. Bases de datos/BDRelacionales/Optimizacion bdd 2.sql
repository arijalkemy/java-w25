#VIVO OPTIMIZACION 2

#ejercicio 1 
CREATE TEMPORARY TABLE TWD (SELECT e.id, e.title, e.number, e.release_date, e.rating, sea.number AS sea_number, sea.title as sea_title
FROM episodes e
JOIN seasons sea
ON sea.id = e.season_id
JOIN series ser
ON ser.id = sea.serie_id
WHERE ser.title LIKE("%the walking dead%"));

SELECT *
FROM TWD
WHERE sea_number = 1;

#ejercicio 2
CREATE INDEX fecha_creacion
ON episodes (created_at);

SHOW INDEX FROM episodes;
