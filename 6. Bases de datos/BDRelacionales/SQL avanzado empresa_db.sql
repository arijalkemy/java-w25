#VIVO SQL AVANZADO 1
#creacion de las tablas

CREATE TABLE departamento ( depto CHAR(6),
							nombre_depto VARCHAR(40),
                            localidad VARCHAR(40), 
                            PRIMARY KEY(depto));

CREATE TABLE empleado ( code_emp CHAR(6),
						nombre VARCHAR(40),
                        apellido VARCHAR(40),
                        puesto VARCHAR(40),
                        fecha_alta DATE,
                        salario BIGINT,
                        comision BIGINT,
                        depto_nro CHAR(6),
                        PRIMARY KEY(code_emp),
                        FOREIGN KEY(depto_nro) REFERENCES departamento(depto) );


#insertando valores
INSERT INTO departamento VALUES ("D-0001", "Software", "Los Tigres");
INSERT INTO departamento VALUES ("D-0002", "Sistemas", "Guadalupe");
INSERT INTO departamento VALUES ("D-0003", "Contabilidad", "La Roca");
INSERT INTO departamento VALUES ("D-0004", "Ventas", "Plata");

INSERT INTO empleado VALUES ("E-0001", "César", "Piñero", "Vendedor", "2018-05-12", 80000, 15000, "D-0004");
INSERT INTO empleado VALUES ("E-0002", "Yosep", "Kowaleski", "Analista", "2015-06-14", 140000, 0, "D-0002");
INSERT INTO empleado VALUES ("E-0003", "Mariela", "Barrios", "Director", "2014-06-05", 185000, 0, "D-0003");
INSERT INTO empleado VALUES ("E-0004", "Jonathan", "Aguilera", "Vendedor", "2015-06-03", 85000, 10000, "D-0004");
INSERT INTO empleado VALUES ("E-0005", "Daniel", "Brezezicki", "Vendedor", "2018-03-03", 83000, 10000, "D-0004");
INSERT INTO empleado VALUES ("E-0006", "Mito", "Barchuk", "Presidente", "2014-06-05", 190000, 0, "D-0003");
INSERT INTO empleado VALUES ("E-0007", "Emilio", "Galarza", "Desarrollador", "2014-08-02", 60000, 0, "D-0001");

#Consultas

SELECT e.nombre, e.puesto, d.localidad
FROM empleado e
JOIN departamento d
ON d.depto = e.depto_nro;

SELECT d.nombre_depto
FROM departamento d
JOIN empleado e
ON d.depto = e.depto_nro
GROUP BY depto
HAVING COUNT(*) > 5;

SELECT e.nombre, e.salario, d.nombre_depto
FROM empleado e
JOIN departamento d
ON d.depto = e.depto_nro
WHERE e.depto_nro 
IN (SELECT depto_nro FROM empleado WHERE nombre = "Mito" AND apellido = "Barchuk") 
AND nombre != "Mito";

SELECT e.* 
FROM empleado e
JOIN departamento d
ON e.depto_nro = d.depto
WHERE d.nombre_depto = "Contabilidad";

SELECT nombre
FROM empleado
WHERE salario = (SELECT MIN(salario) FROM empleado);

SELECT *
FROM empleado 
WHERE salario = (	SELECT MAX(e.salario) 
					FROM empleado e
                    JOIN departamento d
                    ON d.depto = e.depto_nro
                    WHERE d.nombre_depto = "Ventas");
