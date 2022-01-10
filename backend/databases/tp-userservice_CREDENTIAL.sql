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
-- Table structure for table `CREDENTIAL`
--

DROP TABLE IF EXISTS `CREDENTIAL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CREDENTIAL` (
  `ID` varchar(36) COLLATE utf8mb4_general_ci NOT NULL,
  `SALT` tinyblob,
  `TYPE` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `USER_ID` varchar(36) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CREATED_DATE` bigint DEFAULT NULL,
  `USER_LABEL` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `SECRET_DATA` longtext COLLATE utf8mb4_general_ci,
  `CREDENTIAL_DATA` longtext COLLATE utf8mb4_general_ci,
  `PRIORITY` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_USER_CREDENTIAL` (`USER_ID`),
  CONSTRAINT `FK_PFYR0GLASQYL0DEI3KL69R6V0` FOREIGN KEY (`USER_ID`) REFERENCES `USER_ENTITY` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CREDENTIAL`
--

LOCK TABLES `CREDENTIAL` WRITE;
/*!40000 ALTER TABLE `CREDENTIAL` DISABLE KEYS */;
INSERT INTO `CREDENTIAL` VALUES ('0c8f0a05-8137-4e2d-973a-e5a0bbfdcfe6',NULL,'password','4638fe72-9592-4b94-8a73-463b507db582',1641841765983,NULL,'{\"value\":\"xv0zef8Stkh+HHa84IE/MC9Ey9t7G7G0TInBoygBzqT7cOnvvKDYyKvZROcR3PSxg7s/ZX/kzZ8XhYv2tLtYfQ==\",\"salt\":\"dt+Cq6/O/BO7HoInVyuweQ==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('10d2e72b-746b-4052-a815-648c5bcf23c4',NULL,'password','a6e98e48-a6ae-4ca0-a08e-9dde7d503c5f',1641841457043,NULL,'{\"value\":\"RnkkLyVer/cRMkL3PYh097fl5SUuFNtkc5J5rD+7W6tQTLy7fpCx8xLhmEYPUJ8rg85wOmtAdJKOIMlvP8YtfQ==\",\"salt\":\"Bkwo7yLymMK05ejPWv3DHQ==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('1f6faf3e-4362-4fd0-a8f7-66802d9dadeb',NULL,'password','6474fc5b-23ae-48e9-8e73-d720c17ca8a5',1641842500541,NULL,'{\"value\":\"hw2FnF+EufAmKPY4NMEPvP4Nq1aX+Z3bp7VUstWqLbxFTDtRGgb82mPrb5vMqEwMy0trsb3ATrH39QsjhplfCw==\",\"salt\":\"RtiZHZ+hyrmVofOm9erDvw==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('229672eb-9f9b-445e-8035-2f4488d6c0b4',NULL,'password','6cc5f868-c060-4591-93e6-dd347b05999d',1638678318776,NULL,'{\"value\":\"u0J0HwRhAwSsgJHt8/TzJJrhZrE7kIsHmrgRQdI+k86piR8nYK54Rnc3dvWSqDiNeCuRM6Yc7lJO1073BYL5yQ==\",\"salt\":\"g3TI4tvXQVkP4g0KklP/kg==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('351890b6-7f0a-4f31-be01-e749643bc609',NULL,'password','9701409e-042e-49de-a8d5-d046e7ad790d',1641841799556,NULL,'{\"value\":\"kYU6nNPG8w62XHiHbMwAYJnOqcrxWsHXotsBcq691g4552N6VCy6uST3OimJoe2BmZNRGbug/NhN6NAkxlY6IQ==\",\"salt\":\"3i78eGEEKesMG9a3VNzweQ==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('38ccbe4b-8f65-48ac-81bf-6b3ae5359afe',NULL,'password','44689a5e-41b0-4008-99fd-7a0043f5a1a5',1641841664226,NULL,'{\"value\":\"1fQbQWiTBoZ+81Xgw1kRugX9CRwivt8XuwMY3mRrtTtrNcSVAZH7/0zx4FhAeEuh3uVdDTh6+/XiAE7Z5C3hug==\",\"salt\":\"D2uZN1EJtgoMSrdqagHuWQ==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('3961fc10-5a84-42de-b8cf-210cc7f74530',NULL,'password','3345e8b7-e6c4-4589-a018-fef2ff135a5f',1641840835602,NULL,'{\"value\":\"Bv/zEYWMER/sxgm7hnmNpFrvFPRVahRFYE48/KTthMgv9BIC+f6Waoj2+RGwfjXeYLh7CRp/on0dDRzS0QJ2xg==\",\"salt\":\"1Idf+as++k2DL7hVBSRIfA==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('4f9db8d6-03bb-4dc5-9c99-5d68555d8d2c',NULL,'password','be5851ce-6318-49ef-89b5-b8d842155eb1',1637966928059,NULL,'{\"value\":\"zu8ClKxogqnxXSzrf/o64b7ni4Om01fG0C3aHi0CNWsMq6vdYQYC5V5v7z3eFgiNgtF7cmV6k4Ml1XE8lWzyOw==\",\"salt\":\"ky+61pFFh4mjLAgaDTvmOg==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('588d241c-bd7d-40e1-8063-fa85d961b7ed',NULL,'password','9b0a27c5-e31d-4127-811a-2e078cf3b044',1637966875381,NULL,'{\"value\":\"IL0a6II6HLrDmXPtoA24fyfR6hv1i74jacnu+aEarXGVJPYU0z400Y7cVfT6/+TeZiGdt32/jxPtQWFmzZaYBQ==\",\"salt\":\"/VobrO5yxMbbYK8ZiGKp3w==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('7dd722df-b7c1-4044-88f8-fbfb3242108d',NULL,'password','52ea9aa2-a569-403c-b33b-46c831d456da',1641840790228,NULL,'{\"value\":\"oCbvueCjUSwRIw+ftTCw02chPHG/VSlwIYqhpceMl3YJ6bY/JZN3xaRbdtNL1ATOOltFsey4q8UaEvoR0jftPQ==\",\"salt\":\"iUCQ8ZdXr4b3I9gcrQc5Cg==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('82980de4-5474-4c03-8d82-5c534ed6d409',NULL,'password','89677443-e591-4bb2-ac4c-ccefd5911de4',1641841919878,NULL,'{\"value\":\"vWXgjQ1kyLyFs66nBko3zt7m6TCmIchbXtZvDykFviiseZ/zAhdYdebeC4xj/CYKgDCqcjt2vSynmAk1It/Wcw==\",\"salt\":\"gQ97qVPOVUg03jxOJOJ49w==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('9da97828-82f6-4612-8ae3-f97298be7012',NULL,'password','910f1061-e835-4415-aa7e-49ffbca5a23f',1638677762419,NULL,'{\"value\":\"o/33p7eW5tXt0/Wdk4eA51lICJe48moRyGfDHJNGRC+lT2v0zK/kbSWNvNLLgynPkFuCO5rHgg3+8zwwtoyklQ==\",\"salt\":\"17cKkDE6SBU/PQ2ploAiuA==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('a74726ea-4223-4bf9-bbf8-91f48bcfb045',NULL,'password','ecb14193-d545-423b-8e02-53097bc765a6',1641688080052,NULL,'{\"value\":\"ShFvYKLXUyK+P543Z1UyUiO7m+SC1rUY6d+f8p/iAQEjplbkjhsZISnZb8HAFbG7oOqAolk9T8fWQCsMt8zZnA==\",\"salt\":\"lVTGYkQbV00eZnrJp4xX3w==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('b83c1d5b-2892-42f8-8944-0d95045a2a46',NULL,'password','f73a1df4-e961-462f-a1de-2953d1c258ab',1641051201127,NULL,'{\"value\":\"cj5EFZJelO0/3rf8p8a+aO1YYcKpzH0oKbkB2r/yokFdxWtFZWdZgiCW6xHXn+6fEe+CVKbNgE1tONFXe5LIRw==\",\"salt\":\"qPKqIHzfZXkSQ1KduCozwQ==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('ca5686e2-9699-4871-b325-bfc68fb1e22f',NULL,'password','5c33fdaa-6ddf-4ee2-a8db-b580d66104f1',1641842380325,NULL,'{\"value\":\"AHTzJwmhO+9P4bYvb5Uvak2N2WGDEbYsThAsZFuXlbCDt4sJ22QJiiAAIRNkp1ilv2uvBbEEZFLvQPJFzAc/eQ==\",\"salt\":\"OcsyFL/1Ah/mWaivf8CxGw==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('cd1155f6-6de1-43ec-8595-bb31a8ec816e',NULL,'password','d31510c2-eb5d-47ba-bfbc-53c0d6759f72',1641841054732,NULL,'{\"value\":\"Tbdr68PSkoo6stD9dGu0fAT+g1zZnSauPuYyjSTwIYQV50x4phA3jDppj58BxWNBVGDutCPfkCX7fLS39uv9gw==\",\"salt\":\"ZqOacMki2U6JUlI7DqY3tA==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('e077d363-c187-4bee-a7c6-b9af22bf6e81',NULL,'password','bac89e60-b525-4d2f-9fe9-af88f4959dfd',1641842002908,NULL,'{\"value\":\"xiZSZpZEQcDIFENynW2qlcHvrblpyMS+ZKDCPmZx308wmUbqmGHoWdHokj6lHjICue/5iAEx+p12NEzlgpAl2w==\",\"salt\":\"6gO1yywGlONATwkv2lCQnw==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('e37afaa7-42e0-4b3f-81f7-dececf8b8c0f',NULL,'password','0951c69e-9355-4a48-b817-7c779cede052',1639896188921,NULL,'{\"value\":\"ExYFWWNiNSLWnwvnrSt4dS/Z7T2M1ve7N3sjjRWdEJprYtE6nhyg7CcT2sI3tnugJd++6HkXeWPk62ftnhLTEA==\",\"salt\":\"V4MZ2M+8c/UEq26M3B+3LA==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('f5c66a7a-7fab-4360-aa99-eee1f64b45c9',NULL,'password','991b52d0-b5b3-46e9-83e8-9a7adec46201',1641842152278,NULL,'{\"value\":\"ylCaNrTmnSXtFj/hM4H3IIUdlbTTI1/CPHVyQfwOK82G0soG/apK2xPHV5ZSSQaHOeh9wPYnO2BKA165tsyGQw==\",\"salt\":\"bubwMZZ6h/uvglWGdgdufQ==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10),('fcc5ce10-74c7-4d6b-b6cf-d89391ac435d',NULL,'password','7374209f-8cc2-4a1c-ba3f-6b57fe43cc5e',1641688059690,NULL,'{\"value\":\"4KNkFIxxWLr5E3Cz9wnl6loU2kNxtG3V3CRkdd7P5PP1G92EwenJZrmIi+mi5wWKQ3baAM6YnsD4w2ZnPhSVQg==\",\"salt\":\"0Siz/Gc+YLI5CfDqolRHsA==\",\"additionalParameters\":{}}','{\"hashIterations\":27500,\"algorithm\":\"pbkdf2-sha256\",\"additionalParameters\":{}}',10);
/*!40000 ALTER TABLE `CREDENTIAL` ENABLE KEYS */;
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
