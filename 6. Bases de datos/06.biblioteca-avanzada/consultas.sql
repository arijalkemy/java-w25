USE biblioteca_db;

-- Listar los datos de los autores.
select * from autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante
where carrera = 'informática';

-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor
where nacionalidad = 'francesa' or nacionalidad = 'italiana';

-- ¿Qué libros no son del área de internet?
select * from libro
where area != 'internet';

-- Listar los libros de la editorial Salamandra.
select * from libro
where editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante 
where edad > (select avg(edad) from estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre from estudiante
where nombre like 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre from libros l
	inner join libroAutor la on la.idLibro = l.idLibro
    inner join autor a on a.idAutor = la.idAutor
where l.titulo = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.titulo from estudiante e
	inner join prestamo p on p.idLector = e.idLector
    inner join libro l on l.idLibro = p.idLibro
where e.nombre =  'Filippo' and e.apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
select nombre from estudiante
order by edad
limit 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.nombre from prestamo p
	inner join estudiante e on e.idLector = p.idLector
    inner join libro l on l.idLibro = p.idLibro and l.area = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
select l.titulo from libro l 
	inner join libroAutor la on l.idLibro = la.idLibro
    inner join autor a on a.idAutor = la.idAutor and a.nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo from prestamo p
	inner join libro l on p.idLibro = l.idLibro
where p.fechaDevolucion = '2021-07-16';
