/*
Navicat MySQL Data Transfer

Source Server         : first
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : air_system

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-07-15 21:47:46
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
INSERT INTO `detectiondata` VALUES ('0e3efe6648b34117bece49a5a5de4e2d', '2020-07-01 15:26:49', '3adbeec25c674ce29e907e174978d5d5', '111', '11', '121', '124', '124', '154', '142', '124', '124', '12', '12', '125', '22', '54');
INSERT INTO `detectiondata` VALUES ('8c932dc416e74ef5b30213a37c92a1ba', '2020-07-01 15:47:12', '750894b452cc420bac4df89e933746d8', '11', '112', '134', '121', '11', '124', '14', '125', '123', '12', '12', '52', '22', '54');
INSERT INTO `detectiondata` VALUES ('b2f0c416459a4f8cb7dd4164807e0c43', '2020-07-01 00:21:13', '148f31c151a4493699b9bc14b4193863', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11', '11');
INSERT INTO `detectiondata` VALUES ('e6eeb72d4e1d437b8e1156c1ac4a435a', '2020-07-01 15:47:13', '750894b452cc420bac4df89e933746d8', '11', '112', '134', '121', '11', '124', '14', '125', '123', '12', '12', '52', '22', '54');

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
  PRIMARY KEY (`eq_id`,`eq_type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '小米充电宝1', '充电宝', '96', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('10', '热水壶1', '热水壶', '96', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('11', '热水壶2', '热水壶', '100', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('12', '热水壶3', '热水壶', '100', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('13', '防护套装1', '防护套装', '94', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('14', '防护套装2', '防护套装', '100', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('15', '防护套装3', '防护套装', '100', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('2', '小米充电宝2', '充电宝', '100', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('3', '小米充电宝3', '充电宝', '100', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('4', '反应桶1', '反应桶', '195', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('5', '反应桶2', '反应桶', '200', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('6', '反应桶3', '反应桶', '200', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('7', '反应器1', '反应器', '294', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('8', '反应器2', '反应器', '300', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');
INSERT INTO `equipment` VALUES ('9', '反应器3', '反应器', '300', '2020-06-05 10:13:54', '2020-06-05 10:14:02', '0', '描述');

-- ----------------------------
-- Table structure for firm
-- ----------------------------
DROP TABLE IF EXISTS `firm`;
CREATE TABLE `firm` (
  `firm_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司id',
  `firm_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司名称',
  `firm_ceo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司老总',
  PRIMARY KEY (`firm_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of firm
-- ----------------------------

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
INSERT INTO `material` VALUES ('101', '除醛A', '9994', null);
INSERT INTO `material` VALUES ('201', '除醛B', '9989', null);
INSERT INTO `material` VALUES ('301', '消毒A', '9987', null);
INSERT INTO `material` VALUES ('401', '消毒B', '9992', null);
INSERT INTO `material` VALUES ('501', '汽车治理包', '9992', null);

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
INSERT INTO `operator` VALUES ('2', '操作员1', 'Xjw123456', '15871757777', '10', 'op_Qp4zaFfjAfCZQbeODTk6fqEUc');
INSERT INTO `operator` VALUES ('3', '操作员2', 'Xjw123456', '15871758888', '10', '');

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
  `report_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`process_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of process
-- ----------------------------
INSERT INTO `process` VALUES ('148f31c151a4493699b9bc14b4193863', '015935324723271', '865fb649afc94308aa2cc1fee7012a31', null, null, null, null, null, null, '2020-07-01 00:21:37', '1', null, null, 'b2f0c416459a4f8cb7dd4164807e0c43', '123456789', '顺丰快递', '7200', null);
INSERT INTO `process` VALUES ('3adbeec25c674ce29e907e174978d5d5', '015935872869631', 'bbefd7dd57374f30af5dc11900fa3968', null, null, null, null, null, null, '2020-07-01 15:27:09', '1', null, null, '0e3efe6648b34117bece49a5a5de4e2d', '15743165821', '顺丰快递', '7200', null);
INSERT INTO `process` VALUES ('750894b452cc420bac4df89e933746d8', '015935872869631', 'd4cb6d43f5c948628b46535293276190', null, null, null, null, null, null, '2020-07-01 15:47:24', '1', null, null, 'e6eeb72d4e1d437b8e1156c1ac4a435a', '15741236543', '顺丰快递', '7200', null);
INSERT INTO `process` VALUES ('80d610611e5148d1b78f0b853e930bb6', '015935872869631', 'bbefd7dd57374f30af5dc11900fa3968', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `report_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报告ID',
  `describes` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '概述',
  `picurl` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片路径',
  `operate_plan` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '消杀方案',
  `create_time` datetime DEFAULT NULL COMMENT '生成报告时间',
  `validation` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '效果验证',
  `site_condition` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '现场情况描述',
  PRIMARY KEY (`report_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '角色表主键',
  `role_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理员');
INSERT INTO `role` VALUES ('2', 'operator', '操作员');
INSERT INTO `role` VALUES ('3', 'customer', '普通用户');

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
  `open_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`,`user_phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('015935324723271', '4ad2f3f983039797', '13211111112', 'op_Qp4zaFfjAfCZQbeODTk6fqEUc');
INSERT INTO `user` VALUES ('015935327031551', 'a4aeeae1229b9790', '18327155159', 'op_Qp49dqJRed4Qlb5dRW7Qs_wMU');

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
INSERT INTO `userorder` VALUES ('865fb649afc94308aa2cc1fee7012a31', '015935324723271', '2', '1', '2020-07-01 00:16:40', '2020-07-01 10:07:00', '1', 'C:/Users/mhh/Desktop/1593533799627tmp_8f2251564e6c5cfbb075fdeeac0bfcf7bf5b81418bf980d6.jpg', '121', '三室两厅', '武汉市洪山区珞狮路112号', '徐俊伟', '13211111112', '测试使用1', '100.9', '甲醛', null);
INSERT INTO `userorder` VALUES ('97b17e7969514e99bf8a4ad05ec259c3', '015935893022131', '1', '0', '2020-07-01 15:43:08', '2020-07-03 09:01:00', '1', 'C:/Users/mhh/Desktop/1593589388283tmp_c8a7b92c733702753941da193cec7003373bd06d2d802006.jpg', '111', '三室两厅', '湖北省武汉市洪山区珞狮路112号', '徐俊伟', '17737109738', '请尽快处理', '100.9', '甲醛', null);
INSERT INTO `userorder` VALUES ('bbefd7dd57374f30af5dc11900fa3968', '015935872869631', '3', '1', '2020-07-01 15:16:12', '2020-07-03 15:00:00', '1', 'C:/Users/mhh/Desktop/1593587771868tmp_dcefe133244c5e649e157bb1af60bc82003000d0010e4a34.jpg', '110', '三室一厅', '湖北省武汉市洪山区珞狮路112号', '谢霆锋', '15872415355', '请及时处理', '100.9', '甲醛', null);
INSERT INTO `userorder` VALUES ('d4cb6d43f5c948628b46535293276190', '015935872869631', '2', '1', '2020-07-01 15:10:40', '2020-07-04 10:00:00', '2', 'C:/Users/mhh/Desktop/1593587440393tmp_9f297fb96e3cd1169405d3fdfc8ad21ecffd28c81bb05488.jpg', '121', '三室两厅', '湖北省武汉市洪山区珞狮路122号', '徐俊伟', '13211115421', '请尽快处理检测', '100.9', '甲醛', null);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_gender` int(11) DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `firm_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司ID--->公司',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_role_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户角色对应表主键',
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户表外键',
  `role_id` int(10) unsigned NOT NULL COMMENT '角色表外键',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '015935324723271', '1');
INSERT INTO `user_role` VALUES ('2', '015935327031551', '2');
