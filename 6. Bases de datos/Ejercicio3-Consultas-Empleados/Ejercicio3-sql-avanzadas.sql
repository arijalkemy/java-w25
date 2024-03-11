DROP DATABASE IF EXISTS empresa;

CREATE DATABASE IF NOT EXISTS empresa;

USE empresa;

CREATE TABLE departamento (
	depto_nro varchar(7) NOT NULL,
    nombre_depto varchar(20) NOT NULL,
    localidad varchar(20) NOT NULL,
    
    PRIMARY KEY (depto_nro)
);

CREATE TABLE empleado (
	cod_emp varchar(6) NOT NULL,
    nombre varchar(20) NOT NULL,
    apellido varchar(20) NOT NULL,
    puesto varchar(20) NOT NULL,
    fecha_alta date NOT NULL,
    salario int NOT NULL,
    comision int NOT NULL,
    depto_nro varchar(7) NOT NULL,
    
    PRIMARY KEY (cod_emp),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
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
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT em.nombre AS "Nombre", em.puesto AS "Puesto", de.localidad as "Localidad" FROM empleado em
INNER JOIN departamento de ON em.depto_nro = de.depto_nro
WHERE em.puesto = "Vendedor";

# Visualizar los departamentos con más de cinco empleados.
SELECT depto_nro, nombre_depto
FROM departamento
WHERE depto_nro IN (
    SELECT depto_nro
    FROM empleado
    GROUP BY depto_nro
    HAVING COUNT(cod_emp) > 2
);

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT em.nombre, em.apellido, em.salario, de.nombre_depto FROM empleado em
INNER JOIN departamento de ON em.depto_nro = de.depto_nro
WHERE em.puesto IN (
	SELECT puesto FROM empleado 
    WHERE nombre = "Mito" AND apellido = "Barchuk"
    );

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT em.nombre AS Nombre, em.apellido AS Apellido, em.puesto AS Puesto, em.fecha_alta AS Fecha_alta, em.salario AS Salario, em.comision AS Comision, de.nombre_depto AS Nombre_depto FROM empleado em
INNER JOIN departamento de ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = "Contabilidad"
ORDER BY em.nombre;

# Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre AS Nombre, apellido AS Apellido FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT em.nombre AS Nombre, em.apellido AS Apellido, em.salario AS Salario FROM empleado em
INNER JOIN departamento de ON em.depto_nro = de.depto_nro
WHERE de.nombre_depto = "Ventas"
ORDER BY em.salario DESC
LIMIT 1;
