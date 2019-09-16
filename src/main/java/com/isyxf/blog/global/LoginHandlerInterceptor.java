package com.isyxf.blog.global;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiaofei.yan
 * @Create 2019-09-16 11:16
 * @Descript 登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

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

        // 判断是否登录
        Object user = request.getSession().getAttribute("currentUser");
        if (user == null) {
            // 未登录，返回登录页面
            return false;
        } else {
            return true;
        }
    }

    /**
     * 该方法将在请求处理之后，DispatcherServlet 进行视图返回渲染之前进行调用，可以在这个方法中对 Controller 处理之后的 ModelAndView 对象进行操作
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
