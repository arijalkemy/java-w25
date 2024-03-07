#Consultas ejercicio 1 Empresa
USE vivo3_empresa;
# Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores
select em.nombre, em.puesto, de.localidad from empleado em
inner join departamento de on de.depto_nro = em.depto_nro
where em.puesto = "Vendedor";
# Visualizar los departamentos con más de cinco empleados.
select de.nombre_depto, count(em.depto_nro) as nrm_empleados from departamento de
inner join empleado em on de.depto_nro = em.depto_nro
group by em.depto_nro having nrm_empleados >= 2;
# Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
select em.nombre, em.salario, de.nombre_depto from empleado em
inner join departamento de on de.depto_nro = em.depto_nro
where em.puesto = (select em.puesto from empleado em where em.nombre = "Mito" and em.apellido = "Barchuk" );
# Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
select em.* from empleado em
where em.depto_nro = "D-000-3"
order by em.nombre desc;
# Mostrar el nombre del empleado que tiene el salario más bajo.
select em.nombre from empleado em
order by em.salario asc
limit 1;
select em.nombre from empleado em
where em.salario = (select min(em.salario) from empleado em);
# Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
select em.* from empleado em
where em.salario = (select max(em.salario) from empleado em where em.depto_nro = "D-000-4");