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

 Date: 30/06/2020 23:35:44
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
INSERT INTO `admin` VALUES ('1234', 'user', '12345678911', '12345678911', 1);

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
INSERT INTO `detectiondata` VALUES ('113cea15d1ca4eeb8cd9cde1612589c4', '2020-06-30 18:45:35', 'bab7fce965614992a05d7d6bcd8c543b', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `detectiondata` VALUES ('13b3f06e165a44ef9af65c0473e1caa3', '2020-06-30 17:45:19', '3ce17bc4af9341309099bcf42c1d5156', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('3388ceeb022346cd921ab5b3a57f15ec', '2020-06-30 21:44:00', '3ce17bc4af9341309099bcf42c1d5156', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('4c89ce36188b4dcebad2271373e17fe2', '2020-06-30 18:20:58', '3ce17bc4af9341309099bcf42c1d5156', 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);
INSERT INTO `detectiondata` VALUES ('4d56cba841874b73b03201afbdaacdd1', '2020-06-30 21:59:28', 'f9720c8087554bbf898a841aab89e65b', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('4fe4b23e3b3947829d7b677b9f84b58b', '2020-06-30 18:45:15', 'bab7fce965614992a05d7d6bcd8c543b', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `detectiondata` VALUES ('69c1570c32674c77ab22671220b1714f', '2020-06-30 21:32:40', '3ce17bc4af9341309099bcf42c1d5156', 12, 12, 11, 111, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11);
INSERT INTO `detectiondata` VALUES ('7e79793570d14540a0647b4a00cc2c00', '2020-06-30 21:50:26', 'bab7fce965614992a05d7d6bcd8c543b', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('8ebf3ecb30734dd0a14a2cd942e891fe', '2020-06-30 22:06:06', 'c2e9365ec85c4195896abcf66ee669a6', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('a8e5f658c5ee4e309f74e2c21e8c535d', '2020-06-30 18:45:43', 'bab7fce965614992a05d7d6bcd8c543b', 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
INSERT INTO `detectiondata` VALUES ('b164f1d5ae7449ecb4a014d599c759f0', '2020-06-30 21:37:42', '3ce17bc4af9341309099bcf42c1d5156', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('b69bfccba0084554abc0280780bcfc9c', '2020-06-30 21:49:49', 'bab7fce965614992a05d7d6bcd8c543b', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('bb8f1a74a5e847d2a2c5f8a56ff7b32c', '2020-06-30 22:00:01', 'f9720c8087554bbf898a841aab89e65b', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('c12e46afd0304f40bb58e59dfbb07ab5', '2020-06-30 17:51:24', '3ce17bc4af9341309099bcf42c1d5156', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('c6639ed63aef418eb3ed092a6a84c6f2', '2020-06-30 22:04:37', '3ce17bc4af9341309099bcf42c1d5156', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('d987ceb2ea0d41fda6a9129e56619e7e', '2020-06-30 17:40:47', '123124124', 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21);
INSERT INTO `detectiondata` VALUES ('e3d74091454f4dd99500ce2eddf7595a', '2020-06-30 21:46:05', 'bab7fce965614992a05d7d6bcd8c543b', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO `detectiondata` VALUES ('e5a509dcc4d446c995ccdff9df846694', '2020-06-30 17:59:49', '3ce17bc4af9341309099bcf42c1d5156', 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 31, 13, 13);
INSERT INTO `detectiondata` VALUES ('f4ddc5d60f524458a924e4ca6c15ec86', '2020-06-30 18:15:16', '3ce17bc4af9341309099bcf42c1d5156', 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11);
INSERT INTO `detectiondata` VALUES ('fce346077f8c4260a7c04f2ebe6fe443', '2020-06-30 21:50:52', 'f9720c8087554bbf898a841aab89e65b', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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
INSERT INTO `equipment` VALUES ('1', '小米充电宝1', '充电宝', 99, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('10', '热水壶1', '热水壶', 98, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('11', '热水壶2', '热水壶', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('12', '热水壶3', '热水壶', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('13', '防护套装1', '防护套装', 98, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('14', '防护套装2', '防护套装', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('15', '防护套装3', '防护套装', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '手套 防护服 防毒面具');
INSERT INTO `equipment` VALUES ('2', '小米充电宝2', '充电宝', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('3', '小米充电宝3', '充电宝', 100, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('4', '反应桶1', '反应桶', 198, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('5', '反应桶2', '反应桶', 200, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('6', '反应桶3', '反应桶', 200, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
INSERT INTO `equipment` VALUES ('7', '反应器1', '反应器', 298, '2020-06-05 10:13:54', '2020-06-05 10:14:02', 0, '描述');
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
INSERT INTO `material` VALUES ('101', '除醛A', 9998, NULL);
INSERT INTO `material` VALUES ('201', '除醛B', 9993, NULL);
INSERT INTO `material` VALUES ('301', '消毒A', 9992, NULL);
INSERT INTO `material` VALUES ('401', '消毒B', 9995, NULL);
INSERT INTO `material` VALUES ('501', '汽车治理包', 9994, NULL);

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
INSERT INTO `process` VALUES ('3ce17bc4af9341309099bcf42c1d5156', '015895279629461', '45afa032660b46539c5e1f1639d0c762', NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-30 21:38:02', 1, NULL, NULL, 'c6639ed63aef418eb3ed092a6a84c6f2', '157423611', '顺丰快递', 10800);
INSERT INTO `process` VALUES ('bab7fce965614992a05d7d6bcd8c543b', '015893358205961', '5a5be5c1d0df4960b07327cbb114157f', NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-30 21:46:16', 1, NULL, NULL, '7e79793570d14540a0647b4a00cc2c00', '12356', '顺丰快递', 7200);
INSERT INTO `process` VALUES ('c2e9365ec85c4195896abcf66ee669a6', '015893358205961', '1509a3a1d11344fc85eac0c37f959908', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '8ebf3ecb30734dd0a14a2cd942e891fe', NULL, NULL, 0);
INSERT INTO `process` VALUES ('f9720c8087554bbf898a841aab89e65b', '015893358205961', '8a947089a884420eb75bc474c81bd6aa', NULL, NULL, NULL, NULL, NULL, NULL, '2020-06-30 21:59:52', 1, NULL, NULL, 'bb8f1a74a5e847d2a2c5f8a56ff7b32c', NULL, NULL, 7200);

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
INSERT INTO `user` VALUES ('015891924989071', 'ac59075b964b0715', '17786028888', '张三', 1, '213124124');
INSERT INTO `user` VALUES ('015893358205961', 'e6dd63397f1d335c', '13211111112', '李四', 1, '31235123141242');
INSERT INTO `user` VALUES ('015895279629461', '0822da7ea481a653', '13911112222', '王五', 1, 'op_Qp49dqJRed4Qlb5dRW7Qs_wMU');
INSERT INTO `user` VALUES ('015935267540471', '4ad2f3f983039797', '13211111112', '', 1, 'op_Qp4zaFfjAfCZQbeODTk6fqEUc');

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
INSERT INTO `userorder` VALUES ('1509a3a1d11344fc85eac0c37f959908', '015893358205961', '2', 1, '2020-05-13 12:38:33', '2020-05-13 12:38:07', '2', '/Users/pengyuquan/Desktop/1589344713621wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.MnGUnONhECM17a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg', 111, '家居装修', '武汉市', '徐俊伟', '13211111111', '其它111', 100.9, '甲醛', NULL);
INSERT INTO `userorder` VALUES ('45afa032660b46539c5e1f1639d0c762', '015895279629461', '2', 1, '2020-05-15 15:33:52', '2020-05-15 15:32:56', '2', '/Users/pengyuquan/Desktop/1589528032066wx0656326b8fdbe56f.o6zAJs5QFg7Go9_V9BOU0yT_sVOA.JITjaJKjiHfhba470c02f02389f67babdfabd606d248.jpg', 120, '三室二厅', '安徽省安庆市', '笑话', '13911112222', '', 100.9, '甲醛', NULL);
INSERT INTO `userorder` VALUES ('5a5be5c1d0df4960b07327cbb114157f', '015893358205961', '2', 1, '2020-05-14 15:01:28', '2020-05-14 15:00:05', '2', '/Users/pengyuquan/Desktop/1589439688302wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.G9MLxs6bSDc47a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg', 112, '家居装修', '北京市海淀区', '小明啊', '13211111111', '无其它说明', 100.9, '甲醛1', NULL);
INSERT INTO `userorder` VALUES ('6ef5c5ae8c694975bd1fb9037a400138', '015935267540471', '1', 0, '2020-06-30 23:21:50', '2020-06-30 23:21:07', '2', 'C:/Users/mhh/Desktop/1593530510228wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.neQa8Ovgkv7D7a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg', 121, '三室', '武汉市洪山区', '哇哈哈', '13211111112', '测试11', 100.9, '甲醛', NULL);
INSERT INTO `userorder` VALUES ('8a947089a884420eb75bc474c81bd6aa', '015893358205961', '2', 1, '2020-05-13 12:43:25', '2020-05-13 12:42:49', '2', '/Users/pengyuquan/Desktop/1589345005694wx0656326b8fdbe56f.o6zAJs13QSgvIn8ZUcmQh1b2sk1Y.7i6bwJXOFhXg7a3424fbf2e39aa6b7bbd22d5d2a15d9.jpg', 112, '家居装修', '武汉市洪山区', '徐俊伟12', '13211111111', '其它123', 100.9, '甲醛', NULL);

SET FOREIGN_KEY_CHECKS = 1;
