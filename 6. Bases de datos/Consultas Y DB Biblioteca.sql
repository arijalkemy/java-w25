CREATE DATABASE  IF NOT EXISTS `biblioteca_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca_db`;
-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: localhost    Database: biblioteca_db
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `id_autor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(256) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nacionalidad` varchar(256) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `id_lector` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `direccion` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `carrera` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `id_libro` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `editorial` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `area` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro_autor`
--

DROP TABLE IF EXISTS `libro_autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro_autor` (
  `id_autor` int DEFAULT NULL,
  `id_libro` int DEFAULT NULL,
  KEY `id_autor` (`id_autor`),
  KEY `id_libro` (`id_libro`),
  CONSTRAINT `libro_autor_ibfk_1` FOREIGN KEY (`id_autor`) REFERENCES `autor` (`id_autor`),
  CONSTRAINT `libro_autor_ibfk_2` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro_autor`
--

LOCK TABLES `libro_autor` WRITE;
/*!40000 ALTER TABLE `libro_autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro_autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamo` (
  `id_prestamo` int NOT NULL AUTO_INCREMENT,
  `id_lector` int DEFAULT NULL,
  `id_libro` int DEFAULT NULL,
  `fecha_prestamo` date DEFAULT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `devuelto` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_prestamo`),
  KEY `id_lector` (`id_lector`),
  KEY `id_libro` (`id_libro`),
  CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`id_lector`) REFERENCES `estudiante` (`id_lector`),
  CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`id_libro`) REFERENCES `libro` (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-06 12:15:18
# Llenando la tabla autor
INSERT INTO autor (nombre, nacionalidad) VALUES
('Gabriel García Márquez', 'Colombiana'),
('Julio Cortázar', 'Argentino'),
('Mario Vargas Llosa', 'Peruano');

# Llenando la tabla estudiante
INSERT INTO estudiante (nombre, apellido, direccion, carrera, edad) VALUES
('Juan', 'Pérez', 'Av. Libertador 123', 'Ing. Informática', 22),
('María', 'Gómez', 'Calle San Martín 456', 'Lic. en Letras', 25),
('Carlos', 'López', 'Av. Rivadavia 789', 'Medicina', 23);
INSERT INTO libro (titulo, editorial, area) VALUES
('Cien años de soledad', 'Editorial Sudamericana', 'Realismo mágico'),
('Rayuela', 'Editorial Sudamericana', 'Ficción'),
('La ciudad y los perros', 'Editorial Seix Barral', 'Novela');

# Llenando la tabla libro_autor
INSERT INTO libro_autor (id_libro, id_autor) VALUES
(1, 1),
(2, 2),
(3, 3);
INSERT INTO prestamo (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2024-03-01', '2024-03-15', 1),
(2, 2, '2024-03-02', '2024-03-16', 1),
(3, 3, '2024-03-03', NULL, 0);
# Listar los datos de los autores.
SELECT * FROM autor a ;
# Listar nombre y edad de los estudiantes
select e.nombre , e.edad from estudiante e ;
# ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre  from estudiante e where e.carrera = 'Ing. Informática';
# ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor a WHERE a.nacionalidad ="Frances" OR a.nacionalidad = "Italiano";
# ¿Qué libros no son del área de internet?
select * from libro l where l.area != "internet";
# Listar los libros de la editorial Salamandra.
SELECT * from libro l WHERE l.editorial = "Salamanca";
# Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiante e WHERE e.edad  > (select AVG(edad) from estudiante e2);
(select AVG(edad) from estudiante e2);
# Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select e.nombre From estudiante e where e.apellido  LIKE "G%";
# Listar los autores del libro “Rayuela". (Se debe listar solamente los nombres).
SELECT a.nombre  FROM autor a 
INNER JOIN libro_autor la on a.id_autor = la.id_autor 
INNER JOIN libro l on la.id_libro = l.id_libro WHERE l.titulo = "Rayuela" ;
# ¿Qué libros se prestaron al lector “Juan 'Pérez”?
SELECT * FROM libro l 
inner join prestamo p ON l.id_libro = p.id_libro 
where p.id_lector  = 
(SELECT id_lector from estudiante e WHERE e.nombre ="Juan" AND e.apellido = "Pérez");
# Listar el nombre del estudiante de menor edad.
select e.nombre from estudiante e order by e.edad Limit 1;
select e.nombre from estudiante e where e.edad  = (SElect MIN(edad) from estudiante e2 );
# Listar nombres de los estudiantes a los que se prestaron libros de Ficcion.

SELECT e.nombre from estudiante e
inner join prestamo p on e.id_lector = p.id_lector 
inner join libro l on p.id_libro = l.id_libro 
where l.area = 'Ficción';
# Listar los libros que pertenecen a la autora Gabriel García Márquez.
SELECT * from libro l inner join libro_autor la 
on l.id_libro  = la.id_libro 
where la.id_autor = (SELECT a.id_autor from autor a where a.nombre = "Gabriel García Márquez" );
# Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.titulo  from libro l inner join prestamo p 
on l.id_libro = p.id_libro where p.fecha_devolucion = "2024-03-15";


