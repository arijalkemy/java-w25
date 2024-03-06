# EJERCICIO 1
# 1). Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
USE movies_db;
DROP TABLE IF EXISTS TheWalkingD;
CREATE TEMPORARY TABLE TheWalkingD AS
    SELECT series.title AS series_title, seasons.title AS season_title
    FROM series
    JOIN seasons ON series.id = seasons.serie_id
    WHERE series.title = 'The Walking Dead';

SELECT * FROM TheWalkingD;

# 2). Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.

SELECT s.title AS 'temporada', e.title AS 'Titulo Episodio'
FROM episodes e
JOIN seasons s ON e.season_id = s.id
JOIN TheWalkingD ON s.title = TheWalkingD.season_title
WHERE s.title = 'Primer Temporada';

# EJERCICIO 2
# 1). En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
# se crea un indici en la columna 'title' de la tabla 'series'
CREATE INDEX index_title ON series(title);
SHOW INDEX FROM series;

# 2). Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
# Esta es una de las tablas principales de la base de datos por lo tanto es muy util para las columnas ya que se utilizan frecuentemente en las consultas.
# el criterio con el que se elije este campo es porque generalmente en las clausulas WHERE y JOIN es un buen candidato para realizar las consultas.





