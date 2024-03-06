/*************************************************CREAR BD************************************************/

CREATE DATABASE proveedora_internet;

USE proveedora_internet;

CREATE TABLE provincias(
    id_provincia INT NOT NULL PRIMARY KEY,
    nombre VARCHAR(255),
    fecha_alta DATE
);

CREATE TABLE ciudades(
    id_ciudad INT NOT NULL PRIMARY KEY,
    id_provincia INT,
    nombre VARCHAR(255),
    fecha_alta DATE,
    FOREIGN KEY (id_provincia) REFERENCES provincias(id_provincia)
);

CREATE TABLE planes(
    id_plan INT NOT NULL PRIMARY KEY,
    megas INT,
    precio DECIMAL(18,2),
    descuento DECIMAL(18,2),
    fecha_alta DATETIME,
    fecha_ult_act DATETIME
);

CREATE TABLE clientes(
    id_cliente INT NOT NULL PRIMARY KEY,
    dni VARCHAR(255),
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    fecha_nac DATE,
    id_ciudad INT,
    fecha_alta DATETIME,
    fecha_ult_act DATETIME,
    id_plan INT,
    FOREIGN KEY (id_ciudad) REFERENCES ciudades(id_ciudad),
    FOREIGN KEY (id_plan) REFERENCES planes(id_plan)
);

/*************************************************RESPUESTAS************************************************/

/*
a. la PK para la tabla de clientes es "id_cliente". sirve para garantizar que cada registro se puede 
identificar de manera única.

b. la PK para la tabla de planes de internet es "id_plan". similar a la explicación anterior 
para "id_cliente", "id_plan" sirve para identificar de manera única cada plan de internet.

c. en la tabla "ciudades", "id_provincia" sería la FK que hace referencia a "id_provincia" en la tabla "provincias" 
(cada ciudad pertenece a una provincia)

en la tabla "clientes", tendríamos dos FK, "id_ciudad" e "id_plan". "id_ciudad" se refiere a "id_ciudad" 
en la tabla "ciudades", estableciendo así donde vive cada cliente. mientras que "id_plan" se refiere a "id_plan" en 
la tabla "planes", representando el plan de internet que cada cliente ha suscrito.
*/

/*************************************************REGISTROS************************************************/

INSERT INTO provincias (id_provincia, nombre, fecha_alta)
VALUES 
    (4, 'Buenos Aires', '2024-02-14'),
    (5, 'Córdoba', '2024-02-14'),
    (6, 'Santa Fe', '2024-02-14'),
    (7, 'Mendoza', '2024-02-14'),
    (8, 'Tucumán', '2024-02-14');

INSERT INTO ciudades (id_ciudad, id_provincia, nombre, fecha_alta)
VALUES 
    (6, 4, 'La Plata', '2024-02-14'),
    (7, 4, 'Mar del Plata', '2024-02-14'),
    (8, 5, 'Córdoba', '2024-02-14'),
    (9, 5, 'Villa María', '2024-02-14'),
    (10, 6, 'Rosario', '2024-02-14'),
    (11, 6, 'Santa Fe', '2024-02-14'),
    (12, 7, 'Mendoza', '2024-02-14'),
    (13, 7, 'San Rafael', '2024-02-14'),
    (14, 8, 'San Miguel de Tucumán', '2024-02-14'),
    (15, 8, 'San Salvador de Jujuy', '2024-02-14');
    
INSERT INTO planes (id_plan, megas, precio, descuento, fecha_alta, fecha_ult_act)
VALUES 
    (1, 100, 50.00, 5.00, '2024-02-14 00:00:00', '2024-02-14 00:00:00'),
    (2, 200, 75.00, 7.50, '2024-02-14 00:00:00', '2024-02-14 00:00:00'),
    (3, 300, 100.00, 10.00, '2024-02-14 00:00:00', '2024-02-14 00:00:00'),
    (4, 400, 125.00, 12.50, '2024-02-14 00:00:00', '2024-02-14 00:00:00'),
    (5, 500, 150.00, 15.00, '2024-02-14 00:00:00', '2024-02-14 00:00:00');

INSERT INTO clientes (id_cliente, dni, nombre, apellido, fecha_nac, id_ciudad, fecha_alta, fecha_ult_act, id_plan)
VALUES 
    (11, '45244599', 'Juan', 'Pérez', '1990-01-01', 6, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 1),
    (12, '17923460', 'Mariano', 'González', '1995-02-02', 7, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 2),
    (13, '45048711', 'Lucía', 'Martínez', '2000-03-03', 8, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 3),
    (14, '24692455', 'Martín', 'Sánchez', '1985-04-04', 9, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 4),
    (15, '67890023', 'Laura', 'López', '1992-05-05', 10, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 5),
	(16, '45244599', 'Juanito', 'Peresiano', '1990-01-01', 11, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 1),
    (17, '17923460', 'Marianito', 'Gonsalba', '1995-02-02', 12, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 2),
    (18, '45048711', 'Lusia', 'Martinelis', '2000-03-03', 13, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 3),
    (19, '24692455', 'Martincho', 'Sanchopolis', '1985-04-04', 14, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 4),
    (20, '67890023', 'Laureano', 'Lopez Rega', '1992-05-05', 15, '2024-02-14 00:00:00', '2024-02-14 00:00:00', 5);
    
/*************************************************CONSULTAS************************************************/

SELECT * FROM clientes;

SELECT nombre, apellido, fecha_nac
FROM clientes
WHERE id_ciudad = 1;

SELECT nombre FROM provincias ORDER BY nombre;

SELECT * FROM clientes
WHERE nombre LIKE 'C%'
ORDER BY fecha_alta DESC;

SELECT * FROM planes
WHERE megas >= 300 AND precio > 100;

SELECT * FROM clientes
WHERE fecha_nac BETWEEN '1990-01-01' AND '1995-02-02'
ORDER BY fecha_nac;

SELECT * FROM planes ORDER BY precio DESC LIMIT 3;

SELECT DISTINCT nombre FROM clientes;

SELECT COUNT(*) AS total_clientes FROM clientes;

SELECT MAX(precio) AS precio_maximo, MIN(precio) AS precio_minimo FROM planes;

SELECT SUM(megas) AS total_megas FROM planes;

SELECT AVG(megas) AS promedio_megas FROM planes;



