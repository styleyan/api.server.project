-- 创建友链表
CREATE TABLE link(
   `id` bigint(10) unsigned AUTO_INCREMENT,
   `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `gtm_modify` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
   `website_name` varchar(20) NOT NULL COMMENT '友链名称',
   `website_url` varchar(120) NOT NULL COMMENT '链接地址',
   `desc` varchar(240) NOT NULL COMMENT '友链描述',
   `https` int NOT NULL DEFAULT 1 COMMENT '是否是https: 0: 否, 1: 是',
   primary key (`id`)
) ENGINE = InnoDB AUTO_INCREMENT=100000 DEFAULT CHARSET=utf8 COMMENT='友链表';


