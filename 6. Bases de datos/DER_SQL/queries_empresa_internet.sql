#Mostrar clientes
SELECT *
FROM Cliente;

#Mostrar planes
SELECT *
FROM Plan;

#Mostrar clientes de nombre Cecilia
SELECT *
FROM Cliente c 
WHERE nombre = 'Cecilia';

#Clientes de apellido que empiecen con S
SELECT *
FROM Cliente c 
WHERE apellido LIKE 'S%';

#Clientes con dni terminando en 3
SELECT *
FROM Cliente c 
WHERE dni LIKE '%3';

#Planes con mas de 100 MB de velocidad
SELECT *
FROM Plan p 
WHERE velocidad > 100;

#Planes que cuesten menos de 5000
SELECT *
FROM Plan p 
WHERE precio < 5000;

#Mostrar planes ordenados por order_date en orden descendiente
SELECT *
FROM Plan p 
ORDER BY order_date DESC;

#Planes con order_date entre los años 2012 y 2021
SELECT *
FROM Plan p 
WHERE YEAR(order_date) BETWEEN '2012' AND '2021';

#Mostrar velocidad y precio de los planes
SELECT velocidad, precio
FROM Plan p;


