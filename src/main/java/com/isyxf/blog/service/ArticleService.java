package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;


/**
 * @author Y.jer
 * 文章相关操作接口
 */
public interface ArticleService {
    Result add(Article article);
    Result remove(int id);
    Result edit(Article article);
    Result getById(Integer id);
    Result selectWithPage(int pageNum, int pageSize);
}
