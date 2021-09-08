/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : tensquare_friend

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 08/09/2021 14:32:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_friend
-- ----------------------------
DROP TABLE IF EXISTS `tb_friend`;
CREATE TABLE `tb_friend`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `friendid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '好友ID',
  `islike` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否互相喜欢',
  PRIMARY KEY (`userid`, `friendid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_nofriend
-- ----------------------------
DROP TABLE IF EXISTS `tb_nofriend`;
CREATE TABLE `tb_nofriend`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `friendid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '非好友ID',
  PRIMARY KEY (`userid`, `friendid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
