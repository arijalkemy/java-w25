CREATE DATABASE IF NOT EXISTS `empresa`;

CREATE TABLE IF NOT EXISTS `empresa`.`departamento` (
    `depto_nro` VARCHAR(10) NOT NULL,
    `nombre_depto` VARCHAR(45) NULL,
    `localidad` VARCHAR(45) NULL,
    PRIMARY KEY (`depto_nro`)
);
CREATE TABLE IF NOT EXISTS `empresa`.`empleado` (
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
insert into empresa.empleado values ('E-0003','Mariela','PBarrios','Director','2014-06-05',185000,0,'D-000-3');
insert into empresa.empleado values ('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03',85000,10000,'D-000-4');
insert into empresa.empleado values ('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03',82000,10000,'D-000-4');
insert into empresa.empleado values ('E-0006','Mito','Barchuck','Presidente','2014-06-05',190000,0,'D-000-3');
insert into empresa.empleado values ('E-0007','Emilio','Galarza','Desarrollador','2014-08-02',60000,0,'D-000-1');

USE empresa;
-- 1
SELECT e.nombre , e.puesto, dep.localidad FROM empleado e JOIN departamento dep 
WHERE dep.depto_nro = e.depto_nro;
-- 2
SELECT * FROM departamento dep 
WHERE dep.depto_nro in (select depto_nro FROM empleado GROUP BY depto_nro HAVING count(*)>=2);
-- 3 mismos puestos que DANIEL
SELECT e.nombre, e.salario, dep.nombre_depto FROM empleado e JOIN departamento dep
ON dep.depto_nro=e.depto_nro
WHERE puesto=(
		SELECT puesto FROM empleado 
		WHERE nombre="Daniel" AND apellido="Brezezicki");
-- 3.bis
SELECT e.nombre, e.salario, d.nombre_depto FROM empleado AS e
INNER JOIN departamento d 
ON d.depto_nro=e.depto_nro
WHERE e.puesto = (
	SELECT puesto FROM empleado
    WHERE nombre='Daniel' AND apellido='Brezezicki'
);
-- 4
SELECT e.*, dep.nombre_depto FROM empleado e JOIN departamento dep ON dep.depto_nro = e.depto_nro
WHERE "Contabilidad"=dep.nombre_depto;
-- 5
SELECT nombre FROM empleado ORDER BY salario LIMIT 1;
-- 6
SELECT * FROM empleado e JOIN departamento dep ON dep.depto_nro = e.depto_nro
WHERE "Ventas"=dep.nombre_depto ORDER BY e.salario DESC LIMIT 1;

