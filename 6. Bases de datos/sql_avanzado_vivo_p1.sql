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

# 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT e.nombre, e.puesto, d.localidad FROM empleado e JOIN departamento d ON e.depto_nro = d.depto_nro;
# 2. Visualizar los departamentos con más de cinco empleados.
SELECT d.nombre_depto, COUNT(*) AS employees 
FROM departamento d 
INNER JOIN empleado e ON d.depto_nro = e.depto_nro 
GROUP BY e.depto_nro 
HAVING employees > 5; 
# 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.nombre, e.salario, d.nombre_depto 
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE e.puesto = (SELECT puesto FROM empleado WHERE nombre = "Mito" AND apellido = "Barchuk")
AND e.nombre != "Mito" AND e.apellido != "Barchuk";
# 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT e.nombre, e.apellido, e.puesto, e.fecha_alta, d.nombre_depto, d.localidad 
FROM empleado e 
INNER JOIN departamento d ON d.depto_nro = e.depto_nro 
WHERE d.nombre_depto = 'Contabilidad' 
ORDER BY e.nombre;
# 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT e.nombre, e.salario  
FROM empleado e 
ORDER BY e.salario 
LIMIT 1;
# 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT e.nombre, e.salario 
FROM empleado e 
INNER JOIN departamento d ON e.depto_nro = d.depto_nro 
WHERE d.nombre_depto = "Ventas" 
ORDER BY e.salario DESC 
LIMIT 1;