CREATE DATABASE /*!32312 IF NOT EXISTS*/`zjjw` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `zjjw`;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `phone` char(11) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(16) DEFAULT NULL COMMENT '住宅电话',
  `address` varchar(64) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐加密',
  `userface` varchar(128) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `name_zh` varchar(64) DEFAULT NULL COMMENT '角色名称中文',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL COMMENT 'url',
  `component` varchar(64) DEFAULT NULL COMMENT '菜单内容',
  `name` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `icon_cls` varchar(64) DEFAULT NULL COMMENT '图标',
  `keep_alive` tinyint(1) DEFAULT NULL COMMENT '保活',
  `require_auth` tinyint(1) DEFAULT NULL COMMENT '要求',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否可用',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `parent_id` (`parent_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for hr_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=278 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '群ID',
  `name` varchar(32) DEFAULT NULL COMMENT '群名称',
  `admin_id` bigint(20) DEFAULT NULL COMMENT '群主ID',
  `icon` varchar(128) DEFAULT NULL COMMENT '群图标',
  `notice` varchar(256) DEFAULT NULL COMMENT '群公告',
  `info` varchar(128) DEFAULT NULL COMMENT '群介绍',
  `remark` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `group_to_user`;
CREATE TABLE `group_to_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `group_id` bigint(20) DEFAULT NULL COMMENT '群ID',
  `nick` varchar(32) DEFAULT NULL COMMENT '群昵称',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `msg_content`;
CREATE TABLE `msg_content` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content_id` bigint(20) NOT NULL COMMENT '消息ID',
  `content` varchar(256) DEFAULT NULL COMMENT '消息内容',
  `type` int(4) DEFAULT '0' COMMENT '消息类型',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `msg_index`;
CREATE TABLE `msg_index` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL  COMMENT '用户ID',
  `receiver_id` bigint(20) NOT NULL  COMMENT '接收人ID',
  `content_id` bigint(20) NOT NULL  COMMENT '消息ID',
  `type` int(4) DEFAULT '0' COMMENT '类型',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `msg_recent`;
CREATE TABLE `msg_recent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL  COMMENT '用户ID',
  `receiver_id` bigint(20) NOT NULL  COMMENT '接收人ID',
  `content_id` bigint(20) NOT NULL  COMMENT '消息ID',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `msg_group`;
CREATE TABLE `msg_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` bigint(20) DEFAULT NULL COMMENT '群ID',
  `content` varchar(256) DEFAULT NULL COMMENT '消息内容',
  `send_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `send_nick` varchar(32) DEFAULT NULL COMMENT '发送者昵称',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `msg_group_to_user`;
CREATE TABLE `msg_group_to_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_id` bigint(20) DEFAULT NULL COMMENT '群ID',
  `msg_group_id` bigint(20) DEFAULT NULL COMMENT '群消息ID',
  `content` varchar(256) DEFAULT NULL COMMENT '消息内容',
  `receiver_id` bigint(20) DEFAULT NULL COMMENT '接收者ID',
  `state` int(4) DEFAULT '0' COMMENT '消息状态',
  `create_time` timestamp NULL DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_name` varchar(32) COMMENT '企业名称',
	`is_list` int(2) DEFAULT '0' COMMENT '是否上市',
	`base_info` varchar(500)  COMMENT '基本信息',
	`city` varchar(32) COMMENT '城市',
	`financing` varchar(32) COMMENT '融资',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业信息表';

DROP TABLE IF EXISTS `company_dynamic`;
CREATE TABLE `company_dynamic` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`type` int(4) DEFAULT '0' COMMENT '动态类型',
	`dynamic_info` varchar(128) DEFAULT NULL COMMENT '动态信息',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业动态表';

DROP TABLE IF EXISTS `company_evaluate`;
CREATE TABLE `company_evaluate` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`evaluate_info` varchar(500) DEFAULT NULL COMMENT '评价信息',
	`recommend` int(8) DEFAULT '0' COMMENT '推荐数量',
	`recommend_reason` varchar(500) DEFAULT NULL COMMENT '推荐原因',
	`commonly` int(8) DEFAULT '0' COMMENT '一般数量',
	`commonly_reason` varchar(500) NOT NULL COMMENT '一般原因',
	`not_recommend` int(8) DEFAULT '0' COMMENT '不推荐数量',
	`not_recommend_reason` varchar(500) DEFAULT NULL COMMENT '不推荐原因',
	`acclaim_probability` varchar(16) DEFAULT NULL COMMENT '好评率',
	`praise` int(8) DEFAULT '0' COMMENT '点赞',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业评价表';

DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`knock_out_info` varchar(128)  COMMENT '爆料信息',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业爆料表';

DROP TABLE IF EXISTS `company_product`;
CREATE TABLE `company_product` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`product_name` varchar(128)  COMMENT '产品名称',
	`product_info` varchar(128) COMMENT '产品信息',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业产品表';

DROP TABLE IF EXISTS `company_position`;
CREATE TABLE `company_position` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`position_name` varchar(128) COMMENT '职位名称',
	`position_info` varchar(128) COMMENT '职位信息',
	`position_requirement` varchar(128) COMMENT '职位信息',
	`is_listed` int(2) DEFAULT '0' COMMENT '是否上市',
	`minimum_salary` int(8) DEFAULT '0' COMMENT '最低薪资',
	`maximum_salary` int(8) DEFAULT '0' COMMENT '最高薪资',
	`address` varchar(128) NOT NULL COMMENT '地址',
	`minimum_experience` int(8) DEFAULT '0' COMMENT '最低经验',
	`maximum_experience` int(8) DEFAULT '0' COMMENT '最高经验',
	`degree` varchar(16) NOT NULL COMMENT '学历',
	`welfare_label` varchar(128) NOT NULL COMMENT '地址',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='企业职位表';

DROP TABLE IF EXISTS `interview`;
CREATE TABLE `interview` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL COMMENT '企业ID',
	`position_id` bigint(20) NOT NULL COMMENT '职位ID',
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
	`statue` int(4) DEFAULT '0' COMMENT '状态',
	`resume_id` bigint(20) NOT NULL COMMENT '简历ID',
	`resume_share` int(2) DEFAULT '0' COMMENT '是否分享简历',
	`interview_experience` varchar(500) NOT NULL COMMENT '面试经验',
	`company_condition` varchar(128) COMMENT '公司环境',
	`salary` int(8) DEFAULT '0' COMMENT '薪资待遇',
	`interview_num` int(4) DEFAULT '0' COMMENT '几轮面试',
	`entry_intention` int(8) DEFAULT '0' COMMENT '入职意向',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='面试表';


DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
	`age` int(4) DEFAULT NULL COMMENT '年龄',
	`gender` int(4) DEFAULT NULL COMMENT '性别',
	`degree` varchar(16) NOT NULL COMMENT '学历',
	`birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
	`occupation` varchar(16) NOT NULL COMMENT '职业',
	`hometown` varchar(128) DEFAULT NULL COMMENT '家乡',
	`email` varchar(16) NOT NULL COMMENT '邮箱',
	`phone` varchar(16) NOT NULL COMMENT '手机号',
	`wechat` varchar(16) NOT NULL COMMENT '微信',
	`qq` varchar(16) NOT NULL COMMENT 'qq',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

DROP TABLE IF EXISTS `user_relation`;
CREATE TABLE `user_relation` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
	`relation_user_id` bigint(20) NOT NULL COMMENT '关系用户ID',
	`age` int(4) DEFAULT NULL COMMENT '年龄',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户关系表';

DROP TABLE IF EXISTS `user_resume`;
CREATE TABLE `user_resume` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
	`impression_score` int(8) DEFAULT NULL COMMENT '印象分',
	`skill` varchar(16) NOT NULL COMMENT '技能',
	`education` varchar(16) NOT NULL COMMENT '教育经历',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户简历信息表';

DROP TABLE IF EXISTS `user_education`;
CREATE TABLE `user_education` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
	`school` varchar(16) NOT NULL COMMENT '学校',
	`education` varchar(16) NOT NULL COMMENT '教育经历',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户教育经历表';

DROP TABLE IF EXISTS `user_dynamic`;
CREATE TABLE `user_dynamic` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`user_id` bigint(20) NOT NULL COMMENT '用户ID',
	`type` int(4) DEFAULT NULL COMMENT '动态类型',
	`dynamic_info` varchar(128) DEFAULT NULL COMMENT '动态信息',
	`evaluate_mark` varchar(128) DEFAULT NULL COMMENT '企业评价标记',
	`is_delete` int(2) DEFAULT '0' COMMENT '是否删除',
	`create_time` timestamp NULL DEFAULT NULL,
	`update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
	`remark` varchar(500) DEFAULT '' COMMENT '备注',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='用户动态表';
