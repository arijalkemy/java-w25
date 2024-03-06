drop schema biblioteca_db;
create schema biblioteca_db;

CREATE TABLE LIBRO (
    idLibro INT PRIMARY KEY,
    titulo VARCHAR(50),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

INSERT INTO LIBRO (idLibro, titulo, editorial, area) VALUES
(1, 'El Señor de los Anillos', 'Minotauro', 'Fantasía'),
(2, 'Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
(3, 'Cien años de soledad', 'Diana', 'Ficción'),
(4, '1984', 'Debolsillo', 'Ficción distópica'),
(5, 'Orgullo y prejuicio', 'Penguin Clásicos', 'Ficción'),
(6, 'El código Da Vinci', 'Planeta', 'Misterio'),
(7, 'La sombra del viento', 'Planeta', 'Misterio'),
(8, 'El alquimista', 'HarperCollins Español', 'Ficción'),
(9, 'Don Quijote de la Mancha', 'Espasa-Calpe', 'Clásico'),
(10, 'Crónica de una muerte anunciada', 'Sudamericana', 'Ficción');

CREATE TABLE AUTOR(
    idAutor INT PRIMARY KEY,
    nombre VARCHAR(50),
    nacionalidad VARCHAR(50)
);

CREATE TABLE Estudiante (
      idLector INT NOT NULL PRIMARY KEY,
      nombre VARCHAR(50),
      apellido VARCHAR(50),
      direccion VARCHAR(80),
      carrera VARCHAR(80),
      edad INT
);

CREATE TABLE LIBROAUTOR (
    idAutor INT primary key,
    idLibro INT primary key,
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

CREATE TABLE Estudiante (
    fechaPrestamo DATETIME,
    fechaDevolucion DATETIME,
    devuelto BOOLEAN,
    id_lector INT,
    id_libro INT
);