package com.isyxf.blog.dao;

import com.isyxf.blog.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户登录相关操作
 * @author Y.jer
 */
@Repository("usersDao")
public interface UsersDao {
    /**
     * 查询用户
     * @param user
     * @return
     */
    User findUser(User user);
}
