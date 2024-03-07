USE movies_db;


# Agregar una película a la tabla movies.
INSERT INTO movies VALUES
(100, null, null, "Nueva pelicula", 4.2, 0, "2024-03-04 00:00:00", 120, 4);



# Agregar un género a la tabla genres.
INSERT INTO genres VALUES
(13, NOW(), NOW(), "Nuevo genero", 13, 1);



# Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies
SET genre_id = 13
WHERE id = 100;



# Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
SET favorite_movie_id = 100
WHERE id = 1;



# Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE movies_temporary
AS SELECT * FROM movies;



# Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM movies_temporary
WHERE awards < 5;



# Obtener la lista de todos los géneros que tengan al menos una película.
SELECT g.name
FROM genres AS g
INNER JOIN movies AS m ON m.genre_id = g.id
GROUP BY g.id;


# Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select a.* from actors a join movies m ON a.favorite_movie_id = m.id 
where m.awards > 3;

# Crear un índice sobre el nombre en la tabla movies.
alter table movies add index (title);


# Chequee que el índice fue creado correctamente.
show index from movies;

# En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
#Si hay una mejora pero hay que saber donde añadir indices, en el caso anterior se añadio un indice por el campo title,
#lo que podria ayudar por ejemplo a realizar busquedas de peliculas por nombre mucho mas rapido 

# En qué otra tabla crearía un índice y por qué? Justificar la respuesta
#Crearia un indice nuevo en la tabla series en la columna title, ya que ,de forma muy similar al caso de movies, muchas veces
#se buscaran series por nombre, y seria ideal optimizar estas consultas.