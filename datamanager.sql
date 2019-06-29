-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: datamanager
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

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
-- Table structure for table `costteam`
--

DROP TABLE IF EXISTS `costteam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costteam` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `manager` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isvalid` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costteam`
--

LOCK TABLES `costteam` WRITE;
/*!40000 ALTER TABLE `costteam` DISABLE KEYS */;
INSERT INTO `costteam` VALUES (33,'a','李帝豪','12345567',1),(35,'b','李帝豪2','12345454654',1);
/*!40000 ALTER TABLE `costteam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databaseinfo`
--

DROP TABLE IF EXISTS `databaseinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databaseinfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `size` bigint(20) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastUpdateDate` datetime DEFAULT NULL,
  `localtion` text COLLATE utf8_unicode_ci,
  `desc` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`),
  UNIQUE KEY `U_0` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=523 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databaseinfo`
--

LOCK TABLES `databaseinfo` WRITE;
/*!40000 ALTER TABLE `databaseinfo` DISABLE KEYS */;
INSERT INTO `databaseinfo` VALUES (521,'a_a',2,'2019-06-25 07:45:25','2019-06-25 07:45:47','/a_a','a_a'),(522,'a_b',3,'2019-06-25 07:46:12','2019-06-25 07:45:44','/a_b','a_b');
/*!40000 ALTER TABLE `databaseinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `databaseratio`
--

DROP TABLE IF EXISTS `databaseratio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `databaseratio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tableName` char(200) COLLATE utf8_unicode_ci NOT NULL,
  `databaseName` char(200) COLLATE utf8_unicode_ci NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `coldDataRatio` double NOT NULL DEFAULT '0',
  `warmDataRatio` double NOT NULL DEFAULT '0',
  `heatDataRatio` double NOT NULL DEFAULT '0',
  `migrationDataRatio` double NOT NULL DEFAULT '0',
  `totalSize` bigint(20) NOT NULL DEFAULT '0',
  `accessCountPerDay` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `databaseratio`
--

LOCK TABLES `databaseratio` WRITE;
/*!40000 ALTER TABLE `databaseratio` DISABLE KEYS */;
INSERT INTO `databaseratio` VALUES (1,'a','b','2019-06-29 07:25:42',0.1,0.2,0.4,0.3,110,2),(2,'ab','b','2019-06-29 07:26:34',0.2,0.2,0.4,0.2,100,3),(3,'bc','b','2019-06-29 08:16:11',0.3,0.3,0.4,0,1111,34),(4,'ad','b','2019-06-29 08:17:02',0.2,0.1,0.3,0.4,33,2),(5,'e','b','2019-06-29 08:21:44',0.5,0.5,0,0,1111,0);
/*!40000 ALTER TABLE `databaseratio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datastatistics`
--

DROP TABLE IF EXISTS `datastatistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datastatistics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tableName` char(200) COLLATE utf8_unicode_ci NOT NULL,
  `databaseName` char(200) COLLATE utf8_unicode_ci NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `coldDataSize` bigint(20) NOT NULL DEFAULT '0',
  `warmDataSize` bigint(20) NOT NULL DEFAULT '0',
  `heatDataSize` bigint(20) NOT NULL DEFAULT '0',
  `migrationDataSize` bigint(20) NOT NULL DEFAULT '0',
  `totalSize` bigint(20) NOT NULL DEFAULT '0',
  `accessCountPerDay` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=353429 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datastatistics`
--

LOCK TABLES `datastatistics` WRITE;
/*!40000 ALTER TABLE `datastatistics` DISABLE KEYS */;
INSERT INTO `datastatistics` VALUES (353427,'w','w','2019-06-25 03:50:46',485694,565656,656,565656,1617662,32),(353428,'ww','w','2019-06-25 03:56:32',45665,67,766,65656,112154,32);
/*!40000 ALTER TABLE `datastatistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tableinfo`
--

DROP TABLE IF EXISTS `tableinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tableinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` char(200) COLLATE utf8_unicode_ci NOT NULL,
  `databaseId` int(10) NOT NULL,
  `rank` tinyint(4) DEFAULT NULL,
  `alias` char(200) COLLATE utf8_unicode_ci NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastUpdateDate` datetime DEFAULT NULL,
  `inputFormat` tinytext COLLATE utf8_unicode_ci,
  `outputFormat` tinytext COLLATE utf8_unicode_ci,
  `serializeLib` tinytext COLLATE utf8_unicode_ci,
  `localtion` text COLLATE utf8_unicode_ci,
  `state` tinyint(4) NOT NULL DEFAULT '0',
  `size` bigint(20) NOT NULL DEFAULT '0',
  `desc` text COLLATE utf8_unicode_ci,
  `storeDayCount` int(11) DEFAULT NULL,
  `life` bigint(20) DEFAULT '0',
  `isInited` tinyint(1) DEFAULT '0',
  `isVerify` tinyint(1) DEFAULT '0',
  `tid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `U_0` (`name`,`databaseId`),
  KEY `database_table_ref` (`databaseId`),
  FULLTEXT KEY `FN_REMARK` (`desc`),
  CONSTRAINT `database_table_ref` FOREIGN KEY (`databaseId`) REFERENCES `databaseinfo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=353431 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tableinfo`
--

LOCK TABLES `tableinfo` WRITE;
/*!40000 ALTER TABLE `tableinfo` DISABLE KEYS */;
INSERT INTO `tableinfo` VALUES (353427,'a_a_a',521,1,'1','2019-06-25 07:47:28','2019-06-25 07:46:55',NULL,NULL,NULL,NULL,0,0,NULL,NULL,0,0,0,33),(353428,'a_a_b',521,NULL,'3','2019-06-25 07:48:27',NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,0,0,0,33),(353429,'b_b_a',522,NULL,'1','2019-06-25 07:49:22',NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,0,0,0,35),(353430,'a_b_a',522,NULL,'35','2019-06-25 08:05:04',NULL,NULL,NULL,NULL,NULL,0,0,NULL,NULL,0,0,0,33);
/*!40000 ALTER TABLE `tableinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-29  4:43:05
