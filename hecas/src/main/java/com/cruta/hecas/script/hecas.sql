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
  PRIMARY KEY (`idacceso`),
  KEY `idmunicipio` (`idmunicipio`),
  CONSTRAINT `acceso_ibfk_1` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `alertas`
--

DROP TABLE IF EXISTS `alertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alertas` (
  `idalerta` int(11) NOT NULL,
  `nombrecultivo` varchar(80) NOT NULL,
  `nombreplaga` varchar(45) NOT NULL,
  `descripcion` text,
  `gradoafectacion` varchar(45) DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` varchar(45) DEFAULT NULL,
  `porcentajeafectacion` double DEFAULT NULL,
  `etapadelcultivo` varchar(45) DEFAULT NULL,
  `flor` varchar(2) DEFAULT NULL,
  `tallo` varchar(2) DEFAULT NULL,
  `hoja` varchar(2) DEFAULT NULL,
  `fruto` varchar(2) DEFAULT NULL,
  `raices` varchar(2) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  PRIMARY KEY (`idalerta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alertas`
--

LOCK TABLES `alertas` WRITE;
/*!40000 ALTER TABLE `alertas` DISABLE KEYS */;
/*!40000 ALTER TABLE `alertas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alertascomentarios`
--

DROP TABLE IF EXISTS `alertascomentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alertascomentarios` (
  `idalertascomentarios` int(11) NOT NULL,
  `idalerta` int(11) NOT NULL,
  `email` varchar(80) NOT NULL,
  `comentario` text NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idalertascomentarios`),
  KEY `fk_alertascomentarios_1_idx` (`idalerta`),
  KEY `fk_alertascomentarios_2_idx` (`email`),
  CONSTRAINT `fk_alertascomentarios_1` FOREIGN KEY (`idalerta`) REFERENCES `alertas` (`idalerta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_alertascomentarios_2` FOREIGN KEY (`email`) REFERENCES `usuarios` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alertascomentarios`
--

LOCK TABLES `alertascomentarios` WRITE;
/*!40000 ALTER TABLE `alertascomentarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `alertascomentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alertasfotos`
--

DROP TABLE IF EXISTS `alertasfotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alertasfotos` (
  `idalertasfotos` int(11) NOT NULL,
  `idalerta` int(11) DEFAULT NULL,
  `foto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idalertasfotos`),
  KEY `fk_alertasfotos_1_idx` (`idalerta`),
  CONSTRAINT `fk_alertasfotos_1` FOREIGN KEY (`idalerta`) REFERENCES `alertas` (`idalerta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alertasfotos`
--

LOCK TABLES `alertasfotos` WRITE;
/*!40000 ALTER TABLE `alertasfotos` DISABLE KEYS */;
/*!40000 ALTER TABLE `alertasfotos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuraralertas`
--

DROP TABLE IF EXISTS `configuraralertas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuraralertas` (
  `email` varchar(80) NOT NULL,
  `frecuencia` varchar(45) DEFAULT NULL,
  `nombreplaga` varchar(80) DEFAULT NULL,
  `nombrecultivo` varchar(80) DEFAULT NULL,
  `twitter` varchar(80) DEFAULT NULL,
  `facebook` varchar(80) DEFAULT NULL,
  `instagram` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`email`),
  CONSTRAINT `fk_configuraralertas_1` FOREIGN KEY (`email`) REFERENCES `usuarios` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuraralertas`
--

LOCK TABLES `configuraralertas` WRITE;
/*!40000 ALTER TABLE `configuraralertas` DISABLE KEYS */;
/*!40000 ALTER TABLE `configuraralertas` ENABLE KEYS */;
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
  `latitud` int(11) DEFAULT NULL,
  `longitud` int(11) DEFAULT NULL,
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
INSERT INTO `corregimientos` VALUES (1,1,'BOCAS DEL TORO CABECERA',0,0),(2,1,'BASTIMENTOS',0,0),(3,1,'CAUCHERO',0,0),(4,1,'PUNTA LAUREL',0,0),(5,1,'TIERRA OSCURA',0,0),(6,2,'CHANGUINOLA (CABECERA)',0,0),(7,2,'ALMIRANTE',0,0),(8,2,'GUABITO',0,0),(9,2,'TERIBE',0,0),(10,2,'VALLE DEL RISCO',0,0),(11,3,'CHIRIQUA GRANDE (CABECERA)',0,0),(12,3,'MIRAMAR',0,0),(13,3,'PUNTA PENA',0,0),(14,3,'PUNTA ROBALO',0,0),(15,3,'RAMBALA',0,0),(16,5,'ANTON (CABECERA)',0,0),(17,5,'CABUYA',0,0),(18,5,'EL CHIRU',0,0),(19,5,'EL RETIRO',0,0),(20,5,'EL VALLE',0,0),(21,5,'JUAN DIAZ',0,0),(22,5,'RIO HATO',0,0),(23,5,'SAN JUAN DE DIOS',0,0),(24,5,'SANTA RITA',0,0),(25,5,'CABALLERO',0,0),(26,6,'LA PINTADA (CABECERA)',0,0),(27,6,'EL HARINO',0,0),(28,6,'EL POTRERO',0,0),(29,6,'LLANO GRANDE',0,0),(30,6,'PIEDRAS GORDAS',0,0),(31,7,'NATA (CABECERA)',0,0),(32,7,'CAPELLANIA',0,0),(33,7,'EL CANO',0,0),(34,7,'GUZMAN',0,0),(35,7,'LAS HUACAS',0,0),(36,7,'TOZA',0,0),(37,8,'OLA (CABECERA)',0,0),(38,8,'EL COPE',0,0),(39,8,'EL PALMAR',0,0),(40,8,'EL PICACHO',0,0),(41,8,'LA PAVA',0,0),(42,9,'PENONOME (CABECERA)',0,0),(43,9,'CANAVERAL',0,0),(44,9,'COCLE ',0,0),(46,9,'EL COCO',0,0),(47,9,'PAJONAL',0,0),(48,9,'RIO GRANDE',0,0),(49,9,'RIO INDIO',0,0),(50,9,'TOABRE',0,0),(51,9,'TULE',0,0),(52,10,'NUEVO CHAGRES (CABECERA)',0,0),(53,10,'ACHIOTE',0,0),(54,10,'EL GUABO',0,0),(55,10,'LA ENCANTADA',0,0),(56,10,'PALMAS BELLAS',0,0),(57,10,'PIÃ‘A',0,0),(58,10,'SALUD',0,0),(59,11,'BARRIO NORTE',0,0),(60,11,'BARRIO SUR',0,0),(61,11,'BUENA VISTA',0,0),(62,11,'CATIVA',0,0),(63,11,'CIRICITO',0,0),(64,11,'CRISTOBAL',0,0),(65,11,'ESCOBAL',0,0),(66,11,'LIMON',0,0),(67,11,'NUEVA PROVIDENCIA',0,0),(68,11,'PUERTO PILON',0,0),(69,11,'SABANITAS',0,0),(70,11,'SALAMANCA',0,0),(71,11,'SAN JUAN',0,0),(72,11,'SANTA ROSA',0,0),(73,12,'MIGUEL DE LA BORDA (CABECERA)',0,0),(74,12,'COCLE DEL NORTE',0,0),(75,12,'EL GUASIMO',0,0),(76,12,'GOBEA',0,0),(77,12,'RAO INDIO',0,0),(78,12,'SAN JOSE DEL GENERAL',0,0),(79,13,'PORTOBELO (CABECERA)',0,0),(80,13,'CACIQUE',0,0),(81,13,'GARROTE',0,0),(82,13,'ISLA GRANDE',0,0),(83,13,'MARAA CHIQUITA',0,0),(84,14,'PALENQUE (CABECERA)',0,0),(85,14,'CUANGO',0,0),(86,14,'MIRAMAR',0,0),(87,14,'NOMBRE DE DIOS',0,0),(88,14,'PALMIRA',0,0),(89,14,'PLAYA CHIQUITA',0,0),(90,14,'SANTA ISABEL',0,0),(91,14,'VIENTO FRAO',0,0),(92,15,'ALANJE (CABECERA)',0,0),(93,15,'DIVALA',0,0),(94,15,'EL TEJAR',0,0),(95,15,'GUARUMAL',0,0),(96,15,'PALO GRANDE',0,0),(97,15,'QUEREVALO',0,0),(98,15,'SANTO TOMAS',0,0),(99,16,'PUERTO ARMUELLES (CABECERA)',0,0),(100,16,'LIMONES',0,0),(101,16,'PROGRESO',0,0),(102,16,'BACO',0,0),(103,16,'RODOLFO AGUILAR DELGADO',0,0),(104,17,'BOQUERON (CABECERA)',0,0),(105,17,'BAGALA',0,0),(106,17,'CORDILLERA',0,0),(107,17,'GUABAL',0,0),(108,17,'GUAYABAL',0,0),(109,17,'PARAISO',0,0),(110,17,'PEDREGAL',0,0),(111,17,'TIJERAS',0,0),(112,18,'BAJO BOQUETE (CABECERA)',0,0),(113,18,'CALDERA',0,0),(114,18,'PALMIRA',0,0),(115,18,'ALTO BOQUETE',0,0),(116,18,'JARAMILLO',0,0),(117,18,'LOS NARANJOS',0,0),(118,19,'LA CONCEPCION (CABECERA)',0,0),(119,19,'ASERRAO DE GARICHE',0,0),(120,19,'BUGABA',0,0),(121,19,'CERRO PUNTA',0,0),(122,19,'GOMEZ',0,0),(123,19,'LA ESTRELLA',0,0),(124,19,'SAN ANDRES',0,0),(125,19,'SANTA MARTA',0,0),(126,19,'SANTA ROSA',0,0),(127,19,'SANTO DOMINGO',0,0),(128,19,'SORTOVA',0,0),(129,19,'VOLCAN',0,0),(130,19,'EL BONGO',0,0),(131,20,'DAVID (CABECERA)',0,0),(132,20,'BIJAGUAL',0,0),(133,20,'COCHEA',0,0),(134,20,'CHIRIQUA',0,0),(135,20,'GUACA',0,0),(136,20,'LAS LOMAS',0,0),(137,20,'PEDREGAL',0,0),(138,20,'SAN CARLOS',0,0),(139,20,'SAN PABLO NUEVO',0,0),(140,20,'SAN PABLO VIEJO',0,0),(141,21,'DOLEGA (CABECERA)',0,0),(142,21,'DOS RAOS',0,0),(143,21,'LOS ANASTACIOS',0,0),(144,21,'POTRERILLOS',0,0),(145,21,'POTRERILLOS ABAJO',0,0),(146,21,'ROVIRA',0,0),(147,21,'TINAJAS',0,0),(148,22,'GUALACA (CABECERA)',0,0),(149,22,'HORNITO',0,0),(150,22,'LOS ANGELES',0,0),(151,22,'PAJA DE SOMBRERO',0,0),(152,22,'RINCON',0,0),(153,23,'REMEDIOS (CABECERA)',0,0),(154,23,'EL NANCITO',0,0),(155,23,'EL PORVENIR',0,0),(156,23,'EL PUERTO',0,0),(157,23,'SANTA LUCAA',0,0),(158,24,'RAO SERENO (CABECERA)',0,0),(159,24,'BREÃ‘ON',0,0),(160,24,'CAÃ‘AS GORDAS',0,0),(161,24,'MONTE LIRIO',0,0),(162,24,'PLAZA  DE CAISAN',0,0),(163,24,'SANTA CRUZ',0,0),(164,25,'LA LAJAS (CABECERA)',0,0),(165,25,'JUAY',0,0),(166,25,'LAJAS ADENTRO',0,0),(167,25,'SAN FELIX',0,0),(168,25,'SANTA CRUZ',0,0),(169,26,'HORCONCITOS (CABECERA)',0,0),(170,26,'BOCA CHICA',0,0),(171,26,'BOCA DEL MONTE',0,0),(172,26,'SAN JUAN',0,0),(173,26,'SAN LORENZO',0,0),(174,27,'TOLE (CABECERA)',0,0),(175,27,'BELLA VISTA',0,0),(176,27,'CERRO VIEJO',0,0),(177,27,'EL CRISTO',0,0),(178,27,'JUSTO FIDEL PALACIOS',0,0),(179,27,'LAJAS DE TOLE',0,0),(180,27,'POTRERO DE CANA',0,0),(181,27,'QUEBRADA DE PIEDRA',0,0),(182,27,'VELADERO',0,0),(183,29,'LA PALMA (CABECERA)',0,0),(184,29,'CAMOGANTI',0,0),(185,29,'CHEPIGANA',0,0),(186,29,'GARACHINE',0,0),(187,29,'JAQUE',0,0),(188,29,'PUERTO PIÃ‘A',0,0),(189,29,'RAO CONGO',0,0),(190,29,'RAO IGLESIAS',0,0),(191,29,'SAMBU',0,0),(192,29,'SETEGANTA',0,0),(193,29,'TAIMATA',0,0),(194,29,'TUCUTA',0,0),(195,29,'AGUA FRAA',0,0),(196,29,'CUCUNATA',0,0),(197,29,'RIO CONGO ARRIBA',0,0),(198,29,'SANTA FE',0,0),(199,30,'EL REAL DE SANTA MARAA (CABECERA)',0,0),(200,30,'BOCA DE CUPE',0,0),(201,30,'PAYA',0,0),(202,30,'PINOGANA',0,0),(203,30,'PUCURO',0,0),(204,30,'YAPE',0,0),(205,30,'YAVIZA',0,0),(206,30,'METETA',0,0),(207,30,'COMARCA KUNA DE WARGANDA',0,0),(208,32,'CHITRE (CABECERA)',0,0),(209,32,'LA ARENA',0,0),(210,32,'MONAGRILLO',0,0),(211,32,'LLANO BONITO',0,0),(212,32,'SAN JUAN BAUTISTA',0,0),(213,33,'LAS MINAS (CABECERA)',0,0),(214,33,'CHEPO',0,0),(215,33,'CHUMICAL',0,0),(216,33,'EL TORO',0,0),(217,33,'LEONES',0,0),(218,33,'QUEBRADA DEL ROSARIO',0,0),(219,34,'LOS POZOS (CABECERA)',0,0),(220,34,'EL CAPURI',0,0),(221,34,'EL CALABACITO',0,0),(222,34,'EL CEDRO',0,0),(223,34,'LA ARENA',0,0),(224,34,'LA PITALOSA',0,0),(225,34,'LOS CERRITOS',0,0),(226,34,'LOS CERROS DE PAJA',0,0),(227,35,'OCU (CABECERA)',0,0),(228,35,'CERRO LARGO',0,0),(229,35,'LOS LLANOS',0,0),(230,35,'LLANO GRANDE',0,0),(231,35,'PENAS CHATAS',0,0),(232,35,'EL TIJERA',0,0),(233,36,'PARITA (CABECERA)',0,0),(234,36,'CABUYA',0,0),(235,36,'LOS CASTILLOS',0,0),(236,36,'LLANO DE LA CRUZ',0,0),(237,36,'PARIS',0,0),(238,36,'PORTOBELILLO',0,0),(239,36,'POTUGA',0,0),(240,37,'PESE (CABECERA)',0,0),(241,37,'LAS CABRAS',0,0),(242,37,'EL PAJARO',0,0),(243,37,'EL BARRERO',0,0),(244,37,'EL PEDREGOSO',0,0),(245,37,'EL CIRUELO',0,0),(246,37,'SABANA GRANDE',0,0),(247,37,'RINCON HONDO',0,0),(248,38,'SANTA MARAA (CABECERA)',0,0),(249,38,'CHUPAMPA',0,0),(250,38,'EL RINCON',0,0),(251,38,'EL LIMON',0,0),(252,38,'LOS CANELOS',0,0),(253,39,'GUARARE (CABECERA)',0,0),(254,39,'EL ESPINAL',0,0),(255,39,'EL MACANO',0,0),(256,39,'GUARARE ARRIBA',0,0),(257,39,'LA ENEA',0,0),(258,39,'LA PASERA',0,0),(259,39,'LAS TRANCAS',0,0),(260,39,'LLANO ABAJO',0,0),(261,39,'EL HATO',0,0),(262,39,'PERALES',0,0),(263,40,'LAS TABLAS (CABECERA)',0,0),(264,40,'BAJO CORRAL',0,0),(265,40,'BAYANO',0,0),(266,40,'EL CARATE',0,0),(267,40,'EL COCAL',0,0),(268,40,'EL MANANTIAL',0,0),(269,40,'EL MUNOZ',0,0),(270,40,'EL PEDREGOSO',0,0),(271,40,'LA LAJA',0,0),(272,40,'LA MIEL',0,0),(273,40,'LA PALMA',0,0),(274,40,'LA TIZA',0,0),(275,40,'LAS PALMITAS',0,0),(276,40,'LAS TABLAS ABAJO',0,0),(277,40,'NUARIO',0,0),(278,40,'PALMIRA',0,0),(279,40,'PENA BLANCA',0,0),(280,40,'RAO HONDO',0,0),(281,40,'SAN JOSE',0,0),(282,40,'SAN MIGUEL',0,0),(283,40,'SANTO DOMINGO',0,0),(284,40,'SESTEADERO',0,0),(285,40,'VALLE RICO',0,0),(286,40,'VALLERRIQUITO',0,0),(287,41,'LA VILLA DE LOS SANTOS (CABECERA)',0,0),(288,41,'EL GUASIMO',0,0),(289,41,'LA COLORADA',0,0),(290,41,'LA ESPIGADILLA',0,0),(291,41,'LAS CRUCES',0,0),(292,41,'LAS GUABAS',0,0),(293,41,'LOS ANGELES',0,0),(294,41,'LOS OLIVOS',0,0),(295,41,'LLANO LARGO',0,0),(296,41,'SABANA GRANDE',0,0),(297,41,'SANTA ANA',0,0),(298,41,'TRES QUEBRADAS',0,0),(299,41,'AGUA BUENA',0,0),(300,41,'VILLA LOURDES',0,0),(301,42,'MACARACAS (CABECERA)',0,0),(302,42,'BAHIA HONDA',0,0),(303,42,'BAJOS DE GUERA',0,0),(304,42,'COROZAL',0,0),(305,42,'CHUPA',0,0),(306,42,'EL CEDRO',0,0),(307,42,'ESPINO AMARILLO',0,0),(308,42,'LA MESA',0,0),(309,42,'LAS PALMAS',0,0),(310,42,'LLANO DE PIEDRA',0,0),(311,42,'MOGOLLON',0,0),(312,43,'PEDASI (CABECERA)',0,0),(313,43,'LOS ASIENTOS',0,0),(314,43,'MARIABE',0,0),(315,43,'PURIO',0,0),(316,43,'ORIA ARRIBA',0,0),(317,44,'POCRI (CABECERA)',0,0),(318,44,'EL CAÑAFISTULO',0,0),(319,44,'LAJAMINA',0,0),(320,44,'PARAISO',0,0),(321,44,'PARITILLA',0,0),(322,45,'TONOSI (CABECERA)',0,0),(323,45,'ALTOS DE GIEERA',0,0),(324,45,'CAÑAS',0,0),(325,45,'EL BEBEDERO',0,0),(326,45,'EL CACAO',0,0),(327,45,'EL CORTEZO',0,0),(328,45,'FLORES',0,0),(329,45,'GUANICO',0,0),(330,45,'LA TRONOSA',0,0),(331,45,'CAMBUTAL',0,0),(332,46,'ARRAIJAN (CABECERA)',0,0),(333,46,'JUAN D. AROSEMENA',0,0),(334,46,'NUEVO EMPERADOR',0,0),(335,46,'SANTA CLARA',0,0),(336,46,'VERACRUZ',0,0),(337,46,'VISTA ALEGRE',0,0),(338,47,'SAN MIGUEL (CABECERA)',0,0),(339,47,'LA ENSENADA',0,0),(340,47,'LA ESMERALDA',0,0),(341,47,'LA GUINEA',0,0),(342,47,'PEDRO GONZ?LEZ',0,0),(343,47,'SABOGA',0,0),(357,53,'CHAME (CABECERA)',0,0),(358,53,'BEJUCO',0,0),(359,53,'BUENOS AIRES',0,0),(360,53,'CABUYA',0,0),(361,53,'CHICA',0,0),(362,53,'EL LIBANO',0,0),(363,53,'LAS LAJAS',0,0),(364,53,'NUEVA GORGONA',0,0),(365,53,'PUNTA CHAME',0,0),(366,53,'SAJALICES',0,0),(367,53,'SORA',0,0),(368,54,'CHEPO (CABECERA)',0,0),(369,54,'CAÃ‘ITA',0,0),(370,54,'CHEPILLO',0,0),(371,54,'EL LLANO',0,0),(372,54,'LAS MARGARITAS',0,0),(373,54,'SANTA CRUZ DE CHININA',0,0),(374,54,'COMARCA KUNA DE MADUNGANDA',0,0),(375,54,'TORTA',0,0),(376,55,'CHIMAN (CABECERA)',0,0),(377,55,'BRUJAS',0,0),(378,55,'GONZALO VASQUEZ',0,0),(379,55,'PASIGA',0,0),(380,55,'UNION SANTEÑA',0,0),(381,56,'BARRIO BALBOA',0,0),(382,56,'BARRIO COLON',0,0),(383,56,'AMADOR',0,0),(384,56,'AROSEMENA',0,0),(385,56,'EL ARADO',0,0),(386,56,'EL COCO',0,0),(387,56,'FEUILLET',0,0),(388,56,'GUADALUPE',0,0),(389,56,'HERRERA',0,0),(390,56,'HURTADO',0,0),(391,56,'ITURRALDE',0,0),(392,56,'LA REPRESA',0,0),(393,56,'LOS DAAZ',0,0),(394,56,'MENDOZA',0,0),(395,56,'OBALDAA',0,0),(396,56,'PLAYA LEONA',0,0),(397,56,'PUERTO CAIMITO',0,0),(398,56,'SANTA RITA',0,0),(399,57,'SAN CARLOS (CABECERA)',0,0),(400,57,'EL ESPINO',0,0),(401,57,'EL HIGO',0,0),(402,57,'GUAYABITO',0,0),(403,57,'LA ERMITA',0,0),(404,57,'LA LAGUNA',0,0),(405,57,'LAS UVAS',0,0),(406,57,'LOS LLANITOS',0,0),(407,57,'SAN JOSE',0,0),(408,58,'AMELIA DENIS DE ICAZA',0,0),(409,58,'BELISARIO PORRAS',0,0),(410,58,'JOSE DOMINGO ESPINAR',0,0),(411,58,'MATEO ITURRALDE',0,0),(412,58,'VICTORIANO LORENZO',0,0),(413,58,'ARNULFO ARIAS',0,0),(414,58,'BELISARIO FRAAS',0,0),(415,58,'OMAR TORRIJOS',0,0),(416,58,'RUFINA ALFARO',0,0),(417,59,'TABOGA (CABECERA)',0,0),(418,59,'OTOQUE OCCIDENTE',0,0),(419,59,'OTOQUE ORIENTE',0,0),(420,60,'ATALAYA (CABECERA)',0,0),(421,60,'EL BARRITO',0,0),(422,60,'LA MONTAÃ‘UELA',0,0),(423,60,'LA CARRILLO',0,0),(424,60,'SAN ANTONIO',0,0),(425,61,'CALOBRE (CABECERA)',0,0),(426,61,'BARNIZAL',0,0),(427,61,'CHITRA',0,0),(428,61,'EL COCLA',0,0),(429,61,'EL POTRERO',0,0),(430,61,'LA LAGUNA',0,0),(431,61,'LA RAYA DE CALOBRE',0,0),(432,61,'LA TETILLA',0,0),(433,61,'LA YEGUADA',0,0),(434,61,'LAS GUAAS',0,0),(435,61,'MONJARAS',0,0),(436,61,'SAN JOSE',0,0),(437,62,'CANAZAS (CABECERA)',0,0),(438,62,'CERRO DE PLATA',0,0),(439,62,'EL PICADOR',0,0),(440,62,'LOS VALLES',0,0),(441,62,'SAN JOSE',0,0),(442,62,'SAN MARCELO',0,0),(443,63,'LA MESA (CABECERA)',0,0),(444,63,'BISVALLES',0,0),(445,63,'BORO',0,0),(446,63,'LLANO GRANDE',0,0),(447,63,'SAN BARTOLO',0,0),(448,64,'LAS PALMAS (CABECERA)',0,0),(449,64,'CERRO DE CASA',0,0),(450,64,'COROZAL',0,0),(451,64,'EL MARIA',0,0),(452,64,'EL PRADO',0,0),(453,64,'EL RINCON',0,0),(454,64,'LOLA',0,0),(455,64,'PIXVAE',0,0),(456,64,'PUERTO VIDAL',0,0),(457,64,'SAN MARTAN DE PORRES',0,0),(458,64,'VIGUA',0,0),(459,64,'ZAPOTILLO',0,0),(460,67,'MONTIJO (CABECERA)',0,0),(462,67,'GOBERNADORA',0,0),(463,67,'LA GARCEANA',0,0),(464,67,'LEONES',0,0),(466,67,'PILON',0,0),(469,68,'RIO DE JESUS (CABECERA)',0,0),(470,68,'LAS HUACAS',0,0),(471,68,'LOS CASTILLOS',0,0),(472,68,'UTIRA',0,0),(473,68,'CATORCE DE NOVIEMBRE',0,0),(474,69,'SAN FRANCISCO (CABECERA)',0,0),(475,69,'CORRAL FALSO',0,0),(476,69,'LOS HATILLOS',0,0),(477,69,'REMANCE',0,0),(478,69,'SAN JUAN',0,0),(479,70,'SANTA FE (CABECERA)',0,0),(480,70,'CALOVEBORA',0,0),(481,70,'EL ALTO',0,0),(482,70,'EL CUAY',0,0),(483,70,'EL PANTANO',0,0),(484,70,'GATUNCITO',0,0),(485,70,'RIO LUIS',0,0),(486,71,'SANTIAGO (CABECERA)',0,0),(487,71,'LA COLORADA',0,0),(488,71,'LA PENA',0,0),(489,71,'LA RAYA DE SANTA MARAA',0,0),(490,71,'PONUGA',0,0),(491,71,'SAN PEDRO DEL ESPINO',0,0),(492,71,'CANTO DEL LLANO',0,0),(493,71,'LOS ALGARROBOS',0,0),(494,72,'SONA (CABECERA)',0,0),(495,72,'BAHIA HONDA',0,0),(496,72,'CALIDONIA',0,0),(497,72,'CATIVE',0,0),(498,72,'EL MARANON',0,0),(499,72,'GUARUMAL',0,0),(500,72,'LA SOLEDAD',0,0),(501,72,'QUEBRADA DE ORO',0,0),(502,72,'RAO GRANDE',0,0),(503,72,'RODEO VIEJO',0,0),(520,67,'CEBACO',0,0),(521,67,'COSTA HERMOSA',0,0),(522,67,'UNION DEL NORTE',0,0),(523,66,'LLANO CATIVAL',0,0),(524,66,'ARENAS',0,0),(525,66,'EL CACAO',0,0),(526,66,'QUEBRO',0,0),(527,66,'TEBARIO',0,0),(528,69,'SAN JOSE',0,0),(540,62,'EL AROMILLO',0,0),(541,62,'LAS CRUCES',0,0),(542,63,'LOS MILAGROS',0,0),(550,70,'RUBEN CANTU',0,0),(560,71,'CARLOS SANTA ANA AVILA',0,0),(561,71,'EDWIN FABREGA',0,0),(562,71,'SAN MARTIN PORRES',0,0),(563,71,'URRACA',0,0),(570,45,'ISLA DE CAÑAS',0,0),(580,4,'AGUADULCE',0,0),(581,4,'EL CRISTO',0,0),(582,4,'EL ROBLE',0,0),(583,4,'POCRI',0,0),(584,4,'BARRIOS UNIDOS',0,0),(590,6,'LAS LOMAS',0,0),(600,9,'SOFRE',0,0),(601,9,'CHIGUIRI ARRIBA',0,0),(603,33,'QUEBRADA EL CIPRIAN',0,0),(605,34,'LAS LLANAS',0,0),(607,35,'MENCHACA',0,0),(608,52,'24 DE DICIEMBRE ',0,0),(609,52,'ALCALDE DÍAZ ',0,0),(610,52,'ANCÓN ',0,0),(611,52,'BELLA VISTA ',0,0),(612,52,'BETHANIA ',0,0),(613,52,'CALIDONIA ',0,0),(614,52,'CHILIBRE ',0,0),(615,52,'CURUNDÚ ',0,0),(616,52,'EL CHORRILLO ',0,0),(617,52,'ERNESTO CORDOBA CAMPOS ',0,0),(618,52,'JUAN DÍAZ ',0,0),(619,52,'LAS CUMBRES ',0,0),(620,52,'LAS MAÑANITAS ',0,0),(621,52,'PACORA ',0,0),(622,52,'PARQUE LEFEVRE ',0,0),(623,52,'PEDREGAL ',0,0),(624,52,'PUEBLO NUEVO ',0,0),(625,52,'RÍO ABAJO ',0,0),(626,52,'SAN FELIPE ',0,0),(627,52,'SAN FRANCISCO ',0,0),(628,52,'SAN MARTÍN ',0,0),(629,52,'SANTA ANA ',0,0),(630,52,'TOCUMEN',0,0);
/*!40000 ALTER TABLE `corregimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cultivos`
--

DROP TABLE IF EXISTS `cultivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cultivos` (
  `nombrecultivo` varchar(80) NOT NULL,
  `nombrecientifico` varchar(100) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `foto` varchar(200) DEFAULT NULL,
  `familia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`nombrecultivo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cultivos`
--

LOCK TABLES `cultivos` WRITE;
/*!40000 ALTER TABLE `cultivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `cultivos` ENABLE KEYS */;
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
  PRIMARY KEY (`idmensaje`),
  KEY `id` (`id`),
  KEY `idmunicipio` (`idmunicipio`),
  CONSTRAINT `mensajeria_ibfk_1` FOREIGN KEY (`id`) REFERENCES `identificador` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `mensajeria_ibfk_2` FOREIGN KEY (`idmunicipio`) REFERENCES `municipios` (`idmunicipio`) ON DELETE CASCADE ON UPDATE CASCADE
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
-- Table structure for table `miscultivos`
--

DROP TABLE IF EXISTS `miscultivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miscultivos` (
  `idmiscultivos` int(11) NOT NULL,
  `nombrecultivo` varchar(80) NOT NULL,
  `descripcion` text NOT NULL,
  `datossiembra` text,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idmiscultivos`),
  KEY `fk_miscultivos_1_idx` (`email`),
  KEY `fk_miscultivos_2_idx` (`nombrecultivo`),
  CONSTRAINT `fk_miscultivos_1` FOREIGN KEY (`email`) REFERENCES `usuarios` (`email`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_miscultivos_2` FOREIGN KEY (`nombrecultivo`) REFERENCES `cultivos` (`nombrecultivo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miscultivos`
--

LOCK TABLES `miscultivos` WRITE;
/*!40000 ALTER TABLE `miscultivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `miscultivos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miscultivosfotos`
--

DROP TABLE IF EXISTS `miscultivosfotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miscultivosfotos` (
  `idmiscultivosfotos` int(11) NOT NULL,
  `idmiscultivos` int(11) NOT NULL,
  `foto` varchar(80) NOT NULL,
  PRIMARY KEY (`idmiscultivosfotos`),
  KEY `fk_miscultivosfotos_1_idx` (`idmiscultivos`),
  CONSTRAINT `fk_miscultivosfotos_1` FOREIGN KEY (`idmiscultivos`) REFERENCES `miscultivos` (`idmiscultivos`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miscultivosfotos`
--

LOCK TABLES `miscultivosfotos` WRITE;
/*!40000 ALTER TABLE `miscultivosfotos` DISABLE KEYS */;
/*!40000 ALTER TABLE `miscultivosfotos` ENABLE KEYS */;
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
  `latitud` int(11) DEFAULT NULL,
  `longitud` varchar(45) DEFAULT NULL,
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
INSERT INTO `municipios` VALUES (1,'BOCAS DEL TORO  ',1,NULL,0,'0.0'),(2,'CHANGUINOLA',1,NULL,0,'0.0'),(3,'CHIRIQUAGRANDE',1,NULL,0,'0.0'),(4,'AGUADULCE',2,NULL,0,'0.0'),(5,'ANTON',2,NULL,0,'0.0'),(6,'LA PINTADA',2,NULL,0,'0.0'),(7,'NATA',2,NULL,0,'0.0'),(8,'OLA',2,NULL,0,'0.0'),(9,'PENONOME',2,NULL,0,'0.0'),(10,'CHAGRES',3,NULL,0,'0.0'),(11,'COLON',3,NULL,0,'0.0'),(12,'DONOSO',3,NULL,0,'0.0'),(13,'PORTOBELO',3,NULL,0,'0.0'),(14,'SANTA ISABEL',3,NULL,0,'0.0'),(15,'ALANJE',4,NULL,0,'0.0'),(16,'BARU',4,NULL,0,'0.0'),(17,'BOQUERON',4,NULL,0,'0.0'),(18,'BOQUETE',4,NULL,0,'0.0'),(19,'BUGABA',4,NULL,0,'0.0'),(20,'DAVID',4,NULL,0,'0.0'),(21,'DOLEGA',4,NULL,0,'0.0'),(22,'GUALACA',4,NULL,0,'0.0'),(23,'REMEDIOS',4,NULL,0,'0.0'),(24,'RENACIMIENTO',4,NULL,0,'0.0'),(25,'SAN FELIX',4,NULL,0,'0.0'),(26,'SAN LORENZO',4,NULL,0,'0.0'),(27,'TOLE',4,NULL,0,'0.0'),(28,'CEMACO',5,NULL,0,'0.0'),(29,'CHEPIGANA',5,NULL,0,'0.0'),(30,'PINOGANA',5,NULL,0,'0.0'),(31,'SAMBU',5,NULL,0,'0.0'),(32,'CHITRE',6,NULL,0,'0.0'),(33,'LAS MINAS',6,NULL,0,'0.0'),(34,'LOS POZOS',6,NULL,0,'0.0'),(35,'OCU',6,NULL,0,'0.0'),(36,'PARITA',6,NULL,0,'0.0'),(37,'PESE',6,NULL,0,'0.0'),(38,'SANTA MARIA',6,NULL,0,'0.0'),(39,'GUARARE',7,NULL,0,'0.0'),(40,'LAS TABLAS',7,NULL,0,'0.0'),(41,'LOS SANTOS',7,NULL,0,'0.0'),(42,'MACARACAS',7,NULL,0,'0.0'),(43,'PEDASI',7,NULL,0,'0.0'),(44,'POCRI',7,NULL,0,'0.0'),(45,'TONOSI',7,NULL,0,'0.0'),(46,'ARRAIJAN',8,NULL,0,'0.0'),(47,'BALBOA',8,NULL,0,'0.0'),(52,'PANAMA',8,NULL,0,'0.0'),(53,'CHAME',8,NULL,0,'0.0'),(54,'CHEPO',8,NULL,0,'0.0'),(55,'CHIMAN',8,NULL,0,'0.0'),(56,'LA CHORRERA',8,NULL,0,'0.0'),(57,'SAN CARLOS',8,NULL,0,'0.0'),(58,'SAN MIGUELITO',8,NULL,0,'0.0'),(59,'TABOGA',8,NULL,0,'0.0'),(60,'ATALAYA',9,NULL,0,'0.0'),(61,'CALOBRE',9,NULL,0,'0.0'),(62,'CAÑAZAS',9,NULL,0,'0.0'),(63,'LA MESA',9,NULL,0,'0.0'),(64,'LAS PALMAS',9,NULL,0,'0.0'),(66,'MARIATO',9,NULL,0,'0.0'),(67,'MONTIJO',9,NULL,0,'0.0'),(68,'RIO DE JESUS',9,NULL,0,'0.0'),(69,'SAN FRANCISCO',9,NULL,0,'0.0'),(70,'SANTA FE',9,NULL,0,'0.0'),(71,'SANTIAGO',9,NULL,0,'0.0'),(72,'SONA',9,NULL,0,'0.0');
/*!40000 ALTER TABLE `municipios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `idpais` int(11) NOT NULL,
  `pais` varchar(50) NOT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  PRIMARY KEY (`idpais`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (507,'Panama',0,0);
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plagas`
--

DROP TABLE IF EXISTS `plagas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plagas` (
  `nombreplaga` varchar(80) NOT NULL,
  `nombrecientifico` varchar(100) NOT NULL,
  `descripcion` text NOT NULL,
  `aquienafecta` text NOT NULL,
  `foto` varchar(200) CHARACTER SET big5 DEFAULT NULL,
  PRIMARY KEY (`nombreplaga`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plagas`
--

LOCK TABLES `plagas` WRITE;
/*!40000 ALTER TABLE `plagas` DISABLE KEYS */;
/*!40000 ALTER TABLE `plagas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plagasporcultivos`
--

DROP TABLE IF EXISTS `plagasporcultivos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plagasporcultivos` (
  `idplagasporcultivos` int(11) NOT NULL,
  `nombreplaga` varchar(80) DEFAULT NULL,
  `nombrecultivo` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`idplagasporcultivos`),
  KEY `fk_plagasporcultivos_1_idx` (`nombrecultivo`),
  KEY `fk_plagasporcultivos_2_idx` (`nombreplaga`),
  CONSTRAINT `fk_plagasporcultivos_1` FOREIGN KEY (`nombrecultivo`) REFERENCES `cultivos` (`nombrecultivo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_plagasporcultivos_2` FOREIGN KEY (`nombreplaga`) REFERENCES `plagas` (`nombreplaga`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plagasporcultivos`
--

LOCK TABLES `plagasporcultivos` WRITE;
/*!40000 ALTER TABLE `plagasporcultivos` DISABLE KEYS */;
/*!40000 ALTER TABLE `plagasporcultivos` ENABLE KEYS */;
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
  `latitud` int(11) DEFAULT NULL,
  `longitud` int(11) DEFAULT NULL,
  `idpais` int(11) DEFAULT NULL,
  PRIMARY KEY (`idprovincia`),
  UNIQUE KEY `provincia` (`provincia`),
  KEY `fk_provincias_1_idx` (`idpais`),
  CONSTRAINT `fk_provincias_1` FOREIGN KEY (`idpais`) REFERENCES `pais` (`idpais`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Bocas del toro','si',0,0,507),(2,'Cocle','si',0,0,507),(3,'Colon','si',0,0,507),(4,'Chiriqui','si',0,0,507),(5,'Darien','si',0,0,507),(6,'Herrera','si',0,0,507),(7,'Los Santos','si',0,0,507),(8,'Panama ','si',0,0,507),(9,'Veraguas','si',0,0,507);
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `email` varchar(80) NOT NULL,
  `nombre` varchar(80) NOT NULL,
  `password` varchar(45) NOT NULL,
  `celular` varchar(35) DEFAULT NULL,
  `telefono` varchar(35) DEFAULT NULL,
  `sexo` varchar(15) NOT NULL,
  `foto` varchar(200) DEFAULT NULL,
  `profesion` varchar(80) DEFAULT NULL,
  `idgrupousuario` varchar(35) NOT NULL,
  PRIMARY KEY (`email`),
  KEY `fk_usuario_4_idx` (`idgrupousuario`),
  CONSTRAINT `fk_usuario_4` FOREIGN KEY (`idgrupousuario`) REFERENCES `grupousuarios` (`idgrupousuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
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

-- Dump completed on 2015-04-11  0:06:14
