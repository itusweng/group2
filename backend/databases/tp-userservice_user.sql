-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: tp-userservice
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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `email` text COLLATE utf8mb4_general_ci NOT NULL,
  `first_name` text COLLATE utf8mb4_general_ci NOT NULL,
  `last_name` text COLLATE utf8mb4_general_ci NOT NULL,
  `role_id` bigint NOT NULL,
  `password` text COLLATE utf8mb4_general_ci NOT NULL,
  `username` text COLLATE utf8mb4_general_ci NOT NULL,
  `job_title` char(50) COLLATE utf8mb4_general_ci NOT NULL,
  `profile_photo` text COLLATE utf8mb4_general_ci,
  `manager_group_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'test@gmail.com','test name','test last name',11,'$2a$10$wwNjYmbCz/4en33BXtdI9epC8ppcucVng2JBJS8Rc7v.xN4xa.GgK','test1','','https://pbs.twimg.com/profile_images/726356653105369088/uVI0RTjg_400x400.jpg',1),(2,'test2@gmail.com','test name','test last name',11,'$2a$10$tqADviqbqNATOCPEdIuY.O/U4.ltZ.uUlYlymaajiSIBCaLFTjVSW','test2','','https://pbs.twimg.com/profile_images/433220085964996608/eXGd_0r2_400x400.jpeg',2),(3,'test3@gmail.com','test name','test last name',12,'$2a$10$tqADviqbqNATOCPEdIuY.O/U4.ltZ.uUlYlymaajiSIBCaLFTjVSW','test3','','https://pbs.twimg.com/profile_images/963467043726086145/rN-JP6SI_400x400.jpg',2),(4,'test4@gmail.com','test name','test last name',12,'$2a$10$tqADviqbqNATOCPEdIuY.O/U4.ltZ.uUlYlymaajiSIBCaLFTjVSW','test4','','https://pbs.twimg.com/profile_images/1127127014148923393/t5xi827B_400x400.jpg',2),(5,'test5@gmail.com','test name','test last name',12,'$2a$10$tqADviqbqNATOCPEdIuY.O/U4.ltZ.uUlYlymaajiSIBCaLFTjVSW','test5','','https://static.independent.co.uk/s3fs-public/thumbnails/image/2015/10/07/23/web-ali-g-getty.jpg?width=982&height=726&auto=webp&quality=75',1),(6,'test6@gmail.com','test name','test last name',11,'$2a$10$tqADviqbqNATOCPEdIuY.O/U4.ltZ.uUlYlymaajiSIBCaLFTjVSW','test6','','https://cf.kizlarsoruyor.com/q12682016/532f0290-9ef6-4f7c-9e67-5f31b544d0c4-m.jpg',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-09  3:55:30
