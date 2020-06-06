package com.isyxf.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.isyxf.blog.dao.ArticleDao;
import com.isyxf.blog.dao.ClassifyDao;
import com.isyxf.blog.dao.TagsDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Article;
import com.isyxf.blog.service.ArticleMappingTagService;
import com.isyxf.blog.service.ArticleService;
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
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    @Resource
    private ArticleDao articleDao;
    @Resource
    private ArticleMappingTagService articleMappingTagService;
    @Resource
    private ClassifyDao classifyDao;
    @Resource
    private TagsDao tagsDao;

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

            return Result.success(article.getId());
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
     * 模糊搜索
     * @param search
     * @return
     */
    @Override
    public Result search(int pageNum, int pageSize, String search, Integer state, String tags, String classify) {
        try {
            String arrTags = null;
            String[] arrClassify = null;

            if (state == null) {
                state = -1;
            }
            // 分割标签
            if (StringUtils.isNotBlank(tags)) {
                String temp = tags.replace(",", "|");
                arrTags = ",("+ temp +"),";
            }

            // 分割专题
            if (StringUtils.isNotBlank(classify)) {
                arrClassify = classify.split(",");
                logger.error(arrClassify.toString());
            }

            PageHelper.startPage(pageNum, pageSize);
            PageInfo<Article> listInfo = new PageInfo<>(articleDao.search(search, state, arrClassify, arrTags));

            // 查询标签和分类
            Map<Integer, String> classifyList= CommonUtils.classifyListToMap(classifyDao.selectAll());
            Map<Integer, String> tagList = CommonUtils.tagListToMap(tagsDao.selectAll());

            /**
             * TODO: 需要把【分类、标签】都存到 redis 中
             */
            for (int i = 0; i < listInfo.getSize(); i++) {
                Article article = listInfo.getList().get(i);
                article.setClassifyTitle(classifyList.get(article.getClassifyId()));
                article.setClassifyId(null);

                String[] tag = article.getTags().split(",");
                List<String> stringList = new ArrayList<>();

                for (int j = 0; j < tag.length; j++) {
                    String curTag = tag[j];

                    if (StringUtils.isNotBlank(curTag)) {
                        stringList.add(tagList.get(Integer.parseInt(curTag)));
                    }
                }

                // 将List 转字符串并加入分隔字符的方法
                article.setTags(StringUtils.join(stringList.toArray(),","));

            }

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, e.getMessage());
        }
    }
}
