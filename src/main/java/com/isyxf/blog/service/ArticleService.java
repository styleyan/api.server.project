package com.isyxf.blog.service;

import com.isyxf.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    void add(Article article);
    void remove(Integer id);
    void edit(Article article);
    Article get(Integer id);
    List<Article> getAll();
}
