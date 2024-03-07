use   empresa_internet;
CREATE TABLE `empresa_internet`.`planes` (
  `id_plan` INT NOT NULL,
  `velocidad` INT NULL,
  `precio` DECIMAL(8,2) NULL,
  `descuento` FLOAT NULL,
  PRIMARY KEY (`id_plan`));
  
CREATE TABLE `empresa_internet`.`cliente` (
  `id_cliente` INT NOT NULL,
  `dni` VARCHAR(25) NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `fecha_nacimiento` DATE NULL,
  `provincia` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  `id_plan` INT NULL,
  PRIMARY KEY (`id_cliente`),
  CONSTRAINT `id_plan`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `empresa_internet`.`planes` (`id_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
ALTER TABLE cliente ADD CONSTRAINT fk_grade_id FOREIGN KEY (id_plan) REFERENCES planes(id_plan);
    
Insert into cliente VALUES(1, "ioiioi", "nombre1", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(2, "ioiioi", "nombre2", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(3, "ioiioi", "nombre3", "apellido2", "2020-01-03", "p1", "c1", 2);
Insert into cliente VALUES(16, "ioiioi", "juan", "perez", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(15, "ioiioi", "juancho", "gutierrez", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(6, "ioiioi", "nombre6", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(7, "ioiioi", "nombre7", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(8, "ioiioi", "nombre8", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(91, "ioiioi", "nombre9", "apellido2", "2020-01-03", "Mendoza", "c1", 1);
Insert into cliente VALUES(120, "ioiioi", "nombre10", "apellido2", "2020-01-03", "Mendoza", "c1", 1);
Insert into planes VALUES(1, 1,2.5, 0.15);
Insert into planes VALUES(2, 2,2.5, 0.15);
Insert into planes VALUES(32, 3,11, 0.25);
Insert into planes VALUES(42, 4,2.5, 0.35);
Insert into planes VALUES(52, 5,45, 0.15);
# 1traer el nombre y el apellido de todos los clientes cuyo nombre empieze con juan
SELECT nombre, apellido FROM cliente where nombre LIKE "nombre%";
# 2sellecionar planes con descuente entre 0.20 y 0.50
SELECT * from planes where descuento between 0.2 and 0.5;
# 3seleccionar cliente por id
SELECT cliente_id as id, nombre, apellido from cliente where cliente_id= 1;
#4seleccionar todos los clientes de la provincia de mendoza
Select * from cliente where provincia = "mendoza";
#5seleccionar planes por rango de precios
SELECT * from planes where precio between 10 and 50;
#6 contar clientes que tengan el plan 1
select count(*) as cantidad_planes_contratados from cliente where id_plan =1;
#7 traer planes ordenados descendemente por precio
select * from planes order by precio DESC;
#8 traer todos los nombres distintos de clientes
select distinct nombre from cliente;
#9 traer todos los nombres que nacieron depues de enero
select  nombre from cliente where fecha_nacimiento >'2020-01-01';
#10 traer todos los nombres distintos de clientes
select distinct nombre from cliente;