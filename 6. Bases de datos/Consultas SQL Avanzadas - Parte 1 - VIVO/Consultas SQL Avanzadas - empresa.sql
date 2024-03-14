CREATE DATABASE empresa_db;
USE empresa_db;

CREATE TABLE departamento(
	depto_nro VARCHAR(7) NOT NULL PRIMARY KEY,
    nombre_depto VARCHAR(30),
    localidad VARCHAR(30)
);

CREATE TABLE empleado(
	cod_emp VARCHAR(6) NOT NULL PRIMARY KEY,
    nombre VARCHAR(20),
    apellido VARCHAR(20),
    puesto VARCHAR(20),
    fecha_alta DATETIME,
    salario INT,
    comision INT,
    depto_nro VARCHAR(7),
    FOREIGN KEY(depto_nro) REFERENCES departamento(depto_nro)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1'),
('E-0008', 'Lucho', 'Rodriguez', 'Presidente', '2014-06-05', 100000, 0, 'D-000-3');

#1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT em.nombre, em.puesto, de.localidad FROM empleado em
INNER JOIN departamento de ON em.depto_nro = de.depto_nro;

#2. Visualizar los departamentos con más de cinco empleados.
SELECT de.nombre_depto, COUNT(*) as Total FROM empleado em
INNER JOIN departamento de ON em.depto_nro = de.depto_nro
GROUP BY de.nombre_depto
HAVING Total > 5;

#3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.salario, de.nombre_depto FROM empleado em
INNER JOIN departamento de ON de.depto_nro = em.depto_nro
WHERE em.puesto IN (SELECT e.puesto
                    FROM EMPLEADO e
                    WHERE e.nombre = 'Mito'
                    AND e.apellido = 'Barchuk');

#4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT em.* FROM empleado em
INNER JOIN departamento de ON de.depto_nro = em.depto_nro
WHERE de.nombre_depto = "Contabilidad"
ORDER BY em.nombre DESC;

#5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM empleado
ORDER BY salario ASC
LIMIT 1;

#6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.* FROM empleado em
INNER JOIN departamento de ON de.depto_nro = em.depto_nro
WHERE de.nombre_depto = "Ventas"
ORDER BY em.salario DESC
LIMIT 1;



