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
('87654321', 'Alberto', 'Martínez', '1993-06-20', 'Mendoza'),
('76543219', 'Elena', 'Gómez', '1987-10-25', 'Cordoba'),
('65432198', 'David', 'Fernández', '1990-04-15', 'Santa Fe'),
('54321987', 'Sara', 'García', '1995-08-30', 'CABA'),
('43219876', 'Lucía', 'Pérez', '1982-11-10', 'CABA'),
('32198765', 'Javier', 'Sánchez', '1988-03-28', 'Mendoza'),
('21987654', 'Raquel', 'López', '1981-09-05', 'Jujuy');

INSERT INTO planes_internet (velocidad, precio, descuento) VALUES
(60, 35.0, 8.0),
(120, 50.0, 12.0),
(250, 70.0, 18.0),
(600, 85.0, 22.0),
(1500, 110.0, 28.0);

INSERT INTO cliente_planes_internet (cliente_id, planes_id) VALUES
(1,4),
(1,5),
(4,4),
(3,1),
(5,1),
(5,2);