package com.isyxf.blog.service;

import com.isyxf.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    void add(Article article);
    void remove(long id);
    void edit(Article article);
    Article getById(Integer id);
    List<Article> getAll();
}
