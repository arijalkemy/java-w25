
# Eliminar y crear la base de datos y las tablas (con su respectiva asociasión)
DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE plan
(
    id        INT,
    velocidad INT,
    precio    FLOAT,
    descuento FLOAT,
    PRIMARY KEY (id)
);

CREATE TABLE clientes
(
    id         INT,
    nombre     VARCHAR(45),
    apellido   VARCHAR(45),
    cumpleaños DATE,
    provincia  VARCHAR(45),
    ciudad     VARCHAR(45),
    plan_id    INT DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (plan_id) REFERENCES plan (id)
);

# Insertar datos a las tablas incluyendo asociaciónes
INSERT INTO plan (id, velocidad, precio, descuento)
VALUES (1, 30, 29.99, 5),
       (2, 50, 39.99, 10),
       (3, 100, 49.99, 15),
       (4, 200, 59.99, 20),
       (5, 500, 79.99, 25);

INSERT INTO clientes (id, nombre, apellido, cumpleaños, provincia, ciudad)
VALUES ('123456789', 'Juan', 'Pérez', '1990-01-15', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires'),
       ('987654321', 'María', 'Gómez', '1985-05-20', 'Córdoba', 'Córdoba'),
       ('567890123', 'Carlos', 'Rodríguez', '1988-11-08', 'Mendoza', 'Mendoza'),
       ('345678901', 'Laura', 'Fernández', '1995-03-25', 'Santa Fe', 'Rosario'),
       ('789012345', 'Pedro', 'Martínez', '1980-09-10', 'Tucumán', 'San Miguel de Tucumán');

INSERT INTO clientes (id, nombre, apellido, cumpleaños, provincia, ciudad, plan_id)
VALUES ('234567890', 'Ana', 'López', '1992-07-18', 'Salta', 'Salta', 2),
       ('456789012', 'Diego', 'Sánchez', '1983-12-30', 'Entre Ríos', 'Paraná', 1),
       ('890123456', 'Carmen', 'García', '1998-06-05', 'Buenos Aires', 'La Plata', 3),
       ('012345678', 'Jorge', 'Ramírez', '1982-04-12', 'Neuquén', 'Neuquén', 3),
       ('678901234', 'Silvia', 'Díaz', '1993-08-28', 'San Juan', 'San Juan', 4);

# Queries de prueba
SELECT * FROM clientes WHERE cumpleaños BETWEEN '1983-01-01' AND '1995-01-01';
SELECT nombre FROM clientes WHERE plan_id IS NOT NULL;
SELECT COUNT(plan_id) AS 'Personas con plan 3' FROM clientes where plan_id = 3;
SELECT * FROM clientes WHERE provincia = 'Buenos Aires';
SELECT * FROM clientes WHERE cumpleaños > '1990-01-01';
SELECT * FROM clientes ORDER BY cumpleaños DESC;
SELECT * FROM clientes WHERE plan_id IS NULL;
SELECT * FROM clientes WHERE MONTH(cumpleaños) = 5;
SELECT * FROM clientes WHERE provincia IN ('Buenos Aires', 'Córdoba');
SELECT * FROM clientes WHERE apellido LIKE 'G%';
SELECT nombre, apellido, cumpleaños, TIMESTAMPDIFF(YEAR, cumpleaños, CURDATE()) AS edad
FROM clientes
WHERE MONTH(cumpleaños) = MONTH(CURDATE());


