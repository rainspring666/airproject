/*
 Navicat Premium Data Transfer

 Source Server         : document
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : air_system

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 01/07/2020 00:36:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `admin_role` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`, `admin_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for detectiondata
-- ----------------------------
DROP TABLE IF EXISTS `detectiondata`;
CREATE TABLE `detectiondata`  (
  `ddata_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ddata_time` datetime(0) NOT NULL,
  `process_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pm1_0` float NULL DEFAULT NULL,
  `um0_3` float NULL DEFAULT NULL,
  `um2_5` float NULL DEFAULT NULL,
  `pm2_5` float NULL DEFAULT NULL,
  `um0_5` float NULL DEFAULT NULL,
  `um5_0` float NULL DEFAULT NULL,
  `pm10` float NULL DEFAULT NULL,
  `um1_0` float NULL DEFAULT NULL,
  `um10` float NULL DEFAULT NULL,
  `hcho` float NULL DEFAULT NULL,
  `tvoc` float NULL DEFAULT NULL,
  `co2` float NULL DEFAULT NULL,
  `temp` float NULL DEFAULT NULL,
  `rh` float NULL DEFAULT NULL,
  PRIMARY KEY (`ddata_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of detectiondata
-- ----------------------------
INSERT INTO `detectiondata` VALUES ('b2f0c416459a4f8cb7dd4164807e0c43', '2020-07-01 00:21:13', '148f31c151a4493699b9bc14b4193863', 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11);

-- ----------------------------
-- Table structure for detedata
-- ----------------------------
DROP TABLE IF EXISTS `detedata`;
CREATE TABLE `detedata`  (
  `ddata_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ddata_time` datetime(0) NOT NULL,
  `eq_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `data_a` float NOT NULL,
  `data_b` float NOT NULL,
  `data_c` float NOT NULL,
  `data_d` float NOT NULL,
  PRIMARY KEY (`ddata_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of detedata
-- ----------------------------

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment`  (
  `eq_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eq_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eq_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `eq_inner_num` int(0) NOT NULL,
  `eq_create_time` datetime(0) NOT NULL,
  `eq_add_time` datetime(0) NOT NULL,
  `eq_state` int(0) NOT NULL COMMENT '是否禁用',
  `eq_other` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`eq_id`, `eq_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '小米充电宝1', '充电宝', 98, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('10', '热水壶1', '热水壶', 97, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('11', '热水壶2', '热水壶', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('12', '热水壶3', '热水壶', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('13', '防护套装1', '防护套装', 97, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('14', '防护套装2', '防护套装', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('15', '防护套装3', '防护套装', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('2', '小米充电宝2', '充电宝', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('3', '小米充电宝3', '充电宝', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('4', '反应桶1', '反应桶', 197, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('5', '反应桶2', '反应桶', 200, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('6', '反应桶3', '反应桶', 200, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('7', '反应器1', '反应器', 297, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('8', '反应器2', '反应器', 300, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('9', '反应器3', '反应器', 300, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `material_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ma_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ma_number` int(0) UNSIGNED NOT NULL,
  `ma_other` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`material_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('101', '除醛A', 9997, NULL);
INSERT INTO `material` VALUES ('201', '除醛B', 9992, NULL);
INSERT INTO `material` VALUES ('301', '消毒A', 9991, NULL);
INSERT INTO `material` VALUES ('401', '消毒B', 9994, NULL);
INSERT INTO `material` VALUES ('501', '汽车治理包', 9992, NULL);

-- ----------------------------
-- Table structure for operator
-- ----------------------------
DROP TABLE IF EXISTS `operator`;
CREATE TABLE `operator`  (
  `op_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_state` int(0) UNSIGNED NULL DEFAULT NULL,
  `wx_openid` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`op_id`, `op_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of operator
-- ----------------------------
INSERT INTO `operator` VALUES ('1', '待分配', '123', '15871757994', 0, NULL);
INSERT INTO `operator` VALUES ('2', '操作员1', 'Xjw123456', '15871757777', 0, 'op_Qp4zaFfjAfCZQbeODTk6fqEUc');
INSERT INTO `operator` VALUES ('3', '操作员2', 'Xjw123456', '15871758888', 0, '');

-- ----------------------------
-- Table structure for process
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process`  (
  `process_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pro_generator` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pro_sampler` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pro_report` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pro_result` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pro_eq` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pro_material` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pro_starttime` datetime(0) NULL DEFAULT NULL,
  `pro_state` int(0) UNSIGNED NULL DEFAULT NULL,
  `pro_endtime` datetime(0) NULL DEFAULT NULL,
  `pro_pictures` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ddata_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `express_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `express_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pro_counttime` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`process_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of process
-- ----------------------------
INSERT INTO `process` VALUES ('148f31c151a4493699b9bc14b4193863', '015935324723271', '865fb649afc94308aa2cc1fee7012a31', NULL, NULL, NULL, NULL, NULL, NULL, '2020-07-01 00:21:37', 1, NULL, NULL, 'b2f0c416459a4f8cb7dd4164807e0c43', '123456789', '顺丰快递', 7200);

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard`  (
  `st_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `st_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `st_idcard` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `st_year` year NOT NULL,
  PRIMARY KEY (`st_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of standard
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_pwd` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '哈希加密取16位',
  `user_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '手机号码',
  `user_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_gender` int(0) NULL DEFAULT NULL,
  `open_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `user_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('015935324723271', '4ad2f3f983039797', '13211111112', '', 1, 'op_Qp4zaFfjAfCZQbeODTk6fqEUc');
INSERT INTO `user` VALUES ('015935327031551', 'a4aeeae1229b9790', '18327155159', '', 1, 'op_Qp49dqJRed4Qlb5dRW7Qs_wMU');

-- ----------------------------
-- Table structure for userorder
-- ----------------------------
DROP TABLE IF EXISTS `userorder`;
CREATE TABLE `userorder`  (
  `order_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `op_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_state` int(0) NULL DEFAULT NULL,
  `order_createtime` datetime(0) NOT NULL,
  `order_time` datetime(0) NOT NULL,
  `order_class` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_modelf` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_scope` float UNSIGNED NULL DEFAULT NULL,
  `order_descripe` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_address` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `order_others` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_cost` float NULL DEFAULT NULL,
  `order_pollution` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_moremoney` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of userorder
-- ----------------------------
INSERT INTO `userorder` VALUES ('865fb649afc94308aa2cc1fee7012a31', '015935324723271', '2', 1, '2020-07-01 00:16:40', '2020-07-01 10:07:00', '1', 'C:/Users/mhh/Desktop/1593533799627tmp_8f2251564e6c5cfbb075fdeeac0bfcf7bf5b81418bf980d6.jpg', 121, '三室两厅', '武汉市洪山区珞狮路112号', '徐俊伟', '13211111112', '测试使用1', 100.9, '甲醛', NULL);

SET FOREIGN_KEY_CHECKS = 1;