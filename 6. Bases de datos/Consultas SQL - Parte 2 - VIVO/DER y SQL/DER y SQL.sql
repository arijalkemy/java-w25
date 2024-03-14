#Ejercicio 1
# Luego del planteo de los requerimientos de la empresa, se solicita modelar los mismos mediante un DER (Diagrama Entidad-Relación). ver imagen en directorio.

#Ejercicio 2
# Una vez modelada y planteada la base de datos, responder a las siguientes preguntas:

# a. ¿Cuál es la primary key para la tabla de clientes? Justificar respuesta
# El identificador único que se genera automáticamente al insertar registros, ya que el DNI en algunos casos puede estar repetido.

# b. ¿Cuál es la primary key para la tabla de planes de internet? Justificar respuesta.
# El identificador único de cada plan plan_id, se asegura que cada plan tiene uno diferente.

# c. ¿Cómo serían las relaciones entre tablas? ¿En qué tabla debería haber foreign key? ¿A qué campo de qué tabla hace referencia dicha foreign key? Justificar respuesta.
# Cliente: El cliente debe estar suscrito a un plan de Internet FK: plan_id.
# PlanInternet: El plan debe tener 0 ó muchos Clientes suscritos.

#Ejercicio 3
# Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, utilizar PHPMyAdmin o MySQL Workbench para ejecutar lo siguiente:

# Se solicita crear una nueva base de datos llamada “empresa_internet”.
# Realizar las asociaciones/relaciones correspondientes entre estos registros.
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE planInternet(
plan_id int,
velocidad_mb int,
precio float,
descuento float,
PRIMARY KEY(plan_id)
);

CREATE TABLE cliente(
cliente_id int NOT NULL AUTO_INCREMENT,
nombre VARCHAR(30),
apellido VARCHAR(30),
fecha_nacimiento DATE,
provincia VARCHAR(30),
ciudad VARCHAR(30),
plan_id INT,
PRIMARY KEY (cliente_id),
FOREIGN KEY (plan_id) REFERENCES planInternet(plan_id)
);

# Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
INSERT INTO planInternet(plan_id, velocidad_mb, precio, descuento) VALUES 
(001, 10, 30000.00, 5.0),
(002, 50, 45000.00, 4.0),
(003, 100, 60000.00, 3.5),
(004, 150, 75000.00, 2.0),
(005, 200, 90000.00, 1.0);

INSERT INTO cliente (nombre, apellido, fecha_nacimiento, provincia, ciudad, plan_id) VALUES
('Juan', 'Pérez', '1985-02-15', 'Buenos Aires', 'La Plata', 001),
('María', 'López', '1992-07-08', 'Santa Fe', 'Rosario', 002),
('Carlos', 'González', '1978-11-25', 'Córdoba', 'Córdoba', 003),
('Ana', 'Martínez', '1989-04-30', 'Mendoza', 'Mendoza', 004),
('Luis', 'Rodríguez', '1995-05-15', 'Tucumán', 'San Miguel de Tucumán', 005),
('Lucía', 'García', '1975-08-09', 'Chubut', 'Comodoro Rivadavia', 004),
('Fernando', 'Sánchez', '1983-01-22', 'Santa Cruz', 'Río Gallegos', 004),
('Sofía', 'Gómez', '1990-09-14', 'Entre Ríos', 'Paraná', 003),
('Miguel', 'Romero', '1970-12-12', 'Salta', 'Salta', 002),
('Elena', 'Fernández', '1982-03-03', 'La Pampa', 'Santa Rosa', 001);

#Ejercicio 4
# Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.

# 1. Listar todos los clientes.
SELECT nombre, apellido, fecha_nacimiento, provincia, ciudad, plan_id FROM cliente;

# 2. Listar todos los planes de internet.
SELECT plan_id, velocidad_mb, precio, descuento FROM planInternet;

# 3. Listar los clientes de la provincia Buenos Aires.
SELECT nombre, apellido FROM cliente WHERE provincia = "Buenos Aires";

# 4. Obtener el plan con mayor velocidad.
SELECT plan_id, velocidad_mb FROM planInternet ORDER BY precio DESC LIMIT 1;

# 5. Contar el número de clientes por plan de internet.
SELECT plan_id, COUNT(*) as total_clientes FROM cliente GROUP BY plan_id;

# 6. Calcular el precio final de cada plan después de aplicar el descuento.
SELECT plan_id, velocidad_mb, precio, descuento, (precio - (precio * (descuento / 100))) AS precio_final FROM planInternet;

# 7. Listar clientes nacidos después del año 1990.
SELECT * FROM cliente WHERE fecha_nacimiento > '1990-01-01';

# 8. Encontrar el plan de menor precio disponible.
SELECT plan_id, velocidad_mb FROM planInternet ORDER BY precio ASC LIMIT 1;

# 9. Encontrar el plan con mayor cantidad de clientes suscritos.
SELECT plan_id, COUNT(*) as total_clientes FROM cliente GROUP BY plan_id ORDER BY total_clientes DESC LIMIT 1;

# 10. Encontrar el plan con menor cantidad de clientes suscritos.
SELECT plan_id, COUNT(*) as total_clientes FROM cliente GROUP BY plan_id ORDER BY total_clientes ASC LIMIT 1;