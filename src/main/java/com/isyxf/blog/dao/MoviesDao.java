package com.isyxf.blog.dao;

import com.isyxf.blog.entity.Movies;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Y.jer
 * 影视接口
 */
@Repository("moviesDao")
public interface MoviesDao {
    /**
     * 搜索影视
     * @param name
     * @param state
     * @return
     */
    List<Movies> search(@Param("name") String name, Integer state);

    /**
     * 添加影视
     * @param movies
     * @return
     */
    int insert(Movies movies);

    /**
     * 更新影视
     * @param movies
     * @return
     */
    int update(Movies movies);

    /**
     * 删除影视
     * @param id
     * @return
     */
    boolean delete(@Param("id") int id);
}
