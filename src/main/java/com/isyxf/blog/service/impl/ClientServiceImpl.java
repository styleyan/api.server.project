package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.ArticleDao;
import com.isyxf.blog.dao.TagsDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ClientService;
import com.isyxf.blog.utils.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Y.jer
 * C 端相关查询
 */
@Service
public class ClientServiceImpl implements ClientService {
    private final static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleDao articleDao;
    @Resource
    private TagsDao tagsDao;

    @Override
    public Result archiveList() {
        try {
            List<Article> list = articleDao.archiveList();
            return Result.success(list);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询异常");
        }
    }

    /**
     * 文章详情
     * @param url
     * @return
     */
    @Override
    public Result articleDetail(String url) {
        try{
            Article article = articleDao.selectByUrl(url);
            Map<Integer, String> tagList = CommonUtils.tagListToMap(tagsDao.selectAll());

            String[] tags = article.getTags().split(",");
            List<String> stringList = new ArrayList<>();

            for (int j = 0; j < tags.length; j++) {
                String curTag = tags[j];

                if (StringUtils.isNotBlank(curTag)) {
                    stringList.add(tagList.get(Integer.parseInt(curTag)));
                }
            }

            // 将List 转字符串并加入分隔字符的方法
            article.setTags(StringUtils.join(stringList.toArray(),","));

            return Result.success(article);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询异常");
        }
    }
}
