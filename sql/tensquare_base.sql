/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : localhost:3306
 Source Schema         : tensquare_base

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 08/09/2021 14:32:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_city
-- ----------------------------
DROP TABLE IF EXISTS `tb_city`;
CREATE TABLE `tb_city`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `ishot` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否热门',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '城市' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_label
-- ----------------------------
DROP TABLE IF EXISTS `tb_label`;
CREATE TABLE `tb_label`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签ID',
  `labelname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `count` bigint(20) NULL DEFAULT NULL COMMENT '使用数量',
  `recommend` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否推荐',
  `fans` bigint(20) NULL DEFAULT NULL COMMENT '粉丝数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_ul
-- ----------------------------
DROP TABLE IF EXISTS `tb_ul`;
CREATE TABLE `tb_ul`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `labelid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userid`, `labelid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
