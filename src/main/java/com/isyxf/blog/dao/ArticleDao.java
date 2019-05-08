package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articleDao")
public interface ArticleDao {
    void insert(Article article);
    void delete(Integer id);
    void update(Article article);
    Article selectById(Integer id);
    List<Article> selectAll();
}
