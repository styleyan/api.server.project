package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Y.jer
 * 书单接口
 */
@Repository("tagsDao")
public interface TagsDao {
    /**
     * 查询所有书单
     * @return
     */
    List<Tag> selectAll();

    /**
     * 添加书单
     * @param tag
     * @return
     */
    int insert(Tag tag);

    /**
     * 更新书单
     * @param tag
     * @return
     */
    int update(Tag tag);

    /**
     * 删除书单
     * @param id
     * @return
     */
    boolean delete(@Param("id") int id);
}
