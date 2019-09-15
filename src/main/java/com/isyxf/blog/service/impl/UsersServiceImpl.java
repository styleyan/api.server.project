package com.isyxf.blog.service.impl;

import com.isyxf.blog.dao.UsersDao;
import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.User;
import com.isyxf.blog.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Y.jer
 * 后台登录
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    @Override
    public Result findUser(User user) {
        if (StringUtils.isBlank(user.getUserName()) || StringUtils.isBlank(user.getPassword())) {
            return null;
        }

        try{
            User result = usersDao.findUser(user);
            if (result == null) {
                return Result.failure(2333, "账号或密码错误");
            }
            return Result.success(result);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.failure(2003, "登录异常");
        }
    }
}
