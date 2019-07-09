package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.ArticleDao;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Y.jer
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void add(Article article) {

    }

    @Override
    public void remove(int id) {
        articleDao.delete(id);
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
        return articleDao.selectPage(1, 10);
    }
}
