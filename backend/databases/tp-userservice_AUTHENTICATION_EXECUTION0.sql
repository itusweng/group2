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
-- Table structure for table `AUTHENTICATION_EXECUTION`
--

DROP TABLE IF EXISTS `AUTHENTICATION_EXECUTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AUTHENTICATION_EXECUTION` (
  `ID` varchar(36) NOT NULL,
  `ALIAS` varchar(255) DEFAULT NULL,
  `AUTHENTICATOR` varchar(36) DEFAULT NULL,
  `REALM_ID` varchar(36) DEFAULT NULL,
  `FLOW_ID` varchar(36) DEFAULT NULL,
  `REQUIREMENT` int DEFAULT NULL,
  `PRIORITY` int DEFAULT NULL,
  `AUTHENTICATOR_FLOW` bit(1) NOT NULL DEFAULT b'0',
  `AUTH_FLOW_ID` varchar(36) DEFAULT NULL,
  `AUTH_CONFIG` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_AUTH_EXEC_REALM_FLOW` (`REALM_ID`,`FLOW_ID`),
  KEY `IDX_AUTH_EXEC_FLOW` (`FLOW_ID`),
  CONSTRAINT `FK_AUTH_EXEC_FLOW` FOREIGN KEY (`FLOW_ID`) REFERENCES `AUTHENTICATION_FLOW` (`ID`),
  CONSTRAINT `FK_AUTH_EXEC_REALM` FOREIGN KEY (`REALM_ID`) REFERENCES `REALM` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AUTHENTICATION_EXECUTION`
--

LOCK TABLES `AUTHENTICATION_EXECUTION` WRITE;
/*!40000 ALTER TABLE `AUTHENTICATION_EXECUTION` DISABLE KEYS */;
INSERT INTO `AUTHENTICATION_EXECUTION` VALUES ('0108c65e-f6bf-403e-8de6-40196f9fc1a9',NULL,'client-jwt','training-platform-realm','bd101774-198e-4dc6-9043-7d9c0ba8b68f',2,20,_binary '\0',NULL,NULL),('03abad41-d687-4ccf-bc7f-f7957b3eab11',NULL,NULL,'master','e912ab61-604b-4b7b-bf29-4627faca13cd',0,20,_binary '','c50fffdd-454a-4b7b-bc98-d3f4726abe72',NULL),('075a9130-47ff-44d0-9f78-e46bf17afc9f',NULL,'client-jwt','master','ca3a0139-2c53-41bd-adb8-984acfc24eef',2,20,_binary '\0',NULL,NULL),('07b248ca-6256-4e67-ad4f-19fa7bbfb7af',NULL,'basic-auth-otp','master','c50fffdd-454a-4b7b-bc98-d3f4726abe72',3,20,_binary '\0',NULL,NULL),('0da6f177-1754-429b-af45-17b24630054d',NULL,'idp-confirm-link','training-platform-realm','245e2eda-a2ff-4a4d-994e-9d716ca9e037',0,10,_binary '\0',NULL,NULL),('1213953f-4944-4d58-88e3-a369c572ebeb',NULL,'client-x509','training-platform-realm','bd101774-198e-4dc6-9043-7d9c0ba8b68f',2,40,_binary '\0',NULL,NULL),('173e830d-a387-4072-911a-542dcb6b2b62',NULL,'direct-grant-validate-password','master','c1833708-dfd2-4027-aab9-10fd6541e1ed',0,20,_binary '\0',NULL,NULL),('19264ed0-c383-4a94-9e01-8f9fcb85442c',NULL,'registration-page-form','master','285c15be-65cf-4da8-9a1f-807808cfce68',0,10,_binary '','5aca595e-1ccc-4788-b17b-517e73763c2c',NULL),('1fa85063-e158-49f9-b95c-efb2a4c73405',NULL,'registration-password-action','training-platform-realm','fee2aa93-f9f5-4cbb-961e-7072976af80c',0,50,_binary '\0',NULL,NULL),('22078dee-30c3-46c4-811f-779b83e53ec1',NULL,NULL,'training-platform-realm','6320a3c5-04b2-45fe-968a-2a86cfeaf24b',2,20,_binary '','245e2eda-a2ff-4a4d-994e-9d716ca9e037',NULL),('226fe14f-ff92-420d-9db0-34edacce5175',NULL,'reset-otp','training-platform-realm','486540bf-62c0-464e-905a-2667bf2b0cf4',0,20,_binary '\0',NULL,NULL),('236761aa-8613-418f-a5e6-2ff1a60d4189',NULL,NULL,'master','6cef92ba-4928-49c9-8fa9-f960a8e3228f',2,30,_binary '','8434423b-223e-4ad5-ba89-db67890abd82',NULL),('253df937-0e00-4086-b943-d5407c07fa63',NULL,'auth-otp-form','master','9a572f73-6f05-4c9c-89a2-269b21f5cffa',0,20,_binary '\0',NULL,NULL),('2a2b2aa8-59dc-449c-a82c-bd3fa29173cc',NULL,'auth-username-password-form','training-platform-realm','7b3a96de-d337-4fbf-a541-eab506529482',0,10,_binary '\0',NULL,NULL),('2a2c4daa-6b13-45dc-8ac6-670e607fd6f9',NULL,'reset-credential-email','master','3c3c831b-cb2c-44d0-b668-2eb7a69b2aea',0,20,_binary '\0',NULL,NULL),('2d0fa673-2e6e-46c3-9a8a-84484dae1efa',NULL,'no-cookie-redirect','master','e912ab61-604b-4b7b-bf29-4627faca13cd',0,10,_binary '\0',NULL,NULL),('2e0077f3-ac03-47e5-895f-00b44e5a7f1d',NULL,'direct-grant-validate-otp','master','57d69449-858b-4b79-82ee-42ecacaade0d',0,20,_binary '\0',NULL,NULL),('303c99d6-d415-43ba-88ae-e9b7e4ed1e18',NULL,'auth-otp-form','master','b63534b6-a99a-4b5f-951f-201f0f6edb95',0,20,_binary '\0',NULL,NULL),('3080dcb2-94b4-4a9e-9837-2fdfbdf057de',NULL,'registration-page-form','training-platform-realm','32e8db6f-f9e7-4fbc-ac72-c671ea67c208',0,10,_binary '','fee2aa93-f9f5-4cbb-961e-7072976af80c',NULL),('36a0a26f-b08a-468d-8731-9e03e8e6eba5',NULL,'auth-cookie','training-platform-realm','73b5375c-de3d-4f7b-984e-387d76e96784',2,10,_binary '\0',NULL,NULL),('36c5726c-63f1-41f3-9e5e-e7356f9cec96',NULL,'conditional-user-configured','training-platform-realm','85b597e6-2abf-4f9e-8d37-bc2efdfc189e',0,10,_binary '\0',NULL,NULL),('374dcbca-22a2-46e6-bdfa-f710ba3bff9c',NULL,'auth-username-password-form','master','8434423b-223e-4ad5-ba89-db67890abd82',0,10,_binary '\0',NULL,NULL),('38156649-c035-4fb9-844c-fa11d429b29c',NULL,'conditional-user-configured','training-platform-realm','1f335176-1b29-4088-a861-1d3bff7dc318',0,10,_binary '\0',NULL,NULL),('388950ec-32fb-4f67-85e1-ef43e30634d5',NULL,NULL,'master','ba659e5a-7ef7-4ef9-a412-1f744f97abc1',2,20,_binary '','22006cdc-872e-472e-86f1-334949a8888b',NULL),('3be07364-ecf1-4672-838b-47dac531f8e1',NULL,'auth-spnego','training-platform-realm','366e44a7-b12a-493f-8213-5d6d8210d474',3,30,_binary '\0',NULL,NULL),('3df339c7-dd55-402b-b84f-dde89047078e',NULL,'conditional-user-configured','master','a9ebfe0f-81e5-4994-8f22-27bf0a70cfb3',0,10,_binary '\0',NULL,NULL),('3fe338bd-df98-4279-87e0-8cd2c41f1140',NULL,'auth-otp-form','training-platform-realm','ff9afe4b-c4a8-433b-952a-5882cc9e74d8',0,20,_binary '\0',NULL,NULL),('3fe611fb-7760-4369-ab1c-99b145020d44',NULL,'direct-grant-validate-username','master','c1833708-dfd2-4027-aab9-10fd6541e1ed',0,10,_binary '\0',NULL,NULL),('420f1b97-b269-462d-9949-4e1a603ba14c',NULL,'auth-spnego','master','6cef92ba-4928-49c9-8fa9-f960a8e3228f',3,20,_binary '\0',NULL,NULL),('472ce06c-07fd-4511-9640-dd1bbeb4dc45',NULL,NULL,'master','9b6cd68e-93d8-4338-bd8a-da5c8018d769',2,20,_binary '','a381f2c1-840d-4aea-b904-25360854c0a6',NULL),('4b0e03a6-571a-457d-9604-9d9dce397320',NULL,NULL,'master','c1833708-dfd2-4027-aab9-10fd6541e1ed',1,30,_binary '','57d69449-858b-4b79-82ee-42ecacaade0d',NULL),('4d6b6d64-1f9a-44ab-97c0-f06c18474d61',NULL,NULL,'training-platform-realm','245e2eda-a2ff-4a4d-994e-9d716ca9e037',0,20,_binary '','ef1c7897-a86d-445c-8dd5-0d9c6b14528e',NULL),('500f01b8-57d0-4ef8-9ded-83647cd02114',NULL,NULL,'master','2aa0f9cc-c91a-40a7-a0be-dbb76b80896c',0,20,_binary '','9b6cd68e-93d8-4338-bd8a-da5c8018d769',NULL),('53e9bf5f-b18b-44ad-8444-f16532a627eb',NULL,'identity-provider-redirector','training-platform-realm','73b5375c-de3d-4f7b-984e-387d76e96784',2,25,_binary '\0',NULL,NULL),('5b907e70-6683-4118-93af-3b40085fa461',NULL,'client-secret','training-platform-realm','bd101774-198e-4dc6-9043-7d9c0ba8b68f',2,10,_binary '\0',NULL,NULL),('5dde04cc-684e-49af-98ec-dbd49b0b2fb8',NULL,NULL,'master','8434423b-223e-4ad5-ba89-db67890abd82',1,20,_binary '','b63534b6-a99a-4b5f-951f-201f0f6edb95',NULL),('5e5dc89e-7be7-44c0-bbb0-15155567d168',NULL,'registration-user-creation','master','5aca595e-1ccc-4788-b17b-517e73763c2c',0,20,_binary '\0',NULL,NULL),('6bd3839c-e741-4542-bdf7-6ae63b6968e2',NULL,'conditional-user-configured','master','57d69449-858b-4b79-82ee-42ecacaade0d',0,10,_binary '\0',NULL,NULL),('732857f2-3be9-4a04-8853-8d8335cf580b',NULL,NULL,'master','22006cdc-872e-472e-86f1-334949a8888b',1,20,_binary '','9a572f73-6f05-4c9c-89a2-269b21f5cffa',NULL),('79c736e5-791b-4745-9106-a8eed7dd10c6',NULL,'reset-credentials-choose-user','training-platform-realm','613e10cc-178d-4192-ac75-cdf5d1d40535',0,10,_binary '\0',NULL,NULL),('7a5194a7-3dad-432a-9296-585d1201c1a5',NULL,'http-basic-authenticator','training-platform-realm','085faa6f-be3b-4e63-85f8-e32ed1456995',0,10,_binary '\0',NULL,NULL),('7ba78b0f-54f3-40ac-9edb-8c04caf8cc76',NULL,'idp-create-user-if-unique','master','9b6cd68e-93d8-4338-bd8a-da5c8018d769',2,10,_binary '\0',NULL,'73810be0-76bc-4eb0-90bd-a0643ed9c9e6'),('7ce018c6-342f-4a4b-bdad-bd5c167ad3ce',NULL,NULL,'training-platform-realm','73b5375c-de3d-4f7b-984e-387d76e96784',2,30,_binary '','7b3a96de-d337-4fbf-a541-eab506529482',NULL),('807df770-46ae-4e44-903a-9ed361d20524',NULL,'http-basic-authenticator','master','fd237af5-e92d-4294-9fae-000a62e94a59',0,10,_binary '\0',NULL,NULL),('8096200c-7a40-4560-9eb4-29c53eb563ac',NULL,'conditional-user-configured','master','9a572f73-6f05-4c9c-89a2-269b21f5cffa',0,10,_binary '\0',NULL,NULL),('82b05c3f-fa6e-46f8-a87a-c40f3713e30e',NULL,NULL,'training-platform-realm','0eec3cc0-5311-44c0-95b8-6421114455d3',1,30,_binary '','85b597e6-2abf-4f9e-8d37-bc2efdfc189e',NULL),('86733a89-6903-4b25-bc4f-96bfbdeac04f',NULL,'auth-otp-form','training-platform-realm','1f335176-1b29-4088-a861-1d3bff7dc318',0,20,_binary '\0',NULL,NULL),('88aa83cd-c261-4a54-b574-fbfc1027a70a',NULL,'reset-password','master','3c3c831b-cb2c-44d0-b668-2eb7a69b2aea',0,30,_binary '\0',NULL,NULL),('8b3de647-6c56-435a-9460-6a1ab7f29702',NULL,'basic-auth-otp','training-platform-realm','366e44a7-b12a-493f-8213-5d6d8210d474',3,20,_binary '\0',NULL,NULL),('8c88add2-346e-458b-9871-3defcfc9015e',NULL,'direct-grant-validate-password','training-platform-realm','0eec3cc0-5311-44c0-95b8-6421114455d3',0,20,_binary '\0',NULL,NULL),('90930ae5-ef0b-446c-9f39-14f395e758ac',NULL,'auth-spnego','training-platform-realm','73b5375c-de3d-4f7b-984e-387d76e96784',3,20,_binary '\0',NULL,NULL),('93c9ea23-5b12-4c2b-a661-851ced3b1491',NULL,'basic-auth','training-platform-realm','366e44a7-b12a-493f-8213-5d6d8210d474',0,10,_binary '\0',NULL,NULL),('95ebdda1-3986-4aee-ae33-4909524376de',NULL,'registration-recaptcha-action','training-platform-realm','fee2aa93-f9f5-4cbb-961e-7072976af80c',3,60,_binary '\0',NULL,NULL),('9ff912a0-d85a-4ac6-8501-db0aed737245',NULL,'idp-confirm-link','master','a381f2c1-840d-4aea-b904-25360854c0a6',0,10,_binary '\0',NULL,NULL),('a0a4b32c-dcb0-41e5-b11b-43282590f831',NULL,'idp-review-profile','master','2aa0f9cc-c91a-40a7-a0be-dbb76b80896c',0,10,_binary '\0',NULL,'c8080b28-a10f-4e3d-bda0-b3a00cc7ce15'),('a30fae90-583d-4e13-8256-7875409ffacb',NULL,'idp-email-verification','training-platform-realm','ef1c7897-a86d-445c-8dd5-0d9c6b14528e',2,10,_binary '\0',NULL,NULL),('a38fe5bf-35c5-419b-a178-63ae1ee21fc5',NULL,'docker-http-basic-authenticator','master','618aeee9-44cc-46ab-87a1-9a923db77826',0,10,_binary '\0',NULL,NULL),('a40559ba-9eb2-4c39-8415-fbc1d149850f',NULL,'idp-review-profile','training-platform-realm','84e76714-8d4f-40b4-b488-dbc0c2797c9a',0,10,_binary '\0',NULL,'5787b67f-15eb-4634-bf88-33d48a3e871f'),('a42678b8-b431-4c11-a9f2-0f9d9c0c168c',NULL,'idp-username-password-form','training-platform-realm','b199a677-6f6f-4565-9b03-e01dffcfc03a',0,10,_binary '\0',NULL,NULL),('a43b7322-b9dc-44f0-b313-dc313094dc68',NULL,'no-cookie-redirect','training-platform-realm','fda6dead-eb6b-4cc4-b676-23fdd16aeb24',0,10,_binary '\0',NULL,NULL),('a590fd96-6e2a-4174-beb7-e72eddde65ad',NULL,'idp-create-user-if-unique','training-platform-realm','6320a3c5-04b2-45fe-968a-2a86cfeaf24b',2,10,_binary '\0',NULL,'5d6aa9a5-2133-414e-91ee-91113325edf3'),('aab552c3-7910-431b-883f-224369b6c6dc',NULL,'client-secret-jwt','master','ca3a0139-2c53-41bd-adb8-984acfc24eef',2,30,_binary '\0',NULL,NULL),('ace07812-6325-416c-b1b1-3865c7947716',NULL,NULL,'training-platform-realm','ef1c7897-a86d-445c-8dd5-0d9c6b14528e',2,20,_binary '','b199a677-6f6f-4565-9b03-e01dffcfc03a',NULL),('adc32be5-77ec-4b82-ad06-b6fed6de0fff',NULL,'idp-email-verification','master','ba659e5a-7ef7-4ef9-a412-1f744f97abc1',2,10,_binary '\0',NULL,NULL),('ae81e5c9-d565-41aa-8545-a99826ca98dd',NULL,'client-x509','master','ca3a0139-2c53-41bd-adb8-984acfc24eef',2,40,_binary '\0',NULL,NULL),('c1f6b902-7a37-4b59-98d4-84d3fe01bf4a',NULL,'conditional-user-configured','master','b63534b6-a99a-4b5f-951f-201f0f6edb95',0,10,_binary '\0',NULL,NULL),('c49104cf-2d71-4e80-b524-3dd0fbf834a7',NULL,'reset-password','training-platform-realm','613e10cc-178d-4192-ac75-cdf5d1d40535',0,30,_binary '\0',NULL,NULL),('c54f0d65-f897-4043-a6ad-c4eb9029b772',NULL,'registration-password-action','master','5aca595e-1ccc-4788-b17b-517e73763c2c',0,50,_binary '\0',NULL,NULL),('c6aef30c-372c-46b6-87b4-d43c6b3cf54a',NULL,'registration-profile-action','master','5aca595e-1ccc-4788-b17b-517e73763c2c',0,40,_binary '\0',NULL,NULL),('d0ef7117-0f02-4e15-a49e-c9a15c15003c',NULL,NULL,'master','3c3c831b-cb2c-44d0-b668-2eb7a69b2aea',1,40,_binary '','a9ebfe0f-81e5-4994-8f22-27bf0a70cfb3',NULL),('d2193872-b297-4ef5-89ac-463991db3b7e',NULL,NULL,'training-platform-realm','b199a677-6f6f-4565-9b03-e01dffcfc03a',1,20,_binary '','ff9afe4b-c4a8-433b-952a-5882cc9e74d8',NULL),('d2b27520-f0c4-4045-976f-e795903bfdd4',NULL,'registration-profile-action','training-platform-realm','fee2aa93-f9f5-4cbb-961e-7072976af80c',0,40,_binary '\0',NULL,NULL),('d2d9c26d-11d7-4014-9432-ab83942522be',NULL,NULL,'master','a381f2c1-840d-4aea-b904-25360854c0a6',0,20,_binary '','ba659e5a-7ef7-4ef9-a412-1f744f97abc1',NULL),('d31d760b-0095-457a-82ed-5240f25a9764',NULL,'idp-username-password-form','master','22006cdc-872e-472e-86f1-334949a8888b',0,10,_binary '\0',NULL,NULL),('d3b376e5-cadf-4707-a834-35672aa9bf60',NULL,'reset-credentials-choose-user','master','3c3c831b-cb2c-44d0-b668-2eb7a69b2aea',0,10,_binary '\0',NULL,NULL),('d8e31537-a237-44f0-bfb1-3240edeb17e4',NULL,'auth-cookie','master','6cef92ba-4928-49c9-8fa9-f960a8e3228f',2,10,_binary '\0',NULL,NULL),('daf35271-8418-4ad0-8e9c-472f01132e40',NULL,'registration-user-creation','training-platform-realm','fee2aa93-f9f5-4cbb-961e-7072976af80c',0,20,_binary '\0',NULL,NULL),('dcb7e8f7-f0aa-41e2-a6e0-bcddd12abc6d',NULL,NULL,'training-platform-realm','7b3a96de-d337-4fbf-a541-eab506529482',1,20,_binary '','1f335176-1b29-4088-a861-1d3bff7dc318',NULL),('dd6ce197-9c65-4dbd-8680-d0b152d20d55',NULL,'client-secret','master','ca3a0139-2c53-41bd-adb8-984acfc24eef',2,10,_binary '\0',NULL,NULL),('de2f9a90-1e87-4df6-a708-a0753f1c8fb1',NULL,NULL,'training-platform-realm','84e76714-8d4f-40b4-b488-dbc0c2797c9a',0,20,_binary '','6320a3c5-04b2-45fe-968a-2a86cfeaf24b',NULL),('df1c0dcc-d017-4b29-a652-72b6777887cf',NULL,'direct-grant-validate-otp','training-platform-realm','85b597e6-2abf-4f9e-8d37-bc2efdfc189e',0,20,_binary '\0',NULL,NULL),('e0fde9c5-3d95-4a12-a159-9fe18b06f238',NULL,'basic-auth','master','c50fffdd-454a-4b7b-bc98-d3f4726abe72',0,10,_binary '\0',NULL,NULL),('e13a84af-584c-4cf0-a65d-d07ca15edf09',NULL,NULL,'training-platform-realm','fda6dead-eb6b-4cc4-b676-23fdd16aeb24',0,20,_binary '','366e44a7-b12a-493f-8213-5d6d8210d474',NULL),('e3ae9b64-da0a-46b8-b576-fb62d7beeec0',NULL,'registration-recaptcha-action','master','5aca595e-1ccc-4788-b17b-517e73763c2c',3,60,_binary '\0',NULL,NULL),('e4aa76df-75c5-4ffd-aa1a-038eb023f2d0',NULL,'identity-provider-redirector','master','6cef92ba-4928-49c9-8fa9-f960a8e3228f',2,25,_binary '\0',NULL,NULL),('e6af05b4-4c16-492d-8d6a-b1d8d11b7c8e',NULL,'client-secret-jwt','training-platform-realm','bd101774-198e-4dc6-9043-7d9c0ba8b68f',2,30,_binary '\0',NULL,NULL),('e7bb1618-9134-4c2c-b2a2-4de7042c1f3b',NULL,'conditional-user-configured','training-platform-realm','486540bf-62c0-464e-905a-2667bf2b0cf4',0,10,_binary '\0',NULL,NULL),('ea0c0eef-3837-48e3-9dc9-05d8d457c788',NULL,'reset-credential-email','training-platform-realm','613e10cc-178d-4192-ac75-cdf5d1d40535',0,20,_binary '\0',NULL,NULL),('ee3f1396-fde8-4dc9-93a3-9e6aa27c8753',NULL,'docker-http-basic-authenticator','training-platform-realm','8272c931-20e2-4d46-807f-70b86f9c8e78',0,10,_binary '\0',NULL,NULL),('f031af30-a333-49a7-b81c-d5912e655991',NULL,'auth-spnego','master','c50fffdd-454a-4b7b-bc98-d3f4726abe72',3,30,_binary '\0',NULL,NULL),('f42f9136-22a1-40e9-881b-0b26aca0ea94',NULL,'conditional-user-configured','training-platform-realm','ff9afe4b-c4a8-433b-952a-5882cc9e74d8',0,10,_binary '\0',NULL,NULL),('f71b1d4a-4259-4758-9eee-3922a29f4bc4',NULL,'direct-grant-validate-username','training-platform-realm','0eec3cc0-5311-44c0-95b8-6421114455d3',0,10,_binary '\0',NULL,NULL),('fa7e018e-7845-40a5-b291-98ae34873908',NULL,'reset-otp','master','a9ebfe0f-81e5-4994-8f22-27bf0a70cfb3',0,20,_binary '\0',NULL,NULL),('fa98c9da-1420-477a-894e-3e6da27e5a57',NULL,NULL,'training-platform-realm','613e10cc-178d-4192-ac75-cdf5d1d40535',1,40,_binary '','486540bf-62c0-464e-905a-2667bf2b0cf4',NULL);
/*!40000 ALTER TABLE `AUTHENTICATION_EXECUTION` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 16:09:18
