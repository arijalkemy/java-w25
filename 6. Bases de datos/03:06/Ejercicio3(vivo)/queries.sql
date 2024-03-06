# 1.-
SELECT * FROM autores;

# 2.-
SELECT nombre, edad
FROM estudiantes;

# 3.-
SELECT nombre, edad
FROM estudiantes
WHERE carrera = "Informatica";

# 4.-
SELECT *
FROM autores
WHERE nacionalidad = "Francesa" OR nacionalidad = "Italiana";

# 5.-
SELECT *
FROM libros
WHERE area != "Internet";

# 6.-
SELECT *
FROM libros
WHERE editorial = "Salamandra";

# 7.-
SELECT * 
FROM estudiantes 
WHERE edad > (SELECT AVG(edad) FROM estudiantes);

# 8.-
SELECT * 
FROM estudiantes 
WHERE nombre LIKE "G%";

# 9.-
SELECT a.nombre
FROM autores AS a 
INNER JOIN libros AS l
INNER JOIN libros_autores AS la ON la.id_libro = l.id AND la.id_autor = a.id
WHERE l.titulo = "El Universo: Guía de viaje";

# 10.-
SELECT l.titulo
FROM estudiantes AS e
INNER JOIN libros AS l
INNER JOIN prestamos AS p ON p.id_libro = l.id AND p.id_estudiante = e.id
WHERE CONCAT(e.nombre, " ", e.apellido) = "Laura Gomez";

# 11.-
SELECT nombre
FROM estudiantes 
WHERE edad = (SELECT MIN(edad) FROM estudiantes);

# 12.-
SELECT e.nombre
FROM estudiantes AS e
INNER JOIN libros AS l
INNER JOIN prestamos AS p ON p.id_libro = l.id AND p.id_estudiante = e.id
WHERE l.area = "base de datos";

# 13.-
SELECT l.titulo
FROM autores AS a 
INNER JOIN libros AS l
INNER JOIN libros_autores AS la ON la.id_libro = l.id AND la.id_autor = a.id
WHERE a.nombre = "J.K. Rowling";

# 14.-
SELECT l.titulo
FROM libros AS l
INNER JOIN prestamos AS p ON p.id_libro = l.id
WHERE p.fecha_devolucion = "2021-07-16";