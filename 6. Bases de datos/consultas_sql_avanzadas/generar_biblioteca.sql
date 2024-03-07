DROP DATABASE IF EXISTS biblioteca;

CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE Autor (
    idAutor INT PRIMARY KEY,
    nombre VARCHAR(50),
    nacionalidad VARCHAR(20)
);

CREATE TABLE Libro (
    idLibro INT PRIMARY KEY,
    titulo VARCHAR(50),
    editorial VARCHAR(20),
    area VARCHAR(20)
);

CREATE TABLE Estudiante (
    idLector INT PRIMARY KEY,
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    direccion VARCHAR(50),
    carrera VARCHAR(20),
    edad INT
);

CREATE TABLE LibroAutor (
    idAutor INT,
    idLibro INT,
    PRIMARY KEY (idAutor, idLibro),
    FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

CREATE TABLE Prestamo (
    idLector INT,
    idLibro INT,
    fecha_prestamo DATETIME,
    fecha_devolucion DATETIME,
    devuelto BIT,
    PRIMARY KEY (idLector, idLibro),
    FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
    FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

#Poblar base
USE biblioteca;

INSERT INTO Autor (idAutor, nombre, nacionalidad) VALUES
(1, 'Gabriel García Márquez', 'Colombiano'),
(2, 'Mario Vargas Llosa', 'Peruano'),
(3, 'Jorge Luis Borges', 'Argentino'),
(4, 'Italo Calvino', 'Italiana'),
(5, 'J.K. Rowling', 'Británica'),
(6, 'Gabriel García Márquez', 'Colombiano');

INSERT INTO Libro (idLibro, titulo, editorial, area) VALUES
(1, 'Cien años de soledad', 'Sudamericana', 'Ficción'),
(2, 'La ciudad y los perros', 'Seix Barral', 'Ficción'),
(3, 'Ficciones', 'Emecé', 'Ficción'),
(4, 'Las ciudades invisibles', 'Seix Barral', 'Ficción'),
(5, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
(6, 'Crónica de una muerte anunciada', 'Sudamericana', 'Ficción');

INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Pérez', 'Calle 123', 'Informática', 20),
(2, 'María', 'González', 'Avenida 456', 'Literatura', 22),
(3, 'Pedro', 'López', 'Plaza 789', 'Historia', 21),
(4, 'Filippo', 'Galli', 'Via Roma 123', 'Informática', 23),
(5, 'Gemma', 'García', 'Calle Principal 456', 'Informática', 20),
(6, 'Guillermo', 'González', 'Avenida Central 789', 'Literatura', 19);

INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6);

INSERT INTO Prestamo (idLector, idLibro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2021-01-10', '2021-01-20', 1),
(2, 3, '2021-02-05', '2021-02-15', 1),
(3, 2, '2021-03-15', '2021-03-25', 0),
(4, 5, '2021-07-01', '2021-07-14', 1),
(5, 6, '2021-07-05', '2021-07-20', 0),
(6, 4, '2021-07-08', '2021-07-16', 1);