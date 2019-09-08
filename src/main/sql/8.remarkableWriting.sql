-- 个人奇文表
CREATE TABLE `blog_remarkable_writing` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '是否显示: 0：隐藏，1：显示',
  `url` varchar(260) NOT NULL  COMMENT 'url 链接地址',
  `title` varchar(120) NOT NULL  COMMENT '链接名称',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COLLATE=utf8mb4_unicode_ci COMMENT='个人奇文表';