DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS plan;

CREATE TABLE plan (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `megas` FLOAT NOT NULL,
    `precio` FLOAT NOT NULL,
    `descuento` FLOAT NOT NULL
);

CREATE TABLE cliente ( 
      `dni` VARCHAR(20) PRIMARY KEY,
      `nombre` VARCHAR(45) NOT NULL,
      `apellido` VARCHAR(45) NOT NULL,
      `fecha_nacimiento` DATE NOT NULL,
      `provincia` VARCHAR(45) NOT NULL,
      `ciudad` VARCHAR(45) NOT NULL,
      `id_plan` INT,
      FOREIGN KEY(`id_plan`) REFERENCES plan(`id`)
);

INSERT INTO plan (megas, precio, descuento) VALUES
(30, 10.0, 0),
(50, 20.0, 5.0),
(100, 35.0, 10.0),
(300, 75.0, 15.0),
(500, 100.0, 18.0);

INSERT INTO cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, id_plan)
VALUES 
('12332422', 'Arnuad', 'Chalkly', '1977-12-14', 'Madrid', 'Madrid', 1),
('12332423', 'Sharron', 'Solon', '1980-08-02', 'Barcelona', 'Barcelona', 2),
('12332424', 'Duke', 'Purdie', '1993-02-14', 'Sevilla', 'Sevilla', 3),
('12332425', 'Charita', 'Barks', '1983-09-07', 'Madrid', 'Madrid', 4),
('12332426', 'Liesa', 'Corrigane', '1976-12-23', 'Barcelona', 'Barcelona', 5),
('12332427', 'Shawn', 'Tarry', '1968-02-18', 'Madrid', 'Madrid', 2),
('12332428', 'Colin', 'Pharro', '2023-12-12', 'Barcelona', 'Barcelona', 4),
('12332429', 'Marrissa', 'Crache', '1966-12-28', 'Sevilla', 'Sevilla', 5),
('12332420', 'Jobye', 'Suttell', '2015-07-01', 'Madrid', 'Madrid', 2),
('12332421', 'Carlo', 'Gunda', '1989-08-31', 'Madrid', 'Madrid', 1);