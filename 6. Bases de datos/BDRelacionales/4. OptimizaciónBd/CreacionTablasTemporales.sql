use movies_db;

-- EJERCICIO 1
# 1
CREATE TEMPORARY TABLE TWD (
	SELECT episodes.title as episode_tile, seasons.title as season_title FROM SERIES
	INNER JOIN seasons ON seasons.serie_id = series.id
	INNER JOIN episodes ON episodes.season_id = seasons.id
	WHERE series.title LIKE "%Walking Dead%"
);
# 2
SELECT * FROM TWD WHERE season_title LIKE "Primer Temporada";

-- EJERCICIO 2

# 1
CREATE INDEX number_episode 
ON episodes (number);

SHOW INDEX FROM episodes;
# 2
/*
 Teniendo en cuenta que muchas veces cuando uno esta maratoneando una serie, normalmente una persona busca un episodio por su numero
 mas no por el nombre del episodio, esto ya nos indica que si se llega a usar la tabla de episodio, va a ser para buscar cierto capitulo
 de cierta temporada la cual ya tiene un inidce ne la llave foranea.
 */