-- Listar los datos de los autores.
select nombre, nacionalidad from Autor;

-- Listar nombre y edad de los estudiantes
select nombre, edad, carrera from Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera Business?
select nombre, edad, carrera from Estudiante
where carrera='Business';

-- ¿Qué autores son de nacionalidad Indonesa o China?
select nombre, nacionalidad from Autor
where nacionalidad='Indonesia' OR nacionalidad='China';

-- ¿Qué libros no son del área de software?
select titulo, area from Libro
where area!='software';

-- Listar los libros de la editorial Salamandra.
select titulo, editorial from Libro
where editorial='Zoombox';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
select nombre, apellido, carrera, edad from Estudiante
where edad > (
	SELECT avg(edad) from Estudiante
);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido from Estudiante
where apellido LIKE 'M%';

-- Listar los autores del libro “Mrs”. (Se debe listar solamente los nombres).
select a.nombre from Autor as a
inner join Libro_Autor as la ON la.idAutor=a.idAutor
inner join Libro as l ON l.idLibro=la.idLibro
WHERE l.titulo='Mrs';

-- Listar el nombre del estudiante de menor edad.
select nombre from Estudiante
order by edad
limit 1;