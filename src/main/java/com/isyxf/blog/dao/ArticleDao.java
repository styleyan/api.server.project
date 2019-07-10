package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 文章相关操作
 * @author Y.jer
 */
@Repository("articleDao")
public interface ArticleDao {
    /**
     * 添加文章
     * @param article
     */
    void insert(Article article);

    /**
     * 删除文件
     * @param id 文章id
     */
    void delete(@Param("id") int id);

    /**
     * 更新文章
     * @param article 文章信息
     */
    void update(Article article);

    /**
     * 更具id 查询文章
     * @param id
     * @return
     */
    Article selectById(@Param("id") int id);

    /**
     * 分页查询
     * @param pageSize 分页数量
     * @param currPage 当前页码
     * @return
     */
    List<Article> selectPage(@Param("pageSize") int pageSize, @Param("currPage") int currPage);
}
