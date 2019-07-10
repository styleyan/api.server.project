package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Y.jer
 * 书单接口
 */
public interface BooksDao {
    /**
     * 查询所有书单
     * @return
     */
    List<Books> selectAll();

    /**
     * 添加书单
     * @param books
     * @return
     */
    int insert(Books books);

    /**
     * 删除书单
     * @param id
     * @return
     */
    boolean delete(@Param("id") int id);
}
