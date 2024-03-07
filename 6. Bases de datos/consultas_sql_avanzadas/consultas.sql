USE empresa;

#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan 
#los vendedores.
SELECT e.nombre, e.apellido , d.nombre_depto, e.puesto, d.localidad
FROM Empleado e
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro;


#Visualizar los departamentos con más de cinco empleados.
SELECT d.*
FROM Empleado e
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro
GROUP BY d.depto_nro
HAVING COUNT(e.cod_emp) > 5
;

#Mostrar el nombre, salario y nombre del departamento de los empleados que 
#tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM Empleado e
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 
	(SELECT puesto 
	FROM Empleado e2 
	WHERE e2.nombre = 'Mito' AND e2.apellido = 'Barchuk');

#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad,
# ordenados por nombre.
SELECT e.*
FROM Empleado e
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre DESC;
	
#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre
FROM Empleado e
WHERE e.salario = (SELECT MIN(salario) FROM Empleado);

	#Alternativa
SELECT e.nombre
FROM Empleado e
ORDER BY e.salario
LIMIT 1
;

#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM Empleado e
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE 
	e.salario = (
		SELECT MAX(salario) 
		FROM Empleado e1
		INNER JOIN Departamento d1 ON e1.depto_nro = d1.depto_nro
		WHERE d1.nombre_depto = 'Ventas')
;

	#alternativa
SELECT e.*
FROM Empleado e
INNER JOIN Departamento d ON e.depto_nro = d.depto_nro
WHERE 
	d.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
LIMIT 1
;

