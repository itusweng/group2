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
-- Table structure for table `DEFAULT_CLIENT_SCOPE`
--

DROP TABLE IF EXISTS `DEFAULT_CLIENT_SCOPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DEFAULT_CLIENT_SCOPE` (
  `REALM_ID` varchar(36) NOT NULL,
  `SCOPE_ID` varchar(36) NOT NULL,
  `DEFAULT_SCOPE` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`REALM_ID`,`SCOPE_ID`),
  KEY `IDX_DEFCLS_REALM` (`REALM_ID`),
  KEY `IDX_DEFCLS_SCOPE` (`SCOPE_ID`),
  CONSTRAINT `FK_R_DEF_CLI_SCOPE_REALM` FOREIGN KEY (`REALM_ID`) REFERENCES `REALM` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DEFAULT_CLIENT_SCOPE`
--

/*!40000 ALTER TABLE `DEFAULT_CLIENT_SCOPE` DISABLE KEYS */;
INSERT INTO `DEFAULT_CLIENT_SCOPE` VALUES ('master','34559097-c6b4-4792-a1db-769bdc8edf2e',_binary ''),('master','4a8471d8-56ec-4846-b47c-31aa1a54562e',_binary ''),('master','54e97e7e-8161-4cf0-b0ca-ef8b0aab2aef',_binary '\0'),('master','5caba6be-7ab6-4904-97a1-abdef217c6a8',_binary '\0'),('master','8082bc35-e261-4d30-9254-45deb40f5bc8',_binary ''),('master','b2bf91f6-0f19-4e95-ad89-0a65982e4b02',_binary ''),('master','dee9a228-fe60-41d5-b484-47cd90246224',_binary '\0'),('master','fca7e2c0-3c2d-40df-a1be-21cd54e377da',_binary '\0'),('master','fd787c51-5ed4-464e-86be-237d209128ba',_binary ''),('training-platform-realm','0b1eee33-4741-4903-a2ca-c2d3442d537c',_binary '\0'),('training-platform-realm','1b6aa6a2-33b3-4645-87be-c658959367b9',_binary '\0'),('training-platform-realm','2f736949-d74b-449b-b367-9a8970657a85',_binary ''),('training-platform-realm','4858aea6-d749-4166-8c1a-3de16228b1ce',_binary ''),('training-platform-realm','5b9e322d-b418-424e-af31-dca243472f08',_binary ''),('training-platform-realm','5f9e5bfb-8e90-4396-8972-4e0928890ad8',_binary ''),('training-platform-realm','b9148a9a-42d3-4e90-bbcf-33b03b44a0e9',_binary '\0'),('training-platform-realm','fb94fb3d-5ac9-425b-94b4-559d9f67d9d2',_binary '\0');
/*!40000 ALTER TABLE `DEFAULT_CLIENT_SCOPE` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 16:46:40
