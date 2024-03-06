use biblioteca;

INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (1, 'El Gran Gatsby', 'Editorial A', 'Novela');

INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (2, 'Cien años de soledad', 'Editorial B', 'Novela');
INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (3, 'Don Quijote de la Mancha', 'Editorial C', 'Novela');
INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (4, 'Introducción a la programación', 'Editorial D', 'Informática');
INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (5, 'Fundamentos de Base de Datos', 'Editorial E', 'Informática');
INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (6, 'Historia del Arte', 'Editorial F', 'Arte');
INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (7, 'El Principito', 'Editorial G', 'Infantil');
INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (8, 'El Señor de los Anillos', 'Editorial H', 'Fantasía');
INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (9, 'Moby Dick', 'Editorial I', 'Aventura');
INSERT INTO libro (id, Titulo, Editorial, Area)
VALUES (10, 'La Odisea', 'Editorial J', 'Clásico');

INSERT INTO libro_autor (idAutor, idLibro)
VALUES (1, 1);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (2, 2);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (3, 3);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (4, 4);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (5, 5);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (6, 6);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (7, 7);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (8, 8);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (9, 9);
INSERT INTO libro_autor (idAutor, idLibro)
VALUES (10, 10);

INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (1, 'F. Scott Fitzgerald', 'Estados Unidos');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (2, 'Gabriel García Márquez', 'Colombia');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (3, 'Miguel de Cervantes', 'España');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (4, 'Autor Desconocido', 'Desconocido');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (5, 'Autor Anónimo', 'Desconocido');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (6, 'Paula Hawkins', 'Reino Unido');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (7, 'Antoine de Saint-Exupéry', 'Francia');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (8, 'J.R.R. Tolkien', 'Reino Unido');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (9, 'Herman Melville', 'Estados Unidos');
INSERT INTO autor (id, Nombre, Nacionalidad)
VALUES (10, 'Homero', 'Grecia');

INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (1, 1, '2021-01-01', '2021-01-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (2, 2, '2021-02-01', '2021-02-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (3, 3, '2021-03-01', '2021-03-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (4, 4, '2021-04-01', '2021-04-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (5, 5, '2021-05-01', '2021-05-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (6, 6, '2021-06-01', '2021-06-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (7, 7, '2021-07-01', '2021-07-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (8, 8, '2021-08-01', '2021-08-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (9, 9, '2021-09-01', '2021-09-10', 1);
INSERT INTO prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto)
VALUES (10, 10, '2021-10-01', '2021-10-10', 1);

INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (1, 'Pedro', 'Gómez', 'Calle 123', 'Informática', 20);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (2, 'Laura', 'Pérez', 'Avenida X', 'Derecho', 22);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (3, 'Carlos', 'Sánchez', 'Carrera Z', 'Medicina', 24);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (4, 'Ana', 'López', 'Calle Y', 'Arquitectura', 21);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (5, 'Javier', 'Torres', 'Avenida ABC', 'Administración', 23);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (6, 'María', 'Ramírez', 'Carrera XYZ', 'Psicología', 25);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (7, 'Andrés', 'García', 'Calle 456', 'Ingeniería', 22);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (8, 'Carolina', 'Martínez', 'Avenida ZYX', 'Ciencias de la Comunicación', 20);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (9, 'Fernando', 'González', 'Carrera 789', 'Economía', 24);
INSERT INTO estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad)
VALUES (10, 'Luisa', 'Ortega', 'Calle W', 'Biología', 23);

#1 Listar los datos de los autores.
SELECT * from autor a;
#2 Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM Estudiante e ;
#3 ¿Qué estudiantes pertenecen a la carrera informática?
SELECT Nombre, Edad, Carrera  FROM Estudiante e WHERE Carrera = 'Informática';
#4 ¿Qué autores son de nacionalidad francesa o italiana?
SELECT Nombre , Nacionalidad  from autor a WHERE Nacionalidad = 'Francia' OR Nacionalidad = "Italia";
#5 ¿Qué libros no son del área de internet?
SELECT * FROM libro l WHERE Area <> "Internet";
#6 Listar los libros de la editorial Salamandra.
SELECT * FROM libro l WHERE Editorial = "Salamandra";
#7 Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT Nombre, Edad  FROM Estudiante e WHERE Edad  > (SELECT AVG(Edad) FROM Estudiante e2);
#8 Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT Nombre, Apellido FROM Estudiante e WHERE Apellido LIKE 'G%';
#9 Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.Nombre FROM autor a JOIN libro_autor la ON la.idAutor = a.id  JOIN libro l ON l.id = la.idLibro WHERE l.Titulo LIKE 'El Universo: Guía de viaje';
#10 ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.Titulo, p.FechaPrestamo, p.FechaDevolucion, p.Devuelto, e.Nombre FROM prestamo p JOIN libro l ON  l.id = p.idLibro JOIN Estudiante e ON p.idLector = e.idLector WHERE e.Nombre = 'Filippo' AND e.Apellido = "Galli";
#11 Listar el nombre del estudiante de menor edad.
SELECT * FROM Estudiante e WHERE Edad = (SELECT MIN(Edad) FROM Estudiante e2);
#12 Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.Nombre, e.Apellido FROM Estudiante e JOIN prestamo p ON p.idLector =  e.idLector JOIN libro l ON l.id =  p.idLibro WHERE l.Area = 'Base de datos';
#13 Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.Titulo, a.Nombre FROM autor a JOIN libro_autor la ON la.idAutor = a.id  JOIN libro l ON l.id = la.idLibro WHERE a.Nombre = 'J. K. Rowling' ;
#14 Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.Titulo FROM libro l JOIN prestamo p  ON l.id = p.idLibro WHERE p.FechaDevolucion = 2021-07-16;











