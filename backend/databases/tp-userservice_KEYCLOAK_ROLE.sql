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
-- Table structure for table `KEYCLOAK_ROLE`
--

DROP TABLE IF EXISTS `KEYCLOAK_ROLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KEYCLOAK_ROLE` (
  `ID` varchar(36) NOT NULL,
  `CLIENT_REALM_CONSTRAINT` varchar(255) DEFAULT NULL,
  `CLIENT_ROLE` bit(1) DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `REALM_ID` varchar(255) DEFAULT NULL,
  `CLIENT` varchar(36) DEFAULT NULL,
  `REALM` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_J3RWUVD56ONTGSUHOGM184WW2-2` (`NAME`,`CLIENT_REALM_CONSTRAINT`),
  KEY `IDX_KEYCLOAK_ROLE_CLIENT` (`CLIENT`),
  KEY `IDX_KEYCLOAK_ROLE_REALM` (`REALM`),
  CONSTRAINT `FK_6VYQFE4CN4WLQ8R6KT5VDSJ5C` FOREIGN KEY (`REALM`) REFERENCES `REALM` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KEYCLOAK_ROLE`
--

/*!40000 ALTER TABLE `KEYCLOAK_ROLE` DISABLE KEYS */;
INSERT INTO `KEYCLOAK_ROLE` VALUES ('010211ce-2353-4e43-8e1c-18e1780f960f','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_view-authorization}','view-authorization','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('059fec82-462b-440f-8b05-a5d2ac7abdc3','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_view-authorization}','view-authorization','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('0a4d5c50-ad37-483f-add1-d9a066be882a','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_query-users}','query-users','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('0d3f531a-3b4d-4abb-b1e1-5a4406f9e6fc','75a57c7d-19a9-49f3-8796-778f11f5552d',_binary '','${role_manage-account}','manage-account','training-platform-realm','75a57c7d-19a9-49f3-8796-778f11f5552d',NULL),('0f297a5b-2509-4746-82fa-a3ab83ded7e6','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_manage-identity-providers}','manage-identity-providers','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('14624847-ec9e-4402-8f8d-e7d70178095b','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_view-events}','view-events','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('16702d68-0770-4f17-92b2-ce0aa4d8f00d','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_manage-realm}','manage-realm','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('1ede7393-94d4-4ef1-bfaf-c725685b0c63','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_view-identity-providers}','view-identity-providers','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('1f01d757-7ff8-4b05-9f54-8b191d9d9cf3','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_manage-authorization}','manage-authorization','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('205583af-3435-48f6-8414-80071ef76943','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_manage-authorization}','manage-authorization','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('28344ae6-8198-4b7c-b074-253a8ab603f7','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_view-identity-providers}','view-identity-providers','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('2991a2b1-6a8a-4e08-a792-28028c8dd711','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_manage-identity-providers}','manage-identity-providers','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('2c7daca4-c96b-4f64-b2ce-3e5367a3a4c9','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_query-groups}','query-groups','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('36bb7cbe-9644-4975-b07f-3c939a5d6430','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_query-realms}','query-realms','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('3a60a74f-0f53-49fc-9cf1-8809a95bc4a0','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_manage-realm}','manage-realm','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('3bd94c41-2f1d-4b9c-bb01-5d086c6e3aeb','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_query-clients}','query-clients','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('3d473f42-f1ec-4c8e-a713-8e0e340d9056','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_impersonation}','impersonation','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('3f475701-8b53-49d3-904d-bede404c7356','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_view-clients}','view-clients','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('3f576173-aeec-45a8-ac25-18c78e9e7b2e','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_view-realm}','view-realm','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('3fc29d19-65d2-4980-879d-0fcf2651b5e9','79915969-616f-45bf-85bf-615bac5c29b2',_binary '','${role_view-profile}','view-profile','master','79915969-616f-45bf-85bf-615bac5c29b2',NULL),('415daf3b-bc48-4daf-a804-45358b74cd45','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_impersonation}','impersonation','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('42624042-2ced-4d5e-bee6-f554c2e89571','master',_binary '\0','${role_offline-access}','offline_access','master',NULL,NULL),('4298e966-05e1-4116-92b4-cf50b8598b5a','master',_binary '\0','${role_default-roles}','default-roles-master','master',NULL,NULL),('4acadb22-4f6f-4f63-a032-7f5e4207cf05','22c20439-6887-43b5-813b-49f191fadb40',_binary '',NULL,'uma_protection','training-platform-realm','22c20439-6887-43b5-813b-49f191fadb40',NULL),('4e77b4b0-93b3-4b69-b16e-8e5781bdb987','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_manage-users}','manage-users','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('4eb1c815-19a9-4b51-8ce2-b15127e6e8a3','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_view-events}','view-events','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('510bd571-49e2-4049-8ad2-ef0ccca22ff0','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_view-users}','view-users','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('523f341c-31fa-479c-a7cb-ffc57fe13f3f','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_view-realm}','view-realm','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('542665cc-6546-43aa-9be3-f6dc0b81431e','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_create-client}','create-client','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('54cf4fe9-609d-48fb-99ec-9d831610c79f','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_view-events}','view-events','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('550ba8df-7afe-4010-abb5-99fb5304349b','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_manage-authorization}','manage-authorization','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('55a823f7-52ae-4750-9ade-af1aaa874f04','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_manage-users}','manage-users','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('57148fcd-255c-4833-902b-8df483c67212','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_manage-users}','manage-users','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('59bdd1ca-a3cd-42ba-9a9c-973f8a9098c2','79915969-616f-45bf-85bf-615bac5c29b2',_binary '','${role_manage-account-links}','manage-account-links','master','79915969-616f-45bf-85bf-615bac5c29b2',NULL),('642a49b7-c491-4e95-bd86-ad72c56e3882','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_view-clients}','view-clients','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('669a9254-9b12-4f20-b49f-195b6b57cc1e','2493d4c4-276d-4a6b-99af-09b9563d031f',_binary '','${role_read-token}','read-token','master','2493d4c4-276d-4a6b-99af-09b9563d031f',NULL),('677ab716-5588-426d-a24e-260828854e50','training-platform-realm',_binary '\0','${role_uma_authorization}','uma_authorization','training-platform-realm',NULL,NULL),('6eedcf44-6a3c-48c2-bcc4-f6bf7774666c','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_query-groups}','query-groups','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('7128e18f-9430-4064-ab58-e3e825efd546','79915969-616f-45bf-85bf-615bac5c29b2',_binary '','${role_manage-consent}','manage-consent','master','79915969-616f-45bf-85bf-615bac5c29b2',NULL),('74f5cd40-23a3-4177-a249-b1ccd8f7ce36','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_realm-admin}','realm-admin','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('756301f6-27db-4ced-9c8f-171f50b45742','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_query-clients}','query-clients','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('7729af88-ac50-497f-b62c-f51ea59eae76','79915969-616f-45bf-85bf-615bac5c29b2',_binary '','${role_view-consent}','view-consent','master','79915969-616f-45bf-85bf-615bac5c29b2',NULL),('79aa2de3-724f-4440-8b3b-3510d8ab3c5e','75a57c7d-19a9-49f3-8796-778f11f5552d',_binary '','${role_view-profile}','view-profile','training-platform-realm','75a57c7d-19a9-49f3-8796-778f11f5552d',NULL),('7ac52ed8-10da-42c4-bb16-f48cea68c3b9','master',_binary '\0','${role_admin}','admin','master',NULL,NULL),('7e41caf4-8159-4542-8aa1-cc6004367bbc','training-platform-realm',_binary '\0','${role_default-roles}','default-roles-training-platform-realm','training-platform-realm',NULL,NULL),('82e89cc6-6299-414d-970b-f99b37f8335b','79915969-616f-45bf-85bf-615bac5c29b2',_binary '','${role_view-applications}','view-applications','master','79915969-616f-45bf-85bf-615bac5c29b2',NULL),('8459d63f-457c-4d1a-9bef-61adf9bcd6ff','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_manage-realm}','manage-realm','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('858e8d2d-9248-4fae-a6e2-03b586e42513','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_manage-identity-providers}','manage-identity-providers','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('87a673e2-6986-4bed-bb97-4da1740dfb20','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_query-users}','query-users','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('894ac35d-c0bf-402d-98d8-4dfe15d326bf','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_manage-clients}','manage-clients','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('8cef8424-ce20-48be-aa85-92a797e874e0','22c20439-6887-43b5-813b-49f191fadb40',_binary '',NULL,'tp-training-platform','training-platform-realm','22c20439-6887-43b5-813b-49f191fadb40',NULL),('8dce3dd7-0f6c-43fe-b74b-68fe42adcf6b','75a57c7d-19a9-49f3-8796-778f11f5552d',_binary '','${role_manage-consent}','manage-consent','training-platform-realm','75a57c7d-19a9-49f3-8796-778f11f5552d',NULL),('8dcfedb5-eecd-4a81-8da7-c57b14a60ee6','75a57c7d-19a9-49f3-8796-778f11f5552d',_binary '','${role_view-consent}','view-consent','training-platform-realm','75a57c7d-19a9-49f3-8796-778f11f5552d',NULL),('92841c1d-2ea8-4aea-8800-3abccbf676f2','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_create-client}','create-client','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('936a28b3-647f-4664-8d98-311c449d7dfe','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_view-authorization}','view-authorization','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('970502e3-cb26-45e4-86cf-e0ee927c8a93','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_query-realms}','query-realms','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('9c5f4bff-19c5-4b9e-81d9-37cdf60ad5c2','75a57c7d-19a9-49f3-8796-778f11f5552d',_binary '','${role_manage-account-links}','manage-account-links','training-platform-realm','75a57c7d-19a9-49f3-8796-778f11f5552d',NULL),('9f11cf58-9048-4b87-8120-4ce67272d575','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_view-clients}','view-clients','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('9f9920ed-824a-4681-bc8f-0c81a4764975','75a57c7d-19a9-49f3-8796-778f11f5552d',_binary '','${role_view-applications}','view-applications','training-platform-realm','75a57c7d-19a9-49f3-8796-778f11f5552d',NULL),('a18115b4-e19d-41b4-841b-c80837358cb6','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_query-clients}','query-clients','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('a4352b09-13f0-4066-96c9-cb5b465c0fcc','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_view-users}','view-users','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('a4404bed-98a5-4dc6-b5d5-17c678456c72','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_manage-clients}','manage-clients','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('a52c3efc-fcf5-4a19-8084-3e4ed2fee32f','75a57c7d-19a9-49f3-8796-778f11f5552d',_binary '','${role_delete-account}','delete-account','training-platform-realm','75a57c7d-19a9-49f3-8796-778f11f5552d',NULL),('a957abe8-b9ad-443b-bfa8-3926eef6e62b','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_manage-clients}','manage-clients','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('ad4223ba-7635-47c0-adde-fad8a399355e','79915969-616f-45bf-85bf-615bac5c29b2',_binary '','${role_manage-account}','manage-account','master','79915969-616f-45bf-85bf-615bac5c29b2',NULL),('b2547b0b-397d-4c1a-beba-91645b9da5b7','training-platform-realm',_binary '\0',NULL,'MANAGER','training-platform-realm',NULL,NULL),('b3a5960c-390b-42f6-bf9a-1739ba5319cd','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_create-client}','create-client','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('b3c5ff61-8cad-475b-b20e-b1c045a2f0b4','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_view-identity-providers}','view-identity-providers','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('bc3e5b02-71d5-42e1-be4b-0897751fd27a','c5a95f7a-298c-4a2e-9150-3e3cde3788e2',_binary '','${role_read-token}','read-token','training-platform-realm','c5a95f7a-298c-4a2e-9150-3e3cde3788e2',NULL),('bd54ca04-482f-47b1-9f5c-399874344d35','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_view-realm}','view-realm','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('bf1a0133-7f44-4482-bf56-b5c512fa42fe','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_manage-events}','manage-events','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('c11a1136-e837-43da-8aa5-6a789be89d13','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_view-users}','view-users','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('c61c8a56-9304-4e73-80e5-e641d7ba4086','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_impersonation}','impersonation','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('cd1037e4-d344-4cfc-922c-1fc2e8f38c8c','22c20439-6887-43b5-813b-49f191fadb40',_binary '',NULL,'manage-users','training-platform-realm','22c20439-6887-43b5-813b-49f191fadb40',NULL),('cf65e2df-9016-4cff-8faa-65226a2a93c0','master',_binary '\0','${role_uma_authorization}','uma_authorization','master',NULL,NULL),('dae3f083-cfac-42b5-8e0a-5be6e353fa58','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_manage-events}','manage-events','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('e5cd5839-4c70-48d9-9522-555025c7a533','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',_binary '','${role_query-realms}','query-realms','master','412bc1ee-d68f-4be5-96bf-cd7fe022e19d',NULL),('ec11bde5-fe71-4c8e-af7f-ad53d0ed8eba','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_query-users}','query-users','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('ef49ea7c-5e3c-42d1-a1b6-4c92098c8fb0','5c672d07-da67-4494-b773-71c6df07837c',_binary '','${role_query-groups}','query-groups','training-platform-realm','5c672d07-da67-4494-b773-71c6df07837c',NULL),('f21963a9-6d51-42d3-b64a-b8d5c0925483','training-platform-realm',_binary '\0','${role_offline-access}','offline_access','training-platform-realm',NULL,NULL),('f5ddd640-c028-4773-88df-ccaa170890ce','79915969-616f-45bf-85bf-615bac5c29b2',_binary '','${role_delete-account}','delete-account','master','79915969-616f-45bf-85bf-615bac5c29b2',NULL),('f7661d59-0817-4e3c-8468-a8cbca0992b4','bd783b6e-4231-45a8-a878-71215870684f',_binary '','${role_manage-events}','manage-events','master','bd783b6e-4231-45a8-a878-71215870684f',NULL),('fbedb3fb-1304-42c4-b400-9a669898eb02','master',_binary '\0','${role_create-realm}','create-realm','master',NULL,NULL);
/*!40000 ALTER TABLE `KEYCLOAK_ROLE` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-31  8:52:05
