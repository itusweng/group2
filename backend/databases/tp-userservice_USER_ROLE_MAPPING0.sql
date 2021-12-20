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
-- Table structure for table `USER_ROLE_MAPPING`
--

DROP TABLE IF EXISTS `USER_ROLE_MAPPING`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USER_ROLE_MAPPING` (
  `ROLE_ID` varchar(255) NOT NULL,
  `USER_ID` varchar(36) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`USER_ID`),
  KEY `IDX_USER_ROLE_MAPPING` (`USER_ID`),
  CONSTRAINT `FK_C4FQV34P1MBYLLOXANG7B1Q3L` FOREIGN KEY (`USER_ID`) REFERENCES `USER_ENTITY` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ROLE_MAPPING`
--

LOCK TABLES `USER_ROLE_MAPPING` WRITE;
/*!40000 ALTER TABLE `USER_ROLE_MAPPING` DISABLE KEYS */;
INSERT INTO `USER_ROLE_MAPPING` VALUES ('7e41caf4-8159-4542-8aa1-cc6004367bbc','0951c69e-9355-4a48-b817-7c779cede052'),('8cef8424-ce20-48be-aa85-92a797e874e0','0951c69e-9355-4a48-b817-7c779cede052'),('b2547b0b-397d-4c1a-beba-91645b9da5b7','0951c69e-9355-4a48-b817-7c779cede052'),('3a60a74f-0f53-49fc-9cf1-8809a95bc4a0','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('415daf3b-bc48-4daf-a804-45358b74cd45','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('4acadb22-4f6f-4f63-a032-7f5e4207cf05','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('523f341c-31fa-479c-a7cb-ffc57fe13f3f','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('550ba8df-7afe-4010-abb5-99fb5304349b','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('57148fcd-255c-4833-902b-8df483c67212','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('74f5cd40-23a3-4177-a249-b1ccd8f7ce36','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('7e41caf4-8159-4542-8aa1-cc6004367bbc','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('8dce3dd7-0f6c-43fe-b74b-68fe42adcf6b','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('970502e3-cb26-45e4-86cf-e0ee927c8a93','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('9f9920ed-824a-4681-bc8f-0c81a4764975','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('a4352b09-13f0-4066-96c9-cb5b465c0fcc','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('a4404bed-98a5-4dc6-b5d5-17c678456c72','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('a52c3efc-fcf5-4a19-8084-3e4ed2fee32f','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('bc3e5b02-71d5-42e1-be4b-0897751fd27a','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('dae3f083-cfac-42b5-8e0a-5be6e353fa58','31a8c5a6-4cd9-476c-ac10-d345638833b6'),('7e41caf4-8159-4542-8aa1-cc6004367bbc','6cc5f868-c060-4591-93e6-dd347b05999d'),('8cef8424-ce20-48be-aa85-92a797e874e0','6cc5f868-c060-4591-93e6-dd347b05999d'),('a4352b09-13f0-4066-96c9-cb5b465c0fcc','6cc5f868-c060-4591-93e6-dd347b05999d'),('b2547b0b-397d-4c1a-beba-91645b9da5b7','6cc5f868-c060-4591-93e6-dd347b05999d'),('7e41caf4-8159-4542-8aa1-cc6004367bbc','7374209f-8cc2-4a1c-ba3f-6b57fe43cc5e'),('4298e966-05e1-4116-92b4-cf50b8598b5a','9b0a27c5-e31d-4127-811a-2e078cf3b044'),('7ac52ed8-10da-42c4-bb16-f48cea68c3b9','9b0a27c5-e31d-4127-811a-2e078cf3b044'),('4298e966-05e1-4116-92b4-cf50b8598b5a','be5851ce-6318-49ef-89b5-b8d842155eb1'),('7e41caf4-8159-4542-8aa1-cc6004367bbc','ecb14193-d545-423b-8e02-53097bc765a6'),('b2547b0b-397d-4c1a-beba-91645b9da5b7','ecb14193-d545-423b-8e02-53097bc765a6');
/*!40000 ALTER TABLE `USER_ROLE_MAPPING` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 16:09:04
