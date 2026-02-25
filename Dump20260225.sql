-- MySQL dump 10.13  Distrib 8.0.45, for Win64 (x86_64)
--
-- Host: localhost    Database: bancodb
-- ------------------------------------------------------
-- Server version	9.6.0

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '7f11cb0d-fa51-11f0-a48f-b42e999faf79:1-281';

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `IdCliente` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(15) NOT NULL,
  `ApellidoPaterno` varchar(30) NOT NULL,
  `ApellidoMaterno` varchar(30) NOT NULL,
  `Domicilio` varchar(80) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Contrasenia` varchar(12) NOT NULL,
  `FechaRegistro` date NOT NULL,
  PRIMARY KEY (`IdCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Luis Antonio','Garcia','Garcia','No Reeleccion','2006-08-06','123','2026-02-21'),(2,'Jaime Alberto','Garcia','Garcia','No Reelecion','2006-09-07','111','2026-02-22');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuentas`
--

DROP TABLE IF EXISTS `cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuentas` (
  `IdCuenta` int NOT NULL AUTO_INCREMENT,
  `NumeroCuenta` varchar(20) NOT NULL,
  `FechaApertura` date NOT NULL,
  `Saldo` decimal(12,2) NOT NULL,
  `Estado` varchar(20) NOT NULL,
  `IdCliente` int NOT NULL,
  PRIMARY KEY (`IdCuenta`),
  UNIQUE KEY `NumeroCuenta` (`NumeroCuenta`),
  KEY `IdCliente` (`IdCliente`),
  CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `clientes` (`IdCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuentas`
--

LOCK TABLES `cuentas` WRITE;
/*!40000 ALTER TABLE `cuentas` DISABLE KEYS */;
INSERT INTO `cuentas` VALUES (1,'00000001771712674780','2026-02-21',35570.00,'ACTIVA',1),(2,'00000001771816380346','2026-02-22',5000.00,'ACTIVA',2);
/*!40000 ALTER TABLE `cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operaciones`
--

DROP TABLE IF EXISTS `operaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operaciones` (
  `IdOperacion` int NOT NULL AUTO_INCREMENT,
  `FechaHora` datetime NOT NULL,
  `TipoOperacion` varchar(50) NOT NULL,
  `IdCuenta` int NOT NULL,
  PRIMARY KEY (`IdOperacion`),
  KEY `IdCuenta` (`IdCuenta`),
  CONSTRAINT `operaciones_ibfk_1` FOREIGN KEY (`IdCuenta`) REFERENCES `cuentas` (`IdCuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operaciones`
--

LOCK TABLES `operaciones` WRITE;
/*!40000 ALTER TABLE `operaciones` DISABLE KEYS */;
INSERT INTO `operaciones` VALUES (1,'2026-02-21 16:01:49','RETIROSINTARJETA',1),(2,'2026-02-22 20:06:31','RETIROSINTARJETA',1),(3,'2026-02-22 20:08:16','RETIROSINTARJETA',1);
/*!40000 ALTER TABLE `operaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retirossincuenta`
--

DROP TABLE IF EXISTS `retirossincuenta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `retirossincuenta` (
  `IdOperacion` int NOT NULL,
  `Folio` int NOT NULL,
  `ContraseñaRetiro` varchar(8) NOT NULL,
  `Monto` decimal(12,2) NOT NULL,
  `FechaHoraSolicitud` datetime NOT NULL,
  `FechaHoraCobro` datetime DEFAULT NULL,
  PRIMARY KEY (`IdOperacion`),
  UNIQUE KEY `Folio` (`Folio`),
  CONSTRAINT `retirossincuenta_ibfk_1` FOREIGN KEY (`IdOperacion`) REFERENCES `operaciones` (`IdOperacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retirossincuenta`
--

LOCK TABLES `retirossincuenta` WRITE;
/*!40000 ALTER TABLE `retirossincuenta` DISABLE KEYS */;
INSERT INTO `retirossincuenta` VALUES (1,714908794,'43770590',400.00,'2026-02-21 16:01:49','2026-02-21 16:04:24'),(2,815991467,'25476908',4000.00,'2026-02-22 20:06:31','2026-02-22 20:07:14'),(3,816096478,'95126062',30.00,'2026-02-22 20:08:16','2026-02-22 20:08:52');
/*!40000 ALTER TABLE `retirossincuenta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transferencias`
--

DROP TABLE IF EXISTS `transferencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transferencias` (
  `IdOperacion` int NOT NULL,
  `Monto` decimal(12,2) NOT NULL,
  `Concepto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdOperacion`),
  CONSTRAINT `transferencias_ibfk_1` FOREIGN KEY (`IdOperacion`) REFERENCES `operaciones` (`IdOperacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transferencias`
--

LOCK TABLES `transferencias` WRITE;
/*!40000 ALTER TABLE `transferencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `transferencias` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-02-25 15:07:16
