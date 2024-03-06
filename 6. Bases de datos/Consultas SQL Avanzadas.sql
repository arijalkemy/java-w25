#Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT nombre as Nombre, puesto as Puesto, d.localidad as Localidad from empleado as e left join departamento as d on e.depto_nro = d.depto_nro;
#Visualizar los departamentos con más de cinco empleados.
SELECT e.depto_nro from departamento d left join empleado e on e.depto_nro = d.depto_nro group by e.depto_nro having count(*) > 5;
#Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto FROM empleado e LEFT JOIN departamento d ON e.depto_nro = d.depto_nro where e.puesto IN (SELECT puesto from empleado as e1 where e1.nombre = 'MITO' and e1.apellido = 'Barchuk');
#Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.* from empleado e LEFT join departamento d on e.depto_nro = d.depto_nro WHERE d.nombre_depto='Contabilidad';
#Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre from empleado order by salario limit 1;
#Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT nombre from empleado e LEFT join departamento d on e.depto_nro = d.depto_nro WHERE d.nombre_depto='Ventas' order by salario desc limit 1;