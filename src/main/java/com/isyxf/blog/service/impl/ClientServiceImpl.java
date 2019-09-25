package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.ArticleDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Y.jer
 * C 端相关查询
 */
@Service
public class ClientServiceImpl implements ClientService {
    private final static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleDao articleDao;

    @Override
    public Result archiveList() {
        List<Article> list = articleDao.search("");
        return Result.success(list);
    }
}
