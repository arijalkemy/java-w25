-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select 
e.name,
e.`position`,
d.locality 
from employee e
inner join deparment d on d.depto_nro = e.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
select count(d.depto_nro)
from deparment d 
inner join employee e on e.depto_nro = d.depto_nro
group by d.depto_nro
having count(d.depto_nro) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el 
-- mismo puesto que ‘Mito Barchuk’.
select 
e.name, 
e.salary,
d.name 
from employee e 
inner join deparment d on d.depto_nro = e.depto_nro
where e.`position` = (
	select e2.position from employee e2 where e2.name = 'Mito' and e2.last_name = 'Barchuk'
);

-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select 
*
from employee e 
inner join deparment d on d.depto_nro = e.depto_nro
where d.name = 'Contabilidad'
order by e.name;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
select 
e.name 
from employee e 
where e.salary = (select max(e2.salary) from employee e2);

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select 
e.name 
from employee e
where e.salary = (
	select max(e2.salary) from employee e2
	inner join deparment d ON d.depto_nro = e2.depto_nro and
	d.name = 'Ventas'
);
