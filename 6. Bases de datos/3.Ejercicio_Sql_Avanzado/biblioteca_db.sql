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

INSERT INTO AUTOR (idAutor, nombre, nacionalidad) VALUES
(1, 'J.R.R. Tolkien', 'Inglaterra'),
(2, 'J.K. Rowling', 'Reino Unido'),
(3, 'Gabriel García Márquez', 'Colombia'),
(4, 'George Orwell', 'Reino Unido'),
(5, 'Jane Austen', 'Reino Unido'),
(6, 'Dan Brown', 'Estados Unidos'),
(7, 'Carlos Ruiz Zafón', 'España'),
(8, 'Paulo Coelho', 'Brasil'),
(9, 'Miguel de Cervantes', 'España'),
(10, 'Gabriel García Márquez', 'Colombia');

CREATE TABLE Estudiante (
      idLector INT NOT NULL PRIMARY KEY,
      nombre VARCHAR(50),
      apellido VARCHAR(50),
      direccion VARCHAR(80),
      carrera VARCHAR(80),
      edad INT
);

INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'Juan', 'Gómez', 'Calle 123, Ciudad', 'Ingeniería Informática', 20),
(2, 'María', 'López', 'Avenida 456, Pueblo', 'Medicina', 22),
(3, 'Carlos', 'Martínez', 'Calle Principal, Villa', 'Derecho', 21),
(4, 'Ana', 'Rodríguez', 'Avenida 789, Aldea', 'Administración de Empresas', 20),
(5, 'Luis', 'Hernández', 'Calle 234, Poblado', 'Arquitectura', 23),
(6, 'Laura', 'García', 'Carrera 567, Ciudadela', 'Psicología', 22),
(7, 'Pedro', 'Pérez', 'Calle Secundaria, Municipio', 'Biología', 21),
(8, 'Sofía', 'Díaz', 'Avenida Principal, Barrio', 'Economía', 20),
(9, 'Alejandro', 'Gutiérrez', 'Carretera 890, Caserío', 'Ingeniería Civil', 23),
(10, 'Carolina', 'Sánchez', 'Calle Mayor, Colonia', 'Historia', 22);

CREATE TABLE LIBROAUTOR (
    idAutor INT primary key,
    idLibro INT primary key,
    FOREIGN KEY (idAutor) REFERENCES AUTOR(idAutor),
    FOREIGN KEY (idLibro) REFERENCES LIBRO(idLibro)
);

INSERT INTO LIBROAUTOR (idAutor, idLibro) VALUES
(1, 1), -- El Señor de los Anillos - J.R.R. Tolkien
(2, 2), -- Harry Potter y la piedra filosofal - J.K. Rowling
(3, 3), -- Cien años de soledad - Gabriel García Márquez
(4, 4), -- 1984 - George Orwell
(5, 5), -- Orgullo y prejuicio - Jane Austen
(6, 6), -- El código Da Vinci - Dan Brown
(7, 7), -- La sombra del viento - Carlos Ruiz Zafón
(8, 8), -- El alquimista - Paulo Coelho
(9, 9), -- Don Quijote de la Mancha - Miguel de Cervantes
(3, 10); -- Crónica de una muerte anunciada - Gabriel García Márquez

CREATE TABLE PRESTAMO (
    fechaPrestamo DATETIME,
    fechaDevolucion DATETIME,
    devuelto BOOLEAN,
    id_lector INT,
    id_libro INT
);

INSERT INTO PRESTAMO (fechaPrestamo, fechaDevolucion, devuelto, id_lector, id_libro) VALUES
('2024-03-01 10:00:00', '2024-03-10 15:00:00', TRUE, 1, 1), -- Juan prestó "El Señor de los Anillos"
('2024-03-02 11:30:00', NULL, FALSE, 2, 2), -- María prestó "Harry Potter y la piedra filosofal"
('2024-03-03 09:45:00', '2024-03-15 17:30:00', TRUE, 3, 3), -- Carlos prestó "Cien años de soledad"
('2024-03-05 14:20:00', NULL, FALSE, 4, 4), -- Ana prestó "1984"
('2024-03-07 16:10:00', '2024-03-20 10:45:00', TRUE, 5, 5), -- Luis prestó "Orgullo y prejuicio"
('2024-03-08 12:00:00', '2024-03-18 14:00:00', TRUE, 6, 6), -- Laura prestó "El código Da Vinci"
('2024-03-09 08:30:00', NULL, FALSE, 7, 7), -- Pedro prestó "La sombra del viento"
('2024-03-11 17:00:00', NULL, FALSE, 8, 8), -- Sofía prestó "El alquimista"
('2024-03-13 09:15:00', '2024-03-25 11:30:00', TRUE, 9, 9), -- Alejandro prestó "Don Quijote de la Mancha"
('2024-03-15 13:45:00', NULL, FALSE, 10, 10); -- Carolina prestó "Crónica de una muerte anunciada"