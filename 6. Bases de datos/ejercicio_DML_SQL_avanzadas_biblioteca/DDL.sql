-- Create DB
create database biblioteca_db;

use biblioteca_db;

-- Libro table
create table Libro (
	idLibro INT PRIMARY KEY,
	titulo VARCHAR(50),
	editorial VARCHAR(50),
	area VARCHAR(8)
);

insert into Libro (idLibro, titulo, editorial, area) values (1, 'Mrs', 'Gabcube', 'history');
insert into Libro (idLibro, titulo, editorial, area) values (2, 'Rev', 'Zoombox', 'software');
insert into Libro (idLibro, titulo, editorial, area) values (3, 'Honorable', 'Yodel', 'science');
insert into Libro (idLibro, titulo, editorial, area) values (4, 'Ms', 'Oyoyo', 'science');
insert into Libro (idLibro, titulo, editorial, area) values (5, 'Dr', 'Yodo', 'fiction');
insert into Libro (idLibro, titulo, editorial, area) values (6, 'Dr', 'Livetube', 'fiction');
insert into Libro (idLibro, titulo, editorial, area) values (7, 'Honorable', 'Voonder', 'history');
insert into Libro (idLibro, titulo, editorial, area) values (8, 'Mr', 'Topiclounge', 'fiction');
insert into Libro (idLibro, titulo, editorial, area) values (9, 'Honorable', 'Miboo', 'software');
insert into Libro (idLibro, titulo, editorial, area) values (10, 'Ms', 'Devcast', 'history');

-- Autor table
create table Autor (
	idAutor INT PRIMARY KEY,
	nombre VARCHAR(50),
	nacionalidad VARCHAR(50)
);

insert into Autor (idAutor, nombre, nacionalidad) values (1, 'Cathi', 'Syria');
insert into Autor (idAutor, nombre, nacionalidad) values (2, 'Patton', 'Russia');
insert into Autor (idAutor, nombre, nacionalidad) values (3, 'Faythe', 'China');
insert into Autor (idAutor, nombre, nacionalidad) values (4, 'Devlin', 'Argentina');
insert into Autor (idAutor, nombre, nacionalidad) values (5, 'Steffi', 'Indonesia');
insert into Autor (idAutor, nombre, nacionalidad) values (6, 'Flem', 'China');
insert into Autor (idAutor, nombre, nacionalidad) values (7, 'Rourke', 'Philippines');
insert into Autor (idAutor, nombre, nacionalidad) values (8, 'Guy', 'Indonesia');
insert into Autor (idAutor, nombre, nacionalidad) values (9, 'Merrile', 'Nepal');
insert into Autor (idAutor, nombre, nacionalidad) values (10, 'Rafaela', 'Indonesia');

-- Estudiante table
create table Estudiante (
	idLector INT PRIMARY KEY,
	nombre VARCHAR(50),
	apellido VARCHAR(50),
	direccion VARCHAR(50),
	carrera VARCHAR(16),
	edad INT
);

insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (1, 'Napoleon', 'MacPhee', '18324 Eagan Court', 'Law', 76);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (2, 'Erastus', 'Tracy', '79 Chive Street', 'Law', 41);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (3, 'Maggee', 'Domonkos', '5 Bultman Junction', 'Law', 43);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (4, 'Daveen', 'Fernao', '91 Beilfuss Hill', 'Medicine', 67);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (5, 'Patrizia', 'Jurczyk', '92 Loeprich Parkway', 'Computer Science', 40);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (6, 'Harli', 'Shedden', '631 Sunnyside Circle', 'Business', 58);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (7, 'Kevan', 'Rossborough', '7 Mccormick Plaza', 'Business', 31);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (8, 'Brennan', 'Wilhelmy', '84 Bunker Hill Way', 'Medicine', 65);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (9, 'Hildagard', 'Vedntyev', '3888 Menomonie Terrace', 'Engineering', 38);
insert into Estudiante (idLector, nombre, apellido, direccion, carrera, edad) values (10, 'Mayer', 'Clohissy', '6 Golf Course Way', 'Law', 55);

-- Libro_Autor table
create table Libro_Autor (
	idAutor INT,
    idLibro INT,
    foreign key (idAutor) references Autor(idAutor),
    foreign key (idLibro) references Libro(idLibro)
);

insert into Libro_Autor(idAutor, idLibro) values (1,5);
insert into Libro_Autor(idAutor, idLibro) values (1,6);
insert into Libro_Autor(idAutor, idLibro) values (1,7);
insert into Libro_Autor(idAutor, idLibro) values (2,8);
insert into Libro_Autor(idAutor, idLibro) values (2,9);
insert into Libro_Autor(idAutor, idLibro) values (2,10);
insert into Libro_Autor(idAutor, idLibro) values (3,1);
insert into Libro_Autor(idAutor, idLibro) values (4,2);
insert into Libro_Autor(idAutor, idLibro) values (5,3);
insert into Libro_Autor(idAutor, idLibro) values (6,4);

-- Prestamo table
create table Prestamo(
	idLector INT,
    idLibro INT,
    fechaPrestamo DATETIME,
    fechaDevolucion DATE,
    devuelto BOOLEAN default FALSE,
	foreign key (idLibro) references Libro(idLibro),
	foreign key (idLector) references Estudiante(idLector)
);

insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (1, 1, '2022-01-31', '2021-09-27', true);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (2, 2, '2021-04-14', '2020-09-01', true);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (3, 3, '2022-11-27', '2020-09-09', false);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (4, 4, '2021-01-08', '2021-07-11', true);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (5, 5, '2020-03-17', '2022-11-18', false);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (6, 6, '2020-07-29', '2022-04-04', true);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (7, 7, '2022-04-01', '2021-01-11', false);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (8, 8, '2021-09-16', '2022-03-09', false);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (9, 9, '2022-08-23', '2021-02-27', true);
insert into Prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) values (10, 10, '2020-08-03', '2020-11-01', true);
