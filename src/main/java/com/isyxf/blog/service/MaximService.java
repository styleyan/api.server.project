package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Maxim;

/**
 * @author Y.jer
 * 箴言接口
 */
public interface MaximService {
    /**
     * 添加箴言
     * @param maxim
     * @return
     */
    Result add(Maxim maxim);

    /**
     * 编辑箴言
     * @param maxim
     * @return
     */
    Result edit(Maxim maxim);

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
    Result queryAll();
}
