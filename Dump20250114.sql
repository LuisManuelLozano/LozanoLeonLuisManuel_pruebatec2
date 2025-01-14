-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: turnero1
-- ------------------------------------------------------
-- Server version	8.0.40

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
-- Table structure for table `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudadano` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `DNI` varchar(255) DEFAULT NULL,
  `TELEFONO` varchar(255) DEFAULT NULL,
  `APELLIDO` varchar(255) DEFAULT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudadano`
--

LOCK TABLES `ciudadano` WRITE;
/*!40000 ALTER TABLE `ciudadano` DISABLE KEYS */;
INSERT INTO `ciudadano` VALUES (1,'52382173h','600626907','Lozano Leon','Luis Manuel'),(2,'11111111','1111111111111','Carballo','Miguel Angel'),(3,'2222222222222','22222222222','Amador','vicente '),(4,'3333333333333','333333333333','de las heras','antonio'),(5,'44444444444444','444444444444','Crespo','Enrique'),(6,'55555555555','5555555555555','Leon','Mar'),(7,'6666666666666','66666666666666','Parreno Lopez','Maria Jose'),(8,'777777777777777','77777777777777','LOZANO LEON','Jose Carlos'),(9,'88888888888888','88888888888888','Leon Moreno','Maria Teresa'),(10,'99999999999999','99999999999999','Poyatos','JoaquÃ­n'),(11,'12121212121','212121212121','Zamora','ricardo'),(13,'313131313134','131313131314','Parreno','Jose'),(14,'414141414142','69696969','Lopez Lopez','Maria Pascuala'),(15,'85858585','4414145151','Lopez Lopez','LUIS MIGUEL'),(21,'45454545454','600626907','perez','josÃÂ©'),(22,'78787878','87878787','Zamora','ricardo'),(24,'44454545555','2323323232','Arimatea','JosÃ©'),(25,'44454545555','2323323232','PARRENO','ANDRES '),(26,'86886385','647033867','Parreno Lopez','Maria Jose'),(27,'344344','433433','Del Pozo','Enrique'),(28,'546645464','2324232546','Hache','Eva'),(29,'4687','3874001','dieguez','pacojo'),(30,'76876987','607888787','Tormo','ricardo'),(37,'4805555','08094790','gonzalez','felipe '),(38,'444445666','4545454545','urizar','juan');
/*!40000 ALTER TABLE `ciudadano` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',1350);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `ID` bigint NOT NULL AUTO_INCREMENT,
  `ATENDIDO` varchar(255) DEFAULT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `NUMERO` varchar(255) DEFAULT NULL,
  `ciudadano_id` bigint NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_TURNO_ciudadano_id` (`ciudadano_id`),
  CONSTRAINT `FK_TURNO_ciudadano_id` FOREIGN KEY (`ciudadano_id`) REFERENCES `ciudadano` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1304 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (151,'2','ayudas','2025-01-11','92353',1),(251,'2','subsidios','2025-01-22','7',3),(301,'2','vacaciones','2025-01-18','25',8),(351,'3','fiestas','2025-01-14','1',11),(401,'3','puente','2025-01-22','19',10),(451,'3','cosas','2025-01-22','19',7),(501,'2','cosas','2025-01-14','19',14),(551,'3','mas cosas','2025-01-22','29',30),(701,'3','carnet Joven','2025-01-22','251644',13),(801,'2','z<syhgdajthe','2025-01-22','92353',5),(1151,'2','eui5i','2025-01-24','struj',3),(1201,'2','pilÃ³n','2025-01-01','euy4we7u',4),(1301,'2','2756876','2025-01-22','92353',13),(1302,'2','otras cosas','2025-01-17','yww4u',4);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-14  3:53:14
