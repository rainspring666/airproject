-- MySQL dump 10.13  Distrib 5.7.29, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: air_system
-- ------------------------------------------------------
-- Server version	5.7.29

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` varchar(40) NOT NULL,
  `admin_name` varchar(16) NOT NULL,
  `admin_pwd` varchar(16) NOT NULL,
  `admin_phone` varchar(11) NOT NULL,
  PRIMARY KEY (`admin_id`,`admin_phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('1234','user','12345678911','12345678911');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detectiondata`
--

DROP TABLE IF EXISTS `detectiondata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detectiondata` (
  `ddata_id` varchar(40) NOT NULL,
  `ddata_time` datetime NOT NULL,
  `process_id` varchar(40) NOT NULL,
  `pm1_0` float NOT NULL,
  `um0_3` float NOT NULL,
  `um2_5` float NOT NULL,
  `pm2_5` float NOT NULL,
  `um0_5` float NOT NULL,
  `um5_0` float NOT NULL,
  `pm10` float NOT NULL,
  `um1_0` float NOT NULL,
  `um10` float NOT NULL,
  `hcho` float NOT NULL,
  `tvoc` float NOT NULL,
  `co2` float NOT NULL,
  `temp` float NOT NULL,
  `rh` float NOT NULL,
  PRIMARY KEY (`ddata_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detectiondata`
--

LOCK TABLES `detectiondata` WRITE;
/*!40000 ALTER TABLE `detectiondata` DISABLE KEYS */;
/*!40000 ALTER TABLE `detectiondata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `eq_id` varchar(40) NOT NULL,
  `eq_name` varchar(32) NOT NULL,
  `eq_type` varchar(32) NOT NULL,
  `eq_inner_num` varchar(40) NOT NULL,
  `eq_create_time` datetime NOT NULL,
  `eq_add_time` datetime NOT NULL,
  `eq_state` int(11) NOT NULL,
  `eq_other` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`eq_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES ('1','小米充电宝1','充电宝','001','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('10','热水壶1','热水壶','004','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('11','热水壶2','热水壶','004','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('12','热水壶3','热水壶','004','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('13','防护套装1','防护套装','005','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'手套 防护服 防毒面具'),('14','防护套装2','防护套装','005','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'手套 防护服 防毒面具'),('15','防护套装3','防护套装','005','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'手套 防护服 防毒面具'),('2','小米充电宝2','充电宝','001','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('3','小米充电宝3','充电宝','001','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('4','反应桶1','反应桶','002','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('5','反应桶2','反应桶','002','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('6','反应桶3','反应桶','002','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('7','反应器1','反应器','003','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('8','反应器2','反应器','003','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述'),('9','反应器3','反应器','003','2020-06-05 10:13:54','2020-06-05 10:14:02',0,'描述');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `login_id` varchar(40) NOT NULL,
  `password` varchar(16) NOT NULL,
  `role` varchar(10) NOT NULL,
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `material_id` varchar(40) NOT NULL,
  `ma_name` varchar(32) NOT NULL,
  `ma_number` int(10) unsigned NOT NULL,
  `ma_other` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`material_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES ('101','除醛A',10000,NULL),('201','除醛B',10000,NULL),('301','消毒A',10000,NULL),('401','消毒B',10000,NULL),('501','汽车治理包',10000,NULL);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operator`
--

DROP TABLE IF EXISTS `operator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operator` (
  `op_id` varchar(40) NOT NULL,
  `op_name` varchar(16) NOT NULL,
  `op_pwd` varchar(16) NOT NULL,
  `op_phone` varchar(11) NOT NULL,
  `op_state` int(10) unsigned DEFAULT NULL,
  `wx_openid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`op_id`,`op_phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operator`
--

LOCK TABLES `operator` WRITE;
/*!40000 ALTER TABLE `operator` DISABLE KEYS */;
INSERT INTO `operator` VALUES ('1','待分配','123','15871757994',0,NULL),('2','操作员1','123','15871757777',0,NULL),('3','操作员2','123','15871758888',0,'');
/*!40000 ALTER TABLE `operator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `process`
--

DROP TABLE IF EXISTS `process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `process` (
  `process_id` varchar(40) NOT NULL,
  `user_id` varchar(40) NOT NULL,
  `order_id` varchar(40) NOT NULL,
  `pro_generator` varchar(1024) NOT NULL,
  `pro_sampler` varchar(1024) NOT NULL,
  `pro_report` varchar(1024) NOT NULL,
  `pro_result` varchar(1024) NOT NULL,
  `pro_eq` varchar(1024) NOT NULL,
  `pro_material` varchar(1024) NOT NULL,
  `pro_starttime` datetime NOT NULL,
  `pro_state` int(10) unsigned NOT NULL,
  `pro_endtime` datetime NOT NULL,
  `pro_pictures` varchar(1024) NOT NULL,
  `ddata_id` varchar(40) NOT NULL,
  `express_id` varchar(40) NOT NULL,
  `express_name` varchar(40) NOT NULL,
  PRIMARY KEY (`process_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `process`
--

LOCK TABLES `process` WRITE;
/*!40000 ALTER TABLE `process` DISABLE KEYS */;
/*!40000 ALTER TABLE `process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `standard`
--

DROP TABLE IF EXISTS `standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `standard` (
  `st_id` varchar(40) NOT NULL,
  `st_name` varchar(32) NOT NULL,
  `st_idcard` varchar(32) NOT NULL,
  `st_year` year(4) NOT NULL,
  PRIMARY KEY (`st_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard`
--

LOCK TABLES `standard` WRITE;
/*!40000 ALTER TABLE `standard` DISABLE KEYS */;
/*!40000 ALTER TABLE `standard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(40) NOT NULL,
  `user_pwd` varchar(16) NOT NULL COMMENT '哈希加密取16位',
  `user_phone` varchar(11) NOT NULL COMMENT '手机号码',
  `user_name` varchar(16) NOT NULL,
  `user_gender` int(11) DEFAULT NULL,
  `open_id` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`user_phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('015891924989071','ac59075b964b0715','17786028888','张三',1,'213124124'),('015893358205961','e6dd63397f1d335c','13211111112','',1,NULL),('015895279629461','0822da7ea481a653','13911112222','',1,'op_Qp49dqJRed4Qlb5dRW7Qs_wMU'),('1','123','17786029999','user',1,NULL),('2','123','15927048888','admin',2,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userorder`
--

DROP TABLE IF EXISTS `userorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userorder` (
  `order_id` varchar(40) NOT NULL,
  `user_id` varchar(40) NOT NULL,
  `op_id` varchar(40) NOT NULL,
  `order_state` int(10) unsigned DEFAULT NULL,
  `order_createtime` datetime NOT NULL,
  `order_time` datetime NOT NULL,
  `order_class` varchar(10) DEFAULT NULL,
  `order_modelf` varchar(1024) DEFAULT NULL,
  `order_scope` float unsigned DEFAULT NULL,
  `order_descripe` varchar(1024) DEFAULT NULL,
  `order_address` varchar(1024) NOT NULL,
  `order_contact` varchar(20) NOT NULL,
  `order_phone` varchar(11) NOT NULL,
  `order_others` varchar(1024) DEFAULT NULL,
  `order_cost` float DEFAULT NULL,
  `order_pollution` varchar(40) DEFAULT NULL,
  `order_moremoney` tinyint(1) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userorder`
--

LOCK TABLES `userorder` WRITE;
/*!40000 ALTER TABLE `userorder` DISABLE KEYS */;
INSERT INTO `userorder` VALUES ('1509a3a1d11344fc85eac0c37f959908','015893358205961','1',0,'2020-05-13 12:38:33','2020-05-13 12:38:07','2','/Users/pengyuquan/Desktop/1589344713621wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.MnGUnONhECM17a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg',111,'家居装修','武汉市','徐俊伟','13211111111','其它111',100.9,'甲醛',NULL),('45afa032660b46539c5e1f1639d0c762','015895279629461','1',0,'2020-05-15 15:33:52','2020-05-15 15:32:56','2','/Users/pengyuquan/Desktop/1589528032066wx0656326b8fdbe56f.o6zAJs5QFg7Go9_V9BOU0yT_sVOA.JITjaJKjiHfhba470c02f02389f67babdfabd606d248.jpg',120,'三室二厅','安徽省安庆市','笑话','13911112222','',100.9,'甲醛',NULL),('5a5be5c1d0df4960b07327cbb114157f','015893358205961','1',0,'2020-05-14 15:01:28','2020-05-14 15:00:05','2','/Users/pengyuquan/Desktop/1589439688302wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.G9MLxs6bSDc47a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg',112,'家居装修','北京市海淀区','小明啊','13211111111','无其它说明',100.9,'甲醛1',NULL),('8a947089a884420eb75bc474c81bd6aa','015893358205961','1',0,'2020-05-13 12:43:25','2020-05-13 12:42:49','2','/Users/pengyuquan/Desktop/1589345005694wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.7i6bwJXOFhXg7a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg',112,'家居装修','武汉市洪山区','徐俊伟12','13211111111','其它123',100.9,'甲醛',NULL),('d32b75af04ee4844994f49e4bbbcc28c','015893375513131','1',0,'2020-05-15 15:28:13','2020-05-15 15:26:21','1','/Users/pengyuquan/Desktop/1589527692865wx0656326b8fdbe56f.o6zAJs5QFg7Go9_V9BOU0yT_sVOA.8GGCLxwsJgAbba470c02f02389f67babdfabd606d248.jpg',120,'可以','安徽省安庆市','小明','18321889999','',100.9,'甲醛',NULL),('d3fe44d2a451405d876bd7a504f78fce','015893391087901','1',0,'2020-05-13 11:05:08','2020-05-13 11:04:19','2','/Users/pengyuquan/Desktop/1589339108790wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.Lzkzyyt4SIa87a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg',112,'家居装修','武汉市','徐俊伟','13211111111','其它123',100.9,'甲醛',1);
/*!40000 ALTER TABLE `userorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-05 20:52:58
