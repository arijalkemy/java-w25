USE empresa_internet;

SELECT * FROM clientes;
SELECT * FROM planes_internet;
SELECT * FROM clientes_plan;
INSERT INTO clientes_plan (id_cliente, id_plan_internet) VALUES (10, 2), (10, 3);
SELECT COUNT(id) FROM clientes_plan WHERE id_cliente = 10;
UPDATE clientes SET nombre = "Luna" WHERE id = 1;
SELECT * FROM planes_internet WHERE descuento > 0;
SELECT *, precio-((precio*descuento)/100) AS precio_real FROM planes_internet WHERE descuento > 0;
SELECT * FROM clientes WHERE fecha_nacimiento >= '1995-01-01 00:00:00' AND fecha_nacimiento <= NOW();
SELECT * FROM clientes ORDER BY provincia;
SELECT provincia, COUNT(id) cantidad_habitantes_prov FROM clientes GROUP BY provincia;