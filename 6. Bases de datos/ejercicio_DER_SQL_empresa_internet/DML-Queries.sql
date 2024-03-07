-- Delete DB if already exists
DROP DATABASE IF EXISTS empresa_internet;

-- Creating DB
CREATE DATABASE empresa_internet;

USE empresa_internet;

-- Creating Cliente Table
CREATE TABLE Cliente (
	id_cliente INT PRIMARY KEY,
	dni VARCHAR(50),
	nombre VARCHAR(50),
	apellido VARCHAR(50),
	fecha_nacimiento DATE,
	provincia VARCHAR(50),
	ciudad VARCHAR(50)
);

-- Add registers in Cliente Table
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (1, '301-18-9986', 'Dael', 'Pringle', '1992-11-22', 'Stockholm', 'Novoselë');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (2, '431-92-1686', 'Finlay', 'Morland', '2000-02-29', 'Stockholm', 'Baturaden');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (3, '458-67-4412', 'Brnaba', 'Ludgrove', '1985-01-18', 'Île-de-France', 'Nogent-sur-Marne');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (4, '406-19-9520', 'Simmonds', 'Hardwich', '1987-10-18', 'Guarda', 'Vide');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (5, '893-64-8677', 'Marin', 'Maloney', '1991-10-18', 'Stockholm', 'Qingzhou');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (6, '474-94-0793', 'Melodie', 'Pasquale', '1993-07-03', 'Stockholm', 'Waina');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (7, '101-23-0349', 'Lauree', 'Laister', '1990-07-04', 'Stockholm', 'Haodian');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (8, '386-94-5101', 'Eddi', 'Nelle', '2003-03-20', 'Stockholm', 'Södertälje');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (9, '392-31-6658', 'Julia', 'Boal', '1997-09-19', 'Stockholm', 'Yonghe');
insert into Cliente (id_cliente, dni, nombre, apellido, fecha_nacimiento, provincia, ciudad) values (10, '482-68-1692', 'Fredrika', 'Boome', '1992-12-16', 'Stockholm', 'Kista');

-- Creating Plan Table
CREATE TABLE Plan (
	id_plan INT PRIMARY KEY,
	name VARCHAR(16),
	price VARCHAR(50)
);

-- Add registers in Plan Table
insert into Plan (id_plan, name, price) values (1, 'Internet + Movil', '$47.68');
insert into Plan (id_plan, name, price) values (2, '300 MEGAS', '$35.41');
insert into Plan (id_plan, name, price) values (3, 'Triple Velocidad', '$48.58');
insert into Plan (id_plan, name, price) values (4, 'Fibra Optica', '$16.68');
insert into Plan (id_plan, name, price) values (5, 'Postpago', '$32.21');

-- Creating Cliente_Plan Table
CREATE TABLE Cliente_Plan (
	id_plan_internet INT,
    descuento FLOAT,
    id_cliente INT,
    id_plan INT,
    foreign key (id_cliente) references Cliente(id_cliente),
    foreign key (id_plan) references Plan(id_plan)
);

-- Add registers in Cliente_Plan Table
INSERT INTO Cliente_Plan (id_plan_internet, descuento, id_cliente, id_plan)
VALUES
    (11, 0.1, 1, 1),
    (12, 0.2, 2, 3),
    (13, 0.3, 3, 4),
    (14, 0.4, 4, 1),
    (15, 0.5, 5, 2),
    (16, 0.6, 6, 5),
    (17, 0.7, 7, 2),
    (18, 0.8, 8, 3),
    (19, 0.9, 9, 5),
    (20, 1.0, 10, 5);
    
# traer el nombre de todos los clientes
select nombre from cliente;

# traer el nombre de todos los planes ordenado por precio
select distinct name as nombre, price as precio from plan order by nombre;

# traer todos los planes de un cliente
select name as nombre from plan as pl
inner join cliente_plan as cl_pl on pl.id_plan = cl_pl.id_plan
inner join cliente as cl on cl.id_cliente = cl_pl.id_cliente
where cl.id_cliente = 2;

# traer nombre y apellido de clientes ordenados por apellido
select nombre, apellido from cliente order by apellido;

# traer todas las ciudades de los clientes sin repetir
select distinct ciudad from cliente;
select distinct provincia from cliente;

# traer el nombre y el numero de veces que se adquirio un plan
select count(*) id_plan, pl.name from cliente_plan as cl_pl
inner join plan as pl on cl_pl.id_plan = pl.id_plan
group by cl_pl.id_plan;

# Nombre del plan mas adquirido
select count(*) id_plan, pl.name from cliente_plan as cl_pl
inner join plan as pl on cl_pl.id_plan = pl.id_plan
group by cl_pl.id_plan
order by cl_pl.id_plan DESC
limit 1;