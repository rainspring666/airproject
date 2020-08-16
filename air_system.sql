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

 Date: 15/08/2020 18:33:10
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
INSERT INTO `detectiondata` VALUES ('18063be3ea784374bae7f6d5991f91f3', '2020-08-11 21:31:58', '9057ec604c194fafba64285a2cea0a24', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('187c942abf3040eaa1905786016ebb18', '2020-08-12 14:51:01', 'ebd292b4429d42089c834bf71bfb81b8', 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('1c05c45a39684070a4e82c90e13865fc', '2020-08-11 21:00:36', '39a694aaa2d940ceb7a65e49bbf4cbd6', 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('1f291abf7b2d4c2aa0079bb2947f62c0', '2020-08-06 21:34:07', '61e620bca980440c8dc2861e23f53ec2', 0, 0, 0, 0, 0, 1111, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('2af49b58f4c74fe18d40fd27c5ba6ee6', '2020-08-06 20:54:42', '61e620bca980440c8dc2861e23f53ec2', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `detectiondata` VALUES ('7a5b5ae4884545f899eb4106b8f17601', '2020-07-31 22:45:56', '9292d8ea120e4f9596cbbb47ded30621', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('80ea78f6de1240e6af170d8356c59c33', '2020-08-10 23:36:57', '8ea604f9bdb84e888cf2a2b137bc0c1c', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('847748c9d1474b38a814d077cc75b5e6', '2020-08-07 22:54:27', '48f5ab8f7a3a48d0a51e2b71575e9266', 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('85d2b33e52e1474185414ab1725c1bd0', '2020-08-07 22:46:54', '862a80cc645d4ceda944282268e07806', 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('93299fa585544bccb31eec9d1c3bfa0d', '2020-08-10 23:48:58', '089b3a8321dc485193734eb52b990ec2', 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('9c95f0d592224d3883b4bfde2314d03e', '2020-08-11 20:58:35', '9ad7a161a0ce4448aced4920f34f19f1', 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('b02a2a4abee448d6b0b0faa45606ccc2', '2020-08-10 23:44:15', '8ea604f9bdb84e888cf2a2b137bc0c1c', 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('c9f39ed836e54c5788a74833babe39fe', '2020-08-01 09:52:00', '3a7e0ace35484a0480c3c35475b50739', 1, 1, 1, 2, 2, 1, 2, 4, 3, 2, 25, 25, 25, 58);
INSERT INTO `detectiondata` VALUES ('cc828e7abcf64491b81e36d2dfde26fb', '2020-08-06 21:00:47', '61e620bca980440c8dc2861e23f53ec2', 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('d97a3d4842914d07af4f2220f84fa7d0', '2020-08-07 23:04:19', 'a04d9c334df24e34a198c09eee71c7d8', 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('e9f4e21c5fb94d8c929a7e30440166fe', '2020-07-31 22:47:07', '9292d8ea120e4f9596cbbb47ded30621', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

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
INSERT INTO `equipment` VALUES ('1', '小米充电宝1', '充电宝', 95, '2020-06-05 10:13:54', '2020-08-01 09:59:01', 0, '描述');
INSERT INTO `equipment` VALUES ('10', '热水壶1', '热水壶', 88, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('11', '热水壶2', '热水壶', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('12', '热水壶3', '热水壶', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('13', '防护套装1', '防护套装', 87, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('14', '防护套装2', '防护套装', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('15', '防护套装3', '防护套装', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('2', '小米充电宝2', '充电宝', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('3', '小米充电宝3', '充电宝', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('4', '反应桶1', '反应桶', 186, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('5', '反应桶2', '反应桶', 200, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('6', '反应桶3', '反应桶', 200, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('7', '反应器1', '反应器', 285, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('8', '反应器2', '反应器', 300, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('9', '反应器3', '反应器', 300, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');

-- ----------------------------
-- Table structure for firm
-- ----------------------------
DROP TABLE IF EXISTS `firm`;
CREATE TABLE `firm`  (
  `firm_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司id',
  `firm_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `firm_ceo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司老总',
  PRIMARY KEY (`firm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of firm
-- ----------------------------

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
INSERT INTO `material` VALUES ('101', '除醛A', 9999, '');
INSERT INTO `material` VALUES ('201', '除醛B', 9983, NULL);
INSERT INTO `material` VALUES ('301', '消毒A', 9985, NULL);
INSERT INTO `material` VALUES ('401', '消毒B', 9990, NULL);
INSERT INTO `material` VALUES ('501', '汽车治理包', 9991, NULL);

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
INSERT INTO `operator` VALUES ('1', '待分配', '123', '15871757994', 10, NULL);
INSERT INTO `operator` VALUES ('2', '操作员1', 'Xjw123456', '15871757777', 10, 'op_Qp4zaFfjAfCZQbeODTk6fqEUc');
INSERT INTO `operator` VALUES ('3', '操作员2', 'Xjw123456', '15871758888', 10, '');

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
  `report_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`process_id`, `order_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of process
-- ----------------------------
INSERT INTO `process` VALUES ('04c6805388f647bbab4b08d544a22d3d', '015971553021121', 'e666421f2f5640b0975b5962d98c8d88', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `process` VALUES ('089b3a8321dc485193734eb52b990ec2', '015935324723111', '79259e472e594757bae7e65ff69b39a3', NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-10 23:49:13', 24, NULL, NULL, '93299fa585544bccb31eec9d1c3bfa0d', '987465', '中通快递', 10800, '01d12daa3a6d4b0d84d37397f8a9869d');
INSERT INTO `process` VALUES ('2158d2e1cde543ecb59f881e0bad3e35', '015935324723111', '052fb61135af4251a95c1953346b141a', '/order/052fb61135af4251a95c1953346b141a/确认交易.png', NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, 0, '757d50756cd846ab8b82d85bc331a388');
INSERT INTO `process` VALUES ('39a694aaa2d940ceb7a65e49bbf4cbd6', '015935324723111', '73f7dd8ef15b42818b3f43f63c691890', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 22, NULL, NULL, '', NULL, NULL, 0, '');
INSERT INTO `process` VALUES ('48f5ab8f7a3a48d0a51e2b71575e9266', '015935324723111', 'b8e0f1d30a6346fa94ad1c3a3414bad9', NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-07 22:54:45', 24, NULL, NULL, '847748c9d1474b38a814d077cc75b5e6', '', '', 7200, '9852831490f64a648f264b808ba41238');
INSERT INTO `process` VALUES ('53620ab19ac14b6cafa8ceeb0cabd901', '015970688514901', '0667a14694db400b8ef62ac8fbb7276a', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `process` VALUES ('61e620bca980440c8dc2861e23f53ec2', '015935324723271', '07e9906ee0174e49905e4419c918c4b3', '/order/07e9906ee0174e49905e4419c918c4b3/合约交互.png', NULL, NULL, NULL, NULL, NULL, '2020-08-06 21:01:43', 24, NULL, NULL, '1f291abf7b2d4c2aa0079bb2947f62c0', '123', 'shu顺丰', 7200, '0f685b2d19e7412586a98609c16aa63d');
INSERT INTO `process` VALUES ('6735a69fb49e449783d3142b3400c7a6', '015971557770981', '99a22be37b6249f0bcc02ffb21317e52', '/order/99a22be37b6249f0bcc02ffb21317e52/合约交互.png', NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, 0, NULL);
INSERT INTO `process` VALUES ('7f0352baba4a4ff59da41bcf604fa8de', '015935324723111', 'a70b9efb79d64650b73bac3c81002e6e', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `process` VALUES ('862a80cc645d4ceda944282268e07806', '015935324723111', '97dd7092ea594428a977a7ad77922a01', NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-07 22:47:07', 21, NULL, NULL, '85d2b33e52e1474185414ab1725c1bd0', '', '', 7200, '8fe40ea7ae50497cb5f0f25d8a64dc9d');
INSERT INTO `process` VALUES ('8ea604f9bdb84e888cf2a2b137bc0c1c', '015935324723111', 'db6aaef932044453a40558b61dffb5e5', '', NULL, NULL, NULL, NULL, NULL, NULL, 23, NULL, NULL, 'b02a2a4abee448d6b0b0faa45606ccc2', NULL, NULL, 0, '76e8110eaa18485e8a9686b5343404a1');
INSERT INTO `process` VALUES ('9057ec604c194fafba64285a2cea0a24', '015935324723111', '821b89badb6343968b523b91ad61ac13', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 23, NULL, NULL, '18063be3ea784374bae7f6d5991f91f3', NULL, NULL, 0, '277fef387eb5400b880f0804fba26eaf');
INSERT INTO `process` VALUES ('9292d8ea120e4f9596cbbb47ded30621', '015935324723271', 'e58ebc0583e843548c5b54bb5e3acaf8', '/order/e58ebc0583e843548c5b54bb5e3acaf8/合约交互.png', NULL, NULL, NULL, NULL, NULL, '2020-07-31 22:47:20', 20, NULL, NULL, 'e9f4e21c5fb94d8c929a7e30440166fe', '1111', '顺丰', 21600, '750642e86c2c46b2b2c50666f6c3ace8');
INSERT INTO `process` VALUES ('9ad7a161a0ce4448aced4920f34f19f1', '015935324723111', 'c340d433576448bcaba72c93bf6024f2', NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-11 20:58:43', 24, NULL, NULL, '9c95f0d592224d3883b4bfde2314d03e', '123456789', '中通快递', 7200, '2d5fb64f98e7437fbb3f7fc7d824d9a4');
INSERT INTO `process` VALUES ('a04d9c334df24e34a198c09eee71c7d8', '015935324723271', '91f81cb63d8d4aa7a24673649c0d6792', NULL, NULL, NULL, NULL, NULL, NULL, '2020-08-11 20:58:43', 24, NULL, NULL, 'd97a3d4842914d07af4f2220f84fa7d0', '13265487', '顺丰', 0, 'ccf745c3eb524c469e72ae156adb9566');
INSERT INTO `process` VALUES ('ad26137c394f4fe1b19169cfd00393d8', '015935324723111', 'e1b7bd7b3eca4c12b34950059c899371', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `process` VALUES ('d049b35e62a1408aa8faad65a1463ff1', '015935324723111', '28c2d894dde7490f8617ccc127b68ae5', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `process` VALUES ('ebd292b4429d42089c834bf71bfb81b8', '015935324723111', 'fc7057d6294f412abc8e3884dbc3074d', '/order/fc7057d6294f412abc8e3884dbc3074d/合约部署.png', NULL, NULL, NULL, NULL, NULL, NULL, 23, NULL, NULL, '187c942abf3040eaa1905786016ebb18', NULL, NULL, 0, 'c45958b901ee4af2bf88ffcbc25505ee');
INSERT INTO `process` VALUES ('f6aa74bfde0147dc81e6efb4c413c8c8', '015935324723111', '3fcd9f2673214af7ad69ac6ffd804164', '/order/3fcd9f2673214af7ad69ac6ffd804164/确认交易.png', NULL, NULL, NULL, NULL, NULL, NULL, 20, NULL, NULL, NULL, NULL, NULL, 0, NULL);

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report`  (
  `report_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报告ID',
  `describes` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '概述',
  `picurl` varchar(4096) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
  `operate_plan` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消杀方案',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '生成报告时间',
  `validation` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '效果验证',
  `site_condition` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现场情况描述',
  `report_url` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报告存储路径',
  PRIMARY KEY (`report_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of report
-- ----------------------------
INSERT INTO `report` VALUES ('015b187b018147a287386d08f5bdc6c8', '测试1#', '', '', '2020-08-01 09:50:34', '0', '', NULL);
INSERT INTO `report` VALUES ('01d12daa3a6d4b0d84d37397f8a9869d', 'desc2222..#', 'report_img/2020/8/10/624f33dc91e3422697b677c1061d0e31.jpg@#', '', '2020-08-10 23:47:50', '0', '', NULL);
INSERT INTO `report` VALUES ('0f685b2d19e7412586a98609c16aa63d', '', '', '', '2020-08-15 12:25:49', '1', '', 'pdf/output/07e9906ee0174e49905e4419c918c4b3/fccdd162-f1de-4a8c-9788-db6a2966d864.pdf');
INSERT INTO `report` VALUES ('109668ca0cca422186a6be6503755ae3', '的市场1111111#', '', '', '2020-08-11 21:00:25', '0', '', NULL);
INSERT INTO `report` VALUES ('277fef387eb5400b880f0804fba26eaf', 'desc1111111#desc11111mm#', 'report_img/2020/8/11/0725a72d3bbf46f8a74b75f0c91b37a9.jpg@#report_img/2020/8/11/3c4f92986e5a4b8ba714eaa33d7146c3.jpg@#', '', '2020-08-11 21:25:03', '0', '', NULL);
INSERT INTO `report` VALUES ('2d5fb64f98e7437fbb3f7fc7d824d9a4', '', '', '', '2020-08-15 18:27:17', '', '', 'pdf/output/c340d433576448bcaba72c93bf6024f2/a6461a75-d4f3-4926-927e-a01dfd42f640.pdf');
INSERT INTO `report` VALUES ('39e24caed53e4db3a81ce5e0520f5563', '', '', '', '2020-07-31 22:53:07', '0', '', NULL);
INSERT INTO `report` VALUES ('6c978061f9284affa172c11faa137607', '', 'report_img/2020/8/11/fe51f0b273134f0ba2cce28d8eb0a555.jpg@#', '', '2020-08-11 21:00:26', '0', '', NULL);
INSERT INTO `report` VALUES ('750642e86c2c46b2b2c50666f6c3ace8', '搞快滴\n11#来吧#', 'report_img/2020/7/31/62146328301f4b0eb4ca000582877789.jpg@#report_img/2020/7/31/271cfc58f201422a8b1d545e8f4ebedc.jpg@#report_img/2020/7/31/48b5ffa7b86d494fa05a04e49ed9b45a.jpg@#', '', '2020-07-31 22:46:24', '0', '', NULL);
INSERT INTO `report` VALUES ('757d50756cd846ab8b82d85bc331a388', '', '', '', '2020-08-10 22:15:13', '0', '', NULL);
INSERT INTO `report` VALUES ('76e8110eaa18485e8a9686b5343404a1', 'desc1111#desc1111.#desc111...#', 'report_img/2020/8/10/def9f94b05e049ce882440f3e1bc5e7e.jpg@#report_img/2020/8/10/42fa2640afa24c3f8d837323f088b55f.jpg@#report_img/2020/8/10/ed39fc0281504a1bb71948a1d06d07ed.jpg@#', '', '2020-08-10 23:23:26', '0', '', NULL);
INSERT INTO `report` VALUES ('83824a03176b4d84906d19c0e5397947', 'desc111...#desc222...#', 'report_img2020/7/26/6438d782f0104cb0b9d13330a1fec319.jpg@report_img2020/7/26/14754ade3589487387be57f004274b10.jpg@#report_img2020/7/26/9a917fbe08fe46278dacbdc59005555a.png@report_img2020/7/26/b5287856e26a46698e76f52614be3d9c.png@#', '', '2020-07-22 21:32:47', '0', '', NULL);
INSERT INTO `report` VALUES ('8fe40ea7ae50497cb5f0f25d8a64dc9d', '施工132#施工123#', '#report_img/2020/8/7/3d17e016961d41c1b55212653c964a54.jpg@#', '', '2020-08-07 22:44:36', '0', '', NULL);
INSERT INTO `report` VALUES ('9852831490f64a648f264b808ba41238', '', '', '', '2020-08-15 12:31:48', '1', '', 'pdf/output/b8e0f1d30a6346fa94ad1c3a3414bad9/4003863f-3028-4d2c-b2ef-8fa54fb6cdb5.pdf');
INSERT INTO `report` VALUES ('a2c716659ddc4c52ac65c9fc963ea20f', 'desc111...#desc222...#', 'report_img/2020/7/26/7e1619cecfbf48629080b5454cc01a88.jpg@report_img/2020/7/26/e03a3587883644c7b0872c57dd9e4d4b.jpg@#report_img/2020/7/26/00e6515156d84ad3927af856ff7373d4.png@report_img/2020/7/26/af7afa511dd84070bdafff16dc6b1b79.png@#', '', '2020-07-26 21:49:03', '0', '', NULL);
INSERT INTO `report` VALUES ('ab48f66e928e4ed49f0e2b67420195c2', '', 'report_img/2020/8/7/dbb472247aa848afb09b34a1dd37e6b6.jpg@', '', '2020-08-07 22:44:36', '0', '', NULL);
INSERT INTO `report` VALUES ('c45958b901ee4af2bf88ffcbc25505ee', '描述1#描述22#', 'report_img/2020/8/12/368ae264f3884ae79a778675f764f7ae.jpg@report_img/2020/8/12/1631fb9f3fae4a68a60bff2d534ea930.jpg@#report_img/2020/8/12/0db8e77e43c544b6b9f22578f745ff38.jpg@report_img/2020/8/12/be8fb866dff24b1eb0dfc1158cbe9915.jpg@#', '', '2020-08-12 14:48:58', '0', '', NULL);
INSERT INTO `report` VALUES ('ccf745c3eb524c469e72ae156adb9566', '', '', '', '2020-08-15 18:19:30', '', '', 'pdf/output/91f81cb63d8d4aa7a24673649c0d6792/4db9a936-2b47-447b-a3ba-9967daf585fe.pdf');
INSERT INTO `report` VALUES ('cfda08a88e9441058fea4a8cbe3cf33a', 'desc111111111#', '', '', '2020-08-11 20:58:13', '0', '', NULL);
INSERT INTO `report` VALUES ('ddecc0d7b5fe456aaf237b59a55794e3', '测试2#', 'report_img/2020/8/1/63c4a1f7ad9340679a0f906a32f221fd.jpg@report_img/2020/8/1/49f2e592f1484cd5874ec26a4d053b1b.jpg@#report_img/2020/8/1/f7171ce7012f4e9492bf43d0956653b0.jpg@#', '', '2020-08-01 09:50:34', '0', '', NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色表主键',
  `role_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (0, 'admin', '管理员');
INSERT INTO `role` VALUES (1, 'operator', '操作员');
INSERT INTO `role` VALUES (2, 'customer', '普通用户');
INSERT INTO `role` VALUES (3, 'employee', '公司员工');

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
  `open_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `user_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('015935324723111', '4ad2f3f983039797', '13211111112', 'op_Qp4zaFfjAfCZQbeODTk6fqEUc');
INSERT INTO `user` VALUES ('015935327031551', 'a4aeeae1229b9790', '18327155159', 'op_Qp49dqJRed4Qlb5dRW7Qs_wMU');
INSERT INTO `user` VALUES ('015970686465151', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015970694364711', 'Temp00000000', '1234567892', NULL);
INSERT INTO `user` VALUES ('015971251687831', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015971536231421', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015971553021121', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015971557770981', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015971563395961', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015972081253421', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015972081884121', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015972083999051', 'Temp00000000', '15927048974', NULL);
INSERT INTO `user` VALUES ('015972087868911', 'Temp00000000', '15927048974', NULL);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_gender` int(0) NULL DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `firm_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司ID--->公司',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('015935324723111', '待修改', '待修改', 0, '未知', '待修改');
INSERT INTO `user_info` VALUES ('015935324723271', '张三', '我靠靠靠靠', 1, '湖北武汉', '1');
INSERT INTO `user_info` VALUES ('015935327031551', '李四', '大风起兮云飞扬', 2, '北京', '1');
INSERT INTO `user_info` VALUES ('015935893022131', '王五', '力拔山兮气盖世', NULL, NULL, NULL);
INSERT INTO `user_info` VALUES ('015970652656461', '待修改', '待修改', 0, '未知', '待修改');
INSERT INTO `user_info` VALUES ('015970652687371', '待修改', '待修改', 0, '未知', '待修改');
INSERT INTO `user_info` VALUES ('015970686465151', '待修改', '待修改', 0, '未知', '待修改');
INSERT INTO `user_info` VALUES ('015970688514901', 'user', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015970694364711', 'user', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015971251687831', 'user', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015971536231421', 'user', '游客', 0, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015971553021121', 'user', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015971557770981', 'user', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015971563395961', 'mhh', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015972081253421', 'user', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015972081884121', 'user', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015972083999051', 'user', '游客', 1, '湖北武汉', '0');
INSERT INTO `user_info` VALUES ('015972087868911', '武汉理工大学', '公司', 1, '湖北武汉', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `user_role_id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户角色对应表主键',
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户表外键',
  `role_id` int(0) UNSIGNED NOT NULL COMMENT '角色表外键',
  PRIMARY KEY (`user_role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, '015935324723271', 1);
INSERT INTO `user_role` VALUES (2, '015935327031551', 2);
INSERT INTO `user_role` VALUES (3, '015970688514901', 2);
INSERT INTO `user_role` VALUES (4, '015970694364711', 2);
INSERT INTO `user_role` VALUES (5, '015971251687831', 2);
INSERT INTO `user_role` VALUES (6, '015971536231421', 2);
INSERT INTO `user_role` VALUES (7, '015971553021121', 2);
INSERT INTO `user_role` VALUES (8, '015971557770981', 2);
INSERT INTO `user_role` VALUES (9, '015971563395961', 2);
INSERT INTO `user_role` VALUES (10, '015972081253421', 2);
INSERT INTO `user_role` VALUES (11, '015972081884121', 2);
INSERT INTO `user_role` VALUES (12, '015972083999051', 2);
INSERT INTO `user_role` VALUES (13, '015972087868911', 3);

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
INSERT INTO `userorder` VALUES ('0667a14694db400b8ef62ac8fbb7276a', '015970688514901', '2', 1, '2020-08-10 22:15:42', '2020-08-11 00:00:00', '3', 'hx_img_other_users/2020/8/10/a01d2d87e90741b9a8edd0f345bd0a55.png@', 100, '无', '湖北武汉111111', '李四', '15927048974', '无', 1000, '甲醛', 0);
INSERT INTO `userorder` VALUES ('07e9906ee0174e49905e4419c918c4b3', '015935324723271', '2', 2, '2020-08-01 09:44:04', '2020-08-10 11:00:00', '1', 'hx_img/2020/8/1/96a4c598012e45be8d9aa38ace762240.jpg@hx_img/2020/8/1/42310739bcc140d4a5a9153b84a3e4a0.jpg@', 152, '三室两厅', '武汉理工大学', '徐俊伟', '15927048977', '无其他', 100.9, '甲醛', 1);
INSERT INTO `userorder` VALUES ('28c2d894dde7490f8617ccc127b68ae5', '015935324723111', '2', 1, '2020-08-07 22:25:31', '2020-08-07 06:00:00', '1', 'hx_img/2020/8/7/36c06f825b9e416da84b9217da947e5f.jpg@', 15, '越野', '夏威夷', '吴彦祖', '15788886666', '吴彦祖的车', 100.9, '车污染', 1);
INSERT INTO `userorder` VALUES ('3fcd9f2673214af7ad69ac6ffd804164', '015935324723111', '2', 1, '2020-08-11 20:35:16', '2020-08-11 12:34:12', '2', 'hx_img/2020/8/11/49c1ed90103d432f858c010964aaf22a.jpg@', 56, '两室一厅', '上海', '花蝴蝶', '15676542314', '花蝴蝶', 100.9, '甲醛', 1);
INSERT INTO `userorder` VALUES ('73f7dd8ef15b42818b3f43f63c691890', '015935324723111', '2', 1, '2020-08-11 20:47:43', '2020-08-11 12:46:08', '2', 'hx_img/2020/8/11/52b8f6b8c95c4a0b890e27d96e8413ee.png@', 121, '三室一厅', '非洲', '朱一旦', '18838886686', '无其他。。。', 100.9, '甲醛', 0);
INSERT INTO `userorder` VALUES ('79259e472e594757bae7e65ff69b39a3', '015935324723111', '2', 1, '2020-08-10 22:45:11', '2020-08-10 22:43:44', '2', 'hx_img/2020/8/10/9de1d16ae9aa459f917dfeae87980866.jpg@', 111, '三室两厅', '武汉', '小鱼', '13214567654', '其它说明：小鱼', 100.9, '甲醛', 1);
INSERT INTO `userorder` VALUES ('91f81cb63d8d4aa7a24673649c0d6792', '015935324723271', '2', 2, '2020-07-31 22:27:53', '2020-07-31 22:27:11', '2', 'hx_img/2020/7/31/7c3a39205f0a47fdab11302ab8d1cffe.jpg@hx_img/2020/7/31/20eee2018cff44ca998b8e99d6963a94.jpg@', 120, '三室两厅', '北京大学', '小明', '18322221111', '无', 100.9, '甲醛', 0);
INSERT INTO `userorder` VALUES ('97dd7092ea594428a977a7ad77922a01', '015935324723111', '2', 1, '2020-08-07 22:06:44', '2020-08-07 22:04:26', '2', 'hx_img/2020/8/7/ab8994ef893e44d3a13ab4bbeeb109a5.jpg@', 124, '三十一厅', '上海', '鹿先森', '15842136542', '春风十里不如你', 100.9, '', 1);
INSERT INTO `userorder` VALUES ('99a22be37b6249f0bcc02ffb21317e52', '015971557770981', '2', 1, '2020-08-11 22:23:29', '2020-08-12 00:00:00', '2', 'hx_img_other_users/2020/8/11/736ac7feb14f4e7eb315652b36df758c.png@', 100, '三室一厅', '湖北武汉', '张三', '15927048974', '', 1000, '甲醛', 1);
INSERT INTO `userorder` VALUES ('a70b9efb79d64650b73bac3c81002e6e', '015935324723111', '2', 1, '2020-08-10 22:41:50', '2020-08-10 22:40:51', '2', 'hx_img/2020/8/10/14c55c0d4d4b4ad3b232bcdd821c9666.jpg@', 132, '三室两厅', '武汉', '毛慧华', '15871767777', '无其他', 100.9, '甲醛', 0);
INSERT INTO `userorder` VALUES ('b8e0f1d30a6346fa94ad1c3a3414bad9', '015935324723111', '2', 2, '2020-08-07 21:53:49', '2020-08-07 10:00:00', '1', 'hx_img/2020/8/7/691c7ea97d844cd38e50678f3524354f.jpg@', 111, '三室两厅', '武汉皇家理工', '徐俊伟', '17737109738', '无其他说明', 100.9, '甲醛', 1);
INSERT INTO `userorder` VALUES ('c340d433576448bcaba72c93bf6024f2', '015935324723111', '2', 2, '2020-08-11 20:33:54', '2020-08-11 12:32:57', '3', 'hx_img/2020/8/11/50b89b203a424331bbf9aa3f9d824484.jpg@', 12, '车辆', '北京', '小蚂蚁', '13214567890', '小蚂蚁-无其他', 100.9, '未知', 1);
INSERT INTO `userorder` VALUES ('db6aaef932044453a40558b61dffb5e5', '015935324723111', '2', 1, '2020-08-10 22:46:55', '2020-08-10 22:45:40', '2', 'hx_img/2020/8/10/28254974aee448faaabaf531ee2b057e.jpg@', 111, '三室一厅', '武汉', '大黄蜂', '13287654328', '无其他。。。', 100.9, '甲醛', 0);
INSERT INTO `userorder` VALUES ('e1b7bd7b3eca4c12b34950059c899371', '015935324723111', '2', 1, '2020-08-07 21:55:52', '2020-08-07 15:00:00', '1', 'hx_img/2020/8/7/027f37fb5937416f95652eda7b4a0cae.jpg@', 132, '两室一厅', '台湾', '周杰伦', '13215487542', '其他说明', 100.9, '甲醛', 1);
INSERT INTO `userorder` VALUES ('e58ebc0583e843548c5b54bb5e3acaf8', '015935324723271', '2', 1, '2020-07-31 22:35:39', '2020-07-31 22:34:54', '2', 'hx_img/2020/7/31/7322ecd1c4c94c008323d84576a13309.jpg@', 120, '两室一厅', '武汉理工大学', '小明', '18322229999', '', 100.9, 'PM10', 1);
INSERT INTO `userorder` VALUES ('e666421f2f5640b0975b5962d98c8d88', '015971553021121', '2', 1, '2020-08-11 22:15:26', '2020-08-11 22:15:18', '2', 'hx_img_other_users/2020/8/11/fc23093646a04e648736a7545369123a.png@', 100, '三室一厅', '湖北武汉', '张三', '15927048974', '', 1000, '甲醛', 1);

SET FOREIGN_KEY_CHECKS = 1;
