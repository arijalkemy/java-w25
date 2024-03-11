use vivo3;

select a.nombre, a.puesto, b.localidad

from empleado as a

left join DEPARTAMENTO as b on a.depto_nro = b.depto_nro;

select * from DEPARTAMENTO where depto_nro in (select depto_nro from empleado  Group by depto_nro having count(depto_nro) >= 3);

select a.nombre, a.salario, b.nombre_depto from empleado as a left join DEPARTAMENTO as b on a.depto_nro = b.depto_nro where a.puesto in (
select puesto from EMPLEADO where nombre = 'Mito' and apellido = 'Barchuk');

select * from EMPLEADO as a left join DEPARTAMENTO as b on a.depto_nro = b.depto_nro where b.nombre_depto ='Contabilidad' order by nombre;

select nombre from EMPLEADO order by salario ASC limit 1;

select nombre from EMPLEADO as a left join DEPARTAMENTO as b on a.depto_nro = b.depto_nro where b.nombre_depto ='Ventas' order by salario DESC limit 1;

