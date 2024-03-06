drop database empresa_db;
create schema empresa_db;
USE empresa_db;

create table DEPARTAMENTO(
                             depto_nro varchar(50) not null primary key,
                             nombre_depto varchar(50),
                             localidad varchar(50)
);

INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
                                                                  ('D-000-1', 'Software', 'Los Tigres'),
                                                                  ('D-000-2', 'Sistemas', 'Guadalupe'),
                                                                  ('D-000-3', 'Contabilidad', 'La Roca'),
                                                                  ('D-000-4', 'Ventas', 'Plata');

create table EMPLEADO (
                          cod_emp VARCHAR(50) primary key,
                          nombre VARCHAR(50),
                          apellido VARCHAR(50),
                          puesto VARCHAR(50),
                          fecha_alta DATETIME, -- trae la hora
                          salario INT,
                          comision INT,
                          depto_nro VARCHAR(50),
                          FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
                                                                                                       ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
                                                                                                       ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
                                                                                                       ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
                                                                                                       ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
                                                                                                       ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
                                                                                                       ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
                                                                                                       ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1'),
                                                                                                       ('E-0008', 'Lucho', 'Rodriguez', 'Presidente', '2014-06-05', 100000, 0, 'D-000-3');


-- Punto 1: Seleccionar el nombre, el puesto y la localidad
-- de los departamentos donde trabajan los vendedores.

SELECT e.nombre, e.puesto, d.localidad
FROM EMPLEADO e
         JOIN DEPARTAMENTO d on e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

-- Punto 2: Visualizar los departamentos con más de cinco empleados.
-- Aclaracion: Como no hay ninguno, decidimos poner que sea mayor a 2

SELECT count(*) ,d.depto_nro
FROM DEPARTAMENTO d
         JOIN EMPLEADO e on d.depto_nro = e.depto_nro
GROUP BY d.depto_nro
HAVING count(*) > 2;

-- Punto 3: Mostrar el nombre, salario y nombre del departamento de los empleados que
-- tengan el mismo puesto que 'Mito Barchuk'.
SELECT e.puesto -- Subconsulta
FROM EMPLEADO e
WHERE e.nombre = 'Mito'
  AND e.apellido = 'Barchuk';
-- Agregamos un registro más para poder probar
SELECT e.nombre, e.salario, d.nombre_depto
FROM EMPLEADO e
         JOIN DEPARTAMENTO d on e.depto_nro = d.depto_nro
WHERE e.puesto IN (SELECT e.puesto
                   FROM EMPLEADO e
                   WHERE e.nombre = 'Mito'
                     AND e.apellido = 'Barchuk');

-- Punto 4: Mostrar los datos de los empleados que trabajan en el
-- departamento de contabilidad, ordenados por nombre.

SELECT e.*
FROM EMPLEADO e
         JOIN DEPARTAMENTO d on e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre; -- Por default viene ASC

-- Punto 5: Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre
FROM EMPLEADO e
ORDER BY e.salario
    LIMIT 1;
-- otra forma
SELECT e.nombre
FROM EMPLEADO e
WHERE e.salario IN (SELECT min(e2.salario) from EMPLEADO e2 );

-- Punto 6: Mostrar los datos del empleado que tiene el salario más alto en el departamento de 'Ventas'.

SELECT e.nombre
FROM EMPLEADO e
         JOIN DEPARTAMENTO D on e.depto_nro = D.depto_nro
WHERE D.nombre_depto = 'Ventas'
ORDER BY e.salario DESC
    LIMIT 1;