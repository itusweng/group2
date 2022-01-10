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
-- Table structure for table `REQUIRED_ACTION_PROVIDER`
--

DROP TABLE IF EXISTS `REQUIRED_ACTION_PROVIDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REQUIRED_ACTION_PROVIDER` (
  `ID` varchar(36) COLLATE utf8mb4_general_ci NOT NULL,
  `ALIAS` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `NAME` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `REALM_ID` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ENABLED` bit(1) NOT NULL DEFAULT b'0',
  `DEFAULT_ACTION` bit(1) NOT NULL DEFAULT b'0',
  `PROVIDER_ID` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `PRIORITY` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_REQ_ACT_PROV_REALM` (`REALM_ID`),
  CONSTRAINT `FK_REQ_ACT_REALM` FOREIGN KEY (`REALM_ID`) REFERENCES `REALM` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REQUIRED_ACTION_PROVIDER`
--

LOCK TABLES `REQUIRED_ACTION_PROVIDER` WRITE;
/*!40000 ALTER TABLE `REQUIRED_ACTION_PROVIDER` DISABLE KEYS */;
INSERT INTO `REQUIRED_ACTION_PROVIDER` VALUES ('02e8aa9a-edb4-4fc7-846d-ee83b969c4f9','UPDATE_PASSWORD','Update Password','training-platform-realm',_binary '\0',_binary '\0','UPDATE_PASSWORD',30),('0575b708-6953-4583-a341-c802e06a9e6a','UPDATE_PASSWORD','Update Password','fdgdg',_binary '',_binary '\0','UPDATE_PASSWORD',30),('2f592776-2eef-4d31-a75c-4a1ecfe8e887','update_user_locale','Update User Locale','training-platform-realm',_binary '\0',_binary '\0','update_user_locale',1000),('339f25ec-bbb3-4395-aa24-10f4eec64ce0','VERIFY_EMAIL','Verify Email','master',_binary '',_binary '\0','VERIFY_EMAIL',50),('4a406bc3-44a3-45e1-8667-9ff0034fe1d4','CONFIGURE_TOTP','Configure OTP','master',_binary '',_binary '\0','CONFIGURE_TOTP',10),('5fb3e1a3-d7ff-4612-bd81-2c44a20dbae7','terms_and_conditions','Terms and Conditions','training-platform-realm',_binary '\0',_binary '\0','terms_and_conditions',20),('5fbfa936-84cd-4e62-acb6-200528187889','CONFIGURE_TOTP','Configure OTP','training-platform-realm',_binary '\0',_binary '\0','CONFIGURE_TOTP',10),('698dfa6d-d2a1-4498-9b76-1b50565f02ee','UPDATE_PROFILE','Update Profile','training-platform-realm',_binary '\0',_binary '\0','UPDATE_PROFILE',40),('7f9d7ef9-af2c-4dae-9f97-296bcaf76b28','delete_account','Delete Account','fdgdg',_binary '\0',_binary '\0','delete_account',60),('84b59783-433b-4b1e-8030-63bb9b0962ec','terms_and_conditions','Terms and Conditions','master',_binary '\0',_binary '\0','terms_and_conditions',20),('85700c08-530e-4ddf-8681-8e831b0e7b4a','delete_account','Delete Account','master',_binary '\0',_binary '\0','delete_account',60),('86019a9c-3cdf-4177-8102-c8ea08be59b1','UPDATE_PROFILE','Update Profile','fdgdg',_binary '',_binary '\0','UPDATE_PROFILE',40),('866067e2-e3ec-4807-89d7-abf58fb15187','VERIFY_EMAIL','Verify Email','fdgdg',_binary '',_binary '\0','VERIFY_EMAIL',50),('8cafedf4-a866-4c3e-9e4e-05d8ccc78241','UPDATE_PROFILE','Update Profile','master',_binary '',_binary '\0','UPDATE_PROFILE',40),('9bd1483f-4206-4efc-8332-1fb2854984a4','update_user_locale','Update User Locale','master',_binary '',_binary '\0','update_user_locale',1000),('aafcda52-2775-4c32-8b9f-f513333e83ea','UPDATE_PASSWORD','Update Password','master',_binary '',_binary '\0','UPDATE_PASSWORD',30),('c0ba11c4-eab1-4769-a423-ef108921360b','terms_and_conditions','Terms and Conditions','fdgdg',_binary '\0',_binary '\0','terms_and_conditions',20),('c100b9e7-53d4-4568-99f4-dfd35fcda35c','update_user_locale','Update User Locale','fdgdg',_binary '',_binary '\0','update_user_locale',1000),('d3655de9-10fa-441d-a4cc-a468afa2fd5c','VERIFY_EMAIL','Verify Email','training-platform-realm',_binary '\0',_binary '\0','VERIFY_EMAIL',50),('d6345bb2-94eb-41a2-8fb8-88a49ca847d1','webauthn-register-passwordless','Webauthn Register Passwordless','training-platform-realm',_binary '',_binary '\0','webauthn-register-passwordless',1001),('dd139c46-2567-4b93-ae1b-1abe352ad330','CONFIGURE_TOTP','Configure OTP','fdgdg',_binary '',_binary '\0','CONFIGURE_TOTP',10),('ff66aad3-5350-49af-806e-a187a3f8e9f2','delete_account','Delete Account','training-platform-realm',_binary '\0',_binary '\0','delete_account',60);
/*!40000 ALTER TABLE `REQUIRED_ACTION_PROVIDER` ENABLE KEYS */;
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
