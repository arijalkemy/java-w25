/*
setup:

CREATE DATABASE `empresa`

CREATE TABLE `departamento` (
  `depto_nro` varchar(100) NOT NULL,
  `nombre_depto` varchar(100) NOT NULL,
  `localidad` varchar(100) NOT NULL,
  PRIMARY KEY (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `empleado` (
  `cod_emp` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `puesto` varchar(100) NOT NULL,
  `fecha_alta` date NOT NULL,
  `salario` float NOT NULL,
  `comision` float NOT NULL,
  `depto_nro` varchar(100) NOT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `empleado_departamento_FK` (`depto_nro`),
  CONSTRAINT `empleado_departamento_FK` FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`depto_nro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO departamento
values
("D-000-1","Software","Los Tigres"),
("D-000-2","Sistemas","Guadalupe"),
("D-000-3","Contabilidad","La Roca"),
("D-000-4","Ventas","Plata");

INSERT INTO empleado 
values
("E-0001","César","Piñero","Vendedor",date '2018-05-12',80000,15000,"D-000-4"),
("E-0002","Yosep","Kowaleski","Analista",date '2015-07-14',140000,0,"D-000-2"),
("E-0003","Mariela","Barrios","Director",date '2014-06-05',185000,0,"D-000-3"),
("E-0004","Jonathan","Aguilera","Vendedor",date '2015-06-03',85000,10000,"D-000-4"),
("E-0005","Daniel","Brezezicki","Vendedor",date '2018-03-03',83000,10000,"D-000-4"),
("E-0006","Mito","Barchuk","Presidente",date '2014-06-05',190000,0,"D-000-3"),
("E-0007","Emilio","Galarza","Desarrollador",date '2014-08-02',60000,0,"D-000-1");
*/

use empresa;

-- Obtener los empleados con mayor salario al promedio de salarios.
Select e.nombre, e.salario
From empleado e 
Group by e.nombre, e.salario 
Having e.salario  > (Select avg(e2.salario) From empleado e2);

-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad from empleado e join departamento d on e.depto_nro = d.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT e.depto_nro FROM empleado e GROUP BY e.depto_nro HAVING COUNT(*) > 5 ;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto FROM empleado e join departamento d on e.depto_nro = d.depto_nro WHERE e.puesto = (SELECT e2.puesto from empleado e2 WHERE e2.nombre = "Mito" and e2.apellido = "Barchuk");

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* from empleado e join departamento d on e.depto_nro = d.depto_nro WHERE d.nombre_depto = "Contabilidad" ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM  empleado e order by salario LIMIT 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.* FROM empleado e join departamento d on e.depto_nro = d.depto_nro WHERE d.nombre_depto = "Ventas" ORDER BY e.salario DESC limit 1;