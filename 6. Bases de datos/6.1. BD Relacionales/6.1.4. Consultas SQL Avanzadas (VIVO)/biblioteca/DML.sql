INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (1, 'El Principito', 'Salamandra', 'Literatura');
INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (2, 'Harry Potter y la Piedra Filosofal', 'Salamandra', 'Fantasía');
INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (3, 'El Universo: Guía de viaje', 'Editorial 1', 'Ciencia');
INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (4, 'Introducción a las Bases de Datos', 'Editorial 2', 'Base de Datos');
INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (5, 'Programación en Python', 'Editorial 3', 'Informática');

INSERT INTO Autor (idAutor, nombre, nacionalidad)
VALUES (1, 'Francesco', 'Italiana');
INSERT INTO Autor (idAutor, nombre, nacionalidad)
VALUES (2, 'Gustavo', 'Francesa');
INSERT INTO Autor (idAutor, nombre, nacionalidad)
VALUES (3, 'J.K. Rowling', 'Británica');
INSERT INTO Autor (idAutor, nombre, nacionalidad)
VALUES (4, 'Juan', 'Española');
INSERT INTO Autor (idAutor, nombre, nacionalidad)
VALUES (5, 'María', 'Mexicana');

INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (1, 'Filippo', 'Galli', 'Calle Principal 123', 'Informática', 23);
INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (2, 'Gabriela', 'González', 'Avenida Central 456', 'Informática', 21);
INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (3, 'Giovanni', 'Rossi', 'Via Roma 789', 'Informática', 18);
INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (4, 'Marcela', 'López', 'Calle Sur 1011', 'Ingeniería Civil', 19);
INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (5, 'Juan', 'Pérez', 'Avenida Norte 1213', 'Ingeniería Eléctrica', 20);

INSERT INTO LibroAutor (idAutor, idLibro)
VALUES (1, 1);
INSERT INTO LibroAutor (idAutor, idLibro)
VALUES (3, 2);
INSERT INTO LibroAutor (idAutor, idLibro)
VALUES (4, 3);
INSERT INTO LibroAutor (idAutor, idLibro)
VALUES (1, 4);
INSERT INTO LibroAutor (idAutor, idLibro)
VALUES (5, 5);

INSERT INTO Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (1, 1, '2023-01-01', '2023-01-15', true);
INSERT INTO Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (2, 2, '2023-02-01', '2023-02-15', false);
INSERT INTO Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (1, 3, '2023-03-01', '2023-03-10', true);
INSERT INTO Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (4, 4, '2023-04-01', '2023-04-30', false);
INSERT INTO Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES (5, 5, '2023-05-01', '2023-05-20', true);