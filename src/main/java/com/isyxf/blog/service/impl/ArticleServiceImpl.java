package com.isyxf.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isyxf.blog.dao.ArticleDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Y.jer
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleDao articleDao;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @Override
    public Result add(Article article) {
        try {
            articleDao.insert(article);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(100, e.getMessage());
        }
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @Override
    public Result remove(int id) {
        try {
            articleDao.delete(id);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, e.getMessage());
        }
    }

    /**
     * 编辑文章
     * @param article
     * @return
     */
    @Override
    public Result edit(Article article) {
        try {
            articleDao.update(article);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, e.getMessage());
        }
    }

    /**
     * 根据文章id获取文章详情
     * @param id
     * @return
     */
    @Override
    public Result getById(Integer id) {
        try {
            Article article1 = articleDao.selectById(id);
            return Result.success(article1);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, e.getMessage());
        }
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public Result selectWithPage(int pageNum, int pageSize) {
        try {
//            PageInfo<Article> listInfo = new PageInfo<>(articleDao.selectPage());

            PageHelper.startPage(pageNum, pageSize);
            List list = articleDao.selectPage();
            PageInfo<Article> listInfo = new PageInfo<>(list);

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, e.getMessage());
        }
    }
}
