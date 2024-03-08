USE movies_db;

/* Ejercicio 1
 * 
 * 1 - Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y 
 * 		guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
 * 
 * 2 - Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
 */


CREATE TEMPORARY TABLE TWD AS (

SELECT e.* 
FROM episodes e 
INNER JOIN seasons s ON e.season_id = s.id 
INNER JOIN series ser ON s.serie_id = ser.id
WHERE ser.title = 'The Walking Dead'

)

SELECT * 
FROM TWD twd
INNER JOIN seasons s ON twd.season_id = s.id 
WHERE s.title = 'Primer Temporada';


/* Ejercicio 2
 * 
 * 1 - En la base de datos “movies”, seleccionar una tabla donde crear un índice y 
 * 		luego chequear la creación del mismo.
 * 
 * 2 - Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
 */

CREATE INDEX movies_title_idx ON movies (title);

EXPLAIN SELECT * FROM movies m WHERE m.title LIKE 'Toy Story%';

/* 
	 Seleccioné el campo title de la tabla movies porque es un campo que no se actualiza, es
		consultado frecuentemente y suele consultarse con 'LIKE' que es muy costoso. 
 */
