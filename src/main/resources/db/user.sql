/*
Navicat MySQL Data Transfer

Source Server         : local-root
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : springsecurity

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-01-29 15:43:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `roles` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ouyang', 'bbd126f4856c57f68d4e30264da6a4e6', 'ROLE_ADMIN,ROLE_USER');
INSERT INTO `user` VALUES ('2', 'admin', 'bbd126f4856c57f68d4e30264da6a4e6', 'ROLE_ADMIN');
INSERT INTO `user` VALUES ('3', 'user', 'bbd126f4856c57f68d4e30264da6a4e6', 'ROLE_USER');
