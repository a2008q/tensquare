/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : tensquare_gathering

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 08/09/2021 14:32:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_gathering
-- ----------------------------
DROP TABLE IF EXISTS `tb_gathering`;
CREATE TABLE `tb_gathering`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动名称',
  `summary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '大会简介',
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详细说明',
  `sponsor` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主办方',
  `image` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动图片',
  `starttime` datetime NULL DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime NULL DEFAULT NULL COMMENT '截止时间',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '举办地点',
  `enrolltime` datetime NULL DEFAULT NULL COMMENT '报名截止',
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否可见',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_usergath
-- ----------------------------
DROP TABLE IF EXISTS `tb_usergath`;
CREATE TABLE `tb_usergath`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `gathid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动ID',
  `exetime` datetime NULL DEFAULT NULL COMMENT '点击时间',
  PRIMARY KEY (`userid`, `gathid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户关注活动' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
