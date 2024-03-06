-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, puesto, d.localidad, d.nombre_depto
FROM empleado AS e
INNER JOIN departamento AS d
WHERE e.depto_nro=d.depto_nro;

SELECT * FROM empleado;
SELECT * FROM departamento;

-- Visualizar los departamentos con más de cinco empleados.
SELECT * FROM departamento AS d
WHERE d.depto_nro IN (
	SELECT depto_nro FROM empleado AS e
    GROUP by depto_nro
    HAVING count(*)>=2
);

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto FROM empleado AS e
INNER JOIN departamento d 
ON d.depto_nro=e.depto_nro
WHERE e.puesto = (
	SELECT puesto FROM empleado
    WHERE nombre='Daniel' AND apellido='Brezezicki'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.nombre, e.apellido, e.salario FROM empleado AS e
INNER JOIN departamento d
ON d.depto_nro=e.depto_nro
WHERE d.nombre_depto=(
	SELECT nombre_depto FROM departamento
    WHERE nombre_depto='Contabilidad'
)
ORDER BY e.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM empleado
WHERE salario=(
	SELECT MIN(salario) FROM empleado
);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.nombre, e.apellido, e.salario, d.nombre_depto FROM empleado AS e
INNER JOIN departamento AS d
ON d.depto_nro=e.depto_nro
WHERE d.nombre_depto='Ventas'
ORDER BY e.salario DESC
LIMIT 1;