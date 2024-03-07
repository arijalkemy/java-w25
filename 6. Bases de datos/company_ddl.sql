CREATE TABLE IF NOT EXISTS deparment(
	depto_nro varchar(64),
	name varchar(50),
	locality varchar(50)
);

ALTER TABLE deparment ADD CONSTRAINT 
department_pk PRIMARY KEY(depto_nro);


CREATE TABLE IF NOT EXISTS employee
(
	cod_emp varchar(64),
	name varchar(50) not null,
	last_name varchar(50) null,
	position varchar(50) null,
	entry_date date not null,
	salary integer not null,
	commission integer not null,
	depto_nro varchar(64)
);

ALTER TABLE employee ADD CONSTRAINT 
employee_pk PRIMARY KEY(cod_emp);

ALTER TABLE employee ADD CONSTRAINT
employee_depto_nro_fk FOREIGN KEY(depto_nro)
REFERENCES deparment(depto_nro);

INSERT INTO deparment 
VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3','Contabilidad','La Roca'),
('D-000-4', 'Ventas', 'Plata');

INSERT INTO employee 
VALUES
('E-0001', 'César', 'Piñero','Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista','2015-07-14',140000,0,'D-000-2'),
('E-0003','Mariela','Barrios','Director','2014-06-05',185000,0,'D-000-3'),
('E-0004','Jonathan','Aguilera','Vendedor','2015-06-03', 85000, 10000,'D-000-4'),
('E-0005','Daniel','Brezezicki','Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006','Mito','Barchuk','Presidente','2014-06-05',190000,0,'D-000-3'),
('E-0007','Emilio','Galarza','Desarrollador','2014-08-02',60000,0,'D-000-1');
