-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: localhost    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clientes` (
  `dni` int NOT NULL,
  `nombre` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `apellido` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `fechaNacimiento` datetime DEFAULT NULL,
  `ciudad` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `provincia` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (111,'Sergio','Gonzales','1992-01-01 00:00:00','Cordoba','Cordoba'),(123,'Pedro','Gonzales','1997-01-01 00:00:00','Bogota','Bogota'),(222,'Paola','Marquez','1975-01-01 00:00:00','Bogota','Bogota'),(456,'Maria','Perez','1989-01-01 00:00:00','Medellin','Medellin'),(789,'Angelica','Rojas','2000-01-01 00:00:00','Buenos Aires','Buenos Aires');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Planes`
--

DROP TABLE IF EXISTS `Planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Planes` (
  `idPlanes` int NOT NULL AUTO_INCREMENT,
  `velocidadMegas` int DEFAULT NULL,
  `precio` int DEFAULT NULL,
  `descuento` int DEFAULT NULL,
  `dniClientes` int DEFAULT NULL,
  PRIMARY KEY (`idPlanes`),
  KEY `dniClientes_idx` (`dniClientes`),
  CONSTRAINT `dniClientes` FOREIGN KEY (`dniClientes`) REFERENCES `Clientes` (`dni`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Planes`
--

LOCK TABLES `Planes` WRITE;
/*!40000 ALTER TABLE `Planes` DISABLE KEYS */;
INSERT INTO `Planes` VALUES (1,100,400,5,222),(5,500,100,10,111),(20,100,400,10,123),(30,100,400,7,789),(40,100,400,5,456),(41,100,400,5,456);
/*!40000 ALTER TABLE `Planes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-05 11:07:34
