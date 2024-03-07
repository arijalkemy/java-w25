# Listar los datos de los autores.
SELECT * FROM autor a ;
# Listar nombre y edad de los estudiantes
select e.nombre , e.edad from estudiante e ;
# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre  from estudiante e where e.carrera = 'Ing. Informática';
# ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor a WHERE a.nacionalidad ="Frances" OR a.nacionalidad = "Italiano";
# ¿Qué libros no son del área de internet?
select * from libro l where l.area != "internet";
# Listar los libros de la editorial Salamandra.
SELECT * from libro l WHERE l.editorial = "Salamanca";
# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante e WHERE e.edad  > (select AVG(edad) from estudiante e2);
(select AVG(edad) from estudiante e2);
# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select e.nombre From estudiante e where e.apellido  LIKE "G%";
# Listar los autores del libro “Rayuela". (Se debe listar solamente los nombres).
SELECT a.nombre  FROM autor a 
INNER JOIN libro_autor la on a.id_autor = la.id_autor 
INNER JOIN libro l on la.id_libro = l.id_libro WHERE l.titulo = "Rayuela" ;
# ¿Qué libros se prestaron al lector “Juan 'Pérez”?
SELECT * FROM libro l 
inner join prestamo p ON l.id_libro = p.id_libro 
where p.id_lector  = 
(SELECT id_lector from estudiante e WHERE e.nombre ="Juan" AND e.apellido = "Pérez");
# Listar el nombre del estudiante de menor edad.
select e.nombre from estudiante e order by e.edad Limit 1;
select e.nombre from estudiante e where e.edad  = (SElect MIN(edad) from estudiante e2 );
# Listar nombres de los estudiantes a los que se prestaron libros de Ficcion.

SELECT e.nombre from estudiante e
inner join prestamo p on e.id_lector = p.id_lector 
inner join libro l on p.id_libro = l.id_libro 
where l.area = 'Ficción';
# Listar los libros que pertenecen a la autora Gabriel García Márquez.
SELECT * from libro l inner join libro_autor la 
on l.id_libro  = la.id_libro 
where la.id_autor = (SELECT a.id_autor from autor a where a.nombre = "Gabriel García Márquez" );
# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo  from libro l inner join prestamo p 
on l.id_libro = p.id_libro where p.fecha_devolucion = "2024-03-15";