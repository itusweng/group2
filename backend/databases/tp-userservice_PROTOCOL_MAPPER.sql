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
-- Table structure for table `PROTOCOL_MAPPER`
--

DROP TABLE IF EXISTS `PROTOCOL_MAPPER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PROTOCOL_MAPPER` (
  `ID` varchar(36) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `PROTOCOL` varchar(255) NOT NULL,
  `PROTOCOL_MAPPER_NAME` varchar(255) NOT NULL,
  `CLIENT_ID` varchar(36) DEFAULT NULL,
  `CLIENT_SCOPE_ID` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_PROTOCOL_MAPPER_CLIENT` (`CLIENT_ID`),
  KEY `IDX_CLSCOPE_PROTMAP` (`CLIENT_SCOPE_ID`),
  CONSTRAINT `FK_CLI_SCOPE_MAPPER` FOREIGN KEY (`CLIENT_SCOPE_ID`) REFERENCES `CLIENT_SCOPE` (`ID`),
  CONSTRAINT `FK_PCM_REALM` FOREIGN KEY (`CLIENT_ID`) REFERENCES `CLIENT` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROTOCOL_MAPPER`
--

/*!40000 ALTER TABLE `PROTOCOL_MAPPER` DISABLE KEYS */;
INSERT INTO `PROTOCOL_MAPPER` VALUES ('0120fed1-50dc-4e02-8d4f-111e0a1fe270','gender','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('04a8f1b2-d754-40ab-bf09-37e0bf169279','given name','openid-connect','oidc-usermodel-property-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('06c2cc5a-faf3-4b96-ac74-ec952c647cf9','middle name','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('06f7fd7c-bdcb-4efb-96f6-099d34904f68','Client ID','openid-connect','oidc-usersessionmodel-note-mapper','22c20439-6887-43b5-813b-49f191fadb40',NULL),('0acb5d87-aca5-4cd4-987a-58cb70a837c7','role list','saml','saml-role-list-mapper',NULL,'4a8471d8-56ec-4846-b47c-31aa1a54562e'),('0acd660d-dcfa-422c-903d-6b061c925da9','locale','openid-connect','oidc-usermodel-attribute-mapper','6fba9dd5-348e-4bda-b418-58aa1a5a1555',NULL),('0d111e0b-4f61-4382-a50d-91e87f44c281','locale','openid-connect','oidc-usermodel-attribute-mapper','1dbb1163-f4c3-44ae-a385-46d76862cd86',NULL),('0e7c26c1-6c4d-4454-a254-59a00860f0db','address','openid-connect','oidc-address-mapper',NULL,'fca7e2c0-3c2d-40df-a1be-21cd54e377da'),('0eeab5b8-901c-4309-bbfa-9bde36be600e','client roles','openid-connect','oidc-usermodel-client-role-mapper',NULL,'34559097-c6b4-4792-a1db-769bdc8edf2e'),('1f106f86-9e73-445f-91c3-7d577de4c0ff','realm roles','openid-connect','oidc-usermodel-realm-role-mapper',NULL,'34559097-c6b4-4792-a1db-769bdc8edf2e'),('27525049-aeab-4c87-a344-0e2c2f58c60d','profile','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('2c905c49-cd2e-47df-b4d6-cd4d1b682850','gender','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('3c3e8bb3-4b68-41e3-8a22-eb4d533cce93','allowed web origins','openid-connect','oidc-allowed-origins-mapper',NULL,'5f9e5bfb-8e90-4396-8972-4e0928890ad8'),('40c915f4-a3ef-44b7-9fe7-0d70b21753a9','picture','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('42abc9ce-074e-4f59-9d3f-a1579fae9dc6','picture','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('458c56fc-7ec2-462b-9b85-9271a1d478c1','audience resolve','openid-connect','oidc-audience-resolve-mapper',NULL,'34559097-c6b4-4792-a1db-769bdc8edf2e'),('4fe01b8e-c4dd-4d7c-914f-acc821d7bb7a','zoneinfo','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('51312848-a57e-4c60-a3c4-8bfd58370a76','role list','saml','saml-role-list-mapper',NULL,'4858aea6-d749-4166-8c1a-3de16228b1ce'),('51a0f714-06f7-4cce-ac9e-588b60c45ffd','phone number','openid-connect','oidc-usermodel-attribute-mapper',NULL,'dee9a228-fe60-41d5-b484-47cd90246224'),('5226793e-c9ea-426f-8f21-ab13c44b9d61','birthdate','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('584ab1c6-3e54-452f-b0e9-6024f487c4f7','phone number verified','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b9148a9a-42d3-4e90-bbcf-33b03b44a0e9'),('58bd7272-5ab9-4adf-ae74-b72320254e01','groups','openid-connect','oidc-usermodel-realm-role-mapper',NULL,'1b6aa6a2-33b3-4645-87be-c658959367b9'),('5a8b60ba-02c1-4422-9e16-295123858582','phone number verified','openid-connect','oidc-usermodel-attribute-mapper',NULL,'dee9a228-fe60-41d5-b484-47cd90246224'),('648dd66b-87aa-4bc4-b29a-41f05c953b8e','realm roles','openid-connect','oidc-usermodel-realm-role-mapper',NULL,'612b86fb-90d3-4c31-a8df-28b1fc24b36e'),('6630d375-07cb-4c6f-9834-83808a733a83','email verified','openid-connect','oidc-usermodel-property-mapper',NULL,'fd787c51-5ed4-464e-86be-237d209128ba'),('705870bb-5736-410f-9769-f20d4940ec29','Client IP Address','openid-connect','oidc-usersessionmodel-note-mapper','22c20439-6887-43b5-813b-49f191fadb40',NULL),('710fda5b-6f3d-44cf-a103-9dca200092a5','roles','openid-connect','oidc-claims-param-token-mapper','22c20439-6887-43b5-813b-49f191fadb40',NULL),('77dd42ac-070c-4a5e-8a2e-078126b4e081','updated at','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('838d9bcb-354d-4cd6-b1da-3c43b86b7d70','upn','openid-connect','oidc-usermodel-property-mapper',NULL,'1b6aa6a2-33b3-4645-87be-c658959367b9'),('8d5af76c-4e8d-4f82-bd82-fbcebd08f5f1','email','openid-connect','oidc-usermodel-property-mapper',NULL,'5b9e322d-b418-424e-af31-dca243472f08'),('915194a5-8cae-46af-928b-a4d560192c54','updated at','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('960edbbe-ba82-41c4-9735-e65f57d4c20b','full name','openid-connect','oidc-full-name-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('96ff335d-1c11-42e8-b4b1-dafdeb671644','website','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('973aefa2-18a8-43e5-9446-2c01f3ba55af','middle name','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('9991b381-70c2-440c-a683-7266bb7f0102','nickname','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('9c6ba74a-7cde-4904-982b-7c25d128853c','profile','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('9ea578b3-bef0-4f72-929c-d7a175af6a60','email verified','openid-connect','oidc-usermodel-property-mapper',NULL,'5b9e322d-b418-424e-af31-dca243472f08'),('9ec04221-1792-4827-a623-0c07955e3656','full name','openid-connect','oidc-full-name-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('9f765186-a4f1-49b4-8a89-0b883bba16d4','given name','openid-connect','oidc-usermodel-property-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('a11aa5e0-42fd-4ab3-ab5e-5c107bde5c38','family name','openid-connect','oidc-usermodel-property-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('a66eac13-1ff3-46a3-b2fd-3240566c01b9','groups','openid-connect','oidc-usermodel-realm-role-mapper',NULL,'54e97e7e-8161-4cf0-b0ca-ef8b0aab2aef'),('b0440ee0-056e-4413-8f96-e1445896262f','locale','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('b6ebfad3-fe1c-4005-ab2a-15e220b84863','upn','openid-connect','oidc-usermodel-property-mapper',NULL,'54e97e7e-8161-4cf0-b0ca-ef8b0aab2aef'),('bd7c7fa4-919c-4de1-bca1-d42d1376db62','phone number','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b9148a9a-42d3-4e90-bbcf-33b03b44a0e9'),('c468bd33-89c2-44d5-8d4b-d21f64fbedc8','username','openid-connect','oidc-usermodel-property-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('cb64a85f-b808-4ce4-abf3-cb70367706c1','website','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('d1f511d0-854f-43aa-a59d-dba46ce1fa78','nickname','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('d245cd6f-bd93-4097-bfc2-78b2b229addb','locale','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('d367b6ce-8847-4607-ba0f-f8f3f618c0fc','audience resolve','openid-connect','oidc-audience-resolve-mapper','bf730706-6231-4f83-ac31-aaf9646a826e',NULL),('d3837fab-f04f-4dc7-84e5-c21e86df32be','audience resolve','openid-connect','oidc-audience-resolve-mapper','3694ae68-0198-42f4-8280-bade470681e6',NULL),('d4122e0e-11a7-4db4-aabd-42d982266619','address','openid-connect','oidc-address-mapper',NULL,'0b1eee33-4741-4903-a2ca-c2d3442d537c'),('d480c020-8fdb-43be-ba93-8e9136430806','email','openid-connect','oidc-usermodel-property-mapper',NULL,'fd787c51-5ed4-464e-86be-237d209128ba'),('dd2857c2-4145-41e3-b272-7c5ea2d96584','family name','openid-connect','oidc-usermodel-property-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('e278e05a-2231-401d-be09-ebf215d57b25','allowed web origins','openid-connect','oidc-allowed-origins-mapper',NULL,'8082bc35-e261-4d30-9254-45deb40f5bc8'),('e64e63dc-4926-49eb-a765-a7ee5d16f00a','zoneinfo','openid-connect','oidc-usermodel-attribute-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('ecdf9e7e-aaa0-49c1-8020-e6ba9bcd21dd','birthdate','openid-connect','oidc-usermodel-attribute-mapper',NULL,'b2bf91f6-0f19-4e95-ad89-0a65982e4b02'),('fd44a216-2c49-4436-a90b-cd6369306b1a','username','openid-connect','oidc-usermodel-property-mapper',NULL,'2f736949-d74b-449b-b367-9a8970657a85'),('ff4b3ab7-c70c-4e63-99a8-d6281736fd1c','Client Host','openid-connect','oidc-usersessionmodel-note-mapper','22c20439-6887-43b5-813b-49f191fadb40',NULL);
/*!40000 ALTER TABLE `PROTOCOL_MAPPER` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-09  0:26:48
