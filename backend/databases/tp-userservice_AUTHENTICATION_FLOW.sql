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
-- Table structure for table `AUTHENTICATION_FLOW`
--

DROP TABLE IF EXISTS `AUTHENTICATION_FLOW`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AUTHENTICATION_FLOW` (
  `ID` varchar(36) NOT NULL,
  `ALIAS` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `REALM_ID` varchar(36) DEFAULT NULL,
  `PROVIDER_ID` varchar(36) NOT NULL DEFAULT 'basic-flow',
  `TOP_LEVEL` bit(1) NOT NULL DEFAULT b'0',
  `BUILT_IN` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`ID`),
  KEY `IDX_AUTH_FLOW_REALM` (`REALM_ID`),
  CONSTRAINT `FK_AUTH_FLOW_REALM` FOREIGN KEY (`REALM_ID`) REFERENCES `REALM` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AUTHENTICATION_FLOW`
--

/*!40000 ALTER TABLE `AUTHENTICATION_FLOW` DISABLE KEYS */;
INSERT INTO `AUTHENTICATION_FLOW` VALUES ('085faa6f-be3b-4e63-85f8-e32ed1456995','saml ecp','SAML ECP Profile Authentication Flow','training-platform-realm','basic-flow',_binary '',_binary ''),('0eec3cc0-5311-44c0-95b8-6421114455d3','direct grant','OpenID Connect Resource Owner Grant','training-platform-realm','basic-flow',_binary '',_binary ''),('1f335176-1b29-4088-a861-1d3bff7dc318','Browser - Conditional OTP','Flow to determine if the OTP is required for the authentication','training-platform-realm','basic-flow',_binary '\0',_binary ''),('22006cdc-872e-472e-86f1-334949a8888b','Verify Existing Account by Re-authentication','Reauthentication of existing account','master','basic-flow',_binary '\0',_binary ''),('245e2eda-a2ff-4a4d-994e-9d716ca9e037','Handle Existing Account','Handle what to do if there is existing account with same email/username like authenticated identity provider','training-platform-realm','basic-flow',_binary '\0',_binary ''),('285c15be-65cf-4da8-9a1f-807808cfce68','registration','registration flow','master','basic-flow',_binary '',_binary ''),('2aa0f9cc-c91a-40a7-a0be-dbb76b80896c','first broker login','Actions taken after first broker login with identity provider account, which is not yet linked to any Keycloak account','master','basic-flow',_binary '',_binary ''),('32e8db6f-f9e7-4fbc-ac72-c671ea67c208','registration','registration flow','training-platform-realm','basic-flow',_binary '',_binary ''),('366e44a7-b12a-493f-8213-5d6d8210d474','Authentication Options','Authentication options.','training-platform-realm','basic-flow',_binary '\0',_binary ''),('3c3c831b-cb2c-44d0-b668-2eb7a69b2aea','reset credentials','Reset credentials for a user if they forgot their password or something','master','basic-flow',_binary '',_binary ''),('486540bf-62c0-464e-905a-2667bf2b0cf4','Reset - Conditional OTP','Flow to determine if the OTP should be reset or not. Set to REQUIRED to force.','training-platform-realm','basic-flow',_binary '\0',_binary ''),('57d69449-858b-4b79-82ee-42ecacaade0d','Direct Grant - Conditional OTP','Flow to determine if the OTP is required for the authentication','master','basic-flow',_binary '\0',_binary ''),('5aca595e-1ccc-4788-b17b-517e73763c2c','registration form','registration form','master','form-flow',_binary '\0',_binary ''),('613e10cc-178d-4192-ac75-cdf5d1d40535','reset credentials','Reset credentials for a user if they forgot their password or something','training-platform-realm','basic-flow',_binary '',_binary ''),('618aeee9-44cc-46ab-87a1-9a923db77826','docker auth','Used by Docker clients to authenticate against the IDP','master','basic-flow',_binary '',_binary ''),('6320a3c5-04b2-45fe-968a-2a86cfeaf24b','User creation or linking','Flow for the existing/non-existing user alternatives','training-platform-realm','basic-flow',_binary '\0',_binary ''),('6cef92ba-4928-49c9-8fa9-f960a8e3228f','browser','browser based authentication','master','basic-flow',_binary '',_binary ''),('73b5375c-de3d-4f7b-984e-387d76e96784','browser','browser based authentication','training-platform-realm','basic-flow',_binary '',_binary ''),('7b3a96de-d337-4fbf-a541-eab506529482','forms','Username, password, otp and other auth forms.','training-platform-realm','basic-flow',_binary '\0',_binary ''),('8272c931-20e2-4d46-807f-70b86f9c8e78','docker auth','Used by Docker clients to authenticate against the IDP','training-platform-realm','basic-flow',_binary '',_binary ''),('8434423b-223e-4ad5-ba89-db67890abd82','forms','Username, password, otp and other auth forms.','master','basic-flow',_binary '\0',_binary ''),('84e76714-8d4f-40b4-b488-dbc0c2797c9a','first broker login','Actions taken after first broker login with identity provider account, which is not yet linked to any Keycloak account','training-platform-realm','basic-flow',_binary '',_binary ''),('85b597e6-2abf-4f9e-8d37-bc2efdfc189e','Direct Grant - Conditional OTP','Flow to determine if the OTP is required for the authentication','training-platform-realm','basic-flow',_binary '\0',_binary ''),('9a572f73-6f05-4c9c-89a2-269b21f5cffa','First broker login - Conditional OTP','Flow to determine if the OTP is required for the authentication','master','basic-flow',_binary '\0',_binary ''),('9b6cd68e-93d8-4338-bd8a-da5c8018d769','User creation or linking','Flow for the existing/non-existing user alternatives','master','basic-flow',_binary '\0',_binary ''),('a381f2c1-840d-4aea-b904-25360854c0a6','Handle Existing Account','Handle what to do if there is existing account with same email/username like authenticated identity provider','master','basic-flow',_binary '\0',_binary ''),('a9ebfe0f-81e5-4994-8f22-27bf0a70cfb3','Reset - Conditional OTP','Flow to determine if the OTP should be reset or not. Set to REQUIRED to force.','master','basic-flow',_binary '\0',_binary ''),('b199a677-6f6f-4565-9b03-e01dffcfc03a','Verify Existing Account by Re-authentication','Reauthentication of existing account','training-platform-realm','basic-flow',_binary '\0',_binary ''),('b63534b6-a99a-4b5f-951f-201f0f6edb95','Browser - Conditional OTP','Flow to determine if the OTP is required for the authentication','master','basic-flow',_binary '\0',_binary ''),('ba659e5a-7ef7-4ef9-a412-1f744f97abc1','Account verification options','Method with which to verity the existing account','master','basic-flow',_binary '\0',_binary ''),('bd101774-198e-4dc6-9043-7d9c0ba8b68f','clients','Base authentication for clients','training-platform-realm','client-flow',_binary '',_binary ''),('c1833708-dfd2-4027-aab9-10fd6541e1ed','direct grant','OpenID Connect Resource Owner Grant','master','basic-flow',_binary '',_binary ''),('c50fffdd-454a-4b7b-bc98-d3f4726abe72','Authentication Options','Authentication options.','master','basic-flow',_binary '\0',_binary ''),('ca3a0139-2c53-41bd-adb8-984acfc24eef','clients','Base authentication for clients','master','client-flow',_binary '',_binary ''),('e912ab61-604b-4b7b-bf29-4627faca13cd','http challenge','An authentication flow based on challenge-response HTTP Authentication Schemes','master','basic-flow',_binary '',_binary ''),('ef1c7897-a86d-445c-8dd5-0d9c6b14528e','Account verification options','Method with which to verity the existing account','training-platform-realm','basic-flow',_binary '\0',_binary ''),('fd237af5-e92d-4294-9fae-000a62e94a59','saml ecp','SAML ECP Profile Authentication Flow','master','basic-flow',_binary '',_binary ''),('fda6dead-eb6b-4cc4-b676-23fdd16aeb24','http challenge','An authentication flow based on challenge-response HTTP Authentication Schemes','training-platform-realm','basic-flow',_binary '',_binary ''),('fee2aa93-f9f5-4cbb-961e-7072976af80c','registration form','registration form','training-platform-realm','form-flow',_binary '\0',_binary ''),('ff9afe4b-c4a8-433b-952a-5882cc9e74d8','First broker login - Conditional OTP','Flow to determine if the OTP is required for the authentication','training-platform-realm','basic-flow',_binary '\0',_binary '');
/*!40000 ALTER TABLE `AUTHENTICATION_FLOW` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-31  8:52:06
