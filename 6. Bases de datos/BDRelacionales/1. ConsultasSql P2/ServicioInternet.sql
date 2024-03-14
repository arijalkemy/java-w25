-- Usar la base de datos
USE servicio_internet;

-- Poblar la tabla cliente
INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES
    (12345678, 'Juan', 'Pérez', '1980-05-10', 'Madrid', 'Madrid'),
    (23456789, 'María', 'López', '1992-11-25', 'Barcelona', 'Barcelona'),
    (34567890, 'Carlos', 'García', '1975-08-15', 'Valencia', 'Valencia'),
    (45678901, 'Ana', 'Martínez', '1988-03-03', 'Sevilla', 'Sevilla'),
    (56789012, 'Javier', 'Ruiz', '1995-07-20', 'Málaga', 'Málaga'),
    (67890123, 'Laura', 'González', '1983-12-18', 'Alicante', 'Alicante'),
    (78901234, 'David', 'Fernández', '1970-09-05', 'Zaragoza', 'Zaragoza'),
    (89012345, 'Marta', 'Sánchez', '1990-04-30', 'Murcia', 'Murcia'),
    (90123456, 'Pablo', 'Díaz', '1986-06-12', 'Granada', 'Granada'),
    (01234567, 'Carmen', 'Jiménez', '1978-02-28', 'Tenerife', 'Santa Cruz');
    
-- Poblar la tabla plan_internet
INSERT INTO plan_internet (id, customer_id, nombre, velocidad, precio, descuento)
VALUES
    (1, 12345678, 'Internet Básico', 20, 29.99, 0.00),
    (2, 23456789, 'Internet Premium', 50, 49.99, 5.00),
    (3, 34567890, 'Internet Ultra', 100, 69.99, 10.00),
    (4, 45678901, 'Internet Básico', 20, 29.99, 0.00),
    (5, 56789012, 'Internet Premium', 50, 49.99, 5.00),
    (6, 67890123, 'Internet Ultra', 100, 69.99, 10.00),
    (7, 78901234, 'Internet Básico', 20, 29.99, 0.00),
    (8, 89012345, 'Internet Premium', 50, 49.99, 5.00),
    (9, 90123456, 'Internet Ultra', 100, 69.99, 10.00),
    (10, 01234567, 'Internet Básico', 20, 29.99, 0.00);

-- CONSULTAS

-- 1 Obetener los clientes que hayan nacido antes de 1990
SELECT nombre, apellido, fecha_nacimiento 
FROM cliente
WHERE fecha_nacimiento < '1990-01-01';

-- 2 Obtener los cliente que hayan nacido despues de 1990

SELECT nombre, apellido, fecha_nacimiento 
FROM cliente
WHERE fecha_nacimiento < '1990-01-01';

-- 3 Obtener los clientes organizados por fecha de nacimiento y por nombre

SELECT nombre, apellido, fecha_nacimiento 
FROM cliente
ORDER BY fecha_nacimiento, nombre;

-- 4 Obtener los servicios del plan de internet "Internet Básico"

SELECT *
FROM plan_internet
WHERE nombre LIKE "Internet Básico";

-- 5 Obtener los planes de internet con un descuento mayor a 5.00

SELECT id, nombre, descuento
FROM plan_internet
WHERE descuento > 5.00;

-- 6 Obtener los planes de internet que no sean "Internet Ultra"

SELECT id, nombre
FROM plan_internet
WHERE nombre NOT LIKE "Internet Ultra";

-- 7 Obtener los planes de internet que con un precion mayor a 50

SELECT customer_id,id, nombre, precio
FROM plan_internet
WHERE precio > 50;
-- 8 Obtener los planes de internes con un precio menor a 50 ordenado por nombre

SELECT customer_id,id, nombre, precio
FROM plan_internet
WHERE precio < 50
ORDER BY nombre;

-- 9 Obtener el plan de internet del cliente 23456789

SELECT customer_id, id, nombre
FROM plan_internet
WHERE customer_id = 23456789;

-- 10 Obtener los cliente que el nombre finaliza con a ordenado por el nombre ASC

SELECT dni, nombre, apellido
FROM cliente
WHERE nombre LIKE "%a"
ORDER BY nombre ASC;
