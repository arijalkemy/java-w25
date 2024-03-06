USE empleados_db;

# 1.-
SELECT e.nombre, e.puesto, d.localidad
FROM empleados AS e
INNER JOIN departamentos AS d ON d.depto_nro = e.depto_nro
WHERE e.puesto = "Vendedor";

# 2.-
SELECT d.nombre_depto
FROM departamentos AS d
INNER JOIN empleados AS e ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro
HAVING COUNT(e.code_emp) > 5;

# 3.-
SELECT e.nombre, e.salario, d.nombre_depto
FROM departamentos AS d
INNER JOIN empleados AS e ON e.depto_nro = d.depto_nro
WHERE e.depto_nro = (
SELECT depto_nro
FROM empleados
WHERE CONCAT(nombre, " ", apellido) = 'Cesar Piñero'
);

# 4.-
SELECT e.*
FROM departamentos AS d
INNER JOIN empleados AS e ON e.depto_nro = d.depto_nro
WHERE d.depto_nro = "D-000-3"
ORDER BY e.nombre;

# 5.-
SELECT e.*
FROM empleados AS e
WHERE e.salario = (
SELECT MIN(e2.salario)
FROM empleados AS e2
);

# 6.-
SELECT e.*
FROM empleados AS e
WHERE e.salario = (
SELECT MAX(e2.salario)
FROM empleados AS e2
WHERE e2.depto_nro = "D-000-4"
);