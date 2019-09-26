package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Books;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Y.jer
 * 书单接口
 */
@Repository("booksDao")
public interface BooksDao {
    /**
     * 查询所有书单
     * @return
     */
    List<Books> selectPage();

    /**
     * 搜索书单
     */
    List<Books> search(@Param("name") String name, Integer state);

    /**
     * 添加书单
     * @param books
     * @return
     */
    int insert(Books books);

    /**
     * 更新书单
     * @param books
     * @return
     */
    int update(Books books);

    /**
     * 删除书单
     * @param id
     * @return
     */
    boolean delete(@Param("id") int id);
}
