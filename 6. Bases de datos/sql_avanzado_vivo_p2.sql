# CREACION BASE DE DATOS Y TABLAS BIBLIOTECA:
DROP DATABASE IF EXISTS biblioteca;
CREATE DATABASE biblioteca;
USE biblioteca;

DROP TABLE IF EXISTS `estudiante`;
DROP TABLE IF EXISTS `prestamo`;
DROP TABLE IF EXISTS `libro`;
DROP TABLE IF EXISTS `libroAutor`;
DROP TABLE IF EXISTS `autor`;

CREATE TABLE `estudiante` (
  `idLector` INT NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50),
  `nombre` varchar(50),
  `direccion` varchar(50),
  `carrera` varchar(50),
  `edad` int,
  PRIMARY KEY (`idLector`)
);

CREATE TABLE `autor` (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50),
  `nacionalidad` varchar(50),
  PRIMARY KEY (`idAutor`)
);

CREATE TABLE `libro` (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50),
  `editorial` varchar(50),
  `area` varchar(50),
  PRIMARY KEY (`idLibro`)
);

CREATE TABLE `libroAutor` (
  `idLibro` INT NOT NULL,
  `idAutor` INT NOT NULL,
  PRIMARY KEY (`idLibro`, `idAutor`),
  CONSTRAINT `idLibro_foreign` FOREIGN KEY (`idLibro`) REFERENCES libro(`idLibro`),
  CONSTRAINT `idAutor_foreign` FOREIGN KEY (`idAutor`) REFERENCES autor(`idAutor`)
);

CREATE TABLE `prestamo` (
  `idLibro` INT NOT NULL,
  `idLector` INT NOT NULL,
  `fechaPrestamo` date,
  `fechaDevolucion` date,
  `devuelto` bool,
  PRIMARY KEY (`idLibro`, `idLector`),
  CONSTRAINT `idLibro_prestamo_foreign` FOREIGN KEY (`idLibro`) REFERENCES libro(`idLibro`),
  CONSTRAINT `idLector_prestamo_foreign` FOREIGN KEY (`idLector`) REFERENCES estudiante(`idLector`) 
);

insert into autor(nombre, nacionalidad)
values('J.K. Rowling', 'estadounidense'),
('Antoine de Saint-Exupéry', 'francesa'),
('Edgar Allan Poe', 'estadounidense'),
('Gabriel Garcia Marquez', 'colombiano'),
('Julio Cortazar', 'argentino');

insert into libro(titulo, editorial, area)
values('El principito','Salamandra', 'novela'),
('El corazón delator','Alfaguara', 'poema'),
('Harry Potter I','Ediciones Pepito', 'novela'),
('El gato negro','Salamandra', 'poema'),
('El coronel no tiene quien le escriba', 'Norma', 'novela'),
('Rayuela', 'Sudamericana','novela');

insert into libroAutor(idLibro, idAutor)
values(1,2),
(2,3),
(3,1),
(4,3),
(5,4),
(6,5);

insert into estudiante(nombre, apellido, direccion, carrera, edad)
values('Filippo', 'Galli', 'siempreviva 123','derecho', 25),
('Juan', 'Perez', 'letonia 345','informática', 17),
('Mariana', 'Rodriguez', 'fitz 32','economía', 20),
('Felipa', 'Feg', 'gilbert 98','nutrición', 23),
('Luciana', 'Gop', 'rio vivo 721','informática', 29);

insert into prestamo(idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
values(1, 2, '2023-07-11', '2023-07-16', true),
(1, 3, '2021-07-10', '2021-07-16', false),
(2, 2, '2021-07-10', '2021-07-16', true),
(4, 1, '2021-07-12', '2021-07-16', false),
(5, 3, '2021-03-11', '2021-03-17', true);

# 1. Listar los datos de los autores.
SELECT * FROM autor a ;
# 2. Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad FROM estudiante e;
# 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre, e.apellido, e.edad FROM estudiante e WHERE e.carrera = "informática";
# 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor a WHERE a.nacionalidad = "francesa" OR a.nacionalidad = "italiana";
# 5. ¿Qué libros no son del área de internet?
SELECT * FROM libro l WHERE l.area != "internet";
# 6. Listar los libros de la editorial Salamandra.
SELECT * FROM libro l WHERE l.editorial = "Salamandra";
# 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante e WHERE e.edad > (SELECT AVG(edad) FROM estudiante);
# 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM estudiante e WHERE e.apellido LIKE "G%";
# 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autor a INNER JOIN libroAutor la ON a.idAutor = la.idAutor INNER JOIN libro l ON la.idLibro = l.idLibro WHERE l.titulo = "El Universo: Guía de viaje";
# 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.* FROM libro l INNER JOIN prestamo p ON p.idLibro = l.idLibro INNER JOIN estudiante e ON p.idLector = e.idLector WHERE e.nombre = "Filippo" AND e.apellido = "Galli";
# 11. Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.apellido FROM estudiante e ORDER BY e.edad LIMIT 1;
# 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido FROM estudiante e INNER JOIN prestamo p ON p.idLector = e.idLector INNER JOIN libro l ON l.idLibro = p.idLibro WHERE l.area = "Base de Datos";
# 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* FROM libro l INNER JOIN libroAutor la ON la.idLibro = l.idLibro INNER JOIN autor a ON a.idAutor = la.idAutor WHERE a.nombre = "J.K. Rowling";
# 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.* FROM libro l INNER JOIN prestamo p ON p.idLibro = l.idLibro WHERE p.fechaDevolucion = "2021-07-16"