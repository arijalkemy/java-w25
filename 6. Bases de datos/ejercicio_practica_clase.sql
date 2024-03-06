SELECT e.nombre, e.puesto, e.localidad 
FROM empleado e JOIN departamento d
ON e.depto_nro = d.depto_nro 
WHERE e.puesto = 'vendedor';#1

SELECT nombre_depto,count(cod_emp) AS cant_empleado 
FROM departamento JOIN empleado 
ON empleado.depto_nro=departamento.depto_nro  
GROUP BY nombre_depto HAVING cant_empleado >5;#2

SELECT nombre,salario,nombre_depto FROM 
empleado e JOIN departamento d 
ON e.depto_nro=d.depto_nro 
WHERE puesto = 
	(SELECT puesto FROM empleado WHERE cONcat(Nombre, ' ', Apellido) LIKE '%Mito Barchuk%');#3

SELECT * FROM empleado e JOIN departamento d ON e.depto_nro=d.depto_nro  WHERE nombre_depto = 'CONtabilidad' order BY nombre;#4

SELECT * FROM empleado WHERE salario = (SELECT min(salario) FROM empleado);#5

SELECT * FROM empleado WHERE 
salario = (SELECT max(salario) FROM empleado e JOIN departamento d ON e.depto_nro=d.depto_nro WHERE nombre_depto = 'Ventas');#6