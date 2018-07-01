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

 Date: 01/07/2018 20:27:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for command
-- ----------------------------
DROP TABLE IF EXISTS `command`;
CREATE TABLE `command` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(16) DEFAULT NULL,
  `DESCRIPTION` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of command
-- ----------------------------
BEGIN;
INSERT INTO `command` VALUES (1, '段子', '精彩段子');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
