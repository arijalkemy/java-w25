#Consultas
USE empresa_internet;
#Listado de clientes
SELECT dni, nombre, apellido FROM Clientes;
#Total de clientes
SELECT count(*) AS TotalClientes FROM Clientes;
#Clientes con fecha de nacimiento mayor a 1999
SELECT dni, nombre, apellido, fechaNacimiento FROM Clientes WHERE fechaNacimiento > "1999-01-01";
#Clientes que esten ciudades que empiecen por Bogo
SELECT dni, nombre, apellido, ciudad FROM Clientes WHERE ciudad LIKE "%Bogo%";
#Listado de planes 
Select idplanes, velocidadMegas,precio FROM Planes; 
#Listado de planes con precio menor a $200
SELECT idPlanes,dniClientes,precio FROM Planes WHERE precio < 200;
#Listado de planes con velocidad mayor a 400
SELECT idPlanes,dniClientes,velocidadMegas FROM Planes WHERE velocidadMegas > 400;
#Cantidad de planes con velocidad en Megas igual a 100
SELECT count(*) AS ClientesCon100MG FROM Planes WHERE velocidadMegas = 100;
#Planes con mayor descuento
SELECT max(descuento) FROM Planes;
#Promedio de descuento en planes
SELECT avg(descuento) FROM planes;
#Consulta de velocidades en megas ofrecidas
SELECT distinct(velocidadMegas) FROM planes;


