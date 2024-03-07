-- Creacion base de datos y tablas
DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `dni` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `ciudad` varchar(255) NOT NULL,
  PRIMARY KEY (`dni`,`ciudad`)
) ;
DROP TABLE IF EXISTS `plan_internet`;
CREATE TABLE `plan_internet` (
  `id` int NOT NULL,
  `customer_id` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `velocidad` int NOT NULL,
  `precio` varchar(45) NOT NULL,
  `descuento` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `FK_CLIENTE_PLAN_INTERNET` FOREIGN KEY (`customer_id`) REFERENCES `cliente` (`dni`)
);

-- Ingreso datos
INSERT INTO cliente VALUES(1, "Luis", "Camacho", "1998-06-13", "California", "Bogota");
INSERT INTO cliente VALUES(2, "Mario", "Linares", "1998-12-13", "Cundinamarca", "Buenos Aires");
INSERT INTO cliente VALUES(3, "Andrea", "Martinez", "2001-07-15", "Cordoba", "Buenos Aires");
INSERT INTO cliente VALUES(4, "Laura", "Gomez", "2000-03-17", "California", "Buenos Aires");
INSERT INTO cliente VALUES(5, "Diego", "Pachon", "1996-05-25", "Cundinamarca", "Cali");
INSERT INTO cliente VALUES(6, "Lis", "Camaho", "1989-07-23", "Cordoba", "Buenos Aires");
INSERT INTO cliente VALUES(7, "Lucia", "Caacho", "1987-11-19", "California", "Bogota");
INSERT INTO cliente VALUES(8, "Ana", "Lopez", "1978-08-14", "California", "Cali");
INSERT INTO cliente VALUES(9, "Pedro", "Cmacho", "1989-03-22", "Cordoba", "Buenos Aires");
INSERT INTO cliente VALUES(10, "Carla", "Camcho", "1999-01-11", "Cundinamarca", "Cali");
INSERT INTO cliente VALUES(11, "Juan", "Aamacho", "1993-02-14", "Cundinamarca", "Bogota");

INSERT INTO plan_internet VALUES(1,1,"plan1",500,500.50,10);
INSERT INTO plan_internet VALUES(2,1,"plan2",1000,700.25,15);
INSERT INTO plan_internet VALUES(3,4,"plan3",1500,900.75,20);
INSERT INTO plan_internet VALUES(4,2,"plan1",700,600.00,12);
INSERT INTO plan_internet VALUES(5,5,"plan1",2000,1200.00,25);

-- Consultas
-- Clientes de Cali
SELECT dni as DNI, concat(nombre, " ", apellido) as Nombre, ciudad as Ciudad FROM cliente WHERE ciudad="Cali";
-- Clientes mas jovenes (5)
SELECT concat(nombre, " ", apellido) as Nombre, fecha_nacimiento as "Fecha Nacimiento" FROM cliente ORDER BY fecha_nacimiento DESC LIMIT 5;
-- Mostrar del plan mas caro al mas barato (3)
SELECT * FROM plan_internet ORDER BY CAST(precio AS DECIMAL(10,2)) DESC LIMIT 3;
-- Cuantos clientes hay en cada provincia
SELECT provincia as Provincia, COUNT(*) as "Numero Clientes" FROM cliente GROUP BY provincia;
-- Clientes que tienen un descuento superior al 15%
SELECT c.dni as DNI, concat(c.nombre, " ", c.apellido) as Nombre, p.descuento as Descuento 
FROM cliente c JOIN plan_internet p ON c.dni = p.customer_id
WHERE p.descuento>15;
-- Calcular el promedio de velocidad ofrecida por cada plan de Internet
SELECT nombre as Plan, AVG(velocidad) as "Promedio de Velocidad" FROM plan_internet GROUP BY nombre;
-- Encontrar los clientes cuyo nombre comienza con "L"
SELECT dni as DNI, concat(nombre, " ", apellido) as Nombre FROM cliente WHERE nombre LIKE "L%";
-- Ordenar los clientes por fecha de nacimiento en orden acendente:
SELECT concat(nombre, " ", apellido) as Nombre, fecha_nacimiento as "Fecha Nacimiento" FROM cliente ORDER BY fecha_nacimiento ASC;
-- Calcular la suma total de descuentos aplicados en todos los planes de Internet
SELECT sum(descuento) as "Suma Descuentos" FROM plan_internet;
-- Encontrar los clientes que tienen un plan de Internet con una velocidad superior a 1000
SELECT c.dni as DNI, concat(c.nombre, " ", c.apellido) as Nombre, p.velocidad as "Velocidad Plan" 
FROM cliente c JOIN plan_internet p ON c.dni = p.customer_id
WHERE p.velocidad>1000;
