/*
 Navicat Premium Data Transfer

 Source Server         : test
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : db_dorm

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 25/09/2020 17:09:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'cya', '系统管理员', '男', '123553666');

-- ----------------------------
-- Table structure for t_dorm
-- ----------------------------
DROP TABLE IF EXISTS `t_dorm`;
CREATE TABLE `t_dorm`  (
  `dormId` int(11) NOT NULL AUTO_INCREMENT,
  `dormBuildId` int(11) NULL DEFAULT NULL,
  `dormName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormType` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormNumber` int(11) NULL DEFAULT NULL,
  `dormTel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dormId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dorm
-- ----------------------------
INSERT INTO `t_dorm` VALUES (1, 1, '220', '男', 6, '110');

-- ----------------------------
-- Table structure for t_dormbuild
-- ----------------------------
DROP TABLE IF EXISTS `t_dormbuild`;
CREATE TABLE `t_dormbuild`  (
  `dormBuildId` int(11) NOT NULL AUTO_INCREMENT,
  `dormBuildName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormBuildDetail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dormBuildId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dormbuild
-- ----------------------------
INSERT INTO `t_dormbuild` VALUES (4, '2栋', '这是2栋');
INSERT INTO `t_dormbuild` VALUES (5, '3栋', '啥也不想说');
INSERT INTO `t_dormbuild` VALUES (6, '4栋', '这里是第四栋');
INSERT INTO `t_dormbuild` VALUES (7, '5栋', '公众号【C you again】');
INSERT INTO `t_dormbuild` VALUES (8, '6栋', '人生充满了无奈，但是还得咬牙坚持');

-- ----------------------------
-- Table structure for t_dormmanager
-- ----------------------------
DROP TABLE IF EXISTS `t_dormmanager`;
CREATE TABLE `t_dormmanager`  (
  `dormManId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormBuildId` int(11) NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dormManId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 62 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dormmanager
-- ----------------------------
INSERT INTO `t_dormmanager` VALUES (5, 'manager5', 'cya', 4, '小宋5', '男', '1234567');
INSERT INTO `t_dormmanager` VALUES (7, 'manager6', '123', 6, '呵呵 ', '女', '123');
INSERT INTO `t_dormmanager` VALUES (8, 'manager1', '123', 4, '小白', '男', '123');
INSERT INTO `t_dormmanager` VALUES (39, 'Test1', '123', 6, 'C you again 的博客', '男', '4');
INSERT INTO `t_dormmanager` VALUES (40, 'Test2', '123', 0, '普通用户dd', '男', '123');
INSERT INTO `t_dormmanager` VALUES (41, 'sdfssdf', '123', 6, '普通用户', '男', '123');
INSERT INTO `t_dormmanager` VALUES (42, 'manager2', '123', 4, '小张', '男', '1');
INSERT INTO `t_dormmanager` VALUES (43, '002', '1', 4, '1', '男', '1');
INSERT INTO `t_dormmanager` VALUES (44, 'sf', '3', 4, '666', '女', 'saf');
INSERT INTO `t_dormmanager` VALUES (45, 'sdfssdf', '34', 6, '小张', '女', 'saf');
INSERT INTO `t_dormmanager` VALUES (46, 'gfdsfsdfd', '45', 4, '普通用户', '男', 'sdfsf');
INSERT INTO `t_dormmanager` VALUES (47, 'dsf', '333', 0, '44', '男', '123');
INSERT INTO `t_dormmanager` VALUES (48, 'safsf', '44', NULL, 'dgdfd', '女', 'safsdf');
INSERT INTO `t_dormmanager` VALUES (49, 'sfsaf', 'ff', 0, 'dgdfdsf', '女', 'sdfs');
INSERT INTO `t_dormmanager` VALUES (56, 'wer', '3', NULL, 'asdf', '男', '324');
INSERT INTO `t_dormmanager` VALUES (60, 'dorm', 'cya', 4, 's', '女', 'd');
INSERT INTO `t_dormmanager` VALUES (61, 'sdfssdf', '4', NULL, '4', '女', '444');

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `noticeId` int(11) NOT NULL AUTO_INCREMENT,
  `noticePerson` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`noticeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, '公众号【C you again】', '2020-09-23', '欢迎你访问，祝你学习愉快。');
INSERT INTO `t_notice` VALUES (2, '公众号【C you again】', '2020-09-23', '使用前请注明来源，勿侵权');
INSERT INTO `t_notice` VALUES (4, '公众号【C you again】', '2020-09-24', '获得更多系统源码请查看公众号【C you again】');
INSERT INTO `t_notice` VALUES (5, 'admin', '2020-09-24', '2020.9.25将对学校各宿舍进行卫生大检查，宿舍管理员做好相关工作');
INSERT INTO `t_notice` VALUES (6, 'admin', '2020-09-24', 'xxx同学2020.9.28晚在寝室抽烟，通报评批');
INSERT INTO `t_notice` VALUES (9, '公众号【C you again】', '2020-09-25', '测试公告功能');

-- ----------------------------
-- Table structure for t_punchclock
-- ----------------------------
DROP TABLE IF EXISTS `t_punchclock`;
CREATE TABLE `t_punchclock`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `theme` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_punchclock
-- ----------------------------
INSERT INTO `t_punchclock` VALUES ('pcId1601007599477', '测试打卡', '测试打卡功能555', '2020-09-25', 'admin');
INSERT INTO `t_punchclock` VALUES ('pcId1601008207725', 'ddd', 'dddd', '2020-09-25', 'admin');

-- ----------------------------
-- Table structure for t_punchclockrecord
-- ----------------------------
DROP TABLE IF EXISTS `t_punchclockrecord`;
CREATE TABLE `t_punchclockrecord`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `punchClock_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `punchClock_date` date NULL DEFAULT NULL,
  `punchClock_theme` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `punchClock_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `punchClock_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stuNum` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormBuildId` int(11) NULL DEFAULT NULL,
  `isRecord` tinyint(255) NULL DEFAULT NULL,
  `punckClock_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_punchclockrecord
-- ----------------------------
INSERT INTO `t_punchclockrecord` VALUES (46, 'pcId1601007599477', '2020-09-25', '测试打卡', '测试打卡功能555', 'admin', '李xiaosi', '120', '323456', '002', 4, 1, '带上er');
INSERT INTO `t_punchclockrecord` VALUES (47, 'pcId1601007599477', '2020-09-25', '测试打卡', '测试打卡功能555', 'admin', '李四2', '120', '32', '0023', 4, 0, NULL);
INSERT INTO `t_punchclockrecord` VALUES (48, 'pcId1601007599477', '2020-09-25', '测试打卡', '测试打卡功能555', 'admin', '李四5', '120', '32', '0023999', 3, 0, NULL);
INSERT INTO `t_punchclockrecord` VALUES (49, 'pcId1601007599477', '2020-09-25', '测试打卡', '测试打卡功能555', 'admin', '普通用户', '234234', '324', '23423', 324, 0, NULL);
INSERT INTO `t_punchclockrecord` VALUES (50, 'pcId1601007599477', '2020-09-25', '测试打卡', '测试打卡功能555', 'admin', '西郊小', '789', '897', '444', 567, 0, NULL);
INSERT INTO `t_punchclockrecord` VALUES (51, 'pcId1601008207725', '2020-09-25', 'ddd', 'dddd', 'admin', '李xiaosi', '120', '323456', '002', 4, 1, 'sdfdds');
INSERT INTO `t_punchclockrecord` VALUES (52, 'pcId1601008207725', '2020-09-25', 'ddd', 'dddd', 'admin', '李四2', '120', '32', '0023', 4, 0, '');
INSERT INTO `t_punchclockrecord` VALUES (53, 'pcId1601008207725', '2020-09-25', 'ddd', 'dddd', 'admin', '李四5', '120', '32', '0023999', 3, 0, '');
INSERT INTO `t_punchclockrecord` VALUES (54, 'pcId1601008207725', '2020-09-25', 'ddd', 'dddd', 'admin', '普通用户', '234234', '324', '23423', 324, 0, '');
INSERT INTO `t_punchclockrecord` VALUES (55, 'pcId1601008207725', '2020-09-25', 'ddd', 'dddd', 'admin', '西郊小', '789', '897', '444', 567, 0, '');

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record`  (
  `recordId` int(11) NOT NULL AUTO_INCREMENT,
  `studentNumber` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `studentName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormBuildId` int(11) NULL DEFAULT NULL,
  `dormName` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `detail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`recordId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES (1, '002', '李四', 4, '120', '2014-01-01', '欢迎关注公众号【C you again】');
INSERT INTO `t_record` VALUES (3, '007', '测试1', 1, '221', '2014-08-11', '123');
INSERT INTO `t_record` VALUES (5, '006', '王珂珂', 4, '111', '2014-08-12', '00发的规划');
INSERT INTO `t_record` VALUES (7, '004', '李进', 6, '220', '2014-08-12', '22');
INSERT INTO `t_record` VALUES (12, '0023', '李四', 4, '120', '2020-09-23', '说的方法');
INSERT INTO `t_record` VALUES (14, '0023', '李四', 4, '120', '2020-09-23', '普通用户');
INSERT INTO `t_record` VALUES (15, '0023', '李四', 4, '120', '2020-09-23', '普通用户1');
INSERT INTO `t_record` VALUES (16, '0023', '李四', 4, '120', '2020-09-23', '普通用户');
INSERT INTO `t_record` VALUES (17, '0023', '李四', 4, '120', '2020-09-23', '5');
INSERT INTO `t_record` VALUES (18, '002', '李四', 4, '120', '2020-09-23', '小张');
INSERT INTO `t_record` VALUES (20, '002', '李四', 2, '120', '2020-09-24', '迟到');
INSERT INTO `t_record` VALUES (21, '002', '李四', 2, '120', '2020-09-24', '又迟到');
INSERT INTO `t_record` VALUES (22, '0023', '李四', 2, '120', '2020-09-24', '还迟到');
INSERT INTO `t_record` VALUES (23, '0023', '李四', 2, '120', '2020-09-24', '一直迟到');
INSERT INTO `t_record` VALUES (24, '0023', '李四56', 2, '120', '2020-09-24', '玩手机');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `studentId` int(11) NOT NULL AUTO_INCREMENT,
  `stuNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dormBuildId` int(11) NULL DEFAULT NULL,
  `dormName` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (2, '002', 'cya', '李xiaosi', 4, '120', '男', '323456');
INSERT INTO `t_student` VALUES (3, '0023', '123', '李四2', 4, '120', '男', '32');
INSERT INTO `t_student` VALUES (4, '0023', '123', '李四3', 4, '120', '男', '32');
INSERT INTO `t_student` VALUES (5, '0023', '123', '李四45', 2, '120', '男', '32');
INSERT INTO `t_student` VALUES (6, '0023999', '123', '李四5', 3, '120', '男', '32');
INSERT INTO `t_student` VALUES (9, '0023', '123', '李四7', 5, '120', '男', '32');
INSERT INTO `t_student` VALUES (28, '0023', '123', '李四8', 5, '120', '男', '32');
INSERT INTO `t_student` VALUES (29, '0023', '123', '李四56', 2, '120', '男', '32');
INSERT INTO `t_student` VALUES (30, '0023', '123', '李四35', 4, '120', '男', '32');
INSERT INTO `t_student` VALUES (31, '0023', '123', '李四67', 6, '120', '男', '32');
INSERT INTO `t_student` VALUES (32, '0023', '123', '李四56', 2, '120', '男', '32');
INSERT INTO `t_student` VALUES (33, '0023', '123', '李四34', 6, '120', '男', '32');
INSERT INTO `t_student` VALUES (34, '0023', '123', '李四78', 6, '120', '男', '32');
INSERT INTO `t_student` VALUES (36, '0023', '123', '李四34', 4, '120', '男', '32');
INSERT INTO `t_student` VALUES (38, '23423', '3', '普通用户', 324, '234234', '男', '324');
INSERT INTO `t_student` VALUES (39, '444', '444', '西郊小', 567, '789', '女', '897');

SET FOREIGN_KEY_CHECKS = 1;
