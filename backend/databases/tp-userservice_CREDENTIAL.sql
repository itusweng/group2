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
-- Table structure for table `CREDENTIAL`
--

DROP TABLE IF EXISTS `CREDENTIAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CREDENTIAL` (
  `ID` varchar(36) NOT NULL,
  `SALT` tinyblob,
  `TYPE` varchar(255) DEFAULT NULL,
  `USER_ID` varchar(36) DEFAULT NULL,
  `CREATED_DATE` bigint DEFAULT NULL,
  `USER_LABEL` varchar(255) DEFAULT NULL,
  `SECRET_DATA` longtext,
  `CREDENTIAL_DATA` longtext,
  `PRIORITY` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_USER_CREDENTIAL` (`USER_ID`),
  CONSTRAINT `FK_PFYR0GLASQYL0DEI3KL69R6V0` FOREIGN KEY (`USER_ID`) REFERENCES `USER_ENTITY` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CREDENTIAL`
--

LOCK TABLES `CREDENTIAL` WRITE;
/*!40000 ALTER TABLE `CREDENTIAL` DISABLE KEYS */;
INSERT INTO `CREDENTIAL` VALUES ('229672eb-9f9b-445e-8035-2f4488d6c0b4',NULL,'password','6cc5f868-c060-4591-93e6-dd347b05999d',1637971391232,NULL,'{\"value\":\"sz2zJ8lFDYScg1Lmf4C0yPi2irtH/FNd67o2ElkxeYsdPSYXvi8CdRoZFURt23plp3WZ/se68peDUFZJ7VpUsg==\",\"salt\":\"rN0Rfr7gWEnnqbUavcF59A==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('4f9db8d6-03bb-4dc5-9c99-5d68555d8d2c',NULL,'password','be5851ce-6318-49ef-89b5-b8d842155eb1',1637966928059,NULL,'{\"value\":\"zu8ClKxogqnxXSzrf/o64b7ni4Om01fG0C3aHi0CNWsMq6vdYQYC5V5v7z3eFgiNgtF7cmV6k4Ml1XE8lWzyOw==\",\"salt\":\"ky+61pFFh4mjLAgaDTvmOg==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('588d241c-bd7d-40e1-8063-fa85d961b7ed',NULL,'password','9b0a27c5-e31d-4127-811a-2e078cf3b044',1637966875381,NULL,'{\"value\":\"IL0a6II6HLrDmXPtoA24fyfR6hv1i74jacnu+aEarXGVJPYU0z400Y7cVfT6/+TeZiGdt32/jxPtQWFmzZaYBQ==\",\"salt\":\"/VobrO5yxMbbYK8ZiGKp3w==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('a74726ea-4223-4bf9-bbf8-91f48bcfb045',NULL,'password','ecb14193-d545-423b-8e02-53097bc765a6',1638134463801,NULL,'{\"value\":\"GZSVgoR0qlePUPOBAhRq0DIgeDxu7N67jKCKlZ6P9bgSkOAEXlyP5o2VdP4uJWZCqoFLT0AAGxH3Dwtq9Lt4JA==\",\"salt\":\"oAfbakfMjpEeZcLG58jyUw==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('bac47b09-0f72-4bbf-8c03-5bdab60776ef',NULL,'password','7374209f-8cc2-4a1c-ba3f-6b57fe43cc5e',1638132262256,NULL,'{\"value\":\"8cb00PzNbvTW3qqSsPn+GgBNLLDgWSDwQYgL35ilA+BFklMjWFQzug40+Cg4zUtAS1CEnsK1R+AX53Nxay3LVA==\",\"salt\":\"qoirHQtIGogHx5c/15cgXg==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10);
/*!40000 ALTER TABLE `CREDENTIAL` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-29  3:30:51
