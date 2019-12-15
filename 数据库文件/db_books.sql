/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : db_books

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2018-12-21 12:55:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_books
-- ----------------------------
DROP TABLE IF EXISTS `tb_books`;
CREATE TABLE `tb_books` (
  `ID` int(255) unsigned NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `book_price` decimal(10,2) DEFAULT NULL,
  `book_author` varchar(255) DEFAULT NULL,
  `published_house` varchar(255) DEFAULT NULL,
  `book_category` varchar(255) DEFAULT NULL,
  `borrower_name` varchar(255) DEFAULT NULL,
  `borrower_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_books
-- ----------------------------
INSERT INTO `tb_books` VALUES ('1', '978-7-100-10618-4', '《如何阅读一本书》', '56.00', '(美) 莫提默·J. 艾德勒, 查尔斯·范多伦', '商务印书馆', 'G792', '陈彦志', '13503383632');
INSERT INTO `tb_books` VALUES ('2', '978-7-111-29544-0', '《设计模式之禅》', '69.00', '秦小波', '机械工业出版社', 'TP312', '陈彦志', '13503383632');
INSERT INTO `tb_books` VALUES ('3', '978-7-115-21687-8', '《代码整洁之道》', '59.00', '(美)Robert C. Martin', '人民邮电出版社', 'TP311.5', null, null);
INSERT INTO `tb_books` VALUES ('5', '978-7-300-11134-6', '《金融学》', '59.00', '兹维·博迪', '中国人民大学出版社', 'F830', null, null);
INSERT INTO `tb_books` VALUES ('6', '978-7-302-23755-6', '《Java程序设计实践教程》', '36.00', '颜志军, 栾媛媛', '人民邮电出版社', 'TP312', null, null);
INSERT INTO `tb_books` VALUES ('7', '978-7-302-27544-2', '《C语言程序设计》', '29.00', '李爱玲', '机械工业出版社', 'TP312', null, null);
INSERT INTO `tb_books` VALUES ('8', '978-7-302-29391-0', '《网络安全技术》', '34.50', '曾湘黔', '清华大学出版社', 'TP393.0', '陈彦志', '13503383632');
INSERT INTO `tb_books` VALUES ('9', '978-7-5117-0157-2', '《傲慢与偏见》', '16.00', '(英) 简·奥斯汀', '中央编译出版社', 'I', null, null);
INSERT INTO `tb_books` VALUES ('10', '978-7-5327-5110-5', '《悲惨世界》', '58.00', '(法)雨果', '上海译文出版社', 'I', null, null);
INSERT INTO `tb_books` VALUES ('11', '978-7-5399-3321-4', '《纳兰容若词传》', '28.50', '苏缨, 毛晓雯, 夏如意', '江苏文艺出版社', 'I207.23', null, null);
INSERT INTO `tb_books` VALUES ('23', '978-7-5399-5488-2', '《瓦尔登湖 : 梭罗散文选》', '34.00', '(美) 梭罗', '江苏文艺出版社', 'I', null, null);

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(255) unsigned NOT NULL AUTO_INCREMENT,
  `user` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'root', 'root');
