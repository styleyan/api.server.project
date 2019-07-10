package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.ArticleDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
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
    public Result selectPage() {
        try {
            Map map = new HashMap();
            List list = articleDao.selectPage(1, 10);

            // 为空则返回空数组
            if (list == null) {
                list = new ArrayList();
            }

            map.put("list", list);
            map.put("total", 200);
            map.put("pageSize", 10);
            map.put("currentPage", 1);
            map.put("totalPage", 20);

            return Result.success(map);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询异常");
        }
    }
}
