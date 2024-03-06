CREATE DATABASE empresa_db;

USE empresa_db;

CREATE TABLE departamento(
	depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- CREATE TABLE `empresa`.`empleado` (
--  `cod_emp` VARCHAR(12) NOT NULL,
--  `nombre` VARCHAR(45) NULL,
-- `apellido` VARCHAR(45) NULL,
--  `puesto` VARCHAR(45) NULL,
--  `fecha_alta` DATE NULL,
--  `salario` INT NULL,
--  `comision` INT NULL,
--  `depto_nro` VARCHAR(12) NULL,
--  PRIMARY KEY (`cod_emp`),
  -- Index para optimizacion
--  INDEX `depto_nro_idx` (`depto_nro` ASC) VISIBLE,
--  CONSTRAINT `depto_nro`
--    FOREIGN KEY (`depto_nro`)
--    REFERENCES `empresa`.`departamento` (`depto_nro`)
--    ON DELETE NO ACTION
--    ON UPDATE NO ACTION);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) values ('D-000-1', 'Software', 'Los Tigres');
INSERT INTO departamento (depto_nro, nombre_depto, localidad) values ('D-000-2', 'Sistemas', 'Guadalupe');
INSERT INTO departamento (depto_nro, nombre_depto, localidad) values ('D-000-3', 'Contabilidad', 'La Roca');
INSERT INTO departamento (depto_nro, nombre_depto, localidad) values ('D-000-4', 'Ventas', 'Plata');

CREATE TABLE empleado(
	cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(30),
    fecha DATE,
    salario FLOAT,
    comision FLOAT DEFAULT 0,
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha, salario, comision, depto_nro) VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4');
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha, salario, comision, depto_nro) VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2');
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha, salario, comision, depto_nro) VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha, salario, comision, depto_nro) VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha, salario, comision, depto_nro) VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha, salario, comision, depto_nro) VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha, salario, comision, depto_nro) VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');