-- 添加关联表
alter table blog_article add constraint fk_article_classify foreign key(classify_id) references blog_classify(id);