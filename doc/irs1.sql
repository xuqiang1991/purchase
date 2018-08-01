/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : irs1

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-05-20 22:14:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `salt` varchar(5) DEFAULT '',
  `fullname` varchar(50) NOT NULL COMMENT '全名',
  `e_mail` varchar(100) DEFAULT NULL,
  `sex` varchar(1) NOT NULL COMMENT '性别：0女，1男,2保密',
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL COMMENT '地址',
  `phone` varchar(20) NOT NULL COMMENT '手机号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_admin_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', null, 'arthur', 'isduxd@163.com', '1', '1994-11-08', '北京市通州区科创十四街', '17693109997', '1');
INSERT INTO `tb_admin` VALUES ('18', 'test', 'e10adc3949ba59abbe56e057f20f883e', null, 'test', 'test@test.com', '1', '2018-02-25', '甘肃省兰州市榆中县和平镇', '17601038192', null);

-- ----------------------------
-- Table structure for tb_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `operation` varchar(50) NOT NULL COMMENT '操作',
  `method` varchar(100) NOT NULL COMMENT '执行方法',
  `params` varchar(500) NOT NULL COMMENT '请求参数',
  `ip` varchar(64) NOT NULL COMMENT 'ip',
  `create_time` datetime NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=348 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_log
-- ----------------------------
INSERT INTO `tb_log` VALUES ('317', 'admin', '修改密码', '/irs/sys/updPwd', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@1ffed21;111111;111111;', '0:0:0:0:0:0:0:1', '2018-04-30 19:50:01');
INSERT INTO `tb_log` VALUES ('318', 'admin', '修改密码', '/irs/sys/updPwd', 'org.apache.shiro.web.servlet.ShiroHttpServletRequest@17b179f;123456;123456;', '0:0:0:0:0:0:0:1', '2018-04-30 19:50:15');
INSERT INTO `tb_log` VALUES ('319', 'admin', '添加角色信息', '/irs/sys/insRole', 'TbRoles [roleId=null, roleName=test, roleRemark=test];1,1,3,2,10,9;', '0:0:0:0:0:0:0:1', '2018-05-11 20:18:33');
INSERT INTO `tb_log` VALUES ('320', 'admin', '添加角色信息', '/irs/sys/insRole', 'TbRoles [roleId=null, roleName=test1, roleRemark=test];1,1,11,9;', '0:0:0:0:0:0:0:1', '2018-05-11 20:18:44');
INSERT INTO `tb_log` VALUES ('321', 'admin', '添加角色信息', '/irs/sys/insRole', 'TbRoles [roleId=null, roleName=tt, roleRemark=ttt];1,1,36,11,9;', '0:0:0:0:0:0:0:1', '2018-05-18 23:58:28');
INSERT INTO `tb_log` VALUES ('322', 'admin', '删除指定角色信息', '/irs/sys/delRole/55', '55;', '0:0:0:0:0:0:0:1', '2018-05-19 00:06:52');
INSERT INTO `tb_log` VALUES ('323', 'admin', '更新管理员信息', '/irs/sys/updAdmin', 'TbAdmin [id=18, username=test, password=null, salt=null, fullname=test, eMail=test@test.com, sex=1, birthday=2018-02-25, address=甘肃省兰州市榆中县和平镇, phone=17601038192, roleId=null, roleName=null];', '0:0:0:0:0:0:0:1', '2018-05-19 00:20:59');
INSERT INTO `tb_log` VALUES ('324', 'admin', '更新角色信息', '/irs/sys/updRole', 'TbRoles [roleId=54, roleName=test1, roleRemark=test];1,1,42,15,14;', '0:0:0:0:0:0:0:1', '2018-05-19 00:21:40');
INSERT INTO `tb_log` VALUES ('325', 'admin', '更新用户信息', '/irs/user/updUser', 'TbUsers [uid=27, eMail=isduxd@qq.com, nickname=test, sex=1, birthday=2018-03-25, address=北京通州科创十四街区, phone=17693109923, eCode=null, status=0, createTime=null];', '0:0:0:0:0:0:0:1', '2018-05-19 00:38:47');
INSERT INTO `tb_log` VALUES ('326', 'admin', '更新用户信息', '/irs/user/updUser', 'TbUsers [uid=27, eMail=isduxd@qq.com, nickname=test, sex=1, birthday=2018-03-25, address=北京通州科创十四街区, phone=17693109923, eCode=null, status=1, createTime=null];', '0:0:0:0:0:0:0:1', '2018-05-19 14:19:22');
INSERT INTO `tb_log` VALUES ('327', 'admin', '添加角色信息', '/irs/sys/insRole', 'TbRoles [roleId=null, roleName=gd, roleRemark=gg];1,1,16,3,2,18,3,2,19,3,2,21,4,2,22,4,2,23,4,2,33,10,9,34,11,9,35,11,9,36,11,9,37,11,9,42,15,14,45,44,43;', '0:0:0:0:0:0:0:1', '2018-05-19 14:19:56');
INSERT INTO `tb_log` VALUES ('328', 'admin', '更新角色信息', '/irs/sys/updRole', 'TbRoles [roleId=56, roleName=gd, roleRemark=gg];1,1,16,3,2,17,3,2,18,3,2,19,3,2,21,4,2,22,4,2,23,4,2,33,10,9,34,11,9,35,11,9,36,11,9,37,11,9;', '0:0:0:0:0:0:0:1', '2018-05-19 14:20:07');
INSERT INTO `tb_log` VALUES ('329', 'admin', '删除指定角色信息', '/irs/sys/delRole/56', '56;', '0:0:0:0:0:0:0:1', '2018-05-19 14:20:16');
INSERT INTO `tb_log` VALUES ('330', 'admin', '更新管理员信息', '/irs/sys/updAdmin', 'TbAdmin [id=1, username=admin, password=null, salt=null, fullname=arthur, eMail=isduxd@163.com, sex=1, birthday=1994-11-08, address=北京市通州区科创十四街, phone=17693109997, roleId=1, roleName=null];', '0:0:0:0:0:0:0:1', '2018-05-19 14:20:32');
INSERT INTO `tb_log` VALUES ('331', 'admin', '更新角色信息', '/irs/sys/updRole', 'TbRoles [roleId=1, roleName=超级管理员, roleRemark=超级管理员];1,1,16,3,2,17,3,2,18,3,2,19,3,2,20,4,2,21,4,2,22,4,2,23,4,2,47,46,2,48,46,2,49,46,2,50,46,2,33,10,9,34,11,9,35,11,9,36,11,9,37,11,9,42,15,14,45,44,43;', '0:0:0:0:0:0:0:1', '2018-05-19 14:43:10');
INSERT INTO `tb_log` VALUES ('332', 'admin', '删除菜单信息', '/irs/sys/delMenuById/58', '58;', '0:0:0:0:0:0:0:1', '2018-05-19 22:07:15');
INSERT INTO `tb_log` VALUES ('333', 'admin', '删除菜单信息', '/irs/sys/delMenuById/57', '57;', '0:0:0:0:0:0:0:1', '2018-05-19 22:08:03');
INSERT INTO `tb_log` VALUES ('334', 'admin', '删除菜单信息', '/irs/sys/delMenuById/59', '59;', '0:0:0:0:0:0:0:1', '2018-05-19 22:09:09');
INSERT INTO `tb_log` VALUES ('335', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:11:33');
INSERT INTO `tb_log` VALUES ('336', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:11:59');
INSERT INTO `tb_log` VALUES ('337', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:14:29');
INSERT INTO `tb_log` VALUES ('338', 'admin', '删除菜单信息', '/irs/sys/delMenuById/61', '61;', '0:0:0:0:0:0:0:1', '2018-05-19 22:14:39');
INSERT INTO `tb_log` VALUES ('339', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:17:23');
INSERT INTO `tb_log` VALUES ('340', 'admin', '删除菜单信息', '/irs/sys/delMenuById/62', '62;', '0:0:0:0:0:0:0:1', '2018-05-19 22:17:30');
INSERT INTO `tb_log` VALUES ('341', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:19:59');
INSERT INTO `tb_log` VALUES ('342', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:20:05');
INSERT INTO `tb_log` VALUES ('343', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:20:09');
INSERT INTO `tb_log` VALUES ('344', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:20:13');
INSERT INTO `tb_log` VALUES ('345', 'admin', '删除菜单信息', '/irs/sys/delMenuById/63', '63;', '0:0:0:0:0:0:0:1', '2018-05-19 22:20:19');
INSERT INTO `tb_log` VALUES ('346', 'admin', '删除菜单信息', '/irs/sys/delMenuById/64', '64;', '0:0:0:0:0:0:0:1', '2018-05-19 22:20:57');
INSERT INTO `tb_log` VALUES ('347', 'admin', '删除菜单信息', '/irs/sys/delMenuById/60', '60;', '0:0:0:0:0:0:0:1', '2018-05-19 22:21:07');

-- ----------------------------
-- Table structure for tb_menus
-- ----------------------------
DROP TABLE IF EXISTS `tb_menus`;
CREATE TABLE `tb_menus` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL COMMENT '菜单名',
  `icon` varchar(20) DEFAULT NULL COMMENT '图标',
  `href` varchar(100) DEFAULT NULL COMMENT '资源地址',
  `perms` varchar(500) DEFAULT NULL COMMENT '权限',
  `spread` varchar(10) NOT NULL COMMENT 'true：展开，false：不展开',
  `parent_id` bigint(20) NOT NULL COMMENT '父节点',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menus
-- ----------------------------
INSERT INTO `tb_menus` VALUES ('1', '后台首页', '', 'page/main.html', '', 'false', '0');
INSERT INTO `tb_menus` VALUES ('2', '管理员管理', '', '', '', 'false', '0');
INSERT INTO `tb_menus` VALUES ('3', '角色管理', '&#xe613;', 'sys/roleList', null, 'false', '2');
INSERT INTO `tb_menus` VALUES ('4', '管理员列表', '&#xe613;', 'sys/adminList', null, 'false', '2');
INSERT INTO `tb_menus` VALUES ('9', '用户管理', '&#xe61d;', null, null, 'false', '0');
INSERT INTO `tb_menus` VALUES ('10', '添加用户', '&#xe608;', 'user/addUser', null, 'false', '9');
INSERT INTO `tb_menus` VALUES ('11', '管理用户', '&#xe60e;', 'user/userList', null, 'false', '9');
INSERT INTO `tb_menus` VALUES ('14', '系统日志', '&#xe61d;', null, null, 'false', '0');
INSERT INTO `tb_menus` VALUES ('15', '日志管理', '&#xe642;', 'log/logList', null, 'false', '14');
INSERT INTO `tb_menus` VALUES ('16', '查看', null, null, 'sys:role:list', 'false', '3');
INSERT INTO `tb_menus` VALUES ('17', '新增', null, null, 'sys:role:save', 'false', '3');
INSERT INTO `tb_menus` VALUES ('18', '修改', null, null, 'sys:role:update', 'false', '3');
INSERT INTO `tb_menus` VALUES ('19', '删除', null, null, 'sys:role:delete', 'false', '3');
INSERT INTO `tb_menus` VALUES ('20', '查看', null, null, 'sys:admin:list', 'false', '4');
INSERT INTO `tb_menus` VALUES ('21', '新增', null, null, 'sys:admin:save', 'false', '4');
INSERT INTO `tb_menus` VALUES ('22', '修改', null, null, 'sys:admin:update', 'false', '4');
INSERT INTO `tb_menus` VALUES ('23', '删除', null, null, 'sys:admin:delete', 'false', '4');
INSERT INTO `tb_menus` VALUES ('33', '新增', null, null, 'user:user:save', 'false', '10');
INSERT INTO `tb_menus` VALUES ('34', '查看', null, null, 'user:user:list', 'false', '11');
INSERT INTO `tb_menus` VALUES ('35', '新增', null, null, 'user:user:save', 'false', '11');
INSERT INTO `tb_menus` VALUES ('36', '修改', null, null, 'user:user:update', 'false', '11');
INSERT INTO `tb_menus` VALUES ('37', '删除', null, null, 'user:user:delete', 'false', '11');
INSERT INTO `tb_menus` VALUES ('42', '查看', '', '', 'log:log:list', 'false', '15');
INSERT INTO `tb_menus` VALUES ('43', 'SQL监控', '&#xe642;', null, null, 'false', '0');
INSERT INTO `tb_menus` VALUES ('44', 'SQL监控', '&#xe642;', 'sys/druid', null, 'false', '43');
INSERT INTO `tb_menus` VALUES ('45', '查看', null, null, 'sys:druid:list', 'false', '44');
INSERT INTO `tb_menus` VALUES ('46', '菜单管理', '&#xe642;', 'sys/menuList', null, 'false', '2');
INSERT INTO `tb_menus` VALUES ('47', '查看', null, null, 'sys:menu:list', 'false', '46');
INSERT INTO `tb_menus` VALUES ('48', '新增', null, null, 'sys:menu:save', 'false', '46');
INSERT INTO `tb_menus` VALUES ('49', '修改', null, null, 'sys:menu:update', 'false', '46');
INSERT INTO `tb_menus` VALUES ('50', '删除', null, null, 'sys:menu:delete', 'false', '46');
INSERT INTO `tb_menus` VALUES ('51', 'tt', '', '', '', 'false', '0');
INSERT INTO `tb_menus` VALUES ('52', 'ttt1', '', '', '', 'false', '51');

-- ----------------------------
-- Table structure for tb_roles
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles`;
CREATE TABLE `tb_roles` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `role_remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_roles
-- ----------------------------
INSERT INTO `tb_roles` VALUES ('1', '超级管理员', '超级管理员');
INSERT INTO `tb_roles` VALUES ('53', 'test', 'test');
INSERT INTO `tb_roles` VALUES ('54', 'test1', 'test');

-- ----------------------------
-- Table structure for tb_roles_menus
-- ----------------------------
DROP TABLE IF EXISTS `tb_roles_menus`;
CREATE TABLE `tb_roles_menus` (
  `menu_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`menu_id`,`role_id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_roles_menus_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `tb_menus` (`menu_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_roles_menus_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `tb_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_roles_menus
-- ----------------------------
INSERT INTO `tb_roles_menus` VALUES ('1', '1');
INSERT INTO `tb_roles_menus` VALUES ('2', '1');
INSERT INTO `tb_roles_menus` VALUES ('3', '1');
INSERT INTO `tb_roles_menus` VALUES ('4', '1');
INSERT INTO `tb_roles_menus` VALUES ('9', '1');
INSERT INTO `tb_roles_menus` VALUES ('10', '1');
INSERT INTO `tb_roles_menus` VALUES ('11', '1');
INSERT INTO `tb_roles_menus` VALUES ('14', '1');
INSERT INTO `tb_roles_menus` VALUES ('15', '1');
INSERT INTO `tb_roles_menus` VALUES ('16', '1');
INSERT INTO `tb_roles_menus` VALUES ('17', '1');
INSERT INTO `tb_roles_menus` VALUES ('18', '1');
INSERT INTO `tb_roles_menus` VALUES ('19', '1');
INSERT INTO `tb_roles_menus` VALUES ('20', '1');
INSERT INTO `tb_roles_menus` VALUES ('21', '1');
INSERT INTO `tb_roles_menus` VALUES ('22', '1');
INSERT INTO `tb_roles_menus` VALUES ('23', '1');
INSERT INTO `tb_roles_menus` VALUES ('33', '1');
INSERT INTO `tb_roles_menus` VALUES ('34', '1');
INSERT INTO `tb_roles_menus` VALUES ('35', '1');
INSERT INTO `tb_roles_menus` VALUES ('36', '1');
INSERT INTO `tb_roles_menus` VALUES ('37', '1');
INSERT INTO `tb_roles_menus` VALUES ('42', '1');
INSERT INTO `tb_roles_menus` VALUES ('43', '1');
INSERT INTO `tb_roles_menus` VALUES ('44', '1');
INSERT INTO `tb_roles_menus` VALUES ('45', '1');
INSERT INTO `tb_roles_menus` VALUES ('46', '1');
INSERT INTO `tb_roles_menus` VALUES ('47', '1');
INSERT INTO `tb_roles_menus` VALUES ('48', '1');
INSERT INTO `tb_roles_menus` VALUES ('49', '1');
INSERT INTO `tb_roles_menus` VALUES ('50', '1');
INSERT INTO `tb_roles_menus` VALUES ('1', '53');
INSERT INTO `tb_roles_menus` VALUES ('2', '53');
INSERT INTO `tb_roles_menus` VALUES ('3', '53');
INSERT INTO `tb_roles_menus` VALUES ('4', '53');
INSERT INTO `tb_roles_menus` VALUES ('16', '53');
INSERT INTO `tb_roles_menus` VALUES ('20', '53');
INSERT INTO `tb_roles_menus` VALUES ('1', '54');
INSERT INTO `tb_roles_menus` VALUES ('14', '54');
INSERT INTO `tb_roles_menus` VALUES ('15', '54');
INSERT INTO `tb_roles_menus` VALUES ('42', '54');

-- ----------------------------
-- Table structure for tb_users
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `uid` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `e_mail` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL COMMENT '昵称：唯一',
  `password` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL COMMENT '0:女，1:男，2：保密',
  `birthday` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `e_code` varchar(50) NOT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '0:未激活，1，正常，2，禁用',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('8', 'isduxd@163.com', 'admin', '96e79218965eb72c92a549dd5a330112', '2', '2018-02-17', '北京市通州区', '17693109997', '7783b2d8600247ee8bdbbf548e6ae553967', '1', '2018-02-19 22:06:24');
INSERT INTO `tb_users` VALUES ('14', '99392429@qq.com', 'test2', '96e79218965eb72c92a549dd5a330112', '1', '2018-02-08', '北京市通州区', '17693109998', '81181e3c53624effa07f9256a0efc154825', '2', '2018-02-18 22:44:43');
INSERT INTO `tb_users` VALUES ('15', 'isduxd@gmail.com', 'test1', '96e79218965eb72c92a549dd5a330112', '0', '2018-02-14', '北京通州科创十四街区', '17693109923', 'aa06647e073f4f26bbe62c1bf8ac3b15806', '0', '2018-02-20 19:01:39');
INSERT INTO `tb_users` VALUES ('27', 'isduxd@qq.com', 'test', '96e79218965eb72c92a549dd5a330112', '1', '2018-03-25', '北京通州科创十四街区', '17693109923', 'b3f28566dac54f86bd4f4c2ce36e23d8019', '1', '2018-03-25 14:48:48');



CREATE TABLE `tb_department` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '部门名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级部门ID',
  `principal` varchar(64) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(20) DEFAULT NULL COMMENT '负责人电话',
  `valid` tinyint(1) DEFAULT NULL COMMENT '是否有效(1.有效；0.无效)',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;



CREATE TABLE `tb_area` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL COMMENT '名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级地区ID',
  `valid` tinyint(1) DEFAULT NULL COMMENT '是否有效(1.有效；0.无效)',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tb_supplier` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL COMMENT '供应商名称',
  `nick` varchar(100) DEFAULT NULL COMMENT '简称',
  `type` int(2) DEFAULT NULL COMMENT '供应商类别(0.材料供应商；1.工程分包商)',
  `principal_name` varchar(64) DEFAULT NULL COMMENT '负责人',
  `principal_phone` varchar(20) DEFAULT NULL COMMENT '负责人电话',
  `contact_name` varchar(100) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(20) DEFAULT NULL COMMENT '联系人电话',
  `area_id` bigint(20) DEFAULT NULL COMMENT '地区ID',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  `valid` tinyint(1) DEFAULT NULL COMMENT '是否有效(1.有效；0.无效)',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_customers` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `full_name` varchar(50) DEFAULT NULL COMMENT '客户名称',
  `short_name` varchar(50) DEFAULT NULL COMMENT '客户简称',
  `type` int(1) DEFAULT NULL COMMENT '客户类别 0：发展商\r\n1：委托商',
  `charge_name` varchar(20) DEFAULT NULL COMMENT '负责人姓名',
  `charge_phone` varchar(20) DEFAULT NULL COMMENT '负责人电话',
  `link_name` varchar(20) DEFAULT NULL COMMENT '联系人电话',
  `link_phone` varchar(20) DEFAULT NULL COMMENT '联系人电话\n',
  `area` bigint(20) DEFAULT NULL COMMENT '所属区域',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `is_force` int(1) DEFAULT NULL COMMENT '是否生效 1:生效 0:未生效',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `add_date` datetime DEFAULT NULL COMMENT '新增时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
