-- 1. Agregar una película a la tabla movies.
INSERT INTO MOVIES(created_at,updated_at,title,rating,awards,release_date,length,genre_id) VALUES (sysdate(),sysdate(),'MELI PELI',8.1,1,'2025-01-01',234,13);

-- 2.Agregar un género a la tabla genres.
-- 3.Asociar a la película del punto 1. genre el género creado en el punto 2.

INSERT INTO GENRES(created_at,updated_at,name,ranking,active) VALUES(sysdate(),sysdate(),'Tech',13,1);

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET FAVORITE_MOVIE_ID=22 WHERE ID=3;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE MOVIES_COPY 
AS (SELECT * FROM MOVIES);

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SET SQL_SAFE_UPDATES = 0;
DELETE FROM MOVIES_COPY WHERE AWARDS <5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT * FROM MOVIES AS MV, GENRES AS GN WHERE MV.genre_ID=GN.ID;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT concat(ac.first_name,' ',ac.last_name) FROM ACTORS AC, MOVIES MV WHERE AC.favorite_movie_id=mv.id and mv.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
 ALTER TABLE movies ADD INDEX idx_title (title);

-- 10. Chequee que el índice fue creado correctamente.
show index from movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
explain select * from movies where title = "Avatar";
explain select * from movies_copy where title = "Avatar";
/*

Claro que si. A pesar de que actualmente la bd es pequeña, esto es algo que puede llegar a crecer enormemente a medida que se
añadan mas peliculas, series, etc. Y muchas veces las busquedas se realizan a partir de campos que por ahora no tienen indices, por
lo que añadirlos mejoraria el desempeño.
 */
 
 -- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
 /*
 Crearia indices en series, seasons y episodes. Pensando en que tal vez esta bd se use en una pagina como netflix o algo asi,
 una consulta que se haria en muchas ocasiones por muchos clientes seria buscar una serie y sus temporadas y episodios. Y al ser
 una pagina de streaming tendra cientos de miles de registros correspondientes a una consulta de ese tipo.
 */