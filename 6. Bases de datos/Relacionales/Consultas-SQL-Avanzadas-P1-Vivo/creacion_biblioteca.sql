DROP TABLE IF EXISTS PRESTAMO;
DROP TABLE IF EXISTS LIBROAUTOR;
DROP TABLE IF EXISTS ESTUDIANTE;
DROP TABLE IF EXISTS LIBRO;
DROP TABLE IF EXISTS AUTOR;

CREATE TABLE ESTUDIANTE (
  `idLector` INT NOT NULL AUTO_INCREMENT,
  `apellido` varchar(50),
  `nombre` varchar(50),
  `direccion` varchar(50),
  `carrera` varchar(50),
  `edad` int,
  PRIMARY KEY (`idLector`)
);

CREATE TABLE AUTOR (
  `idAutor` INT NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50),
  `nacionalidad` varchar(50),
  PRIMARY KEY (`idAutor`)
);

CREATE TABLE LIBRO (
  `idLibro` INT NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50),
  `editorial` varchar(50),
  `area` varchar(50),
  PRIMARY KEY (`idLibro`)
);

CREATE TABLE LIBROAUTOR (
  `idLibro` INT NOT NULL,
  `idAutor` INT NOT NULL,
  PRIMARY KEY (`idLibro`, `idAutor`),
  CONSTRAINT `idLibro_foreign` FOREIGN KEY (`idLibro`) REFERENCES libro(`idLibro`),
  CONSTRAINT `idAutor_foreign` FOREIGN KEY (`idAutor`) REFERENCES autor(`idAutor`)
);

CREATE TABLE PRESTAMO (
  `idLibro` INT NOT NULL,
  `idLector` INT NOT NULL,
  `fechaPrestamo` date,
  `fechaDevolucion` date,
  `devuelto` bool,
  PRIMARY KEY (`idLibro`, `idLector`),
  CONSTRAINT `idLibro_prestamo_foreign` FOREIGN KEY (`idLibro`) REFERENCES libro(`idLibro`),
  CONSTRAINT `idLector_prestamo_foreign` FOREIGN KEY (`idLector`) REFERENCES estudiante(`idLector`)
);

insert into AUTOR(nombre, nacionalidad)
values('J.K. Rowling', 'estadounidense'),
('Antoine de Saint-Exupéry', 'francesa'),
('Edgar Allan Poe', 'estadounidense'),
('Dante Alighieri', 'italiana');

insert into LIBRO(titulo, editorial, area)
values('El principito','Salamandra', 'novela'),
('El corazón delator','Alfaguara', 'poema'),
('Harry Potter I','Ediciones Pepito', 'novela'),
('El gato negro','Salamandra', 'poema'),
('SQL Fácil','Salamandra', 'internet'),
('El Universo: Guía de viaje','Ediciones Pepito', 'ficción'),
('Base de Datos','Salamandra', 'internet');

insert into LIBROAUTOR(idLibro, idAutor)
values(1,2),
(2,3),
(3,1),
(4,3),
(6,1),
(6,2);

insert into ESTUDIANTE(nombre, apellido, direccion, carrera, edad)
values('Filippo', 'Galli', 'siempreviva 123','derecho', 25),
('Juan', 'Perez', 'letonia 345','informática', 17),
('Mariana', 'Rodriguez', 'fitz 32','economía', 20),
('Felipa', 'Feg', 'gilbert 98','nutrición', 23),
('Luciana', 'Gop', 'rio vivo 721','informática', 29);

insert into PRESTAMO(idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
values(1, 2, '2023-07-11', '2023-07-16', true),
(1, 3, '2021-07-10', '2021-07-16', false),
(2, 2, '2021-07-10', '2021-07-16', true),
(4, 1, '2021-07-12', '2021-07-16', false),
(2, 7, '2021-03-21', '2021-03-17', false),
(4, 7, '2021-03-22', '2021-03-17', true);