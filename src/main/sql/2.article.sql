-- 创建数据库
CREATE TABLE article(
  `id` bigint(10) unsigned NOT NULL AUTO_INCREMENT,
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gtm_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP '修改时间',
  `state` tinyint NOT NULL DEFAULT 0 COMMENT '状态标识: 0: 隐藏, 1: 显示',
  `classify_id` tinyit NOT NULL DEFAULT 0 COMMIT '文章分类id',
  `content` text NULL COMMIT '文章内容',
  `title` varchar(20) NOT NULL COMMENT '文章标题',
  `desc` values(120) NOT NULL COMMENT '文章简介',
)
