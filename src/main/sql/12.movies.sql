-- 影视列表
CREATE TABLE `blog_movies` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` int(1) NOT NULL DEFAULT 0 COMMENT '类型: 1:动漫, 2:纪录片, 3:电影, 4:连续剧',
  `movie_name` varchar(100) unique NOT NULL  COMMENT '影视名',
  `movie_score` float NOT NULL  COMMENT '评分',
  `movie_evaluate` varchar(250) NOT NULL  COMMENT '评价',
  `state` int(1) NOT NULL DEFAULT 1 COMMENT '是否显示, 1:显示, 0: 不显示',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB COLLATE=utf8mb4_unicode_ci COMMENT='影视列表';