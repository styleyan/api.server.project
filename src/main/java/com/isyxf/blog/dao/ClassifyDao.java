package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Classify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 文章分类接口
 * 文章分类相关
 */
@Repository("classifyDao")
public interface ClassifyDao {
    /**
     * 添加分类
     * @param classify
     * @return
     */
    Long insert(Classify classify);

    /**
     * 删除分类
     * @param id
     * @return
     */
    Boolean delete(@Param("id") Integer id);

    /**
     * 更新分类
     * @param classify
     * @return
     */
    Boolean update(Classify classify);

    /**
     * 查询单个分类信息
     * @param id
     * @return
     */
    Classify selectById(@Param("id") Integer id);

    /**
     * 查询所有分类
     * @return
     */
    List<Classify> selectAll();
}
