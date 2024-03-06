-- Crear la tabla EMPLEADO
CREATE TABLE EMPLEADO (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario INT,
    comision INT,
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

-- Crear la tabla DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- Insertar datos en la tabla EMPLEADO
INSERT INTO EMPLEADO (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- Insertar datos en la tabla DEPARTAMENTO
INSERT INTO DEPARTAMENTO (depto_nro, nombre_depto, localidad)
VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');


# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro;

# Visualizar los departamentos con más de cinco empleados.
select d.depto_nro, d.nombre_depto, d.localidad, count(*) total from DEPARTAMENTO d join EMPLEADO e on d.depto_nro = e.depto_nro
	GROUP BY e.depto_nro HAVING count(*) > 2;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro
	where e.puesto = (select puesto from EMPLEADO where nombre like 'Mito' and apellido like 'Barchuk');

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select * from EMPLEADO e where e.depto_nro = (select depto_nro from DEPARTAMENTO where nombre_depto like 'Contabilidad')
	order by nombre;

select * from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro where d.nombre_depto like 'Contabilidad'
	order by e.nombre;

# Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre from EMPLEADO order by salario limit 1;

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select * from EMPLEADO e where e.depto_nro = (select depto_nro from DEPARTAMENTO where nombre_depto like 'Contabilidad')
	order by salario desc limit 1;


# Listar los datos de los autores.
select * from autor;

# Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante e where e.carrera like 'Informatica';

# ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor a WHERE a.nacionalidad like 'Francesa' or a.nacionalidad like 'Italiana';

# ¿Qué libros no son del área de internet?
select * from libro l WHERE l.area not like 'Internet';

# Listar los libros de la editorial Salamandra.
select * from libro l WHERE l.editorial like 'Salamandra';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante e where e.edad > (select AVG(edad) from estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre, apellido from estudiante e where e.apellido like 'G%';

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select a.nombre from autor a join libro_autor la on a.id_autor = la.id_autor 
	join libro l on la.id_libro = l.id_libro
	WHERE l.titulo like 'El Universo: Guía de viaje';

# ¿Qué libros se prestaron al lector “Filippo Galli”?
select l.titulo from libro l join prestamo p on l.id_libro = p.id_libro 
	join estudiante e on p.id_lector = e.id_lector 
	WHERE e.nombre like 'Filippo' and e.apellido = 'Galli';

# Listar el nombre del estudiante de menor edad.
select nombre from estudiante e order by edad limit 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select e.nombre from estudiante e join prestamo p on e.id_lector = p.id_lector 
	join libro l on p.id_libro = l.id_libro
	WHERE l.area like 'Base de datos';

# Listar los libros que pertenecen a la autora J.K. Rowling.
select l.titulo, l.editorial, l.area from libro l join libro_autor la on l.id_libro = la.id_libro
	join autor a on la.id_autor = a.id_autor 
	WHERE a.nombre like 'J.K. Rowling';

# Listar títulos de los libros que debían devolverse el 16/07/2021.
select l.titulo from libro l join prestamo p on l.id_libro = p.id_libro 
	WHERE p.fecha_devolucion = '2021-07-16';


/* Implementar la base de datos en PHPMyAdmin o MySQL Workbench, cargar cinco registros en cada tabla 
y probar algunas consultas planteadas en el Ejercicio 1. */


create database biblioteca;

CREATE table autor(
	id_autor int primary key auto_increment,
	nombre varchar(256),
	nacionalidad varchar(256)
);

CREATE table libro(
	id_libro int primary key auto_increment,
	titulo varchar(256),
	editorial varchar(256),
	area varchar(256)
);

CREATE table libro_autor(
	id_autor int,
	id_libro int,
	foreign key (id_autor) references autor(id_autor),
	foreign key (id_libro) references libro(id_libro)
);

CREATE table estudiante(
	id_lector int primary key auto_increment,
	nombre varchar(256),
	apellido varchar(256),
	direccion varchar(256),
	carrera varchar(256),
	edad int
);


CREATE TABLE prestamo (
	id_prestamo int primary key auto_increment,
    id_lector INT,
    id_libro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    FOREIGN KEY (id_lector) REFERENCES estudiante(id_lector),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- Inserts para la tabla 'autor'
INSERT INTO autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Francesa'),
('Haruki Murakami', 'Japonés'),
('J.K. Rowling', 'Italiana'),
('Stephen King', 'Italiana'),
('Jane Austen', 'Británica');

-- Inserts para la tabla 'libro'
INSERT INTO libro (titulo, editorial, area) VALUES
('Cien años de soledad', 'Sudamericana', 'Realismo mágico'),
('El Universo: Guía de viaje', 'Kodansha', 'Ficción'),
('Harry Potter y la piedra filosofal', 'Bloomsbury', 'Fantasía'),
('It', 'Viking Press', 'Terror'),
('Orgullo y prejuicio', 'Thomas Egerton', 'Romance');

-- Inserts para la tabla 'libro_autor'
INSERT INTO libro_autor (id_autor, id_libro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Inserts para la tabla 'estudiante'
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Filippo', 'Galli', 'Calle 123', 'Ingeniería', 20),
('María', 'González', 'Avenida 456', 'Medicina', 22),
('Carlos', 'López', 'Carrera 789', 'Derecho', 15),
('Ana', 'Martínez', 'Calle Principal', 'Psicología', 23),
('Pedro', 'Sánchez', 'Avenida Central', 'Economía', 19);

-- Inserts para la tabla 'prestamo'
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2024-02-01', '2024-02-15', 1),
(2, 3, '2024-01-20', '2024-02-10', 1),
(3, 4, '2020-02-05', '2021-07-16', 0),
(4, 2, '2020-01-15', '2021-07-16', 0),
(5, 5, '2024-02-10', NULL, 0);
