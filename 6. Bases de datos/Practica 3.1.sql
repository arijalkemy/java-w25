CREATE SCHEMA  IF NOT EXISTS empleados_db;
USE empleados_db;

CREATE TABLE IF NOT EXISTS departamentos (
depto_nro VARCHAR(255) NOT NULL PRIMARY KEY,
nombre_depto VARCHAR(255) NOT NULL,
localidad VARCHAR(255) NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS empleados (
code_emp VARCHAR(255) NOT NULL PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
apellido VARCHAR(255) NOT NULL,
puesto VARCHAR(255) NOT NULL,
fecha_alta DATE NOT NULL,
salario INT NOT NULL,
comision INT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
depto_nro VARCHAR(255) NOT NULL,
FOREIGN KEY (depto_nro) REFERENCES departamentos(depto_nro) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO departamentos(depto_nro, nombre_depto, localidad) VALUES
("D-000-1", "Software", "Los Tigres"),
("D-000-2", "Sistemas", "Guadaplupe"),
("D-000-3", "Contabilidad", "La Roca"),
("D-000-4", "Ventas", "Plata");

INSERT INTO empleados(code_emp, nombre, apellido, puesto, fecha_alta, salario, comision, depto_nro) VALUES
("E-0001", "Cesar", "Piñero", "Vendedor", "2018-05-12", 80000, 15000, "D-000-4"),
("E-0002", "Yosep", "Kowaleski", "Analista", "2015-07-14", 140000, 0, "D-000-2"),
("E-0003", "Mariela", "Barrios", "Director", "2014-06-05", 185000, 0, "D-000-3"),
("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-04", 85000, 10000, "D-000-4"),
("E-0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", 83000, 10000, "D-000-4"),
("E-0006", "Mito", "Barchuk", "Presidente", "2014-06-05", 190000, 0, "D-000-3"),
("E-0007", "Emilio", "Galarza", "Desarrollador", "2014-08-02", 60000, 0, "D-000-1");

SELECT * FROM empleados;

# 1
SELECT emp.nombre, emp.puesto, dep.localidad 
FROM empleados emp
JOIN departamentos dep ON dep.depto_nro = emp.depto_nro 
WHERE emp.puesto = "Vendedor";

# 2
SELECT count(emp.nombre) total_emp, dep.*
FROM departamentos dep
JOIN empleados emp ON emp.depto_nro = dep.depto_nro
GROUP BY dep.depto_nro
HAVING total_emp > 1;

# 3
SELECT CONCAT(e.nombre, " ", e.apellido) nombre, e.salario, d.nombre_depto
FROM empleados e
JOIN departamentos d ON d.depto_nro = e.depto_nro 
WHERE e.puesto = (SELECT puesto FROM empleados e WHERE CONCAT(e.nombre, " ", e.apellido) LIKE "Mito Barchuk");

# 4
SELECT e.*
FROM empleados e
WHERE e.depto_nro = (SELECT depto_nro FROM departamentos WHERE nombre_depto LIKE "Contabilidad")
ORDER BY e.nombre;

# 5
SELECT CONCAT(e.nombre, " ", e.apellido) as Nombre, e.salario as Salario
FROM empleado e
WHERE e.salario = (SELECT MIN(salario) FROM empleado);

# 6
SELECT e.*
FROM empleados e
WHERE e.salario = (SELECT MAX(salario) FROM empleados WHERE depto_nro = "D-000-4");