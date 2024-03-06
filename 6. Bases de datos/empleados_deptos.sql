/* Consultas SQL Avanzadas - Parte 1 - VIVO Ejercicios Prácticos (Vivo) 💻*/

create database empleados_deptos;
use empleados_deptos;

CREATE TABLE departamento (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

CREATE TABLE empleado (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES departamento(depto_nro)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad)
VALUES 
    ('D-000-1', 'Software', 'Los Tigres'),
    ('D-000-2', 'Sistemas', 'Guadalupe'),
    ('D-000-3', 'Contabilidad', 'La Roca'),
    ('D-000-4', 'Ventas', 'Plata');

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro)
VALUES 
    ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
    ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
    ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
    ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
    ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
    ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
    ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');
    
/* 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores. */
SELECT d.nombre_depto, d.localidad, concat(e.nombre, ' ', e.apellido) 'empleado', e.puesto
FROM departamento d
INNER JOIN empleado e ON d.depto_nro = e.depto_nro
WHERE e.puesto = 'Vendedor';

/* 2. Visualizar los departamentos con más de cinco empleados. */
SELECT d.nombre_depto, COUNT(e.cod_emp) as cantidad_empleados
FROM departamento d
LEFT JOIN empleado e ON d.depto_nro = e.depto_nro
GROUP BY d.nombre_depto
HAVING cantidad_empleados > 5;

/* 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’. */
SELECT concat(e.nombre, ' ', e.apellido) 'empleado', e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = (
	SELECT puesto 
	FROM empleado 
	WHERE concat(Nombre, ' ', Apellido) LIKE '%Mito Barchuk%'
);

/* 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre. */
SELECT *
FROM empleado e
WHERE e.depto_nro = (
	SELECT d.depto_nro 
	FROM departamento d 
	WHERE d.nombre_depto = 'Contabilidad'
)
ORDER BY e.nombre;

/* 5. Mostrar el nombre del empleado que tiene el salario más bajo. */
SELECT concat(nombre, ' ', apellido) 'empleado'
FROM empleado
WHERE salario = (
	SELECT MIN(salario) 
	FROM empleado
);

/* 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’. */
SELECT *
FROM empleado
WHERE salario = (
	SELECT MAX(salario) 
	FROM empleado 
	WHERE depto_nro = (
		SELECT d.depto_nro 
		FROM departamento d 
		WHERE d.nombre_depto = 'Ventas'
    )
);



