DROP DATABASE IF EXISTS empleados_db;
CREATE DATABASE empleados_db;
USE empleados_db;

DROP TABLE IF EXISTS `empleado`;
DROP TABLE IF EXISTS `departamento`;

CREATE TABLE `departamento` (
  `depto_nro` varchar(7) NOT NULL,
  `localidad` varchar(50),
  `nombre_depto` varchar(50),
  PRIMARY KEY (`depto_nro`)
);

CREATE TABLE `empleado` (
  `cod_emp` varchar(7) NOT NULL,
  `nombre` varchar(50),
  `apellido` varchar(50),
  `puesto` varchar(50),
  `fecha_alta` date,
  `salario` float,
  `comision`float,
  `depto_nro` varchar(7),
  PRIMARY KEY (`cod_emp`),
  CONSTRAINT `depto_nro_foreign` FOREIGN KEY (`depto_nro`) REFERENCES departamento(`depto_nro`)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES 
('D-000-1', 'Software', 'Los Tigres' ),
('D-000-2','Sistemas','Guadalupe'),
('D-000-3','Contabilidad','La Roca'),
('D-000-4','Ventas','Plata');

INSERT INTO empleado(cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

