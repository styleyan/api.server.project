package com.isyxf.blog.controller;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Y.jer
 */
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * TODO: 使用 Article 对象来接收请求体, 这种形式会将 JSON 字符串的值赋予 user 中对应的属性上，需要注意的是
     * JSON字符串中的key必须对应user中的属性名，否则是请求不过去的。
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public void add(@RequestBody Article article) {
        System.out.println(article);
    }

    /**
     * 删除文章
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public Result remove(@PathVariable("id") int id) {
        Result globalResult;

        try {
            articleService.remove(id);
            globalResult = Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            globalResult = Result.failure(2003, e.getMessage());
        }

        return globalResult;
    }

    /**
     * 查询文章列表
     * @return List<Article> 返回文章列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list() {
        List<Article> list = articleService.getAll();
        Result globalResult = Result.success(list);

        return globalResult;
    }

    /**
     * 查询文章信息
     * @param id 文章id
     * @return 文章实体对象
     */
    @RequestMapping(value = "/{id}/detail", method = RequestMethod.GET)
    public Result detail(@PathVariable("id") int id) {
        Result result;

        try {
            Article article1 = articleService.getById(id);
            result = Result.success(article1);
        } catch (Exception e) {
            e.printStackTrace();
            result = Result.failure(2003, e.getMessage());
        }

        return result;
    }
}
