#VIVO SQL AVANZADO 1
SELECT * 
FROM autor;

SELECT nombre, edad
FROM estudiante;

SELECT *
FROM estudiante
WHERE carrera = "informatica";

SELECT *
FROM autor
WHERE nacionalidad = "francesa" OR nacionalidad = "italiana";

SELECT *
FROM libro
WHERE area != "internet";

SELECT *
FROM libro
WHERE editorial = "salamandra";

SELECT *
FROM estudiante
WHERE edad > (SELECT AVG(edad) FROM estudiante);

SELECT * 
FROM estudiante
WHERE apellido LIKE("G%");

SELECT au.nombre
FROM autor au
JOIN libroautor la
ON la.idautor = au.idautor
JOIN libro li
ON la.idlibro = li.idlibro
WHERE li.titulo = "El Universo: Guía de viaje";

SELECT li.titulo
FROM libro li
JOIN prestamo p
ON p.idlibro = li.idlibro
JOIN estudiante e
ON e.idlector = p.idlector
WHERE nombre = "filippo" AND apellido = "galli";

SELECT nombre
FROM estudiante
WHERE edad < 18;

SELECT nombre
FROM estudiante e
JOIN prestamo p
ON e.idlector = p.idlector
JOIN libro l
ON p.idlibro = l.idlibro
WHERE l.area LIKE("bases de datos");

SELECT l.titulo
FROM libro l
JOIN libroautor la
ON la.idlibro = l.idlibro
JOIN autor au
ON au.idautor = la.idautor
WHERE au.nombre LIKE("J.K. Rowling");

SELECT l.*
FROM libro l
JOIN prestamo p
ON p.idlibro = l.idlibro
WHERE p.fechadevolucion = "2021-07-16";
