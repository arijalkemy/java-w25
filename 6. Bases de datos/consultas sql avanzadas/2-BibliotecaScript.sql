-- MySQL dump 10.13  Distrib 8.2.0, for macos13 (arm64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autor` (
  `idAutor` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES (1,'Dewitt','Indonesia'),(2,'Richmond','Francia'),(3,'Dennet','Burkina Faso'),(4,'J.K. Rowling','Eritrea'),(5,'Gavrielle','Sweden'),(6,'Shari','Bulgaria'),(7,'Damon','Italia'),(8,'Aymer','Colombia'),(9,'Ariela','Francia'),(10,'Ryan','Italia');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante` (
  `idLector` int NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `carrera` varchar(50) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  PRIMARY KEY (`idLector`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
INSERT INTO `estudiante` VALUES (1,'Gerardo','Edgeworth','9770 Goodland Plaza','informatica',28),(2,'Filippo','Galli','39 Glendale Crossing','Programmer Analyst I',28),(3,'Gasper','Gotham','9 Stuart Lane','informatica',18),(4,'Shandeigh','Swinburne','0067 Green Ridge Lane','General Manager',36),(5,'Yves','Flaherty','784 Bartelt Crossing','informatica',87),(6,'Kessia','McOnie','6562 Clemons Alley','VP Marketing',33),(7,'Noelani','McRorie','44 Carpenter Point','Legal Assistant',98),(8,'Jamima','Grantsev','3 Leroy Crossing','informatica',99),(9,'Fredi','Hallad','9 Main Parkway','Senior Editor',74),(10,'Brennen','Orvis','2 Thierer Hill','Civil Engineer',90);
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `idLibro` int NOT NULL,
  `Titulo` varchar(50) DEFAULT NULL,
  `Editorial` varchar(50) DEFAULT NULL,
  `Area` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'RFK Must Die: The Assassination of Bobby Kennedy','Salamandra','Documentary'),(2,'Trouble with Bliss, The','Corabel','internet'),(3,'El Universo: Guía de viaje','Elnore','internet'),(4,'Flying Deuces, The','Salamandra','Bases de Datos'),(5,'Simple Life of Noah Dearborn, The','Temp','Drama'),(6,'Ah, Wilderness!','Salamandra','internet'),(7,'Sione\'s Wedding (Samoan Wedding)','Bibi','Bases de Datos'),(8,'Assault, The (Aanslag, De)','Salamandra','Drama|Romance|War'),(9,'Base de Datos','Colleen','Drama'),(10,'Libeled Lady','Paxon','Bases de Datos');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libroautor`
--

DROP TABLE IF EXISTS `libroautor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libroautor` (
  `idAutor` int NOT NULL,
  `idLibro` int NOT NULL,
  PRIMARY KEY (`idAutor`,`idLibro`),
  KEY `idLibro` (`idLibro`),
  CONSTRAINT `libroautor_ibfk_1` FOREIGN KEY (`idAutor`) REFERENCES `autor` (`idAutor`),
  CONSTRAINT `libroautor_ibfk_2` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libroautor`
--

LOCK TABLES `libroautor` WRITE;
/*!40000 ALTER TABLE `libroautor` DISABLE KEYS */;
INSERT INTO `libroautor` VALUES (1,1),(2,2),(3,3),(5,3),(8,3),(4,4),(6,6),(7,7),(9,9),(10,10);
/*!40000 ALTER TABLE `libroautor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestamo` (
  `idLector` int NOT NULL,
  `idLibro` int NOT NULL,
  `FechaPrestamo` date DEFAULT NULL,
  `FechaDevolucion` date DEFAULT NULL,
  `Devuelto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idLector`,`idLibro`),
  KEY `idLibro` (`idLibro`),
  CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`idLector`) REFERENCES `estudiante` (`idLector`),
  CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`idLibro`) REFERENCES `libro` (`idLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
INSERT INTO `prestamo` VALUES (1,1,'2024-01-07','2021-05-28','1'),(2,9,'2023-10-19','2023-09-02','0'),(3,3,'2023-08-23','2021-07-16','0'),(4,4,'2023-09-24','2021-04-04','0'),(5,5,'2023-07-08','2020-02-02','1'),(6,6,'2023-07-06','2021-07-16','1'),(7,7,'2023-12-23','2023-09-03','1'),(8,8,'2023-06-03','2023-05-10','1'),(9,9,'2023-04-11','2023-10-17','0'),(10,10,'2023-12-17','2023-07-25','0');
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
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

-- Dump completed on 2024-03-06 20:04:28
