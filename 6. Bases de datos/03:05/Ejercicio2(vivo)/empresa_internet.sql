CREATE SCHEMA  IF NOT EXISTS empresa_internet;
USE empresa_internet;

CREATE TABLE IF NOT EXISTS clientes (
id INT AUTO_INCREMENT PRIMARY KEY,
dni VARCHAR(50) NOT NULL,
nombre VARCHAR(50) NOT NULL,
fecha_nacimiento DATETIME NOT NULL,
provincia VARCHAR(100) NOT NULL,
ciudad VARCHAR(100) NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS planes_internet (
id INT AUTO_INCREMENT PRIMARY KEY,
velocidad_megas INT NOT NULL,
precio DOUBLE(10,2) NOT NULL,
descuento INT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS clientes_plan (
id INT AUTO_INCREMENT PRIMARY KEY,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
id_cliente INT,
FOREIGN KEY (id_cliente) REFERENCES clientes(id) ON UPDATE CASCADE ON DELETE CASCADE,
id_plan_internet INT,
FOREIGN KEY (id_plan_internet) REFERENCES planes_internet(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO clientes (dni, nombre, fecha_nacimiento, provincia, ciudad) VALUES
("123456789A", "Juan Perez", "1990-05-15", "La Pampa", "Santa Rosa"),
("987654321B", "Maria Sanchez", "1995-08-20", "La Rioja", "La Rioja"),
("456789123C", "Pedro Gomez", "1985-12-10", "Buenos Aires", "Buenos Aires"),
("654321987D", "Laura Fernandez", "2000-02-25", "La Pampa", "General Pico"),
("789123456E", "Carlos Rodriguez", "1992-07-05", "Buenos Aires", "Quilmes"),
("321987654F", "Ana Lopez", "1988-01-30", "La Rioja", "La Rioja"),
("567890123G", "Luis Ramirez", "1997-09-22", "La Pampa", "Santa Rosa"),
("098765432H", "Sofia Torres", "1987-04-12", "La Pampa", "General Acha"),
("234567890I", "Elena Castro", "1993-11-18", "Buenos Aires", "Mar del Plata"),
("678901234J", "Diego Herrera", "1998-06-08", "La Rioja", "La Rioja");

INSERT INTO planes_internet (velocidad_megas, precio, descuento) VALUES
(100, 29.99, 0),
(200, 39.99, 10),
(300, 49.99, 20),
(500, 59.99, 15),
(1000, 79.99, 25);