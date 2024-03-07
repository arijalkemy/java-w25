CREATE DATABASE if not exists `biblioteca` 

USE biblioteca;

CREATE TABLE if not exists `Autor` (
  `id_autor` int NOT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_autor`)
) 

CREATE TABLE IF NOT EXISTS `Estudiante` (
  `id_lector` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `carrera` varchar(50) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`id_lector`)
) 

CREATE TABLE if not exists `Libro` (
  `id_libro` int NOT NULL,
  `titulo` varchar(50) DEFAULT NULL,
  `editorial` varchar(50) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_libro`)
)

CREATE TABLE if not exists `LibroAutor` (
  `id_autor` int DEFAULT NULL,
  `id_libro` int DEFAULT NULL,
  KEY `id_autor` (`id_autor`),
  KEY `id_libro` (`id_libro`),
  CONSTRAINT `libroautor_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `Autor` (`id_autor`),
  CONSTRAINT `libroautor_ibfk_2` FOREIGN KEY (`id_libro`) REFERENCES `Libro` (`id_libro`)
) 

CREATE TABLE if not exists `Prestamo` (
  `id_lector` int DEFAULT NULL,
  `id_libro` int DEFAULT NULL,
  `fecha_prestamo` varchar(50) DEFAULT NULL,
  `fecha_devolucion` varchar(50) DEFAULT NULL,
  `devuelto` tinyint(1) DEFAULT NULL,
  KEY `id_lector` (`id_lector`),
  KEY `id_libro` (`id_libro`),
  CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`id_lector`) REFERENCES `Estudiante` (`id_lector`),
  CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`id_libro`) REFERENCES `Libro` (`id_libro`)
)

INSERT INTO biblioteca.Autor (id_autor,nacionalidad,Nombre) VALUES
	 (1,'Mexican','J.K. Rowling'),
	 (2,'American','Lisa'),
	 (3,'French','Pierre');

	
INSERT INTO biblioteca.Estudiante (id_lector,nombre,apellido,direccion,carrera,edad) VALUES
	 (1,'John','Goe','123 Main St','Engineering',21),
	 (2,'Jane','Smith','456 Elm St','informatica',20),
	 (3,'Filippo','Galli','789 Oak St','informatica',22);

	
INSERT INTO biblioteca.Libro (id_libro,titulo,editorial,area) VALUES
 (1,'El Universo: Guía de viaje','Salamandra','Fiction'),
 (2,'Book2','XYZ','Base de Datos'),
 (3,'Book3','DEF','Base de Datos');


INSERT INTO biblioteca.LibroAutor (id_autor,id_libro) VALUES
	 (1,1),
	 (2,2),
	 (3,3);

INSERT INTO biblioteca.Prestamo (id_lector,id_libro,fecha_prestamo,fecha_devolucion,devuelto) VALUES
	 (1,1,'2020-01-01','2020-01-15',1),
	 (2,2,'2020-02-05','2020-02-20',1),
	 (3,1,'2020-03-10','16-07-2021',0);
