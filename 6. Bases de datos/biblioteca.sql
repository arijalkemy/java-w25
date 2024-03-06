-- MySQL dump 10.13  Distrib 8.3.0, for macos14.2 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Autor`
--

DROP TABLE IF EXISTS `Autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Autor` (
  `id_autor` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `nacionalidad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Autor`
--

LOCK TABLES `Autor` WRITE;
/*!40000 ALTER TABLE `Autor` DISABLE KEYS */;
INSERT INTO `Autor` VALUES (1,'Carlos','Argentina'),(2,'Pedro','Italiana'),(3,'Lara','Francesa'),(4,'J.K. Rowling','Inglesa');
/*!40000 ALTER TABLE `Autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Estudiante`
--

DROP TABLE IF EXISTS `Estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Estudiante` (
  `id_lector` int NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `carrera` varchar(100) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`id_lector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Estudiante`
--

LOCK TABLES `Estudiante` WRITE;
/*!40000 ALTER TABLE `Estudiante` DISABLE KEYS */;
INSERT INTO `Estudiante` VALUES (1,'Juan','Alavrez','numero1','astronommia',18),(2,'Pedro','Juarez','direccion3','Informatica',24),(3,'German','Garmendia','direccion4','Astrologia',19),(44,'Filippo','Galli','direccion3','Informatica',31);
/*!40000 ALTER TABLE `Estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Libro`
--

DROP TABLE IF EXISTS `Libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Libro` (
  `id_libro` int NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `editorial` varchar(100) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Libro`
--

LOCK TABLES `Libro` WRITE;
/*!40000 ALTER TABLE `Libro` DISABLE KEYS */;
INSERT INTO `Libro` VALUES (1,'Libro1','Salamandra','Informatica'),(2,'libro2','editorial2','Internet'),(3,'El Universo: Guía de viaje','Salamandra','Internet'),(4,'BD 1','Informatica','Base de datos');
/*!40000 ALTER TABLE `Libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LibroAutor`
--

DROP TABLE IF EXISTS `LibroAutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LibroAutor` (
  `id_libro` int NOT NULL,
  `id_autor` int NOT NULL,
  PRIMARY KEY (`id_libro`,`id_autor`),
  KEY `LibroAutor_Autor_FK` (`id_autor`),
  CONSTRAINT `LibroAutor_Autor_FK` FOREIGN KEY (`id_autor`) REFERENCES `Autor` (`id_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LibroAutor`
--

LOCK TABLES `LibroAutor` WRITE;
/*!40000 ALTER TABLE `LibroAutor` DISABLE KEYS */;
INSERT INTO `LibroAutor` VALUES (3,1),(3,2),(2,4);
/*!40000 ALTER TABLE `LibroAutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Prestamo`
--

DROP TABLE IF EXISTS `Prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Prestamo` (
  `id_lector` int NOT NULL,
  `id_libro` int NOT NULL,
  `fecha_prestamo` date DEFAULT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  `devuelto` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_lector`,`id_libro`),
  KEY `Prestamo_Libro_FK` (`id_libro`),
  CONSTRAINT `Prestamo_Estudiante_FK` FOREIGN KEY (`id_lector`) REFERENCES `Estudiante` (`id_lector`),
  CONSTRAINT `Prestamo_Libro_FK` FOREIGN KEY (`id_libro`) REFERENCES `Libro` (`id_libro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Prestamo`
--

LOCK TABLES `Prestamo` WRITE;
/*!40000 ALTER TABLE `Prestamo` DISABLE KEYS */;
INSERT INTO `Prestamo` VALUES (1,2,'2018-12-01','2021-07-16',_binary '\0'),(1,4,'2018-12-01','2018-12-01',_binary '\0'),(44,1,'2018-12-01','2018-12-01',_binary '');
/*!40000 ALTER TABLE `Prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'biblioteca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-06 12:44:51

-- Listar los datos de los autores.
SELECT *FROM Autor a ;
-- Listar nombre y edad de los estudiantes
select nombre, edad from estudiante;
-- ¿Qué estudiantes pertenecen a la carrera informática?
select * from estudiante where carrera = "Informatica";
-- ¿Qué autores son de nacionalidad francesa o italiana?
select * from autor where nacionalidad = "francesa" or nacionalidad = "italiana";
-- ¿Qué libros no son del área de internet?
select * from libro  where area !="Internet";
-- Listar los libros de la editorial Salamandra.
select * from libro  where editorial ="Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM Estudiante e WHERE edad > (SELECT AVG(edad) from Estudiante e2);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre from Estudiante e WHERE e.apellido LIKE "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT nombre  from Autor a
inner join LibroAutor la on la.id_autor = a.id_autor
INNER JOIN  Libro l on l.id_libro = la.id_libro
where l.titulo = "El Universo: Guía de viaje";
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.* From Libro l inner join Prestamo p on p.id_libro =l.id_libro
INNER JOIN Estudiante e on p.id_lector = e.id_lector
WHERE e.nombre = "Filippo" and e.apellido = "Galli";
-- Listar el nombre del estudiante de menor edad.
SELECT nombre from Estudiante e WHERE  edad =  (select min(edad) from Estudiante );
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT nombre from Estudiante e inner join Prestamo p on p.id_lector = e.id_lector
INNER join Libro l on l.id_libro = p.id_libro
WHERE l.area = "Base de datos";
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* from Libro l inner join LibroAutor la  on la.id_libro = l.id_libro
INNER JOIN Autor a on la.id_autor = a.id_autor
WHERE a.nombre = "J.K. Rowling" ;
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo from Libro l inner join Prestamo p on p.id_libro = l.id_libro WHERE p.fecha_devolucion = "2021-07-16";
