package com.isyxf.blog.controller;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.User;
import com.isyxf.blog.service.UsersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @author Y.jer
 *
 * 书单请求列表
 */
@RestController
@RequestMapping(value = "/api/user")
public class UsersController {
    @Resource
    private UsersService usersService;
    @Resource
    private ValueOperations<String, Object> valueOperations;
    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody User user, HttpServletResponse response) {

        if (StringUtils.isBlank(user.getPassword()) || StringUtils.isBlank(user.getUserName())) {
            return Result.failure(2003, "账号/密码不能为空");
        }

        Result result = usersService.findUser(user);
        if (result.getCode() != 0) {
            return result;
        }

        String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        Cookie cookie = new Cookie("_YXF_TOKEN_", uuid);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60 * 60 * 24 * 365);
        response.addCookie(cookie);

        // 设置 redis 缓存
        valueOperations.set(uuid, "2333", 365, TimeUnit.DAYS);
        return result;
    }
}
