CREATE SCHEMA IF NOT EXISTS db_user
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
USE db_user;

DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `display_name` varchar(255) NOT NULL DEFAULT '' COMMENT '显示的用户名',
  `delete_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标志位：0代表未删除，1代表已删除', 
  `creator` varchar(50) NOT NULL DEFAULT "系统" COMMENT '记录添加者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录添加时间',  
  `updater` varchar(50) NOT NULL DEFAULT "系统" COMMENT '记录更新者',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',   
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;