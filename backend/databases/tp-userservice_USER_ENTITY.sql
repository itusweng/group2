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
-- Table structure for table `USER_ENTITY`
--

DROP TABLE IF EXISTS `USER_ENTITY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USER_ENTITY` (
  `ID` varchar(36) COLLATE utf8mb4_general_ci NOT NULL,
  `EMAIL` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `EMAIL_CONSTRAINT` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `EMAIL_VERIFIED` bit(1) NOT NULL DEFAULT b'0',
  `ENABLED` bit(1) NOT NULL DEFAULT b'0',
  `FEDERATION_LINK` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `FIRST_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `LAST_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `REALM_ID` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `USERNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `CREATED_TIMESTAMP` bigint DEFAULT NULL,
  `SERVICE_ACCOUNT_CLIENT_LINK` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `NOT_BEFORE` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_DYKN684SL8UP1CRFEI6ECKHD7` (`REALM_ID`,`EMAIL_CONSTRAINT`),
  UNIQUE KEY `UK_RU8TT6T700S9V50BU18WS5HA6` (`REALM_ID`,`USERNAME`),
  KEY `IDX_USER_EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ENTITY`
--

LOCK TABLES `USER_ENTITY` WRITE;
/*!40000 ALTER TABLE `USER_ENTITY` DISABLE KEYS */;
INSERT INTO `USER_ENTITY` VALUES ('0951c69e-9355-4a48-b817-7c779cede052',NULL,'f3419941-1b5f-4db4-bac4-2ff5b1145c0d',_binary '',_binary '',NULL,NULL,NULL,'training-platform-realm','test5',1639896174686,NULL,1641831517),('31a8c5a6-4cd9-476c-ac10-d345638833b6',NULL,'b3dda27a-d489-45ec-bf96-23620df33078',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','service-account-tp-spring-cloud-gateway-client',1637971214280,'22c20439-6887-43b5-813b-49f191fadb40',0),('3345e8b7-e6c4-4589-a018-fef2ff135a5f','$2a$10$ydxjx..pjjxmyb5zj2eaourbrjk.9yktprwqvskarri0prqetau9k','$2a$10$ydxjx..pjjxmyb5zj2eaourbrjk.9yktprwqvskarri0prqetau9k',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','hadi kocum',1641840835555,NULL,0),('44689a5e-41b0-4008-99fd-7a0043f5a1a5','deneme2@gmail.com','deneme2@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme2',1641841664174,NULL,0),('4638fe72-9592-4b94-8a73-463b507db582','deneme3@gmail.com','deneme3@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme3',1641841765932,NULL,0),('52ea9aa2-a569-403c-b33b-46c831d456da','$2a$10$pj369bsfe7fzusqkog4rkuzqav1t5uzs7n7aiu2kydvyzxhpqyrx.','$2a$10$pj369bsfe7fzusqkog4rkuzqav1t5uzs7n7aiu2kydvyzxhpqyrx.',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','erol abi̇',1641840790150,NULL,0),('5c33fdaa-6ddf-4ee2-a8db-b580d66104f1','deneme8@gmail.com','deneme8@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme8',1641842380269,NULL,0),('6474fc5b-23ae-48e9-8e73-d720c17ca8a5','deneme9@gmail.com','deneme9@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme9',1641842500487,NULL,0),('6cc5f868-c060-4591-93e6-dd347b05999d',NULL,'7aa7c7ef-c653-4ab1-bc41-ce52a97476a1',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','test1',1637971272674,NULL,1637972507),('7374209f-8cc2-4a1c-ba3f-6b57fe43cc5e','test@gmail.com','test@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','test2',1638132262195,NULL,0),('746eb40a-534b-4ed1-83af-55f21888d4d0',NULL,'6c3abe77-8864-42b6-af0f-852db2b9ec99',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','ya hak',1641839335871,NULL,0),('810ace42-8536-4337-a2c6-593f4b3972ed','$2a$10$rcv/m9nt9ikkntodyz1l7ean.a.5ysklbzwy7tvxttp/yyehsonb.','$2a$10$rcv/m9nt9ikkntodyz1l7ean.a.5ysklbzwy7tvxttp/yyehsonb.',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','test8',1641839721928,NULL,0),('88992624-b106-447d-a387-aa3f6466856c','$2a$10$s7vhgwauge/y6j.6w4b5fe71wl.4zd8akdqxwpqxoze8w2zyxj1ek','$2a$10$s7vhgwauge/y6j.6w4b5fe71wl.4zd8akdqxwpqxoze8w2zyxj1ek',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','olustur lan ibiinnnnnnnnne',1641839762704,NULL,0),('89677443-e591-4bb2-ac4c-ccefd5911de4','deneme5@gmail.com','deneme5@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme5',1641841919829,NULL,0),('910f1061-e835-4415-aa7e-49ffbca5a23f',NULL,'07ff9ae1-2c8b-4fe4-88a3-ed2fdd367c9e',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','test4',1638677752786,NULL,0),('9701409e-042e-49de-a8d5-d046e7ad790d','deneme4@gmail.com','deneme4@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme4',1641841799505,NULL,0),('991b52d0-b5b3-46e9-83e8-9a7adec46201','deneme7@gmail.com','deneme7@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme7',1641842152226,NULL,0),('9b0a27c5-e31d-4127-811a-2e078cf3b044',NULL,'670fba5c-a0bf-49bb-83e7-54faa070dc8d',_binary '\0',_binary '',NULL,NULL,NULL,'master','admin',1637966875195,NULL,0),('a6e98e48-a6ae-4ca0-a08e-9dde7d503c5f','test8@gmail.com','test8@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme1',1641841342055,NULL,0),('aa125086-7dd9-471f-a3f1-d0c4d858af3b',NULL,'6053b168-50b6-448a-99de-59f13209ec75',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','sdfsd',1641834099245,NULL,0),('bac89e60-b525-4d2f-9fe9-af88f4959dfd','deneme6@gmail.com','deneme6@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','deneme6',1641842002859,NULL,0),('be5851ce-6318-49ef-89b5-b8d842155eb1',NULL,'8b2ad81b-5bfc-4432-8ea6-71834ec05496',_binary '\0',_binary '',NULL,NULL,NULL,'master','test',1637966911227,NULL,0),('d31510c2-eb5d-47ba-bfbc-53c0d6759f72','$2a$10$ft9g3r3czaqbdqdrtrajloisxlhfxmxq9s2s6hdorlxoki.tiemsy','$2a$10$ft9g3r3czaqbdqdrtrajloisxlhfxmxq9s2s6hdorlxoki.tiemsy',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','hadi kocumrtgr',1641841054677,NULL,0),('d7572e8d-81cf-442a-aa77-4d79311807ce',NULL,'55f7ab2d-f3aa-4867-8cd3-64ddcdd0e363',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','sddfdfgfsd',1641837559068,NULL,0),('df7bf34d-b258-4efc-9331-5271374df2f4',NULL,'fed3f6bf-5924-471a-bbd5-dbef5a15689f',_binary '\0',_binary '\0',NULL,NULL,NULL,'training-platform-realm','valllaaa olusturdum laaaan',1641834124173,NULL,0),('ecb14193-d545-423b-8e02-53097bc765a6','test3@gmail.com','test3@gmail.com',_binary '\0',_binary '',NULL,NULL,NULL,'training-platform-realm','test3',1638134463747,NULL,0),('f73a1df4-e961-462f-a1de-2953d1c258ab',NULL,'fcc58ae2-1b00-4ebd-ad2b-4d3ae6e5211d',_binary '',_binary '',NULL,NULL,NULL,'training-platform-realm','test6',1641051190009,NULL,0);
/*!40000 ALTER TABLE `USER_ENTITY` ENABLE KEYS */;
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
