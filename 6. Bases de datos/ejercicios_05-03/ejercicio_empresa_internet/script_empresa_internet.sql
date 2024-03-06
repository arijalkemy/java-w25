SHOW databases;

USE empresa_internet; 


# Creo los planes de internet
INSERT INTO plan_internet (velocidad, precio, descuento)
VALUES 
(50, 30.0, 0.4),
(500, 300.0, 0.2),
(450, 301.0, 0.5),
(98, 50.0, 0.0);


# Creo los clientes
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES 
('11111', 'Carlos', 'Lopez', '2000-01-14', 'Mendoza', 'Mendoza'),
('22222', 'Juan', 'Alcaraz', '2001-01-14', 'Buenos Aires', 'La Plata'),
('33333', 'Francisco', 'Gomez', '2002-01-14', 'Buenos Aires', 'La Plata'),
('44444', 'Julian', 'Lopez', '2003-01-14', 'Buenos Aires', 'La Plata'),
('55555', 'Victoria', 'Alcaraz', '1999-01-14', 'Buenos Aires', 'La Plata'),
('66666', 'Damian', 'Dao', '2010-01-14', 'Chubut', 'Rawson'),
('77777', 'Carlos', 'Gomez', '2009-01-14', 'Chubut', 'Rawson'),
('88888', 'Carlos', 'Alcaraz', '2003-01-14', 'Buenos Aires', 'La Plata'),
('99999', 'Jorge', 'Gomez', '2002-01-14', 'Mendoza', 'Mendoza'),
('10101', 'Sergio', 'Lopez', '2002-01-14', 'Mendoza', 'Mendoza');

# Creo los planes para los clientes

INSERT INTO cliente_plan (id_cliente, id_plan_internet) 
VALUES
(1, 3),
(2, 4),
(3, 1),
(4, 3),
(5, 1),
(6, 2),
(7, 4);



# Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

# 1 -  Obtener el nombre y el apellido de todos los clientes 
SELECT nombre, apellido
FROM cliente c;

# 2 - Encontrar los planes de internet con un descuento superior al 10%.
SELECT  descuento 
FROM plan_internet
WHERE descuento > 0.1;

# 3 -  Obtener nombre y apellido de clientes que residen en la provincia de Buenos Aires.
SELECT nombre, apellido 
FROM cliente c 
WHERE provincia = 'Buenos Aires';

# 4 - Obtener la suma total de los precios de los planes de internet en la base de datos.
SELECT SUM(precio)
FROM plan_internet;

# 5 - Obtener la cantidad total de clientes registrados en la base de datos.
SELECT COUNT(*)
FROM cliente c;

# 6 - Encontrar los clientes cuyo apellido comienza con la letra "G".
SELECT nombre, apellido
FROM cliente c 
WHERE apellido LIKE 'G%';

# 7 - Encontrar el id delos planes de internet con una velocidad superior al 100 Mbps.
SELECT id_plan_internet 
FROM plan_internet 
WHERE velocidad > 100;

# 8 - Encontrar los clientes que tienen contratado el plan de internet con la identificación "3".
SELECT nombre, apellido 
FROM cliente c INNER JOIN cliente_plan cp ON c.id_cliente = cp.id_cliente
WHERE cp.id_plan_internet = 3;

# 9 - Encontrar los clientes que tienen contratado un plan de internet con una velocidad ofrecida superior a 100 Mbps.
SELECT nombre, apellido, velocidad
FROM cliente c
INNER JOIN cliente_plan cp ON c.id_cliente = cp.id_cliente 
INNER JOIN plan_internet pi2 ON cp.id_plan_internet = pi2.id_plan_internet
WHERE velocidad > 100;

# 10 - Obtener nombre, apellido, velocidad y precio de todos los planes.
SELECT nombre, apellido, velocidad, precio
FROM cliente c 
INNER JOIN cliente_plan cp ON c.id_cliente = cp.id_cliente 
INNER JOIN plan_internet pi2 ON cp.id_plan_internet = pi2.id_plan_internet;
