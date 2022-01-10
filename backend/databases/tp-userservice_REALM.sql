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
-- Table structure for table `REALM`
--

DROP TABLE IF EXISTS `REALM`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REALM` (
  `ID` varchar(36) COLLATE utf8mb4_general_ci NOT NULL,
  `ACCESS_CODE_LIFESPAN` int DEFAULT NULL,
  `USER_ACTION_LIFESPAN` int DEFAULT NULL,
  `ACCESS_TOKEN_LIFESPAN` int DEFAULT NULL,
  `ACCOUNT_THEME` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ADMIN_THEME` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `EMAIL_THEME` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ENABLED` bit(1) NOT NULL DEFAULT b'0',
  `EVENTS_ENABLED` bit(1) NOT NULL DEFAULT b'0',
  `EVENTS_EXPIRATION` bigint DEFAULT NULL,
  `LOGIN_THEME` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `NAME` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `NOT_BEFORE` int DEFAULT NULL,
  `PASSWORD_POLICY` text COLLATE utf8mb4_general_ci,
  `REGISTRATION_ALLOWED` bit(1) NOT NULL DEFAULT b'0',
  `REMEMBER_ME` bit(1) NOT NULL DEFAULT b'0',
  `RESET_PASSWORD_ALLOWED` bit(1) NOT NULL DEFAULT b'0',
  `SOCIAL` bit(1) NOT NULL DEFAULT b'0',
  `SSL_REQUIRED` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `SSO_IDLE_TIMEOUT` int DEFAULT NULL,
  `SSO_MAX_LIFESPAN` int DEFAULT NULL,
  `UPDATE_PROFILE_ON_SOC_LOGIN` bit(1) NOT NULL DEFAULT b'0',
  `VERIFY_EMAIL` bit(1) NOT NULL DEFAULT b'0',
  `MASTER_ADMIN_CLIENT` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `LOGIN_LIFESPAN` int DEFAULT NULL,
  `INTERNATIONALIZATION_ENABLED` bit(1) NOT NULL DEFAULT b'0',
  `DEFAULT_LOCALE` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `REG_EMAIL_AS_USERNAME` bit(1) NOT NULL DEFAULT b'0',
  `ADMIN_EVENTS_ENABLED` bit(1) NOT NULL DEFAULT b'0',
  `ADMIN_EVENTS_DETAILS_ENABLED` bit(1) NOT NULL DEFAULT b'0',
  `EDIT_USERNAME_ALLOWED` bit(1) NOT NULL DEFAULT b'0',
  `OTP_POLICY_COUNTER` int DEFAULT '0',
  `OTP_POLICY_WINDOW` int DEFAULT '1',
  `OTP_POLICY_PERIOD` int DEFAULT '30',
  `OTP_POLICY_DIGITS` int DEFAULT '6',
  `OTP_POLICY_ALG` varchar(36) COLLATE utf8mb4_general_ci DEFAULT 'HmacSHA1',
  `OTP_POLICY_TYPE` varchar(36) COLLATE utf8mb4_general_ci DEFAULT 'totp',
  `BROWSER_FLOW` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `REGISTRATION_FLOW` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DIRECT_GRANT_FLOW` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `RESET_CREDENTIALS_FLOW` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CLIENT_AUTH_FLOW` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `OFFLINE_SESSION_IDLE_TIMEOUT` int DEFAULT '0',
  `REVOKE_REFRESH_TOKEN` bit(1) NOT NULL DEFAULT b'0',
  `ACCESS_TOKEN_LIFE_IMPLICIT` int DEFAULT '0',
  `LOGIN_WITH_EMAIL_ALLOWED` bit(1) NOT NULL DEFAULT b'1',
  `DUPLICATE_EMAILS_ALLOWED` bit(1) NOT NULL DEFAULT b'0',
  `DOCKER_AUTH_FLOW` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `REFRESH_TOKEN_MAX_REUSE` int DEFAULT '0',
  `ALLOW_USER_MANAGED_ACCESS` bit(1) NOT NULL DEFAULT b'0',
  `SSO_MAX_LIFESPAN_REMEMBER_ME` int NOT NULL,
  `SSO_IDLE_TIMEOUT_REMEMBER_ME` int NOT NULL,
  `DEFAULT_ROLE` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_ORVSDMLA56612EAEFIQ6WL5OI` (`NAME`),
  KEY `IDX_REALM_MASTER_ADM_CLI` (`MASTER_ADMIN_CLIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REALM`
--

LOCK TABLES `REALM` WRITE;
/*!40000 ALTER TABLE `REALM` DISABLE KEYS */;
INSERT INTO `REALM` VALUES ('fdgdg',60,300,300,NULL,NULL,NULL,_binary '',_binary '\0',0,NULL,'fdgdg',0,NULL,_binary '\0',_binary '\0',_binary '\0',_binary '\0','EXTERNAL',1800,36000,_binary '\0',_binary '\0','d69bcba8-fd74-4b8c-bfb2-79ad23e268fe',1800,_binary '\0',NULL,_binary '\0',_binary '\0',_binary '\0',_binary '\0',0,1,30,6,'HmacSHA1','totp','0cca6972-9b82-40b9-a9bc-d8f61ea52128','19752118-92ae-4b77-91a6-8c68ae49c611','b171421f-db67-437b-80b5-b974f52adf54','fbb4a710-80cc-439f-9961-60865d6cd90a','1fce6d32-7cdf-4579-9e4f-ba7ae45871d3',2592000,_binary '\0',900,_binary '',_binary '\0','6d5f5aa8-3a0f-4288-8646-a53c25f0b398',0,_binary '\0',0,0,'d3e037ff-36d0-4566-89cd-68623d4ca35b'),('master',60,300,60,NULL,NULL,NULL,_binary '',_binary '\0',0,NULL,'master',0,NULL,_binary '\0',_binary '\0',_binary '\0',_binary '\0','EXTERNAL',1800,36000,_binary '\0',_binary '\0','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',1800,_binary '\0',NULL,_binary '\0',_binary '\0',_binary '\0',_binary '\0',0,1,30,6,'HmacSHA1','totp','6cef92ba-4928-49c9-8fa9-f960a8e3228f','285c15be-65cf-4da8-9a1f-807808cfce68','c1833708-dfd2-4027-aab9-10fd6541e1ed','3c3c831b-cb2c-44d0-b668-2eb7a69b2aea','ca3a0139-2c53-41bd-adb8-984acfc24eef',2592000,_binary '\0',900,_binary '',_binary '\0','618aeee9-44cc-46ab-87a1-9a923db77826',0,_binary '\0',0,0,'4298e966-05e1-4116-92b4-cf50b8598b5a'),('training-platform-realm',60,300,2592000,NULL,NULL,NULL,_binary '',_binary '\0',0,NULL,'training-platform-realm',1638678273,NULL,_binary '',_binary '\0',_binary '\0',_binary '\0','EXTERNAL',2592000,2592000,_binary '\0',_binary '\0','bd783b6e-4231-45a8-a878-71215870684f',2592000,_binary '\0',NULL,_binary '\0',_binary '\0',_binary '\0',_binary '\0',0,1,30,6,'HmacSHA1','totp','73b5375c-de3d-4f7b-984e-387d76e96784','32e8db6f-f9e7-4fbc-ac72-c671ea67c208','0eec3cc0-5311-44c0-95b8-6421114455d3','613e10cc-178d-4192-ac75-cdf5d1d40535','bd101774-198e-4dc6-9043-7d9c0ba8b68f',2592000,_binary '\0',2592000,_binary '',_binary '\0','8272c931-20e2-4d46-807f-70b86f9c8e78',0,_binary '\0',0,0,'7e41caf4-8159-4542-8aa1-cc6004367bbc');
/*!40000 ALTER TABLE `REALM` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-10 22:30:57
