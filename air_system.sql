/*
Navicat MySQL Data Transfer

Source Server         : first
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : air_system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-06-29 22:11:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_role` int(11) DEFAULT NULL,
  PRIMARY KEY (`admin_id`,`admin_phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1234', 'user', '12345678911', '12345678911', '1');

-- ----------------------------
-- Table structure for detectiondata
-- ----------------------------
DROP TABLE IF EXISTS `detectiondata`;
CREATE TABLE `detectiondata` (
  `ddata_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ddata_time` datetime NOT NULL,
  `process_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pm1_0` float DEFAULT NULL,
  `um0_3` float DEFAULT NULL,
  `um2_5` float DEFAULT NULL,
  `pm2_5` float DEFAULT NULL,
  `um0_5` float DEFAULT NULL,
  `um5_0` float DEFAULT NULL,
  `pm10` float DEFAULT NULL,
  `um1_0` float DEFAULT NULL,
  `um10` float DEFAULT NULL,
  `hcho` float DEFAULT NULL,
  `tvoc` float DEFAULT NULL,
  `co2` float DEFAULT NULL,
  `temp` float DEFAULT NULL,
  `rh` float DEFAULT NULL,
  PRIMARY KEY (`ddata_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of detectiondata
-- ----------------------------
INSERT INTO `detectiondata` VALUES ('05b0fa143a884ae784a751b5d23ce2f2', '2020-06-08 19:04:14', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('067e8cebfb2c41be8612a8c74d72ce51', '2020-06-08 17:49:51', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('1a95a1e58771491ba62b7f1f41888ea7', '2020-06-08 17:54:45', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('1fe7e6da733f43d3b96b1e82cf0b8171', '2020-06-08 19:02:03', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('24fd3592ffa5425596c252636c9bc02f', '2020-06-08 19:02:03', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('25a24ae52fcc482f94eb4e691749ff1b', '2020-06-08 19:05:56', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('28cbdf05af4e49e49531ee4b26c2ca04', '2020-06-08 19:02:00', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('2b49317b4ead4977a3e937eee19a4a10', '2020-06-08 18:27:29', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('35b84653cbd64394926fa78341fec22c', '2020-06-08 19:02:06', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('38c7597e5a73469486421b490c011ae7', '2020-06-08 19:02:04', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('47a1428298094416b7d9196cdabdbfa3', '2020-06-08 19:00:44', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('4f165147be5c40129692f973e46d0ac7', '2020-06-08 19:02:01', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('575adc9aecbe42388e915c84811fdae6', '2020-06-08 17:56:32', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('6784c310a9b749ff85200d82bcbd017c', '2020-06-08 18:58:31', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('6d80f1e59bf6403490f584502be6d85e', '2020-06-08 19:01:56', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('7278eefb391e435784282cdc412acaac', '2020-06-08 19:02:03', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('774bb7d6286a42d9b7b1b0ac9f3fb636', '2020-06-08 19:02:00', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('77547d88370c4cdabdf384210654d778', '2020-06-08 19:00:29', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('7a3a6e6dac0d4acaa72aa06bd1100b21', '2020-06-08 19:02:05', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('7b97924a97244e508fda2633ac24de7e', '2020-06-08 17:55:22', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('7ed7b30a85eb4982b47484d64835b94e', '2020-06-08 19:02:01', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('7f39152feef04b1785a608d3e2f47e5c', '2020-06-08 19:01:59', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('891adc3c3d5941bda7d773247fbd0e9d', '2020-06-08 19:02:04', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('892af1e8027e495990a61e7fc26404a9', '2020-06-08 17:57:37', '123124124', '1', '1', '1', '1', '1', '3', '2', '4', '5', '6', '2', '1', '3', '1');
INSERT INTO `detectiondata` VALUES ('8d152fde3fc84a738338111d47f57539', '2020-06-08 19:06:00', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('8fe1ac4fbf634035800eb001b62fc25a', '2020-06-08 19:02:01', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('91c42737925f4534841b99056cd8dee1', '2020-06-08 19:02:02', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('9afcf8246e934d96af1818f9b5fe293d', '2020-06-08 19:02:01', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('a839f22dbfcc4b71bb5795c5dd951828', '2020-06-08 19:02:00', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('bc86c6fa5ee24e9dbfe8a2f1b20356e5', '2020-06-08 19:00:24', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('bdbe79c9e9c44646961c71c833347d1a', '2020-06-08 19:02:04', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('c01db420d63c442caaaff7148e2033bb', '2020-06-08 18:58:29', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('c3922152ddf34fb98e2d3cda15461aaf', '2020-06-08 19:02:05', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('daae5efb970d4b8591787c541b17de68', '2020-06-08 19:02:02', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('dba8bc9822aa4aaa88f48a9490996c6b', '2020-06-08 19:02:05', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('e13a79232c0845d29f90f24db17f4aa0', '2020-06-08 19:02:03', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('e384e2eca90e4258a2e9f959f3efc0ff', '2020-06-08 19:01:22', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('e412b75cde4f42bd853f596778b83eb1', '2020-06-08 17:51:34', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('e41749c835ac4eb2bbb6fe6092c72a52', '2020-06-08 19:02:02', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('e92d68374d9246e390df19df9d0c8234', '2020-06-08 19:00:33', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('e9c3d777f1ac44029d6f14bceb4fe5ad', '2020-06-08 19:00:53', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('ec6f52d01f1143bd9373a5e6aec7b76d', '2020-06-08 19:01:53', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('edfe4abefb7641788c22c54a88be68a1', '2020-06-08 19:02:02', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('ef77bf3731934f1d86a6a4c73fce3f29', '2020-06-08 19:02:02', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('f2ba7ad5437240a0a1f6aabf815942a1', '2020-06-08 19:02:04', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('f4bf60a8c1664560aaf8c673300beb8f', '2020-06-08 19:04:10', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');
INSERT INTO `detectiondata` VALUES ('fc9eae27c20d4df197a1487d4aa8364c', '2020-06-08 19:02:05', '123124124', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for detedata
-- ----------------------------
DROP TABLE IF EXISTS `detedata`;
CREATE TABLE `detedata` (
  `ddata_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ddata_time` datetime NOT NULL,
  `eq_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `data_a` float NOT NULL,
  `data_b` float NOT NULL,
  `data_c` float NOT NULL,
  `data_d` float NOT NULL,
  PRIMARY KEY (`ddata_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of detedata
-- ----------------------------

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `eq_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eq_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eq_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eq_inner_num` int(11) NOT NULL,
  `eq_create_time` datetime NOT NULL,
  `eq_add_time` datetime NOT NULL,
  `eq_state` int(11) NOT NULL COMMENT '是否禁用',
  `eq_other` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`eq_id`,`eq_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '小米充电宝1', '充电宝', '1', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('10', '热水壶1', '热水壶', '4', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('11', '热水壶2', '热水壶', '4', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('12', '热水壶3', '热水壶', '4', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('13', '防护套装1', '防护套装', '3', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('14', '防护套装2', '防护套装', '5', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('15', '防护套装3', '防护套装', '5', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('2', '小米充电宝2', '充电宝', '1', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('3', '小米充电宝3', '充电宝', '1', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('4', '反应桶1', '反应桶', '2', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('5', '反应桶2', '反应桶', '2', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('6', '反应桶3', '反应桶', '2', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('7', '反应器1', '反应器', '3', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('8', '反应器2', '反应器', '3', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('9', '反应器3', '反应器', '3', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material` (
  `material_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ma_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ma_number` int(10) unsigned NOT NULL,
  `ma_other` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`material_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('101', '除醛A', '9000', null);
INSERT INTO `material` VALUES ('201', '除醛B', '10000', null);
INSERT INTO `material` VALUES ('301', '消毒A', '10000', null);
INSERT INTO `material` VALUES ('401', '消毒B', '10000', null);
INSERT INTO `material` VALUES ('501', '汽车治理包', '10000', null);

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator` (
  `op_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_state` int(10) unsigned DEFAULT NULL,
  `wx_openid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`op_id`,`op_phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES ('1', '待分配', '123', '15871757994', '0', null);
INSERT INTO `operator` VALUES ('2', '操作员1', 'Xjw123456', '15871757777', '0', 'op_Qp4zaFfjAfCZQbeODTk6fqEUc');
INSERT INTO `operator` VALUES ('3', '操作员2', 'Xjw123456', '15871758888', '0', '');

-- ----------------------------
-- Table structure for process
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `process_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pro_generator` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pro_sampler` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pro_report` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pro_result` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pro_eq` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pro_material` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pro_starttime` datetime DEFAULT NULL,
  `pro_state` int(10) unsigned DEFAULT NULL,
  `pro_endtime` datetime DEFAULT NULL,
  `pro_pictures` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ddata_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `express_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `express_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pro_counttime` int(11) DEFAULT NULL,
  PRIMARY KEY (`process_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of process
-- ----------------------------
INSERT INTO `process` VALUES ('123', '123', '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `process` VALUES ('6f91f43d2e3840859eb67c36caee20ee', '123213', '1509a3a1d11344fc85eac0c37f959908', null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard` (
  `st_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `st_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `st_idcard` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `st_year` year(4) NOT NULL,
  PRIMARY KEY (`st_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of standard
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '哈希加密取16位',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `user_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_gender` int(11) DEFAULT NULL,
  `open_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`,`user_phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('015891924989071', 'ac59075b964b0715', '17786028888', '张三', '1', '213124124');
INSERT INTO `user` VALUES ('015893358205961', 'e6dd63397f1d335c', '13211111112', '李四', '1', null);
INSERT INTO `user` VALUES ('015895279629461', '0822da7ea481a653', '13911112222', '王五', '1', 'op_Qp49dqJRed4Qlb5dRW7Qs_wMU');

-- ----------------------------
-- Table structure for userorder
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder` (
  `order_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_state` int(11) DEFAULT NULL,
  `order_createtime` datetime NOT NULL,
  `order_time` datetime NOT NULL,
  `order_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `order_modelf` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_scope` float unsigned DEFAULT NULL,
  `order_descripe` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `order_address` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_others` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `order_cost` float DEFAULT NULL,
  `order_pollution` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `order_moremoney` tinyint(1) unsigned zerofill DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of userorder
-- ----------------------------
INSERT INTO `userorder` VALUES ('1509a3a1d11344fc85eac0c37f959908', '015893358205961', '1', '0', '2020-05-13 12:38:33', '2020-05-13 12:38:07', '2', '/Users/pengyuquan/Desktop/1589344713621wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.MnGUnONhECM17a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg', '111', '家居装修', '武汉市', '徐俊伟', '13211111111', '其它111', '100.9', '甲醛', null);
INSERT INTO `userorder` VALUES ('45afa032660b46539c5e1f1639d0c762', '015895279629461', '1', '0', '2020-05-15 15:33:52', '2020-05-15 15:32:56', '2', '/Users/pengyuquan/Desktop/1589528032066wx0656326b8fdbe56f.o6zAJs5QFg7Go9_V9BOU0yT_sVOA.JITjaJKjiHfhba470c02f02389f67babdfabd606d248.jpg', '120', '三室二厅', '安徽省安庆市', '笑话', '13911112222', '', '100.9', '甲醛', null);
INSERT INTO `userorder` VALUES ('5a5be5c1d0df4960b07327cbb114157f', '015893358205961', '2', '0', '2020-05-14 15:01:28', '2020-05-14 15:00:05', '2', '/Users/pengyuquan/Desktop/1589439688302wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.G9MLxs6bSDc47a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg', '112', '家居装修', '北京市海淀区', '小明啊', '13211111111', '无其它说明', '100.9', '甲醛1', null);
INSERT INTO `userorder` VALUES ('8a947089a884420eb75bc474c81bd6aa', '015893358205961', '2', '0', '2020-05-13 12:43:25', '2020-05-13 12:42:49', '2', '/Users/pengyuquan/Desktop/1589345005694wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.7i6bwJXOFhXg7a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg', '112', '家居装修', '武汉市洪山区', '徐俊伟12', '13211111111', '其它123', '100.9', '甲醛', null);
