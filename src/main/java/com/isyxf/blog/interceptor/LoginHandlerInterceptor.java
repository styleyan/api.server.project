package com.isyxf.blog.interceptor;

import com.alibaba.fastjson.JSON;
import com.isyxf.blog.cache.RedisService;
import com.isyxf.blog.dto.Result;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaofei.yan
 * @Create 2019-09-16 11:16
 * @Descript 登录拦截器
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    private final static Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);

    @Autowired
    private RedisService redisService;
    /**
     * 该方法在处理请求之前进行调用，就是在执行 Controller 的任务之前，如果返回 true 就继续往下执行，返回 false 就放弃执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        String _token=null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("_YXF_TOKEN_")) {
                    _token = cookie.getValue();
                }
            }
        }

        /**
         * 判断是否登录，没登录直接返回
         */
        if (StringUtils.isBlank(_token) || redisService.get(_token) == null) {
            Result result = Result.failure(1990, "Go log in, access");
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.setCharacterEncoding("UTF-8");
            response.getOutputStream().println(JSON.toJSONString(result));
            return false;
        }

        return true;
    }
}
