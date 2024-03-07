-- Creacion base de datos y tablas
DROP DATABASE IF EXISTS libro_prestamo;
CREATE DATABASE libro_prestamo;
USE libro_prestamo;
DROP TABLE IF EXISTS `estudiante`;
CREATE TABLE `estudiante` (
  `idlector` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `carrera` varchar(50) NOT NULL,
  `edad` int NOT NULL,
  PRIMARY KEY (`idlector`)  
);
DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `idlibro` int NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `editorial` varchar(50) NOT NULL,
  `area` varchar(50) NOT NULL,
  PRIMARY KEY (`idlibro`)  
);
DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE `prestamo` (
  `idlector` int NOT NULL,
  `idlibro` int NOT NULL,
  `fecha_prestamo` datetime NOT NULL,
  `fecha_devolucion` datetime NOT NULL,
  `devuelto` int NOT NULL,
  KEY `idlector_idx` (`idlector`),
  KEY `idlibro_idx` (`idlibro`),
  CONSTRAINT `FK_ESTUDIANTE_PRESTAMO` FOREIGN KEY (`idlector`) REFERENCES `estudiante` (`idlector`),
  CONSTRAINT `FK_LIBRO_PRESTAMO` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`)
) ;
DROP TABLE IF EXISTS `autor`;
CREATE TABLE `autor` (
  `idautor` int NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `nacionalidad` varchar(50) NOT NULL,
  PRIMARY KEY (`idautor`)  
);
DROP TABLE IF EXISTS `libroautor`;
CREATE TABLE `libroautor` (
  `idautor` int NOT NULL,
  `idlibro` int NOT NULL,
  KEY `idautor_idx` (`idautor`),
  KEY `idlibro_idx` (`idlibro`),
  CONSTRAINT `FK_AUTOR_LIBROAUTOR` FOREIGN KEY (`idautor`) REFERENCES `autor` (`idautor`),
  CONSTRAINT `FK_LIBRO_LIBROAUTOR` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`)
) ;


-- Ingreso datos
INSERT INTO estudiante (idlector, nombre, apellido, direccion, carrera, edad)
VALUES
    (1, 'Juan', 'Pérez', 'Calle 123', 'Ingeniería', 20),
    (2, 'María', 'González', 'Avenida 456', 'Medicina', 22),
    (3, 'Pedro', 'López', 'Plaza Principal', 'Derecho', 21),
    (4, 'Ana', 'Martínez', 'Calle 789', 'Arquitectura', 19),
    (5, 'Luis', 'Sánchez', 'Calle 321', 'Psicología', 23),
    (6, 'Laura', 'García', 'Calle 555', 'Informática', 20),
    (7, 'Roberto', 'Ferrari', 'Avenida 999', 'Ingeniería', 21),
    (8, 'Giulia', 'Rossi', 'Plaza Central', 'Medicina', 22),
    (9, 'Marco', 'Bianchi', 'Calle 777', 'Informática', 19),
    (10, 'Federico', 'Ricci', 'Calle 333', 'Derecho', 23),
    (11, 'Filippo', 'Galli', 'Calle 123', 'Ingeniería', 25);

INSERT INTO libro (idlibro, titulo, editorial, area)
VALUES
    (1, 'Introducción a la Programación', 'Editorial A', 'Informática'),
    (2, 'Anatomía Humana', 'Editorial B', 'Medicina'),
    (3, 'Historia del Derecho', 'Editorial C', 'Historia'),
    (4, 'Diseño de Edificios Sostenibles', 'Editorial D', 'Arquitectura'),
    (5, 'Psicología del Desarrollo', 'Editorial E', 'Psicología'),
    (6, 'Introducción a las Bases de Datos', 'Editorial X', 'Informática'),
    (7, 'Aprende Python en 30 días', 'Editorial Y', 'Informática'),
    (8, 'Historia del Renacimiento', 'Editorial Z', 'Historia'),
    (9, 'El Universo: Guía de viaje', 'Salamandra', 'Ciencia'),
    (10, 'Harry Potter y la Piedra Filosofal', 'Salamandra', 'Fantasía');

INSERT INTO prestamo (idlector, idlibro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES
    (1, 1, '2021-07-01', '2021-07-16', 1),
    (2, 2, '2021-06-20', '2021-07-16', 0),
    (3, 6, '2021-07-10', '2021-07-16', 0),
    (4, 4, '2022-10-10', '2022-10-25', 1),
    (5, 6, '2023-03-20', '2023-04-04', 1),
    (1, 9, '2023-09-25', '2023-10-10', 1),
    (2, 10, '2023-11-12', '2023-11-27', 1),
    (3, 6, '2024-02-18', '2024-03-04', 0),
    (4, 7, '2024-04-05', '2024-04-20', 1),
    (5, 8, '2024-06-10', '2024-06-25', 1),
    (6, 9, '2024-07-15', '2024-07-30', 0),
    (7, 10, '2024-08-20', '2024-09-04', 0),
    (8, 6, '2024-09-25', '2024-10-10', 1),
    (9, 7, '2024-11-01', '2024-11-16', 1),
    (10, 8, '2024-12-10', '2024-12-25', 1),
    (11, 9, '2024-02-01', '2024-02-16', 1),
    (11, 10, '2023-12-20', '2024-01-04', 1);

INSERT INTO autor (idautor, nombre, nacionalidad)
VALUES
    (1, 'Alberto García', 'Española'),
    (2, 'Carla Fernández', 'Mexicana'),
    (3, 'David López', 'Colombiana'),
    (4, 'Elena Martínez', 'Argentina'),
    (5, 'Francisco Pérez', 'Chilena'),
    (6, 'Sophie Martin', 'Francesa'),
    (7, 'Giovanni Lombardi', 'Italiana'),
    (8, 'Anna Bellini', 'Inglesa'),
    (9, 'Luca Moretti', 'Italiana'),
    (10, 'Elena Ferrari', 'Francesa'),
	(11, 'J.K. Rowling', 'Británica');

INSERT INTO libroautor (idautor, idlibro)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 9),
    (8, 9),
    (9, 9),
    (10, 10),
    (11, 1),
    (11, 2),
    (11, 3);
    
-- Consultas
-- Listar los datos de los autores.
SELECT nombre as Nombre, nacionalidad as Nacionalidad
FROM autor;
-- Listar nombre y edad de los estudiantes
SELECT concat(nombre, " ", apellido) as Nombre, edad as Edad
FROM estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT concat(nombre, " ", apellido) as Nombre, carrera as Carrera
FROM estudiante
WHERE carrera="Informática";
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre as Nombre, nacionalidad as Nacionalidad
FROM autor
WHERE nacionalidad="Francesa" OR nacionalidad="Italiana";
-- ¿Qué libros no son del área de internet?
SELECT titulo as Titulo,  editorial as Editorial, area as Area
FROM libro
WHERE area<>"Informática";
-- Listar los libros de la editorial Salamandra.
SELECT titulo as Titulo,  editorial as Editorial, area as Area
FROM libro
WHERE editorial="Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT concat(nombre, " ", apellido) as Nombre, direccion as Direccion, carrera as Carrera, edad as Edad
FROM estudiante
WHERE edad>(SELECT avg(edad) FROM estudiante);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT concat(nombre, " ", apellido) as Nombre, direccion as Direccion, carrera as Carrera, edad as Edad
FROM estudiante
WHERE apellido LIKE "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre as 	Autor
FROM autor a
INNER JOIN libroautor la ON a.idautor = la.idautor
INNER JOIN libro l ON la.idlibro = l.idlibro
WHERE l.titulo = 'El Universo: Guía de viaje';
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT concat(e.nombre, " ", e.apellido) as Lector,l.titulo as Titulo
FROM libro l 
INNER JOIN prestamo p ON l.idlibro=p.idlibro
INNER JOIN estudiante e ON p.idlector=e.idlector
WHERE e.nombre ="Filippo" AND e.apellido="Galli";
-- Listar el nombre del estudiante de menor edad.
SELECT concat(nombre, " ", apellido) as Nombre, direccion as Direccion, carrera as Carrera, edad as Edad
FROM estudiante
ORDER BY edad ASC LIMIT 1;
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT concat(e.nombre, " ", e.apellido) as Lector,l.titulo as Titulo
FROM estudiante e
INNER JOIN prestamo p ON e.idlector = p.idlector
INNER JOIN libro l ON p.idlibro = l.idlibro
WHERE l.titulo = "Introducción a las Bases de Datos";
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo as Titulo, a.nombre as Autor
FROM libro l
INNER JOIN libroautor la ON l.idlibro = la.idlibro
INNER JOIN autor a ON la.idautor = a.idautor
WHERE a.nombre = 'J.K. Rowling';
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo as Titulo , p.fecha_devolucion as "Fecha Devolucion"
FROM libro l 
INNER JOIN prestamo p ON l.idlibro=p.idlibro
WHERE p.fecha_devolucion="2021-07-16";



