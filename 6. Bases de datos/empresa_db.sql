#Crear y usar base de datos
CREATE DATABASE IF NOT EXISTS empresa_db;
USE empresa_db;

#Creación de tablas
CREATE TABLE IF NOT EXISTS departamentos (
	depto_nro VARCHAR(15) NOT NULL,
    nombre_depto VARCHAR (15) NOT NULL,
    localidad VARCHAR (30) NOT NULL,
    PRIMARY KEY (depto_nro)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS empleados (
	cod_emp VARCHAR(10) NOT NULL,
    nombre VARCHAR(20) NOT NULL,
    apellido VARCHAR(20) NOT NULL,
    puesto VARCHAR(20) NOT NULL,
    fecha_alta DATE NOT NULL,
    salario FLOAT NOT NULL,
    comision FLOAT NOT NULL,
    PRIMARY KEY (cod_emp),
    departamentos_depto_nro VARCHAR(15) NOT NULL,
		CONSTRAINT fkempleado_depto_nro
		FOREIGN KEY (departamentos_depto_nro)
		REFERENCES departamentos (depto_nro)
) ENGINE=INNODB;
show tables;

#Insercion de datos
INSERT INTO departamentos (depto_nro, nombre_depto, localidad)
VALUES
	('D-000-1', 'Software', 'Los Tigres'),
    ('D-000-2', 'Sistemas', 'Guadalupe'),
    ('D-000-3', 'Contabilidad', 'La Roca'),
    ('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, departamentos_depto_nro) 
VALUES
    ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
    ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
    ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
    ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
	('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
    ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
    ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');
    
#Consultas SQL
#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.    
SELECT e.nombre AS 'Nombre empleado', e.puesto AS 'Puesto de trabajo', d.localidad AS 'Localidad' 
FROM empleados e INNER JOIN departamentos d 
ON e.departamentos_depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

#Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto AS 'Departamento', COUNT(e.cod_emp) as total_empleados
FROM departamentos d INNER JOIN empleados e 
ON d.depto_nro = e.departamentos_depto_nro
GROUP BY d.nombre_depto
HAVING COUNT(e.cod_emp) > 5;

#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre AS 'Nombre', e.salario AS 'Salario', d.nombre_depto 'Departamento'
FROM empleados e INNER JOIN departamentos d
ON e.departamentos_depto_nro = d.depto_nro
WHERE d.nombre_depto IN (
	SELECT nombre_depto
    FROM departamentos d INNER JOIN empleados e
    ON e.departamentos_depto_nro = d.depto_nro
	WHERE e.nombre = 'Mito' AND e.apellido = 'Barchuk'
    );

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT nombre AS 'Nombre', apellido AS 'Apellido', puesto AS 'Puesto', fecha_alta AS 'Fecha de alta', salario AS 'Salario', comision AS 'Comisión'
FROM empleados e INNER JOIN departamentos d
ON e.departamentos_depto_nro = d.depto_nro
WHERE d.nombre_depto = "Contabilidad"
ORDER BY e.nombre;

#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre AS 'Nombre'
FROM empleados
WHERE salario = (
	SELECT MIN(salario)
    FROM empleados
	);

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre AS 'Nombre', apellido AS 'Apellido', puesto AS 'Puesto', fecha_alta AS 'Fecha de alta', salario AS 'Salario', comision AS 'Comisión'
FROM empleados e INNER JOIN departamentos d
ON e.departamentos_depto_nro = d.depto_nro
WHERE d.nombre_depto = "Ventas"
ORDER BY salario DESC
LIMIT 1;