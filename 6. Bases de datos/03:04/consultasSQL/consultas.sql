CREATE SCHEMA  IF NOT EXISTS mydb;

USE mydb;

CREATE TABLE IF NOT EXISTS personas (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
edad INT NOT NULL
);

INSERT INTO personas (nombre, apellido, edad) VALUES
('Juan', 'Perez', 30),
('Maria', 'Lopez', 25),
('Pedro', 'Gomez', 45),
('Valeria', 'Torres', 30);

SELECT * FROM mydb.personas;
SELECT nombre AS n FROM mydb.personas;
SELECT nombre AS n FROM mydb.personas WHERE id = 1;

SELECT * FROM mydb.personas ORDER BY edad ASC LIMIT 2;
SELECT * FROM mydb.personas WHERE nombre LIKE "%dr%";
SELECT * FROM mydb.personas WHERE edad BETWEEN 18 AND 30;
SELECT * FROM mydb.personas WHERE edad>18 AND edad<30;

SELECT MAX(edad) FROM mydb.personas;
SELECT COUNT(edad) FROM mydb.personas;
SELECT SUM(edad) FROM mydb.personas;

UPDATE personas SET nombre = "Luna" WHERE id = 1;

DELETE FROM personas WHERE id = 1;