package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Maxim;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Y.jer
 * 个人箴言接口
 */
@Repository("maximDao")
public interface MaximDao {
    /**
     * 查询所有箴言
     * @return
     */
    List<Maxim> selectPage();

    /**
     * 添加箴言
     * @param maxim
     * @return
     */
    int insert(Maxim maxim);

    /**
     * 编辑箴言
     * @param maxim
     * @return
     */
    boolean edit(Maxim maxim);

    /**
     * 删除箴言
     * @param id
     * @return
     */
    boolean delete(@Param("id") int id);
}
