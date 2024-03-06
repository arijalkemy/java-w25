# 1. CREACION DE EMPRESA
USE emp_depto

CREATE TABLE departamento ( 
      `depto_nro` VARCHAR(45) PRIMARY KEY,
      `nombre_depto` VARCHAR(45) NOT NULL,
      `localidad` VARCHAR(45) NOT NULL
);

CREATE TABLE empleado ( 
      `cod_emp` VARCHAR(20) PRIMARY KEY,
      `nombre` VARCHAR(45) NOT NULL,
      `apellido` VARCHAR(45) NOT NULL,
      `puesto` VARCHAR(45) NOT NULL,
      `fecha_alta` DATE NOT NULL,
      `salario` INT NOT NULL,
      `comision` INT NOT NULL,
      `depto_nro` VARCHAR(45) NOT NULL,
      FOREIGN KEY(`depto_nro`) REFERENCES departamento(`depto_nro`)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', '80000', '15000', 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', '140000', '0', 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', '185000', '0', 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', '85000', '10000', 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', '83000', '10000', 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', '190000', '0', 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', '60000', '0', 'D-000-1');


# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
select em.nombre, em.puesto, de.localidad from empleado em
inner join departamento de on de.depto_nro = em.depto_nro
where em.puesto = "Vendedor";

# Visualizar los departamentos con más de cinco empleados.
select de.nombre_depto, count(em.depto_nro) as nrm_empleados from departamento de
inner join empleado em on de.depto_nro = em.depto_nro
group by em.depto_nro having nrm_empleados >= 2;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select em.nombre, em.salario, de.nombre_depto from empleado em
inner join departamento de on de.depto_nro = em.depto_nro
where em.puesto = (select em.puesto from empleado em where em.nombre = "Mito" and em.apellido = "Barchuk" );

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select em.* from empleado em
where em.depto_nro = "D-000-3"
order by em.nombre desc;

# Mostrar el nombre del empleado que tiene el salario más bajo.
select em.nombre from empleado em
order by em.salario asc
limit 1;
select em.nombre from empleado em
where em.salario = (select min(em.salario) from empleado em);

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select em.* from empleado em
where em.salario = (select max(em.salario) from empleado em where em.depto_nro = "D-000-4");

# 2. CREACION BIBLIOTECA
DROP TABLE IF EXISTS prestamo;
DROP TABLE IF EXISTS libroautor;
DROP TABLE IF EXISTS libro;
DROP TABLE IF EXISTS estudiante;
DROP TABLE IF EXISTS autor;

create table libro (
    idLibro INT PRIMARY KEY,
    Titulo VARCHAR(50),
    Editorial VARCHAR(50),
    Area VARCHAR(50)
);
insert into libro (idLibro, Titulo, Editorial, Area) values (1, 'RFK Must Die: The Assassination of Bobby Kennedy', 'Salamandra', 'Documentary');
insert into libro (idLibro, Titulo, Editorial, Area) values (2, 'Trouble with Bliss, The', 'Corabel', 'internet');
insert into libro (idLibro, Titulo, Editorial, Area) values (3, 'Butterfly, The (Papillon, Le)', 'Elnore', 'internet');
insert into libro (idLibro, Titulo, Editorial, Area) values (4, 'Flying Deuces, The', 'Salamandra', 'Bases de Datos');
insert into libro (idLibro, Titulo, Editorial, Area) values (5, 'El Universo: Guía de viaje', 'Temp', 'Drama');
insert into libro (idLibro, Titulo, Editorial, Area) values (6, 'Ah, Wilderness!', 'Salamandra', 'internet');
insert into libro (idLibro, Titulo, Editorial, Area) values (7, 'Sione''s Wedding (Samoan Wedding)', 'Bibi', 'Bases de Datos');
insert into libro (idLibro, Titulo, Editorial, Area) values (8, 'Assault, The (Aanslag, De)', 'Salamandra', 'Drama|Romance|War');
insert into libro (idLibro, Titulo, Editorial, Area) values (9, 'Trees Lounge', 'Colleen', 'Drama');
insert into libro (idLibro, Titulo, Editorial, Area) values (10, 'Libeled Lady', 'Paxon', 'Bases de Datos');

create table estudiante (
	idLector INT PRIMARY KEY,
	nombre VARCHAR(50),
	apellido VARCHAR(50),
	direccion VARCHAR(50),
	carrera VARCHAR(50),
	edad INT
);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (1, 'Gerardo', 'Edgeworth', '9770 Goodland Plaza', 'informatica', 28);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (2, 'Filippo', 'Galli', '39 Glendale Crossing', 'Programmer Analyst I', 28);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (3, 'Gasper', 'Gotham', '9 Stuart Lane', 'informatica', 18);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (4, 'Shandeigh', 'Swinburne', '0067 Green Ridge Lane', 'General Manager', 36);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (5, 'Yves', 'Flaherty', '784 Bartelt Crossing', 'informatica', 87);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (6, 'Kessia', 'McOnie', '6562 Clemons Alley', 'VP Marketing', 33);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (7, 'Noelani', 'McRorie', '44 Carpenter Point', 'Legal Assistant', 98);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (8, 'Jamima', 'Grantsev', '3 Leroy Crossing', 'informatica', 99);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (9, 'Fredi', 'Hallad', '9 Main Parkway', 'Senior Editor', 74);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (10, 'Brennen', 'Orvis', '2 Thierer Hill', 'Civil Engineer', 90);

create table autor (
	idAutor INT PRIMARY KEY,
	nombre VARCHAR(50),
	nacionalidad VARCHAR(50)
);
insert into autor (idAutor, nombre, nacionalidad) values (1, 'Dewitt', 'Indonesia');
insert into autor (idAutor, nombre, nacionalidad) values (2, 'Richmond', 'Francia');
insert into autor (idAutor, nombre, nacionalidad) values (3, 'Dennet', 'Burkina Faso');
insert into autor (idAutor, nombre, nacionalidad) values (4, 'J.K. Rowling', 'Eritrea');
insert into autor (idAutor, nombre, nacionalidad) values (5, 'Gavrielle', 'Sweden');
insert into autor (idAutor, nombre, nacionalidad) values (6, 'Shari', 'Bulgaria');
insert into autor (idAutor, nombre, nacionalidad) values (7, 'Damon', 'Italia');
insert into autor (idAutor, nombre, nacionalidad) values (8, 'Aymer', 'Colombia');
insert into autor (idAutor, nombre, nacionalidad) values (9, 'Ariela', 'Francia');
insert into autor (idAutor, nombre, nacionalidad) values (10, 'Ryan', 'Italia');

create table prestamo (
	idLector INT,
	idLibro INT,
	FechaPrestamo DATE,
	FechaDevolucion DATE,
	Devuelto VARCHAR(50),
    PRIMARY KEY(idLector, idLibro),
    FOREIGN KEY(`idLector`) REFERENCES estudiante(`idLector`),
    FOREIGN KEY(`idLibro`) REFERENCES libro(`idLibro`)
);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (1, 1, '2024-01-07', '2021-05-28', true);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (2, 2, '2023-10-19', '2023-09-02', false);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (3, 3, '2023-08-23', '2023-08-04', false);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (4, 4, '2023-09-24', '2021-04-04', false);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (5, 5, '2023-07-08', '2020-02-02', true);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (6, 6, '2023-07-06', '2023-12-16', true);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (7, 7, '2023-12-23', '2023-09-03', true);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (8, 8, '2023-06-03', '2023-05-10', true);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (9, 9, '2023-04-11', '2023-10-17', false);
insert into PRESTAMO (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) values (10, 10, '2023-12-17', '2023-07-25', false);

create table libroautor (
	idAutor INT,
	idLibro INT,
    PRIMARY KEY(idAutor, idLibro),
    FOREIGN KEY(`idAutor`) REFERENCES autor(`idAutor`),
    FOREIGN KEY(`idLibro`) REFERENCES libro(`idLibro`)
);
insert into libroautor (idAutor, idLibro) values (1, 1);
insert into libroautor (idAutor, idLibro) values (2, 2);
insert into libroautor (idAutor, idLibro) values (3, 3);
insert into libroautor (idAutor, idLibro) values (4, 4);
insert into libroautor (idAutor, idLibro) values (5, 5);
insert into libroautor (idAutor, idLibro) values (6, 6);
insert into libroautor (idAutor, idLibro) values (7, 7);
insert into libroautor (idAutor, idLibro) values (8, 8);
insert into libroautor (idAutor, idLibro) values (9, 9);
insert into libroautor (idAutor, idLibro) values (10, 10);

# CONSULTAR BIBLIOTECA
USE BIBLIOTECA;

# Listar los datos de los autores
select * from autor;

# Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;

# ¿Qué estudiantes pertenecen a la carrera informática?
select nombre from estudiante where carrera = 'informatica';

# ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad in ('Francia', 'Italia');

# ¿Qué libros no son del área de internet?
select * from libro where area = 'internet';

# Listar los libros de la editorial Salamandra.
select * from libro where editorial = 'Salamandra';

# Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante where edad > (select avg(edad) from estudiante);

# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre from estudiante where apellido like 'G%';

# Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select * from autor where idAutor in (select idAutor from libroautor where idLibro in (select idLibro from libro where titulo = 'El Universo: Guía de viaje'));

# ¿Qué libros se prestaron al lector “Filippo Galli”?
select * from libro where idLibro in (select idLibro from prestamo where idLector in (select idLector from estudiante where nombre = 'Filippo' and apellido = 'Galli'));

# Listar el nombre del estudiante de menor edad.
select nombre from estudiante order by edad asc limit 1;

# Listar nombres de los estudiantes a los que se prestaron libros de Bases de Datos.
select nombre from estudiante where idLector in (select idLector from prestamo where idLibro in (select idLibro from libro where area = 'Bases de Datos'));

# Listar los libros que pertenecen a la autora J.K. Rowling.
select * from libro where idLibro in (select idLibro from libroautor where idAutor in (select idAutor from autor where nombre = 'J.K. Rowling'));

# Listar títulos de los libros que debían devolverse antes del 16/07/2021.
select titulo from libro where idLibro in (select idLibro from prestamo where FechaDevolucion < '2021-07-16');


