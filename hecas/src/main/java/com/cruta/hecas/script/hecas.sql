-- MySQL dump 10.13  Distrib 5.5.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: hecas
-- ------------------------------------------------------
-- Server version	5.5.41-0ubuntu0.14.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `acceso` (
  `idacceso` int(11) NOT NULL AUTO_INCREMENT,
  `formulario` varchar(150) NOT NULL,
  `hora` varchar(10) NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `username` varchar(35) NOT NULL,
  PRIMARY KEY (`idacceso`),
  KEY `username` (`username`),
  KEY `idmunicipio` (`idmunicipio`),
  CONSTRAINT `acceso_ibfk_1` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `acceso_ibfk_2` FOREIGN KEY (`username`) REFERENCES `usuarios` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corregimientos`
--

DROP TABLE IF EXISTS `corregimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corregimientos` (
  `idcorregimiento` int(11) NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  `corregimiento` varchar(60) NOT NULL,
  PRIMARY KEY (`idcorregimiento`),
  KEY `idmunicipio` (`idmunicipio`),
  CONSTRAINT `corregimientos_ibfk_1` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corregimientos`
--

LOCK TABLES `corregimientos` WRITE;
/*!40000 ALTER TABLE `corregimientos` DISABLE KEYS */;
INSERT INTO `corregimientos` VALUES (1,1,'BOCAS DEL TORO CABECERA'),(2,1,'BASTIMENTOS'),(3,1,'CAUCHERO'),(4,1,'PUNTA LAUREL'),(5,1,'TIERRA OSCURA'),(6,2,'CHANGUINOLA (CABECERA)'),(7,2,'ALMIRANTE'),(8,2,'GUABITO'),(9,2,'TERIBE'),(10,2,'VALLE DEL RISCO'),(11,3,'CHIRIQUA GRANDE (CABECERA)'),(12,3,'MIRAMAR'),(13,3,'PUNTA PENA'),(14,3,'PUNTA ROBALO'),(15,3,'RAMBALA'),(16,5,'ANTON (CABECERA)'),(17,5,'CABUYA'),(18,5,'EL CHIRU'),(19,5,'EL RETIRO'),(20,5,'EL VALLE'),(21,5,'JUAN DIAZ'),(22,5,'RIO HATO'),(23,5,'SAN JUAN DE DIOS'),(24,5,'SANTA RITA'),(25,5,'CABALLERO'),(26,6,'LA PINTADA (CABECERA)'),(27,6,'EL HARINO'),(28,6,'EL POTRERO'),(29,6,'LLANO GRANDE'),(30,6,'PIEDRAS GORDAS'),(31,7,'NATA (CABECERA)'),(32,7,'CAPELLANIA'),(33,7,'EL CANO'),(34,7,'GUZMAN'),(35,7,'LAS HUACAS'),(36,7,'TOZA'),(37,8,'OLA (CABECERA)'),(38,8,'EL COPE'),(39,8,'EL PALMAR'),(40,8,'EL PICACHO'),(41,8,'LA PAVA'),(42,9,'PENONOME (CABECERA)'),(43,9,'CANAVERAL'),(44,9,'COCLE '),(46,9,'EL COCO'),(47,9,'PAJONAL'),(48,9,'RIO GRANDE'),(49,9,'RIO INDIO'),(50,9,'TOABRE'),(51,9,'TULE'),(52,10,'NUEVO CHAGRES (CABECERA)'),(53,10,'ACHIOTE'),(54,10,'EL GUABO'),(55,10,'LA ENCANTADA'),(56,10,'PALMAS BELLAS'),(57,10,'PIÃ‘A'),(58,10,'SALUD'),(59,11,'BARRIO NORTE'),(60,11,'BARRIO SUR'),(61,11,'BUENA VISTA'),(62,11,'CATIVA'),(63,11,'CIRICITO'),(64,11,'CRISTOBAL'),(65,11,'ESCOBAL'),(66,11,'LIMON'),(67,11,'NUEVA PROVIDENCIA'),(68,11,'PUERTO PILON'),(69,11,'SABANITAS'),(70,11,'SALAMANCA'),(71,11,'SAN JUAN'),(72,11,'SANTA ROSA'),(73,12,'MIGUEL DE LA BORDA (CABECERA)'),(74,12,'COCLE DEL NORTE'),(75,12,'EL GUASIMO'),(76,12,'GOBEA'),(77,12,'RAO INDIO'),(78,12,'SAN JOSE DEL GENERAL'),(79,13,'PORTOBELO (CABECERA)'),(80,13,'CACIQUE'),(81,13,'GARROTE'),(82,13,'ISLA GRANDE'),(83,13,'MARAA CHIQUITA'),(84,14,'PALENQUE (CABECERA)'),(85,14,'CUANGO'),(86,14,'MIRAMAR'),(87,14,'NOMBRE DE DIOS'),(88,14,'PALMIRA'),(89,14,'PLAYA CHIQUITA'),(90,14,'SANTA ISABEL'),(91,14,'VIENTO FRAO'),(92,15,'ALANJE (CABECERA)'),(93,15,'DIVALA'),(94,15,'EL TEJAR'),(95,15,'GUARUMAL'),(96,15,'PALO GRANDE'),(97,15,'QUEREVALO'),(98,15,'SANTO TOMAS'),(99,16,'PUERTO ARMUELLES (CABECERA)'),(100,16,'LIMONES'),(101,16,'PROGRESO'),(102,16,'BACO'),(103,16,'RODOLFO AGUILAR DELGADO'),(104,17,'BOQUERON (CABECERA)'),(105,17,'BAGALA'),(106,17,'CORDILLERA'),(107,17,'GUABAL'),(108,17,'GUAYABAL'),(109,17,'PARAISO'),(110,17,'PEDREGAL'),(111,17,'TIJERAS'),(112,18,'BAJO BOQUETE (CABECERA)'),(113,18,'CALDERA'),(114,18,'PALMIRA'),(115,18,'ALTO BOQUETE'),(116,18,'JARAMILLO'),(117,18,'LOS NARANJOS'),(118,19,'LA CONCEPCION (CABECERA)'),(119,19,'ASERRAO DE GARICHE'),(120,19,'BUGABA'),(121,19,'CERRO PUNTA'),(122,19,'GOMEZ'),(123,19,'LA ESTRELLA'),(124,19,'SAN ANDRES'),(125,19,'SANTA MARTA'),(126,19,'SANTA ROSA'),(127,19,'SANTO DOMINGO'),(128,19,'SORTOVA'),(129,19,'VOLCAN'),(130,19,'EL BONGO'),(131,20,'DAVID (CABECERA)'),(132,20,'BIJAGUAL'),(133,20,'COCHEA'),(134,20,'CHIRIQUA'),(135,20,'GUACA'),(136,20,'LAS LOMAS'),(137,20,'PEDREGAL'),(138,20,'SAN CARLOS'),(139,20,'SAN PABLO NUEVO'),(140,20,'SAN PABLO VIEJO'),(141,21,'DOLEGA (CABECERA)'),(142,21,'DOS RAOS'),(143,21,'LOS ANASTACIOS'),(144,21,'POTRERILLOS'),(145,21,'POTRERILLOS ABAJO'),(146,21,'ROVIRA'),(147,21,'TINAJAS'),(148,22,'GUALACA (CABECERA)'),(149,22,'HORNITO'),(150,22,'LOS ANGELES'),(151,22,'PAJA DE SOMBRERO'),(152,22,'RINCON'),(153,23,'REMEDIOS (CABECERA)'),(154,23,'EL NANCITO'),(155,23,'EL PORVENIR'),(156,23,'EL PUERTO'),(157,23,'SANTA LUCAA'),(158,24,'RAO SERENO (CABECERA)'),(159,24,'BREÃ‘ON'),(160,24,'CAÃ‘AS GORDAS'),(161,24,'MONTE LIRIO'),(162,24,'PLAZA  DE CAISAN'),(163,24,'SANTA CRUZ'),(164,25,'LA LAJAS (CABECERA)'),(165,25,'JUAY'),(166,25,'LAJAS ADENTRO'),(167,25,'SAN FELIX'),(168,25,'SANTA CRUZ'),(169,26,'HORCONCITOS (CABECERA)'),(170,26,'BOCA CHICA'),(171,26,'BOCA DEL MONTE'),(172,26,'SAN JUAN'),(173,26,'SAN LORENZO'),(174,27,'TOLE (CABECERA)'),(175,27,'BELLA VISTA'),(176,27,'CERRO VIEJO'),(177,27,'EL CRISTO'),(178,27,'JUSTO FIDEL PALACIOS'),(179,27,'LAJAS DE TOLE'),(180,27,'POTRERO DE CANA'),(181,27,'QUEBRADA DE PIEDRA'),(182,27,'VELADERO'),(183,29,'LA PALMA (CABECERA)'),(184,29,'CAMOGANTI'),(185,29,'CHEPIGANA'),(186,29,'GARACHINE'),(187,29,'JAQUE'),(188,29,'PUERTO PIÃ‘A'),(189,29,'RAO CONGO'),(190,29,'RAO IGLESIAS'),(191,29,'SAMBU'),(192,29,'SETEGANTA'),(193,29,'TAIMATA'),(194,29,'TUCUTA'),(195,29,'AGUA FRAA'),(196,29,'CUCUNATA'),(197,29,'RIO CONGO ARRIBA'),(198,29,'SANTA FE'),(199,30,'EL REAL DE SANTA MARAA (CABECERA)'),(200,30,'BOCA DE CUPE'),(201,30,'PAYA'),(202,30,'PINOGANA'),(203,30,'PUCURO'),(204,30,'YAPE'),(205,30,'YAVIZA'),(206,30,'METETA'),(207,30,'COMARCA KUNA DE WARGANDA'),(208,32,'CHITRE (CABECERA)'),(209,32,'LA ARENA'),(210,32,'MONAGRILLO'),(211,32,'LLANO BONITO'),(212,32,'SAN JUAN BAUTISTA'),(213,33,'LAS MINAS (CABECERA)'),(214,33,'CHEPO'),(215,33,'CHUMICAL'),(216,33,'EL TORO'),(217,33,'LEONES'),(218,33,'QUEBRADA DEL ROSARIO'),(219,34,'LOS POZOS (CABECERA)'),(220,34,'EL CAPURI'),(221,34,'EL CALABACITO'),(222,34,'EL CEDRO'),(223,34,'LA ARENA'),(224,34,'LA PITALOSA'),(225,34,'LOS CERRITOS'),(226,34,'LOS CERROS DE PAJA'),(227,35,'OCU (CABECERA)'),(228,35,'CERRO LARGO'),(229,35,'LOS LLANOS'),(230,35,'LLANO GRANDE'),(231,35,'PENAS CHATAS'),(232,35,'EL TIJERA'),(233,36,'PARITA (CABECERA)'),(234,36,'CABUYA'),(235,36,'LOS CASTILLOS'),(236,36,'LLANO DE LA CRUZ'),(237,36,'PARIS'),(238,36,'PORTOBELILLO'),(239,36,'POTUGA'),(240,37,'PESE (CABECERA)'),(241,37,'LAS CABRAS'),(242,37,'EL PAJARO'),(243,37,'EL BARRERO'),(244,37,'EL PEDREGOSO'),(245,37,'EL CIRUELO'),(246,37,'SABANA GRANDE'),(247,37,'RINCON HONDO'),(248,38,'SANTA MARAA (CABECERA)'),(249,38,'CHUPAMPA'),(250,38,'EL RINCON'),(251,38,'EL LIMON'),(252,38,'LOS CANELOS'),(253,39,'GUARARE (CABECERA)'),(254,39,'EL ESPINAL'),(255,39,'EL MACANO'),(256,39,'GUARARE ARRIBA'),(257,39,'LA ENEA'),(258,39,'LA PASERA'),(259,39,'LAS TRANCAS'),(260,39,'LLANO ABAJO'),(261,39,'EL HATO'),(262,39,'PERALES'),(263,40,'LAS TABLAS (CABECERA)'),(264,40,'BAJO CORRAL'),(265,40,'BAYANO'),(266,40,'EL CARATE'),(267,40,'EL COCAL'),(268,40,'EL MANANTIAL'),(269,40,'EL MUNOZ'),(270,40,'EL PEDREGOSO'),(271,40,'LA LAJA'),(272,40,'LA MIEL'),(273,40,'LA PALMA'),(274,40,'LA TIZA'),(275,40,'LAS PALMITAS'),(276,40,'LAS TABLAS ABAJO'),(277,40,'NUARIO'),(278,40,'PALMIRA'),(279,40,'PENA BLANCA'),(280,40,'RAO HONDO'),(281,40,'SAN JOSE'),(282,40,'SAN MIGUEL'),(283,40,'SANTO DOMINGO'),(284,40,'SESTEADERO'),(285,40,'VALLE RICO'),(286,40,'VALLERRIQUITO'),(287,41,'LA VILLA DE LOS SANTOS (CABECERA)'),(288,41,'EL GUASIMO'),(289,41,'LA COLORADA'),(290,41,'LA ESPIGADILLA'),(291,41,'LAS CRUCES'),(292,41,'LAS GUABAS'),(293,41,'LOS ANGELES'),(294,41,'LOS OLIVOS'),(295,41,'LLANO LARGO'),(296,41,'SABANA GRANDE'),(297,41,'SANTA ANA'),(298,41,'TRES QUEBRADAS'),(299,41,'AGUA BUENA'),(300,41,'VILLA LOURDES'),(301,42,'MACARACAS (CABECERA)'),(302,42,'BAHIA HONDA'),(303,42,'BAJOS DE GUERA'),(304,42,'COROZAL'),(305,42,'CHUPA'),(306,42,'EL CEDRO'),(307,42,'ESPINO AMARILLO'),(308,42,'LA MESA'),(309,42,'LAS PALMAS'),(310,42,'LLANO DE PIEDRA'),(311,42,'MOGOLLON'),(312,43,'PEDASI (CABECERA)'),(313,43,'LOS ASIENTOS'),(314,43,'MARIABE'),(315,43,'PURIO'),(316,43,'ORIA ARRIBA'),(317,44,'POCRI (CABECERA)'),(318,44,'EL CAÑAFISTULO'),(319,44,'LAJAMINA'),(320,44,'PARAISO'),(321,44,'PARITILLA'),(322,45,'TONOSI (CABECERA)'),(323,45,'ALTOS DE GIEERA'),(324,45,'CAÑAS'),(325,45,'EL BEBEDERO'),(326,45,'EL CACAO'),(327,45,'EL CORTEZO'),(328,45,'FLORES'),(329,45,'GUANICO'),(330,45,'LA TRONOSA'),(331,45,'CAMBUTAL'),(332,46,'ARRAIJAN (CABECERA)'),(333,46,'JUAN D. AROSEMENA'),(334,46,'NUEVO EMPERADOR'),(335,46,'SANTA CLARA'),(336,46,'VERACRUZ'),(337,46,'VISTA ALEGRE'),(338,47,'SAN MIGUEL (CABECERA)'),(339,47,'LA ENSENADA'),(340,47,'LA ESMERALDA'),(341,47,'LA GUINEA'),(342,47,'PEDRO GONZ?LEZ'),(343,47,'SABOGA'),(357,53,'CHAME (CABECERA)'),(358,53,'BEJUCO'),(359,53,'BUENOS AIRES'),(360,53,'CABUYA'),(361,53,'CHICA'),(362,53,'EL LIBANO'),(363,53,'LAS LAJAS'),(364,53,'NUEVA GORGONA'),(365,53,'PUNTA CHAME'),(366,53,'SAJALICES'),(367,53,'SORA'),(368,54,'CHEPO (CABECERA)'),(369,54,'CAÃ‘ITA'),(370,54,'CHEPILLO'),(371,54,'EL LLANO'),(372,54,'LAS MARGARITAS'),(373,54,'SANTA CRUZ DE CHININA'),(374,54,'COMARCA KUNA DE MADUNGANDA'),(375,54,'TORTA'),(376,55,'CHIMAN (CABECERA)'),(377,55,'BRUJAS'),(378,55,'GONZALO VASQUEZ'),(379,55,'PASIGA'),(380,55,'UNION SANTEÑA'),(381,56,'BARRIO BALBOA'),(382,56,'BARRIO COLON'),(383,56,'AMADOR'),(384,56,'AROSEMENA'),(385,56,'EL ARADO'),(386,56,'EL COCO'),(387,56,'FEUILLET'),(388,56,'GUADALUPE'),(389,56,'HERRERA'),(390,56,'HURTADO'),(391,56,'ITURRALDE'),(392,56,'LA REPRESA'),(393,56,'LOS DAAZ'),(394,56,'MENDOZA'),(395,56,'OBALDAA'),(396,56,'PLAYA LEONA'),(397,56,'PUERTO CAIMITO'),(398,56,'SANTA RITA'),(399,57,'SAN CARLOS (CABECERA)'),(400,57,'EL ESPINO'),(401,57,'EL HIGO'),(402,57,'GUAYABITO'),(403,57,'LA ERMITA'),(404,57,'LA LAGUNA'),(405,57,'LAS UVAS'),(406,57,'LOS LLANITOS'),(407,57,'SAN JOSE'),(408,58,'AMELIA DENIS DE ICAZA'),(409,58,'BELISARIO PORRAS'),(410,58,'JOSE DOMINGO ESPINAR'),(411,58,'MATEO ITURRALDE'),(412,58,'VICTORIANO LORENZO'),(413,58,'ARNULFO ARIAS'),(414,58,'BELISARIO FRAAS'),(415,58,'OMAR TORRIJOS'),(416,58,'RUFINA ALFARO'),(417,59,'TABOGA (CABECERA)'),(418,59,'OTOQUE OCCIDENTE'),(419,59,'OTOQUE ORIENTE'),(420,60,'ATALAYA (CABECERA)'),(421,60,'EL BARRITO'),(422,60,'LA MONTAÃ‘UELA'),(423,60,'LA CARRILLO'),(424,60,'SAN ANTONIO'),(425,61,'CALOBRE (CABECERA)'),(426,61,'BARNIZAL'),(427,61,'CHITRA'),(428,61,'EL COCLA'),(429,61,'EL POTRERO'),(430,61,'LA LAGUNA'),(431,61,'LA RAYA DE CALOBRE'),(432,61,'LA TETILLA'),(433,61,'LA YEGUADA'),(434,61,'LAS GUAAS'),(435,61,'MONJARAS'),(436,61,'SAN JOSE'),(437,62,'CANAZAS (CABECERA)'),(438,62,'CERRO DE PLATA'),(439,62,'EL PICADOR'),(440,62,'LOS VALLES'),(441,62,'SAN JOSE'),(442,62,'SAN MARCELO'),(443,63,'LA MESA (CABECERA)'),(444,63,'BISVALLES'),(445,63,'BORO'),(446,63,'LLANO GRANDE'),(447,63,'SAN BARTOLO'),(448,64,'LAS PALMAS (CABECERA)'),(449,64,'CERRO DE CASA'),(450,64,'COROZAL'),(451,64,'EL MARIA'),(452,64,'EL PRADO'),(453,64,'EL RINCON'),(454,64,'LOLA'),(455,64,'PIXVAE'),(456,64,'PUERTO VIDAL'),(457,64,'SAN MARTAN DE PORRES'),(458,64,'VIGUA'),(459,64,'ZAPOTILLO'),(460,67,'MONTIJO (CABECERA)'),(462,67,'GOBERNADORA'),(463,67,'LA GARCEANA'),(464,67,'LEONES'),(466,67,'PILON'),(469,68,'RIO DE JESUS (CABECERA)'),(470,68,'LAS HUACAS'),(471,68,'LOS CASTILLOS'),(472,68,'UTIRA'),(473,68,'CATORCE DE NOVIEMBRE'),(474,69,'SAN FRANCISCO (CABECERA)'),(475,69,'CORRAL FALSO'),(476,69,'LOS HATILLOS'),(477,69,'REMANCE'),(478,69,'SAN JUAN'),(479,70,'SANTA FE (CABECERA)'),(480,70,'CALOVEBORA'),(481,70,'EL ALTO'),(482,70,'EL CUAY'),(483,70,'EL PANTANO'),(484,70,'GATUNCITO'),(485,70,'RIO LUIS'),(486,71,'SANTIAGO (CABECERA)'),(487,71,'LA COLORADA'),(488,71,'LA PENA'),(489,71,'LA RAYA DE SANTA MARAA'),(490,71,'PONUGA'),(491,71,'SAN PEDRO DEL ESPINO'),(492,71,'CANTO DEL LLANO'),(493,71,'LOS ALGARROBOS'),(494,72,'SONA (CABECERA)'),(495,72,'BAHIA HONDA'),(496,72,'CALIDONIA'),(497,72,'CATIVE'),(498,72,'EL MARANON'),(499,72,'GUARUMAL'),(500,72,'LA SOLEDAD'),(501,72,'QUEBRADA DE ORO'),(502,72,'RAO GRANDE'),(503,72,'RODEO VIEJO'),(520,67,'CEBACO'),(521,67,'COSTA HERMOSA'),(522,67,'UNION DEL NORTE'),(523,66,'LLANO CATIVAL'),(524,66,'ARENAS'),(525,66,'EL CACAO'),(526,66,'QUEBRO'),(527,66,'TEBARIO'),(528,69,'SAN JOSE'),(540,62,'EL AROMILLO'),(541,62,'LAS CRUCES'),(542,63,'LOS MILAGROS'),(550,70,'RUBEN CANTU'),(560,71,'CARLOS SANTA ANA AVILA'),(561,71,'EDWIN FABREGA'),(562,71,'SAN MARTIN PORRES'),(563,71,'URRACA'),(570,45,'ISLA DE CAÑAS'),(580,4,'AGUADULCE'),(581,4,'EL CRISTO'),(582,4,'EL ROBLE'),(583,4,'POCRI'),(584,4,'BARRIOS UNIDOS'),(590,6,'LAS LOMAS'),(600,9,'SOFRE'),(601,9,'CHIGUIRI ARRIBA'),(603,33,'QUEBRADA EL CIPRIAN'),(605,34,'LAS LLANAS'),(607,35,'MENCHACA'),(608,52,'24 DE DICIEMBRE '),(609,52,'ALCALDE DÍAZ '),(610,52,'ANCÓN '),(611,52,'BELLA VISTA '),(612,52,'BETHANIA '),(613,52,'CALIDONIA '),(614,52,'CHILIBRE '),(615,52,'CURUNDÚ '),(616,52,'EL CHORRILLO '),(617,52,'ERNESTO CORDOBA CAMPOS '),(618,52,'JUAN DÍAZ '),(619,52,'LAS CUMBRES '),(620,52,'LAS MAÑANITAS '),(621,52,'PACORA '),(622,52,'PARQUE LEFEVRE '),(623,52,'PEDREGAL '),(624,52,'PUEBLO NUEVO '),(625,52,'RÍO ABAJO '),(626,52,'SAN FELIPE '),(627,52,'SAN FRANCISCO '),(628,52,'SAN MARTÍN '),(629,52,'SANTA ANA '),(630,52,'TOCUMEN');
/*!40000 ALTER TABLE `corregimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `errores`
--

DROP TABLE IF EXISTS `errores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `errores` (
  `iderror` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text NOT NULL,
  `hora` varchar(10) NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  `formulario` varchar(150) NOT NULL,
  `metodo` varchar(150) NOT NULL,
  `fecha` date NOT NULL,
  `username` varchar(35) NOT NULL,
  PRIMARY KEY (`iderror`),
  KEY `idmunicipio` (`idmunicipio`),
  KEY `username` (`username`),
  CONSTRAINT `errores_ibfk_1` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `errores_ibfk_2` FOREIGN KEY (`username`) REFERENCES `usuarios` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `errores`
--

LOCK TABLES `errores` WRITE;
/*!40000 ALTER TABLE `errores` DISABLE KEYS */;
/*!40000 ALTER TABLE `errores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupousuarios`
--

DROP TABLE IF EXISTS `grupousuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupousuarios` (
  `idgrupousuario` varchar(35) NOT NULL,
  `grupousuario` varchar(50) NOT NULL,
  `activo` char(2) DEFAULT NULL,
  PRIMARY KEY (`idgrupousuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupousuarios`
--

LOCK TABLES `grupousuarios` WRITE;
/*!40000 ALTER TABLE `grupousuarios` DISABLE KEYS */;
INSERT INTO `grupousuarios` VALUES ('administrador','Administrador','si'),('alcalde','Alcalde','si'),('auditor','Auditor','si'),('cajera','Cajeros','si'),('contable','Contable','si'),('contribuyente','Contribuyente','si'),('desarrollador','Desarrollador','si'),('Programador','Desarrollador','si'),('tesorero','Tesorero','si'),('we','rwerwer','si'),('weqr','qweeqw','si');
/*!40000 ALTER TABLE `grupousuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historial` (
  `idhistorial` int(11) NOT NULL,
  `data` text NOT NULL,
  `tabla` varchar(80) NOT NULL,
  `username` varchar(35) NOT NULL,
  `fecha` date NOT NULL,
  `hora` varchar(15) NOT NULL,
  `descripcion` text NOT NULL,
  `eliminado` varchar(2) NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  PRIMARY KEY (`idhistorial`),
  KEY `idmunicipio` (`idmunicipio`),
  CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajeria`
--

DROP TABLE IF EXISTS `mensajeria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensajeria` (
  `idmensaje` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `mensaje` text NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  `activo` varchar(2) NOT NULL,
  `fecha` date NOT NULL,
  `username` varchar(35) NOT NULL,
  PRIMARY KEY (`idmensaje`),
  KEY `id` (`id`),
  KEY `idmunicipio` (`idmunicipio`),
  KEY `username` (`username`),
  CONSTRAINT `mensajeria_ibfk_1` FOREIGN KEY (`id`) REFERENCES `identificador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mensajeria_ibfk_2` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mensajeria_ibfk_3` FOREIGN KEY (`username`) REFERENCES `usuarios` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajeria`
--

LOCK TABLES `mensajeria` WRITE;
/*!40000 ALTER TABLE `mensajeria` DISABLE KEYS */;
/*!40000 ALTER TABLE `mensajeria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipios`
--

DROP TABLE IF EXISTS `municipios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipios` (
  `idmunicipio` int(11) NOT NULL,
  `municipio` varchar(60) NOT NULL,
  `idprovincia` int(11) NOT NULL,
  `activo` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`idmunicipio`),
  KEY `fk_municipios_provincias` (`idprovincia`),
  CONSTRAINT `municipios_ibfk_1` FOREIGN KEY (`idprovincia`) REFERENCES `provincias` (`idprovincia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipios`
--

LOCK TABLES `municipios` WRITE;
/*!40000 ALTER TABLE `municipios` DISABLE KEYS */;
INSERT INTO `municipios` VALUES (1,'BOCAS DEL TORO  ',1,NULL),(2,'CHANGUINOLA',1,NULL),(3,'CHIRIQUAGRANDE',1,NULL),(4,'AGUADULCE',2,NULL),(5,'ANTON',2,NULL),(6,'LA PINTADA',2,NULL),(7,'NATA',2,NULL),(8,'OLA',2,NULL),(9,'PENONOME',2,NULL),(10,'CHAGRES',3,NULL),(11,'COLON',3,NULL),(12,'DONOSO',3,NULL),(13,'PORTOBELO',3,NULL),(14,'SANTA ISABEL',3,NULL),(15,'ALANJE',4,NULL),(16,'BARU',4,NULL),(17,'BOQUERON',4,NULL),(18,'BOQUETE',4,NULL),(19,'BUGABA',4,NULL),(20,'DAVID',4,NULL),(21,'DOLEGA',4,NULL),(22,'GUALACA',4,NULL),(23,'REMEDIOS',4,NULL),(24,'RENACIMIENTO',4,NULL),(25,'SAN FELIX',4,NULL),(26,'SAN LORENZO',4,NULL),(27,'TOLE',4,NULL),(28,'CEMACO',5,NULL),(29,'CHEPIGANA',5,NULL),(30,'PINOGANA',5,NULL),(31,'SAMBU',5,NULL),(32,'CHITRE',6,NULL),(33,'LAS MINAS',6,NULL),(34,'LOS POZOS',6,NULL),(35,'OCU',6,NULL),(36,'PARITA',6,NULL),(37,'PESE',6,NULL),(38,'SANTA MARIA',6,NULL),(39,'GUARARE',7,NULL),(40,'LAS TABLAS',7,NULL),(41,'LOS SANTOS',7,NULL),(42,'MACARACAS',7,NULL),(43,'PEDASI',7,NULL),(44,'POCRI',7,NULL),(45,'TONOSI',7,NULL),(46,'ARRAIJAN',8,NULL),(47,'BALBOA',8,NULL),(52,'PANAMA',8,NULL),(53,'CHAME',8,NULL),(54,'CHEPO',8,NULL),(55,'CHIMAN',8,NULL),(56,'LA CHORRERA',8,NULL),(57,'SAN CARLOS',8,NULL),(58,'SAN MIGUELITO',8,NULL),(59,'TABOGA',8,NULL),(60,'ATALAYA',9,NULL),(61,'CALOBRE',9,NULL),(62,'CAÑAZAS',9,NULL),(63,'LA MESA',9,NULL),(64,'LAS PALMAS',9,NULL),(66,'MARIATO',9,NULL),(67,'MONTIJO',9,NULL),(68,'RIO DE JESUS',9,NULL),(69,'SAN FRANCISCO',9,NULL),(70,'SANTA FE',9,NULL),(71,'SANTIAGO',9,NULL),(72,'SONA',9,NULL);
/*!40000 ALTER TABLE `municipios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `idprovincia` int(11) NOT NULL,
  `provincia` varchar(255) NOT NULL DEFAULT '',
  `activo` varchar(2) DEFAULT 'si',
  PRIMARY KEY (`idprovincia`),
  UNIQUE KEY `provincia` (`provincia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Bocas del toro','si'),(2,'Cocle','si'),(3,'Colon','si'),(4,'Chiriqui','si'),(5,'Darien','si'),(6,'Herrera','si'),(7,'Los Santos','si'),(8,'Panama ','si'),(9,'Veraguas','si');
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `username` varchar(35) NOT NULL,
  `password` varchar(200) NOT NULL DEFAULT '',
  `nombre` varchar(60) NOT NULL,
  `email` varchar(80) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `tema` varchar(70) NOT NULL,
  `activo` char(2) DEFAULT NULL,
  `idgrupousuario` varchar(35) NOT NULL DEFAULT 'guest',
  `cedula` varchar(35) NOT NULL,
  `idmunicipio` int(11) NOT NULL,
  PRIMARY KEY (`username`),
  KEY `idgrupousuario` (`idgrupousuario`),
  KEY `idmunicipio` (`idmunicipio`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`idgrupousuario`) REFERENCES `grupousuarios` (`idgrupousuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuarios_ibfk_2` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES ('avbravo','denver','aristides villarreal bravo','avbravo@gmail.com','966-6278','671-27429','aristo','si','administrador','7-7-7',41);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-04 16:31:25
