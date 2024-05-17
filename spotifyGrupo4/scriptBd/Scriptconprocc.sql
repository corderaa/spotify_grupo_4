CREATE DATABASE  IF NOT EXISTS `reto4_grupo4` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `reto4_grupo4`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: reto4_grupo4
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `accountId` int NOT NULL AUTO_INCREMENT,
  `accountdni` varchar(9) NOT NULL,
  `accountname` varchar(50) NOT NULL,
  `accountType` enum('premium','free','admin') NOT NULL,
  `accountmiddleName` varchar(50) NOT NULL,
  `registryDate` date DEFAULT NULL,
  `last_login` date DEFAULT NULL,
  `isblocked` tinyint(1) DEFAULT '0',
  `accountsurname` varchar(50) NOT NULL,
  `accountbirthDate` date NOT NULL,
  `accountpostCode` int NOT NULL,
  `accountcity` text NOT NULL,
  `accountcountry` text NOT NULL,
  `accountPassword` text NOT NULL,
  PRIMARY KEY (`accountId`),
  UNIQUE KEY `accountdni` (`accountdni`),
  CONSTRAINT `valid_birth_date` CHECK ((`accountbirthDate` < sysdate())),
  CONSTRAINT `valid_DNI` CHECK (regexp_like(`accountdni`,_utf8mb4'^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]')),
  CONSTRAINT `valid_password_account` CHECK ((length(`accountPassword`) > 6))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'12345679P','Prueba','admin','Doe','2024-05-07',NULL,0,'Smith','1990-03-12',28001,'Madrid','Spain','prueba1'),(2,'12345678Z','John','premium','Doe','2024-05-08',NULL,0,'Smith','1990-02-15',28001,'Madrid','Spain','password123'),(3,'87654321A','Alice','free','Smith','2024-05-08',NULL,0,'Johnson','1985-07-20',8001,'Barcelona','Spain','securepass123'),(4,'23456789B','Emily','premium','Taylor','2024-05-08',NULL,0,'Brown','1995-11-10',41001,'Seville','Spain','strongpassword'),(5,'34567890C','Michael','admin','Johnson','2024-05-08',NULL,0,'Williams','1980-04-25',28080,'Madrid','Spain','adminpass'),(6,'45678901D','Sophia','free','Miller','2024-05-08',NULL,0,'Martinez','1992-09-30',8015,'Barcelona','Spain','sophia123'),(7,'56789012E','David','premium','Brown','2024-05-08',NULL,0,'Garcia','1988-12-05',29010,'Malaga','Spain','david1988'),(8,'67890123F','Emma','free','Davis','2024-05-08',NULL,0,'Lopez','1997-06-12',46001,'Valencia','Spain','passwordemma'),(9,'78901234G','James','premium','Wilson','2024-05-08',NULL,0,'Fernandez','1983-03-18',48002,'Bilbao','Spain','jameswilson'),(10,'89012345H','Olivia','free','Harris','2024-05-08',NULL,0,'Sanchez','1994-08-08',3002,'Alicante','Spain','olivia94'),(11,'90123456J','William','admin','Anderson','2024-05-08',NULL,0,'Gomez','1975-01-22',41010,'Seville','Spain','williamadmin');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `band`
--

DROP TABLE IF EXISTS `band`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `band` (
  `contentCreatorId` int NOT NULL,
  `members` int NOT NULL,
  PRIMARY KEY (`contentCreatorId`),
  CONSTRAINT `fk_band_contentCreatorId` FOREIGN KEY (`contentCreatorId`) REFERENCES `contentcreator` (`contentCreatorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `band`
--

LOCK TABLES `band` WRITE;
/*!40000 ALTER TABLE `band` DISABLE KEYS */;
INSERT INTO `band` VALUES (1,4),(3,3),(5,5);
/*!40000 ALTER TABLE `band` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content`
--

DROP TABLE IF EXISTS `content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `content` (
  `contentId` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `duration` time NOT NULL,
  `numberReproductions` int DEFAULT '0',
  `contentType` enum('single','podcast') NOT NULL,
  PRIMARY KEY (`contentId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content`
--

LOCK TABLES `content` WRITE;
/*!40000 ALTER TABLE `content` DISABLE KEYS */;
INSERT INTO `content` VALUES (1,'Song 1','00:03:30',10000,'single'),(2,'Song 2','00:04:15',7500,'single'),(3,'Song 3','00:03:45',12000,'single'),(4,'Song 4','00:03:10',8500,'single'),(5,'Song 5','00:04:00',11000,'single'),(6,'Song 6','00:03:20',9000,'single'),(7,'Song 7','00:03:55',10500,'single'),(8,'Song 8','00:04:30',8000,'single'),(9,'Song 9','00:03:40',9500,'single'),(10,'Song 10','00:04:20',11500,'single'),(11,'Tech Talk - Episode 1','00:30:00',5000,'podcast'),(12,'History Explained - Episode 1','00:45:00',3500,'podcast'),(13,'Science Stories - Episode 1','00:20:00',6000,'podcast'),(14,'True Crime Tales - Episode 1','00:50:00',4200,'podcast'),(15,'Health Matters - Episode 1','00:35:00',7000,'podcast'),(16,'Artistic Insights - Episode 1','00:25:00',5500,'podcast'),(17,'Travel Diaries - Episode 1','00:40:00',4800,'podcast'),(18,'Tech Talk - Episode 2','00:28:00',5200,'podcast'),(19,'History Explained - Episode 2','00:42:00',3700,'podcast'),(20,'Science Stories - Episode 2','00:22:00',6200,'podcast');
/*!40000 ALTER TABLE `content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contentcreator`
--

DROP TABLE IF EXISTS `contentcreator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contentcreator` (
  `contentCreatorId` int NOT NULL AUTO_INCREMENT,
  `contentCreatorName` text NOT NULL,
  `contentCreatorReproductionNumber` int NOT NULL DEFAULT '0',
  `contentCreatorRegistrationDate` date NOT NULL,
  `contentCreatorDescription` text DEFAULT (_utf8mb4'description empty'),
  `contentCreatorImage` blob,
  PRIMARY KEY (`contentCreatorId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contentcreator`
--

LOCK TABLES `contentcreator` WRITE;
/*!40000 ALTER TABLE `contentcreator` DISABLE KEYS */;
INSERT INTO `contentcreator` VALUES (1,'John Doe',0,'2024-05-08','description empty',NULL),(2,'Alice Johnson',0,'2024-05-08','description empty',NULL),(3,'Emily Brown',0,'2024-05-08','description empty',NULL),(4,'Michael Williams',0,'2024-05-08','description empty',NULL),(5,'Sophia Martinez',0,'2024-05-08','description empty',NULL);
/*!40000 ALTER TABLE `contentcreator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `free`
--

DROP TABLE IF EXISTS `free`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `free` (
  `accountId` int NOT NULL,
  `lastListenTime` time DEFAULT NULL,
  PRIMARY KEY (`accountId`),
  CONSTRAINT `fk_free_accountId` FOREIGN KEY (`accountId`) REFERENCES `account` (`accountId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `free`
--

LOCK TABLES `free` WRITE;
/*!40000 ALTER TABLE `free` DISABLE KEYS */;
INSERT INTO `free` VALUES (2,'12:30:00'),(5,'15:45:00'),(7,'18:20:00'),(9,'09:10:00');
/*!40000 ALTER TABLE `free` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listline`
--

DROP TABLE IF EXISTS `listline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listline` (
  `playlistId` int DEFAULT NULL,
  `contentId` int DEFAULT NULL,
  KEY `fk_listLine_contentId` (`contentId`),
  KEY `fk_listLine_playlistId` (`playlistId`),
  CONSTRAINT `fk_listLine_contentId` FOREIGN KEY (`contentId`) REFERENCES `content` (`contentId`),
  CONSTRAINT `fk_listLine_playlistId` FOREIGN KEY (`playlistId`) REFERENCES `playlist` (`playlistId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listline`
--

LOCK TABLES `listline` WRITE;
/*!40000 ALTER TABLE `listline` DISABLE KEYS */;
INSERT INTO `listline` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(4,9),(4,10),(5,11),(5,12),(6,13),(6,14);
/*!40000 ALTER TABLE `listline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playlist`
--

DROP TABLE IF EXISTS `playlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `playlist` (
  `playlistId` int NOT NULL AUTO_INCREMENT,
  `accountId` int DEFAULT NULL,
  `playlistTitle` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`playlistId`),
  KEY `fk_accountId_playlist` (`accountId`),
  CONSTRAINT `fk_accountId_playlist` FOREIGN KEY (`accountId`) REFERENCES `account` (`accountId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,1,'Favorites'),(2,1,'Workout'),(3,2,'Chill'),(4,3,'Study'),(5,4,'Road Trip'),(6,5,'Party');
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `podcast`
--

DROP TABLE IF EXISTS `podcast`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `podcast` (
  `contentId` int NOT NULL,
  `serieId` int DEFAULT NULL,
  PRIMARY KEY (`contentId`),
  KEY `fk_podcast_serieId` (`serieId`),
  CONSTRAINT `fk_podcast_contentId` FOREIGN KEY (`contentId`) REFERENCES `content` (`contentId`),
  CONSTRAINT `fk_podcast_serieId` FOREIGN KEY (`serieId`) REFERENCES `serie` (`serieId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `podcast`
--

LOCK TABLES `podcast` WRITE;
/*!40000 ALTER TABLE `podcast` DISABLE KEYS */;
INSERT INTO `podcast` VALUES (11,1),(12,2);
/*!40000 ALTER TABLE `podcast` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `podcaster`
--

DROP TABLE IF EXISTS `podcaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `podcaster` (
  `contentCreatorId` int NOT NULL,
  PRIMARY KEY (`contentCreatorId`),
  CONSTRAINT `fk_podcaster_contentCreatorId` FOREIGN KEY (`contentCreatorId`) REFERENCES `contentcreator` (`contentCreatorId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `podcaster`
--

LOCK TABLES `podcaster` WRITE;
/*!40000 ALTER TABLE `podcaster` DISABLE KEYS */;
INSERT INTO `podcaster` VALUES (2),(4);
/*!40000 ALTER TABLE `podcaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `premium`
--

DROP TABLE IF EXISTS `premium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `premium` (
  `accountId` int NOT NULL,
  `cardNumber` mediumtext NOT NULL,
  `cvv` int NOT NULL,
  `expiringDate` date NOT NULL,
  PRIMARY KEY (`accountId`),
  CONSTRAINT `fk_premium_accountId` FOREIGN KEY (`accountId`) REFERENCES `account` (`accountId`),
  CONSTRAINT `valid_cardNumber_premium` CHECK ((length(`cardNumber`) = 16)),
  CONSTRAINT `valid_cvv_premium` CHECK ((length(`cvv`) = 4))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `premium`
--

LOCK TABLES `premium` WRITE;
/*!40000 ALTER TABLE `premium` DISABLE KEYS */;
INSERT INTO `premium` VALUES (1,'1234567812345678',1234,'2025-06-30'),(3,'8765432187654321',5678,'2026-09-15'),(6,'2345678923456789',9012,'2025-03-20'),(8,'3456789034567890',3456,'2024-11-10');
/*!40000 ALTER TABLE `premium` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `record` (
  `recordId` int NOT NULL AUTO_INCREMENT,
  `bandId` int DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `cover` blob,
  `genre` varchar(50) NOT NULL,
  `releaseDate` date NOT NULL,
  `numberReproductions` int DEFAULT '0',
  PRIMARY KEY (`recordId`),
  KEY `fk_record_bandId` (`bandId`),
  CONSTRAINT `fk_record_bandId` FOREIGN KEY (`bandId`) REFERENCES `band` (`contentCreatorId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
INSERT INTO `record` VALUES (1,1,'Greatest Hits',NULL,'Rock','2024-05-01',10000),(2,3,'Jazz Fusion',NULL,'Jazz','2024-05-15',7500),(3,5,'Pop Anthems',NULL,'Pop','2024-06-01',12000);
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `serie`
--

DROP TABLE IF EXISTS `serie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `serie` (
  `serieId` int NOT NULL AUTO_INCREMENT,
  `podcasterId` int DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `firstEpisodeDate` date DEFAULT NULL,
  `lastEpisodeDate` date DEFAULT NULL,
  `theme` varchar(50) NOT NULL,
  `description` text DEFAULT (_utf8mb4'description empty'),
  PRIMARY KEY (`serieId`),
  KEY `fk_serie_bandId` (`podcasterId`),
  CONSTRAINT `fk_serie_bandId` FOREIGN KEY (`podcasterId`) REFERENCES `podcaster` (`contentCreatorId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `serie`
--

LOCK TABLES `serie` WRITE;
/*!40000 ALTER TABLE `serie` DISABLE KEYS */;
INSERT INTO `serie` VALUES (1,2,'Tech Talk','2024-05-01','2024-05-30','Technology','description empty'),(2,4,'History Explained','2024-06-01','2024-06-30','History','description empty'),(4,2,'Tech Talk','2024-05-01','2024-05-30','Technology','description empty'),(5,4,'History Explained','2024-06-01','2024-06-30','History','description empty'),(7,2,'Tech Talk','2024-05-01','2024-05-30','Technology','description empty'),(8,4,'History Explained','2024-06-01','2024-06-30','History','description empty');
/*!40000 ALTER TABLE `serie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `song`
--

DROP TABLE IF EXISTS `song`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `song` (
  `contentId` int NOT NULL,
  `recordId` int DEFAULT NULL,
  PRIMARY KEY (`contentId`),
  KEY `fk_single_recordId` (`recordId`),
  CONSTRAINT `fk_single_contentId` FOREIGN KEY (`contentId`) REFERENCES `content` (`contentId`),
  CONSTRAINT `fk_single_recordId` FOREIGN KEY (`recordId`) REFERENCES `record` (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `song`
--

LOCK TABLES `song` WRITE;
/*!40000 ALTER TABLE `song` DISABLE KEYS */;
INSERT INTO `song` VALUES (1,1),(2,1),(3,1),(4,2),(5,2),(6,3),(7,3),(8,3),(9,3),(10,3);
/*!40000 ALTER TABLE `song` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-08 21:11:30
