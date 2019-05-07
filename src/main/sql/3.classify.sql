-- 创建专题表
CREATE TABLE classify(
   `id` bigint(10) AUTO_INCREMENT,
   `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `gtm_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   `desc` varchar(240) NOT NULL COMMENT '专题简介',
   `title` varchar(120) NOT NULL COMMENT '专题名称',
   primary key (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='专题表';
