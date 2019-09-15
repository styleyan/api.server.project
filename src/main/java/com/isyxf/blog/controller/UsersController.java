package com.isyxf.blog.controller;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.User;
import com.isyxf.blog.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


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

    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public Result add(@RequestBody User user) {
        return usersService.findUser(user);
    }
}
