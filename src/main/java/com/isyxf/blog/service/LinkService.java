package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Link;

/**
 * @author Y.jer
 * 友链
 */
public interface LinkService {

    /**
     * 添加友链
     * @param link
     * @return
     */
    Result add(Link link);

    /**
     * 删除友链
     * @param id
     * @return
     */
    Result remove(Integer id);

    /**
     * 编辑友链
     * @param link
     * @return
     */
    Result edit(Link link);

    /**
     * 获取所有友链
     * @return
     */
    Result getAll();
}
