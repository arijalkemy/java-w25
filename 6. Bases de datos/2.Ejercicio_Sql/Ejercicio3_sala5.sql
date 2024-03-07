DROP DATABASE IF EXISTS empresa_internet;

CREATE DATABASE empresa_internet;

USE empresa_internet;

DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS planes_internet;
DROP TABLE IF EXISTS cliente_planes_internet;

CREATE TABLE cliente ( 
	  `id` INT NOT NULL AUTO_INCREMENT,
      `dni` VARCHAR(20) NOT NULL,
      `nombre` VARCHAR(50),
      `apellido` VARCHAR(50),
      `fecha_nacimiento` DATE,
      `provincia` VARCHAR(50),
      `ciudad` VARCHAR(50),
      PRIMARY KEY (`id`)
);

CREATE TABLE planes_internet(
	`id` INT NOT NULL AUTO_INCREMENT,
    `velocidad` FLOAT,
    `precio` FLOAT,
    `descuento` FLOAT,
    PRIMARY KEY (`id`)
);

CREATE TABLE cliente_planes_internet(
	`cliente_id` INT NOT NULL,
    `planes_id` INT NOT NULL,
    PRIMARY KEY (`cliente_id`, `planes_id`),
    FOREIGN KEY(`cliente_id`) REFERENCES cliente(`id`),
    FOREIGN KEY(`planes_id`) REFERENCES planes_internet(`id`)
);

-- INSERT REGISTROS
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES 
('12345678A', 'Juan', 'Pérez', '1990-05-15', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires'),
('23456789B', 'María', 'González', '1985-10-20', 'Córdoba', 'Cordoba'),
('34567890C', 'Pedro', 'Rodríguez', '1988-03-25', 'Mendoza', 'Mendoza'),
('45678901D', 'Ana', 'López', '1992-07-12', 'Santa Fe', 'Cordoba'),
('56789012E', 'Diego', 'Martínez', '1982-12-08', 'Buenos Aires', 'La Plata'),
('67890123F', 'Laura', 'Fernández', '1995-02-18', 'Buenos Aires', 'Quilmes'),
('78901234G', 'Lucas', 'Sánchez', '1980-09-30', 'Córdoba', 'Villa María'),
('89012345H', 'Carolina', 'Díaz', '1998-06-05', 'Entre Ríos', 'Paraná'),
('90123456I', 'Federico', 'Alvarez', '1987-11-22', 'Salta', 'Salta'),
('01234567J', 'Camila', 'Romero', '1993-04-10', 'Neuquén', 'Neuquén');

INSERT INTO planes_internet (velocidad, precio, descuento) VALUES
(50, 30.0, 5.0),
(100, 45.0, 10.0),
(200, 60.0, 15.0),
(500, 75.0, 20.0),
(1000, 100.0, 25.0);

INSERT INTO cliente_planes_internet (cliente_id, planes_id) VALUES 
(1,4),
(1,5),
(4,4),
(3,1),
(5,1),
(6,2);

-- Consultas
-- Listar los clientes que sean de la ciudad de Madrid o Valencia
SELECT * FROM cliente WHERE ciudad LIKE 'Cordoba' OR ciudad LIKE 'Quilmes';

-- Mostrar los planes con precio mayor a 50
SELECT * FROM planes_internet WHERE precio > 50;

-- Mostrar los nombres de los clientes que nacieron despues del 1990
SELECT * FROM cliente WHERE YEAR(fecha_nacimiento) > 1990;

-- Listar el dni y el nombre de los clientes que el apellido termine con z
SELECT dni, nombre FROM cliente WHERE apellido LIKE '%z';

-- Mostrar la cantidad de clientes que tienen
SELECT COUNT(*) 'Cantidad de clientes' FROM cliente;

-- Mostrar la cantidad de clientes que son de la provincia de Buenos Aires
SELECT COUNT(*) 'Clientes en Buenos Aires' FROM cliente WHERE provincia = 'Buenos Aires';

-- Mostrar la cantidad de planes del cliente 1
SELECT COUNT(*) 'Planes del cliente 1' FROM cliente_planes_internet WHERE cliente_id = 1;

-- Listar los planes con velocidad menor o igual a 200
SELECT * FROM planes_internet WHERE velocidad <= 200;

-- Mostrar el id del plan con mayor descuento
SELECT id FROM planes_internet ORDER BY descuento DESC LIMIT 1;

-- Ordenar los clientes de manera alfabetica descendente por nombre
SELECT * FROM cliente ORDER BY nombre DESC;


