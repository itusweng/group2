-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: tp-trainingservice
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `training`
--

DROP TABLE IF EXISTS `training`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `training` (
  `id` bigint NOT NULL,
  `capacity` int NOT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `description` text COLLATE utf8mb4_general_ci NOT NULL,
  `instructor_id` bigint NOT NULL,
  `is_online` tinyint(1) NOT NULL,
  `thumbnail` text COLLATE utf8mb4_general_ci,
  `title` char(50) COLLATE utf8mb4_general_ci NOT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  `user_created_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

LOCK TABLES `training` WRITE;
/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,100,NULL,'updated description',2,1,'https://images.unsplash.com/photo-1611162616475-46b635cb6868?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8dGh1bWJuYWlsfGVufDB8fDB8fA%3D%3D&w=1000&q=80','Updated title','2022-01-10 20:35:44.815000',1),(20,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1),(21,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1),(22,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1),(23,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1),(24,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1),(25,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1),(26,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1),(27,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1),(28,100,NULL,'training114 descrp',2,0,NULL,'training841',NULL,1);
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-10 22:31:04
