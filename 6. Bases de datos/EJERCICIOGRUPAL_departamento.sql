CREATE DATABASE `empresa`;

CREATE TABLE `empresa`.`departamento` (
    `depto_nro` VARCHAR(10) NOT NULL,
    `nombre_depto` VARCHAR(45) NULL,
    `localidad` VARCHAR(45) NULL,
    PRIMARY KEY (`depto_nro`)
);
CREATE TABLE `empresa`.`empleado` (
  `cod_emp` VARCHAR(12) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `puesto` VARCHAR(45) NULL,
  `fecha_alta` DATE NULL,
  `salario` INT NULL,
  `comision` INT NULL,
  `depto_nro` VARCHAR(12) NULL,
  PRIMARY KEY (`cod_emp`),
  INDEX `depto_nro_idx` (`depto_nro` ASC) VISIBLE,
  CONSTRAINT `depto_nro`
    FOREIGN KEY (`depto_nro`)
    REFERENCES `empresa`.`departamento` (`depto_nro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
insert into empresa.departamento values ('D-000-1','Sofrware','Los tigres');
insert into empresa.departamento values ('D-000-2','Sistemas','Guadalupe');
insert into empresa.departamento values ('D-000-3','Contabilidad','La roca');
insert into empresa.departamento values ('D-000-4','Ventas','Plata');
insert into empresa.empleado values ('E-0001','Cesar','Piñero','Vendedor','2018-05-12',80000,15000,'D-000-4');
insert into empresa.empleado values ('E-0002','Yosep','Kowaleski','Analista','2015-07-14',140000,0,'D-000-2');
insert into empresa.empleado values ('E-0003','Mariela','Barrios','Director','2014-06-05',185000,0,'D-000-3');
insert into empresa.empleado values ('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03',85000,10000,'D-000-4');
insert into empresa.empleado values ('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03',80000,10000,'D-000-4');
insert into empresa.empleado values ('E-0006','Mito','Barchuck','Presidente','2014-06-05',190000,0,'D-000-3');
insert into empresa.empleado values ('E-0007','Pepe','Galarza','Desarrollador','2014-08-02',80000,0,'D-000-1');

USE empresa;
#1 Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro;
#2 Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(*) AS total FROM departamento d JOIN empleado e ON e.depto_nro = d.depto_nro GROUP BY d.nombre_depto HAVING COUNT(*) > 5;
#3 Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre LIKE "%Mito%" AND apellido LIKE "%Barchuck%");
#4 Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* FROM empleado e JOIN departamento d ON d.depto_nro = e. depto_nro WHERE d.nombre_depto = "Contabilidad" ORDER BY e.nombre ASC;
#5 Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre, apellido, salario FROM empleado ORDER BY salario, nombre LIMIT 1;
SELECT nombre, salario FROM empleado WHERE salario = (SELECT MIN(salario) FROM empleado);
#6 Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.* FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro WHERE e.salario = (SELECT MAX(e.salario) FROM empleado e JOIN departamento d ON d.nombre_depto = "Ventas" AND e.depto_nro = d.depto_nro);

