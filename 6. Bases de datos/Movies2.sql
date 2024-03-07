use movies_db;

-- Agregar una película a la tabla movies.

    INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
    values (null, null, 'Pelicula nueva', 5.6, 4, '2010-12-04 00:00:00', 120, 2);

-- Agregar un género a la tabla genres.


    INSERT INTO genres (created_at, updated_at, name, ranking)
    VALUES (null, null , 'genero nuevo', 13);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.

    UPDATE movies m SET m.genre_id = (select g.id from genres g where g.name = 'genero nuevo')
    WHERE m.title ='Pelicula nueva';

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

    UPDATE actors a SET a.favorite_movie_id =  (select g.id from movies g where g.title = 'Pelicula nueva')
    WHERE a.rating > 9;

-- Crear una tabla temporal copia de la tabla movies.

    CREATE TEMPORARY TABLE moviesTemporal
        select * from movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.

    DELETE FROM moviesTemporal m WHERE m.awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.

    select distinct g.name
    from genres g
    join movies m on g.id = m.genre_id;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

    select *
    from actors a
    join movies m on m.id = a.favorite_movie_id
    where m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.

    ALTER TABLE movies
    ADD UNIQUE INDEX titleMovie_index (title);

-- Chequee que el índice fue creado correctamente.

    SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

    -- Correcto, existiria una mejora notable ya que se realizan varias consultas sobre el titulo de una pelicula
    -- esto facilita la busqueda --> lo que la hace mas performante
    -- facilita el ordenamiento de la misma, ya que puede identificarlas de una forma mas sencilla
    -- Recordemos que sin indice estaria buscando de forma secuencial sobre la tabla hasta coincidir con la busqueda
    -- y en caso de que se encuentre un indice, solo se consulta por la clave del indice para ver su posicion especifica 

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

    -- Crearía otro indice sobre el nombre del actor o sobre el nombre del género
    -- por el mismo motivo anterior.