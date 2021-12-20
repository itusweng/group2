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
-- Table structure for table `CLIENT_SCOPE_ATTRIBUTES`
--

DROP TABLE IF EXISTS `CLIENT_SCOPE_ATTRIBUTES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENT_SCOPE_ATTRIBUTES` (
  `SCOPE_ID` varchar(36) NOT NULL,
  `VALUE` text,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`SCOPE_ID`,`NAME`),
  KEY `IDX_CLSCOPE_ATTRS` (`SCOPE_ID`),
  CONSTRAINT `FK_CL_SCOPE_ATTR_SCOPE` FOREIGN KEY (`SCOPE_ID`) REFERENCES `CLIENT_SCOPE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENT_SCOPE_ATTRIBUTES`
--

/*!40000 ALTER TABLE `CLIENT_SCOPE_ATTRIBUTES` DISABLE KEYS */;
INSERT INTO `CLIENT_SCOPE_ATTRIBUTES` VALUES ('0b1eee33-4741-4903-a2ca-c2d3442d537c','${addressScopeConsentText}','consent.screen.text'),('0b1eee33-4741-4903-a2ca-c2d3442d537c','true','display.on.consent.screen'),('0b1eee33-4741-4903-a2ca-c2d3442d537c','true','include.in.token.scope'),('1b6aa6a2-33b3-4645-87be-c658959367b9','false','display.on.consent.screen'),('1b6aa6a2-33b3-4645-87be-c658959367b9','true','include.in.token.scope'),('2f736949-d74b-449b-b367-9a8970657a85','${profileScopeConsentText}','consent.screen.text'),('2f736949-d74b-449b-b367-9a8970657a85','true','display.on.consent.screen'),('2f736949-d74b-449b-b367-9a8970657a85','true','include.in.token.scope'),('34559097-c6b4-4792-a1db-769bdc8edf2e','${rolesScopeConsentText}','consent.screen.text'),('34559097-c6b4-4792-a1db-769bdc8edf2e','true','display.on.consent.screen'),('34559097-c6b4-4792-a1db-769bdc8edf2e','false','include.in.token.scope'),('4858aea6-d749-4166-8c1a-3de16228b1ce','${samlRoleListScopeConsentText}','consent.screen.text'),('4858aea6-d749-4166-8c1a-3de16228b1ce','true','display.on.consent.screen'),('4a8471d8-56ec-4846-b47c-31aa1a54562e','${samlRoleListScopeConsentText}','consent.screen.text'),('4a8471d8-56ec-4846-b47c-31aa1a54562e','true','display.on.consent.screen'),('54e97e7e-8161-4cf0-b0ca-ef8b0aab2aef','false','display.on.consent.screen'),('54e97e7e-8161-4cf0-b0ca-ef8b0aab2aef','true','include.in.token.scope'),('5b9e322d-b418-424e-af31-dca243472f08','${emailScopeConsentText}','consent.screen.text'),('5b9e322d-b418-424e-af31-dca243472f08','true','display.on.consent.screen'),('5b9e322d-b418-424e-af31-dca243472f08','true','include.in.token.scope'),('5caba6be-7ab6-4904-97a1-abdef217c6a8','${offlineAccessScopeConsentText}','consent.screen.text'),('5caba6be-7ab6-4904-97a1-abdef217c6a8','true','display.on.consent.screen'),('5f9e5bfb-8e90-4396-8972-4e0928890ad8','','consent.screen.text'),('5f9e5bfb-8e90-4396-8972-4e0928890ad8','false','display.on.consent.screen'),('5f9e5bfb-8e90-4396-8972-4e0928890ad8','false','include.in.token.scope'),('612b86fb-90d3-4c31-a8df-28b1fc24b36e','true','display.on.consent.screen'),('612b86fb-90d3-4c31-a8df-28b1fc24b36e','true','include.in.token.scope'),('7203b0d0-20c2-4b6a-b3db-09cbaa9492cc','true','display.on.consent.screen'),('7203b0d0-20c2-4b6a-b3db-09cbaa9492cc','true','include.in.token.scope'),('8082bc35-e261-4d30-9254-45deb40f5bc8','','consent.screen.text'),('8082bc35-e261-4d30-9254-45deb40f5bc8','false','display.on.consent.screen'),('8082bc35-e261-4d30-9254-45deb40f5bc8','false','include.in.token.scope'),('b2bf91f6-0f19-4e95-ad89-0a65982e4b02','${profileScopeConsentText}','consent.screen.text'),('b2bf91f6-0f19-4e95-ad89-0a65982e4b02','true','display.on.consent.screen'),('b2bf91f6-0f19-4e95-ad89-0a65982e4b02','true','include.in.token.scope'),('b9148a9a-42d3-4e90-bbcf-33b03b44a0e9','${phoneScopeConsentText}','consent.screen.text'),('b9148a9a-42d3-4e90-bbcf-33b03b44a0e9','true','display.on.consent.screen'),('b9148a9a-42d3-4e90-bbcf-33b03b44a0e9','true','include.in.token.scope'),('dee9a228-fe60-41d5-b484-47cd90246224','${phoneScopeConsentText}','consent.screen.text'),('dee9a228-fe60-41d5-b484-47cd90246224','true','display.on.consent.screen'),('dee9a228-fe60-41d5-b484-47cd90246224','true','include.in.token.scope'),('fb94fb3d-5ac9-425b-94b4-559d9f67d9d2','${offlineAccessScopeConsentText}','consent.screen.text'),('fb94fb3d-5ac9-425b-94b4-559d9f67d9d2','true','display.on.consent.screen'),('fca7e2c0-3c2d-40df-a1be-21cd54e377da','${addressScopeConsentText}','consent.screen.text'),('fca7e2c0-3c2d-40df-a1be-21cd54e377da','true','display.on.consent.screen'),('fca7e2c0-3c2d-40df-a1be-21cd54e377da','true','include.in.token.scope'),('fd787c51-5ed4-464e-86be-237d209128ba','${emailScopeConsentText}','consent.screen.text'),('fd787c51-5ed4-464e-86be-237d209128ba','true','display.on.consent.screen'),('fd787c51-5ed4-464e-86be-237d209128ba','true','include.in.token.scope');
/*!40000 ALTER TABLE `CLIENT_SCOPE_ATTRIBUTES` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 16:46:39
