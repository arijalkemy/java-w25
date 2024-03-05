-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (x86_64)
--
-- Host: localhost    Database: servicio_internet
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `dni` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `fecha_nacimiento` datetime NOT NULL,
  `provincia` varchar(50) NOT NULL,
  `ciudad` varchar(255) NOT NULL,
  PRIMARY KEY (`dni`,`ciudad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Luis','Camacho','1998-06-13 00:00:00','Cordoba','Bogota'),(1,'Mario','Linares','1998-12-13 00:00:00','Cundinamarca','Buenos Aires'),(2,'Mario','Linares','1998-12-13 00:00:00','Cundinamarca','Buenos Aires'),(3,'Luis','Linares','2001-07-15 00:00:00','Cordoba','Buenos Aires'),(4,'Luis','Rodriguez','2000-03-17 00:00:00','California','Buenos Aires'),(5,'Luis','Pachon','1996-05-25 00:00:00','Cundinamarca','Cali'),(6,'Lis','Camaho','1989-07-23 00:00:00','Cordoba','Buenos Aires'),(7,'Lus','Caacho','1987-11-19 00:00:00','California','Bogota'),(8,'Lis','Camaho','1978-08-14 00:00:00','California','Cali'),(9,'Luis','Cmacho','1989-03-22 00:00:00','Cordoba','Buenos Aires'),(10,'Lis','Camcho','1999-01-11 00:00:00','Cundinamarca','Cali'),(11,'Lus','Aamacho','1993-02-14 00:00:00','Cundinamarca','Bogota');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_internet`
--

DROP TABLE IF EXISTS `plan_internet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plan_internet` (
  `id` int NOT NULL,
  `customer_id` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `velocidad` int NOT NULL,
  `precio` varchar(45) NOT NULL,
  `descuento` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id_idx` (`customer_id`),
  CONSTRAINT `FK_CLIENTE_PLAN_INTERNET` FOREIGN KEY (`customer_id`) REFERENCES `cliente` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_internet`
--

LOCK TABLES `plan_internet` WRITE;
/*!40000 ALTER TABLE `plan_internet` DISABLE KEYS */;
INSERT INTO `plan_internet` VALUES (1,1,'plan1',500,'500.50','10'),(2,1,'plan2',500,'500.50','10'),(3,4,'plan3',500,'500.50','10'),(4,2,'plan1',500,'500.50','10'),(5,5,'plan1',500,'500.50','10');
/*!40000 ALTER TABLE `plan_internet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-05 11:02:46
