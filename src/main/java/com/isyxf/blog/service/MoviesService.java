package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Movies;

/**
 * @author Y.jer
 * 影视接口
 */
public interface MoviesService {
    /**
     * 添加影视
     * @param movies
     * @return
     */
    Result add(Movies movies);

    /**
     * 更新影视
     * @param movies
     * @return
     */
    Result update(Movies movies);

    /**
     * 删除影视
     * @param id
     * @return
     */
    Result remove(Integer id);

    /**
     * 获取影视列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result queryList(int pageNum, int pageSize);

    /**
     * 搜索影视
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result searchList(int pageNum, int pageSize, String name, Integer state);
}
