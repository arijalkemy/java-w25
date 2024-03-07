#Consultas
#Listar los datos de los autores.
SELECT * FROM autor a ;
#Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad  FROM estudiante e;
#¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante e WHERE carrera = 'informatica';
#¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor a WHERE nacionalidad IN ('Francia','italia');
#¿Qué libros no son del área de internet?
SELECT * FROM libro l WHERE Area != 'internet';
#Listar los libros de la editorial Salamandra.
SELECT * FROM libro l WHERE Editorial  = 'salamandra';
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT e.nombre, e.edad  FROM estudiante e WHERE e.edad > (SELECT AVG(e2.edad) FROM estudiante e2);
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.*  FROM estudiante e WHERE e.apellido LIKE 'G%';
#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autor a 
INNER JOIN libroautor la ON a.idAutor = la.idAutor  
INNER JOIN libro l on la.idLibro  = l.idLibro 
WHERE l.Titulo = 'El Universo: Guía de viaje';
#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT e.nombre , e.apellido, l.Titulo libroPrestado FROM prestamo p 
INNER JOIN estudiante e on p.idLector = e.idLector 
INNER JOIN libro l on l.idLibro = p.idLibro 
WHERE e.nombre = 'Filippo' AND e.apellido = 'galli';
#Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.edad FROM estudiante e 
WHERE e.edad = (SELECT MIN(e.edad) FROM estudiante e);
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select * from estudiante e  
INNER JOIN prestamo p  on e.idLector  = p.idLector  
INNER JOIN libro l on l.idLibro = p.idLibro 
WHERE l.Titulo = 'base de datos';
#Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* FROM libro l 
INNER JOIN libroautor l2 ON l.idLibro = l2.idLibro 
INNER JOIN autor a on a.idAutor = l2.idAutor  
WHERE a.nombre = 'j.k. rowling';
#Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.* FROM libro l 
INNER JOIN prestamo p ON l.idLibro = p.idLibro 
WHERE p.FechaDevolucion = '2021-07-16';