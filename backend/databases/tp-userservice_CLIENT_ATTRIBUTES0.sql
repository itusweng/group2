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
-- Table structure for table `CLIENT_ATTRIBUTES`
--

DROP TABLE IF EXISTS `CLIENT_ATTRIBUTES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENT_ATTRIBUTES` (
  `CLIENT_ID` varchar(36) NOT NULL,
  `VALUE` text,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`CLIENT_ID`,`NAME`),
  KEY `IDX_CLIENT_ATT_BY_NAME_VALUE` (`NAME`,`VALUE`(255)),
  CONSTRAINT `FK3C47C64BEACCA966` FOREIGN KEY (`CLIENT_ID`) REFERENCES `CLIENT` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENT_ATTRIBUTES`
--

LOCK TABLES `CLIENT_ATTRIBUTES` WRITE;
/*!40000 ALTER TABLE `CLIENT_ATTRIBUTES` DISABLE KEYS */;
INSERT INTO `CLIENT_ATTRIBUTES` VALUES ('1dbb1163-f4c3-44ae-a385-46d76862cd86','S256','pkce.code.challenge.method'),('22c20439-6887-43b5-813b-49f191fadb40','false','backchannel.logout.revoke.offline.tokens'),('22c20439-6887-43b5-813b-49f191fadb40','true','backchannel.logout.session.required'),('22c20439-6887-43b5-813b-49f191fadb40','false','client_credentials.use_refresh_token'),('22c20439-6887-43b5-813b-49f191fadb40','false','display.on.consent.screen'),('22c20439-6887-43b5-813b-49f191fadb40','false','exclude.session.state.from.auth.response'),('22c20439-6887-43b5-813b-49f191fadb40','false','id.token.as.detached.signature'),('22c20439-6887-43b5-813b-49f191fadb40','false','oauth2.device.authorization.grant.enabled'),('22c20439-6887-43b5-813b-49f191fadb40','false','oidc.ciba.grant.enabled'),('22c20439-6887-43b5-813b-49f191fadb40','false','require.pushed.authorization.requests'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml_force_name_id_format'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.artifact.binding'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.assertion.signature'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.authnstatement'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.client.signature'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.encrypt'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.force.post.binding'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.multivalued.roles'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.onetimeuse.condition'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.server.signature'),('22c20439-6887-43b5-813b-49f191fadb40','false','saml.server.signature.keyinfo.ext'),('22c20439-6887-43b5-813b-49f191fadb40','false','tls.client.certificate.bound.access.tokens'),('22c20439-6887-43b5-813b-49f191fadb40','true','use.refresh.tokens'),('3694ae68-0198-42f4-8280-bade470681e6','S256','pkce.code.challenge.method'),('6fba9dd5-348e-4bda-b418-58aa1a5a1555','S256','pkce.code.challenge.method'),('bf730706-6231-4f83-ac31-aaf9646a826e','S256','pkce.code.challenge.method');
/*!40000 ALTER TABLE `CLIENT_ATTRIBUTES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 16:09:16
