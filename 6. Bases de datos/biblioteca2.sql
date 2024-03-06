/* Consultas SQL Avanzadas - Parte 1 - VIVO Ejercicios Prácticos (Vivo) 💻*/

CREATE DATABASE Biblioteca3;
USE Biblioteca3;

CREATE TABLE LIBRO (
  idLibro INT PRIMARY KEY,
  Titulo VARCHAR(255),
  Editorial VARCHAR(255),
  Area VARCHAR(255)
);

CREATE TABLE AUTOR (
  idAutor INT PRIMARY KEY,
  Nombre VARCHAR(255),
  Nacionalidad VARCHAR(255)
);

CREATE TABLE ESTUDIANTE (
  idLector INT PRIMARY KEY,
  Nombre VARCHAR(255),
  Apellido VARCHAR(255),
  Direccion VARCHAR(255),
  Carrera VARCHAR(255),
  Edad INT
);

CREATE TABLE PRESTAMO (
  idLector INT,
  idLibro INT,
  FechaPrestamo DATE,
  FechaDevolucion DATE,
  Devuelto BOOLEAN,
  FOREIGN KEY (idLector) REFERENCES ESTUDIANTE(idLector),
  FOREIGN Key (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE LIBROAUTOR (
  idAutor INT,
  idLibro INT,
  PRIMARY KEY (idAutor, idLibro),
  FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
  FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

INSERT INTO LIBRO (idLibro, Titulo, Editorial, Area) VALUES
(1, 'El Universo: Guía de viaje', 'Editorial A', 'Astronomía'),
(2, 'Harry Potter y la Piedra Filosofal', 'Salamandra', 'Fantasía'),
(3, 'La Sombra del Viento', 'Editorial B', 'Ficción'),
(4, 'Cien años de soledad', 'Editorial C', 'Ficción'),
(5, 'Introducción a las Bases de Datos', 'Editorial D', 'Base de Datos'),
(6, 'La insoportable levedad del ser', 'Editorial E', 'Ficción'),
(7, 'El Código Da Vinci', 'Editorial F', 'Misterio'),
(8, '1984', 'Editorial G', 'Ciencia ficción'),
(9, 'El nombre del viento', 'Editorial H', 'Fantasía'),
(10, 'Rebelión en la granja', 'Editorial I', 'Política'),
(11, 'Fundamentos de las Bases de Datos', 'Editorial Tecnológica', 'Base de Datos'),
(12, 'Navegación Segura', 'Editorial Web', 'Internet'),
(13, 'El Principito', 'Salamandra', 'Fantasía'),
(14, 'Programación en Python', 'Editorial Tecnológica', 'Informática'),
(15, 'Los Tres Mosqueteros', 'Editorial Clásica', 'Aventuras'),
(16, 'La Divina Comedia', 'Editorial Renacimiento', 'Poesía'),
(17, 'Historia de la Filosofía', 'Editorial Erudita', 'Filosofía'),
(18, 'Cuentos de Edgar Allan Poe', 'Salamandra', 'Terror'),
(19, 'Estructura de datos en Java', 'Editorial Tecnológica', 'Informática'),
(20, 'Protocolos HTTP', 'Salamandra', 'Internet');

INSERT INTO AUTOR (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Stephen Hawking', 'Británica'),
(2, 'J.K. Rowling', 'Británica'),
(3, 'Gabriel García Márquez', 'Colombiana'),
(4, 'Milan Kundera', 'Checa'),
(5, 'Dan Brown', 'Estadounidense'),
(6, 'George Orwell', 'Británica'),
(7, 'John Katzenbach', 'Estadounidense'),
(8, 'Victor Hugo', 'Francesa'),
(9, 'Jules Verne', 'Francesa'),
(10, 'Voltaire', 'Francesa'),
(11, 'Alexandre Dumas', 'Francesa'),
(12, 'Niccolò Machiavelli', 'Italiana'),
(13, 'Dante Alighieri', 'Italiana'),
(14, 'Leonardo da Vinci', 'Italiana'),
(15, 'Amélie Nothomb', 'Belga'),
(16, 'Salman Rushdie', 'Indio-Británica');

INSERT INTO ESTUDIANTE (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'Juan', 'Perez', 'Calle 123', 'Informática', 20),
(2, 'María', 'Lopez', 'Avenida 456', 'Biología', 22),
(3, 'Luis', 'Martinez', 'Carrera 789', 'Informática', 21),
(4, 'Ana', 'González', 'Plaza 1011', 'Medicina', 23),
(5, 'Pedro', 'García', 'Calle 1213', 'Informática', 19),
(6, 'Laura', 'Hernández', 'Avenida 1415', 'Derecho', 24),
(7, 'Sofía', 'Díaz', 'Carrera 1617', 'Química', 20),
(8, 'Carlos', 'Gómez', 'Plaza 1819', 'Historia', 22),
(9, 'Daniel', 'Rodríguez', 'Calle 2021', 'Informática', 20),
(10, 'Lucía', 'Fernández', 'Avenida 2223', 'Arquitectura', 21),
(11, 'Filippo', 'Galli', 'Piazza del Popolo 100, Roma', 'Literatura', 24);

INSERT INTO PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-01-05', '2023-01-15', TRUE),
(2, 2, '2023-02-10', '2023-02-20', FALSE),
(3, 3, '2023-03-15', '2023-03-25', TRUE),
(4, 4, '2023-04-20', '2021-07-16', FALSE),
(5, 5, '2023-05-25', '2023-06-05', TRUE),
(6, 6, '2023-06-30', '2023-07-10', FALSE),
(7, 7, '2023-07-10', '2023-07-20', TRUE),
(8, 8, '2023-08-15', '2023-08-25', FALSE),
(9, 9, '2023-09-20', '2023-09-30', TRUE),
(10, 10, '2023-10-25', '2023-11-04', FALSE),
(11, 11, '2023-11-05', '2023-11-15', TRUE),
(1, 12, '2023-12-10', '2023-12-20', FALSE),
(2, 13, '2024-01-15', '2024-01-25', TRUE),
(3, 14, '2024-02-20', '2024-03-01', FALSE),
(4, 15, '2024-03-25', '2021-07-16', TRUE),
(5, 16, '2024-04-30', '2024-05-10', FALSE),
(6, 17, '2024-06-10', '2024-06-20', TRUE),
(7, 18, '2024-07-15', '2024-07-25', FALSE),
(8, 19, '2024-08-20', '2024-08-30', TRUE),
(9, 20, '2024-09-25', '2024-10-04', FALSE);

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1), /* Stephen Hawking - El Universo: Guía de viaje */
(2, 2), /* J.K. Rowling - Harry Potter y la Piedra Filosofal */
(3, 4), /* Gabriel García Márquez - Cien años de soledad */
(4, 6), /* Milan Kundera - La insoportable levedad del ser */
(5, 7), /* Dan Brown - El Código Da Vinci */
(6, 8), /* George Orwell - 1984 */
(6, 10), /* George Orwell - Rebelión en la granja */
(7, 3), /* John Katzenbach - La Sombra del Viento */
(8, 15), /* Victor Hugo - Los Tres Mosqueteros */
(9, 13), /* Jules Verne - El Principito */
(10, 17),/* Voltaire - Historia de la Filosofía */
(11, 15),/* Alexandre Dumas - Los Tres Mosqueteros */
(12, 5), /* Niccolò Machiavelli - Introducción a las Bases de Datos */
(13, 16),/* Dante Alighieri - La Divina Comedia */
(14, 14),/* Leonardo da Vinci - Programación en Python */
(15, 9), /* Amélie Nothomb - El nombre del viento */
(16, 19);/* Salman Rushdie - Estructura de datos en Java */

/* Listar los datos de los autores */
SELECT * 
FROM AUTOR;

/* Listar nombre y edad de los estudiantes */
SELECT concat(Nombre, ' ', Apellido) 'Nombre', Edad 
FROM ESTUDIANTE;

/* ¿Qué estudiantes pertenecen a la carrera informática? */
SELECT concat(Nombre, ' ', Apellido) 'Nombre', Direccion, Carrera, Edad 
FROM ESTUDIANTE 
WHERE Carrera = 'Informática';

/* ¿Qué autores son de nacionalidad francesa o italiana? */
SELECT Nombre, Nacionalidad
FROM AUTOR 
WHERE Nacionalidad = 'Francesa' OR Nacionalidad = 'Italiana';

/* ¿Qué libros no son del área de internet? */
SELECT Titulo, Area 
FROM LIBRO 
WHERE Area != 'Internet';

/* Listar los libros de la editorial Salamandra */
SELECT Titulo, Editorial
FROM LIBRO 
WHERE Editorial = 'Salamandra';

/* Listar los datos de los estudiantes cuya edad es mayor al promedio */
SELECT concat(Nombre, ' ', Apellido) 'Nombre', Direccion, Carrera, Edad
FROM ESTUDIANTE 
WHERE Edad > (
	SELECT AVG(Edad) 
	FROM ESTUDIANTE
);

/* Listar los nombres de los estudiantes cuyo apellido comience con la letra G */
SELECT concat(Nombre, ' ', Apellido) 'Nombre' 
FROM ESTUDIANTE 
WHERE Apellido 
LIKE 'G%';

/* Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres) */
SELECT au.Nombre 
FROM AUTOR au 
JOIN LIBROAUTOR lib_au ON au.idAutor = lib_au.idAutor
WHERE lib_au.idLibro IN (
	SELECT lib.idLibro 
	FROM LIBRO lib
	WHERE lib.Titulo = 'El Universo: Guía de viaje'
);

/* ¿Qué libros se prestaron al lector “Filippo Galli”? */
SELECT lib.Titulo 
FROM LIBRO lib
JOIN PRESTAMO pres ON lib.idLibro = pres.idLibro
WHERE pres.idLector IN (
	SELECT est.idLector 
	FROM ESTUDIANTE est
	WHERE concat(Nombre, ' ', Apellido) LIKE '%Filippo Galli%'
);

/* Listar el nombre del estudiante de menor edad */
SELECT concat(Nombre, ' ', Apellido) 'Nombre'
FROM ESTUDIANTE 
ORDER BY Edad ASC LIMIT 1;

SELECT concat(Nombre, ' ', Apellido) 'Nombre'
FROM ESTUDIANTE
WHERE Edad = (
	SELECT MIN(Edad)
    FROM ESTUDIANTE
);

/* Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos */
SELECT concat(es.Nombre, ' ', es.Apellido) 'Nombre'
FROM ESTUDIANTE es
JOIN PRESTAMO pre ON es.idLector = pre.idLector
WHERE pre.idLibro IN (
	SELECT lib.idLibro 
	FROM LIBRO lib
	WHERE lib.Area = 'Base de Datos'
);

/* Listar los libros que pertenecen a la autora J.K. Rowling */
SELECT lib.Titulo 
FROM LIBRO lib
JOIN LIBROAUTOR lib_au ON lib.idLibro = lib_au.idLibro
WHERE lib_au.idAutor IN (
	SELECT au.idAutor 
	FROM AUTOR au
	WHERE au.Nombre = 'J.K. Rowling'
);

/* Listar títulos de los libros que debían devolverse el 16/07/2021 */
SELECT lib.Titulo 
FROM LIBRO lib
JOIN PRESTAMO pre ON lib.idLibro = pre.idLibro
WHERE DATE(pre.FechaDevolucion) = '2021-07-16';

