use movies_db;

-- EJERCICIO 1:
/*
Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar
	en la misma los episodios de todas las temporadas de “The Walking Dead”.
	Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
*/
CREATE TEMPORARY TABLE TWD (
	id INT NOT NULL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    number INT NOT NULL,
    release_date DATETIME,
    rating DECIMAL(3,1),
    season_id INT
);

INSERT INTO TWD (id, title, number, release_date, rating, season_id)
SELECT id, title, number, release_date, rating, season_id
FROM episodes
WHERE season_id IN (SELECT id 
					FROM seasons
					WHERE serie_id = (	SELECT id 
										FROM series 
                                        WHERE title = 'The Walking Dead'
									)
					);
                    
SELECT * FROM TWD;

-- EJERCICIO 2:
/*
	En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego
    chequear la creación del mismo.
	Analizar por qué crearía un índice en la tabla indicada y con qué criterio se
    elige/n el/los campos.
*/

ALTER TABLE actors
ADD INDEX (first_name, last_name);

SHOW INDEXES FROM actors;

/* Creé el indice en esa tabla y justamente con esos campos porque puede ocurrir frecuentemente
	que uno quiera filtrar los datos de busqueda de un determinado actor por su nombre (o apellido).
*/