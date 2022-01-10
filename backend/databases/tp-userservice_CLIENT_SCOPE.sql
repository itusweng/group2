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
-- Table structure for table `CLIENT_SCOPE`
--

DROP TABLE IF EXISTS `CLIENT_SCOPE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENT_SCOPE` (
  `ID` varchar(36) COLLATE utf8mb4_general_ci NOT NULL,
  `NAME` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `REALM_ID` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `PROTOCOL` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_CLI_SCOPE` (`REALM_ID`,`NAME`),
  KEY `IDX_REALM_CLSCOPE` (`REALM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENT_SCOPE`
--

LOCK TABLES `CLIENT_SCOPE` WRITE;
/*!40000 ALTER TABLE `CLIENT_SCOPE` DISABLE KEYS */;
INSERT INTO `CLIENT_SCOPE` VALUES ('021c2314-036f-4ec8-8d05-26bd3d8f5162','roles','fdgdg','OpenID Connect scope for add user roles to the access token','openid-connect'),('0b1eee33-4741-4903-a2ca-c2d3442d537c','address','training-platform-realm','OpenID Connect built-in scope: address','openid-connect'),('0f8d27bd-ecd5-4529-8353-5ab3828f4747','microprofile-jwt','fdgdg','Microprofile - JWT built-in scope','openid-connect'),('137f1bc9-e0c5-4663-901e-702fbc14cbaa','address','fdgdg','OpenID Connect built-in scope: address','openid-connect'),('1b6aa6a2-33b3-4645-87be-c658959367b9','microprofile-jwt','training-platform-realm','Microprofile - JWT built-in scope','openid-connect'),('2f736949-d74b-449b-b367-9a8970657a85','profile','training-platform-realm','OpenID Connect built-in scope: profile','openid-connect'),('34559097-c6b4-4792-a1db-769bdc8edf2e','roles','master','OpenID Connect scope for add user roles to the access token','openid-connect'),('3cc52dc2-cc4b-4b45-9669-06c016d2cec4','offline_access','fdgdg','OpenID Connect built-in scope: offline_access','openid-connect'),('4858aea6-d749-4166-8c1a-3de16228b1ce','role_list','training-platform-realm','SAML role list','saml'),('4a8471d8-56ec-4846-b47c-31aa1a54562e','role_list','master','SAML role list','saml'),('54e97e7e-8161-4cf0-b0ca-ef8b0aab2aef','microprofile-jwt','master','Microprofile - JWT built-in scope','openid-connect'),('5b9e322d-b418-424e-af31-dca243472f08','email','training-platform-realm','OpenID Connect built-in scope: email','openid-connect'),('5caba6be-7ab6-4904-97a1-abdef217c6a8','offline_access','master','OpenID Connect built-in scope: offline_access','openid-connect'),('5f13d656-eef1-4801-bd50-c31e56f66521','email','fdgdg','OpenID Connect built-in scope: email','openid-connect'),('5f9e5bfb-8e90-4396-8972-4e0928890ad8','web-origins','training-platform-realm','OpenID Connect scope for add allowed web origins to the access token','openid-connect'),('612b86fb-90d3-4c31-a8df-28b1fc24b36e','roles','training-platform-realm',NULL,'openid-connect'),('6a629849-2e41-4f20-af54-8e3727699879','role_list','fdgdg','SAML role list','saml'),('8082bc35-e261-4d30-9254-45deb40f5bc8','web-origins','master','OpenID Connect scope for add allowed web origins to the access token','openid-connect'),('b2476ed0-d50d-475a-9fd1-903283449594','web-origins','fdgdg','OpenID Connect scope for add allowed web origins to the access token','openid-connect'),('b2bf91f6-0f19-4e95-ad89-0a65982e4b02','profile','master','OpenID Connect built-in scope: profile','openid-connect'),('b9148a9a-42d3-4e90-bbcf-33b03b44a0e9','phone','training-platform-realm','OpenID Connect built-in scope: phone','openid-connect'),('cc1832c3-a3e7-4d3a-8564-32e6aaadc312','profile','fdgdg','OpenID Connect built-in scope: profile','openid-connect'),('dee9a228-fe60-41d5-b484-47cd90246224','phone','master','OpenID Connect built-in scope: phone','openid-connect'),('f9438407-4811-454b-9ef1-345f65a6355b','phone','fdgdg','OpenID Connect built-in scope: phone','openid-connect'),('fb94fb3d-5ac9-425b-94b4-559d9f67d9d2','offline_access','training-platform-realm','OpenID Connect built-in scope: offline_access','openid-connect'),('fca7e2c0-3c2d-40df-a1be-21cd54e377da','address','master','OpenID Connect built-in scope: address','openid-connect'),('fd787c51-5ed4-464e-86be-237d209128ba','email','master','OpenID Connect built-in scope: email','openid-connect');
/*!40000 ALTER TABLE `CLIENT_SCOPE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-10 22:30:54
