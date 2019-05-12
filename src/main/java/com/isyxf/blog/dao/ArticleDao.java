package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articleDao")
public interface ArticleDao {
    void insert(Article article);
    void delete(long id);
    void update(Article article);
    Article selectById(long id);
    List<Article> selectAll();
}
