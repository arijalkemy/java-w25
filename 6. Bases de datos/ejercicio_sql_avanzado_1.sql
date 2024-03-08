# Grupo 7

DROP TABLE IF EXISTS empleado;
CREATE TABLE empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    puesto VARCHAR(20),
    fecha_alta DATE,
    salario FLOAT,
    comision FLOAT,
    depto_nro VARCHAR(20)
);

INSERT INTO empleado VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002','Yosep','Kowaleski','Analista','2015-07-14',14000,0,'D-000-2'),
("E-0003", "Mariela", "Barrios", "Director", "2014-06-05", 1850000, 0, "D-000-3"),
("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-03", 85000, 10000, "D-000-4"),
("E-0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", 83000, 10000, "D-000-4"),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

DROP TABLE IF EXISTS departamento;
CREATE TABLE departamento (
	depto_nro VARCHAR(20) PRIMARY KEY,
    nombre_depto VARCHAR(40),
    localidad VARCHAR(40)
);


INSERT INTO departamento VALUES ('D-000-1', 'Software', 'Los Tigres');
INSERT INTO departamento VALUES ('D-000-2', 'Sistemas', 'Guadalupe');
INSERT INTO departamento VALUES ('D-000-3', 'Contabilidad', 'La Rosa');
INSERT INTO departamento VALUES ('D-000-4', 'Ventas', 'Plata');


ALTER TABLE empleado ADD CONSTRAINT fk_depto_nro FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro);

# Finalmente podemos empezar el ejercicio

SELECT empleado.nombre, empleado.puesto, departamento.localidad FROM empleado
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro;

SELECT empleado.depto_nro, COUNT(empleado.cod_emp) as empleados_total FROM empleado GROUP BY empleado.depto_nro HAVING empleados_total >= 2;

SELECT empleado.nombre, empleado.salario, departamento.nombre_depto FROM empleado
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = (
SELECT puesto FROM empleado WHERE nombre = 'Mito' AND apellido = 'Barchuk'
);

SELECT * FROM empleado
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = 'Contabilidad'
ORDER BY empleado.nombre ASC;

SELECT empleado.nombre, empleado.apellido, empleado.salario FROM empleado
WHERE empleado.salario = (
SELECT MIN(salario) FROM empleado
);

SELECT * FROM empleado
INNER JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = 'Ventas'
ORDER BY empleado.salario DESC
LIMIT 1;

/*
EJERCICIO 2
*/

#Listar los datos de los autores.
SELECT * FROM autor;

##Listar nombre y edad de los estudiantes
SELECT nombre, apellido, edad FROM ESTUDIANTE;

##¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre, apellido, carrera WHERE carrera = "Informática";

##¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad FROM autor WHERE nacionalidad = "Francesa" OR nacionalidad =  "Italiana";

#¿Qué libros no son del área de internet?
SELECT titulo, editorial FROM libro WHERE area NOT LIKE "Internet";

#Listar los libros de la editorial Salamandra.
SELECT titulo, editorial, area FROM libro where editorial = "Salamanca";

##Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre, apellido, carrera, edad FROM estudiante WHERE edad < (SELECT AVG(edad) FROM estudiante);

###Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre FROM estudiante WHERE apellido LIKE "G%";

####Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT nombre FROM autor 
INNER JOIN  libroautor ON libroautor.idAutor = autor.idAutor
WHERE libroautor.idLibro IN (SELECT idLibro FROM libro where titulo =  "EL Universo: Guia de viaje");

###¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT titulo from libro
INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro
WHERE prestamo.idLector IN (SELECT idLector FROM estudiante WHERE nombre ="Filippo" AND apellido = "Galli");

###Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante WHERE edad = (SELECT MIN(edad) FROM estudiante);

###Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT nombre FROM estudiante 
INNER JOIN prestamo ON prestamo.idLector = estudiante.idLector
WHERE prestamo.idLibro IN (SELECT idLibro FROM libro WHERE area="Base de datos");

###Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT titulo FROM libro 
INNER JOIN libroautor ON libro.idLibro = libroautor.idLibro
WHERE libroautor.idAutor IN (SELECT idAutor FROM autor WHERE nombre = "J.K. Rowling");

####Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo FROM libro 
INNER JOIN prestamo ON libro.idLibro = prestamo.idLibro
WHERE fechaDevolucion = "16/07/2021";