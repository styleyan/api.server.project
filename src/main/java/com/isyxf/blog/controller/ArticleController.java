package com.isyxf.blog.controller;

import com.isyxf.blog.dto.GlobalResult;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 查询文章列表
     * @return List<Article> 返回文章列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public GlobalResult list() {
        List<Article> list = articleService.getAll();
        GlobalResult<List<Article>> globalResult = new GlobalResult<List<Article>>(true, list);

        return globalResult;
    }

    /**
     * 查询文章信息
     * @param id 文章id
     * @return 文章实体对象
     */
    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public GlobalResult detail(@PathVariable("id") Integer id) {
        GlobalResult<Article> result;

        try {
            Article article1 = articleService.getById(id);
            result = new GlobalResult<Article>(true, article1);
        } catch (Exception e) {
            e.printStackTrace();
            result = new GlobalResult<Article>(false, e.getMessage(), 2003);
        }

        return result;
    }


    /**
     * 删除文章
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public GlobalResult remove(@PathVariable("id") long id) {
        GlobalResult globalResult;

        try {
            articleService.remove(id);
            globalResult = new GlobalResult(true, null);
        } catch (Exception e) {
            e.printStackTrace();
            globalResult = new GlobalResult(false, e.getMessage());
        }

        return globalResult;
    }
}
