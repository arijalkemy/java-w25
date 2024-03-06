select * from AUTOR;#1
select nombre,edad from ESTUDIANTE;#2
select * from ESTUDIANTE where carrera = 'Informatica';#3
select * from AUTOR where nacionalidad = 'Francesa' or nacionalidad = 'Italiana';#4
select * from LIBRO where area != 'internet';#5
select * from LIBRO WHERE Editorial = 'Salamandra';#6
select * from ESTUDIANTE where edad > (select avg(edad) from ESTUDIANTE);#7
select nombre from ESTUDIANTE where apellido like 'G%';#8
select nombre from AUTOR a join LIBROAUTOR la on a.idAutor = la.idAutor 
where idLibro = (select idLibro from LIBRO where titulo ='El Universo: Guía de viaje');#9

select titulo from LIBRO l join PRESTAMO p on l.idLibro = p.idLibro 
where p.idLector = (select idLector from ESTUDIANTE where nombre ='Filippo' and apellido='Galli');#10

select * from ESTUDIANTE where edad = (select min(edad) from ESTUDIANTE);#11

select nombre from ESTUDIANTE e join PRESTAMO p on e.idLector = p.idLector 
where p.idLibro in (select idLibro from LIBRO where area ='Base de Datos');#12

select titulo from LIBRO l join LIBROAUTOR la on l.idLibro = la.idLibro 
where la.idAutor = (select idAutor from AUTOR where nombre = 'J.K. Rowling') ;#13

select titulo from LIBRO l join PRESTAMO p on l.idLibro = p.idLibro where  DATE(FechaDevolucion) = '2021-07-16';#14



