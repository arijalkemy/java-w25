use empresa_internet;
ALTER TABLE cliente ADD CONSTRAINT fk_id_plane FOREIGN KEY (plan_id) REFERENCES plan(plan_id);
Insert into cliente VALUES(123, "ioiioi", "nombre1", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(27, "ioiioi", "nombre2", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(34, "ioiioi", "nombre3", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(187, "ioiioi", "juan", "perez", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(155, "ioiioi", "juancho", "gutierrez", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(61, "ioiioi", "nombre6", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(72, "ioiioi", "nombre7", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(82, "ioiioi", "nombre8", "apellido2", "2020-01-03", "p1", "c1", 1);
Insert into cliente VALUES(90, "ioiioi", "nombre9", "apellido2", "2020-01-03", "Mendoza", "c1", 1);
Insert into cliente VALUES(124, "ioiioi", "nombre10", "apellido2", "2020-01-03", "Mendoza", "c1", 1);
Insert into plan VALUES(111, 1,2.5, 0.15);
Insert into plan VALUES(211, 2,2.5, 0.15);
Insert into plan VALUES(321, 3,11, 0.25);
Insert into plan VALUES(421, 4,2.5, 0.35);
Insert into plan VALUES(521, 5,45, 0.15);
# 1). traer el nombre y el apellido de todos los clientes cuyo nombre empieze con juan
SELECT nombre, apellido FROM cliente WHERE nombre LIKE "juan%";
# 2). sellecionar planes con descuente entre 0.20 y 0.50
SELECT * FROM plan WHERE descuento BETWEEN 0.2 AND 0.5;
# 3). seleccionar cliente por id
SELECT clienteid AS id, nombre, apellido FROM cliente WHERE clienteid= 1;
# 4). seleccionar todos los clientes de la provincia de mendoza
SELECT * FROM cliente WHERE provincia = "mendoza";
# 5). seleccionar planes por rango de precios
SELECT * FROM plan WHERE precio BETWEEN 10 AND 50;
# 6). contar clientes que tengan el plan 1
SELECT count(*) AS cantidad_planes_contratados FROM cliente WHERE plan_id =1;
# 7). traer planes ordenados descendemente por precio
SELECT * FROM plan ORDER BY precio DESC;
# 8). traer todos los nombres distintos de clientes
SELECT DISTINCT nombre FROM cliente;
# 9). traer todos los apellidos distintos de clientes
SELECT DISTINCT apellido FROM cliente;
# 10). seleccionar plan por id
SELECT plan_id AS id, velocidad, precio, descuento FROM plan WHERE plan_id=321;