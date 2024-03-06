CREATE SCHEMA `empresa_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;

-- Crear la base de datos "empresa" (si aún no existe)
CREATE DATABASE IF NOT EXISTS empresa_db;

-- Usar la base de datos "empresa"
USE empresa_db;

-- Tabla DEPARTAMENTO
CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50) NOT NULL,
    localidad VARCHAR(50) NOT NULL
);

-- Tabla EMPLEADO
CREATE TABLE empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario INT,
    comision INT,
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

-- Código DML Departamento
INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES 
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');


-- Código DML Empleado
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor','2018-05-12',80000,15000,'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista','2015-07-14',140000,0,'D-000-2'),
('E-0003', 'Mariela','Barrios','Director','2014-06-05',185000,0,'D-000-3'),
('E-0004 ','Jonathan ','Aguilera ','Vendedor ','2015-06-03',85000,10000,'D-000-4'),
('E-0005 ','Daniel ','Brezezicki ','Vendedor ','2018-03-03',83000,10000,'D-000-4'),
('E-0006 ','Mito','Barchuk','Presidente','2014–06–05',190000,0,'D–0003'),
('E–0007' ,'Emilio' ,'Galarza' ,'Desarrollador','2014–08–02',60000,0,'D–000-1');