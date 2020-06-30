/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : bbs_sql

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2020-06-02 11:29:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `adminUsername` varchar(255) NOT NULL COMMENT '管理员名',
  `adminPassword` varchar(255) NOT NULL COMMENT '管理员密码',
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admininfo
-- ----------------------------
INSERT INTO `admininfo` VALUES ('1', 'admin', '123456');
INSERT INTO `admininfo` VALUES ('2', 'xiaohua', '111111');
INSERT INTO `admininfo` VALUES ('3', 'hanghang', '156444');

-- ----------------------------
-- Table structure for commentinfo
-- ----------------------------
DROP TABLE IF EXISTS `commentinfo`;
CREATE TABLE `commentinfo` (
  `commentID` int(4) NOT NULL AUTO_INCREMENT COMMENT '留言模块编号',
  `title` varchar(100) DEFAULT NULL COMMENT '发表留言主题',
  `content` mediumtext COMMENT '发表留言内容',
  `time` datetime DEFAULT NULL COMMENT '发表留言时间',
  `postName` varchar(50) DEFAULT NULL COMMENT '发表人',
  `image` varchar(255) DEFAULT NULL COMMENT '发表图片',
  PRIMARY KEY (`commentID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commentinfo
-- ----------------------------
INSERT INTO `commentinfo` VALUES ('8', '中国版的马尔代夫', '美济岛位于中国南海的南沙群岛中东部海域，是一个椭圆形的珊瑚环礁上面填海造出的人工岛，顶部全由珊瑚构成，总面积约5.66平方公里，为南沙罕见的大型的天然避风良港，战略价值高。更是被称作中国的“海洋之心.', '2017-07-01 12:12:19', '旅行人小燕子', '1.jpg');
INSERT INTO `commentinfo` VALUES ('10', '旗迹山河，点赞中国', '#旗迹山河 点赞中国#一汽红旗HS5上市周年庆活动正式开启。山河无恙，感恩有你，携手红旗HS5车主，从祖国各地五线齐发，以车轮为笔，大地为纸，铺陈壮美画卷，点赞中华风骨。', '2017-07-01 17:08:38', '一汽红旗', '3.jpg');
INSERT INTO `commentinfo` VALUES ('11', '大连梦幻荧光海', '#大连# 海域出现荧光海 梦幻景致宛若蓝色星河】#大连荧光海# 5月24日夜至5月25日凌晨，瓦房店市驼山乡排石村海域出现了荧光海。梦幻景致宛若蓝色星河，各地摄影爱好者闻讯后赶来拍摄#大连梦幻荧光海# 。图片在网络传开后，大连美景再次吸引了全国网友的目光。（图片：于永乐）', '2017-07-01 09:24:27', '半岛晨报', '2.jpg');
INSERT INTO `commentinfo` VALUES ('12', '东北菜到底有多好吃', '我真的好爱东北菜！份量大又实惠！锅包肉、小鸡炖蘑菇、地三鲜、猪肉炖粉条、大拉皮、排骨炖豆角… 你们最爱吃的东北菜是什么呀', '2017-07-01 09:27:40', '吃饱了记得夸我', '4.jpg');
INSERT INTO `commentinfo` VALUES ('14', '全国人大常委会', '全国人大常委会都在做些啥？快戳下方链接进入《全国人民代表大会常务委员会工作报告》官方融媒版，为这份全国人大常委会交出的给力答卷点赞！', '2017-07-01 09:33:39', '新华网', '5.jpg');
INSERT INTO `commentinfo` VALUES ('15', '你好', '你好', '2020-03-18 18:01:30', '你好', '5.jpg');
INSERT INTO `commentinfo` VALUES ('16', 'bibi', 'bibi', '2020-05-20 18:01:56', 'bibi', '5.jpg');

-- ----------------------------
-- Table structure for messinfo
-- ----------------------------
DROP TABLE IF EXISTS `messinfo`;
CREATE TABLE `messinfo` (
  `messID` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `userID` int(11) NOT NULL COMMENT '用户编号',
  `commentID` int(11) NOT NULL COMMENT '留言模块编号',
  `mess_text` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `mess_time` datetime NOT NULL COMMENT '评论时间',
  PRIMARY KEY (`messID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messinfo
-- ----------------------------
INSERT INTO `messinfo` VALUES ('14', '29', '10', '非常可以，', '2020-05-29 19:03:43');
INSERT INTO `messinfo` VALUES ('15', '29', '11', '喜欢的不得了', '2020-05-29 19:04:02');
INSERT INTO `messinfo` VALUES ('18', '29', '14', '非常可以', '2020-05-29 20:41:11');
INSERT INTO `messinfo` VALUES ('20', '0', '8', '你好', '2020-05-29 20:48:30');
INSERT INTO `messinfo` VALUES ('21', '26', '8', '非常喜欢', '2020-06-02 10:13:31');
INSERT INTO `messinfo` VALUES ('22', '26', '10', '哈哈哈哈  ', '2020-06-02 10:13:47');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userID` int(3) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `userName` char(20) NOT NULL COMMENT '用户名',
  `password` char(20) NOT NULL COMMENT '用户密码',
  `sex` int(10) NOT NULL COMMENT '用户性别',
  `email` varchar(50) NOT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`userID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('3', '祖国de', '123', '0', '1564464275@qq.com');
INSERT INTO `userinfo` VALUES ('25', 'adminxiao凯', '123456', '0', '1564464285@qq.com');
INSERT INTO `userinfo` VALUES ('26', 'admin', '123456789', '0', '1564464275@qq.com');
INSERT INTO `userinfo` VALUES ('27', 'xiaotiantian', '123456', '0', '1564464285@qq.com');
