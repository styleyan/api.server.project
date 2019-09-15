package com.isyxf.blog.service;

import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.User;

public interface UsersService {
    /**
     * 通过密码或账号查询
     * @param user
     * @return
     */
    Result findUser(User user);
}
