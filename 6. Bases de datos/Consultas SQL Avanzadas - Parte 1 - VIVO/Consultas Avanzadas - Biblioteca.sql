CREATE DATABASE biblioteca;
USE biblioteca;

CREATE TABLE autor(
	idAutor INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(20),
    nacionalidad VARCHAR(20)
);

CREATE TABLE libro(
	idLibro INT NOT NULL PRIMARY KEY,
    titulo VARCHAR(20),
    editorial VARCHAR(20),
    area VARCHAR(20)
);

CREATE TABLE libroAutor(
	idLibro INT NOT NULL,
    idAutor INT NOT NULL,
    FOREIGN KEY(idLibro) REFERENCES libro(idLibro),
    FOREIGN KEY(idAutor) REFERENCES autor(idAutor)
);


CREATE TABLE estudiante(
	idLector INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    direccion VARCHAR(20),
    carrera VARCHAR(20),
    edad INT
);

CREATE TABLE prestamo(
	idLector INT NOT NULL,
	idLibro INT NOT NULL,
    fechaPrestamo DATETIME,
    fechaDevolucion DATETIME,
    devuelto BOOLEAN,
    FOREIGN KEY(idLector) REFERENCES estudiante(idLector),
    FOREIGN KEY(idLibro) REFERENCES libro(idLibro)
);

INSERT INTO autor (idAutor, nombre, nacionalidad) VALUES
(1, 'Gabriel García M', 'Colombiana'),
(2, 'J.K. Rowling', 'Británica'),
(3, 'Alberto Manguel', 'Argentino'),
(4, 'George Orwell', 'Británica'),
(5, 'Italo Calvino', 'Italiana');

INSERT INTO libro (idLibro, titulo, editorial, area) VALUES
(1, '100 años de soledad', 'Sudamericana', 'Literatura'),
(2, 'Harry Potter 1', 'Salamandra', 'Fantasía'),
(3, 'Historia de lectura', 'Alianza', 'Ensayo'),
(4, '1984', 'Debolsillo', 'Ciencia Ficción'),
(5, 'El barón rampante', 'Siruela', 'Fantasía');

INSERT INTO libroAutor (idLibro, idAutor) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Pérez', 'Calle 123', 'Informática', 22),
(2, 'Ana', 'López', 'Avenida Viva 456', 'Literatura', 19),
(3, 'Carlos', 'González', 'Diagonal 789', 'Filosofía', 25),
(4, 'Lucía', 'Martínez', 'Corredor 101', 'Informática', 23),
(5, 'Pedro', 'Gutiérrez', 'Gran Vía 202', 'Matemáticas', 20);

INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 2, '2023-01-10', '2023-01-24', TRUE),
(2, 1, '2023-02-15', '2023-03-01', FALSE),
(3, 4, '2023-03-20', '2023-04-05', TRUE),
(4, 3, '2023-04-10', '2023-04-25', FALSE),
(5, 5, '2023-05-15', '2023-05-30', TRUE);

# Listar los datos de los autores.
SELECT * FROM autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante WHERE carrera = 'Informática';

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor WHERE nacionalidad IN ('Francesa', 'Italiana');

# ¿Qué libros no son del área de internet?
SELECT * FROM libro WHERE area != 'Internet';

# Listar los libros de la editorial Salamandra.
SELECT * FROM libro WHERE editorial = 'Salamandra';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM estudiante WHERE apellido LIKE 'G%';

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre 
FROM autor a
JOIN libroAutor la ON a.idAutor = la.idAutor
JOIN libro l ON la.idLibro = l.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo 
FROM libro l
JOIN prestamo p ON l.idLibro = p.idLibro
JOIN estudiante e ON p.idLector = e.idLector
WHERE e.nombre = 'Filippo Galli';

# Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante ORDER BY edad ASC LIMIT 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT e.nombre 
FROM estudiante e
JOIN prestamo p ON e.idLector = p.idLector
JOIN libro l ON p.idLibro = l.idLibro
WHERE l.area = 'Base de Datos';

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo
FROM libro l
JOIN libroAutor la ON l.idLibro = la.idLibro
JOIN autor a ON la.idAutor = a.idAutor
WHERE a.nombre = 'J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM libro l
JOIN prestamo p ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = '2021-07-16';


