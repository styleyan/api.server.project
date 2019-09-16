package com.isyxf.blog.controller;


import com.isyxf.blog.dto.Result;
import com.isyxf.blog.entity.User;
import com.isyxf.blog.service.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


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
    public Result add(@RequestBody User user, HttpServletRequest request) {
        HttpSession session = request.getSession();

        if (session.getAttribute("currentUser") == null) {
            session.setAttribute("user", "zhangsan");
            System.out.println("不存在session");
        } else {
            System.out.println("存在session");
        }
        return usersService.findUser(user);
    }
}
