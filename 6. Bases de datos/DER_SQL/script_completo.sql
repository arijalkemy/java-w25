DROP DATABASE IF EXISTS empresa_internet;

CREATE DATABASE empresa_internet;

USE empresa_internet;

DROP TABLE IF EXISTS Cliente;
DROP TABLE IF EXISTS Plan;

CREATE TABLE Plan (
	`id` INT NOT NULL AUTO_INCREMENT,
	`velocidad` FLOAT,
	`precio` FLOAT,
	`descuento` FLOAT,
	PRIMARY KEY (`id`)
);

CREATE TABLE Cliente (
	`dni` VARCHAR(20) NOT NULL,
	`nombre` VARCHAR(50),
	`apellido` VARCHAR(50),
	`fecha_nacimiento` DATE,
	`plan_id` INT,
	`ciudad_id` INT,
	PRIMARY KEY (`dni`),
	FOREIGN KEY(`ciudad_id`) REFERENCES `Ciudad`(`id`),
	FOREIGN KEY(`plan_id`) REFERENCES `Plan`(`id`)
);

-- INSERT REGISTROS
INSERT INTO Cliente (dni, nombre, apellido, fecha_nacimiento, ciudad)
VALUES 
('12345678A', 'Juan', 'García', '1990-05-15', 'Madrid'),
('23456789B', 'María', 'López', '1985-09-20', 'Barcelona'),
('34567890C', 'Carlos', 'Martínez', '1988-03-10', 'Sevilla'),
('45678901D', 'Ana', 'Rodríguez', '1992-07-25', 'Valencia'),
('56789012E', 'Pedro', 'Fernández', '1980-12-05', 'Bilbao'),
('67890123F', 'Laura', 'González', '1995-02-18', 'Málaga'),
('78901234G', 'Sergio', 'Sánchez', '1983-11-30', 'Zaragoza');

INSERT INTO Plan (velocidad, precio, descuento) VALUES
(50, 30.0, 5.0),
(100, 45.0, 10.0),
(200, 60.0, 15.0),
(500, 75.0, 20.0),
(1000, 100.0, 25.0);