-- Listar los datos de los autores.
SELECT * FROM Autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM Estudiante WHERE carrera = 'Informatica';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM Autor WHERE nacionalidad = 'francesa' OR nacionalidad = 'italiana';

-- ¿Qué libros no son del área de internet?
SELECT * FROM Libro WHERE area <> 'internet';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM Libro WHERE editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * 
FROM Estudiante 
WHERE edad > (
				SELECT AVG(edad) 
				FROM Estudiante
			 );

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM Estudiante WHERE apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM Autor a
JOIN LibroActor la ON la.idLibro = a.idAutor
JOIN Libro l ON l.idLibro = la.idLibro
WHERE titulo LIKE 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.*
FROM Libro l
JOIN Prestamo p ON p.idLibro = l.idLibro
JOIN Estudiante e ON e.idLector = p.idLector
WHERE nombre = 'Filippo' AND apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT nombre 
FROM Estudiante
ORDER BY edad
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre
FROM Libro l
JOIN Prestamo p ON p.idLibro = l.idLibro
JOIN Estudiante e ON e.idLector = p.idLector
WHERE l.area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.*
FROM Autor a
JOIN LibroActor la ON la.idLibro = a.idAutor
JOIN Libro l ON l.idLibro = la.idLibro
WHERE a.nombre LIKE 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM Libro l
JOIN Prestamo p ON p.idLibro = l.idLibro
WHERE p.fechaDevolucion = '2021/07/16'