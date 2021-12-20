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
  `description` text NOT NULL,
  `instructor_id` bigint NOT NULL,
  `is_online` tinyint(1) NOT NULL,
  `title` char(50) NOT NULL,
  `user_created_id` bigint NOT NULL,
  `thumbnail` text,
  `created_date` datetime(6) DEFAULT NULL,
  `updated_date` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `training`
--

/*!40000 ALTER TABLE `training` DISABLE KEYS */;
INSERT INTO `training` VALUES (1,500,'Training 1 Description',1,1,'Training 1 Title',1,NULL,NULL,NULL),(4,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(5,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(6,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(7,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(8,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(9,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(10,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(11,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(12,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(13,500,'Training1 desc',1,0,'Training1',1,'https://w7.pngwing.com/pngs/1003/697/png-transparent-teacher-illustration-training-expert-management-education-learning-skills-certificate-icon-miscellaneous-blue-text-thumbnail.png',NULL,NULL),(15,100,'Guzel bir aciklama',2,1,'Guzel bir egitim',1,'https://images.unsplash.com/photo-1611162616475-46b635cb6868?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8dGh1bWJuYWlsfGVufDB8fDB8fA%3D%3D&w=1000&q=80',NULL,NULL);
/*!40000 ALTER TABLE `training` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 16:46:38
