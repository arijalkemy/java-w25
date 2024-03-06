-- Listar los datos de los autores.
SELECT *FROM Autor a ;
-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera = "Informatica";
-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad = "francesa" or nacionalidad = "italiana";
-- ¿Qué libros no son del área de internet?
select * from libro  where area !="Internet";
-- Listar los libros de la editorial Salamandra.
select * from libro  where editorial ="Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM Estudiante e WHERE edad > (SELECT AVG(edad) from Estudiante e2);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre from Estudiante e WHERE e.apellido LIKE "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT nombre  from Autor a 
inner join LibroAutor la on la.id_autor = a.id_autor  
INNER JOIN  Libro l on l.id_libro = la.id_libro
where l.titulo = "El Universo: Guía de viaje";
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.* From Libro l inner join Prestamo p on p.id_libro =l.id_libro 
INNER JOIN Estudiante e on p.id_lector = e.id_lector 
WHERE e.nombre = "Filippo" and e.apellido = "Galli";
-- Listar el nombre del estudiante de menor edad.
SELECT nombre from Estudiante e WHERE  edad =  (select min(edad) from Estudiante );
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT nombre from Estudiante e inner join Prestamo p on p.id_lector = e.id_lector 
INNER join Libro l on l.id_libro = p.id_libro 
WHERE l.area = "Base de datos";
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* from Libro l inner join LibroAutor la  on la.id_libro = l.id_libro 
INNER JOIN Autor a on la.id_autor = a.id_autor 
WHERE a.nombre = "J.K. Rowling" ;
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo from Libro l inner join Prestamo p on p.id_libro = l.id_libro WHERE p.fecha_devolucion = "2021-07-16";