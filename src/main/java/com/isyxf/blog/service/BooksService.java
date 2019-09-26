package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.Books;

/**
 * @author Y.jer
 * 箴言接口
 */
public interface BooksService {
    /**
     * 添加书单
     * @param books
     * @return
     */
    Result add(Books books);

    /**
     * 更新书单
     * @param books
     * @return
     */
    Result update(Books books);

    /**
     * 删除书单
     * @param id
     * @return
     */
    Result remove(Integer id);

    /**
     * 获取书单
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result queryList(int pageNum, int pageSize);

    /**
     * 搜索书单
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result searchList(int pageNum, int pageSize, String name, Integer state);
}
