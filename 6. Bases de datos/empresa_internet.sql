CREATE DATABASE empresa_internet;

USE empresa_internet;

CREATE TABLE clientes( 
	id_cliente INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dni INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE ,
    provincia VARCHAR(50),
    ciudad VARCHAR(50)
);

CREATE TABLE planes(
	id_plan INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    velocidad INT NOT NULL,
	precio DOUBLE NOT NULL,
    descuento DOUBLE DEFAULT 0
);

CREATE TABLE planes_clientes(
	id_plan INT NOT NULL,
    id_cliente INT NOT NULL,
	PRIMARY KEY (id_plan, id_cliente),
	CONSTRAINT constr_planes_clientes_plan_fk
		FOREIGN KEY plan_fk (id_plan) REFERENCES planes (id_plan),
	CONSTRAINT constr_planes_clientes_cliente_fk
		FOREIGN KEY cliente_fk (id_cliente) REFERENCES clientes (id_cliente)
);

# A. La primary key para la tabla clientes es id_cliente, porque, se crea autoincrementable para evitar duplicidad en el campo
#	 y asi asegurarnos que cada cliente tenga un ID unico y sea distinto

# B. La primary key para la tabla plan es id_plan, porque, se crea autoincrementable para evitar duplicidad en el campo
#	 y asi asegurarnos que cada plan tenga un ID unico y sea distino

# C. Declaramos una relación de muchos a muchos, añadiendo una tabla intermedia "planes_clientes", donde muchos clientes pueden tener muchos planes. 
#    En la tabla intermedia estan las foreign keys, el campo id_cliente hace referencia a la PK de tabla clientes, y el id_plan hace referencia a la PK de la tabla planes.

# Insercion de 10 clientes y 5 planes:
INSERT INTO clientes(dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) VALUES
(23521,"Santiago","Jaramillo","2001-05-29","Antioquia","Medellin"),
(32423,"Alberto","Mora","1980-01-21","Cundinamarca","Bogota"),
(64634,"Rodrigo","Ocampo","2000-03-09","Caldas","Manizales"),
(42333,"Gonzalo","Cepeda","1999-11-12","Valle del Cauca","Cali"),
(87867,"Ariel","Campos","1991-12-12","Bolivar","Cartagena"),
(97676,"Juan","Fernandez","1981-01-16","Antioquia","Medellin"),
(43689,"Gabriel","Gonzalez","1980-05-19","Cordoba","Monteria"),
(88044,"Felipe","Toro","2003-09-16","Antioquia","Medellin"),
(34689,"Martin","Cano","2002-08-23","Boyaca","Tunja"),
(34229,"Leonardo","Cardenas","2004-06-27","Antioquia","Medellin");

INSERT INTO planes(velocidad, precio, descuento) VALUES
(100,80000,30),
(200,100000,40),
(300,120000,0),
(500,150000,10),
(50,50000,30);

# Asociaciones entre planes y clientes.
INSERT INTO planes_clientes(id_cliente, id_plan) VALUES
(1,2),
(2,5),
(3,2),
(1,5),
(4,3),
(5,1),
(6,4),
(7,4),
(1,3),
(8,1),
(9,3),
(10,2);

# 10 consultas posibles:
SELECT dni, nombre, apellido FROM clientes WHERE provincia = "Antioquia";
SELECT id_plan, velocidad, precio FROM planes WHERE precio <= 80000;
SELECT c.dni, c.nombre, c.apellido, p.id_plan, p.velocidad, p.precio FROM clientes AS c 
INNER JOIN planes_clientes as pc ON pc.id_cliente = c.id_cliente
INNER JOIN planes as p ON pc.id_plan = p.id_plan;
SELECT dni, nombre, apellido, provincia FROM clientes ORDER BY provincia;
SELECT avg(precio) FROM planes;
SELECT count(*) FROM clientes;
SELECT dni, nombre, apellido, fecha_nacimiento FROM clientes ORDER BY fecha_nacimiento DESC LIMIT 1;
SELECT * FROM planes WHERE descuento BETWEEN 10 AND 30;
SELECT dni, nombre, apellido FROM clientes WHERE nombre LIKE "A%";
SELECT provincia, count(*) AS numero_clientes FROM clientes GROUP BY provincia;
