-- 个人书单表
CREATE TABLE `blog_books` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `progress` int(1) NOT NULL DEFAULT 0 COMMENT '状态: 0：未读, 1: 正在读, 2：已读',
  `classify_id` int(2) NOT NULL DELETE 0 COMMENT '数的分类标签',
  `book_name` varchar(100) NOT NULL  COMMENT '书名',
  `book_score` float NOT NULL  COMMENT '评分',
  `book_reason` varchar(250) NOT NULL  COMMENT '推荐理由',
  `book_evaluate` varchar(250) NOT NULL  COMMENT '评价',
  `state` int(1) NOT NULL DEFAULT 1 COMMENT '是否显示, 1:显示, 0: 不显示',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COLLATE=utf8mb4_unicode_ci COMMENT='个人书单表';