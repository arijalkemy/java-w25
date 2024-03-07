show databases;

DROP DATABASE IF EXISTS empresa_internet;
DROP TABLE IF EXISTS clientes;
DROP TABLE IF EXISTS planes_internet;
DROP TABLE IF EXISTS clientes_plan;

CREATE SCHEMA IF NOT EXISTS empresa_internet;
USE empresa_internet;
SHOW TABLES;

CREATE TABLE IF NOT EXISTS clientes (
id INT AUTO_INCREMENT PRIMARY KEY,
dni VARCHAR(20) NOT NULL,
nombre VARCHAR(50) NOT NULL,
apellido VARCHAR(50) NOT NULL,
fecha_nacimiento DATE NOT NULL,
provincia VARCHAR(100) NOT NULL,
ciudad VARCHAR(100) NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS planes_internet (
id INT AUTO_INCREMENT PRIMARY KEY,
velocidad_megas INT NOT NULL,
precio DOUBLE(10,2) NOT NULL,
descuento INT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS clientes_plan (
id INT AUTO_INCREMENT PRIMARY KEY,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON UPDATE CASCADE ON DELETE CASCADE,
id_plan_internet INT,
FOREIGN KEY (id_plan_internet) REFERENCES planes_internet(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES
('123456789A', 'Juan', 'Pérez', '1990-01-15', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires'),
('987654321B', 'María', 'Gómez', '1985-05-20', 'Buenos Aires', 'La Plata'),
('567890123C', 'Pedro', 'Martínez', '1995-09-10', 'Córdoba', 'Córdoba'),
('345678901D', 'Laura', 'Fernández', '1980-03-25', 'Santa Fe', 'Rosario'),
('234567890E', 'Miguel', 'López', '1992-07-08', 'Mendoza', 'Mendoza'),
('789012345F', 'Carmen', 'Sánchez', '1988-11-30', 'Misiones', 'Posadas'),
('012345678G', 'Antonio', 'Ramírez', '1998-04-18', 'Salta', 'Salta'),
('456789012H', 'Elena', 'Díaz', '1983-06-12', 'Tucumán', 'San Miguel de Tucumán'),
('890123456I', 'Carlos', 'Hernández', '1993-12-05', 'Chaco', 'Resistencia'),
('678901234J', 'Ana', 'Jiménez', '1987-08-22', 'Entre Ríos', 'Paraná');

INSERT INTO planes_internet (velocidad_megas, precio, descuento) VALUES
(100, 29.99, 5),
(200, 39.99, 10),
(500, 59.99, 15),
(1000, 79.99, 20),
(2000, 99.99, 25);

INSERT INTO clientes_plan (id_cliente, id_plan_internet) VALUES
(1, 1), (2, 3), (3, 5), (4, 1), (5, 5), (6,2), (6,3), (7,4), (8,1), (9,5), (10,1), (10,2);

# Mostrar todos los clientes de la tabla clientes
SELECT * FROM clientes;

# MOSTRAR todos los planes de internet
SELECT * FROM planes_internet;

# Mostrar los planes que tienen contratados los usuarios
SELECT * FROM clientes_plan;

# Mostrar los clientes que nacieron en 1990 o posterior
SELECT *
FROM clientes
WHERE fecha_nacimiento > '1990-01-01';

# Mostrar los planes con precio mayor a 50 dolares
SELECT *
FROM planes_internet
WHERE precio > 50;

# Mostrar los nombres y apellidos de los clientes que son de Buenos Aires
SELECT nombre, apellido
FROM clientes
WHERE provincia = 'Buenos Aires';

# Mostrar los velocidades y los precios de los planes mayores o iguales a 500 mb
SELECT velocidad_megas, precio
FROM planes_internet
WHERE velocidad_megas >= 500;

# Mostrar los clientes que sean de posadas
SELECT *
FROM clientes
WHERE ciudad = 'Posadas';

# Mostrar los clientes que se llaman Juan
SELECT *
FROM clientes
WHERE nombre = 'Juan';

# Mostrar los clientes que hayan nacido antes de 1985
SELECT *
FROM clientes
WHERE fecha_nacimiento < '1985-01-01';








