package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;

/**
 * C端相关查询接口
 */
public interface ClientService {
    /**
     * 文章归档
     * @return
     */
    Result archiveList();

    /**
     * 文章详情
     */
    Result articleDetail(String url);
}
