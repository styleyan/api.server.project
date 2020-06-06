# 清单

- 自定义异常处理
- 数据库创建检查
- ~~返回日期格式化~~
- ~~使用fastJSON增加值为null处理, 添加默认处理~~
- ~~logback-spring进行日志处理~~




Error querying database. Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ',( '2' ), ORDER BY gmt_create DESC)' at line 7
 ### The error may exist in file [D:\myStatus\api.server.project\target\classes\mybatis\mapper\ArticleDao.xml]
 ### The error may involve com.isyxf.blog.dao.ArticleDao.search-Inline
 ### The error occurred while setting parameters
 ### SQL: select count(0) from (SELECT id,state,gmt_create,gmt_modify,title,url,tags,classify_id,brief FROM blog_article WHERE title LIKE '%%' AND concat(',', tags, ',') regexp ,( ? ), ORDER BY gmt_create DESC) tmp_count
 ### Cause: java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ',( '2' ), ORDER BY gmt_create DESC)' at line 7 ; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near ',( '2' ), ORDER BY gmt_create DESC)' at line 7