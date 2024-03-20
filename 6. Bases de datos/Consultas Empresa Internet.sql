
# A. La primary key para la tabla clientes es id_cliente, porque, se crea autoincrementable para evitar duplicidad en el campo
#	y asi asegurarnos que cada cliente tenga un ID unico y sea distinto

# B. La primary key para la tabla plan es id_plan, porque, se crea autoincrementable para evitar duplicidad en el campo
#	y asi asegurarnos que cada plan tenga un ID unico y sea distino

# C. Declaramos una relación de muchos a muchos, añadiendo una tabla intermedia "planXCliente", para establecer una relación de muchos a muchos, donde muchos clientes pueden tener muchos planes

# D. En la tabla intermedia

# E. El campo id_cliente, hace referencia a la tabla cliente al campo id_cliente, y el id_plan desde la tabla plan del campo id_plan 

DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE cliente(
	id_cliente INT PRIMARY KEY,
	documento VARCHAR(16),
	nombre	VARCHAR(100),
	apellido VARCHAR(100),
	fecha_nacimiento DATE,
	provincia VARCHAR(50),
	ciudad VARCHAR(50),
	
);

CREATE TABLE plan(
	id_plan INT PRIMARY KEY,
	velocidad INT,
	precio DECIMAL(2),
	descuento DECIMAL(2)
);

CREATE TABLE planXCliente(
	id_planXcliente INT PRIMARY KEY,
	id_cliente INT,
	id_plan INT,
	FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
	FOREIGN KEY (id_plan) REFERENCES plan(id_plan)
);


INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");
INSERT INTO cliente  VALUES(null, "123", "Pepe", "Sanchez", "1997-05-10", "Mendoza", "Mendoza");

Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, utilizar PHPMyAdmin o MySQL Workbench para ejecutar lo siguiente:

Se solicita crear una nueva base de datos llamada “empresa_internet”.
Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
Realizar las asociaciones/relaciones correspondientes entre estos registros.

 Ejercicio 4

Plantear 10 consultas SQL que se podrían realizar a la base de datos. Expresar las sentencias.



