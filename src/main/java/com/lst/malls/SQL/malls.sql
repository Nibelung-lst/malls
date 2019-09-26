/*
Navicat MySQL Data Transfer

Source Server         : SearchNibelung
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : malls

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-09-26 10:21:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('3', 'louiss', '777777');
INSERT INTO `t_admin` VALUES ('15', 'lws', 'fpx666666');
INSERT INTO `t_admin` VALUES ('17', 'Nibelung', '159487');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分类名',
  `create_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人名',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  `final_modification_time` date DEFAULT NULL COMMENT '最后修改时间',
  `final_change_man` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '测试分类1', 'Nibelung', '2019-09-11', '2019-09-12', 'Nibelung');
INSERT INTO `t_category` VALUES ('2', '测试分类2', 'Nibelung', '2019-09-11', '2019-09-12', 'Nibelung');
INSERT INTO `t_category` VALUES ('3', '测试分类3', 'Nibelung', '2019-09-11', '2019-09-12', 'Nibelung');
INSERT INTO `t_category` VALUES ('4', '测试分类4', 'Nibelung', '2019-09-11', '2019-09-12', 'Nibelung');
INSERT INTO `t_category` VALUES ('5', '测试分类5', 'Nibelung', '2019-09-11', '2019-09-12', 'Nibelung');
INSERT INTO `t_category` VALUES ('13', '测试分类13', 'Nibelung', '2019-09-11', '2019-09-12', 'Nibelung');
INSERT INTO `t_category` VALUES ('16', '测试分类10', 'Nibelung', '2019-09-12', '2019-09-12', 'Nibelung');
INSERT INTO `t_category` VALUES ('20', '测试分类20', 'Nibelung', '2019-09-12', null, null);

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品图片地址',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '初始价格',
  `real_price` decimal(10,2) DEFAULT NULL COMMENT '原价',
  `represent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名',
  `creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建者',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `final_changer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最后修改人',
  `final_change_time` date DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', '测试商品1', null, '1.00', '2.00', '3', '测试分类1', 'Nibelung', '2019-09-14', null, null);
INSERT INTO `t_goods` VALUES ('2', '测试商品2', null, '1.00', '3.00', '2', '测试分类2', 'Nibelung', '2019-09-14', null, null);
INSERT INTO `t_goods` VALUES ('3', '测试商品3', null, '2.00', '3.00', '4', '测试分类1', 'Nibelung', '2019-09-14', null, null);
INSERT INTO `t_goods` VALUES ('4', '测试商品4', '3bbc69f7-138a-4dba-9dfc-890f682a7b834.jpg', '2.00', '1.00', '6', '测试分类1', 'Nibelung', '2019-09-14', 'Nibelung', '2019-09-16');
INSERT INTO `t_goods` VALUES ('5', '测试商品5', 'f70c5bbf-7fe6-4b85-bf89-a8ad2e6f81b33.jpg', '12.00', '23.00', '32', '测试分类1', 'Nibelung', '2019-09-14', 'Nibelung', '2019-09-16');
INSERT INTO `t_goods` VALUES ('6', '测试商品6', null, '123.00', '122.00', '32', '测试分类2', 'Nibelung', '2019-09-14', null, null);
INSERT INTO `t_goods` VALUES ('7', '测试商品7', null, '1223.00', '323.00', '23', '测试分类1', 'Nibelung', '2019-09-14', null, null);
INSERT INTO `t_goods` VALUES ('9', '测试商品9', '367f9608-0a0c-4fa4-b41a-4508f6c9833c3.jpg', '10.00', '100.00', '无', '测试分类1', 'Nibelung', '2019-09-16', null, null);

-- ----------------------------
-- Table structure for t_imageurl
-- ----------------------------
DROP TABLE IF EXISTS `t_imageurl`;
CREATE TABLE `t_imageurl` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL,
  `imgURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_imageurl
-- ----------------------------
INSERT INTO `t_imageurl` VALUES ('2', '测试商品1', '80cc7111-bbbe-4671-ad1b-578e818065b93.jpg');
INSERT INTO `t_imageurl` VALUES ('3', '测试商品4', '945f894c-0a99-4426-a70a-ad8693e69fe13.jpg');
INSERT INTO `t_imageurl` VALUES ('4', '测试商品4', '890decce-d8c7-4c8b-85f3-30fe10fa9aa93.jpg');
INSERT INTO `t_imageurl` VALUES ('5', '测试商品4', 'df51b464-f3f8-4315-a1de-4dd739bc68c33.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_ID` bigint(255) DEFAULT NULL COMMENT '订单编号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `receiver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '接收人',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `price` decimal(10,2) DEFAULT NULL COMMENT '订单总额',
  `creator_time` date DEFAULT NULL COMMENT '创建时间',
  `finsh_time` date DEFAULT NULL COMMENT '完成时间',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '会员名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '123456789', '厦门', '厂长', '7777', '58.00', '2019-09-16', '2019-09-16', '未签收', '');
INSERT INTO `t_order` VALUES ('2', '1234567890', '广东', '枣子哥', '111', '1.00', '2019-09-16', null, '送货中', null);
INSERT INTO `t_order` VALUES ('3', '201909260905534681', '厦门', '侯国玉', '12345678901', '4.00', '2019-09-26', null, '待付款', 'otto');
INSERT INTO `t_order` VALUES ('4', '201909260927504691', '厦门', '侯国玉', '12345678900', '3.00', '2019-09-26', null, '代发货', 'otto');
INSERT INTO `t_order` VALUES ('5', '201909260929405281', '厦门', '侯国玉', '12312312123231', '92.00', '2019-09-26', null, '代发货', 'otto');

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(255) DEFAULT NULL COMMENT '订单ID',
  `goods_id` int(10) DEFAULT NULL COMMENT '商品ID',
  `number` int(10) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES ('1', '123456789', '4', '12');
INSERT INTO `t_order_detail` VALUES ('2', '123456789', '5', '2');
INSERT INTO `t_order_detail` VALUES ('3', '1234567890', '4', '1');
INSERT INTO `t_order_detail` VALUES ('4', '201909260905534681', '4', '4');
INSERT INTO `t_order_detail` VALUES ('5', '201909260927504691', '4', '3');
INSERT INTO `t_order_detail` VALUES ('6', '201909260929405281', '5', '4');

-- ----------------------------
-- Table structure for t_point
-- ----------------------------
DROP TABLE IF EXISTS `t_point`;
CREATE TABLE `t_point` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '用户ID',
  `point` int(10) DEFAULT NULL COMMENT '积分',
  `total_point` int(10) DEFAULT NULL COMMENT '总积分',
  `order_id` bigint(255) DEFAULT NULL COMMENT '订单ID',
  `create_time` date DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_point
-- ----------------------------
INSERT INTO `t_point` VALUES ('1', '1', null, null, '1', '2019-09-18');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `point` int(10) DEFAULT NULL COMMENT '积分',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'otto', '侯国玉', '123456', '1', '123213213', '吉吉国', '12312', '1989-07-21', '121', '1');
INSERT INTO `t_user` VALUES ('2', 'BZZB', '梁志斌', '123456', '1', '123132133', '日本', '12321', '1984-06-14', '0', '1');
INSERT INTO `t_user` VALUES ('3', 'NMSL', '孙笑川', '123456', '1', '123213213', '日本', '12312', '1980-10-18', '0', '1');
INSERT INTO `t_user` VALUES ('4', 'dragon', '许昊龙', '123456', '1', '123123213', '福州', '12321', '1998-06-10', '0', '1');
INSERT INTO `t_user` VALUES ('5', 'aass3265', null, '123456', '1', '12345678', null, null, null, null, '1');
INSERT INTO `t_user` VALUES ('6', 'as12345', null, '12345678', '1', '12345678', null, null, null, null, '1');
INSERT INTO `t_user` VALUES ('25', 'Nibelung', null, '123456', '1', '1232132', null, null, null, null, '1');
INSERT INTO `t_user` VALUES ('28', 'asdasd', null, '123123', '1', '123213', null, null, null, null, '1');
INSERT INTO `t_user` VALUES ('29', '55open', null, '123456', '1', '43967777', null, null, null, null, '0');
INSERT INTO `t_user` VALUES ('30', 'dogdog', null, '123456', '1', '1233123', null, null, null, null, '1');
INSERT INTO `t_user` VALUES ('31', 'hahaha', null, '123456', '0', '12345', null, null, null, null, '1');
