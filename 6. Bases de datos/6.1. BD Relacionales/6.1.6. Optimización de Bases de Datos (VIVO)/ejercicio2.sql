USE movies_db;

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
ALTER TABLE movies ADD INDEX movies_title (title);
SHOW INDEX FROM movies;

-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

# Crearía un índice en la tabla movies, sobre todo para el campo title, dado que las búsquedas por título pueden 
# ser frecuentes y son más costosas por ser un campo de texto, y más aún al realizar la consulta por medio de 
# análisis de patrones con los símbolos '%' o '_'.