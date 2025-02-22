-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: securitydb
-- ------------------------------------------------------
-- Server version	5.7.43

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
-- Table structure for table `ambulancia_placa`
--

DROP TABLE IF EXISTS `ambulancia_placa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ambulancia_placa` (
  `id_ambulancia` bigint(20) NOT NULL AUTO_INCREMENT,
  `estado_ambulancia_placa` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `id_basesamu` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_ambulancia`),
  KEY `FKjkckmn3dhkt2vdkj5q28ymnfb` (`id_basesamu`),
  CONSTRAINT `FKjkckmn3dhkt2vdkj5q28ymnfb` FOREIGN KEY (`id_basesamu`) REFERENCES `base_samu` (`id_base_samu`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ambulancia_placa`
--

LOCK TABLES `ambulancia_placa` WRITE;
/*!40000 ALTER TABLE `ambulancia_placa` DISABLE KEYS */;
INSERT INTO `ambulancia_placa` VALUES (2,'OPERATIVA',NULL,NULL,'EUC 912',2),(4,'OPERATIVA(RECOGER)',NULL,NULL,'EUD 077',4),(5,'OPERATIVA',NULL,NULL,'EUC 927',5),(6,'OPERATIVA',NULL,NULL,'EUC 712',6),(7,'INOPERATIVA',NULL,NULL,'EUD 008',6),(8,'OPERATIVA',NULL,NULL,'EUC 968',1),(9,'OPERATIVA',NULL,NULL,'EUC 950',9),(10,'OPERATIVA',NULL,NULL,'EUC 711',10),(11,'OPERATIVA',NULL,NULL,'EUC 719',11),(13,'OPERATIVA',NULL,NULL,'EUC 742',13),(14,'OPERATIVA',NULL,NULL,'EUD 054',14),(16,'OPERATIVA',NULL,NULL,'EUC 728',9),(17,'OPERATIVA',NULL,NULL,'EUC 992',17),(35,'OPERATIVA',NULL,NULL,'EUC 746',35),(36,'OPERATIVA',NULL,NULL,'EUC 731',8),(37,'OPERATIVA',NULL,NULL,'EUC 754',11),(38,'OPERATIVA(RECOGER)',NULL,NULL,'EUD 047',12),(39,'INOPERATIVA',NULL,NULL,'EUC 713',35),(45,'OPERATIVA',NULL,NULL,'EUC 710',35),(46,'OPERATIVA',NULL,NULL,'EUC 730',35),(47,'EN REPARACION',NULL,NULL,'EUC 734',35),(48,'OPERATIVA',NULL,NULL,'EUC 745',35),(49,'OPERATIVA',NULL,NULL,'EUD 052',35),(50,'INOPERATIVA',NULL,NULL,'EUC 989',15),(51,'EN REPARACION',NULL,NULL,'EUC 721',35),(52,'INOPERATIVA',NULL,NULL,'EUC 749',35),(53,'INOPERATIVA',NULL,NULL,'EUD 083',35),(54,'INOPERATIVA',NULL,NULL,'EUD 096',35),(55,'INOPERATIVA(BAJA)',NULL,NULL,'EUC 720',35),(56,'INOPERATIVA',NULL,NULL,'EUC 735',35),(57,'INOPERATIVA',NULL,NULL,'EUC 740',35),(58,'INOPERATIVA',NULL,NULL,'EUC 747',35),(59,'INOPERATIVA',NULL,NULL,'EUC 755',35),(60,'OPERATIVA',NULL,NULL,'xxx',NULL),(63,'mmm','mmmm','rrrr','mmmm',1),(64,'OPERATIVO','TOYOTA','CLÃSICO','wxyz',3),(65,'OPERATIVO','TOYOTA','CLÃSICO','wxyz',3),(66,'OPERATIVO','TOYOTA','CLÃSICO','YYYY',2),(67,'INOPERATIVA','VOSKWAGEN','NEW BEETLE','ZZZ-699',13),(68,'operativo','toyota','ws-4','ddd-444',8),(69,'OPERATIVA(RECOGER)','VOKSVAGEN','NEW BEETLE','HHH-000',16);
/*!40000 ALTER TABLE `ambulancia_placa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-22 14:21:15
