package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.TagsDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Tag;
import com.isyxf.blog.service.ArticleMappingTagService;
import com.isyxf.blog.service.TagsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Y.jer
 * 箴言
 */
@Service
public class TagsServiceImpl implements TagsService {
    @Resource
    private TagsDao tagsDao;
    @Resource
    private ArticleMappingTagService articleMappingTagService;

    /**
     * 添加标签
     * @param tag
     * @return
     */
    @Override
    public Result add(Tag tag) {
        try{
            tagsDao.insert(tag);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "添加异常");
        }
    }

    /**
     * 更新标签
     * @param tag
     * @return
     */
    @Override
    public Result update(Tag tag) {
        try{
            tagsDao.update(tag);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "更新异常");
        }
    }

    /**
     * 删除标签
     * @param id
     * @return
     */
    @Override
    public Result remove(Integer id) {
        try {
            tagsDao.delete(id);
            articleMappingTagService.delete(id, 0);
            return Result.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "删除异常");
        }
    }

    /**
     * 查询所有标签
     * @return
     */
    @Override
    public Result queryList() {
        try {
            List<Tag> listInfo = tagsDao.selectAll();

            return Result.success(listInfo);
        }catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "查询失败");
        }
    }
}
