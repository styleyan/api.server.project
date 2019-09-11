package com.isyxf.blog.dao;

import com.isyxf.blog.entity.ArticleMappingTag;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaofei.yan
 * @Create 2019-09-09 16:41
 * @Descript 文章标签映射表
 */
public interface ArticleMappingTagDao {
    /**
     * 查询所有标签
     * @param id 文章/tag id
     * @param type id类型: id类型: 1:文章, 0:标签
     * @return
     */
    List<ArticleMappingTag> list(@Param("id") int id, @Param("type") int type);

    /**
     * 文章id添加标签
     * @param id 文章id
     * @param tagsId 标签列表
     * @return
     */
    long insert(@Param("id") int id, ArrayList<String> tagsId);

    /**
     * 删除映射
     * @param id 文章/tag 的id
     * @param type id类型: 1:文章, 0:标签
     * @return
     */
    boolean delete(@Param("id") int id, @Param("type") int type);
}
