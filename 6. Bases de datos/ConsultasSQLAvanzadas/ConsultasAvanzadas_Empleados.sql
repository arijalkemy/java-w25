-- Creacion base de datos y tablas
DROP DATABASE IF EXISTS empresa_empleados;
CREATE DATABASE empresa_empleados;
USE empresa_empleados;
DROP TABLE IF EXISTS `departamento`;
CREATE TABLE `departamento` (
  `depto_nro` varchar(7) NOT NULL,
  `nombre_depto` varchar(50) NOT NULL,
  `localidad` varchar(50) NOT NULL,
  PRIMARY KEY (`depto_nro`)  
);
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `cod_emp` varchar(6) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `puesto` varchar(50) NOT NULL,
  `fecha_alta` datetime NOT NULL,
  `salario` int NOT NULL,
  `comision` int NOT NULL,
  `depto_nro` varchar(7) NOT NULL,
  PRIMARY KEY (`cod_emp`),
  KEY `depto_nro_idx` (`depto_nro`),
  CONSTRAINT `FK_EMPLEADO_PLAN_DEPARTAMENTO` FOREIGN KEY (`depto_nro`) REFERENCES `departamento` (`depto_nro`)
) ;

-- Ingreso datos
INSERT INTO departamento VALUES("D-000-1","Software","Los Tigres");
INSERT INTO departamento VALUES("D-000-2","Sistemas","Guadalupe");
INSERT INTO departamento VALUES("D-000-3","Contabilidad","La Roca");
INSERT INTO departamento VALUES("D-000-4","Ventas","Plata");

INSERT INTO empleado VALUES("E-0001","César","Piñero","Vendedor","2018-05-12","80000","15000","D-000-4");
INSERT INTO empleado VALUES("E-0002","Yosep","Kowaleski","Analista","2015-07-14","140000","0","D-000-2");
INSERT INTO empleado VALUES("E-0003","Mariela","Barrios","Director","2014-06-05","185000","0","D-000-3");
INSERT INTO empleado VALUES("E-0004","Jonathan","Aguilera","Vendedor","2015-06-03","85000","10000","D-000-4");
INSERT INTO empleado VALUES("E-0005","Daniel","Brezezicki","Vendedor","2018-03-03","83000","10000","D-000-4");
INSERT INTO empleado VALUES("E-0006","Mito","Barchuk","Presidente","2014-06-05","190000","0","D-000-3");
INSERT INTO empleado VALUES("E-0007","Emilio","Galarza","Desarrollador","2014-08-02","60000","0","D-000-1");

-- Consultas
-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT DISTINCT d.nombre_depto as Departamento, e.puesto as Puesto, d.localidad as Localidad
FROM departamento d INNER JOIN empleado e ON d.depto_nro = e.depto_nro
WHERE e.puesto="Vendedor";
-- Visualizar los departamentos con más de cinco (cambio a 2 porque no hay de 5) por empleados.
SELECT d.nombre_depto as Departamento, count(e.cod_emp) as "Cantidad Empleados"
FROM departamento d INNER JOIN empleado e ON d.depto_nro = e.depto_nro
GROUP BY d.nombre_depto
HAVING count(e.cod_emp)>2;
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT concat(e.nombre, " ", e.apellido) as Nombre, e.salario as Salario, d.nombre_depto
FROM departamento d INNER JOIN empleado e ON d.depto_nro = e.depto_nro
WHERE e.puesto=(SELECT e.puesto FROM  empleado e WHERE e.nombre="Mito" AND e.apellido="Barchuk");
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT concat(e.nombre, " ", e.apellido) as Nombre, e.puesto as Puesto,e.salario as Salario
FROM departamento d INNER JOIN empleado e ON d.depto_nro = e.depto_nro
WHERE d.nombre_depto="Contabilidad"
ORDER BY e.nombre;
-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT CONCAT(e.nombre, " ", e.apellido) as Nombre, e.salario as Salario
FROM empleado e
WHERE e.salario = (SELECT MIN(salario) FROM empleado);
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’
SELECT CONCAT(e.nombre, " ", e.apellido) as Nombre, e.puesto as Puesto,e.salario as Salario
FROM empleado e
WHERE e.salario = (SELECT MAX(salario) FROM departamento d INNER JOIN empleado e ON d.depto_nro = e.depto_nro WHERE d.nombre_depto="Ventas");





