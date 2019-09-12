package com.isyxf.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isyxf.blog.dao.ArticleDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleMappingTagService;
import com.isyxf.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Y.jer
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleDao articleDao;
    @Resource
    private ArticleMappingTagService articleMappingTagService;

    /**
     * 添加文章
     * @param article
     * @return
     */
    @Override
    public Result add(Article article) {
        try {
            articleDao.insert(article);
            articleMappingTagService.delete(article.getId(), 1);
            articleMappingTagService.insert(article.getId(), article.getTags());
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
            articleMappingTagService.delete(id, 1);
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
            articleMappingTagService.delete(article.getId(), 1);
            articleMappingTagService.insert(article.getId(), article.getTags());
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
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Article> listInfo = new PageInfo<>(articleDao.selectPage());

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, e.getMessage());
        }
    }
}
