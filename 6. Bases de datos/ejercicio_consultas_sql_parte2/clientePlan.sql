use empresa_internet;
ALTER TABLE cliente ADD CONSTRAINT fk_grade_id FOREIGN KEY (plan_id) REFERENCES plan(plan_id);
Insert into cliente VALUES(1, "ioiioi", "nombre1", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(2, "ioiioi", "nombre2", "apellido2", "1999-01-03", "p1", "c1", 1);
Insert into cliente VALUES(3, "ioiioi", "nombre3", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(16, "ioiioi", "juan", "perez", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(15, "ioiioi", "juancho", "gutierrez", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(6, "ioiioi", "nombre6", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(7, "ioiioi", "nombre7", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(8, "ioiioi", "nombre8", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(91, "ioiioi", "nombre9", "apellido2", "2020-01-03", "Mendoza", "c1", 1);
Insert into cliente VALUES(120, "ioiioi", "nombre10", "apellido2", "2020-01-03", "Mendoza", "c1", 1);
Insert into plan VALUES(1, 1,2.5, 0.15);
Insert into plan VALUES(2, 2,2.5, 0.15);
Insert into plan VALUES(32, 3,11, 0.25);
Insert into plan VALUES(42, 4,2.5, 0.35);
Insert into plan VALUES(52, 5,45, 0.15);
# 1 traer el nombre y el apellido de todos los clientes cuyo nombre empieze con juan
SELECT nombre, apellido FROM cliente where nombre LIKE "juan%";
# 2 sellecionar planes con descuente entre 0.20 y 0.50
SELECT * from plan where descuento between 0.2 and 0.5;
# 3 seleccionar cliente por id
SELECT cliente_id as id, nombre, apellido from cliente where cliente_id= 1;
# 4 seleccionar todos los clientes de la provincia de mendoza
Select * from cliente where provincia = "mendoza";
# 5 seleccionar planes por rango de precios
SELECT * from plan where precio between 10 and 50;
# 6 contar clientes que tengan el plan 1
select count(*) as cantidad_planes_contratados from cliente where plan_id =1;
# 7 traer planes ordenados descendemente por precio
select * from plan order by precio DESC;
# 8 traer todos los nombres distintos de clientes
select distinct nombre from cliente;
# 9 traer todos los clientes una ciudad que hayan nacido despues de 1999
select nombre,apellido from cliente where ciudad = "cdmx" and fecha_nacimiento > "1999-01-01";
# 10 traer todos los cliente que no sean de cierta ciudad
select nombre,apellido from cliente where ciudad not like "cdmx";