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
-- Table structure for table `COMPONENT`
--

DROP TABLE IF EXISTS `COMPONENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `COMPONENT` (
  `ID` varchar(36) NOT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(36) DEFAULT NULL,
  `PROVIDER_ID` varchar(36) DEFAULT NULL,
  `PROVIDER_TYPE` varchar(255) DEFAULT NULL,
  `REALM_ID` varchar(36) DEFAULT NULL,
  `SUB_TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_COMPONENT_REALM` (`REALM_ID`),
  KEY `IDX_COMPONENT_PROVIDER_TYPE` (`PROVIDER_TYPE`),
  CONSTRAINT `FK_COMPONENT_REALM` FOREIGN KEY (`REALM_ID`) REFERENCES `REALM` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPONENT`
--

/*!40000 ALTER TABLE `COMPONENT` DISABLE KEYS */;
INSERT INTO `COMPONENT` VALUES ('001634f4-96c6-4bbe-b616-dc3d0a74cf86','Full Scope Disabled','training-platform-realm','scope','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','training-platform-realm','anonymous'),('01fc5f29-cef5-4c08-882e-e02f69d9e105','Allowed Protocol Mapper Types','master','allowed-protocol-mappers','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','master','anonymous'),('0f1615af-ff5b-416c-9d18-3ee06adf08cf','Allowed Protocol Mapper Types','training-platform-realm','allowed-protocol-mappers','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','training-platform-realm','authenticated'),('186db2cc-34ac-4cc4-ab38-886ef0b34832','rsa-generated','training-platform-realm','rsa-generated','org.keycloak.keys.KeyProvider','training-platform-realm',NULL),('2c3678fe-af1a-46b8-8997-77ec3b6878ce','Allowed Client Scopes','master','allowed-client-templates','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','master','anonymous'),('31f282a8-82e1-4ff3-81c9-1dc47909ea4f','rsa-enc-generated','master','rsa-generated','org.keycloak.keys.KeyProvider','master',NULL),('3cc2b7c4-f278-4f5b-b200-4a03077d35ed','Allowed Protocol Mapper Types','training-platform-realm','allowed-protocol-mappers','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','training-platform-realm','anonymous'),('4c372f8b-e925-495e-8e12-f5e2053c6520','Allowed Client Scopes','master','allowed-client-templates','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','master','authenticated'),('6ea83f83-950d-4f93-a93c-a7f9a939af4f','Trusted Hosts','training-platform-realm','trusted-hosts','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','training-platform-realm','anonymous'),('9ff194ec-5bbb-4eeb-8471-7899715eb472','Full Scope Disabled','master','scope','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','master','anonymous'),('a6a0197e-ef7c-45cc-aa63-065e3ed0032b','aes-generated','training-platform-realm','aes-generated','org.keycloak.keys.KeyProvider','training-platform-realm',NULL),('ac21f2d1-adac-4d1f-adb4-26009913b8d3','Allowed Protocol Mapper Types','master','allowed-protocol-mappers','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','master','authenticated'),('aff15b26-7631-4b25-b089-99d42b19eba7','Allowed Client Scopes','training-platform-realm','allowed-client-templates','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','training-platform-realm','anonymous'),('b75e5494-3052-4b21-9730-17e8b05b6d9b','Allowed Client Scopes','training-platform-realm','allowed-client-templates','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','training-platform-realm','authenticated'),('ba2e9ac0-1981-442d-a941-7f11858045a2','hmac-generated','training-platform-realm','hmac-generated','org.keycloak.keys.KeyProvider','training-platform-realm',NULL),('c6d7e677-e1bf-44cc-b781-2206a4e9b60c','Consent Required','master','consent-required','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','master','anonymous'),('c7bf8e01-e2bf-4b76-966c-b209f7bb57e6','hmac-generated','master','hmac-generated','org.keycloak.keys.KeyProvider','master',NULL),('ce5ae54c-13a6-455c-b9df-d4cb02cb7e81','aes-generated','master','aes-generated','org.keycloak.keys.KeyProvider','master',NULL),('d281756f-f469-4215-b5d2-45845c08bd96','rsa-generated','master','rsa-generated','org.keycloak.keys.KeyProvider','master',NULL),('df4ba774-0f14-4e70-82a7-4d97ef147cc7','Trusted Hosts','master','trusted-hosts','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','master','anonymous'),('df564e0f-ce2e-4ac5-8e62-8d9170b5e079','Max Clients Limit','master','max-clients','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','master','anonymous'),('e47c11e2-1e30-4796-8b91-45d1fbe3b358','rsa-enc-generated','training-platform-realm','rsa-generated','org.keycloak.keys.KeyProvider','training-platform-realm',NULL),('fa15f2b5-4483-4fea-812b-1e11dc26e334','Consent Required','training-platform-realm','consent-required','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','training-platform-realm','anonymous'),('fbbf581f-fb0c-4c8c-9148-7b08ab190dc0','Max Clients Limit','training-platform-realm','max-clients','org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy','training-platform-realm','anonymous');
/*!40000 ALTER TABLE `COMPONENT` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 16:46:42
