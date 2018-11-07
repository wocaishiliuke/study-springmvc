package com.baicai.interceptor;

import com.baicai.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证拦截器
 */
public class AuthHandlerInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URI = {"/loginForm", "/login"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthInterceptor preHandle --->");

        boolean flag = false;
        //1.登录请求，则直接放行
        String servletPath = request.getServletPath();
        for (String s : IGNORE_URI) {
            if(servletPath.contains(s)) {
                System.out.println("登录请求，直接放行...");
                flag = true;//放行
                break;
            }
        }
        //2.非登录请求，再判断登录状态
        if (!flag) {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                System.out.println("非登录请求，且未登录，将跳转至登录页...");
                request.setAttribute("message", "请先登录！");
                request.getRequestDispatcher("loginForm").forward(request, response);
            }else {
                System.out.println("非登录请求，已登录，放行...");
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthInterceptor postHandle --->");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AuthInterceptor afterCompletion --->");
    }
}
