-- 文章表
CREATE TABLE article(
  `id` bigint(10) AUTO_INCREMENT,
  `gm_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gtm_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `classify_id` bigint(10) COMMENT '专题分类id, 与专题表对应',
  `title` varchar(20) NOT NULL COMMENT '文章标题',
  `desc` varchar(240) NOT NULL COMMENT '文章简介',
  `content` text NULL COMMENT '文章内容',
  `url` varchar(120) NOT NULL COMMENT '定义文章链接地址',

  `state` int NOT NULL DEFAULT 0 COMMENT '是否发布状态标识, 0: 隐藏, 1: 显示',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='文章表';
