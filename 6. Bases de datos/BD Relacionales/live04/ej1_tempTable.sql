use movies_db;

/*
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” 
y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
*/

CREATE TEMPORARY TABLE TWD (
	season varchar(500),
	episode varchar(500)
);

INSERT INTO TWD 
SELECT sea.title, e.title
FROM episodes e
JOIN seasons sea ON e.season_id = sea.id
JOIN series ser ON ser.id = sea.serie_id
WHERE ser.title = 'The Walking Dead';

/*Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.*/
SELECT * FROM TWD;

/*
Ejercicio 2

* En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
* Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
*/



