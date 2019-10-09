/*
Navicat MySQL Data Transfer

Source Server         : SearchNibelung
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : malls

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2019-10-09 17:03:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理员密码',
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('2', '科幻', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_category` VALUES ('3', '网络小说', 'Nibelung', '2019-10-09', '2019-10-09', 'Nibelung');
INSERT INTO `t_category` VALUES ('4', '文学', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_category` VALUES ('5', '经济', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_category` VALUES ('6', '互联网技术', 'Nibelung', '2019-10-09', '2019-10-09', 'Nibelung');

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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', '一九八四乔治奥威尔1984国文学小说D', 'e5b81eb6-a63e-4905-b9a8-bebfbdf9268e1984.jpg', '36.00', '13.80', '无删节全译本', '科幻', 'Nibelung', '2019-10-09', 'Nibelung', '2019-10-09');
INSERT INTO `t_goods` VALUES ('2', '阿努比斯之门提姆·鲍尔斯著', '6058a59b-321b-4a21-a9fd-9d815f8b5a57阿努比斯之门.jpg', '49.00', '32.80', '新华书店正版 外国科幻,侦探小说 文轩网', '科幻', 'Nibelung', '2019-10-09', 'Nibelung', '2019-10-09');
INSERT INTO `t_goods` VALUES ('3', '仿生人会梦见电子羊吗迪克菲利普迪克', 'a778712e-4c28-415f-852f-3c0548ebf70c仿生人会梦见电子羊吗.jpg', '39.80', '26.00', '26省包邮,银翼杀手原著小说', '科幻', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('4', '银河帝国1基地阿西莫夫基地银河帝国系列', 'fd58b629-8a70-411a-bad0-0da5c893fbc0基地.jpg', '35.00', '19.80', '正版现货', '科幻', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('5', '三体全集共3册刘慈欣科幻小说', '99fc5616-af30-4293-9bbd-e9f3e419dc34三体全集.jpg', '93.00', '46.00', '中国科幻小说雨果奖获奖作品刘慈欣科幻小说', '科幻', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('6', '斗罗大陆精装典藏版全套1-14册', '82c9956d-4590-46bb-8940-9873317f26b5斗罗大陆全集.jpg', '487.20', '316.00', '第一部完结文字小说版,唐家三少编著', '网络小说', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('7', '斗破苍穹小说全集套40册', 'abbdce0a-6c42-46af-b32d-7aeca524a243斗破苍穹全集.jpg', '910.00', '488.00', '正版现货', '网络小说', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('8', '龙族系列共4册', 'cadc9dde-ba3e-4450-b9ea-6a0217c266b3龙族系列共4册.jpg', '128.40', '75.00', '正版现货', '网络小说', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('9', '神墓全集1-14大结局', '2a777c0d-0890-40fb-9bbd-56c46a07d860神墓全集.jpg', '234.00', '125.00', '神墓全集', '网络小说', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('10', '完美世界小说1-10辰东著', 'fc1e7bf4-daf9-46bf-b60a-1290d4cf78cb完美世界全集.jpg', '260.00', '159.00', '正版现货', '网络小说', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('11', '活着余华作品正版包邮', '565fd1fd-ea3d-4af1-9c10-8723f6f96b87活着.jpg', '14.01', '14.00', '新华书店正版', '文学', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('12', '人间失格太宰治正版日文原版翻译著作', 'ef38adb5-4706-42fc-9e50-a162274619ec人间失格.jpg', '25.00', '9.90', '新华书店正版', '文学', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('13', '围城钱钟书代表作品', 'e389c10e-3a40-4e22-8d4b-4b1fd7c497b0围城.jpg', '39.00', '27.30', '正版现货', '文学', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('14', ' 我是猫正版书夏目漱石著', '20fea0a0-461e-4fe8-9213-98a6c464a640我是猫.jpg', '26.00', '15.60', '长篇文学小说外国文学名著', '文学', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('15', '细雪日本唯美派恶魔主义代表谷崎润一郎竺家荣', 'e126b93b-c0d1-446e-b00d-8cb0e3a9361f细雪.jpg', '45.00', '25.00', '全新精译唯美小说', '文学', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('16', '艾略特波动原理三十讲', '372d683a-be16-4608-ae96-c06e7afef9ff艾略特波动原理三十讲.jpg', '32.00', '22.00', '国内解读艾略特波浪理论三十讲股票书', '经济', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('17', '国富论精装书亚当斯密', '6c835eeb-0b3f-4a4e-985b-52487e57cb0c国富论.jpg', '35.00', '23.80', '现代政治经济学研究起点', '经济', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('18', '金融经济学原理第2版', '93a5c862-c43f-4a7f-98f5-c14378288c45金融经济学原理.jpg', '69.00', '47.40', '高级金融学译丛', '经济', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('19', '马云:未来已来阿里巴巴集团', '3c6bb6c3-7100-4843-9a6e-7b9f26784a66马云未来已来.jpg', '48.00', '30.00', '全面展现阿里巴巴的商业逻辑和纵深布局', '经济', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('20', '周期霍华德马克斯', 'ca7fa984-ac47-46e7-ad82-fd17ec32979e周期.jpg', '88.00', '48.00', '中信出版社经济管理书籍', '经济', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('21', 'C语言从入门到精通', '3a44e5d6-af39-4a14-ac47-543c88429fbeC语言从入门到精通.jpg', '69.80', '38.90', '正版现货', '互联网技术', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('22', 'JavaEE互联网轻量级框架整合开发SSM框架', 'ba9a7e99-0003-4afb-8c5d-4c156580a94cJavaEE.jpg', '119.00', '69.80', 'SpringMVC+Spring+MyBatis', '互联网技术', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('23', 'Java从入门到精通', 'e175353f-0a68-49b2-adbb-4a94b250fd44Java从入门到精通.jpg', '69.80', '34.90', '入门到入土', '互联网技术', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('24', 'Python从入门到精通', 'abc34363-e074-4070-8836-a1ebfa8137e7Python从入门到精通.jpg', '69.77', '48.00', '入门到入土', '互联网技术', 'Nibelung', '2019-10-09', null, null);
INSERT INTO `t_goods` VALUES ('25', 'TCPIP详解', '9d36c051-bd6d-4d65-b928-95120f5d620eTCPIP详解.jpg', '388.00', '233.00', '你看不懂的东西', '互联网技术', 'Nibelung', '2019-10-09', null, null);

-- ----------------------------
-- Table structure for t_imageurl
-- ----------------------------
DROP TABLE IF EXISTS `t_imageurl`;
CREATE TABLE `t_imageurl` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `imgURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '附图地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_imageurl
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '201910091658451951', '吉吉国', '侯国玉', '15396642212', '245.40', '2019-10-09', null, '待收货', 'otto');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
INSERT INTO `t_order_detail` VALUES ('1', '201910091658451951', '11', '2');
INSERT INTO `t_order_detail` VALUES ('2', '201910091658451951', '21', '2');
INSERT INTO `t_order_detail` VALUES ('3', '201910091658451951', '22', '2');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_point
-- ----------------------------

-- ----------------------------
-- Table structure for t_shopping_car
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping_car`;
CREATE TABLE `t_shopping_car` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(10) DEFAULT NULL COMMENT '用户ID',
  `goods_id` int(10) DEFAULT NULL COMMENT '商品ID',
  `numbers` int(10) DEFAULT NULL COMMENT '对应的商品数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shopping_car
-- ----------------------------

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
INSERT INTO `t_user` VALUES ('1', 'otto', '侯国玉', '123456', '1', '15396642212', '吉吉国', '511301802@qq.com', '2019-03-07', '0', '1');
INSERT INTO `t_user` VALUES ('2', 'BZZB', '梁志斌', '123456', '1', '12313213312', '日本', '18059898630@qq.com', '1984-06-14', '0', '1');
INSERT INTO `t_user` VALUES ('3', 'NMSL', '孙笑川', '123456', '1', '12321321312', '日本', '123456678@qq.com', '1980-10-18', '0', '1');
INSERT INTO `t_user` VALUES ('4', 'dragon', '许昊龙', '123456', '1', '12312321312', '福州', '10000@qq.com', '1998-06-10', '0', '1');
