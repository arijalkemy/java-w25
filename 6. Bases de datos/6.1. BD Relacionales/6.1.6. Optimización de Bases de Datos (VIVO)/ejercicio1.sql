USE movies_db;

CREATE TEMPORARY TABLE TWD (
	SELECT e.id, sn.number AS season, e.number AS episode, e.title AS title, e.release_date, e.rating
	FROM episodes e 
	JOIN seasons sn 
	ON e.season_id = sn.id
	JOIN series s
	ON sn.serie_id = s.id
	WHERE s.title = "The Walking Dead"
);

SELECT * FROM TWD;

SELECT * FROM TWD WHERE season = 1;