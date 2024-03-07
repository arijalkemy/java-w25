CREATE DATABASE `empresa`;
USE empresa;

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
insert into empresa.empleado values ('E-0003','Mariela','PBarrios','Director','2014-06-05',185000,0,'D-000-3');
insert into empresa.empleado values ('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03',85000,10000,'D-000-4');
insert into empresa.empleado values ('E-0005','Daniel','Brezezicki','Vendedor','2018-03-03',82000,10000,'D-000-4');
insert into empresa.empleado values ('E-0006','Mito','Barchuck','Presidente','2014-06-05',190000,0,'D-000-3');
insert into empresa.empleado values ('E-0007','Emilio','Galarza','Desarrollador','2014-08-02',60000,0,'D-000-1');