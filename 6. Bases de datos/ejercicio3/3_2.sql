DROP DATABASE IF EXISTS library;
CREATE DATABASE library;
USE library;

DROP TABLE IF EXISTS autor;
CREATE TABLE autor(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
	nacionalidad VARCHAR(50)
    );
    
INSERT INTO autor (nombre, nacionalidad)
VALUES
('Jean Dupont', 'Francesa'),
('J.K. Rowling', 'Francesa'),
('Luigi Rossi', 'Italiana'),
('Giovanni Bianchi', 'Italiana'),
('Maria Garcia', 'Española'),
('John Smith', 'Estadounidense'),
('Hans Müller', 'Alemán'),
('Anna Nowak', 'Polaca'),
('Juan Rodriguez', 'Mexicana'),
('Sara Andersson', 'Sueca'),
('Miguel Silva', 'Portuguesa'),
('Giuseppe Esposito', 'Italiana'),
('Pablo Hernandez', 'Española'),
('Antoine Martin', 'Francesa'),
('Maria Russo', 'Italiana'),
('Thomas Müller', 'Alemán'),
('Federico Bianchi', 'Italiana'),
('Luis Fernandez', 'Española'),
('Mario Rossi', 'Italiana'),
('Sofia Garcia', 'Española'),
('Julia Schmidt', 'Alemana'),
('Emilia Nowak', 'Polaca'),
('Juan Martinez', 'Española'),
('Andrea Ferrari', 'Italiana'),
('Laura Gonzalez', 'Española'),
('Fabio Ricci', 'Italiana'),
('Sophie Martin', 'Francesa'),
('Alessandro Conti', 'Italiana'),
('David Smith', 'Estadounidense'),
('Marco Rossi', 'Italiana'),
('Clara Müller', 'Alemana'),
('Martina Novak', 'Polaca'),
('Pedro Rodriguez', 'Española'),
('Julio Lopez', 'Española'),
('Cristina Esposito', 'Italiana'),
('Julian Fernandez', 'Española'),
('Simone Ferrari', 'Italiana'),
('Carla Sanchez', 'Española'),
('Lena Weber', 'Alemana'),
('Lucas Silva', 'Portuguesa'),
('Maria Lopez', 'Española'),
('Maximilian Müller', 'Alemán'),
('Elena Nowak', 'Polaca'),
('Marta Martinez', 'Española'),
('Giovanni Rossi', 'Italiana'),
('Rosa Martin', 'Española'),
('Luca Bianchi', 'Italiana');

    
DROP TABLE IF EXISTS libro;
CREATE TABLE libro(
	id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(50),
	editorial VARCHAR(50),
    area VARCHAR(50)
    );
    
INSERT INTO libro (titulo, editorial, area)
VALUES
('El Jardín de los Sueños', 'Ediciones del Paraíso', 'Fantasía'),
('El Último Suspiro', 'Editorial Épica', 'Aventura'),
('La Rosa Negra', 'Libros del Misterio', 'Misterio'),
('Cielo de Fuego', 'Editorial Estelar', 'Ciencia Ficción'),
('El Tesoro del Pirata', 'Ediciones del Mar', 'Aventura'),
('Secretos del Pasado', 'Ediciones del Tiempo', 'Histórico'),
('El Bosque Encantado', 'Libros de la Magia', 'Fantasía'),
('Códice Perdido', 'Editorial Arcana', 'Misterio'),
('El Ladrón de Sueños', 'Ediciones Oníricas', 'Fantasía'),
('El Diamante Azul', 'Editorial Brillante', 'Aventura'),
('El Último Dragón', 'Editorial Draconiana', 'Fantasía'),
('El Laberinto de las Sombras', 'Salamandra', 'Misterio'),
('La Isla de los Secretos', 'Editorial Isla Negra', 'Aventura'),
('La Profecía del Destino', 'Ediciones Proféticas', 'Fantasía'),
('La Marca del Asesino', 'Editorial de Crimen', 'Misterio'),
('El Grito del Viento', 'Ediciones del Viento', 'Aventura'),
('El Reino Olvidado', 'Editorial del Olvido', 'Fantasía'),
('El Misterio del Faro', 'Editorial del Faro', 'Misterio'),
('La Revolución de la Nube', 'Editorial Nube', 'Internet'),
('El Futuro de la Inteligencia Artificial', 'Ediciones Inteligentes', 'Internet'),
('Seguridad en Línea: Protegiendo tu Privacidad', 'Editorial Segura', 'Internet'),
('Blockchain: Más Allá del Bitcoin', 'Ediciones Blockchain', 'Internet'),
('El Poder de los Datos: Big Data y Análisis', 'Editorial Datamind', 'Internet'),
('E-commerce: Estrategias para el Éxito', 'Ediciones E-commerce', 'Internet'),
('Desarrollo Web Moderno', 'Editorial Web', 'Internet'),
('Hacking Ético: Una Introducción', 'Ediciones Hack', 'Internet'),
('Introducción a la Ciberseguridad', 'Salamandra', 'Internet'),
('La Ciudad Perdida', 'Editorial de las Ruinas', 'Aventura'),
('El Eterno Despertar', 'Ediciones del Amanecer', 'Fantasía'),
('El Secreto de la Montaña', 'Editorial de las Cumbres', 'Misterio'),
('La Espada del Guerrero', 'Editorial de Batalla', 'Aventura'),
('El Libro de los Secretos', 'Ediciones del Secreto', 'Fantasía'),
('La Sombra del Pasado', 'Editorial de los Recuerdos', 'Misterio'),
('Internet de las Cosas: Conectando el Mundo', 'Ediciones IoT', 'Internet'),
('Marketing Digital: Estrategias Innovadoras', 'Editorial Digital', 'Internet'),
('La Web Semántica: Más Allá de los Enlaces', 'Ediciones Semántica', 'Internet'),
('Realidad Virtual: Una Experiencia Inmersiva', 'Editorial Virtual', 'Internet'),
('El Oráculo Perdido', 'Editorial del Oráculo', 'Aventura'),
('La Corona del Rey', 'Ediciones Reales', 'Fantasía'),
('La Llave del Tiempo', 'Editorial del Tiempo', 'Misterio'),
('La Isla de los Tesoros', 'Editorial del Tesoro', 'Aventura'),
('El Sendero del Guerrero', 'Ediciones del Guerrero', 'Fantasía'),
('La Cripta de los Secretos', 'Editorial de los Misterios', 'Misterio'),
('El Cáliz de los Dioses', 'Editorial de las Leyendas', 'Aventura'),
('La Princesa del Reino', 'Ediciones de la Realeza', 'Fantasía'),
('El Secreto del Bosque', 'Editorial del Bosque', 'Misterio'),
('El Arco del Destino', 'Editorial del Destino', 'Aventura'),
('El Guardián de los Sueños', 'Ediciones del Guardián', 'Fantasía'),
('La Esencia del Miedo', 'Editorial del Miedo', 'Misterio'),
('El Viajero del Tiempo', 'Editorial del Viaje', 'Aventura'),
('La Corona de la Oscuridad', 'Ediciones de la Oscuridad', 'Fantasía'),
('El Secreto del Vampiro', 'Editorial del Vampiro', 'Misterio'),
('La Espada del Honor', 'Editorial del Honor', 'Aventura'),
('El Libro de las Sombras', 'Ediciones de las Sombras', 'Fantasía'),
('El Enigma del Pasado', 'Editorial del Enigma', 'Misterio'),
('La Búsqueda del Tesoro', 'Salamandra', 'Aventura'),
('El Susurro del Silencio', 'Salamandra', 'Fantasía'),
('La Máscara del Engaño', 'Editorial del Engaño', 'Misterio'),
('El Cáliz del Rey', 'Editorial del Rey', 'Aventura'),
('El Legado del Mago', 'Salamandra', 'Fantasía'),
('La Sombra del Asesino', 'Editorial de las Sombras', 'Misterio'),
('La Espada de la Justicia', 'Editorial de la Justicia', 'Aventura'),
('La Corona del Dragón', 'Ediciones del Dragón', 'Fantasía'),
('El Universo: Guía de viaje', 'Salamandra', 'Misterio'),
('El Tesoro del Pirata', 'Editorial del Pirata', 'Aventura');
    
DROP TABLE IF EXISTS libro_autor;
CREATE TABLE libro_autor(
	id_autor INT,
    id_libro INT,
    FOREIGN KEY (id_autor) REFERENCES autor(id),
    FOREIGN KEY (id_libro) REFERENCES libro(id)
    );
    
INSERT INTO libro_autor (id_autor, id_libro) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(3, 6),
(3, 7),
(4, 8),
(4, 9),
(5, 10),
(5, 11),
(6, 12),
(6, 13),
(7, 14),
(7, 15),
(8, 16),
(8, 17),
(9, 18),
(9, 19),
(10, 20),
(10, 21),
(11, 22),
(11, 23),
(12, 24),
(12, 25),
(13, 26),
(13, 27),
(14, 28),
(14, 29),
(15, 30),
(15, 31),
(16, 32),
(16, 33),
(17, 34),
(17, 35),
(18, 36),
(18, 37),
(19, 38),
(19, 39),
(20, 40),
(20, 41),
(21, 42),
(21, 43),
(22, 44),
(22, 45),
(23, 46),
(23, 47),
(24, 48),
(24, 49),
(25, 50),
(25, 51),
(26, 52),
(26, 53),
(27, 54),
(27, 55),
(28, 56),
(28, 57),
(29, 58),
(29, 59),
(30, 60),
(30, 61),
(31, 62),
(31, 63),
(32, 64),
(41,64);

DROP TABLE IF EXISTS estudiante;
CREATE TABLE estudiante(
	id_lector INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(50),
    carrera VARCHAR(50),
    edad TINYINT);

INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad)
VALUES
('Filippo', 'Galli', 'Calle de los Rosales 123, Madrid', 'Informática', 22),
('María', 'López', 'Avenida del Parque 45, Barcelona', 'Ingeniería Biomédica', 23),
('Carlos', 'Martínez', 'Calle de la Luna 67, Valencia', 'Ciencias de la Computación', 21),
('Laura', 'Rodríguez', 'Avenida del Sol 89, Sevilla', 'Ingeniería de Software', 20),
('Daniel', 'Hernández', 'Calle del Mar 12, Málaga', 'Inteligencia Artificial', 24),
('Ana', 'Pérez', 'Avenida del Río 34, Bilbao', 'Ciberseguridad', 22),
('Pedro', 'Gómez', 'Calle de la Montaña 56, Zaragoza', 'Informática', 23),
('Sofía', 'Díaz', 'Avenida de las Flores 78, Alicante', 'Informática', 21),
('Diego', 'Sánchez', 'Calle del Árbol 90, Murcia', 'Informática', 20),
('Lucía', 'Fernández', 'Avenida de los Lagos 23, Granada', 'Robótica', 24),
('José', 'Martínez', 'Calle de los Alpes 45, Madrid', 'Informática', 24),
('Teresa', 'Pérez', 'Avenida del Mar 67, Barcelona', 'Estudios Digitales', 22),
('Roberto', 'García', 'Calle del Pino 89, Valencia', 'Diseño Computacional', 21),
('Inés', 'Fernández', 'Avenida del Cielo 12, Sevilla', 'Ingeniería Biomédica', 20),
('Ana', 'Martínez', 'Calle de la Brisa 34, Bilbao', 'Tecnologías de la Salud', 24),
('Juan', 'Hernández', 'Avenida de los Ríos 56, Zaragoza', 'Informática', 22),
('María', 'Gómez', 'Calle de los Campos 78, Alicante', 'Informática', 21),
('Carlos', 'Sánchez', 'Avenida del Aire 90, Murcia', 'Informática', 20),
('Laura', 'Fernández', 'Calle de la Colina 23, Granada', 'Ingeniería de Gas', 24),
('Daniel', 'Sánchez', 'Avenida de los Pinos 45, Madrid', 'Ingeniería en Geología', 22);

DROP TABLE IF EXISTS prestamo;
CREATE TABLE prestamo(
	id_lector INT,
    id_libro INT,
    fecha_prestamo DATETIME,
    fecha_devolucion DATETIME,
    devuelto BOOLEAN);
    
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 3, '2021-03-16 10:00:00', '2021-07-16 10:00:00', 1),
(2, 12, '2024-03-16 11:00:00', '2024-03-23 11:00:00', 1),
(3, 28, '2024-03-16 12:00:00', '2024-03-23 12:00:00', 0),
(4, 33, '2024-03-16 13:00:00', '2024-03-23 13:00:00', 1),
(5, 7, '2024-03-16 14:00:00', '2024-03-23 14:00:00', 0),
(6, 49, '2024-03-16 15:00:00', '2024-03-23 15:00:00', 1),
(7, 19, '2024-03-16 16:00:00', '2024-03-23 16:00:00', 0),
(8, 6, '2024-03-16 17:00:00', '2024-03-23 17:00:00', 1),
(9, 51, '2024-03-16 18:00:00', '2024-03-23 18:00:00', 0),
(10, 35, '2021-03-16 19:00:00', '2021-07-16 19:00:00', 1),
(11, 47, '2024-03-16 20:00:00', '2024-03-23 20:00:00', 0),
(12, 16, '2024-03-16 21:00:00', '2024-03-23 21:00:00', 1),
(1, 30, '2024-03-16 22:00:00', '2024-03-23 22:00:00', 0),
(14, 40, '2024-03-16 23:00:00', '2024-03-23 23:00:00', 1),
(15, 55, '2024-03-17 10:00:00', '2024-03-24 10:00:00', 0),
(16, 8, '2024-03-17 11:00:00', '2024-03-24 11:00:00', 1),
(17, 32, '2024-03-17 12:00:00', '2024-03-24 12:00:00', 0),
(18, 38, '2024-03-17 13:00:00', '2024-03-24 13:00:00', 1),
(19, 27, '2024-03-17 14:00:00', '2024-03-24 14:00:00', 0),
(20, 45, '2024-03-17 15:00:00', '2024-03-24 15:00:00', 1),
(1, 52, '2024-03-17 16:00:00', '2024-03-24 16:00:00', 0),
(2, 14, '2024-03-17 17:00:00', '2024-03-24 17:00:00', 1),
(3, 2, '2024-03-17 18:00:00', '2024-03-24 18:00:00', 0),
(4, 9, '2024-03-17 19:00:00', '2024-03-24 19:00:00', 1),
(5, 23, '2024-03-17 20:00:00', '2024-03-24 20:00:00', 0),
(6, 34, '2024-03-17 21:00:00', '2024-03-24 21:00:00', 1),
(7, 37, '2024-03-17 22:00:00', '2024-03-24 22:00:00', 0),
(8, 1, '2024-03-17 23:00:00', '2024-03-24 23:00:00', 1),
(9, 18, '2024-03-18 10:00:00', '2024-03-25 10:00:00', 0),
(1, 20, '2024-03-18 11:00:00', '2024-03-25 11:00:00', 1),
(11, 44, '2024-03-18 12:00:00', '2024-03-25 12:00:00', 0),
(12, 5, '2024-03-18 13:00:00', '2024-03-25 13:00:00', 1),
(13, 53, '2024-03-18 14:00:00', '2024-03-25 14:00:00', 0),
(14, 11, '2024-03-18 15:00:00', '2024-03-25 15:00:00', 1),
(15, 4, '2024-03-18 16:00:00', '2024-03-25 16:00:00', 0),
(16, 36, '2024-03-18 17:00:00', '2024-03-25 17:00:00', 1),
(1, 21, '2024-03-18 18:00:00', '2024-03-25 18:00:00', 0),
(18, 25, '2024-03-18 19:00:00', '2024-03-25 19:00:00', 1),
(19, 42, '2024-03-18 20:00:00', '2024-03-25 20:00:00', 0),
(20, 15, '2024-03-18 21:00:00', '2024-03-25 21:00:00', 1);
    
-- Listar los datos de los autores.
SELECT nombre, nacionalidad
FROM autor;
-- Listar nombre y edad de los estudiantes
SELECT nombre,edad 
FROM estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre,  apellido, direccion, carrera, edad
FROM estudiante
WHERE carrera = 'Informática';
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre, nacionalidad
FROM autor
WHERE nacionalidad IN ('Francesa','Italiana');
-- ¿Qué libros no son del área de internet?
SELECT titulo, editorial, area
FROM libro
WHERE area != 'Internet';
-- Listar los libros de la editorial Salamandra.
SELECT id, titulo, editorial, area
FROM libro
WHERE editorial = 'Salamandra';
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT nombre,  apellido, direccion, carrera, edad
FROM estudiante 
WHERE edad > (SELECT AVG(edad) FROM estudiante);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre
FROM estudiante
WHERE LOWER(apellido) LIKE 'g%';
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT autor.nombre
FROM autor
JOIN libro_autor
ON autor.id = libro_autor.id_autor
JOIN libro
ON libro_autor.id_libro = libro.id
WHERE libro.titulo = 'El Universo: Guía de viaje';
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT id, titulo, editorial, area
FROM libro
WHERE id IN (SELECT prestamo.id_libro FROM prestamo JOIN estudiante ON prestamo.id_lector = estudiante.id_lector  WHERE estudiante.nombre = 'Filippo' AND apellido = 'Galli');
-- Listar el nombre del estudiante de menor edad.
SELECT nombre 
FROM estudiante
ORDER BY edad
LIMIT 1;
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT nombre
FROM estudiante
WHERE id_lector IN (SELECT id_lector FROM prestamo);
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT id, titulo, editorial, area
FROM libro
WHERE id IN (SELECT libro_autor.id_libro FROM libro_autor JOIN autor ON libro_autor.id_autor = autor.id  WHERE autor.nombre = 'J.K. Rowling');
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT libro.titulo
FROM libro
JOIN prestamo
ON libro.id = prestamo.id_libro
WHERE DATE(prestamo.fecha_devolucion) = '2021-07-16';