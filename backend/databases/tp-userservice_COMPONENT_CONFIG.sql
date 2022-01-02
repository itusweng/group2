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
-- Table structure for table `COMPONENT_CONFIG`
--

DROP TABLE IF EXISTS `COMPONENT_CONFIG`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `COMPONENT_CONFIG` (
  `ID` varchar(36) NOT NULL,
  `COMPONENT_ID` varchar(36) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `VALUE` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDX_COMPO_CONFIG_COMPO` (`COMPONENT_ID`),
  CONSTRAINT `FK_COMPONENT_CONFIG` FOREIGN KEY (`COMPONENT_ID`) REFERENCES `COMPONENT` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMPONENT_CONFIG`
--

/*!40000 ALTER TABLE `COMPONENT_CONFIG` DISABLE KEYS */;
INSERT INTO `COMPONENT_CONFIG` VALUES ('01e2cc3d-4590-44ea-a6cc-2faecf32d4dc','e47c11e2-1e30-4796-8b91-45d1fbe3b358','privateKey','MIIEpAIBAAKCAQEAtEFjqsNR0VIERR6aou3/7rvE1avDA1mYjaA2AWxwo5Le3iq3//oGbjF33hojOXnyQiULiSvwYlXGJZvN4eMB0Lj4BjIkR/QYUYBgm2EPL8wqALIuDcq80rsWt6M0K8GIzkUdJhjnRR534LYqbDe9tJr5CwQSHV9TSNqXzh1AKb9PhgxXFJHStFlQ8LRa6ofWEzrfYyBNATAtEOPhuwbSI3ETCG4cIDlQJS4S9EC9wnp+CL1qA5PMc1NIXyYJti2LNZlfssXZzTnqkFgSkvn3cyqwuNUCUsbS/U6uNPjR6o7QNaJ0VhtKEn3IEPap8Bt3FePzu5F1etn2TUhOdNQ4PwIDAQABAoIBABvgwxaIHRwiXakHqdiKC5ueFxFe07XYbQjLtEk1vsP69T9nXEwZcgDSjhyKbqk3LC8WW07h6KHPbJT+IEePxtpDno8YFoFkW0B7pN/9u7i45Zl0SpLKfg1ExHzZSmUmtPmwjxNd0E2Mf/N/6QFnVjkxAKm3UvU6UX9X2MOWxYjPHEgrmm6slDfdlyYfWZg7e065XME43D0BVk01QVrAeCcR57oktHzoL4UNsU8clMXioWf3+84iYwRMf8yOxBT68nBjskAZjkbHZkDtgoXJgBQZ3MS8qpvMWR+Ii+OyH3hNpRlDxdD/EP6eoIbUrTC5PRbU/y3m3Is2X5iFuoMwGFkCgYEA6JaOzwpS+8dxFxQGH2ROlSRBA4gdmhLuXE7ZNOTug7v0AvrZ8j3IVLudAIBgjWl1Li75z/as/ilUA4oIXYnWOFOLZH5JpVpn8UUwVZkc3uVUTKMUteG5uZpMNO5l9+tDPXTMf0XC5MO+4EVEZ4WMJH+sJrHrsescSbYyXlWE5qcCgYEAxmZMMZDgkh9r7p7X3xpZcU3BuuONip6swQNq9h1pjlZDCBiL01SW//PcHjtE8iQJ0kMkmSjCY9J8NDmAi7HriI/1MCT8jRM1urt5e8WgpqwWnTwTc9fixlYodCR0lu3pTRAyP41nWi5yjNEtGJFrX8TlElL/LufghnE1fc2a7KkCgYEA2i7SDHpc2f9/oOyRycToypNVwaBgVHZJz6HPtATFkiIwhtMWvF0kngfZAe1rpXw2BnresS1vnoTaYO+NZWG16OTGMCEfqNOkCfqjmsilApsSd0nMVcpH1UpfDpBMa0LwsqfsZb/lUYAmgG+5+XqXum1h6nKg7SfmQ2d83G1Q3KUCgYAFFTPYhTyrobBzMZCYP6WQ+IwBDLlglsYYP80qtwAwTFd1SqOya1VfA1FdWOlgRroVr/CtF9U7F3ZlJB/99DXzjrSaYigyOQ7EVO8804hVHM2Lg7F/40UFDcoFh7WQ9FFozwRqimXecpgusWE1YuxcTMANoyC0g+5Fo3raWT0h2QKBgQC77ikXx+FvxNUCNtH4a0sMfBEVwIeVdHE6L8/4Z5FnxdZgRE1kRvZne8KS6zVc0ireEKPZgpJG5y4jb8rMyvgE0SGsTKE005NNUuA41yjRBL8WsJ/7janeCnAsEJobbR8HYCwHjmbUMj1mW0zeXbruPlzCmRXGNmNSBJazPckZ2w=='),('04edc453-0a8b-4ba8-84a8-f963d60424d9','01fc5f29-cef5-4c08-882e-e02f69d9e105','allowed-protocol-mapper-types','oidc-usermodel-attribute-mapper'),('070d62e9-5922-411f-805d-c32d002b51e7','3cc2b7c4-f278-4f5b-b200-4a03077d35ed','allowed-protocol-mapper-types','oidc-usermodel-attribute-mapper'),('0ec71971-5b83-41b9-a421-3abcbcab7aa8','ac21f2d1-adac-4d1f-adb4-26009913b8d3','allowed-protocol-mapper-types','saml-user-attribute-mapper'),('122c7347-c52a-4803-9ca2-1d67a89e29a9','c7bf8e01-e2bf-4b76-966c-b209f7bb57e6','kid','299a1140-7918-4541-992a-3b2a77024877'),('13459b84-097c-4726-8e02-787c804d4c80','3cc2b7c4-f278-4f5b-b200-4a03077d35ed','allowed-protocol-mapper-types','oidc-full-name-mapper'),('157de1c7-9944-464e-8b25-9eaa158beb97','ac21f2d1-adac-4d1f-adb4-26009913b8d3','allowed-protocol-mapper-types','oidc-address-mapper'),('194ac6e5-e4b9-4c09-82a9-3ee28158d39e','3cc2b7c4-f278-4f5b-b200-4a03077d35ed','allowed-protocol-mapper-types','oidc-usermodel-property-mapper'),('1b51b9a3-1bc8-47fa-a1ec-3c36746aba49','ac21f2d1-adac-4d1f-adb4-26009913b8d3','allowed-protocol-mapper-types','oidc-full-name-mapper'),('1b9d8632-9463-4aea-80d4-ca2648b5f536','01fc5f29-cef5-4c08-882e-e02f69d9e105','allowed-protocol-mapper-types','saml-user-property-mapper'),('1f7a6afd-5699-4065-872b-5237eb541588','e47c11e2-1e30-4796-8b91-45d1fbe3b358','certificate','MIICvTCCAaUCBgF9XrAtaDANBgkqhkiG9w0BAQsFADAiMSAwHgYDVQQDDBd0cmFpbmluZy1wbGF0Zm9ybS1yZWFsbTAeFw0yMTExMjYyMzU3MjRaFw0zMTExMjYyMzU5MDRaMCIxIDAeBgNVBAMMF3RyYWluaW5nLXBsYXRmb3JtLXJlYWxtMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtEFjqsNR0VIERR6aou3/7rvE1avDA1mYjaA2AWxwo5Le3iq3//oGbjF33hojOXnyQiULiSvwYlXGJZvN4eMB0Lj4BjIkR/QYUYBgm2EPL8wqALIuDcq80rsWt6M0K8GIzkUdJhjnRR534LYqbDe9tJr5CwQSHV9TSNqXzh1AKb9PhgxXFJHStFlQ8LRa6ofWEzrfYyBNATAtEOPhuwbSI3ETCG4cIDlQJS4S9EC9wnp+CL1qA5PMc1NIXyYJti2LNZlfssXZzTnqkFgSkvn3cyqwuNUCUsbS/U6uNPjR6o7QNaJ0VhtKEn3IEPap8Bt3FePzu5F1etn2TUhOdNQ4PwIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQA9idEi+NdmV5b3EEcAEbkKlTGG0FtBTnTe5AblnXrjTmsFn01e1lNKrkUgKS3yC2yUBT+sXNgc9KVwOF3fkfm8QlRha5bzXnfxmSSTgVQe8I8NYKehP+RifLkRO/GI4SPjNL1ScpUTxfzGjFfzca0/sdVkVjAodfgoUUUGLoobTjW4e0XxpqQw6QUF7FAg1tiMUARBfxT2EXsnS5kt9krEsd6NyPsLM14VcyWSoH6qXb/3KbYMnwDjf9pYqw8dbMV3z1ru/RA7S1fr02RLldrnPRmV0cxnMoP5D3ZIPQjykJJhB+7G83XAY2frtYmZGI9HkzsL6ffbWP1WxmufE7ME'),('221413c4-d988-4b5b-82d4-c6e1168c83c5','0f1615af-ff5b-416c-9d18-3ee06adf08cf','allowed-protocol-mapper-types','oidc-usermodel-attribute-mapper'),('224aa48a-c489-42bf-a178-5b2b9e024e37','2c3678fe-af1a-46b8-8997-77ec3b6878ce','allow-default-scopes','true'),('2983c6a1-7ed8-4897-b4d7-d8cecba6d981','0f1615af-ff5b-416c-9d18-3ee06adf08cf','allowed-protocol-mapper-types','oidc-usermodel-property-mapper'),('2da0b602-b96d-4186-a8a0-5de83a4df116','186db2cc-34ac-4cc4-ab38-886ef0b34832','certificate','MIICvTCCAaUCBgF9XrAtHzANBgkqhkiG9w0BAQsFADAiMSAwHgYDVQQDDBd0cmFpbmluZy1wbGF0Zm9ybS1yZWFsbTAeFw0yMTExMjYyMzU3MjNaFw0zMTExMjYyMzU5MDNaMCIxIDAeBgNVBAMMF3RyYWluaW5nLXBsYXRmb3JtLXJlYWxtMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2BMYwtc6hPiDApfBsMIMUMFrV5KxvSJ+/uIzG0KOxtXf1397l4P65jR4rbSQDMx5XLJuEoHjeWw4VBDtrjfVqaLsBjErNwFKF2N2j3e1dCIRVR4Estyi3FbeLNX7grgvBvCPufzYMVa8J7qjjjbteuu2W+Goq/HH5+jLvxjKnr6jUg2VXddSLq6snHS2NDghybeebI+15GewD3zaAYqnOt5yfLQpQENQeNPAUFn4+tuusOPs/+G+raNRJ3zbBHCz770GZVtFrD/wglUnwbVD5Ri/DlPXUvDwnPb74CLwzkBP6urD8GP0pD7JGpKlW7pkSN3VJPSl8Q/7k7IuJnPXNQIDAQABMA0GCSqGSIb3DQEBCwUAA4IBAQCwJlkKg/gG6ON+TiNLIR2iFRmWgkeCniS3HSMLQ3u+evEMlWiCe9+7A7H7PceT4wUOZUNP6bBlMrPtx55LuXzs8B6kZ34j2c2nAJXvu/FwTTrbyEdo7S6rUl2PLV1wPdVZOO/tPE9agWbh85TKq2sCoTEnVdUociiRwFD38q4l+pKiCfDPe7v3hOfTETmA72TkuZ6D5BlnsWYhfwa1bdEhOTajzTIIEXMHP7pFY5aw5SJHJr7uqNO9inacso3JGnLDWB/I9NC5LM/oudW5hgkj+ATJdkzHk7Rl0PsVd/QdHGlZjPpeQU6AsspjKlqWPCJ4oEW0cLOU7xGUorlL98Bc'),('338f8bc6-7f75-442b-b6b9-a3b83134c63c','31f282a8-82e1-4ff3-81c9-1dc47909ea4f','certificate','MIICmzCCAYMCBgF9Xm6+zTANBgkqhkiG9w0BAQsFADARMQ8wDQYDVQQDDAZtYXN0ZXIwHhcNMjExMTI2MjI0NTU1WhcNMzExMTI2MjI0NzM1WjARMQ8wDQYDVQQDDAZtYXN0ZXIwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC3Umco2sniztJmonXArdVAsmsrTTetWNshCVoNFU3m6x8FBlGxKNE+R7wnFk8MfdqaQ4ZwkHoIUsFjkRri7pBGcuTe6V/LZgZcw6zz2M4KtNuFAql5NsZrpnBcDb9KIe2kAvmRUnr0ZfM/t2agHaDsr8HmK6n3FXJew1QP5JWgtz05y/1B6uyztMhl8+7y5l+5e1Cj+O2V4swYGMTOY1xTrouZRpW+D3WROBYVFUrXBwPaEJ3Y/WogkWAtQqfA+83U2k9+dFfr0jEI1uGiDqnj7RNlz7otxd/6XssJoKjM2u3WIVjrVe3jPE5KcyWLvRfNpqFcB5bRSfkvEWOJuf0lAgMBAAEwDQYJKoZIhvcNAQELBQADggEBAGWfOTWD2daZ15Baj+kyFXt83Lk6pwOlIc9/of6VgHJu2CEJCdtKZ6zd6L6drU7uIXoiuih7h1maWFeLeQK1VFs1zyyoITHqTi7zZGKRP5J2RxApX3stRAkaPrv5NduKR/VuFrOX955qatV04r1CSBOyAwdgPid2e0sEhp2z9hChtoawBbbGs4BBHs7pEFdAznXoFWCYgr5UaF090BsP1cCJP9YyHpJQxmhwUTYOP5Sf1j5E3SiRDZpuogrwIapFmxn3tShk6U8iqhCIqE+o2Ww/kSfkz6t0zxE1WBRSg3zRLpleVUfBOkZeC/Im4GzzGCXEDjkMAUl5o92KKSBics4='),('36ba58a6-0bd4-4c64-9685-b3373be7a0a2','df564e0f-ce2e-4ac5-8e62-8d9170b5e079','max-clients','200'),('36f8a6c1-c9fe-4977-9174-ff4506d26745','31f282a8-82e1-4ff3-81c9-1dc47909ea4f','privateKey','MIIEogIBAAKCAQEAt1JnKNrJ4s7SZqJ1wK3VQLJrK003rVjbIQlaDRVN5usfBQZRsSjRPke8JxZPDH3amkOGcJB6CFLBY5Ea4u6QRnLk3ulfy2YGXMOs89jOCrTbhQKpeTbGa6ZwXA2/SiHtpAL5kVJ69GXzP7dmoB2g7K/B5iup9xVyXsNUD+SVoLc9Ocv9Qerss7TIZfPu8uZfuXtQo/jtleLMGBjEzmNcU66LmUaVvg91kTgWFRVK1wcD2hCd2P1qIJFgLUKnwPvN1NpPfnRX69IxCNbhog6p4+0TZc+6LcXf+l7LCaCozNrt1iFY61Xt4zxOSnMli70XzaahXAeW0Un5LxFjibn9JQIDAQABAoIBABuW+gIWzXgGTvmV3TlyoAvk3kat0CGVZCNIdEZQTMFiZPB9ZzmNrlIcezd5vstfPJFndLoHsGoExGiu+7goFcwYehQHVPy4XeBDrcmkOTw4xGn0ANwGj52/dp0QD5hBW3HJ5dQGcQ1Ls6yE9lvGIcRFXl38989BKc2TwZjDuvYtJAC0lpkrk2eVcl+IuKlj1+/ClzRidSxiqtl3tH5306MS0JVakLLbkJfbL+G1WwNvGm93ey/2eNW8lO8WI77XTGIp13UWBKhOMzbjpSXqm96IGaNo+BvLIy2b5tfdjc38POGcQn52O7YH2aQKz/QqZvEbysOgHA+SJ6jeekgVxRkCgYEAvyqkOFhiVhHfBZALvJdsOOlt5HnFhI4i/KUuN0yJ2oNA8JjUviV7bSyJpQG2aWVlB1p0aoiH7kzq3Jh+C8oSsF3ynKvrigmmG5Xu205QGl2+WEGNS9o1Zg3H5LewMZd1zjSTUAI7Rg5FxmKFaKvKjxqYooY2GOS6Rh5GoKwkI70CgYEA9X6swsihkxd3dHcUBeTFql58ZMz/udumQ7yJNbQkWGzVdccqL4vafsaaI4Zo4xJPa6sKmizWj3Z2H4HsPYPWmM9O57oXiybEr2/phcv0WEaCZ8LatUR1bOu8wz9+mNG2x/+IssekbtCle25RavYrJuGp5aXqUB2LsKANn6mdoYkCgYAeCRweQjzJGyu4WwaNDhmR45NBl6RiDFcQ7P8S7zKlo4O7ibe7XHZFE/9Ybqlza9vwyNSLvIHm/izUlh0PyyMelNQ+q4BpgtSXdvo9eNN7IQl8ImiJ53IGY9npZLcJQ6vdx0LyCje37RwnbGlbpcpAq8QZnQ644I8n3y/npMRU3QKBgAZeNtUGp0pNfYfD3v0YJhh5QvjKaIfFrtZq+ZQvDBJPIGphtDJvikdnl2/8eJQLUYwVb7z4FMi75eyDTkF6PgLQvdc8+IdfhhKW8JPL6pavnYpbf5jcIb+ljcvyxbHpHripZD5e92D4gJJnFi2UHSJxEBso5p8VZR47yJ6vo6shAoGATFlMETBmRH5rP1RB6afD3LST0ddu22ju9u3jvB8tZ9PpBD6CY/y0g1CJGfCUbicnchpfekXG39ysy4SvpE8IZKba0+pPXhHnpbrilM2cdmfEIa0tS856ZoghwtLaTGhUQIvh9nIXR/0h0DP7697ldoKTBIz/zdy2cvwj/tbdoH0='),('39ea0b28-2db4-4b52-b5ef-6e577de2d2a7','ba2e9ac0-1981-442d-a941-7f11858045a2','secret','_0bjv6T8PNl2DqIZrfkbNiDwjPaHJiUJp29FnXPhqfxgtH4MGk1lt--IASEC-4ccknF-NABw9tCeeguWBQ5ksA'),('4140895c-b245-4315-a883-3773b2de49df','d281756f-f469-4215-b5d2-45845c08bd96','priority','100'),('41a6bc9c-1664-49bd-ba18-4eec9eb419fc','3cc2b7c4-f278-4f5b-b200-4a03077d35ed','allowed-protocol-mapper-types','saml-user-attribute-mapper'),('43b31475-92d4-433c-935f-3e5f8542db6f','ba2e9ac0-1981-442d-a941-7f11858045a2','priority','100'),('45513468-105c-4aac-aaed-f0899d21928f','6ea83f83-950d-4f93-a93c-a7f9a939af4f','client-uris-must-match','true'),('4b953d8d-b6c3-4094-86f9-f90b6c60eacc','01fc5f29-cef5-4c08-882e-e02f69d9e105','allowed-protocol-mapper-types','oidc-full-name-mapper'),('4bf1437f-29d5-429d-b8b3-a16adfdc8e63','ac21f2d1-adac-4d1f-adb4-26009913b8d3','allowed-protocol-mapper-types','oidc-usermodel-attribute-mapper'),('4d8f1677-9de6-4ab0-899a-5cd592997696','0f1615af-ff5b-416c-9d18-3ee06adf08cf','allowed-protocol-mapper-types','saml-user-attribute-mapper'),('4fbf2477-7298-49db-9cb7-e290b56e47db','3cc2b7c4-f278-4f5b-b200-4a03077d35ed','allowed-protocol-mapper-types','saml-role-list-mapper'),('51fdbaa0-9638-4a9d-89f8-db462229d80a','4c372f8b-e925-495e-8e12-f5e2053c6520','allow-default-scopes','true'),('59ece005-8ec0-4cd6-8497-fecf1d00ef71','ce5ae54c-13a6-455c-b9df-d4cb02cb7e81','kid','da2df1fb-66d1-47ca-baae-96d473830e0c'),('5c27c2b0-d540-48e5-a564-45484e285e3f','ce5ae54c-13a6-455c-b9df-d4cb02cb7e81','secret','g2FUuZDFbe7J6eTX5jT1_Q'),('62c8bfa9-47a0-488b-9824-80ca9cb66d26','01fc5f29-cef5-4c08-882e-e02f69d9e105','allowed-protocol-mapper-types','saml-user-attribute-mapper'),('658d4c6e-1835-4115-9dce-4134ec85e0ce','3cc2b7c4-f278-4f5b-b200-4a03077d35ed','allowed-protocol-mapper-types','oidc-sha256-pairwise-sub-mapper'),('65b47d3a-1856-4c24-8c8f-8538e74629a4','6ea83f83-950d-4f93-a93c-a7f9a939af4f','host-sending-registration-request-must-match','true'),('66648f02-b3a2-46fd-ba40-e28f314d9b6d','0f1615af-ff5b-416c-9d18-3ee06adf08cf','allowed-protocol-mapper-types','saml-user-property-mapper'),('69958d1c-072f-4a87-89df-fa65f96b7207','0f1615af-ff5b-416c-9d18-3ee06adf08cf','allowed-protocol-mapper-types','saml-role-list-mapper'),('714a88cb-3dfa-434f-a7b6-5c0983cf6a23','b75e5494-3052-4b21-9730-17e8b05b6d9b','allow-default-scopes','true'),('74491946-610d-4c30-b283-e06f77024b30','186db2cc-34ac-4cc4-ab38-886ef0b34832','keyUse','sig'),('75847a97-2cb6-4ceb-a102-9f3857035da3','186db2cc-34ac-4cc4-ab38-886ef0b34832','priority','100'),('7b1587bd-1e4a-4332-8dc0-9103dfbc10b5','d281756f-f469-4215-b5d2-45845c08bd96','certificate','MIICmzCCAYMCBgF9Xm6+NjANBgkqhkiG9w0BAQsFADARMQ8wDQYDVQQDDAZtYXN0ZXIwHhcNMjExMTI2MjI0NTU1WhcNMzExMTI2MjI0NzM1WjARMQ8wDQYDVQQDDAZtYXN0ZXIwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQC6OrmNY7syEwVWb8XQn0CgZi2DxTBvijdAimQkqVoSTxjqTyp5GSOET4zRwzZQS92EdMaK+VWQKzVz6PcvWNYB5v6TtOxTEndx4aOjTQvmSrjUHiM2STp3FnwGClfDAcnFqsym3c6Tmim2cDu+v70y7HpR6UuwOT030fjtbHKpLLL4HwOwK9vRpoywtW+DSKBm1eCiEt/V+5o1+hgYCaJzAyuMobh9oNLX6hO7s4nhqOI9gM38u2Xa68+oe2ACTem2hiOjA01u8bSuLY5Niuqcl0l/ckKhEXhtjyn+KpDpzvlo4Xl7VXwucoeF0znt6jZUVHygAG1YB5qbXr+LE6rdAgMBAAEwDQYJKoZIhvcNAQELBQADggEBADKsY4e+P2EfDbRD8CqUXTtSWhShjhpH3eWfZXpLH5tbH8NblSffupCYOK/1b5dp53+LIpt17da0KKP2+cJRc6lkZu3876CLpcqrXk6VFO9NIioxuuQpawxaOUFFurcRDISlPOPvVBq9/79kfqbIlenyqg0pR4hSk2i/J4Y/ZGxrpkHQSvk/yeST4H1sNf+ELBA4mliKFfn2TpiuI8WGvPjQWwvlCgGQTMm5WjtMQvBfokiGtouD4nKIZdEggCNtGG/IfCMGEHym/iP5xtrnVn+R8GzW8XYUB4GmV+WRV46vrUl/ztR8KtL9milUXt4p8qKRcIYpuOVcXpzMpwdRIU8='),('7cb54286-d421-4c90-9976-d2b877cdcc9f','df4ba774-0f14-4e70-82a7-4d97ef147cc7','host-sending-registration-request-must-match','true'),('7cceaf87-bde2-4472-a612-e9d19c3d96b0','01fc5f29-cef5-4c08-882e-e02f69d9e105','allowed-protocol-mapper-types','oidc-usermodel-property-mapper'),('7f8d5a74-fdbb-4b1a-9019-b6ff264f0ff5','ac21f2d1-adac-4d1f-adb4-26009913b8d3','allowed-protocol-mapper-types','saml-user-property-mapper'),('7fd77bd6-fbe0-4cb0-9205-e34c8a9df421','d281756f-f469-4215-b5d2-45845c08bd96','privateKey','MIIEowIBAAKCAQEAujq5jWO7MhMFVm/F0J9AoGYtg8Uwb4o3QIpkJKlaEk8Y6k8qeRkjhE+M0cM2UEvdhHTGivlVkCs1c+j3L1jWAeb+k7TsUxJ3ceGjo00L5kq41B4jNkk6dxZ8BgpXwwHJxarMpt3Ok5optnA7vr+9Mux6UelLsDk9N9H47WxyqSyy+B8DsCvb0aaMsLVvg0igZtXgohLf1fuaNfoYGAmicwMrjKG4faDS1+oTu7OJ4ajiPYDN/Ltl2uvPqHtgAk3ptoYjowNNbvG0ri2OTYrqnJdJf3JCoRF4bY8p/iqQ6c75aOF5e1V8LnKHhdM57eo2VFR8oABtWAeam16/ixOq3QIDAQABAoIBAAui1jZhrCVqP1aMiCzAz/IFww5yoH65ATqg5bYjDRv2QcKy3MmcGsDuaIiFx6EXmxkm48NKENYqgP3uU/LrJyoPbnTjud13RVaCCFkQhsURAlX3URttUsAfUUizq5KldrT0DF1ZIB/PDZABmMC9LHD1X4TlNxkP0TBUSBcWWYlnmdh+2xs2u92GMO9fBWx4u6swjLaUXKdQDWweJ4ROA5D8tv+VPhO+zrMommhDGMqfpQ9Li2gq+0dkjT2qLlhz3jddQuYy9oftF3YoHsLL9Ot145VAKbtvqraz5up8Hqitb2m01U+mbLOsvyNcw4M/FmT5gJWwVP2MEDgQAvoZTOkCgYEAzl7cAW4R0SUpEWRhrXqVNLGweh/ytdnB+DzTfv15Ti/rUeiySMMM3xXkonibtQX4gGNDcJ72LY8/jpvzhDdDV8YU9RT0MAizaxRw9ln07GXk9fHLHLCgm91NgxZuNTTG387ZhhYqFZaBSR/8tuj/mSgIAktz3l2+VFawOwPzwzUCgYEA5wPhq18akBwQIeFGixZt12sCOFju1up5IoMhYUNv8CGhFdSUNagsjaJRHVTmTfsHhib+Odv3jI4OIDQtICbdXtfujCkHz+QaLkk/K3GRtSBn4HugqHEF2ZYkMwMITTdLagvhDdCO5l2rdKpvZLQI3k0MWQnngO9FAGNE5hP2VgkCgYAgwHtIGtDnEW+4G+dIofjGGSE58JITfFDFddnXAKFc4EwHfte0pogHa7ESe/OyQhVTQu20FPZa+q4KkwONyzt71asDzmSGrwrShrb60gIF9pHk2o/yqLGEqxWfJVMuTIb3hBuPpTrenDk+gr4XxVizVOAYhSMJenU3a16irxjjtQKBgE4gje17GGysUPhkS4s2Zqd31SRhT0T3v0fguSU/vVekx+muHwGWgprTzkLxN4If54eDIG9I6Qtr73MMskYxXqR4uoBEUBQKvJ/yvZ5fpjtvXjIZHVhaAPR5RnzKBcC3dpXCtrYJVoqqGxY1nb6c9HLZ89cY9mYwhVGAQQjer2yhAoGBAK7/hrULXwIJvFIsjk5I0W4rtsY4TxPq5//jDRKRUUAArqY3IkohI9EwsuJFWC1M3OLnAZhOmr6Ssmz6DaLRyYSptuVydQ9pWqa7NFidwJHgMh5qaaOOkLT2mo7/DoELByqjJK1ezCibEnCqM8ayRRMszRJMc1YYIHzYOW8iAIzj'),('80ec5d5d-b650-4eeb-be19-10313eda523d','ac21f2d1-adac-4d1f-adb4-26009913b8d3','allowed-protocol-mapper-types','saml-role-list-mapper'),('8ceb68ec-dbfb-49e0-b6fd-4832c92fa39d','e47c11e2-1e30-4796-8b91-45d1fbe3b358','priority','100'),('8e4bfd2d-d956-4747-9b4f-f09516638897','0f1615af-ff5b-416c-9d18-3ee06adf08cf','allowed-protocol-mapper-types','oidc-sha256-pairwise-sub-mapper'),('914b5aef-b0fa-42bd-b7dc-8c98f01add87','ce5ae54c-13a6-455c-b9df-d4cb02cb7e81','priority','100'),('96178f02-5553-49b8-9b97-3e142f92d21a','a6a0197e-ef7c-45cc-aa63-065e3ed0032b','secret','99fK3kK9nOdQbIDoJ7ubUA'),('96d35496-8749-4dbc-9b5e-e4d31f680e67','c7bf8e01-e2bf-4b76-966c-b209f7bb57e6','algorithm','HS256'),('9850e89a-caab-493e-859f-91eb8bb1aae6','3cc2b7c4-f278-4f5b-b200-4a03077d35ed','allowed-protocol-mapper-types','oidc-address-mapper'),('9f175fe7-a2dd-4177-9a6a-42227b028b16','e47c11e2-1e30-4796-8b91-45d1fbe3b358','keyUse','enc'),('a427f540-9934-4772-b74d-9603b701aa64','ac21f2d1-adac-4d1f-adb4-26009913b8d3','allowed-protocol-mapper-types','oidc-sha256-pairwise-sub-mapper'),('aecca80d-d98f-4754-9a16-837992784cab','ba2e9ac0-1981-442d-a941-7f11858045a2','kid','97a2bee3-cb4a-40c9-b39a-9f42a936f9de'),('aed4eb22-c03b-4c3d-b6ca-5aa28204b25a','0f1615af-ff5b-416c-9d18-3ee06adf08cf','allowed-protocol-mapper-types','oidc-address-mapper'),('b49479c3-715e-4be9-9180-abafe17706c5','c7bf8e01-e2bf-4b76-966c-b209f7bb57e6','secret','qg3Gxo_0tBp0cC5vmLBWbstxen3wPjkNNf440yeSBoqINF_WoeQWnlVMGpGRMd2Jc0IrjcBbaE1sUQSRw_fvOQ'),('bd9f86bb-3775-4b7f-aced-a54f63fa9ffd','01fc5f29-cef5-4c08-882e-e02f69d9e105','allowed-protocol-mapper-types','saml-role-list-mapper'),('bf7bb4c5-ab92-47bf-921d-42c603bf6a1c','a6a0197e-ef7c-45cc-aa63-065e3ed0032b','kid','ce1129c8-49cd-49f5-8013-51cd1bc3f51e'),('c42a13d7-2ad1-46cf-8d2f-2e091aa2b101','31f282a8-82e1-4ff3-81c9-1dc47909ea4f','priority','100'),('cb598048-a5ba-4c40-98b7-b02710bf965c','df4ba774-0f14-4e70-82a7-4d97ef147cc7','client-uris-must-match','true'),('cdcc2c9e-c097-4b8a-b73c-75c7f5b56642','01fc5f29-cef5-4c08-882e-e02f69d9e105','allowed-protocol-mapper-types','oidc-sha256-pairwise-sub-mapper'),('cfaec951-c3ee-4964-93b4-06c1510a9d14','0f1615af-ff5b-416c-9d18-3ee06adf08cf','allowed-protocol-mapper-types','oidc-full-name-mapper'),('d2b258e9-f1ec-458a-8f10-2c3de48644a4','a6a0197e-ef7c-45cc-aa63-065e3ed0032b','priority','100'),('d3492630-9cc2-4a9d-b0ef-9534d4126441','ba2e9ac0-1981-442d-a941-7f11858045a2','algorithm','HS256'),('d3b1e668-bd43-48cc-9d69-c52db2a0f72a','d281756f-f469-4215-b5d2-45845c08bd96','keyUse','sig'),('d59f5c7a-e2ae-4841-b85e-d0a6ea511c28','3cc2b7c4-f278-4f5b-b200-4a03077d35ed','allowed-protocol-mapper-types','saml-user-property-mapper'),('d8422b2b-e421-4076-87e7-f092f5ecfecb','aff15b26-7631-4b25-b089-99d42b19eba7','allow-default-scopes','true'),('decc8b10-9d80-4112-82c1-6a7c615babff','31f282a8-82e1-4ff3-81c9-1dc47909ea4f','keyUse','enc'),('e0e17d66-4d28-4f4c-a87e-0f150afd7c19','ac21f2d1-adac-4d1f-adb4-26009913b8d3','allowed-protocol-mapper-types','oidc-usermodel-property-mapper'),('e1ffe20b-65a7-4e31-9433-caef1890143c','01fc5f29-cef5-4c08-882e-e02f69d9e105','allowed-protocol-mapper-types','oidc-address-mapper'),('e2e5f740-48b8-4ab3-9d31-286edc1bbe4d','186db2cc-34ac-4cc4-ab38-886ef0b34832','privateKey','MIIEowIBAAKCAQEA2BMYwtc6hPiDApfBsMIMUMFrV5KxvSJ+/uIzG0KOxtXf1397l4P65jR4rbSQDMx5XLJuEoHjeWw4VBDtrjfVqaLsBjErNwFKF2N2j3e1dCIRVR4Estyi3FbeLNX7grgvBvCPufzYMVa8J7qjjjbteuu2W+Goq/HH5+jLvxjKnr6jUg2VXddSLq6snHS2NDghybeebI+15GewD3zaAYqnOt5yfLQpQENQeNPAUFn4+tuusOPs/+G+raNRJ3zbBHCz770GZVtFrD/wglUnwbVD5Ri/DlPXUvDwnPb74CLwzkBP6urD8GP0pD7JGpKlW7pkSN3VJPSl8Q/7k7IuJnPXNQIDAQABAoIBAAmqm3F5na5KmQw58mbWqSSVuphU2wTwlzwOer9t9CNuEjdt7LJwq5e2SKED+NIxwmSRiorjN7EV1KFIjpfvYVLw+g+Lp8WSr7HDKw/5CLhoBVyu9pvZctaNP+xDXtI2xjFqL3itGJWzrfNpdJ0aO16QtZXmG8/xbAJY4xoqx3aTHXnjobpyRoM4fOVgYW1v/segMhdYu9EgbsoYW7vs/6unKt2GR5l7Kh6xxAFh6oqUm9RkYS2xvQaccEhwOu5H7XPF51iE3S77rGBl6cV85sPCT4r+7JrcIK/gQmr1OyKaCKsQMKuauSN/kStyafsiEMSLC3sdquUfi/PxDmtEXTECgYEA+G/xOinvN6znUrwuYq7yf6wOfl1nHWFvJdXCjvyS6jiqHPYv5GYchRQoVUHpSuf2BQ+DiQmarLy66j0nLNZr93Tons+7ldJ2t/y1k0HPsdrosEFKq+Dlnp2NM18rkpDpJAsX2dbz3DsZd5+da1SvdmjA3zRMgmuaoGjxT2ia3XkCgYEA3qb0MslPy02x7mBgjjHo9sQsWZ0j1N4SR3P2gNDYp4QKAr4QE4W6u55yjLiUv3Vm5+4J48JVDCpJLtNyu6AXSbHnQ1r25bYjj5G1bdYUVP4JGzL6ukk/ZB/Cb2EitA8eUq1yUIMXDlvdVpiD/l6ZN+IaUllwlDqU8uwT3ea9JJ0CgYEA13E0Ly1obs65d+0LCLcQQplxpDHZlwgEvDnIU/lCam2jUCRKWfYXK2zUoULcTgIkPjU66x7yDHRKX5GSpHZ6AIlYpUgeM4nlPB6hU8dRlrnw6dBlMfKBDfExHuicP6j9FS2tjFK0/TofFrbLa+Vvl+61u5p98uffmtYG1ccv7XkCgYBaBsGoo1N7TdALJbcE59Ndq9aO6YXqdVyIva/HSCrCGRZ/I2CWtDTb1eZVVfD3NT5Fuy8Og64lvBdZMrAqg0HHT4LF7kr0eOAKFg14+t2/u/PspoFQv3s9PcY9iNYiXhaRsYYOXeL9sFFfyU1dldx4BxlDgNyPYtyFGMWzrK9/1QKBgGAljWW/PuY2WDcYNvd/sqJTFytbxY9GVAAnYtHV+nEqPit4lH4HMMcIa4VkKNkJ+fx4ekf+iezktutt4saARI9iQu3cXBy11sYWVg8N/xOsUjwplSlH/DGBu0G2EjtJwGL42UWhjys+Eu7nEhMrppwMMn7w1jxL+5Y5o5upc/HC'),('e6c35e06-7167-4ee2-8bb4-f5bd12e3f42f','c7bf8e01-e2bf-4b76-966c-b209f7bb57e6','priority','100'),('eb353df6-f840-44b5-9928-268a07dbe838','fbbf581f-fb0c-4c8c-9148-7b08ab190dc0','max-clients','200');
/*!40000 ALTER TABLE `COMPONENT_CONFIG` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-02 23:18:11
