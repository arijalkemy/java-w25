-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

WITH AUX AS (SELECT nombre, puesto, depto_nro
             FROM empleado
             WHERE empleado.puesto = 'Vendedor')
SELECT e.nombre, e.puesto, d.localidad
FROM AUX e JOIN departamento d ON e.depto_nro = d.depto_nro;

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT depto_nro, COUNT(*) as cant_empleados
FROM empleado
GROUP BY depto_nro
HAVING cant_empleados > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (
    SELECT puesto
    FROM empleado
    WHERE nombre = 'Mito'
    AND apellido = 'Barchuk'
)
AND nombre != 'Mito'
AND apellido != 'Barchuk';

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, d.nombre_depto
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleado
ORDER BY salario
LIMIT 1;

WITH minimo AS (
    SELECT MIN(salario) AS salario
    FROM empleado
)
SELECT nombre
FROM empleado e JOIN minimo m ON e.salario = m.salario
LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
WITH ventas AS (
    SELECT depto_nro, nombre_depto
    FROM departamento
    WHERE nombre_depto = 'Ventas'
)
SELECT *
FROM empleado e JOIN ventas v ON e.depto_nro = v.depto_nro
ORDER BY salario DESC
LIMIT 1;