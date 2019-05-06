-- 添加关联表
alter table article add constraint fk_article_classify foreign key(classify_id) references classify(id);