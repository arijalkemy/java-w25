# Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.

INSERT INTO empresa_internet.cliente
	(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES
	('001', 'Juan', 'Gómez', '2000-10-10', 'Amazonas', 'Leticia'),
	('002', 'Julian', 'Ríos', '1998-01-01', 'Antioquia', 'Medellin'),
	('003', 'Mariana', 'Bedoya', '1990-11-11', 'Bogotá D.C.', 'Bogotá D.C.'),
	('004', 'Maria', 'Bedoya', '1990-11-11', 'Bogotá D.C.', 'Bogotá D.C.'),
	('005', 'Martina', 'Bedoya', '1990-11-11', 'Bogotá D.C.', 'Bogotá D.C.'),
	('006', 'Mario', 'Bedoya', '1990-11-11', 'Bogotá D.C.', 'Bogotá D.C.'),
	('007', 'Mar', 'Bedoya', '1990-11-11', 'Bogotá D.C.', 'Bogotá D.C.'),
	('008', 'Ana', 'Bedoya', '1990-11-11', 'Bogotá D.C.', 'Bogotá D.C.'),
	('009', 'Juliana', 'Ríos Almanza', '1998-01-01', 'Antioquia', 'Medellín'),
	('010', 'Julian', 'Ríos', '1998-01-01', 'Antioquia', 'Medellín');
	
INSERT INTO empresa_internet.plan_internet
	(velocidad, precio, descuento, cliente_id)
VALUES
	(200, 100000.0, 10, 1),
	(300, 150000.0, 20, 2),
	(400, 200000.0, 22, 3),
	(500, 250000.0, 24, 4),
	(500, 250000.0, 24, 5);

# Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

# 1. Traer los datos de los clientes y ordenarlos según provincia y ciudad

SELECT
	nombre,
	apellido,
	dni,
	provincia,
	ciudad
FROM
	cliente
ORDER BY
	provincia,
	ciudad;

# 2. Listar el número de clientes en Bogotá D.C.
SELECT
	nombre,
	apellido,
	dni,
	provincia,
	ciudad
FROM
	cliente
WHERE
	ciudad = 'Bogotá D.C.';

# 3. Contar el número de clientes en Bogotá D.C.
SELECT
	COUNT(ciudad)
FROM
	cliente
WHERE
	ciudad = 'Bogotá D.C.'
GROUP BY
	ciudad ;

# 4. Traer los datos de los planes y ordenarlos según velocidad y precio

SELECT
	velocidad, precio, descuento 
FROM
	plan_internet
ORDER BY
	precio,
	descuento;

# 5. Listar el número de planes que tengan 400 MB o más
SELECT
	velocidad, precio, descuento 
FROM
	plan_internet
WHERE 
	velocidad >= 400
ORDER BY
	precio,
	descuento;

# 6. Contar el número de planes de mayores o iguales a 400 MB
SELECT
	COUNT(*)
FROM
	plan_internet
WHERE
	velocidad >= 400;

# 7. Traer los datos de los planes y calcular el promedio del precio y precio total de los planes

SELECT
	AVG(precio) AS promedio,
	SUM(precio) AS total
FROM
	plan_internet;

# 8. Listar el número de planes que estén en Bogotá D.C.
SELECT
	pi.velocidad,
	pi.precio,
	pi.descuento,
	c.ciudad
FROM
	plan_internet pi
INNER JOIN cliente c ON
	pi.cliente_id = c.id
WHERE
	c.ciudad LIKE 'Bogotá%'
ORDER BY
	precio,
	descuento;
	
# 9. Listar los clientes cuya fecha de nacimiento sea del año 1995 o superior.
SELECT 
	nombre,
	apellido,
	fecha_nacimiento
FROM
	cliente c
WHERE
	YEAR(fecha_nacimiento) >= 1995;

# 10. Listar los clientes cuya fecha de nacimiento sea inferior a 1995.
SELECT 
	nombre,
	apellido,
	fecha_nacimiento
FROM
	cliente c
WHERE NOT YEAR(fecha_nacimiento) >= 1995;
