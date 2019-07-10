package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.RemarkableWriting;

/**
 * @author Y.jer
 * 箴言接口
 */
public interface RemarkableWritingService {
    /**
     * 添加箴言
     * @param remarkableWriting
     * @return
     */
    Result add(RemarkableWriting remarkableWriting);

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
