#Crear y usar base de datos
CREATE DATABASE IF NOT EXISTS internet_db;
USE internet_db;

#Creación de tablas
CREATE TABLE IF NOT EXISTS plan_internet (
	id_plan VARCHAR(10) NOT NULL,
    speed INT NOT NULL,
    price FLOAT NOT NULL,
    discount INT NOT NULL,
	PRIMARY KEY (id_plan)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS clientes (
	dni VARCHAR(15) NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    birthdate DATE NOT NULL,
	province VARCHAR(45) NOT NULL,
    city VARCHAR(45) NOT NULL,
    PRIMARY KEY (dni),
    plan_internet_plan_id VARCHAR(10) NOT NULL,
		CONSTRAINT fkcliente_plan_internet
		FOREIGN KEY (plan_internet_plan_id)
		REFERENCES plan_internet (id_plan)
)ENGINE=INNODB;
show tables;
#DELETE FROM clientes;
#DELETE FROM plan_internet;
#DROP TABLE clientes;
#DROP TABLE plan_internet;

#Insertar datos
INSERT INTO plan_internet (id_plan, speed, price, discount)
VALUES
  (1, 30, 29.99, 5),
  (2, 50, 39.99, 10),
  (3, 100, 49.99, 15),
  (4, 200, 59.99, 20),
  (5, 500, 79.99, 25);
  
INSERT INTO clientes (dni, first_name, last_name, birthdate, province, city, plan_internet_plan_id)
VALUES
  ('123456789', 'Juan', 'Pérez', '1990-01-15', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires','3'),
  ('987654321', 'María', 'Gómez', '1985-05-20', 'Córdoba', 'Córdoba','5'),
  ('567890123', 'Carlos', 'Rodríguez', '1988-11-08', 'Mendoza', 'Mendoza','2'),
  ('345678901', 'Laura', 'Fernández', '1995-03-25', 'Santa Fe', 'Rosario','1'),
  ('789012345', 'Pedro', 'Martínez', '1980-09-10', 'Tucumán', 'San Miguel de Tucumán','2'),
  ('234567890', 'Ana', 'López', '1992-07-18', 'Salta', 'Salta','4'),
  ('456789012', 'Diego', 'Sánchez', '1983-12-30', 'Entre Ríos', 'Paraná','4'),
  ('890123456', 'Carmen', 'García', '1998-06-05', 'Buenos Aires', 'La Plata','3'),
  ('012345678', 'Jorge', 'Ramírez', '1982-04-12', 'Neuquén', 'Neuquén','2'),
  ('678901234', 'Silvia', 'Díaz', '1993-08-28', 'San Juan', 'San Juan','5');

#Consultas SQL
#Traer el nombre y apellido de los clientes que tengan contratado el plan de 100MG contratados
SELECT first_name AS 'Nombre', last_name 'Apellido'
FROM clientes c INNER JOIN plan_internet p
ON c.plan_internet_plan_id = p.id_plan
WHERE p.speed = 100;

#Total de clientes que cuentan con un plan con un precio mayor a $45.00
SELECT COUNT(*) AS 'Total clientes'
FROM clientes c INNER JOIN plan_internet p
ON c.plan_internet_plan_id = p.id_plan
WHERE p.price > 45.00;

#Traer la velocidad y el precio de los planes contratados por clientes de la provincia de Buenos Aires
SELECT speed AS 'Velocidad', price AS 'Precio'
FROM plan_internet p INNER JOIN clientes c
ON c.plan_internet_plan_id = p.id_plan
WHERE c.province = 'Buenos Aires';

#Traer el nombre, apellido y ciudad de los clientes nacidos después de 1991 y ordenarlo por el nombre
SELECT first_name AS 'Nombre', last_name 'Apellido', city AS 'Ciudad'
FROM clientes
WHERE birthdate > '1991-01-01'
ORDER BY first_name;

#Total de clientes que cuentan con un plan con un descuento menor o igual a 20
SELECT COUNT(*) AS 'Total clientes'
FROM clientes c INNER JOIN plan_internet p
ON c.plan_internet_plan_id = p.id_plan
WHERE p.discount >= 20.00;

#Total de clientes por plan
SELECT COUNT(*) AS 'Total clientes', plan_internet_plan_id AS 'Id del plan'
FROM clientes
GROUP BY plan_internet_plan_id;

#Mostrar el total de clientes por plan nacidos después de 1990
SELECT COUNT(*) AS 'Total clientes', plan_internet_plan_id AS 'Id del plan'
FROM clientes
WHERE birthdate > '1990-01-01'
GROUP BY plan_internet_plan_id;
