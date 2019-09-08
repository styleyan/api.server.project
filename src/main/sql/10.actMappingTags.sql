-- 博客标签映射表
CREATE TABLE `blog_article_mapping_tag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `act_id` int(11) NOT NULL DEFAULT 0 COMMENT '文章id',
  `tag_id` int(11) NOT NULL DEFAULT 0 COMMENT '标签id',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COLLATE=utf8mb4_unicode_ci COMMENT='博客标签映射表';