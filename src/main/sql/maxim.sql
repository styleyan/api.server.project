-- 个人箴言表
CREATE TABLE `blog_maxim` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(1) NOT NULL DEFAULT 1 COMMENT '是否显示: 0：隐藏，1：显示',
  `context` varchar(520) NOT NULL  COMMENT '箴言内容',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COLLATE=utf8mb4_unicode_ci COMMENT='个人箴言表';