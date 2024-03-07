CREATE TABLE departamento (
      `depto_nro` VARCHAR(45) PRIMARY KEY,
      `nombre_depto` VARCHAR(45) NOT NULL,
      `localidad` VARCHAR(45) NOT NULL
);
CREATE TABLE empleado (
      `cod_emp` VARCHAR(20) PRIMARY KEY,
      `nombre` VARCHAR(45) NOT NULL,
      `apellido` VARCHAR(45) NOT NULL,
      `puesto` VARCHAR(45) NOT NULL,
      `fecha_alta` DATE NOT NULL,
      `salario` INT NOT NULL,
      `comision` INT NOT NULL,
      `depto_nro` VARCHAR(45) NOT NULL,
      FOREIGN KEY(`depto_nro`) REFERENCES departamento(`depto_nro`)
);
INSERT INTO departamento (depto_nro, nombre_depto, localidad) VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');
INSERT INTO empleado (cod_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', '80000', '15000', 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', '140000', '0', 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', '185000', '0', 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', '85000', '10000', 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', '83000', '10000', 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', '190000', '0', 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', '60000', '0', 'D-000-1');


-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto = 'Vendedor';

WITH AUX AS (SELECT nombre, puesto, depto_nro
             FROM empleado
             WHERE empleado.puesto = 'Vendedor')
SELECT e.nombre, e.puesto, d.localidad
FROM AUX e JOIN departamento d ON e.depto_nro = d.depto_nro;

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT depto_nro, COUNT(*) as cant_empleados
FROM empleado
GROUP BY depto_nro
HAVING cant_empleados > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE e.puesto IN (
    SELECT puesto
    FROM empleado
    WHERE nombre = 'Mito'
    AND apellido = 'Barchuk'
)
AND nombre != 'Mito'
AND apellido != 'Barchuk';

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.nombre, e.apellido, e.puesto, e.fecha_alta, e.salario, e.comision, d.nombre_depto
FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro
WHERE d.nombre_depto = 'Contabilidad'
ORDER BY e.nombre;

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleado
ORDER BY salario
LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
WITH ventas AS (
    SELECT depto_nro, nombre_depto
    FROM departamento
    WHERE nombre_depto = 'Ventas'
)
SELECT *
FROM empleado e JOIN ventas v ON e.depto_nro = v.depto_nro
ORDER BY salario DESC
LIMIT 1;