package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.ArticleDao;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    @Override
    public void add(Article article) {

    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void edit(Article article) {

    }

    @Override
    public Article getById(Integer id) {
        return articleDao.selectById(id);
    }

    @Override
    public List<Article> getAll() {
        return null;
    }
}
