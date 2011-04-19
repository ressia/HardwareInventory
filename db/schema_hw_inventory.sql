-- MySQL dump 10.13  Distrib 5.1.34, for apple-darwin9.5.0 (i386)
--
-- Host: 127.0.0.1    Database: hw_inventory
-- ------------------------------------------------------
-- Server version	5.1.44

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
-- Current Database: `hw_inventory`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `hw_inventory` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hw_inventory`;

--
-- Table structure for table `hw_categories`
--

DROP TABLE IF EXISTS `hw_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hw_categories` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hw_categories`
--

LOCK TABLES `hw_categories` WRITE;
/*!40000 ALTER TABLE `hw_categories` DISABLE KEYS */;
INSERT INTO `hw_categories` VALUES (52,'Other hardware'),(53,'MacPro laptop'),(57,'MacPro laptop 2'),(58,'Dell');
/*!40000 ALTER TABLE `hw_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hw_device`
--

DROP TABLE IF EXISTS `hw_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hw_device` (
  `device_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_id` bigint(20) DEFAULT NULL,
  `disk_size` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '	',
  `memory_size` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `ian_number` int(11) DEFAULT NULL,
  `mac_address` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `serial_number` varchar(45) CHARACTER SET latin1 DEFAULT NULL COMMENT '	',
  `ip_address` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`device_id`),
  KEY `FKD7540F869451F881` (`type_id`),
  CONSTRAINT `FKD7540F869451F881` FOREIGN KEY (`type_id`) REFERENCES `hw_types` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hw_device`
--

LOCK TABLES `hw_device` WRITE;
/*!40000 ALTER TABLE `hw_device` DISABLE KEYS */;
INSERT INTO `hw_device` VALUES (2,9,'512MB','',0,'','',''),(3,10,'512MB','',2523,'00:16:cb:96:e1:ad','W863112UVWZ','130.92.65.219'),(4,10,'512MB','',2524,'00:16:cb:96:e1:ad','W863112UVWZ','130.92.65.211'),(5,11,'512MB','2GB',2525,'00:16:cb:96:e1:ad','W863112UVWZ','130.92.65.231'),(7,13,'512MB','2GB',3525,'00:16:cb:96:e1:ad','W863112UVWT','130.92.65.231'),(8,14,'5GB','3GB',3000,'00:16:cb:96:e1:ad','W111111111','130.92.65.200');
/*!40000 ALTER TABLE `hw_device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hw_items`
--

DROP TABLE IF EXISTS `hw_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hw_items` (
  `item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  `item_scg_num` int(11) DEFAULT NULL,
  `item_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `item_price` decimal(11,2) DEFAULT NULL,
  `item_budget` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `item_guarantee` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `item_guarantee_end` date DEFAULT NULL,
  `inventory_date` date DEFAULT NULL,
  `item_note` text,
  PRIMARY KEY (`item_id`),
  KEY `FK729A10909A1ACB10` (`location_id`),
  KEY `FK729A10903B36B5A3` (`user_id`),
  KEY `FK729A1090FBEE028B` (`device_id`),
  CONSTRAINT `FK729A10903B36B5A3` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FK729A10909A1ACB10` FOREIGN KEY (`location_id`) REFERENCES `inventory_locations` (`location_id`),
  CONSTRAINT `FK729A1090FBEE028B` FOREIGN KEY (`device_id`) REFERENCES `hw_device` (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hw_items`
--

LOCK TABLES `hw_items` WRITE;
/*!40000 ALTER TABLE `hw_items` DISABLE KEYS */;
INSERT INTO `hw_items` VALUES (1,2,1,1,121,'','139.00','IK 2005','','2008-03-03','2007-03-09',NULL),(4,4,3,1,10,'machul','4139.00','IK2006','MacBook 531040673291','2008-03-03','2007-03-09',NULL),(5,5,4,1,11,'machul','4139.23','IK2006','MacBook 531040673291','2008-03-03','2007-03-09',NULL),(8,7,6,1,15,'pupu','4139.23','IK2006','MacBook 531040673291','2008-03-03','2007-03-09',NULL),(9,8,6,3,20,'dellmagu','2000.20','BUD111','Dell 222222','2011-06-02','2011-11-20','Test 5');
/*!40000 ALTER TABLE `hw_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hw_types`
--

DROP TABLE IF EXISTS `hw_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hw_types` (
  `type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`type_id`),
  KEY `FK73378149A7855E81` (`category_id`),
  CONSTRAINT `FK73378149A7855E81` FOREIGN KEY (`category_id`) REFERENCES `hw_categories` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hw_types`
--

LOCK TABLES `hw_types` WRITE;
/*!40000 ALTER TABLE `hw_types` DISABLE KEYS */;
INSERT INTO `hw_types` VALUES (9,'iPod Shuffle',52),(10,'MacBook Pro 2.16Ghz 15',53),(11,'MacBook Pro 4000',53),(13,'MacBook Pro 8000',57),(14,'Dell Notebook Pro 15',58);
/*!40000 ALTER TABLE `hw_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory_locations`
--

DROP TABLE IF EXISTS `inventory_locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory_locations` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_locations`
--

LOCK TABLES `inventory_locations` WRITE;
/*!40000 ALTER TABLE `inventory_locations` DISABLE KEYS */;
INSERT INTO `inventory_locations` VALUES (1,'S14/102'),(2,'Home'),(3,'Office Luis');
/*!40000 ALTER TABLE `inventory_locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Pipi'),(2,'Magu'),(3,'Jorge'),(4,'Paula'),(6,'Luis'),(7,'Chris');
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

-- Dump completed on 2011-04-19  9:05:58
