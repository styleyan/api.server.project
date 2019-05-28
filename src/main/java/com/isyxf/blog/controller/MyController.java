package com.isyxf.blog.controller;

import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/out")
    public String out() {
        Article article = articleService.getById(1);

        String str = "sdfsdf";
        return "success";
    }
}
