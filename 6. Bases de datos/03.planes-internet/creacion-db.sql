DROP DATABASE IF EXISTS empresa_internet_db;
CREATE DATABASE empresa_internet_db;
USE empresa_internet_db;

DROP TABLE IF EXISTS `cliente`;
DROP TABLE IF EXISTS `planes_internet`;
DROP TABLE IF EXISTS `cliente_planes_internet`;
CREATE TABLE `cliente` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dni` varchar(20),
  `apellido` varchar(50),
  `nombre` varchar(50),
  `fecha_nacimiento` date,
  `provincia` varchar(50),
  `ciudad` varchar(50),
  PRIMARY KEY (`id`)
);

CREATE TABLE `planes_internet` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `velocidad` float,
  `precio` float,
  `descuento` float,
  PRIMARY KEY (`id`)
);

CREATE TABLE `cliente_planes_internet` (
  `cliente_id` int(10) unsigned NOT NULL,
  `plan_id` int(10) unsigned NOT NULL,
  `precio` float,
  PRIMARY KEY (`cliente_id`, `plan_id`),
  CONSTRAINT `cliente_id_foreign` FOREIGN KEY (`cliente_id`) REFERENCES cliente(`id`),
  CONSTRAINT `plan_id_foreign` FOREIGN KEY (`plan_id`) REFERENCES planes_internet (`id`)
);

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

INSERT INTO cliente_planes_internet (cliente_id, plan_id, precio) VALUES 
(1,4, 30),
(1,5, 20),
(4,4, 10),
(3,1, 50),
(5,1, 30),
(5,2, 24);