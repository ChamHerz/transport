-- MySQL dump 10.13  Distrib 5.7.23, for Win64 (x86_64)
--
-- Host: localhost    Database: transportdb
-- ------------------------------------------------------
-- Server version	5.7.23-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bulto`
--

DROP TABLE IF EXISTS `bulto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bulto` (
  `id_bulto` int(11) NOT NULL AUTO_INCREMENT,
  `id_ciudad_origen` int(11) DEFAULT NULL,
  `id_ciudad_destino` int(11) DEFAULT NULL,
  `pesoKG` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_bulto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bulto`
--

LOCK TABLES `bulto` WRITE;
/*!40000 ALTER TABLE `bulto` DISABLE KEYS */;
INSERT INTO `bulto` VALUES (1,1,2,125.23),(2,3,4,235.21),(3,NULL,NULL,302.55);
/*!40000 ALTER TABLE `bulto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `camion`
--

DROP TABLE IF EXISTS `camion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `camion` (
  `id_camion` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(45) NOT NULL,
  `pesoMaximo` decimal(10,2) NOT NULL,
  `kmPorHoraMedio` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_camion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `camion`
--

LOCK TABLES `camion` WRITE;
/*!40000 ALTER TABLE `camion` DISABLE KEYS */;
INSERT INTO `camion` VALUES (1,'ISQ118',5315.21,100.53),(2,'WXF351',6351.23,95.53);
/*!40000 ALTER TABLE `camion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciudad` (
  `id_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,'Cordoba'),(2,'Capital Federal'),(3,'Rosario'),(4,'La Plata');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Roberto','Lucero','Hipolito Yrigoyen 1235','1130408435'),(2,'Alejandro','Fernandez','Martinez de Hoz 5321','1152131548');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conductor` (
  `id_conductor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `id_camion` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_conductor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conductor`
--

LOCK TABLES `conductor` WRITE;
/*!40000 ALTER TABLE `conductor` DISABLE KEYS */;
INSERT INTO `conductor` VALUES (1,'Adriel','Chambi','32875131','Correa de Saa 1909','Cordoba','1140809480',1),(2,'Ulises','Gustamantes','33512651','Maipu 531','Buenos Aires','1153154861',2),(3,'Javier','Rodriguez','30215315','Independencia 2313','Santa Fe','1123545312',NULL);
/*!40000 ALTER TABLE `conductor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,1),(2,2),(3,1);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remolque`
--

DROP TABLE IF EXISTS `remolque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remolque` (
  `id_remolque` int(11) NOT NULL AUTO_INCREMENT,
  `pesoMaximo` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_remolque`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remolque`
--

LOCK TABLES `remolque` WRITE;
/*!40000 ALTER TABLE `remolque` DISABLE KEYS */;
INSERT INTO `remolque` VALUES (1,1500.00),(2,1250.00);
/*!40000 ALTER TABLE `remolque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ruta` (
  `id_ruta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id_ruta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruta`
--

LOCK TABLES `ruta` WRITE;
/*!40000 ALTER TABLE `ruta` DISABLE KEYS */;
INSERT INTO `ruta` VALUES (1,'Cordoba - Capital Federal'),(2,'Capital Federal - Cordoba');
/*!40000 ALTER TABLE `ruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sistema`
--

DROP TABLE IF EXISTS `sistema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistema` (
  `id_sistema` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  PRIMARY KEY (`id_sistema`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sistema`
--

LOCK TABLES `sistema` WRITE;
/*!40000 ALTER TABLE `sistema` DISABLE KEYS */;
INSERT INTO `sistema` VALUES (1,'Transport','Adriel Chambi');
/*!40000 ALTER TABLE `sistema` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-18 13:59:04
