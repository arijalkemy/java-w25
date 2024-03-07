CREATE DATABASE IF NOT EXISTS biblioteca;

USE biblioteca;

-- CREACION DE TABLAS --

CREATE TABLE autor(
	idAutor 		INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre			VARCHAR(50) NOT NULL,
    nacionalidad	VARCHAR(50) NOT NULL
);

CREATE TABlE libro(
	idLibro		INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    titulo		VARCHAR(50) NOT NULL,
    editorial	VARCHAR(50),
    area		VARCHAR(50)
);

CREATE TABLE libroautor(
	idAutor		INT NOT NULL,
    idLibro		INT NOT NULL,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

CREATE TABLE estudiante(
	idLector 	INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    nombre		VARCHAR(30) NOT NULL,
    apellido	VARCHAR(30) NOT NULL,
    direccion	VARCHAR(50) NOT NULL,
    carrera		VARCHAR(50) NOT NULL,
    edad		INT
);

CREATE TABLE prestamo(
	idLector		INT NOT NULL,
    idLibro			INT NOT NULL,
    fechaPrestamo	DATE,
    fechaDevolucion DATE,
    devuelto		TINYINT(1),
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES libro(idLibro)
);

-- INSERTS A TABLAS --

INSERT INTO autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('J.K. Rowling', 'Británica'),
('Haruki Murakami', 'Japonesa'),
('Isabel Allende', 'Chilena'),
('Khaled Hosseini', 'Afgana');

INSERT INTO libro (titulo, editorial, area) VALUES
('Cien años de soledad', 'Editorial Sudamericana', 'Realismo'),
('Harry Potter y la piedra filosofal', 'Bloomsbury Publishing', 'Fantasía'),
('Tokio blues', 'Random House Mondadori', 'Ficcion'),
('La casa de los espíritus', 'Editorial Sudamericana', 'Literatura'),
('Cometas en el cielo', 'Riverhead Books', 'Ficcion');

INSERT INTO libroautor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('María', 'Gómez', 'Calle 123, Ciudad', 'Medicina', 20),
('Juan', 'Rodríguez', 'Avenida Principal, Ciudad', 'Ingeniería Civil', 21),
('Laura', 'López', 'Calle Principal, Ciudad', 'Arquitectura', 22),
('Carlos', 'Martínez', 'Carrera 456, Ciudad', 'Derecho', 23),
('Ana', 'Hernández', 'Avenida 789, Ciudad', 'Administración de Empresas', 24);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2021-01-05', '2021-01-12', 1),
(2, 2, '2021-02-10', '2021-02-17', 1),
(3, 3, '2021-03-15', '2021-03-22', 0),
(4, 4, '2021-04-20', '2021-04-27', 0),
(5, 5, '2021-05-25', '2021-06-01', 1);

/*
	Atencion: los siguientes ejercicios provenientes de LearningHub fueron alterados para concordar con los datos
    existentes de las tablas.
*/

-- 	Listar los datos de los autores.
SELECT nombre, nacionalidad
FROM autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera de ingenieria?
SELECT nombre, carrera
FROM estudiante
WHERE carrera LIKE "Ingeniería%";

-- ¿Qué autores son de nacionalidad colombiana o britanica?

SELECT nombre, nacionalidad
FROM autor
WHERE nacionalidad IN ('Colombiana', 'Británica');

-- ¿Qué libros no son del área de ficcion?

SELECT titulo, editorial, area
FROM libro
WHERE area != 'Ficcion';

-- Listar los libros de la Editorial Sudamericana.
SELECT titulo, area
FROM libro l
WHERE editorial = 'Editorial Sudamericana';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, edad, carrera
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido
FROM estudiante
WHERE apellido LIKE "G%";

-- Listar los autores del libro “Cometas en el cielo”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM autor a
	INNER JOIN libroautor la
		ON 	la.idAutor = a.idAutor
	INNER JOIN libro l
		ON 	l.idLibro = la.idLibro
        AND	l.titulo = 'Cometas en el cielo';
        
-- ¿Qué libros se prestaron al lector “Juan Rodríguez”?
SELECT l.*
FROM libro l
	INNER JOIN prestamo p
		ON	p.idLibro = l.idLibro
	INNER JOIN estudiante e
		ON	e.idLector = p.idLector
WHERE 	e.nombre = 'Juan'
	AND	e.apellido = 'Rodríguez';
    
-- Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiante
WHERE edad = (SELECT MIN(edad) FROM estudiante);

-- Listar nombres de los estudiantes a los que se prestaron libros de La casa de los espíritus.
SELECT nombre
FROM estudiante e
	INNER JOIN prestamo p
		ON p.idLector = e.idLector
	INNER JOIN libro l
		ON l.idLibro = p.idLibro
WHERE l.titulo = 'La casa de los espíritus';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM libro l
	INNER JOIN libroautor la
		ON la.idLibro = l.idLibro
	INNER JOIN autor a
		ON a.idAutor = la.idAutor
WHERE a.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/03/2021.
SELECT titulo
FROM libro l
	INNER JOIN prestamo p
		ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion < '2021-03-16';
