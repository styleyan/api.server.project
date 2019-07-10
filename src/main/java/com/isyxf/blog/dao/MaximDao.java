package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Maxim;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Y.jer
 * 个人箴言接口
 */
public interface MaximDao {
    /**
     * 查询所有箴言
     * @return
     */
    List<Maxim> selectAll();

    /**
     * 添加箴言
     * @param maxim
     * @return
     */
    int insert(Maxim maxim);

    /**
     * 删除箴言
     * @param id
     * @return
     */
    boolean delete(@Param("id") int id);
}
