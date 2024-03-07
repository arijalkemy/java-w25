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

-- CONSULTAS

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, puesto, localidad
FROM departamento dep
	INNER JOIN empleado emp
		ON 	emp.depto_nro = dep.depto_nro
        AND	emp.puesto = "Vendedor";
        
-- Visualizar los departamentos con más de cinco empleados.
SELECT dep.nombre_depto, COUNT(1) AS cant_empleados
FROM empleado emp
	INNER JOIN departamento dep
		ON dep.depto_nro = emp.depto_nro
GROUP BY emp.depto_nro
HAVING COUNT(1) > 2;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT nombre, salario, dep.nombre_depto
FROM empleado emp
	INNER JOIN departamento dep
		ON dep.depto_nro = emp.depto_nro
WHERE puesto = ( 	SELECT puesto
					FROM empleado emp2
                    WHERE emp2.apellido = 'Brezezicki'
				);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT emp.*
FROM empleado emp
	INNER JOIN departamento dep
		ON 	dep.depto_nro = emp.depto_nro
        AND	dep.nombre_depto = 'Contabilidad'
ORDER BY emp.nombre ASC;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, salario
FROM empleado
ORDER BY salario ASC
LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre, salario
FROM empleado emp
	INNER JOIN departamento dep
		ON 	dep.depto_nro = emp.depto_nro
        AND dep.nombre_depto = 'Ventas'
ORDER BY salario DESC
LIMIT 1;