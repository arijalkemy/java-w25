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
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, ciudad)
VALUES 
('12345678A', 'Juan', 'García', '1990-05-15', 'Madrid'),
('23456789B', 'María', 'López', '1985-09-20', 'Barcelona'),
('34567890C', 'Carlos', 'Martínez', '1988-03-10', 'Sevilla'),
('45678901D', 'Ana', 'Rodríguez', '1992-07-25', 'Valencia'),
('56789012E', 'Pedro', 'Fernández', '1980-12-05', 'Bilbao'),
('67890123F', 'Laura', 'González', '1995-02-18', 'Málaga'),
('78901234G', 'Sergio', 'Sánchez', '1983-11-30', 'Zaragoza');

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
(5,2)




