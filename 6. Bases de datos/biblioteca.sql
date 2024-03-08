#Crear y usar base de datos
CREATE DATABASE IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

#Creación de tablas
CREATE TABLE IF NOT EXISTS autores (
	id_autor VARCHAR(15) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    nacionalidad VARCHAR (30) NOT NULL,
    PRIMARY KEY (id_autor)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS estudiantes(
	id_lector VARCHAR(15) NOT NULL,
    nombre VARCHAR(30) NOT NULL,
    apellido VARCHAR (30) NOT NULL,
    direccion VARCHAR (30) NOT NULL,
    carrera VARCHAR (30) NOT NULL,
    edad INT NOT NULL,
    PRIMARY KEY (id_lector)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS libros (
	id_libro VARCHAR(15) NOT NULL,
    titulo VARCHAR(30) NOT NULL,
    editorial VARCHAR (30) NOT NULL,
    area_escolar VARCHAR (30) NOT NULL,
    PRIMARY KEY (id_libro)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS libro_autor(
	autores_id_autor VARCHAR(15) NOT NULL,
		CONSTRAINT fklibro_id_autor
		FOREIGN KEY (autores_id_autor)
		REFERENCES autores (id_autor),
    libros_id_libro VARCHAR(15) NOT NULL,
		CONSTRAINT fkautor_id_libro
		FOREIGN KEY (libros_id_libro)
		REFERENCES libros (id_libro),
    PRIMARY KEY (autores_id_autor, libros_id_libro)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS prestamos (
	estudiantes_id_lector VARCHAR(15) NOT NULL,
		CONSTRAINT fkprestamo_id_lector
		FOREIGN KEY (estudiantes_id_lector)
		REFERENCES estudiantes (id_lector),
    libros_id_libro VARCHAR(15) NOT NULL,
		CONSTRAINT fkprestamo_id_libro
		FOREIGN KEY (libros_id_libro)
		REFERENCES libros (id_libro),
	fecha_prestamo DATE NOT NULL,
    fecha_devolucion DATE NOT NULL,
    devuelto BOOLEAN NOT NULL,
    PRIMARY KEY (estudiantes_id_lector, libros_id_libro)
)ENGINE=INNODB;
show tables;

#Insercion de datos
INSERT INTO autores (id_autor, nombre, nacionalidad)
VALUES
	('A001','J.K. Rowling','Britanica'),
    ('A002','Mark A Garlick','Britanica'),
    ('A003','Valerie Stimac','Estadounidense'),
    ('A004','Oliver Berry','Britanica'),
    ('A005','Mark Mackenzie','Holandes'),
    ('A006','Mario Mendoza','Colombiana'),
    ('A007','Soazig Aaron','Francesa'),
    ('A008','Dante Alighieri','Italiana'),
    ('A009','Paul Beynon-Davies','Britanica');

INSERT INTO estudiantes (id_lector, nombre, apellido, direccion, carrera, edad)
VALUES
	('LEC01', 'Maria', 'Lopez', '123 Calle Principal', 'Ingeniería', 20),
    ('LEC02', 'Juan', 'Gomez', '456 Calle Sexta', 'Informatica', 22),
    ('LEC03', 'Laura', 'Perez', '789 Calle Terciaria', 'Medicina', 23),
	('LEC04', 'Pedro', 'Martinez', '159 Calle Octava', 'Derecho', 21),
	('LEC05', 'Ana', 'Rodriguez', '357 Calle Quinta', 'Informatica', 17),
	('LEC06', 'Carlos', 'Sanchez', '753 Calle Sexta', 'Economia', 22),
	('LEC07', 'Luis', 'Garcia', '951 Calle Segunda', 'Administracion', 20),
	('LEC08', 'Sara', 'Torres', '753 Calle Octava', 'Informatica', 26),
	('LEC09', 'Fernando', 'Lara', '456 Calle Terciaria', 'Ingeniería', 23),
	('LEC10', 'Filippo', 'Galli', '123 Calle Principal', 'Medicina', 19);

INSERT INTO libros (id_libro, titulo, editorial, area_escolar)
VALUES
	('LIB01', 'El Universo: Guía de viaje', 'GeoPlaneta', 'Astrologia'),
	('LIB02', 'Harry Potter: 1', 'Salamandra', 'Aventura'),
    ('LIB03', 'Harry Potter: 2', 'Salamandra', 'Aventura'),
	('LIB04', 'Satanas', 'Planeta Comics', 'Novela'),
	('LIB05', 'La melancolia de los feos', 'Planeta Comics', 'Ficcion'),
    ('LIB06', 'Le non de Klara', 'Maurice Nadeau', 'Ficcion'),
    ('LIB07', 'La divina comedia', 'Blanco Y Negro', 'Poesia'),
    ('LIB08', 'Sitemas de bases de datos','Reverte','Bases de datos');
    
INSERT INTO libro_autor (autores_id_autor, libros_id_libro)
VALUES
	('A001','LIB02'),
    ('A001','LIB03'),
    ('A002','LIB01'),
    ('A003','LIB01'),
    ('A004','LIB01'),
    ('A005','LIB01'),
    ('A006','LIB04'),
    ('A006','LIB05'),
    ('A007','LIB06'),
    ('A008','LIB07'),
    ('A009','LIB08');
    
INSERT INTO prestamos (estudiantes_id_lector, libros_id_libro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES
	('LEC02','LIB04','2021-05-29','2021-07-16',1),
    ('LEC04','LIB01','2021-06-29','2021-08-02',1),
    ('LEC10','LIB06','2021-05-14','2021-07-03',0),
    ('LEC07','LIB07','2021-05-20','2021-07-16',1),
	('LEC08','LIB08','2021-01-29','2021-02-16',1),
    ('LEC05','LIB03','2021-06-25','2021-07-16',0);

#Consultas SQL
#Listar los datos de los autores.
SELECT nombre, nacionalidad
FROM autores;

#Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM estudiantes;

#¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido
FROM estudiantes
WHERE carrera = 'Informatica';

#¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre
FROM autores
WHERE nacionalidad = 'Francesa' OR nacionalidad = 'Italiana';

#¿Qué libros no son del área de internet?
SELECT titulo, area_escolar
FROM libros
WHERE area_escolar != 'Internet';

#Listar los libros de la editorial Salamandra.
SELECT titulo
FROM libros
WHERE editorial = 'Salamandra';

#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, apellido, carrera, edad
FROM estudiantes
WHERE edad > (
	SELECT AVG(edad)
    FROM estudiantes
    );

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM estudiantes
WHERE apellido LIKE 'G%';

#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre AS 'Autores'
FROM autores a INNER JOIN libro_autor la INNER JOIN libros l
ON a.id_autor = la.autores_id_autor AND l.id_libro = la.libros_id_libro
WHERE l.titulo = 'El Universo: Guía de viaje';

#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo AS 'Libros'
FROM libros l INNER JOIN prestamos p INNER JOIN estudiantes e
ON l.id_libro = p.libros_id_libro AND p.estudiantes_id_lector = e.id_lector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

#Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM estudiantes
WHERE edad = (
	SELECT MIN(edad)
    FROM estudiantes
    );
    
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre AS 'Estudiantes'
FROM libros l INNER JOIN prestamos p INNER JOIN estudiantes e
ON l.id_libro = p.libros_id_libro AND p.estudiantes_id_lector = e.id_lector
WHERE l.area_escolar = 'Bases de datos';

#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo AS 'Libro', l.editorial AS 'Editorial'
FROM autores a INNER JOIN libro_autor la INNER JOIN libros l
ON a.id_autor = la.autores_id_autor AND l.id_libro = la.libros_id_libro
WHERE a.nombre = 'J.K. Rowling';

#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo AS 'Libros'
FROM libros l INNER JOIN prestamos p 
ON l.id_libro = p.libros_id_libro
WHERE p.fecha_devolucion = '2021-07-16';