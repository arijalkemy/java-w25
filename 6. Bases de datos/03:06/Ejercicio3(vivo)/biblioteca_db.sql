CREATE SCHEMA IF NOT EXISTS biblioteca_db;
USE biblioteca_db;

CREATE TABLE IF NOT EXISTS libros (
id INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(255) NOT NULL,
editorial VARCHAR(255) NOT NULL,
area VARCHAR(255) NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS autores (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
nacionalidad VARCHAR(255) NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS estudiantes (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(255) NOT NULL,
apellido VARCHAR(255) NOT NULL,
direccion VARCHAR(255) NOT NULL,
carrera VARCHAR(255) NOT NULL,
edad INT NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS prestamos (
id INT AUTO_INCREMENT PRIMARY KEY,
fecha_prestamo DATE NOT NULL,
fecha_devolucion DATE NOT NULL,
devuelto INT(1) NOT NULL,
created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
id_libro INT NOT NULL,
FOREIGN KEY (id_libro) REFERENCES libros(id) ON UPDATE CASCADE ON DELETE CASCADE,
id_estudiante INT NOT NULL,
FOREIGN KEY (id_estudiante) REFERENCES estudiantes(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS libros_autores (
id INT AUTO_INCREMENT PRIMARY KEY,
id_libro INT NOT NULL,
FOREIGN KEY (id_libro) REFERENCES libros(id) ON UPDATE CASCADE ON DELETE CASCADE,
id_autor INT NOT NULL,
FOREIGN KEY (id_autor) REFERENCES autores(id) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO libros (titulo, editorial, area) VALUES
('Harry Potter y la piedra filosofal', 'Salamandra', 'Fantasía'),
('1984', 'Debolsillo', 'Distopía'),
('El código Da Vinci', 'Planeta', 'Misterio'),
('Orgullo y prejuicio', 'Alfaguara', 'Romance'),
('Cien años de soledad', 'Cátedra', 'Realismo mágico');

INSERT INTO autores (nombre, nacionalidad) VALUES
('J.K. Rowling', 'Británica'),
('George Orwell', 'Británico'),
('Dan Brown', 'Estadounidense'),
('Jane Austen', 'Británica'),
('Gabriel García Márquez', 'Colombiano');

INSERT INTO estudiantes (nombre, apellido, direccion, carrera, edad) VALUES
('Laura', 'Gómez', 'Calle 123', 'Derecho', 20),
('Carlos', 'López', 'Avenida 456', 'Medicina', 22),
('Ana', 'Pérez', 'Carrera 789', 'Ingeniería', 21),
('Pedro', 'González', 'Calle 321', 'Contabilidad', 23),
('María', 'Sánchez', 'Avenida 654', 'Arquitectura', 19);

INSERT INTO prestamos (fecha_prestamo, fecha_devolucion, devuelto, id_libro, id_estudiante) VALUES
('2021-01-10', '2021-01-17', 1, 1, 1),
('2021-02-05', '2021-02-12', 0, 2, 1),
('2021-03-15', '2021-03-22', 1, 3, 2),
('2021-04-20', '2021-04-27', 0, 4, 3),
('2021-05-30', '2021-06-06', 1, 5, 4);

INSERT INTO libros_autores (id_libro, id_autor) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);