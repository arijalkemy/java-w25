USE movies_db;

# Crea tabla temporal:
CREATE TEMPORARY TABLE IF NOT EXISTS  TWD (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
temporada INT,
episodio INT,
titulo VARCHAR(255)
);

# Agrega valores a la tabla temporal:
INSERT INTO TWD (temporada, episodio, titulo) VALUES
(1, 1, 'Days Gone Bye'),
(1, 2, 'Guts'),
(1, 3, 'Tell It to the Frogs'),
(1, 4, 'Vatos'),
(2, 1, 'What Lies Ahead'),
(2, 2, 'Bloodletting'),
(2, 3, 'Save the Last One'),
(2, 4, 'Cherokee Rose');

# Consultas a la tabla temporal:
SELECT * FROM TWD;
SELECT * FROM TWD WHERE temporada = 1;

# Antes del indice escanea las 49 filas:
EXPLAIN SELECT * FROM actors WHERE last_name = "Lincoln"; 
# Crea el indice:
CREATE INDEX idx_last_name
ON actors(last_name);
# Al tener el campo last_name indexado, no tiene que escanear las 49 filas:
EXPLAIN SELECT * FROM actors WHERE last_name = "Lincoln";

/*
Se decidió crear un índice en el campo "last_name" de la tabla "actors", ya que creemos que al buscar un actor es más probable que nos 
refieramos a él por su apellido que por su nombre o id.
*/