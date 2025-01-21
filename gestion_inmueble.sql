CREATE DATABASE  IF NOT EXISTS `gestion_inmueble` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestion_inmueble`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestion_inmueble
-- ------------------------------------------------------
-- Server version	8.0.38

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
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentario` (
  `idComentario` int NOT NULL AUTO_INCREMENT,
  `idInmueble` int NOT NULL,
  `ComeAutor` varchar(100) NOT NULL,
  `ComeTexto` text,
  `ComeFecha` date NOT NULL,
  `ComePuntuacion` int DEFAULT '0',
  PRIMARY KEY (`idComentario`),
  KEY `idInmueble` (`idInmueble`),
  CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`idInmueble`) REFERENCES `inmueble` (`idInmueble`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrato_alquiler`
--

DROP TABLE IF EXISTS `contrato_alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato_alquiler` (
  `idAlquiler` int NOT NULL AUTO_INCREMENT,
  `idInmueble` int NOT NULL,
  `AlqFecIni` date DEFAULT NULL,
  `AlqFechFin` date DEFAULT NULL,
  `alqCosto` decimal(38,2) DEFAULT NULL,
  PRIMARY KEY (`idAlquiler`),
  KEY `idInmueble` (`idInmueble`),
  CONSTRAINT `contrato_alquiler_ibfk_1` FOREIGN KEY (`idInmueble`) REFERENCES `inmueble` (`idInmueble`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato_alquiler`
--

LOCK TABLES `contrato_alquiler` WRITE;
/*!40000 ALTER TABLE `contrato_alquiler` DISABLE KEYS */;
INSERT INTO `contrato_alquiler` VALUES (1,1,'2025-01-24','2025-01-29',150000.00),(2,1,'2025-01-23','2025-01-22',150000.00),(3,1,'2025-01-23','2025-01-22',150000.00),(4,2,'2025-01-23','2025-01-24',95000.00),(10,3,'2025-01-29','2025-01-31',120000.00),(11,3,'2025-01-29','2025-01-31',120000.00),(12,1,'2025-01-22','2025-01-30',150000.00),(13,1,'2025-01-31','2025-01-29',150000.00),(14,2,'2023-12-12','2025-03-21',95000.00),(15,1,'2025-01-23','2025-02-01',150000.00),(16,1,'2025-01-23','2025-02-01',150000.00),(17,1,'2025-01-24','2025-02-07',150000.00),(18,1,'2025-01-24','2025-02-07',150000.00),(19,1,'2025-01-24','2025-02-07',150000.00),(20,1,'2025-01-24','2025-02-07',150000.00),(21,1,'2025-01-21','2025-01-23',150000.00);
/*!40000 ALTER TABLE `contrato_alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial`
--

DROP TABLE IF EXISTS `historial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historial` (
  `idHistorial` int NOT NULL AUTO_INCREMENT,
  `idInmueble` int NOT NULL,
  `HisFecha` date NOT NULL,
  PRIMARY KEY (`idHistorial`),
  KEY `idInmueble` (`idInmueble`),
  CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`idInmueble`) REFERENCES `inmueble` (`idInmueble`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial`
--

LOCK TABLES `historial` WRITE;
/*!40000 ALTER TABLE `historial` DISABLE KEYS */;
/*!40000 ALTER TABLE `historial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmueble` (
  `idInmueble` int NOT NULL AUTO_INCREMENT,
  `InmTitulo` varchar(255) NOT NULL,
  `InmTipo` varchar(255) NOT NULL,
  `InmPisos` int DEFAULT NULL,
  `InmEstado` varchar(255) NOT NULL,
  `InmDescrip` varchar(255) DEFAULT NULL,
  `InmPrecio` decimal(38,2) NOT NULL,
  `InmPunt` decimal(3,2) DEFAULT '0.00',
  `InmDepart` varchar(255) NOT NULL,
  `InmCiudad` varchar(255) NOT NULL,
  `InmArea` varchar(255) NOT NULL,
  `InmDireccion` varchar(255) NOT NULL,
  `VecesAlquilado` int DEFAULT '0',
  PRIMARY KEY (`idInmueble`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
INSERT INTO `inmueble` VALUES (1,'Casa Moderna','Casa',2,'No disponible','Casa moderna con jardín amplio y excelente iluminación natural.',150000.00,0.00,'Zona 1','Ciudad A','100 m²','Calle Falsa 123',0),(2,'Departamento céntrico','Departamento',3,'No disponible','Departamento en el centro con acceso a transporte público y comercio cercano.',95000.00,NULL,'Zona 2','Ciudad Bs','85 m²','Avenida Principal 456',0),(3,'Local comercial en esquina','Local',1,'No disponible','Amplio local comercial en esquina, ideal para tiendas o oficinas.',120000.00,0.00,'Zona 3','Ciudad C','120 m²','Esquina Comercio 789',0),(4,'Casa con terraza','Casa',2,'Disponible','Casa con terraza grande y vista panorámica de la ciudad.',175000.00,0.00,'Zona 4','Ciudad D','95 m²','Calle Tranquila 101',0),(5,'Departamento amoblado','Departamento',3,'Disponible','Departamento totalmente amoblado, listo para mudarse.',89000.00,0.00,'Zona 5','Ciudad E','80 m²','Bulevar de las Flores 202',0),(6,'Local para oficinas','Local',1,'Disponible','Local adecuado para oficinas, cuenta con salas de reuniones.',95000.00,0.00,'Zona 6','Ciudad F','110 m²','Avenida de los Negocios 303',0),(7,'Casa con piscina','Casa',2,'Disponible','Casa espaciosa con piscina y espacio para eventos.',210000.00,0.00,'Zona 7','Ciudad G','120 m²','Calle Verde 404',0),(8,'Departamento con balcón','Departamento',3,'Disponible','Departamento con balcón y vista al parque.',88000.00,0.00,'Zona 8','Ciudad H','90 m²','Boulevard Central 505',0),(9,'Local en galería','Local',1,'Disponible','Local en galería comercial con alta afluencia de público.',105000.00,0.00,'Zona 9','Ciudad I','85 m²','Centro Comercial 606',0),(10,'Casa antigua renovada','Casa',2,'Disponible','Casa antigua renovada con estilo clásico y detalles únicos.',160000.00,0.00,'Zona 10','Ciudad J','110 m²','Calle Histórica 707',0),(11,'Departamento duplex','Departamento',4,'Disponible','Departamento duplex con espacio amplio y distribuciones cómodas.',175000.00,0.00,'Zona 11','Ciudad K','120 m²','Avenida de las Palmeras 808',0),(12,'Local para restaurante','Local',1,'Disponible','Local en planta baja ideal para restaurante, con amplia cocina.',145000.00,0.00,'Zona 12','Ciudad L','130 m²','Zona Gastronómica 909',0),(13,'Casa con cochera techada','Casa',2,'Disponible','Casa con cochera techada y jardín interior.',180000.00,0.00,'Zona 13','Ciudad M','95 m²','Calle Principal 1010',0),(14,'Departamento en torre alta','Departamento',3,'Disponible','Departamento en torre alta con vista panorámica de la ciudad.',92000.00,0.00,'Zona 14','Ciudad N','85 m²','Skyline Tower 1111',0),(15,'Local en planta alta','Local',1,'Disponible','Local en planta alta con acceso por escaleras, ideal para oficinas.',88000.00,0.00,'Zona 15','Ciudad O','90 m²','Planta Alta 1212',0),(16,'Casa moderna con jacuzzi','Casa',2,'Disponible','Casa moderna con jacuzzi en el jardín trasero.',220000.00,0.00,'Zona 16','Ciudad P','100 m²','Calle Verde 1313',0),(17,'Departamento con vista al mar','Departamento',3,'Disponible','Departamento con vista al mar y acceso directo a la playa.',195000.00,0.00,'Zona 17','Ciudad Q','110 m²','Costanera 1414',0),(18,'Local en centro comercial','Local',1,'Disponible','Local en centro comercial con excelente visibilidad.',130000.00,0.00,'Zona 18','Ciudad R','120 m²','Centro Comercial 1515',0),(19,'Casa en zona residencial','Casa',2,'Disponible','Casa ubicada en zona residencial tranquila, ideal para familias.',175000.00,0.00,'Zona 19','Ciudad S','105 m²','Calle Serena 1616',0),(20,'Departamento en edificio moderno','Departamento',4,'Disponible','Departamento en edificio moderno con gimnasio y piscina.',165000.00,0.00,'Zona 20','Ciudad T','125 m²','Av. Moderna 1717',0),(21,'Local con acceso a vías principales','Local',1,'Disponible','Local con excelente acceso a vías principales, ideal para negocios.',135000.00,0.00,'Zona 21','Ciudad U','115 m²','Av. Principal 1818',0),(22,'Casa tipo rústica','Casa',2,'Disponible','Casa tipo rústica con paredes de piedra y techos de madera.',195000.00,0.00,'Zona 22','Ciudad V','110 m²','Calle del Molino 1919',0),(23,'Departamento con parque privado','Departamento',3,'Disponible','Departamento con parque privado y seguridad 24/7.',180000.00,0.00,'Zona 23','Ciudad W','95 m²','Avenida Verde 2020',0),(24,'Local en galería de lujo','Local',1,'Disponible','Local en galería de lujo, perfecto para boutiques exclusivas.',185000.00,0.00,'Zona 24','Ciudad X','125 m²','Galería del lujo 2121',0),(25,'Casa con jardín vertical','Casa',2,'Disponible','Casa con jardín vertical en la fachada y área de BBQ.',210000.00,0.00,'Zona 25','Ciudad Y','120 m²','Avenida Jardín 2222',0),(26,'Departamento con gimnasio privado','Departamento',4,'Disponible','Departamento con gimnasio privado y áreas de relax.',155000.00,0.00,'Zona 26','Ciudad Z','95 m²','Residencial del Sur 2323',0),(27,'Local en esquina muy visible','Local',1,'Disponible','Local en esquina muy visible, ideal para franquicias.',145000.00,0.00,'Zona 27','Ciudad AA','130 m²','Esquina Principal 2424',0),(28,'Casa con vista al lago','Casa',2,'Disponible','Casa con vista al lago y embarcadero privado.',230000.00,0.00,'Zona 28','Ciudad BB','125 m²','Lago Dorado 2525',0),(29,'Departamento con balcón amplio','Departamento',3,'Disponible','Departamento con balcón amplio y vista despejada.',87000.00,0.00,'Zona 29','Ciudad CC','90 m²','Calle Alta 2626',0),(30,'Local en centro de negocio','Local',1,'Disponible','Local en pleno centro de negocio, con clientela constante.',95000.00,0.00,'Zona 30','Ciudad DD','110 m²','Negocios Central 2727',0),(31,'Casa con acceso a áreas comunes','Casa',2,'Disponible','Casa con acceso a áreas comunes, como piscina y canchas.',175000.00,0.00,'Zona 31','Ciudad EE','120 m²','Complejo Residencial 2828',0),(32,'Departamento en primera línea','Departamento',4,'Disponible','Departamento en primera línea con acceso privado a playa.',295000.00,0.00,'Zona 32','Ciudad FF','150 m²','Playa Central 2929',0),(33,'Local en pasillo comercial','Local',1,'Disponible','Local ubicado en pasillo comercial con alta afluencia.',105000.00,0.00,'Zona 33','Ciudad GG','85 m²','Pasillo Comercial 3030',0),(34,'Casa en lote grande','Casa',2,'Disponible','Casa en lote grande con jardín delantero y trasero.',190000.00,0.00,'Zona 34','Ciudad HH','130 m²','Calle Ancha 3131',0),(35,'Departamento tipo loft','Departamento',3,'Disponible','Departamento tipo loft, espacioso y de diseño moderno.',110000.00,0.00,'Zona 35','Ciudad II','95 m²','Loft Moderno 3232',0),(36,'Local con estacionamiento privado','Local',1,'Disponible','Local con estacionamiento privado y área de carga.',125000.00,0.00,'Zona 36','Ciudad JJ','100 m²','Estacionamiento Privado 3333',0),(37,'Casa con pérgola','Casa',2,'Disponible','Casa con pérgola y espacio para reuniones al aire libre.',210000.00,0.00,'Zona 37','Ciudad KK','115 m²','Pérgola 3434',0),(38,'Departamento con cocina equipada','Departamento',4,'Disponible','Departamento con cocina equipada y área de lavandería.',130000.00,0.00,'Zona 38','Ciudad LL','100 m²','Residencial Gourmet 3535',0),(39,'Local en centro comercial premium','Local',1,'Disponible','Local en centro comercial premium, alto tráfico peatonal.',170000.00,0.00,'Zona 39','Ciudad MM','125 m²','Centro Premium 3636',0),(40,'Casa con estudio independiente','Casa',2,'Disponible','Casa con estudio independiente y jardín privado.',220000.00,0.00,'Zona 40','Ciudad NN','120 m²','Estudio Independiente 3737',0),(41,'Departamento con acceso a transporte','Departamento',3,'Disponible','Departamento con acceso directo a transporte público.',88000.00,0.00,'Zona 41','Ciudad OO','95 m²','Acceso Transporte 3838',0),(42,'Local en calle peatonal','Local',1,'Disponible','Local en calle peatonal, zona comercial activa.',145000.00,0.00,'Zona 42','Ciudad PP','90 m²','Calle Peatonal 3939',0),(43,'Casa con ventanas grandes','Casa',2,'Disponible','Casa con amplias ventanas y excelente ventilación.',200000.00,0.00,'Zona 43','Ciudad QQ','125 m²','Ventanas Amplias 4040',0),(44,'Departamento con sala de estar','Departamento',4,'Disponible','Departamento con sala de estar y comedor independiente.',165000.00,0.00,'Zona 44','Ciudad RR','110 m²','Sala de Estar 4141',0),(45,'Local en zona turística','Local',1,'Disponible','Local en zona turística, atractivo para visitantes.',95000.00,0.00,'Zona 45','Ciudad SS','85 m²','Zona Turística 4242',0),(46,'Casa con chimenea','Casa',2,'Disponible','Casa con chimenea y área de estar acogedora.',230000.00,0.00,'Zona 46','Ciudad TT','130 m²','Chimenea 4343',0),(47,'Departamento con sala de cine','Departamento',3,'Disponible','Departamento con sala de cine en casa.',270000.00,0.00,'Zona 47','Ciudad UU','150 m²','Cine en Casa 4444',0),(48,'Local en paso concurrido','Local',1,'Disponible','Local ubicado en paso concurrido, buena exposición.',185000.00,0.00,'Zona 48','Ciudad VV','120 m²','Paso Concurrido 4545',0),(49,'Casa con área BBQ','Casa',2,'Disponible','Casa con área de BBQ y jardín amplio.',215000.00,0.00,'Zona 49','Ciudad WW','125 m²','Área BBQ 4646',0),(50,'Departamento con vigilancia 24/7','Departamento',3,'Disponible','Departamento con vigilancia las 24 horas y acceso controlado.',175000.00,0.00,'Zona 50','Ciudad XX','110 m²','Seguridad 24/7 4747',0),(51,'Local en centro de exposiciones','Local',1,'Disponible','Local en centro de exposiciones para eventos y ferias.',200000.00,0.00,'Zona 51','Ciudad YY','130 m²','Centro de Exposiciones 4848',0),(52,'Casa con cancha deportiva','Casa',2,'Disponible','Casa con cancha deportiva privada y amplio jardín.',220000.00,0.00,'Zona 52','Ciudad ZZ','125 m²','Cancha Deportiva 4949',0),(53,'Departamento con acceso a gimnasio','Departamento',4,'Disponible','Departamento con acceso a gimnasio comunitario.',155000.00,0.00,'Zona 53','Ciudad AAA','95 m²','Gimnasio 5050',0),(54,'Local en galería empresarial','Local',1,'Disponible','Local en galería empresarial con oficinas cercanas.',145000.00,0.00,'Zona 54','Ciudad BBB','100 m²','Galería Empresarial 5151',0),(55,'Casa con piscina y área de juego','Casa',2,'Disponible','Casa con piscina y área de juego para niños.',230000.00,0.00,'Zona 55','Ciudad CCC','110 m²','Piscina y Juego 5252',0),(56,'Departamento con vista al parque','Departamento',3,'Disponible','Departamento con vista al parque y tranquilidad asegurada.',95000.00,0.00,'Zona 56','Ciudad DDD','80 m²','Vista Parque 5353',0),(57,'Local en zona industrial','Local',1,'Disponible','Local en zona industrial, ideal para fábricas o depósitos.',185000.00,0.00,'Zona 57','Ciudad EEE','125 m²','Zona Industrial 5454',0),(58,'Casa tipo chalet','Casa',2,'Disponible','Casa tipo chalet con amplios espacios y techos inclinados.',200000.00,0.00,'Zona 58','Ciudad FFF','110 m²','Chalet 5555',0),(59,'Departamento con terraza privada','Departamento',3,'Disponible','Departamento con terraza privada y excelente vista.',98000.00,0.00,'Zona 59','Ciudad GGG','90 m²','Terraza Privada 5656',0),(60,'Local en calle comercial principal','Local',1,'Disponible','Local en calle comercial principal con alto tráfico.',155000.00,0.00,'Zona 60','Ciudad HHH','85 m²','Calle Principal 5757',0);
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagos`
--

DROP TABLE IF EXISTS `pagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagos` (
  `idPago` int NOT NULL AUTO_INCREMENT,
  `idAlquiler` int NOT NULL,
  `pagCosMan` decimal(10,2) DEFAULT '0.00',
  `pagCosto` decimal(10,2) NOT NULL,
  `pagDsct` decimal(10,2) DEFAULT '0.00',
  `pagEstado` enum('Cancelado') DEFAULT 'Cancelado',
  `pagTotal` decimal(10,2) NOT NULL,
  `pagfecPag` date NOT NULL,
  PRIMARY KEY (`idPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagos`
--

LOCK TABLES `pagos` WRITE;
/*!40000 ALTER TABLE `pagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo_pago`
--

DROP TABLE IF EXISTS `recibo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recibo_pago` (
  `idRecibo` int NOT NULL AUTO_INCREMENT,
  `idAlquiler` int NOT NULL,
  `RecFecha` date NOT NULL,
  `RecMonto` decimal(38,2) NOT NULL,
  `RecDscto` decimal(10,2) DEFAULT '0.00',
  `RecMan` decimal(10,2) DEFAULT '0.00',
  `RecTotal` decimal(38,2) NOT NULL,
  PRIMARY KEY (`idRecibo`),
  KEY `idAlquiler` (`idAlquiler`),
  CONSTRAINT `recibo_pago_ibfk_1` FOREIGN KEY (`idAlquiler`) REFERENCES `contrato_alquiler` (`idAlquiler`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo_pago`
--

LOCK TABLES `recibo_pago` WRITE;
/*!40000 ALTER TABLE `recibo_pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `recibo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recibo_pago_seq`
--

DROP TABLE IF EXISTS `recibo_pago_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recibo_pago_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recibo_pago_seq`
--

LOCK TABLES `recibo_pago_seq` WRITE;
/*!40000 ALTER TABLE `recibo_pago_seq` DISABLE KEYS */;
INSERT INTO `recibo_pago_seq` VALUES (1);
/*!40000 ALTER TABLE `recibo_pago_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `usuName` varchar(255) NOT NULL,
  `usuPass` varchar(255) NOT NULL,
  `usuNomb` varchar(255) DEFAULT NULL,
  `usuApe` varchar(255) DEFAULT NULL,
  `usuCorreo` varchar(255) DEFAULT NULL,
  `usuCelular` varchar(255) DEFAULT NULL,
  `usuTipo` varchar(255) DEFAULT NULL,
  `vecesAlquilo` int DEFAULT '0',
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `UsuName` (`usuName`),
  UNIQUE KEY `UsuCorreo` (`usuCorreo`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin1','123','Maria','Gonzalez','maria.gonzalez@example.com','9999999999','Administrador',0),(2,'admin2','password123','Carlos','Martinez','carlos.martinez@example.com','8888888888','Administrador',0),(3,'user01','password1','Juan','Perez','juan.perez@example.com','6111111111','Usuario',0),(4,'user02','password2','Ana','Lopez','ana.lopez@example.com','6211111111','Usuario',0),(5,'user03','password3','Luis','Fernandez','luis.fernandez@example.com','6311111111','Usuario',0),(6,'user04','password4','Laura','Gomez','laura.gomez@example.com','6411111111','Usuario',0),(7,'user05','password5','Pedro','Rodriguez','pedro.rodriguez@example.com','6511111111','Usuario',0),(8,'user06','password6','Sofia','Martinez','sofia.martinez@example.com','6611111111','Usuario',0),(9,'user07','password7','Diego','Garcia','diego.garcia@example.com','6711111111','Usuario',0),(10,'user08','password8','Camila','Hernandez','camila.hernandez@example.com','6811111111','Usuario',0),(11,'user09','password9','Gabriel','Lopez','gabriel.lopez@example.com','6911111111','Usuario',0),(12,'user10','password10','Isabel','Gomez','isabel.gomez@example.com','7011111111','Usuario',0),(13,'user11','password11','Jose','Martinez','jose.martinez@example.com','7111111111','Usuario',0),(14,'user12','password12','Victoria','Rodriguez','victoria.rodriguez@example.com','7211111111','Usuario',0),(15,'user13','password13','Carlos','Garcia','carlos.garcia@example.com','7311111111','Usuario',0),(16,'user14','password14','Lucia','Hernandez','lucia.herandez@example.com','7411111111','Usuario',0),(17,'user15','password15','Santiago','Lopez','santiago.lopez@example.com','7511111111','Usuario',0),(18,'user16','password16','Mariana','Gomez','mariana.gomez@example.com','7611111111','Usuario',0),(19,'user17','password17','Daniel','Martinez','daniel.martinez@example.com','7711111111','Usuario',0),(20,'user18','password18','Paula','Rodriguez','paula.rodriguez@example.com','7811111111','Usuario',0),(21,'user19','password19','Gabriela','Garcia','gabriela.garcia@example.com','7911111111','Usuario',0),(22,'user20','password20','Roberto','Hernandez','roberto.herandez@example.com','8011111111','Usuario',0),(23,'user21','password21','Miriam','Lopez','miriam.lopez@example.com','8111111111','Usuario',0),(24,'user22','password22','Fernando','Gomez','fernando.gomez@example.com','8211111111','Usuario',0),(25,'user23','password23','Claudia','Martinez','claudia.martinez@example.com','8311111111','Usuario',0),(26,'user24','password24','Luis','Rodriguez','luis.rodriguez@example.com','8411111111','Usuario',0),(27,'user25','password25','Nina','Garcia','nina.garcia@example.com','8511111111','Usuario',0),(28,'user26','password26','Javier','Hernandez','javier.herandez@example.com','8611111111','Usuario',0),(29,'user27','password27','Ana','Lopez','ana.lopez2@example.com','8711111111','Usuario',0),(30,'q','q','q','q','q@gmail.com','222','Usuario',0),(31,'w','w','w','w','w','w','Usuario',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestion_inmueble'
--

--
-- Dumping routines for database 'gestion_inmueble'
--
/*!50003 DROP PROCEDURE IF EXISTS `RegistrarAlquiler` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `RegistrarAlquiler`(
    IN p_idUsuario INT,
    IN p_idInmueble INT,
    IN p_fecIni DATE,
    IN p_fecFin DATE,
    IN p_costo DECIMAL(10, 2)
)
BEGIN
    INSERT INTO contrato_alquiler (idUsuario, idInmueble, AlqFecIni, AlqFechFin, AlqCosto)
    VALUES (p_idUsuario, p_idInmueble, p_fecIni, p_fecFin, p_costo);

    UPDATE inmueble SET InmEstado = 'No disponible'
    WHERE idInmueble = p_idInmueble;

    UPDATE usuario SET VecesAlquilo = VecesAlquilo + 1
    WHERE idUsuario = p_idUsuario;

    INSERT INTO historial (idInmueble, HisFecha)
    VALUES (p_idInmueble, CURDATE());
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `RegistrarPago` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `RegistrarPago`(
    IN p_idAlquiler INT,
    IN p_costo DECIMAL(10, 2),
    IN p_dscto DECIMAL(10, 2),
    IN p_mantenimiento DECIMAL(10, 2)
)
BEGIN
    DECLARE p_total DECIMAL(10, 2);

    SET p_total = p_costo - p_dscto + p_mantenimiento;

    INSERT INTO contrato_alquiler (idAlquiler, PagFecPag, PagCosto, PagDsct, PagCosMan, PagTotal)
    VALUES (p_idAlquiler, CURDATE(), p_costo, p_dscto, p_mantenimiento, p_total);

    INSERT INTO recibo_pago (idPago, RecFecha, RecMonto, RecDscto, RecMan, RecTotal)
    VALUES (LAST_INSERT_ID(), CURDATE(), p_costo, p_dscto, p_mantenimiento, p_total);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-20 19:58:36
