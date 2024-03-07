use biblioteca;

#Listar los datos de los autores.
select * from Autor a;
#Listar nombre y edad de los estudiantes
select  e.nombre, e.edad from Estudiante e;
#¿Qué estudiantes pertenecen a la carrera informática?
select e.* from Estudiante e 
WHERE carrera = 'informatica';
#¿Qué autores son de nacionalidad francesa o italiana?
select a.* from Autor a 
where nacionalidad = 'French' OR nacionalidad ="Italian";
#¿Qué libros no son del área de internet?
select l.* from Libro l 
where l.area !="internet";
#Listar los libros de la editorial Salamandra.
select l.* from Libro l 
WHERE editorial ='Salamandra';
#Listar los datos de los estudiantes cuya edad es mayor al promedio.
select e.* from Estudiante e 
where e.edad > (SELECT AVG(edad) from Estudiante e2);
#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.nombre, e.apellido  from Estudiante e 
where apellido LIKE "G%";
#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre from Autor a join LibroAutor la on a.id_autor = la.id_autor join Libro l on l.id_libro = la.id_libro 
where l.titulo = "El Universo: Guía de viaje";
#¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.* from Libro l join Prestamo p on l.id_libro = p.id_libro join Estudiante e on e.id_lector = p.id_lector 
where e.nombre = "Filippo" and e.apellido = "Galli";
#Listar el nombre del estudiante de menor edad.
select e.nombre from Estudiante e 
where e.edad = (SELECT MIN(edad) from Estudiante e2);
#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.nombre from Estudiante e join Prestamo p on p.id_lector = e.id_lector join Libro l on l.id_libro = p.id_libro 
where l.area = 'Base de Datos';
#Listar los libros que pertenecen a la autora J.K. Rowling.
select l.* from Autor a join LibroAutor la on a.id_autor = la.id_autor join Libro l on l.id_libro = la.id_libro 
where a.Nombre = "J.K. Rowling";
#Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo from Libro l join Prestamo p on p.id_libro = l.id_libro 
where p.fecha_devolucion = "16-07-2021";
