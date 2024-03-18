USE empleados_db;

# 1.- 
SELECT e.nombre, e.puesto, d.localidad
FROM empleados e
INNER JOIN departamentos d ON d.depto_nro = e.depto_nro
WHERE puesto = "vendedor";

# 2.- 
SELECT d.*
FROM empleados e
INNER JOIN departamentos d ON d.depto_nro = e.depto_nro
GROUP BY d.depto_nro
HAVING COUNT(e.code_emp) > 5;

# 3.- 
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleados e
JOIN departamentos d ON d.depto_nro = e.depto_nro 
WHERE e.puesto = (SELECT puesto FROM empleados e WHERE CONCAT(e.nombre, " ", e.apellido) LIKE "Mito Barchuk");

# 4.-
SELECT e.*
FROM empleados AS e
WHERE e.depto_nro = "D-000-3"
ORDER BY e.nombre;

# 5.-
SELECT e.*
FROM empleados AS e
WHERE e.salario = (SELECT MIN(salario) FROM empleados);

# 6.-
SELECT e.*
FROM empleados AS e
WHERE e.salario = (SELECT MAX(salario) FROM empleados WHERE depto_nro = "D-000-4");