package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Link;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Y.jer
 * 友链相关接口
 */
@Repository("linkDao")
public interface LinkDao {
    /**
     * 添加友链
     * @param link
     * @return
     */
    int insert(Link link);

    /**
     * 删除友链
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 更新友链
     * @param link
     * @return
     */
    boolean update(Link link);

    /**
     * 查询友链
     * @return
     */
    List<Link> selectAll(@Param("state") Integer state);
}
