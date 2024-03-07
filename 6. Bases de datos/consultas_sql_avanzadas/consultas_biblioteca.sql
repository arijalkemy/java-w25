USE biblioteca;

#Listar los datos de los autores.
SELECT *
FROM Autor;

#Listar nombre y edad de los estudiantes
SELECT nombre, edad
FROM Estudiante;

#¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM Estudiante
WHERE carrera = 'Informatica';

#¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM Autor
WHERE nacionalidad IN ('francesa', 'italiana');

#¿Qué libros no son del área de internet?
SELECT *
FROM Libro
WHERE Area != 'Internet';

#Listar los libros de la editorial Salamandra.
SELECT *
FROM Libro
WHERE Editorial = 'Salamandra';

#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM Estudiante
WHERE Edad > (SELECT AVG(Edad) FROM Estudiante);

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM Estudiante
WHERE apellido LIKE 'G%';

#Listar los autores del libro “El Universo: Guía de viaje”. 
#(Se debe listar solamente los nombres).
SELECT a.nombre
FROM Autor a
JOIN LibroAutor la ON a.idAutor = la.idAutor
JOIN Libro l ON la.idLibro = l.idLibro
WHERE l.titulo = 'El Universo: Guía de viaje';


#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.*
FROM Libro l
JOIN Prestamo p ON l.idLibro = p.idLibro
JOIN Estudiante e ON p.idLector = e.idLector
WHERE e.nombre = 'Filippo' AND e.apellido = 'Galli';

#Listar el nombre del estudiante de menor edad.
SELECT nombre
FROM Estudiante
WHERE edad = (SELECT MIN(edad) FROM Estudiante);


#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT DISTINCT e.nombre
FROM Libro l
JOIN Prestamo p ON l.idLibro = p.idLibro
JOIN Estudiante e ON p.idLector = e.idLector;

#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM Autor a
JOIN LibroAutor la ON a.idAutor = la.idAutor
JOIN Libro l ON la.idLibro = l.idLibro
WHERE a.nombre = 'J.K. Rowling';

#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM Libro l
JOIN Prestamo p ON l.idLibro = p.idLibro
WHERE p.fecha_devolucion = '2021-07-16';
