USE biblioteca_db;

# Listar los datos de los autores.
SELECT * 
FROM Autor;

# Listar nombre y edad de los estudiantes
SELECT nombre, edad 
FROM Estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * 
FROM Estudiante 
WHERE carrera LIKE "%informatica%";

# ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * 
FROM Autor 
WHERE nacionalidad IN ("francesa", "italiana");

# ¿Qué libros no son del área de internet?
SELECT * 
FROM Libro 
WHERE area NOT LIKE "%internet%";

# Listar los libros de la editorial Salamandra.
SELECT * 
FROM Libro 
WHERE editorial LIKE "%salamandra%";

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * 
FROM Estudiante 
WHERE edad > (
	SELECT AVG(edad) 
    FROM Estudiante
);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido 
FROM Estudiante 
WHERE apellido LIKE "g%";

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre 
FROM Autor a JOIN LibroAutor la 
ON a.idAutor = la.idAutor 
WHERE la.idLibro = (
	SELECT idLibro 
    FROM Libro 
    WHERE titulo LIKE "%universo%"
);

# ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo 
FROM Libro l JOIN Prestamo p 
ON l.idLibro = p.idLibro 
WHERE p.idLector = (
	SELECT idLector 
    FROM Estudiante
    WHERE nombre = "Filippo" AND apellido = "Galli"
);

# Listar el nombre del estudiante de menor edad.
SELECT nombre 
FROM Estudiante 
WHERE edad = (
	SELECT MIN(edad)
    FROM Estudiante
);

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre 
FROM Estudiante e JOIN Prestamo p
ON e.idLector = p.idLector
WHERE p.idLibro = (
	SELECT idLibro
    FROM Libro
    WHERE titulo LIKE "%bases de datos%"
);

# Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.titulo 
FROM Libro l JOIN LibroAutor la
ON l.idLibro = la.idLibro
WHERE la.idAutor = (
	SELECT idAutor
    FROM Autor
    WHERE nombre = "J.K. Rowling"
);

# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo
FROM Libro l JOIN Prestamo p
ON l.idLibro = p.idLibro
WHERE p.fechaDevolucion = "2021-07-16";