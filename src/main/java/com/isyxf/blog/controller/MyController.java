package com.isyxf.blog.controller;

import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/my")
public class MyController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/out")
    public String out() {
        Article article = null;

        try {
            article= articleService.getById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = "sdfsdf";
        return "success";
    }
}
