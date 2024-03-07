# Ejercicio 1
CREATE TEMPORARY TABLE IF NOT EXISTS twd_episodes SELECT e.* FROM episodes e INNER JOIN seasons s ON s.id = e.season_id
INNER JOIN series s2 ON s2.id = s.serie_id where s2.title = "The Walking Dead";

SELECT * FROM twd_episodes;

# Ejercicio 2:
CREATE INDEX movie_title_index ON movies(title);

SELECT * FROM movies m WHERE m.title LIKE "H%";

# Se elige crear el indice en el campo title de la tabla movies debido a que es una tabla que no se espera actualizar con mucha frecuencia
# (suponemos que se agrega un registro cuando sale una nueva pelicula, lo cual no suele ser extremadamente frecuente).
# Tambien por el hecho de que se quiere permitir encontrar peliculas mediante el uso de consultas con clausula LIKE y con Wildcards.
# Se buscaran las peliculas cuyo titulo tenga ciertas coincidencias con el parametro de consulta.