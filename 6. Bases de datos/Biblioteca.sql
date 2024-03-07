DROP DATABASE IF EXISTS biblioteca;

CREATE DATABASE IF NOT EXISTS biblioteca;

USE biblioteca;


CREATE TABLE IF NOT EXISTS autor(
	id_autor int AUTO_INCREMENT,
    nombre varchar(20) NOT NULL,
    nacionalidad varchar(20) NOT NULL,
    
    PRIMARY KEY (id_autor)
);

CREATE TABLE IF NOT EXISTS libro(
	id_libro int AUTO_INCREMENT,
    titulo varchar(60) NOT NULL,
    editorial varchar(20) NOT NULL,
    rubro varchar(20) NOT NULL,
    
    PRIMARY KEY (id_libro)
);

CREATE TABLE IF NOT EXISTS libroautor(
	id_autor int,
    id_libro int,
    
    FOREIGN KEY (id_autor) REFERENCES autor(id_autor),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

CREATE TABLE IF NOT EXISTS estudiante(
	id_lector int AUTO_INCREMENT,
    nombre varchar(20) NOT NULL,
	apellido varchar(20) NOT NULL,
	direccion varchar(40) NOT NULL,
	carrera varchar(20) NOT NULL,
	edad int NOT NULL,
    
    PRIMARY KEY (id_lector)
);

CREATE TABLE IF NOT EXISTS prestamo(
	id_lector int,
    id_libro int,
    fecha_prestamo date NOT NULL,
    fecha_devolucion date NOT NULL,
    devuelto bit NOT NULL,
    
    FOREIGN KEY (id_lector) REFERENCES estudiante(id_lector),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

INSERT INTO autor (id_autor, nombre, nacionalidad) VALUES
(1, "Oliver Berry", "Argentina"),
(2, "J.R.R. Tolkien", "Inglaterra"),
(3, "Frank Herbert", "Italia"),
(4, "Stephen King", "Estados Unidos"),
(5, "J.K. Rowling", "Francia");

INSERT INTO libro (id_libro, titulo, editorial, rubro) VALUES
(1, "Harry Potter", "Oceano", "Terror"),
(2, "La Torre Oscura", "Salamandra", "Internet"),
(3, "Dune", "Salamandra", "Novela"),
(4, "El Señor de los Anillos", "Deuso", "Novela"),
(5, "El Universo: Guía de viaje", "Debate", "Base de Datos");

INSERT INTO estudiante (id_lector, nombre, apellido, direccion, carrera, edad) VALUES
(1, "Raul", "Perez", "Calle 3 123", "Informatica", 30),
(2, "Filippo", "Galli","Avenida 1 500", "Diseño", 25),
(3, "Ruben", "Garcia", "Calle 5 300", "Arquitectura", 33),
(4, "Marcela", "Lagos", "Calle 9 980", "Electronica", 19),
(5, "Sandra", "Santos", "Avenida 9 333", "Psicologia", 35);

INSERT INTO libroautor (id_autor, id_libro) VALUES
(1, 5),
(2, 4),
(3, 3),
(4, 2),
(5, 1);

INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 3, "2019-11-11", "2019-12-01", 1),
(2, 2, "2020-01-10", "2020-03-02", 1),
(3, 3, "2020-06-12", "2021-07-16", 0),
(4, 1, "2022-01-04", "2022-10-16", 1),
(5, 5, "2023-05-06", "2023-06-05", 0);


# ------------------------------------------------------------------------------------------------------------------------------------------

# Listar los datos de los autores.
SELECT * FROM autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido FROM estudiante WHERE carrera = "Informatica";

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad FROM autor WHERE nacionalidad = "Francia" OR nacionalidad = "Italia";

# ¿Qué libros no son del área de internet?
SELECT titulo, rubro FROM libro WHERE rubro != "Internet";

# Listar los libros de la editorial Salamandra.
SELECT titulo, editorial FROM libro WHERE editorial = "Salamandra";

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante WHERE edad > (SELECT AVG(edad) FROM estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM estudiante WHERE apellido LIKE 'G%';

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT nombre FROM autor WHERE id_autor = (
	SELECT id_autor FROM libroautor WHERE id_libro = (
		SELECT id_libro FROM libro WHERE titulo = "El Universo: Guía de viaje"
	)
);

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT titulo FROM libro WHERE id_libro = (
	SELECT id_libro FROM prestamo WHERE id_lector = (
		SELECT id_lector FROM estudiante WHERE nombre = "Filippo" AND apellido = "Galli"
	)
);

# Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido FROM estudiante WHERE edad = (SELECT MIN(edad) FROM estudiante);

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT nombre, apellido FROM estudiante WHERE id_lector = (
	SELECT id_lector FROM prestamo WHERE id_libro = (
		SELECT id_libro FROM libro WHERE rubro = "Base de Datos"
    )
);

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT titulo FROM libro WHERE id_libro = (
	SELECT id_libro FROM libroautor WHERE id_autor = (
		SELECT id_autor FROM autor WHERE nombre = "J.K. Rowling"
	)
);

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo FROM libro WHERE id_libro = (
	SELECT id_libro FROM prestamo WHERE fecha_devolucion = "2021-07-16"
);
