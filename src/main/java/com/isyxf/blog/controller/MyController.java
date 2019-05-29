package com.isyxf.blog.controller;

import com.isyxf.blog.dto.GlobalResult;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/my")
public class MyController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/out/{id}", method = RequestMethod.GET)
    public GlobalResult out(@PathVariable("id") Integer id) {
        GlobalResult<Article> result;

        try {
            Article article1 = articleService.getById(id);
            result = new GlobalResult<Article>(true, article1);

            if (result == null) {
                throw new Exception("查询结果为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new GlobalResult<Article>(false, e.getMessage(), 2003);
        }

        return result;
    }
}
