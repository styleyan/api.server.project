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
    int insert(Article article);

    /**
     * 删除文章
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
     * 模糊查询
     * @param search 搜索字符
     * @return list
     */
    List<Article> search(
            @Param("search") String search,
            @Param("state") Integer state,
            @Param("arrClassify") String[] arrClassify,
            @Param("arrTags") String arrTags
    );

    /**
     * 归档查询（client 端调用)
     * @return list
     */
    List<Article> archiveList();

    /**
     * 文章详情 (client 端调用)
     * @return
     */
    Article selectByUrl(@Param("url") String url);

    /**
     * 下一篇文章 (client 端调用)
     * @return
     */
    Article selectNextById(@Param("id") Integer id);

    /**
     * 上一篇文章 (client 端调用)
     * @return
     */
    Article selectPrevById(@Param("id") Integer id);
}
