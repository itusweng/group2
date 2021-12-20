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
-- Table structure for table `USER_ENTITY`
--

DROP TABLE IF EXISTS `USER_ENTITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USER_ENTITY` (
  `ID` varchar(36) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `EMAIL_CONSTRAINT` varchar(255) DEFAULT NULL,
  `EMAIL_VERIFIED` bit(1) NOT NULL DEFAULT b'0',
  `ENABLED` bit(1) NOT NULL DEFAULT b'0',
  `FEDERATION_LINK` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LAST_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `REALM_ID` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CREATED_TIMESTAMP` bigint DEFAULT NULL,
  `SERVICE_ACCOUNT_CLIENT_LINK` varchar(255) DEFAULT NULL,
  `NOT_BEFORE` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_DYKN684SL8UP1CRFEI6ECKHD7` (`REALM_ID`,`EMAIL_CONSTRAINT`),
  UNIQUE KEY `UK_RU8TT6T700S9V50BU18WS5HA6` (`REALM_ID`,`USERNAME`),
  KEY `IDX_USER_EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ENTITY`
--

LOCK TABLES `USER_ENTITY` WRITE;
/*!40000 ALTER TABLE `USER_ENTITY` DISABLE KEYS */;
INSERT INTO `USER_ENTITY` VALUES ('0951c69e-9355-4a48-b817-7c779cede052',NULL,'f3419941-1b5f-4db4-bac4-2ff5b1145c0d',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','test5',1639896174686,NULL,0),('31a8c5a6-4cd9-476c-ac10-d345638833b6',NULL,'b3dda27a-d489-45ec-bf96-23620df33078',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','service-account-tp-spring-cloud-gateway-client',1637971214280,'22c20439-6887-43b5-813b-49f191fadb40',0),('6cc5f868-c060-4591-93e6-dd347b05999d',NULL,'7aa7c7ef-c653-4ab1-bc41-ce52a97476a1',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','test1',1637971272674,NULL,1637972507),('7374209f-8cc2-4a1c-ba3f-6b57fe43cc5e','test@gmail.com','test@gmail.com',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','test2',1638132262195,NULL,0),('910f1061-e835-4415-aa7e-49ffbca5a23f',NULL,'07ff9ae1-2c8b-4fe4-88a3-ed2fdd367c9e',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','test4',1638677752786,NULL,0),('9b0a27c5-e31d-4127-811a-2e078cf3b044',NULL,'670fba5c-a0bf-49bb-83e7-54faa070dc8d',_binary '\0',_binary '',NULL,NULL,NULL,'master','admin',1637966875195,NULL,0),('be5851ce-6318-49ef-89b5-b8d842155eb1',NULL,'8b2ad81b-5bfc-4432-8ea6-71834ec05496',_binary '\0',_binary '',NULL,NULL,NULL,'master','test',1637966911227,NULL,0),('ecb14193-d545-423b-8e02-53097bc765a6','test3@gmail.com','test3@gmail.com',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','test3',1638134463747,NULL,0);
/*!40000 ALTER TABLE `USER_ENTITY` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 16:09:08
