package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Tag;

/**
 * @author Y.jer
 * 箴言接口
 */
public interface TagsService {
    /**
     * 添加箴言
     * @param tag
     * @return
     */
    Result add(Tag tag);

    /**
     * 更新箴言
     * @param tag
     * @return
     */
    Result update(Tag tag);

    /**
     * 删除箴言
     * @param id
     * @return
     */
    Result remove(Integer id);

    /**
     * 获取所有箴言
     * @return
     */
    Result queryList();
}
