CREATE DATABASE IF NOT EXISTS `libros_db`;
USE `libros_db`;

CREATE TABLE libro (
    idLibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    editorial VARCHAR(100) NOT NULL,
    area VARCHAR(100) NOT NULL
);

CREATE TABLE autor (
    idAutor INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(100) NOT NULL
);

CREATE TABLE libro_autor (
    idLibroAutor INT PRIMARY KEY AUTO_INCREMENT,
    idLibro INT NOT NULL,
    idAutor INT NOT NULL,
    FOREIGN KEY (idLibro) REFERENCES libro (idLibro),
    FOREIGN KEY (idAutor) REFERENCES autor (idAutor)
);

CREATE TABLE estudiante (
    idLector INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    direccion VARCHAR(100) NOT NULL,
    carrera VARCHAR(100) NOT NULL,
    edad INT NOT NULL
);

CREATE TABLE prestamo (
    idPrestamo INT PRIMARY KEY AUTO_INCREMENT,
    idLector INT NOT NULL,
    FOREIGN KEY (idLector) REFERENCES estudiante (idLector),
    idLibro INT NOT NULL,
    FOREIGN KEY (idLibro) REFERENCES libro (idLibro),
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE NOT NULL
);

-- 1. Listar los datos de los autores.
SELECT *
FROM autor;

-- 2. Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad IN ('Francesa', 'Italiana');

-- 5. ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area <> 'Informática';

-- 6. Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
WITH libro_universo AS (
    SELECT idLibro FROM libro WHERE titulo = 'El Universo: Guía de viaje'
), libro_autor_universo AS (
    SELECT idAutor FROM libro_autor WHERE idLibro IN (SELECT idLibro FROM libro_universo)
)
SELECT nombre FROM autor WHERE idAutor IN (SELECT idAutor FROM libro_autor_universo);

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo 
FROM libro l
JOIN prestamo p 
ON l.idLibro = p.idLibro
JOIN estudiante e ON p.idLector = e.idLector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre, edad FROM estudiante ORDER BY edad ASC LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT e.nombre FROM estudiante e
JOIN prestamo p ON e.idLector = p.idLector
JOIN libro l ON p.idLibro = l.idLibro
WHERE l.area = 'Informática';


-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo FROM libro l
JOIN libro_autor la ON l.idLibro = la.idLibro
JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = 'J.K. Rowling';


-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo FROM libro l
JOIN prestamo p ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = '2021-07-16';
