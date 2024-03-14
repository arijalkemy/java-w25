-- 1. Listar los datos de los autores.
SELECT *
FROM AUTOR;

-- 2. Listar nombre y edad de los estudiantes
SELECT Nombre, Edad
FROM ESTUDIANTE;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM ESTUDIANTE
WHERE Carrera = 'informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM AUTOR
WHERE Nacionalidad IN ('francesa', 'italiana');

-- 5. ¿Qué libros no son del área de internet?
SELECT *
FROM LIBRO
WHERE area = 'internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT *
FROM LIBRO
WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
WITH edad_promedio AS (
    SELECT AVG(edad) AS edad_promedio
    FROM ESTUDIANTE
)
SELECT *
FROM ESTUDIANTE e JOIN edad_promedio p ON e.edad > p.edad_promedio;

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM ESTUDIANTE
WHERE apellido LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre
FROM LIBROAUTOR la JOIN AUTOR a ON la.idAutor = a.idAutor
WHERE idLibro IN (
    SELECT idLibro
    FROM LIBRO
    WHERE titulo = 'El Universo: Guía de viaje'
);

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
WITH prestamos_filippo AS (
    SELECT idLibro
    FROM PRESTAMO
    WHERE idLector IN (
        SELECT idLector
        FROM ESTUDIANTE
        WHERE nombre = 'Filippo'
        AND apellido = 'Galli'
    )
)
SELECT l.titulo
FROM prestamos_filippo p JOIN LIBRO l ON p.idLibro = l.idLibro;



-- 11. Listar el nombre del estudiante de menor edad.
SELECT nombre, apellido
FROM ESTUDIANTE
ORDER BY edad
LIMIT 1;

WITH minimo AS (
    SELECT MIN(edad) AS edad
    FROM ESTUDIANTE
)
SELECT nombre, apellido
FROM ESTUDIANTE e JOIN minimo m ON e.edad = m.edad
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre, e.apellido
FROM PRESTAMO p JOIN ESTUDIANTE e ON p.idLector = e.idLector
WHERE idLibro IN (
    SELECT idLibro
    FROM LIBRO
    WHERE titulo = 'Base de Datos'
);

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
WITH JK AS (
    SELECT idAutor
    FROM AUTOR
    WHERE nombre = 'J.K. Rowling'
)
SELECT *
FROM LIBRO
WHERE idLibro IN (
    SELECT idLibro
    FROM LIBROAUTOR la JOIN JK ON la.idAutor = jk.idAutor
);

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo
FROM LIBRO
WHERE idLibro IN (
    SELECT DISTINCT idLibro
    FROM PRESTAMO
    WHERE fechaDevolucion = '2021-07-16'
);
