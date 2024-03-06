CREATE SCHEMA `biblioteca_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;

USE biblioteca_db;

CREATE TABLE Libro (
	idLibro INT NOT NULL,
	titulo VARCHAR(100) NOT NULL,
	editorial VARCHAR(100) NOT NULL,
	area VARCHAR(50) NOT NULL,
	PRIMARY KEY (idLibro)
);

CREATE TABLE Autor (
	idAutor INT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	nacionalidad VARCHAR(50) NOT NULL,
	PRIMARY KEY (idAutor)
);

CREATE TABLE Estudiante (
	idLector INT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	direccion VARCHAR(100) NOT NULL,
	carrera VARCHAR(100) NOT NULL,
	edad TINYINT NOT NULL,
	PRIMARY KEY (idLector)
);

CREATE TABLE LibroAutor (
	idAutor INT NOT NULL,
	idLibro INT NOT NULL,
	FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
	FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

CREATE TABLE Prestamo (
	idLector INT NOT NULL,
	idLibro INT NOT NULL,
	fechaPrestamo DATE NOT NULL,
	fechaDevolucion DATE NOT NULL,
	devuelto BOOLEAN NOT NULL,
	FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
	FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);