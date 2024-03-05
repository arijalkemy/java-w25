-- Ejercicio 3

INSERT INTO packs
VALUES
    (1, 100, 5000, 0),
    (2, 300, 12000, 10),
    (3, 500, 18000, 20),
    (4, 1000, 30000, 30),
    (5, 3000, 60000, 50);

INSERT INTO clients
VALUES
    (1, 00000000, 'Juan', 'Pérez', '1991-03-05', 'Buenos Aires', 'CABA', 2),
    (2, 11111111, 'Juan', 'Pérez', '1990-03-05', 'Buenos Aires', 'CABA', 3),
    (3, 22222222, 'Juan', 'Martinez', '1998-03-05', 'Buenos Aires', 'CABA', 1),
    (4, 33333333, 'Lucia', 'García', '1983-03-05', 'Mendoza', 'Mendoza', 4),
    (5, 44444444, 'Martín', 'Silva', '1990-03-05', 'Santa Fe', 'Rosario', 3),
    (6, 55555555, 'José', 'Pereira', '2003-03-05', 'Buenos Aires', 'CABA', 1),
    (7, 66666666, 'Vanina', 'Mendez', '2000-03-05', 'Buenos Aires', 'CABA', 2),
    (8, 77777777, 'Lourdes', 'David', '1994-03-05', 'Santa Fe', 'Santa Fe', 2),
    (9, 88888888, 'Renzo', 'Pérez', '1995-03-05', 'Buenos Aires', 'CABA', 3),
    (10, 99999999, 'Martina', 'Da Silva', '1997-03-05', 'Buenos Aires', 'CABA', 1);

-- Ejercicio 4

-- 1 Todos los clientes
SELECT *
FROM clients;

-- 2 Nombre y apellido de clientes que tengan el pack 3
SELECT first_name, last_name
FROM clients
WHERE pack_id = 3;

-- 3 Nombre y apellido de clientes que se apelliden 'Pérez'
SELECT first_name, last_name
FROM clients
WHERE last_name = 'Pérez';

-- 4 Nombre, apellido y pack de clientes nacidos en los '90
SELECT *
FROM clients
WHERE birthday BETWEEN '1990-01-01' AND '1999-12-31';

-- 5

-- 6

-- 7

-- 8

-- 9

-- 10
