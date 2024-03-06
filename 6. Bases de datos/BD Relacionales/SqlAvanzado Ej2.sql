# 1). Listar los datos de los autores.
select * 
from AUTOR;

# 2). Listar nombre y edad de los estudiantes
select nombre, edad 
from ESTUDIANTE;

# 3). ¿Qué estudiantes pertenecen a la carrera informática?
select * 
from ESTUDIANTE 
where carrera = 'Informatica';

# 4). ¿Qué autores son de nacionalidad francesa o italiana?
select * 
from AUTOR 
where nacionalidad = 'Francesa' or nacionalidad = 'Italiana';

# 5). ¿Qué libros no son del área de internet?
select * 
from LIBRO 
where area != 'internet';

# 6). Listar los libros de la editorial Salamandra.
select * 
from LIBRO 
where Editorial = 'Salamandra';

# 7). Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * 
from ESTUDIANTE 
where edad > (select avg(edad) 
			  from ESTUDIANTE);
           
# 8). Listar los nombres de los estudiantes cuyo apellido comience con la letra G.           
select nombre 
from ESTUDIANTE 
where apellido like 'G%';

# 9). Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select nombre 
from AUTOR a 
join LIBROAUTOR la on a.idAutor = la.idAutor 
where idLibro = (select idLibro 
				 from LIBRO 
                 where titulo ='El Universo: Guía de viaje');

# 10). ¿Qué libros se prestaron al lector “Filippo Galli”?
select titulo 
from LIBRO l 
join PRESTAMO p on l.idLibro = p.idLibro 
where p.idLector = (select idLector 
				    from ESTUDIANTE 
                    where nombre ='Filippo' and apellido='Galli');

# 11). Listar el nombre del estudiante de menor edad.
select * 
from ESTUDIANTE 
where edad = (select min(edad) 
			  from ESTUDIANTE);

# 12). Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select nombre 
from ESTUDIANTE e 
join PRESTAMO p on e.idLector = p.idLector 
where p.idLibro in (select idLibro 
					from LIBRO 
                    where area ='Base de Datos');

# 13). Listar los libros que pertenecen a la autora J.K. Rowling.
select titulo 
from LIBRO l 
join LIBROAUTOR la on l.idLibro = la.idLibro 
where la.idAutor = (select idAutor 
					from AUTOR 
                    where nombre = 'J.K. Rowling');

# 14). Listar títulos de los libros que debían devolverse el 16/07/2021.
select titulo 
from LIBRO l 
join PRESTAMO p on l.idLibro = p.idLibro 
where  DATE(FechaDevolucion) = '2021-07-16';



