package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Books;

/**
 * @author Y.jer
 * 箴言接口
 */
public interface BooksService {
    /**
     * 添加箴言
     * @param books
     * @return
     */
    Result add(Books books);

    /**
     * 更新箴言
     * @param books
     * @return
     */
    Result update(Books books);

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
