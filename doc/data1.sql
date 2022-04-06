-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: demo
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `bidlist`
--

DROP TABLE IF EXISTS `bidlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bidlist` (
  `BidListId` int NOT NULL AUTO_INCREMENT,
  `account` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `bidQuantity` double DEFAULT NULL,
  `askQuantity` double DEFAULT NULL,
  `bid` double DEFAULT NULL,
  `ask` double DEFAULT NULL,
  `benchmark` varchar(125) DEFAULT NULL,
  `bidListDate` timestamp NULL DEFAULT NULL,
  `commentary` varchar(125) DEFAULT NULL,
  `security` varchar(125) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `trader` varchar(125) DEFAULT NULL,
  `book` varchar(125) DEFAULT NULL,
  `creationName` varchar(125) DEFAULT NULL,
  `creationDate` timestamp NULL DEFAULT NULL,
  `revisionName` varchar(125) DEFAULT NULL,
  `revisionDate` timestamp NULL DEFAULT NULL,
  `dealName` varchar(125) DEFAULT NULL,
  `dealType` varchar(125) DEFAULT NULL,
  `sourceListId` varchar(125) DEFAULT NULL,
  `side` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`BidListId`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bidlist`
--

LOCK TABLES `bidlist` WRITE;
/*!40000 ALTER TABLE `bidlist` DISABLE KEYS */;
INSERT INTO `bidlist` VALUES (2,'account1','type1',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'account3','type3',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'account4','type4',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'account5','type5',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'account6','type6',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(8,'account7','type7',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(9,'account8','type8',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(10,'account9','type9',950,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(11,'account10','type10',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(12,'account11','type11',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(13,'account12','type12',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,'account13','type13',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(15,'account14','type14',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(50,'account16','type16',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `bidlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curvepoint`
--

DROP TABLE IF EXISTS `curvepoint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curvepoint` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `CurveId` int DEFAULT NULL,
  `asOfDate` timestamp NULL DEFAULT NULL,
  `term` double DEFAULT NULL,
  `value` double DEFAULT NULL,
  `creationDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curvepoint`
--

LOCK TABLES `curvepoint` WRITE;
/*!40000 ALTER TABLE `curvepoint` DISABLE KEYS */;
INSERT INTO `curvepoint` VALUES (13,20,NULL,10,30,NULL),(14,20,NULL,10,30,NULL),(17,20,NULL,10,30,NULL),(18,20,NULL,10,30,NULL),(19,50,NULL,45,45,NULL),(20,20,NULL,10,30,NULL),(22,25,NULL,50,10,NULL),(23,25,NULL,50,10,NULL),(24,25,NULL,50,10,NULL),(25,25,NULL,50,10,NULL),(26,25,NULL,50,10,NULL),(27,25,NULL,50,10,NULL),(28,20,NULL,50,10,NULL),(29,25,NULL,50,10,NULL);
/*!40000 ALTER TABLE `curvepoint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `moodysRating` varchar(125) DEFAULT NULL,
  `sandPRating` varchar(125) DEFAULT NULL,
  `fitchRating` varchar(125) DEFAULT NULL,
  `orderNumber` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,'5','5','5',5),(2,'6','6','66',6),(16,'4','4','4',4);
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rulename`
--

DROP TABLE IF EXISTS `rulename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rulename` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(125) DEFAULT NULL,
  `description` varchar(125) DEFAULT NULL,
  `json` varchar(125) DEFAULT NULL,
  `template` varchar(512) DEFAULT NULL,
  `sqlStr` varchar(125) DEFAULT NULL,
  `sqlPart` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rulename`
--

LOCK TABLES `rulename` WRITE;
/*!40000 ALTER TABLE `rulename` DISABLE KEYS */;
INSERT INTO `rulename` VALUES (15,'name','des','json',NULL,'sql','sql'),(16,'name','des','json',NULL,'sql','sql'),(20,'name','description','json','template','sqlStr','sqlPart'),(21,'name','description','json','template','sqlStr','sqlPart');
/*!40000 ALTER TABLE `rulename` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trade`
--

DROP TABLE IF EXISTS `trade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trade` (
  `TradeId` int NOT NULL AUTO_INCREMENT,
  `account` varchar(30) NOT NULL,
  `type` varchar(30) NOT NULL,
  `buyQuantity` double DEFAULT NULL,
  `sellQuantity` double DEFAULT NULL,
  `buyPrice` double DEFAULT NULL,
  `sellPrice` double DEFAULT NULL,
  `tradeDate` timestamp NULL DEFAULT NULL,
  `security` varchar(125) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `trader` varchar(125) DEFAULT NULL,
  `benchmark` varchar(125) DEFAULT NULL,
  `book` varchar(125) DEFAULT NULL,
  `creationName` varchar(125) DEFAULT NULL,
  `creationDate` timestamp NULL DEFAULT NULL,
  `revisionName` varchar(125) DEFAULT NULL,
  `revisionDate` timestamp NULL DEFAULT NULL,
  `dealName` varchar(125) DEFAULT NULL,
  `dealType` varchar(125) DEFAULT NULL,
  `sourceListId` varchar(125) DEFAULT NULL,
  `side` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`TradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trade`
--

LOCK TABLES `trade` WRITE;
/*!40000 ALTER TABLE `trade` DISABLE KEYS */;
INSERT INTO `trade` VALUES (16,'account','type',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(17,'account','type',50,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `trade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(125) DEFAULT NULL,
  `password` varchar(125) DEFAULT NULL,
  `fullname` varchar(125) DEFAULT NULL,
  `role` varchar(125) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa','Administrator','ADMIN'),(2,'user','$2a$10$pBV8ILO/s/nao4wVnGLrh.sa/rnr5pDpbeC4E.KNzQWoy8obFZdaa','User','USER'),(4,'ol','$2a$10$Uf.Il1TSboBVlmQ7y2mzAuHQKJlBNddbg6dtifsUny1c3m6hw2Wdm','olvic','USER'),(5,'admin1','$2a$10$QjZe84P5jq2DTKkpFWyhn.vKF4GBOLgwJtDCY.XMwxr444XsYGfyG','Administrator1','ADMIN');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-06  9:39:50
