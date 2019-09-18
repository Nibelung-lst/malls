/*
Navicat MySQL Data Transfer

Source Server         : SearchNibelung
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : malls

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-09-18 15:47:13
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
  `name` varchar(255) DEFAULT NULL,
  `create_name` varchar(255) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `final_modification_time` date DEFAULT NULL,
  `final_change_man` varchar(255) DEFAULT NULL,
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
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `original_price` decimal(10,2) DEFAULT NULL,
  `real_price` decimal(10,2) DEFAULT NULL,
  `represent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `final_changer` varchar(255) DEFAULT NULL,
  `final_change_time` date DEFAULT NULL,
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
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_ID` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `creator_time` date DEFAULT NULL,
  `finsh_time` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', 'b12a277d-030c-4ece-a9c0-ebd5a05faf56', '厦门', '厂长', '7777', '58.00', '2019-09-16', '2019-09-16', '未签收', '');
INSERT INTO `t_order` VALUES ('2', '7937cd21-c3bb-4739-829b-a6eb1ca65349', '广东', '枣子哥', '111', '1.00', '2019-09-16', null, '送货中', null);

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `order_id` int(10) DEFAULT NULL,
  `goods_id` int(10) DEFAULT NULL,
  `number` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES ('1', '1', '4', '12');
INSERT INTO `t_order_detail` VALUES ('2', '1', '5', '2');
INSERT INTO `t_order_detail` VALUES ('3', '2', '4', '1');

-- ----------------------------
-- Table structure for t_point
-- ----------------------------
DROP TABLE IF EXISTS `t_point`;
CREATE TABLE `t_point` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `point` int(10) DEFAULT NULL,
  `total_point` int(10) DEFAULT NULL,
  `order_id` int(10) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
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
  `name` varchar(255) NOT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `point` int(10) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'otto', '侯国玉', '123456', '1', '123213213', '吉吉国', '12312', '1989-07-21', '121', '1');
INSERT INTO `t_user` VALUES ('2', 'BZZB', '梁志斌', '123456', '1', '123132133', '日本', '12321', '1984-06-14', '0', '1');
INSERT INTO `t_user` VALUES ('3', 'NMSL', '孙笑川', '123456', '1', '123213213', '日本', '12312', '1980-10-18', '0', '1');
INSERT INTO `t_user` VALUES ('4', 'dragon', '许昊龙', '123456', '1', '123123213', '福州', '12321', '1998-06-10', '0', '1');
