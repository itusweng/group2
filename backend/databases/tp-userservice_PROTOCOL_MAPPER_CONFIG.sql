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
-- Table structure for table `PROTOCOL_MAPPER_CONFIG`
--

DROP TABLE IF EXISTS `PROTOCOL_MAPPER_CONFIG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PROTOCOL_MAPPER_CONFIG` (
  `PROTOCOL_MAPPER_ID` varchar(36) NOT NULL,
  `VALUE` longtext,
  `NAME` varchar(255) NOT NULL,
  PRIMARY KEY (`PROTOCOL_MAPPER_ID`,`NAME`),
  CONSTRAINT `FK_PMCONFIG` FOREIGN KEY (`PROTOCOL_MAPPER_ID`) REFERENCES `PROTOCOL_MAPPER` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROTOCOL_MAPPER_CONFIG`
--

LOCK TABLES `PROTOCOL_MAPPER_CONFIG` WRITE;
/*!40000 ALTER TABLE `PROTOCOL_MAPPER_CONFIG` DISABLE KEYS */;
INSERT INTO `PROTOCOL_MAPPER_CONFIG` VALUES ('0120fed1-50dc-4e02-8d4f-111e0a1fe270','true','access.token.claim'),('0120fed1-50dc-4e02-8d4f-111e0a1fe270','gender','claim.name'),('0120fed1-50dc-4e02-8d4f-111e0a1fe270','true','id.token.claim'),('0120fed1-50dc-4e02-8d4f-111e0a1fe270','String','jsonType.label'),('0120fed1-50dc-4e02-8d4f-111e0a1fe270','gender','user.attribute'),('0120fed1-50dc-4e02-8d4f-111e0a1fe270','true','userinfo.token.claim'),('04a8f1b2-d754-40ab-bf09-37e0bf169279','true','access.token.claim'),('04a8f1b2-d754-40ab-bf09-37e0bf169279','given_name','claim.name'),('04a8f1b2-d754-40ab-bf09-37e0bf169279','true','id.token.claim'),('04a8f1b2-d754-40ab-bf09-37e0bf169279','String','jsonType.label'),('04a8f1b2-d754-40ab-bf09-37e0bf169279','firstName','user.attribute'),('04a8f1b2-d754-40ab-bf09-37e0bf169279','true','userinfo.token.claim'),('06c2cc5a-faf3-4b96-ac74-ec952c647cf9','true','access.token.claim'),('06c2cc5a-faf3-4b96-ac74-ec952c647cf9','middle_name','claim.name'),('06c2cc5a-faf3-4b96-ac74-ec952c647cf9','true','id.token.claim'),('06c2cc5a-faf3-4b96-ac74-ec952c647cf9','String','jsonType.label'),('06c2cc5a-faf3-4b96-ac74-ec952c647cf9','middleName','user.attribute'),('06c2cc5a-faf3-4b96-ac74-ec952c647cf9','true','userinfo.token.claim'),('06f7fd7c-bdcb-4efb-96f6-099d34904f68','true','access.token.claim'),('06f7fd7c-bdcb-4efb-96f6-099d34904f68','clientId','claim.name'),('06f7fd7c-bdcb-4efb-96f6-099d34904f68','true','id.token.claim'),('06f7fd7c-bdcb-4efb-96f6-099d34904f68','String','jsonType.label'),('06f7fd7c-bdcb-4efb-96f6-099d34904f68','clientId','user.session.note'),('0acb5d87-aca5-4cd4-987a-58cb70a837c7','Role','attribute.name'),('0acb5d87-aca5-4cd4-987a-58cb70a837c7','Basic','attribute.nameformat'),('0acb5d87-aca5-4cd4-987a-58cb70a837c7','false','single'),('0acd660d-dcfa-422c-903d-6b061c925da9','true','access.token.claim'),('0acd660d-dcfa-422c-903d-6b061c925da9','locale','claim.name'),('0acd660d-dcfa-422c-903d-6b061c925da9','true','id.token.claim'),('0acd660d-dcfa-422c-903d-6b061c925da9','String','jsonType.label'),('0acd660d-dcfa-422c-903d-6b061c925da9','locale','user.attribute'),('0acd660d-dcfa-422c-903d-6b061c925da9','true','userinfo.token.claim'),('0d111e0b-4f61-4382-a50d-91e87f44c281','true','access.token.claim'),('0d111e0b-4f61-4382-a50d-91e87f44c281','locale','claim.name'),('0d111e0b-4f61-4382-a50d-91e87f44c281','true','id.token.claim'),('0d111e0b-4f61-4382-a50d-91e87f44c281','String','jsonType.label'),('0d111e0b-4f61-4382-a50d-91e87f44c281','locale','user.attribute'),('0d111e0b-4f61-4382-a50d-91e87f44c281','true','userinfo.token.claim'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','true','access.token.claim'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','true','id.token.claim'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','country','user.attribute.country'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','formatted','user.attribute.formatted'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','locality','user.attribute.locality'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','postal_code','user.attribute.postal_code'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','region','user.attribute.region'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','street','user.attribute.street'),('0e7c26c1-6c4d-4454-a254-59a00860f0db','true','userinfo.token.claim'),('0eeab5b8-901c-4309-bbfa-9bde36be600e','true','access.token.claim'),('0eeab5b8-901c-4309-bbfa-9bde36be600e','resource_access.${client_id}.roles','claim.name'),('0eeab5b8-901c-4309-bbfa-9bde36be600e','String','jsonType.label'),('0eeab5b8-901c-4309-bbfa-9bde36be600e','true','multivalued'),('0eeab5b8-901c-4309-bbfa-9bde36be600e','foo','user.attribute'),('1f106f86-9e73-445f-91c3-7d577de4c0ff','true','access.token.claim'),('1f106f86-9e73-445f-91c3-7d577de4c0ff','realm_access.roles','claim.name'),('1f106f86-9e73-445f-91c3-7d577de4c0ff','String','jsonType.label'),('1f106f86-9e73-445f-91c3-7d577de4c0ff','true','multivalued'),('1f106f86-9e73-445f-91c3-7d577de4c0ff','foo','user.attribute'),('27525049-aeab-4c87-a344-0e2c2f58c60d','true','access.token.claim'),('27525049-aeab-4c87-a344-0e2c2f58c60d','profile','claim.name'),('27525049-aeab-4c87-a344-0e2c2f58c60d','true','id.token.claim'),('27525049-aeab-4c87-a344-0e2c2f58c60d','String','jsonType.label'),('27525049-aeab-4c87-a344-0e2c2f58c60d','profile','user.attribute'),('27525049-aeab-4c87-a344-0e2c2f58c60d','true','userinfo.token.claim'),('2c905c49-cd2e-47df-b4d6-cd4d1b682850','true','access.token.claim'),('2c905c49-cd2e-47df-b4d6-cd4d1b682850','gender','claim.name'),('2c905c49-cd2e-47df-b4d6-cd4d1b682850','true','id.token.claim'),('2c905c49-cd2e-47df-b4d6-cd4d1b682850','String','jsonType.label'),('2c905c49-cd2e-47df-b4d6-cd4d1b682850','gender','user.attribute'),('2c905c49-cd2e-47df-b4d6-cd4d1b682850','true','userinfo.token.claim'),('40c915f4-a3ef-44b7-9fe7-0d70b21753a9','true','access.token.claim'),('40c915f4-a3ef-44b7-9fe7-0d70b21753a9','picture','claim.name'),('40c915f4-a3ef-44b7-9fe7-0d70b21753a9','true','id.token.claim'),('40c915f4-a3ef-44b7-9fe7-0d70b21753a9','String','jsonType.label'),('40c915f4-a3ef-44b7-9fe7-0d70b21753a9','picture','user.attribute'),('40c915f4-a3ef-44b7-9fe7-0d70b21753a9','true','userinfo.token.claim'),('42abc9ce-074e-4f59-9d3f-a1579fae9dc6','true','access.token.claim'),('42abc9ce-074e-4f59-9d3f-a1579fae9dc6','picture','claim.name'),('42abc9ce-074e-4f59-9d3f-a1579fae9dc6','true','id.token.claim'),('42abc9ce-074e-4f59-9d3f-a1579fae9dc6','String','jsonType.label'),('42abc9ce-074e-4f59-9d3f-a1579fae9dc6','picture','user.attribute'),('42abc9ce-074e-4f59-9d3f-a1579fae9dc6','true','userinfo.token.claim'),('4fe01b8e-c4dd-4d7c-914f-acc821d7bb7a','true','access.token.claim'),('4fe01b8e-c4dd-4d7c-914f-acc821d7bb7a','zoneinfo','claim.name'),('4fe01b8e-c4dd-4d7c-914f-acc821d7bb7a','true','id.token.claim'),('4fe01b8e-c4dd-4d7c-914f-acc821d7bb7a','String','jsonType.label'),('4fe01b8e-c4dd-4d7c-914f-acc821d7bb7a','zoneinfo','user.attribute'),('4fe01b8e-c4dd-4d7c-914f-acc821d7bb7a','true','userinfo.token.claim'),('51312848-a57e-4c60-a3c4-8bfd58370a76','Role','attribute.name'),('51312848-a57e-4c60-a3c4-8bfd58370a76','Basic','attribute.nameformat'),('51312848-a57e-4c60-a3c4-8bfd58370a76','false','single'),('51a0f714-06f7-4cce-ac9e-588b60c45ffd','true','access.token.claim'),('51a0f714-06f7-4cce-ac9e-588b60c45ffd','phone_number','claim.name'),('51a0f714-06f7-4cce-ac9e-588b60c45ffd','true','id.token.claim'),('51a0f714-06f7-4cce-ac9e-588b60c45ffd','String','jsonType.label'),('51a0f714-06f7-4cce-ac9e-588b60c45ffd','phoneNumber','user.attribute'),('51a0f714-06f7-4cce-ac9e-588b60c45ffd','true','userinfo.token.claim'),('5226793e-c9ea-426f-8f21-ab13c44b9d61','true','access.token.claim'),('5226793e-c9ea-426f-8f21-ab13c44b9d61','birthdate','claim.name'),('5226793e-c9ea-426f-8f21-ab13c44b9d61','true','id.token.claim'),('5226793e-c9ea-426f-8f21-ab13c44b9d61','String','jsonType.label'),('5226793e-c9ea-426f-8f21-ab13c44b9d61','birthdate','user.attribute'),('5226793e-c9ea-426f-8f21-ab13c44b9d61','true','userinfo.token.claim'),('584ab1c6-3e54-452f-b0e9-6024f487c4f7','true','access.token.claim'),('584ab1c6-3e54-452f-b0e9-6024f487c4f7','phone_number_verified','claim.name'),('584ab1c6-3e54-452f-b0e9-6024f487c4f7','true','id.token.claim'),('584ab1c6-3e54-452f-b0e9-6024f487c4f7','boolean','jsonType.label'),('584ab1c6-3e54-452f-b0e9-6024f487c4f7','phoneNumberVerified','user.attribute'),('584ab1c6-3e54-452f-b0e9-6024f487c4f7','true','userinfo.token.claim'),('58bd7272-5ab9-4adf-ae74-b72320254e01','true','access.token.claim'),('58bd7272-5ab9-4adf-ae74-b72320254e01','groups','claim.name'),('58bd7272-5ab9-4adf-ae74-b72320254e01','true','id.token.claim'),('58bd7272-5ab9-4adf-ae74-b72320254e01','String','jsonType.label'),('58bd7272-5ab9-4adf-ae74-b72320254e01','true','multivalued'),('58bd7272-5ab9-4adf-ae74-b72320254e01','foo','user.attribute'),('5a8b60ba-02c1-4422-9e16-295123858582','true','access.token.claim'),('5a8b60ba-02c1-4422-9e16-295123858582','phone_number_verified','claim.name'),('5a8b60ba-02c1-4422-9e16-295123858582','true','id.token.claim'),('5a8b60ba-02c1-4422-9e16-295123858582','boolean','jsonType.label'),('5a8b60ba-02c1-4422-9e16-295123858582','phoneNumberVerified','user.attribute'),('5a8b60ba-02c1-4422-9e16-295123858582','true','userinfo.token.claim'),('648dd66b-87aa-4bc4-b29a-41f05c953b8e','true','access.token.claim'),('648dd66b-87aa-4bc4-b29a-41f05c953b8e','realm_access.roles','claim.name'),('648dd66b-87aa-4bc4-b29a-41f05c953b8e','false','id.token.claim'),('648dd66b-87aa-4bc4-b29a-41f05c953b8e','true','multivalued'),('648dd66b-87aa-4bc4-b29a-41f05c953b8e','true','userinfo.token.claim'),('6630d375-07cb-4c6f-9834-83808a733a83','true','access.token.claim'),('6630d375-07cb-4c6f-9834-83808a733a83','email_verified','claim.name'),('6630d375-07cb-4c6f-9834-83808a733a83','true','id.token.claim'),('6630d375-07cb-4c6f-9834-83808a733a83','boolean','jsonType.label'),('6630d375-07cb-4c6f-9834-83808a733a83','emailVerified','user.attribute'),('6630d375-07cb-4c6f-9834-83808a733a83','true','userinfo.token.claim'),('705870bb-5736-410f-9769-f20d4940ec29','true','access.token.claim'),('705870bb-5736-410f-9769-f20d4940ec29','clientAddress','claim.name'),('705870bb-5736-410f-9769-f20d4940ec29','true','id.token.claim'),('705870bb-5736-410f-9769-f20d4940ec29','String','jsonType.label'),('705870bb-5736-410f-9769-f20d4940ec29','clientAddress','user.session.note'),('710fda5b-6f3d-44cf-a103-9dca200092a5','true','id.token.claim'),('710fda5b-6f3d-44cf-a103-9dca200092a5','true','userinfo.token.claim'),('77dd42ac-070c-4a5e-8a2e-078126b4e081','true','access.token.claim'),('77dd42ac-070c-4a5e-8a2e-078126b4e081','updated_at','claim.name'),('77dd42ac-070c-4a5e-8a2e-078126b4e081','true','id.token.claim'),('77dd42ac-070c-4a5e-8a2e-078126b4e081','String','jsonType.label'),('77dd42ac-070c-4a5e-8a2e-078126b4e081','updatedAt','user.attribute'),('77dd42ac-070c-4a5e-8a2e-078126b4e081','true','userinfo.token.claim'),('838d9bcb-354d-4cd6-b1da-3c43b86b7d70','true','access.token.claim'),('838d9bcb-354d-4cd6-b1da-3c43b86b7d70','upn','claim.name'),('838d9bcb-354d-4cd6-b1da-3c43b86b7d70','true','id.token.claim'),('838d9bcb-354d-4cd6-b1da-3c43b86b7d70','String','jsonType.label'),('838d9bcb-354d-4cd6-b1da-3c43b86b7d70','username','user.attribute'),('838d9bcb-354d-4cd6-b1da-3c43b86b7d70','true','userinfo.token.claim'),('8d5af76c-4e8d-4f82-bd82-fbcebd08f5f1','true','access.token.claim'),('8d5af76c-4e8d-4f82-bd82-fbcebd08f5f1','email','claim.name'),('8d5af76c-4e8d-4f82-bd82-fbcebd08f5f1','true','id.token.claim'),('8d5af76c-4e8d-4f82-bd82-fbcebd08f5f1','String','jsonType.label'),('8d5af76c-4e8d-4f82-bd82-fbcebd08f5f1','email','user.attribute'),('8d5af76c-4e8d-4f82-bd82-fbcebd08f5f1','true','userinfo.token.claim'),('915194a5-8cae-46af-928b-a4d560192c54','true','access.token.claim'),('915194a5-8cae-46af-928b-a4d560192c54','updated_at','claim.name'),('915194a5-8cae-46af-928b-a4d560192c54','true','id.token.claim'),('915194a5-8cae-46af-928b-a4d560192c54','String','jsonType.label'),('915194a5-8cae-46af-928b-a4d560192c54','updatedAt','user.attribute'),('915194a5-8cae-46af-928b-a4d560192c54','true','userinfo.token.claim'),('960edbbe-ba82-41c4-9735-e65f57d4c20b','true','access.token.claim'),('960edbbe-ba82-41c4-9735-e65f57d4c20b','true','id.token.claim'),('960edbbe-ba82-41c4-9735-e65f57d4c20b','true','userinfo.token.claim'),('96ff335d-1c11-42e8-b4b1-dafdeb671644','true','access.token.claim'),('96ff335d-1c11-42e8-b4b1-dafdeb671644','website','claim.name'),('96ff335d-1c11-42e8-b4b1-dafdeb671644','true','id.token.claim'),('96ff335d-1c11-42e8-b4b1-dafdeb671644','String','jsonType.label'),('96ff335d-1c11-42e8-b4b1-dafdeb671644','website','user.attribute'),('96ff335d-1c11-42e8-b4b1-dafdeb671644','true','userinfo.token.claim'),('973aefa2-18a8-43e5-9446-2c01f3ba55af','true','access.token.claim'),('973aefa2-18a8-43e5-9446-2c01f3ba55af','middle_name','claim.name'),('973aefa2-18a8-43e5-9446-2c01f3ba55af','true','id.token.claim'),('973aefa2-18a8-43e5-9446-2c01f3ba55af','String','jsonType.label'),('973aefa2-18a8-43e5-9446-2c01f3ba55af','middleName','user.attribute'),('973aefa2-18a8-43e5-9446-2c01f3ba55af','true','userinfo.token.claim'),('9991b381-70c2-440c-a683-7266bb7f0102','true','access.token.claim'),('9991b381-70c2-440c-a683-7266bb7f0102','nickname','claim.name'),('9991b381-70c2-440c-a683-7266bb7f0102','true','id.token.claim'),('9991b381-70c2-440c-a683-7266bb7f0102','String','jsonType.label'),('9991b381-70c2-440c-a683-7266bb7f0102','nickname','user.attribute'),('9991b381-70c2-440c-a683-7266bb7f0102','true','userinfo.token.claim'),('9c6ba74a-7cde-4904-982b-7c25d128853c','true','access.token.claim'),('9c6ba74a-7cde-4904-982b-7c25d128853c','profile','claim.name'),('9c6ba74a-7cde-4904-982b-7c25d128853c','true','id.token.claim'),('9c6ba74a-7cde-4904-982b-7c25d128853c','String','jsonType.label'),('9c6ba74a-7cde-4904-982b-7c25d128853c','profile','user.attribute'),('9c6ba74a-7cde-4904-982b-7c25d128853c','true','userinfo.token.claim'),('9ea578b3-bef0-4f72-929c-d7a175af6a60','true','access.token.claim'),('9ea578b3-bef0-4f72-929c-d7a175af6a60','email_verified','claim.name'),('9ea578b3-bef0-4f72-929c-d7a175af6a60','true','id.token.claim'),('9ea578b3-bef0-4f72-929c-d7a175af6a60','boolean','jsonType.label'),('9ea578b3-bef0-4f72-929c-d7a175af6a60','emailVerified','user.attribute'),('9ea578b3-bef0-4f72-929c-d7a175af6a60','true','userinfo.token.claim'),('9ec04221-1792-4827-a623-0c07955e3656','true','access.token.claim'),('9ec04221-1792-4827-a623-0c07955e3656','true','id.token.claim'),('9ec04221-1792-4827-a623-0c07955e3656','true','userinfo.token.claim'),('9f765186-a4f1-49b4-8a89-0b883bba16d4','true','access.token.claim'),('9f765186-a4f1-49b4-8a89-0b883bba16d4','given_name','claim.name'),('9f765186-a4f1-49b4-8a89-0b883bba16d4','true','id.token.claim'),('9f765186-a4f1-49b4-8a89-0b883bba16d4','String','jsonType.label'),('9f765186-a4f1-49b4-8a89-0b883bba16d4','firstName','user.attribute'),('9f765186-a4f1-49b4-8a89-0b883bba16d4','true','userinfo.token.claim'),('a11aa5e0-42fd-4ab3-ab5e-5c107bde5c38','true','access.token.claim'),('a11aa5e0-42fd-4ab3-ab5e-5c107bde5c38','family_name','claim.name'),('a11aa5e0-42fd-4ab3-ab5e-5c107bde5c38','true','id.token.claim'),('a11aa5e0-42fd-4ab3-ab5e-5c107bde5c38','String','jsonType.label'),('a11aa5e0-42fd-4ab3-ab5e-5c107bde5c38','lastName','user.attribute'),('a11aa5e0-42fd-4ab3-ab5e-5c107bde5c38','true','userinfo.token.claim'),('a66eac13-1ff3-46a3-b2fd-3240566c01b9','true','access.token.claim'),('a66eac13-1ff3-46a3-b2fd-3240566c01b9','groups','claim.name'),('a66eac13-1ff3-46a3-b2fd-3240566c01b9','true','id.token.claim'),('a66eac13-1ff3-46a3-b2fd-3240566c01b9','String','jsonType.label'),('a66eac13-1ff3-46a3-b2fd-3240566c01b9','true','multivalued'),('a66eac13-1ff3-46a3-b2fd-3240566c01b9','foo','user.attribute'),('b0440ee0-056e-4413-8f96-e1445896262f','true','access.token.claim'),('b0440ee0-056e-4413-8f96-e1445896262f','locale','claim.name'),('b0440ee0-056e-4413-8f96-e1445896262f','true','id.token.claim'),('b0440ee0-056e-4413-8f96-e1445896262f','String','jsonType.label'),('b0440ee0-056e-4413-8f96-e1445896262f','locale','user.attribute'),('b0440ee0-056e-4413-8f96-e1445896262f','true','userinfo.token.claim'),('b6ebfad3-fe1c-4005-ab2a-15e220b84863','true','access.token.claim'),('b6ebfad3-fe1c-4005-ab2a-15e220b84863','upn','claim.name'),('b6ebfad3-fe1c-4005-ab2a-15e220b84863','true','id.token.claim'),('b6ebfad3-fe1c-4005-ab2a-15e220b84863','String','jsonType.label'),('b6ebfad3-fe1c-4005-ab2a-15e220b84863','username','user.attribute'),('b6ebfad3-fe1c-4005-ab2a-15e220b84863','true','userinfo.token.claim'),('bd7c7fa4-919c-4de1-bca1-d42d1376db62','true','access.token.claim'),('bd7c7fa4-919c-4de1-bca1-d42d1376db62','phone_number','claim.name'),('bd7c7fa4-919c-4de1-bca1-d42d1376db62','true','id.token.claim'),('bd7c7fa4-919c-4de1-bca1-d42d1376db62','String','jsonType.label'),('bd7c7fa4-919c-4de1-bca1-d42d1376db62','phoneNumber','user.attribute'),('bd7c7fa4-919c-4de1-bca1-d42d1376db62','true','userinfo.token.claim'),('c468bd33-89c2-44d5-8d4b-d21f64fbedc8','true','access.token.claim'),('c468bd33-89c2-44d5-8d4b-d21f64fbedc8','preferred_username','claim.name'),('c468bd33-89c2-44d5-8d4b-d21f64fbedc8','true','id.token.claim'),('c468bd33-89c2-44d5-8d4b-d21f64fbedc8','String','jsonType.label'),('c468bd33-89c2-44d5-8d4b-d21f64fbedc8','username','user.attribute'),('c468bd33-89c2-44d5-8d4b-d21f64fbedc8','true','userinfo.token.claim'),('cb64a85f-b808-4ce4-abf3-cb70367706c1','true','access.token.claim'),('cb64a85f-b808-4ce4-abf3-cb70367706c1','website','claim.name'),('cb64a85f-b808-4ce4-abf3-cb70367706c1','true','id.token.claim'),('cb64a85f-b808-4ce4-abf3-cb70367706c1','String','jsonType.label'),('cb64a85f-b808-4ce4-abf3-cb70367706c1','website','user.attribute'),('cb64a85f-b808-4ce4-abf3-cb70367706c1','true','userinfo.token.claim'),('d1f511d0-854f-43aa-a59d-dba46ce1fa78','true','access.token.claim'),('d1f511d0-854f-43aa-a59d-dba46ce1fa78','nickname','claim.name'),('d1f511d0-854f-43aa-a59d-dba46ce1fa78','true','id.token.claim'),('d1f511d0-854f-43aa-a59d-dba46ce1fa78','String','jsonType.label'),('d1f511d0-854f-43aa-a59d-dba46ce1fa78','nickname','user.attribute'),('d1f511d0-854f-43aa-a59d-dba46ce1fa78','true','userinfo.token.claim'),('d245cd6f-bd93-4097-bfc2-78b2b229addb','true','access.token.claim'),('d245cd6f-bd93-4097-bfc2-78b2b229addb','locale','claim.name'),('d245cd6f-bd93-4097-bfc2-78b2b229addb','true','id.token.claim'),('d245cd6f-bd93-4097-bfc2-78b2b229addb','String','jsonType.label'),('d245cd6f-bd93-4097-bfc2-78b2b229addb','locale','user.attribute'),('d245cd6f-bd93-4097-bfc2-78b2b229addb','true','userinfo.token.claim'),('d4122e0e-11a7-4db4-aabd-42d982266619','true','access.token.claim'),('d4122e0e-11a7-4db4-aabd-42d982266619','true','id.token.claim'),('d4122e0e-11a7-4db4-aabd-42d982266619','country','user.attribute.country'),('d4122e0e-11a7-4db4-aabd-42d982266619','formatted','user.attribute.formatted'),('d4122e0e-11a7-4db4-aabd-42d982266619','locality','user.attribute.locality'),('d4122e0e-11a7-4db4-aabd-42d982266619','postal_code','user.attribute.postal_code'),('d4122e0e-11a7-4db4-aabd-42d982266619','region','user.attribute.region'),('d4122e0e-11a7-4db4-aabd-42d982266619','street','user.attribute.street'),('d4122e0e-11a7-4db4-aabd-42d982266619','true','userinfo.token.claim'),('d480c020-8fdb-43be-ba93-8e9136430806','true','access.token.claim'),('d480c020-8fdb-43be-ba93-8e9136430806','email','claim.name'),('d480c020-8fdb-43be-ba93-8e9136430806','true','id.token.claim'),('d480c020-8fdb-43be-ba93-8e9136430806','String','jsonType.label'),('d480c020-8fdb-43be-ba93-8e9136430806','email','user.attribute'),('d480c020-8fdb-43be-ba93-8e9136430806','true','userinfo.token.claim'),('dd2857c2-4145-41e3-b272-7c5ea2d96584','true','access.token.claim'),('dd2857c2-4145-41e3-b272-7c5ea2d96584','family_name','claim.name'),('dd2857c2-4145-41e3-b272-7c5ea2d96584','true','id.token.claim'),('dd2857c2-4145-41e3-b272-7c5ea2d96584','String','jsonType.label'),('dd2857c2-4145-41e3-b272-7c5ea2d96584','lastName','user.attribute'),('dd2857c2-4145-41e3-b272-7c5ea2d96584','true','userinfo.token.claim'),('e64e63dc-4926-49eb-a765-a7ee5d16f00a','true','access.token.claim'),('e64e63dc-4926-49eb-a765-a7ee5d16f00a','zoneinfo','claim.name'),('e64e63dc-4926-49eb-a765-a7ee5d16f00a','true','id.token.claim'),('e64e63dc-4926-49eb-a765-a7ee5d16f00a','String','jsonType.label'),('e64e63dc-4926-49eb-a765-a7ee5d16f00a','zoneinfo','user.attribute'),('e64e63dc-4926-49eb-a765-a7ee5d16f00a','true','userinfo.token.claim'),('ecdf9e7e-aaa0-49c1-8020-e6ba9bcd21dd','true','access.token.claim'),('ecdf9e7e-aaa0-49c1-8020-e6ba9bcd21dd','birthdate','claim.name'),('ecdf9e7e-aaa0-49c1-8020-e6ba9bcd21dd','true','id.token.claim'),('ecdf9e7e-aaa0-49c1-8020-e6ba9bcd21dd','String','jsonType.label'),('ecdf9e7e-aaa0-49c1-8020-e6ba9bcd21dd','birthdate','user.attribute'),('ecdf9e7e-aaa0-49c1-8020-e6ba9bcd21dd','true','userinfo.token.claim'),('fd44a216-2c49-4436-a90b-cd6369306b1a','true','access.token.claim'),('fd44a216-2c49-4436-a90b-cd6369306b1a','preferred_username','claim.name'),('fd44a216-2c49-4436-a90b-cd6369306b1a','true','id.token.claim'),('fd44a216-2c49-4436-a90b-cd6369306b1a','String','jsonType.label'),('fd44a216-2c49-4436-a90b-cd6369306b1a','username','user.attribute'),('fd44a216-2c49-4436-a90b-cd6369306b1a','true','userinfo.token.claim'),('ff4b3ab7-c70c-4e63-99a8-d6281736fd1c','true','access.token.claim'),('ff4b3ab7-c70c-4e63-99a8-d6281736fd1c','clientHost','claim.name'),('ff4b3ab7-c70c-4e63-99a8-d6281736fd1c','true','id.token.claim'),('ff4b3ab7-c70c-4e63-99a8-d6281736fd1c','String','jsonType.label'),('ff4b3ab7-c70c-4e63-99a8-d6281736fd1c','clientHost','user.session.note');
/*!40000 ALTER TABLE `PROTOCOL_MAPPER_CONFIG` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-03 22:21:42
