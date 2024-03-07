DROP DATABASE IF EXISTS biblioteca;
DROP TABLE IF EXISTS LIBRO;
DROP TABLE IF EXISTS LIBROAUTOR;
DROP TABLE IF EXISTS ESTUDIANTE;
DROP TABLE IF EXISTS AUTOR;

CREATE SCHEMA IF NOT EXISTS biblioteca;
USE biblioteca;

CREATE TABLE LIBRO (
      `idLibro` VARCHAR(45) PRIMARY KEY,
      `Titulo` VARCHAR(45) NOT NULL,
      `Editorial` VARCHAR(45) NOT NULL,
      `Area` VARCHAR(45) NOT NULL
);
CREATE TABLE LIBROAUTOR (
	  `id` VARCHAR(45) PRIMARY KEY,
      `idAutor` VARCHAR(45) NOT NULL,
      FOREIGN KEY(`idAutor`) REFERENCES AUTOR(`idAutor`),
      `idLibro` VARCHAR(45) NOT NULL,
      FOREIGN KEY(`idLibro`) REFERENCES LIBRO(`idLibro`)
);
CREATE TABLE PRESTAMO (
	  `id` VARCHAR(45) PRIMARY KEY,
      `idLector` VARCHAR(20) NOT NULL,
      FOREIGN KEY(`idLector`) REFERENCES ESTUDIANTE(`idLector`),
      `idLibro` VARCHAR(45) NOT NULL,
      FOREIGN KEY(`idLibro`) REFERENCES LIBRO(`idLibro`),
      `FechaPrestamo` DATE NOT NULL,
      `FechaDevolucion` DATE NOT NULL,
      `Devuelto` BOOLEAN NOT NULL
);
CREATE TABLE ESTUDIANTE (
      `idLector` VARCHAR(45) PRIMARY KEY,
      `Nombre` VARCHAR(45) NOT NULL,
      `Apellido` VARCHAR(45) NOT NULL,
      `Direccion` VARCHAR(45) NOT NULL,
      `Carrera` VARCHAR(45) NOT NULL,
      `Edad` INT(3) NOT NULL
);
CREATE TABLE AUTOR (
      `idAutor` VARCHAR(45) PRIMARY KEY,
      `Nombre` VARCHAR(45) NOT NULL,
      `Nacionalidad` VARCHAR(100) NOT NULL
);

-- Insertar datos en la tabla AUTOR
INSERT INTO AUTOR (`idAutor`, `Nombre`, `Nacionalidad`)
VALUES
  ('A1', 'John Smith', 'Estadounidense'),
  ('A2', 'Maria Rodriguez', 'Mexicana'),
  ('A3', 'Ahmed Khan', 'Pakistani'),
  ('A4', 'Anna Müller', 'Alemana'),
  ('A5', 'Carlos García', 'Español');

-- Insertar datos en la tabla LIBRO
INSERT INTO LIBRO (`idLibro`, `Titulo`, `Editorial`, `Area`)
VALUES
  ('L1', 'La Aventura del Conocimiento', 'Editorial ABC', 'Ciencia'),
  ('L2', 'Amor y Despedida', 'Libros Románticos S.A.', 'Romance'),
  ('L3', 'Programación Avanzada en Python', 'Tech Books', 'Informática'),
  ('L4', 'Historia del Arte Moderno', 'Cultural Publishing', 'Arte'),
  ('L5', 'Misterios del Universo', 'Cosmic Press', 'Ciencia Ficción');

-- Insertar datos en la tabla ESTUDIANTE
INSERT INTO ESTUDIANTE (`idLector`, `Nombre`, `Apellido`, `Direccion`, `Carrera`, `Edad`)
VALUES
  ('E1', 'Laura', 'Gómez', 'Calle 123', 'Ingeniería Informática', 22),
  ('E2', 'Juan', 'Pérez', 'Avenida Principal', 'Historia del Arte', 25),
  ('E3', 'Ana', 'Martínez', 'Plaza Central', 'Biología', 20),
  ('E4', 'Carlos', 'Fernández', 'Calle 456', 'Medicina', 23),
  ('E5', 'Luisa', 'Díaz', 'Rincón Tranquilo', 'Psicología', 21);

-- Insertar datos en la tabla LIBROAUTOR
INSERT INTO LIBROAUTOR (`id`, `idAutor`, `idLibro`)
VALUES
  ('LA1', 'A1', 'L1'),
  ('LA2', 'A2', 'L2'),
  ('LA3', 'A3', 'L3'),
  ('LA4', 'A4', 'L4'),
  ('LA5', 'A5', 'L5');

-- Insertar datos en la tabla PRESTAMO
INSERT INTO PRESTAMO (`id`, `idLector`, `idLibro`, `FechaPrestamo`, `FechaDevolucion`, `Devuelto`)
VALUES
  ('P1', 'E1', 'L1', '2024-03-06', '2024-03-20', true),
  ('P2', 'E2', 'L2', '2024-03-08', '2024-03-22', true),
  ('P3', 'E3', 'L3', '2024-03-10', '2024-03-21', false),
  ('P4', 'E4', 'L4', '2024-03-12', '2024-03-31', false),
  ('P5', 'E5', 'L5', '2024-03-14', '2024-04-01', false);



-- 1. Listar los datos de los autores.
SELECT *
FROM AUTOR;

-- 2. Listar nombre y edad de los estudiantes
SELECT Nombre, Edad
FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM ESTUDIANTE
WHERE Carrera LIKE '%Informática%';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM AUTOR
WHERE Nacionalidad IN ('Francesa', 'Italiana');

-- 5.  ¿Qué libros no son del área de internet?
SELECT *
FROM LIBRO
WHERE Area <> 'Internet';

-- 6.  Listar los libros de la editorial Salamandra.
SELECT *
FROM LIBRO
WHERE Editorial = 'Salamandra';


-- 7.  Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM ESTUDIANTE
WHERE Edad > (
	SELECT AVG(Edad)
    FROM ESTUDIANTE
);


-- 8.  Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre
FROM ESTUDIANTE
WHERE Apellido LIKE 'G%';

-- 9.  Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT A.Nombre
FROM LIBROAUTOR LA
JOIN AUTOR A ON LA.idAutor = A.idAutor
JOIN LIBRO L ON L.idLibro = LA.idLibro
WHERE L.Titulo = "El Universo: Guía de viaje";

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT *
FROM LIBRO
WHERE idLibro = (
	SELECT idLibro
	FROM PRESTAMO
	WHERE idLector = (
		SELECT idLector
		FROM ESTUDIANTE
		WHERE Nombre = 'Filippo Galli'
		)
	);

-- 11. Listar el nombre del estudiante de menor edad.
SELECT Nombre
FROM ESTUDIANTE
WHERE Edad = (
	SELECT MIN(Edad)
    FROM ESTUDIANTE
);

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT Nombre
FROM ESTUDIANTE
WHERE idLector = (
	SELECT idLector
	FROM PRESTAMO
	WHERE idLibro = (
		SELECT idLibro
		FROM LIBRO
		WHERE Area = 'Base de Datos'
		)
	);

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT *
FROM LIBRO
WHERE idLibro = (
	SELECT idLibro
	FROM LIBROAUTOR
	WHERE idAutor = (
		SELECT idAutor
		FROM AUTOR 
		WHERE Nombre = 'J.K. Rowling'
	)
);

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT L.Titulo
FROM PRESTAMO P
JOIN LIBRO L ON P.idLibro = L.idLibro
WHERE P.FechaDevolucion = '2021-07-16';