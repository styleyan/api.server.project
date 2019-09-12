package com.isyxf.blog.service;

import com.isyxf.blog.entity.ArticleMappingTag;

import java.util.List;

/**
 * @author Y.jer
 * 文章、标签映射 Service
 */
public interface ArticleMappingTagService {
    /**
     * 查询所有标签
     * @param id 文章/tag id
     * @param type id类型: id类型: 1:文章, 0:标签
     * @return
     */
    List<ArticleMappingTag> list(int id, int type);

    /**
     * 文章id添加标签
     * @param id 文章id
     * @param ids 标签字符
     * @return
     */
    long insert(int id, String ids);

    /**
     * 删除映射
     * @param id 文章/tag 的id
     * @param type id类型: 1:文章, 0:标签
     * @return
     */
    boolean delete(int id, int type);
}
