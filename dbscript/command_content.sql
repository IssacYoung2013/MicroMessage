/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 01/07/2018 20:27:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for command_content
-- ----------------------------
DROP TABLE IF EXISTS `command_content`;
CREATE TABLE `command_content` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `COMMAND_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of command_content
-- ----------------------------
BEGIN;
INSERT INTO `command_content` VALUES (1, 'hhhhasdlkjalj ljal啊三等奖两大速度快了； 范老师大家发了；啊了', 1);
INSERT INTO `command_content` VALUES (2, '都说了克己复礼独家发售啦；江东父老说；啊减肥了；爱上了啊', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
