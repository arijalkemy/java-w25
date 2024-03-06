-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre, puesto, localidad from Empleado e inner join Departamento d  on e.depto_nro = d.depto_nro ;
-- Visualizar los departamentos con más de cinco empleados.
SELECT d.depto_nro , d.nombre_depto , d.localidad  FROM Departamento d inner join Empleado e on d.depto_nro = e.depto_nro 
GROUP by d.depto_nro 
HAVING COUNT(*) > 5; 
-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto  from Empleado e inner join Departamento d on e.depto_nro = d.depto_nro 
WHERE e.puesto = (SELECT puesto from Empleado e2 WHERE e2.nombre = "Mito" and e2.apellido = "Barchuk");
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT * FROM Empleado e 
inner join Departamento d on d.depto_nro = e.depto_nro 
WHERE d.nombre_depto = 'Contabilidad' 
ORDER by e.nombre  ;
-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre FROM Empleado e WHERE e.salario = (SELECT min(salario) from Empleado e2 );
-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.* from Empleado e  WHERE e.salario = 
(SELECT MAX(salario) 
from Empleado e2 inner join Departamento d on d.depto_nro = e2.depto_nro 
WHERE d.nombre_depto = "Ventas");
