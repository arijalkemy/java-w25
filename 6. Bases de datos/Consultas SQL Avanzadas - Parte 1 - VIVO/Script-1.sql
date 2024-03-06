# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select e.nombre, e.puesto, d.localidad from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro;

# Visualizar los departamentos con más de cinco empleados.
select d.depto_nro, d.nombre_depto, d.localidad, count(*) total from DEPARTAMENTO d join EMPLEADO e on d.depto_nro = e.depto_nro
	GROUP BY e.depto_nro HAVING count(*) > 2;

# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select e.nombre, e.salario, d.nombre_depto from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro 
	where e.puesto = (select puesto from EMPLEADO where nombre like "Mito" and apellido like "Barchuk");

# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select * from EMPLEADO e where e.depto_nro = (select depto_nro from DEPARTAMENTO where nombre_depto like "Contabilidad")
	order by nombre;

select * from EMPLEADO e join DEPARTAMENTO d on e.depto_nro = d.depto_nro where d.nombre_depto like "Contabilidad"
	order by e.nombre;

# Mostrar el nombre del empleado que tiene el salario más bajo.
select nombre from EMPLEADO order by salario limit 1;

# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select * from EMPLEADO e where e.depto_nro = (select depto_nro from DEPARTAMENTO where nombre_depto like "Contabilidad")
	order by salario desc limit 1;