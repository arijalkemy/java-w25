# 1). Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
select nombre,puesto,localidad 
from empleado 
join departamento on empleado.depto_nro=departamento.depto_nro 
where puesto = 'vendedor';

# 2). Visualizar los departamentos con más de cinco empleados.
select nombre_depto,count(cod_emp) as cant_empleado 
from departamento 
join empleado on empleado.depto_nro=departamento.depto_nro  
group by nombre_depto 
having cant_empleado > 5;

# 3). Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select nombre,salario,nombre_depto 
from empleado e 
join departamento d on e.depto_nro=d.depto_nro 
where puesto = (select puesto 
			    from empleado 
                where concat(Nombre, ' ', Apellido) LIKE '%Mito Barchuk%');

# 4). Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select * 
from empleado e 
join departamento d on e.depto_nro=d.depto_nro  
where nombre_depto = 'Contabilidad' order by nombre;

# 5). Mostrar el nombre del empleado que tiene el salario más bajo.
select * 
from empleado 
where salario = (select min(salario) from empleado);

# 6). Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select * 
from empleado 
where salario = (select max(salario) 
				from empleado e 
                join departamento d on e.depto_nro=d.depto_nro 
                where nombre_depto = 'Ventas');


