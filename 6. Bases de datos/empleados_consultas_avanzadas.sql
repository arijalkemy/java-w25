use empleados;

CREATE TABLE empleados (
    cod_emp VARCHAR(10),
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro VARCHAR(10)
);

INSERT INTO empleados (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES 
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

CREATE TABLE departamentos (
    depto_nro VARCHAR(10),
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

INSERT INTO departamentos (depto_nro, nombre_depto, localidad)
VALUES 
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');




SELECT * from empleados;


#1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.apellido,e.puesto, de.localidad 
FROM empleados e
INNER JOIN departamentos de
ON e.depto_nro = de.depto_nro;

#2. Visualizar los departamentos con más de cinco empleados.
SELECT de.nombre_depto, count(*) AS num_empleados
FROM empleados e
INNER JOIN departamentos de
ON e.depto_nro = de.depto_nro
GROUP BY de.nombre_depto
HAVING count(*) > 1;

#3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, de.nombre_depto
FROM empleados e
INNER JOIN departamentos de ON e.depto_nro = de.depto_nro
WHERE nombre != 'Mito' AND apellido != 'Barchuk'
AND de.depto_nro = (SELECT depto_nro
					  FROM empleados 
                      WHERE nombre = 'Mito' AND apellido = 'Barchuk');

#4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.*
FROM empleados e
WHERE e.depto_nro = (SELECT depto_nro
					FROM departamentos
                    WHERE nombre_depto = 'Contabilidad');


#5.Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre, e.apellido
FROM empleados e
WHERE e.salario = (SELECT MIN(em.salario)
					FROM empleados em);
                    

# 6.Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.*
FROM empleados e
WHERE e.salario = (SELECT MAX(em.salario)
					FROM empleados em
                    WHERE em.depto_nro = (SELECT depto_nro
											FROM departamentos
											WHERE nombre_depto = 'Ventas'));