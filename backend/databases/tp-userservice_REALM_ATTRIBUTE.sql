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
-- Table structure for table `REALM_ATTRIBUTE`
--

DROP TABLE IF EXISTS `REALM_ATTRIBUTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `REALM_ATTRIBUTE` (
  `NAME` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `REALM_ID` varchar(36) COLLATE utf8mb4_general_ci NOT NULL,
  `VALUE` longtext CHARACTER SET utf8 COLLATE utf8_general_ci,
  PRIMARY KEY (`NAME`,`REALM_ID`),
  KEY `IDX_REALM_ATTR_REALM` (`REALM_ID`),
  CONSTRAINT `FK_8SHXD6L3E9ATQUKACXGPFFPTW` FOREIGN KEY (`REALM_ID`) REFERENCES `REALM` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `REALM_ATTRIBUTE`
--

LOCK TABLES `REALM_ATTRIBUTE` WRITE;
/*!40000 ALTER TABLE `REALM_ATTRIBUTE` DISABLE KEYS */;
INSERT INTO `REALM_ATTRIBUTE` VALUES ('actionTokenGeneratedByAdminLifespan','fdgdg','43200'),('actionTokenGeneratedByAdminLifespan','training-platform-realm','1036800'),('actionTokenGeneratedByUserLifespan','fdgdg','300'),('actionTokenGeneratedByUserLifespan','training-platform-realm','300'),('bruteForceProtected','fdgdg','false'),('bruteForceProtected','master','false'),('bruteForceProtected','training-platform-realm','false'),('cibaAuthRequestedUserHint','fdgdg','login_hint'),('cibaAuthRequestedUserHint','training-platform-realm','login_hint'),('cibaBackchannelTokenDeliveryMode','fdgdg','poll'),('cibaBackchannelTokenDeliveryMode','training-platform-realm','poll'),('cibaExpiresIn','fdgdg','120'),('cibaExpiresIn','training-platform-realm','120'),('cibaInterval','fdgdg','5'),('cibaInterval','training-platform-realm','5'),('client-policies.policies','training-platform-realm','{\"policies\":[]}'),('client-policies.profiles','training-platform-realm','{\"profiles\":[]}'),('clientOfflineSessionIdleTimeout','training-platform-realm','0'),('clientOfflineSessionMaxLifespan','training-platform-realm','0'),('clientSessionIdleTimeout','training-platform-realm','0'),('clientSessionMaxLifespan','training-platform-realm','0'),('defaultSignatureAlgorithm','fdgdg','RS256'),('defaultSignatureAlgorithm','master','RS256'),('defaultSignatureAlgorithm','training-platform-realm','RS256'),('displayName','master','Keycloak'),('displayNameHtml','master','<div class=\"kc-logo-text\"><span>Keycloak</span></div>'),('failureFactor','fdgdg','30'),('failureFactor','master','30'),('failureFactor','training-platform-realm','30'),('maxDeltaTimeSeconds','fdgdg','43200'),('maxDeltaTimeSeconds','master','43200'),('maxDeltaTimeSeconds','training-platform-realm','43200'),('maxFailureWaitSeconds','fdgdg','900'),('maxFailureWaitSeconds','master','900'),('maxFailureWaitSeconds','training-platform-realm','900'),('minimumQuickLoginWaitSeconds','fdgdg','60'),('minimumQuickLoginWaitSeconds','master','60'),('minimumQuickLoginWaitSeconds','training-platform-realm','60'),('oauth2DeviceCodeLifespan','fdgdg','600'),('oauth2DeviceCodeLifespan','training-platform-realm','864000'),('oauth2DevicePollingInterval','fdgdg','5'),('oauth2DevicePollingInterval','training-platform-realm','5'),('offlineSessionMaxLifespan','fdgdg','5184000'),('offlineSessionMaxLifespan','master','5184000'),('offlineSessionMaxLifespan','training-platform-realm','5184000'),('offlineSessionMaxLifespanEnabled','fdgdg','false'),('offlineSessionMaxLifespanEnabled','master','false'),('offlineSessionMaxLifespanEnabled','training-platform-realm','false'),('parRequestUriLifespan','fdgdg','60'),('parRequestUriLifespan','training-platform-realm','60'),('permanentLockout','fdgdg','false'),('permanentLockout','master','false'),('permanentLockout','training-platform-realm','false'),('quickLoginCheckMilliSeconds','fdgdg','1000'),('quickLoginCheckMilliSeconds','master','1000'),('quickLoginCheckMilliSeconds','training-platform-realm','1000'),('userProfileEnabled','training-platform-realm','false'),('waitIncrementSeconds','fdgdg','60'),('waitIncrementSeconds','master','60'),('waitIncrementSeconds','training-platform-realm','60'),('webAuthnPolicyAttestationConveyancePreference','fdgdg','not specified'),('webAuthnPolicyAttestationConveyancePreference','training-platform-realm','not specified'),('webAuthnPolicyAttestationConveyancePreferencePasswordless','fdgdg','not specified'),('webAuthnPolicyAttestationConveyancePreferencePasswordless','training-platform-realm','not specified'),('webAuthnPolicyAuthenticatorAttachment','fdgdg','not specified'),('webAuthnPolicyAuthenticatorAttachment','training-platform-realm','not specified'),('webAuthnPolicyAuthenticatorAttachmentPasswordless','fdgdg','not specified'),('webAuthnPolicyAuthenticatorAttachmentPasswordless','training-platform-realm','not specified'),('webAuthnPolicyAvoidSameAuthenticatorRegister','fdgdg','false'),('webAuthnPolicyAvoidSameAuthenticatorRegister','training-platform-realm','false'),('webAuthnPolicyAvoidSameAuthenticatorRegisterPasswordless','fdgdg','false'),('webAuthnPolicyAvoidSameAuthenticatorRegisterPasswordless','training-platform-realm','false'),('webAuthnPolicyCreateTimeout','fdgdg','0'),('webAuthnPolicyCreateTimeout','training-platform-realm','0'),('webAuthnPolicyCreateTimeoutPasswordless','fdgdg','0'),('webAuthnPolicyCreateTimeoutPasswordless','training-platform-realm','0'),('webAuthnPolicyRequireResidentKey','fdgdg','not specified'),('webAuthnPolicyRequireResidentKey','training-platform-realm','not specified'),('webAuthnPolicyRequireResidentKeyPasswordless','fdgdg','not specified'),('webAuthnPolicyRequireResidentKeyPasswordless','training-platform-realm','not specified'),('webAuthnPolicyRpEntityName','fdgdg','keycloak'),('webAuthnPolicyRpEntityName','training-platform-realm','keycloak'),('webAuthnPolicyRpEntityNamePasswordless','fdgdg','keycloak'),('webAuthnPolicyRpEntityNamePasswordless','training-platform-realm','keycloak'),('webAuthnPolicyRpId','fdgdg',''),('webAuthnPolicyRpId','training-platform-realm',''),('webAuthnPolicyRpIdPasswordless','fdgdg',''),('webAuthnPolicyRpIdPasswordless','training-platform-realm',''),('webAuthnPolicySignatureAlgorithms','fdgdg','ES256'),('webAuthnPolicySignatureAlgorithms','training-platform-realm','ES256'),('webAuthnPolicySignatureAlgorithmsPasswordless','fdgdg','ES256'),('webAuthnPolicySignatureAlgorithmsPasswordless','training-platform-realm','ES256'),('webAuthnPolicyUserVerificationRequirement','fdgdg','not specified'),('webAuthnPolicyUserVerificationRequirement','training-platform-realm','not specified'),('webAuthnPolicyUserVerificationRequirementPasswordless','fdgdg','not specified'),('webAuthnPolicyUserVerificationRequirementPasswordless','training-platform-realm','not specified'),('_browser_header.contentSecurityPolicy','fdgdg','frame-src \'self\'; frame-ancestors \'self\'; object-src \'none\';'),('_browser_header.contentSecurityPolicy','master','frame-src \'self\'; frame-ancestors \'self\'; object-src \'none\';'),('_browser_header.contentSecurityPolicy','training-platform-realm','frame-src \'self\'; frame-ancestors \'self\'; object-src \'none\';'),('_browser_header.contentSecurityPolicyReportOnly','fdgdg',''),('_browser_header.contentSecurityPolicyReportOnly','master',''),('_browser_header.contentSecurityPolicyReportOnly','training-platform-realm',''),('_browser_header.strictTransportSecurity','fdgdg','max-age=31536000; includeSubDomains'),('_browser_header.strictTransportSecurity','master','max-age=31536000; includeSubDomains'),('_browser_header.strictTransportSecurity','training-platform-realm','max-age=31536000; includeSubDomains'),('_browser_header.xContentTypeOptions','fdgdg','nosniff'),('_browser_header.xContentTypeOptions','master','nosniff'),('_browser_header.xContentTypeOptions','training-platform-realm','nosniff'),('_browser_header.xFrameOptions','fdgdg','SAMEORIGIN'),('_browser_header.xFrameOptions','master','SAMEORIGIN'),('_browser_header.xFrameOptions','training-platform-realm','SAMEORIGIN'),('_browser_header.xRobotsTag','fdgdg','none'),('_browser_header.xRobotsTag','master','none'),('_browser_header.xRobotsTag','training-platform-realm','none'),('_browser_header.xXSSProtection','fdgdg','1; mode=block'),('_browser_header.xXSSProtection','master','1; mode=block'),('_browser_header.xXSSProtection','training-platform-realm','1; mode=block');
/*!40000 ALTER TABLE `REALM_ATTRIBUTE` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-10 22:30:58
