#Empresa script
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