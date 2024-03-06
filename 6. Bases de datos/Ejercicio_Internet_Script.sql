-- CREATE DATABASE empresa_internet;
USE empresa_internet;

CREATE TABLE PlanDeInternet (
	Plan_id int NOT NULL PRIMARY KEY auto_increment,
    Plan_velocidad float NOT NULL,
    Plan_precio float NOT NULL,
    Plan_descuento float NULL
);

CREATE TABLE Cliente (
	Cliente_id int NOT NULL PRIMARY KEY auto_increment,
    Cliente_dni int NOT NULL,
    Cliente_nombre varchar(50) NOT NULL,
    Cliente_apellido varchar(50) NOT NULL,
    Cliente_fecNac date NOT NULL,
    Cliente_provincia varchar(30) NOT NULL,
    Cliente_ciudad varchar(50) NOT NULL,
    Plan_id int NOT NULL,
    FOREIGN KEY (Plan_id) REFERENCES PlanDeInternet(Plan_id)
);

INSERT INTO PlanDeInternet (Plan_velocidad, Plan_precio, Plan_descuento) VALUES
(100, 10000, 10), -- Plan_id: 1
(200, 12000, 15), -- Plan_id: 2
(300, 15000, 5), -- Plan_id: 3
(500, 18000, 10), -- Plan_id: 4
(1000, 23000, 20); -- Plan_id: 5

INSERT INTO Cliente (Cliente_dni, Cliente_nombre, Cliente_apellido, Cliente_fecNac, Cliente_provincia,
					 Cliente_ciudad, Plan_id) VALUES
(123456789, 'Juan', 'Pérez', '1990-05-15', 'Madrid', 'Madrid', 1),
(987654321, 'María', 'Gómez', '1985-10-20', 'Barcelona', 'Barcelona', 2),
(456123789, 'Pedro', 'Sánchez', '1988-03-25', 'Valencia', 'Valencia', 4),
(789123456, 'Laura', 'Martínez', '1992-08-12', 'Sevilla', 'Sevilla', 3),
(654987321, 'Ana', 'Rodríguez', '1995-11-30', 'Málaga', 'Málaga', 2),
(321456987, 'David', 'López', '1980-04-05', 'Alicante', 'Alicante', 1),
(159753468, 'Sara', 'Fernández', '1996-05-05', 'Barcelona', 'Barceloneta', 5),
('852369741', 'Javier', 'Ruiz', '1998-12-08', 'Granada', 'Granada', 4),
('369852147', 'Elena', 'García', '1991-07-22', 'Bilbao', 'Bilbao', 1),
('741258963', 'Carlos', 'Hernández', '1987-06-10', 'Toledo', 'Toledo', 3);