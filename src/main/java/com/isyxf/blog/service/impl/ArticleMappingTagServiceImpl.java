package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.ArticleMappingTagDao;
import com.isyxf.blog.entity.ArticleMappingTag;
import com.isyxf.blog.service.ArticleMappingTagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Y.jer
 */
@Service
public class ArticleMappingTagServiceImpl implements ArticleMappingTagService {

    @Resource
    private ArticleMappingTagDao articleMappingTagDao;

    @Override
    public List<ArticleMappingTag> list(int id, int type) {
        return articleMappingTagDao.list(id, type);
    }

    @Override
    public long insert(int id, String ids) {
        try {
            ArrayList<String> idList = new ArrayList<>(Arrays.asList(ids.split(",")));
            return articleMappingTagDao.insert(id, idList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean delete(int id, int type) {
        try {
            return articleMappingTagDao.delete(id,type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
